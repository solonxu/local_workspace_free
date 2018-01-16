package org.foundation.dml.event.processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.foundation.dml.bean.FeedArrivalBean;
import org.foundation.dml.bean.Registry;
import org.foundation.dml.configuration.PubSubApplication.PubsubOutboundGateway;
import org.foundation.dml.dao.DbDao;
import org.foundation.dml.filepoller.FilePatternChecker;
import org.foundation.dml.util.GSFileUtil;
import org.foundation.dml.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;


public class FileEventProcessor implements EventProcessor   {
   private  final Log log = LogFactory.getLog(this.getClass());

    private String landingBucketName = null;
    private String outgoingBucketName = null;
    private String scrathDirPath = null;
    private DbDao dbDao;
    
    @Autowired 
    private PubsubOutboundGateway messagingGateway;
 
    
    private File scratchDir = null;
  
    public FileEventProcessor(String landingBucketName,String outgoingBucketName,String scrathDirPath,DbDao dbDao) {
 	
    	this.landingBucketName = landingBucketName;
    	this.outgoingBucketName = outgoingBucketName;
    	this.scrathDirPath = scrathDirPath;
    	this.dbDao = dbDao;

    	scratchDir = new File(scrathDirPath);
    	
    	if (!scratchDir.exists()) {
    		if (scratchDir.mkdirs()) {
    			log.info("Succeed to create folder" + this.scrathDirPath);
    		} else {
    			log.error("Failed to create folder" + this.scrathDirPath);
    		}
    	} else {
    		log.info("Scratch path already exist:" + this.scrathDirPath);
    	}
    	
    }
    
    
    public void process(Object event) {
    	String relativePath = (String)event;
    	
        log.info("Going to process event :" + relativePath);
        try {
            //download the file 
    	     File scratchFile = new File(scratchDir,getName(relativePath));
    	     GSFileUtil.download(landingBucketName, relativePath, scratchFile);
    	     log.info(String.format("Downloaded file from bucket[%s],path[%s]",this.landingBucketName ,relativePath));
    	     
    	     //gzip the file
    	     File processedFile = gzip(scratchFile);
    	     log.info(String.format("Gzip file from [%s],to [%s]",scratchFile.getAbsolutePath() ,processedFile.getAbsolutePath()));
        	 
    	     // upload  file 
    	    
    	     FeedArrivalBean feedArrival= createFeedArrivalEntry(relativePath);
    	     
    	     if (feedArrival == null) {
    	    	 log.warn("Skip illegal event:" + relativePath);
    	    	 return ;
    	     }
    	     
    	     String toRelativePath = feedArrival.getSourceName();
    	     
    	     GSFileUtil.upload(processedFile, outgoingBucketName, toRelativePath );
    	     log.info(String.format("Uploaded file to bucket [%s],name [%s]",this.outgoingBucketName ,toRelativePath));

    	     feedArrival.setSourceName("gs://" + this.outgoingBucketName + "/" + toRelativePath);
    	     this.messagingGateway.sendToPubsub(JsonHelper.objectToString(feedArrival));
    	     log.info("successfully send the pubsub to for " + this.outgoingBucketName + toRelativePath);
    	     

    	     //delete the landing bucket file
    	     GSFileUtil.delete(landingBucketName, relativePath );
    	     log.info(String.format("Deleted file to bucket [%s],name [%s]",this.landingBucketName ,relativePath));
          	
    	      
    	     //delete scratch file
    	     scratchFile.delete();
    	     processedFile.delete();
    	     
    	     log.info("Succesfully to process event :" + relativePath);
    	 } catch (Exception e) {
    		 log.error("Failed to process event :" + relativePath,e.getCause());
    	 }
    	
    }
    
    private static String getName(String relativePath) {
    	return StringUtils.substringAfterLast(relativePath, "/");
    }
    
    private static File gzip(File inputFile) throws IOException {
    	FileInputStream in = null;
    	GZIPOutputStream out = null;
        File outputFile = null;
        
    	try {
    		in = new FileInputStream(inputFile);
    		outputFile = new File(inputFile.getAbsolutePath() + ".gz");
    		
    		out = new GZIPOutputStream(new FileOutputStream(outputFile));
    		
    		IOUtils.copy(in, out);
    		
    	} finally {
    		IOUtils.closeQuietly(in);
    		IOUtils.closeQuietly(out);
    	}
    	
    	return outputFile;
    	
    }
    
    private FeedArrivalBean createFeedArrivalEntry(String relativePath) {
    	String[] subs = StringUtils.split(relativePath,"/");
    	
    	String sourceSystem = null;
    	String siteCode = null;
    	String filename = null;
    	
        int sizeOfSub = subs.length;
        
        if (subs.length  >= 3) {
    	   filename  = subs[sizeOfSub-1];
           siteCode = subs[sizeOfSub-2];
           sourceSystem  = subs[sizeOfSub-3];
        } else {
        	return null;
        }
    	
        Registry registry =locateFeedRegistry(sourceSystem,siteCode,filename);
        
        if (registry == null) {
            log.error("No registry is found for source System " + sourceSystem +",siteCode:" + siteCode +",filename:" + filename);
            return null ;
            
        }
        
        
    	//Assert.notNull((sourceSystem);
    	
    	//to-do:try to get from the db if yes
    	
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd-HHmmss");
    	Date now = new Date();
        
    	String newFilename = sdf.format(now) + "_" + filename +"_" + sdf2.format(now) +".gz";
    	String sourceName =  sourceSystem +"/" + siteCode +"/" + registry.getDataType() +"/" + registry.getDataSubType() +"/" + newFilename;
    	
    	
    	FeedArrivalBean arrivalBean = new FeedArrivalBean();
    	arrivalBean.setBatchDate(now);
    	arrivalBean.setSourceSystem(registry.getSourceSystem());
    	arrivalBean.setSite(registry.getSiteCode());;
    	arrivalBean.setDataType(registry.getDataType());
    	arrivalBean.setDataSubtype(registry.getDataSubType());
    	arrivalBean.setSourceName(sourceName);
    	
    	return arrivalBean;
    	
    }
    
    private Registry locateFeedRegistry(String sourceSystem,String siteCode,String filename) {
    	  List<Registry>  registryList = this.dbDao.listRegistry(sourceSystem.toUpperCase(),siteCode);
          
          if (registryList.isEmpty()) {
              return null ;
              
          }
          
          for (Registry registry :  registryList) {
        	   if (FilePatternChecker.isMatch(filename,registry.getFilename())) {
        		   return registry;
        	   }
          }
          
          return null;
    }
    
    
    
    public void setMessagingGateway(PubsubOutboundGateway messagingGateway) {
		this.messagingGateway = messagingGateway;
	}


	public static void main(String arg[]) {
//    	landingBucketName ="sx-183314-bucket";
//    	outgoingBucketName = "outgoing-bucket";
//    	scrathDirPath = "D:\\learning\\gcp\\tmp\\212";
//    	
   
//    	FileProcessor processor = new FileProcessor();
//    	processor.processEvent("landing/scp/LOH/tchan.txt");
    	
    }

}

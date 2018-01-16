package com.maplequad.gbm.grt.om.job;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.beans.factory.annotation.Autowired;

import com.maplequad.gbm.grt.om.ExecuteRequest;
import com.maplequad.gbm.grt.om.Feed;
import com.maplequad.gbm.grt.om.bean.FeedArrivalBean;
import com.maplequad.gbm.grt.om.dao.FeedArrivalDao;
import com.maplequad.gbm.grt.om.ws.service.ExecuteClient;

public class HandleExecutionJob implements StatefulJob{

	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private FeedArrivalDao feedArrivalDao;
	private ExecuteClient executeService;
	
	
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		if (feedArrivalDao == null) {
			log.info("Can't find feedArrivalDao");
		} else {
			//log.info("Got the feed arrival!!! ,try to get the instanceiD" + this.feedArrivalDao.generateSequence());
			
			
			try {
			    List<FeedArrivalBean> feedArrivalList = this.feedArrivalDao.listFeedArrival();
			    
			    for (FeedArrivalBean feedArrival : feedArrivalList) {
			    	process(feedArrival);
			    }
			    
		    } catch(Exception e) {
		    	log.error("Failed to poll the feedArrival ",e);
		    }
			
			
			
			
		}
		log.info("Execute  " + this.getClass().getName());
	}
	
	
	
	
	private void process(FeedArrivalBean feedArrival) {
		try {
			log.info("Procesing feedArrival" + feedArrival.getSourceName());
			ExecuteRequest executeRequest = formExecuteRequest(feedArrival);
			this.executeService.pushExecution(executeRequest);
			
			log.info("Send request for instance Id successfully " + executeRequest.getInstanceId());
			
			
			this.feedArrivalDao.updateFeedArrival(feedArrival.getBusinessDate(), feedArrival.getInstanceId(), "P");
			
		}catch (Exception e) {
			log.error("Failed to process arrivel " + feedArrival.getSourceName() ,e);
		}
	}
	
	public ExecuteRequest formExecuteRequest(FeedArrivalBean feedArrival) {
		ExecuteRequest executeRequest = new ExecuteRequest();
		
		executeRequest.setInstanceId(feedArrivalDao.generateSequence());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		executeRequest.setProcessId("VaR Aggregation.STANDARD1DAY");
		executeRequest.setRunType("VaR Aggregation.var-1d");
		if (feedArrival.getBusinessDate()!= null)  executeRequest.setBusinessDate(sdf.format(feedArrival.getBusinessDate()));
		executeRequest.setApplyLastProcessingDate(false);
		executeRequest.setSite(feedArrival.getSite());
		executeRequest.setSourceSystem(feedArrival.getSourceSystem());
	//	executeRequest.getFeed().add(feed);
		Feed feed =new Feed();
		feed.setCategory("DML");
		feed.setSourceSystem(feedArrival.getSourceSystem());
		feed.setSite(feedArrival.getSite());
		feed.setDataType(feedArrival.getDataType());
		feed.setDataSubType(feedArrival.getDataSubtype());
		if (feedArrival.getBusinessDate()!= null)  feed.setFeedBusinessDate(sdf.format(feedArrival.getBusinessDate()));
	    feed.setOther(feedArrival.getOther());
	    feed.setPart(1);
	    feed.setMaxPart(1);
	    feed.setCalcKey(feedArrival.getCalcKey());
	    feed.setSourceName(feedArrival.getSourceName());
	    feed.setIsReplacement(true);
	    executeRequest.getFeed().add(feed);
	    
	//	feed.set
		return executeRequest;
	}

	public void setFeedArrivalDao(FeedArrivalDao feedArrivalDao) {
		this.feedArrivalDao = feedArrivalDao;
	}




	public void setExecuteService(ExecuteClient executeService) {
		this.executeService = executeService;
	}

 
	
	
	
	
}

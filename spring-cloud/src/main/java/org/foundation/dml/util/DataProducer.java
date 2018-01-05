package org.foundation.dml.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.foundation.dml.mockup.event.CallEvent;
import org.foundation.dml.mockup.event.DataSender;
import org.foundation.dml.mockup.event.FileDataSender;


public class DataProducer {
	
	
	private static List<CallEvent> initialLoad(File file) {
		BufferedReader br = null;
		
		List<CallEvent> list =new ArrayList<CallEvent>();
	    System.out.println("Initial loading read the file:" + file.getPath());  
		
		
		try {
			System.out.println("Initializing the sender...");
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
			
		    String line= null;
			
			while ( (line = br.readLine()) != null) {
				String splits[] = StringUtils.split(line,",");
		 
		        //System.out.println("the location is:" + splits[4]);
		
		        CallEvent event = new CallEvent();
		        event.setId(splits[0]);;
		        event.setLatitude(splits[1]);
		        event.setLongtitude(splits[2]);
		        event.setTime(splits[3]);
		        event.setLocation(splits[4]);
		        list.add(event);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br!= null) {
				try {br.close(); } catch (Exception ignore) {}
			}
		}
		
		return list;
		
	}

	
	private static DataSender initializeSender(File file) {
		DataSender sender = null;
		try {
	      //  sender = new KinesisDataSender();
			//File file = new File("D:\\learning\\hackathon\\demo-source-data\\sample-file1.csv");
			
			sender = new FileDataSender(file);
	   } catch (Exception e) {
		  e.printStackTrace();	
	   }
	
	   return sender;
	}
	
	
	public static void  main(String arg[]) {
	    List<CallEvent>  eventList =  initialLoad(new File(arg[0]));
		
	    File outputFile = new File(arg[1]);
	    
	    DataSender sender =initializeSender(outputFile);
	    if (sender == null) System.exit(1);;
	    
	    long sizeOfMockupFile = 500000000L;
	    if (arg.length > 2) {
	    	sizeOfMockupFile = Long.valueOf(arg[2]);
	    }
	    
	    System.out.println(String.format("Going to mockup file [%s] base on file [%s],size would be [%d]",outputFile.getAbsolutePath(),arg[1],sizeOfMockupFile));
	    
	    int n = 0;;
	    while (true) {
	        System.out.println("***********************Going to generate data for " + (++n) + "th time data");
	    	List<CallEvent> randomEventList = getRandomEventList(eventList,300);;
	        //write the list to kinesis 
	            
	        sendEventListToKinesis(randomEventList,sender);
	        System.out.println("***********************Going to generate data for " + (++n) + "th time data");
	        
	        sleep(10);
	        
	       if (outputFile.length() > sizeOfMockupFile ) {
	    	   break;
	       }
	    
	    }
	    
	    if (sender instanceof FileDataSender) {
	    	//(FileDataSender)sender)
	    	FileDataSender fs = (FileDataSender)sender;
	    	fs.close();
	    }
	
	}
	
   private static void sleep(int seconds) {
	   System.out.println("Going to sleep" + seconds +" seconds");
	   try {
		   Thread.sleep(seconds );
	   }catch (Exception e) {
		   
	   }
	   
   }
	
   private static void sendEventListToKinesis(List<CallEvent> randomEventList,DataSender sender) {
	   
	   for (CallEvent event : randomEventList) {
	     //  System.out.println(String.format("Got the event[id:%s,timestamp:%s,location:%s" ,event.getId(),event.getTime(),event.getLocation()));;
           sender.sendSingleRecordToStream(event);
	   }
   }
	
	

	
	private static List<CallEvent> getRandomEventList( List<CallEvent> eventList,int number) {
		Random rand = new Random();
		
		List<CallEvent> retList = new ArrayList<CallEvent>();
		
		while (true) {
		   int  n = rand.nextInt(eventList.size());
		   System.out.println(eventList.get(n).getId());
		   retList.add(eventList.get(n));
		   
		   if (retList.size() >= number) break;
		}
		
		
		return retList;
	}

}

package org.foundation.dml.configuration;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.foundation.dml.util.GSFileUtil;

public class MultiThreadFileUploader {
	private static Log log = LogFactory.getLog(MultiThreadFileUploader.class);
	
	
	public static void main(String arg[]) {
		String destBucket = arg[0];
		int noOfThreadInParallel = Integer.valueOf(arg[1]);
		
		int writeInterval = 3 * 1000; //3s
		
		if (arg.length > 2) {
			writeInterval  = Integer.valueOf(arg[2]);
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(noOfThreadInParallel);
		
		
		for (int i=0;i<noOfThreadInParallel;i++) {
		     executor.submit(new WorkThread(log,destBucket,i+1,writeInterval));
		}
		
		
		executor.shutdown();
		
		try {
		    while (!executor.isTerminated()) {
			
		     }

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("the executor is stopped!");
		
	}

}
class WorkThread extends Thread {
    private int index;
    private String destBucket;
    private int sleepInterval;
    private Log log ;
    
    public WorkThread(Log log ,String destBucket,int index,int sleepInterval)  {
        this.destBucket = destBucket;
        this.index = index;
        this.sleepInterval = sleepInterval;
        Thread.currentThread().setName("Thread-" + index);
        this .log= log;
     
    }
    @Override
    public void run() {
        log.info("Thread-" + Thread.currentThread().getId() + " start");
        processCommand();
        log.info("Thread-" + Thread.currentThread().getId() + " end.");
    }
    private void processCommand() {
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyyyMMdd-HHmmss-SSS");
        	
        	String destFileName = "upload-" + index +"-"+sdf.format(new Date());
        				
        	GSFileUtil.upload(new File("D:\\learning\\gcp\\tmp\\tchan.txt"),destBucket,destFileName);
        	log.info(String.format("Thread[%s] Deliver file %s",Thread.currentThread().getName(),destFileName));
        				
       // 	log.info(String.format("Thread[%s] is going to sleep %d", Thread.currentThread().getName(),this.sleepInterval));	
        //    Thread.sleep(1000);
        } catch (Exception e) {
        	log.error("Failed to upload the file",e.getCause());;
        }
    }
}
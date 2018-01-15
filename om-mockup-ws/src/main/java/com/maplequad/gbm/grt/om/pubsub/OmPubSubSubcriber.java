package com.maplequad.gbm.grt.om.pubsub;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.SubscriptionName;
import com.maplequad.gbm.grt.om.Feed;
import com.maplequad.gbm.grt.om.bean.DataLoadRequestBean;
import com.maplequad.gbm.grt.om.bean.FeedArrivalBean;
import com.maplequad.gbm.grt.om.dao.FeedArrivalDao;
import com.maplequad.gbm.grt.om.util.JsonHelper;
import com.maplequad.gbm.grt.om.ws.service.FeedNotificationClient;

public class OmPubSubSubcriber {
	private static Log LOG = LogFactory.getLog(OmPubSubSubcriber.class);
	
	private String subscriptionId;
	private FeedArrivalDao feedArrivalDao;
	private String url;
	
	
    public void createSubscriber() throws Exception {
		String projectId = ServiceOptions.getDefaultProjectId();
		LOG.info("Listening to subscriber : " + this.subscriptionId);
	    SubscriptionName subscriptionName = SubscriptionName.of(projectId, subscriptionId);
		MessageReceiver receiver =
		     new MessageReceiver() {
		          @Override
		          public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
		            // handle incoming message, then ack/nack the received message
		        //    System.out.println("Id : " + message.getMessageId());
		           LOG.info("Data : " + message.getData().toStringUtf8());
		            consumer.ack();
		             
		            try {
		            	LOG.info("Going to process this data");
		                FeedArrivalBean feedArrivalBean = JsonHelper.jsonToFeedArrival(message.getData().toStringUtf8());
		                System.out.println("get the batchDate:" + feedArrivalBean.getBatchDate() +",the sourcename :" + feedArrivalBean.getSourceName());
		                DataLoadRequestBean dlBean  = formDataloadRequestBean(feedArrivalBean);
		                LOG.info("Create the request bean" + dlBean.getProcessId());;
		                FeedNotificationClient.sendNotificationRequest(url, dlBean);
		            } catch (Exception e ) {
		            	e.printStackTrace();
		            }  
		          }
		};

	    Subscriber subscriber = null;
		
	    try {
		      // Create a subscriber for "my-subscription-id" bound to the message receiver
		      subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
		      subscriber.startAsync();
		      subscriber.addListener(
		    		    new Subscriber.Listener() {
		    		      public void failed(Subscriber.State from, Throwable failure) {
		    		        // Handle error.
		    		    	  failure.printStackTrace();
		    		      }
		    		    },
		    		    MoreExecutors.directExecutor());
		      LOG.info("Listening to subsribe" + this.subscriptionId +"...");
		  } finally {
		      // stop receiving messages
		      if (subscriber != null) {
		        subscriber.awaitTerminated();
		   //     System.out.println(arg0);
		      }
		    }
		    // [END pubsub_pull]
	 }
	 
	 
	 
	 private DataLoadRequestBean formDataloadRequestBean(FeedArrivalBean feedArrival) {
	    	  DataLoadRequestBean dataloadRequestBean = new DataLoadRequestBean();
	     long instanceId = feedArrivalDao.generateSequence();
	     LOG.info("Got instance id " + instanceId);
	   	   dataloadRequestBean.setInstanceId(instanceId);
	   	   dataloadRequestBean.setProcessId("VaR Aggregation.loadData_var-1d");
	   	   Feed feed = new Feed();
	   	   feed.setCategory("DML");
	   	   feed.setSourceSystem(feedArrival.getSourceSystem());
	   	   feed.setSite(feedArrival.getSite());
	   	   feed.setDataType(feedArrival.getDataType());
	   	   feed.setDataSubType(feedArrival.getDataSubtype());
	   	   feed.setIncrementalFeed(true);
	   	   feed.setAdjustmentFeed(false);
	   	   feed.setSourceName(feedArrival.getSourceName());
	   	   feed.setPart(1);
	   	   feed.setMaxPart(1);
	   	   feed.setOther("STANDARD1DAY");
	   	   feed.setCalcKey("7412727");
	   	   feed.setIsReplacement(true);
	   	   
	   	   List<Feed> feeds = new ArrayList<Feed>();
	   	   feeds.add(feed);
	   	   
	   	   dataloadRequestBean.setFeeds(feeds);
	   	   
	   	   
	   	   return dataloadRequestBean;
	   	   
	    	
	    }



	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}



	public void setFeedArrivalDao(FeedArrivalDao feedArrivalDao) {
		this.feedArrivalDao = feedArrivalDao;
	}



	public void setUrl(String url) {
		this.url = url;
	}
	 
	
	
	    
	 

}

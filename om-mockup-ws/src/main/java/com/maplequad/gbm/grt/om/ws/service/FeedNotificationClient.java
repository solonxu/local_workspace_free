package com.maplequad.gbm.grt.om.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.maplequad.gbm.grt.om.Feed;
import com.maplequad.gbm.grt.om.FeedNotificationRequest;
import com.maplequad.gbm.grt.om.FeedNotificationResponse;
import com.maplequad.gbm.grt.om.IFeedNotification;
import com.maplequad.gbm.grt.om.bean.DataLoadRequestBean;


public class FeedNotificationClient {
   private static Log LOG = LogFactory.getLog(FeedNotificationClient.class);
	
   public static void sendNotificationRequest(String url,DataLoadRequestBean dataloadRequestBean) {
		IFeedNotification  service = createService(url);
		FeedNotificationRequest feedNotificationRequest = assemble(dataloadRequestBean);
		 
		FeedNotificationResponse response = service.feedNotificationWrapperRequest(feedNotificationRequest);
		LOG.info("Got the response:" + response.getReasonCode());
   }
   
   private static FeedNotificationRequest assemble(DataLoadRequestBean dataloadRequestBean) {
		FeedNotificationRequest feedNotificationRequest = new FeedNotificationRequest();
		feedNotificationRequest.setProcessId(dataloadRequestBean.getProcessId());
		feedNotificationRequest.setInstanceId(dataloadRequestBean.getInstanceId());
		feedNotificationRequest.getFeed().addAll(dataloadRequestBean.getFeeds());
		
		return feedNotificationRequest;
	
   }
   
   
   private static IFeedNotification  createService(String url) {
	   JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
		proxyFactoryBean.setAddress(url);
		proxyFactoryBean.setServiceClass(IFeedNotification.class);
		IFeedNotification service = (IFeedNotification)proxyFactoryBean.create();
	
		return service;
		
   }
	
 
	public static void main(String arg[]) {
	
	   DataLoadRequestBean dataloadRequestBean = new DataLoadRequestBean();
	   dataloadRequestBean.setInstanceId(7412729L);
	   dataloadRequestBean.setProcessId("VaR Aggregation.loadData_var-1d");
	   Feed feed = new Feed();
	   feed.setCategory("DML");
	   feed.setSourceName("RAVENAA");
	   feed.setRegion("AP");
	   feed.setSite("HMR");
	   feed.setDataType("val_data");
	   feed.setDataSubType("xfos_pnl_var_1d");
	   feed.setIncrementalFeed(true);
	   feed.setAdjustmentFeed(false);
	   feed.setSourceName("gs://va-test/20171214_ABC_var-1d_20170101_system-sensitivity_EOD-66858-1-1.csv.zip.gz");
	   feed.setPart(1);
	   feed.setMaxPart(1);
	   feed.setOther("STANDARD1DAY");
	   feed.setCalcKey("7412727");
	   feed.setIsReplacement(true);
	   
	   List<Feed> feeds = new ArrayList<Feed>();
	   feeds.add(feed);
	   
	   dataloadRequestBean.setFeeds(feeds);
	   
	   	
	   
	   sendNotificationRequest("http://35.187.82.167:8080/sra-service/FeedNotification?wsdl",dataloadRequestBean);
	}
	

}

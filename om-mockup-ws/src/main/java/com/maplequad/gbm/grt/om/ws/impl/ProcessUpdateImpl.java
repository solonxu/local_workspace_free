package com.maplequad.gbm.grt.om.ws.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.maplequad.gbm.grt.om.client.Feed;
import com.maplequad.gbm.grt.om.dao.FeedArrivalDao;
import com.maplequad.gbm.grt.om.ws.IProcessUpdate;
import com.maplequad.gbm.grt.om.ws.bean.request.ProcessUpdateRequestBean;
import com.maplequad.gbm.grt.om.ws.bean.response.ProcessUpdateResponseBean;

@WebService(endpointInterface="com.maplequad.gbm.grt.om.ws.IProcessUpdate")
public class ProcessUpdateImpl implements IProcessUpdate {
	private Log log = LogFactory.getLog(this.getClass());
	
	private FeedArrivalDao feedArrivalDao;
	

	public ProcessUpdateResponseBean updateProcessStatus(ProcessUpdateRequestBean reqBean) {
		log.info("Got msg for the process Id " + reqBean.getProcessId() + " and instance Id:" + reqBean.getInstanceId());
		
		if (reqBean.getProcessId().contains("loadData")) {
			return handleDataLoad(reqBean);
		} 
		
		return handleExecute(reqBean);
	}
	
	
	public ProcessUpdateResponseBean handleExecute(ProcessUpdateRequestBean reqBean) {
		log.info("Handle execution update  for instance id +" +reqBean.getInstanceId());
		
		
		ProcessUpdateResponseBean response = new ProcessUpdateResponseBean();
		
		try {
		    feedArrivalDao.updateFeedArrival(getBusinessDate(), reqBean.getInstanceId(), "C");

		    response.setReasonCode("OK");
		    response.setReasonText("Update execution successfully for instance id :" + reqBean.getInstanceId());
		    response.setReasonCode("COMPLETED");
		} catch (Exception e) {
		    response.setReasonCode("FAIL");
		    response.setReasonText("FAIL to update execution for instance id :" + reqBean.getInstanceId());
		    response.setReasonCode("FAIL");
		}
		
		return response;
	}
	
	
	
	
	
	public ProcessUpdateResponseBean handleDataLoad(ProcessUpdateRequestBean reqBean) {
		//long instanceId = reqBean.getInstanceId();
		//reqBean.getBusinessDate();
		log.info("Handle data load for instance id +" +reqBean.getInstanceId());
		
		List<Feed> outputFeeds = reqBean.getOutputFeeds();
		
		if (outputFeeds != null) {
			for (Feed feed : outputFeeds) {
			   log.info("\t Feed :" + feed.getCategory() +",instanceId:" + feed.getDataLoadInstanceID() 
			    +",the business date is "  + feed.getFeedBusinessDate());
			}
		} else {
			log.info("No feeds got");
		}
		
		
		feedArrivalDao.updateFeedArrival(getBusinessDate(), reqBean.getInstanceId(), "D");
		
		log.info("Update instance Id " + reqBean.getInstanceId() + " successfully!");

		ProcessUpdateResponseBean response = new ProcessUpdateResponseBean();
		response.setReasonCode("OK");
		response.setReasonText("Got " + (outputFeeds == null ? 0 : outputFeeds.size()) +" feeds");
		response.setReasonCode("COMPLETED");
		
		return response;

	}
	
	private Date getBusinessDate() {
	    Date date = null;
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    
		try {
			date = sdf.parse("20170829");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return date;
	}


	public void setFeedArrivalDao(FeedArrivalDao feedArrivalDao) {
		this.feedArrivalDao = feedArrivalDao;
	}
	
	
	

}

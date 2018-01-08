package com.maplequad.gbm.grt.om.ws.impl;

import java.util.List;

import javax.jws.WebService;

import com.maplequad.gbm.grt.om.client.Feed;
import com.maplequad.gbm.grt.om.ws.IProcessUpdate;
import com.maplequad.gbm.grt.om.ws.bean.request.ProcessUpdateRequestBean;
import com.maplequad.gbm.grt.om.ws.bean.response.ProcessUpdateResponseBean;

@WebService(endpointInterface="com.maplequad.gbm.grt.om.ws.IProcessUpdate")
public class ProcessUpdateImpl implements IProcessUpdate {
	

	public ProcessUpdateResponseBean updateProcessStatus(ProcessUpdateRequestBean reqBean) {
		
		System.out.println("Server :" +reqBean.getBusinessDate());
	    
		List<Feed> outputFeeds = reqBean.getOutputFeeds();
		
		if (outputFeeds != null) {
			for (Feed feed : outputFeeds) {
			    System.out.println("\t Feed :" + feed.getCategory() +",instanceId:" + feed.getDataLoadInstanceId());
			}
		} else {
			System.out.println("No feeds got");
		}
		

		ProcessUpdateResponseBean response = new ProcessUpdateResponseBean();
		response.setReasonCode("OK");
		response.setReasonText("Got " + (outputFeeds == null ? 0 : outputFeeds.size()) +" feeds");
		response.setReasonCode("COMPLETED");
		
		return response;
	}
	
	

}

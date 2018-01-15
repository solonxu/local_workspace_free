package com.maplequad.gbm.grt.om.bean;

import java.util.List;

import com.maplequad.gbm.grt.om.Feed;

public class DataLoadRequestBean {
	
	private Long instanceId;
	private String processId;
	
	private List<Feed> feeds;

	public Long getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(Long instanceId) {
		this.instanceId = instanceId;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public List<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}
	
	

	

}

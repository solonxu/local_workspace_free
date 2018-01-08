package com.maplequad.gbm.grt.om.ws.bean.request;

import java.util.List;

import com.maplequad.gbm.grt.om.client.Feed;

public class ProcessUpdateRequestBean {
	
	private Long instanceId;
	private String processId;
	private String status;
	private String statusReasonCode;
	private String statusReasonText;
    private String description;
    private String businessDate;
    private List<Feed> outputFeeds;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusReasonCode() {
		return statusReasonCode;
	}
	public void setStatusReasonCode(String statusReasonCode) {
		this.statusReasonCode = statusReasonCode;
	}
	public String getStatusReasonText() {
		return statusReasonText;
	}
	public void setStatusReasonText(String statusReasonText) {
		this.statusReasonText = statusReasonText;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}
	public List<Feed> getOutputFeeds() {
		return outputFeeds;
	}
	public void setOutputFeeds(List<Feed> outputFeeds) {
		this.outputFeeds = outputFeeds;
	}
    
    
    

}

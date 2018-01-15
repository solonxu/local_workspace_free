package com.maplequad.gbm.grt.om.bean;

import java.util.Date;

public class FeedArrivalBean {
	
	private String sourceSystem;
	private String site;
	private String dataType;
	private String dataSubtype;
	private String sourceName;
	private Date batchDate;
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDataSubtype() {
		return dataSubtype;
	}
	public void setDataSubtype(String dataSubtype) {
		this.dataSubtype = dataSubtype;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public Date getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(Date batchDate) {
		this.batchDate = batchDate;
	}
	
	
	
	

}

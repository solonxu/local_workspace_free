package com.maplequad.gbm.grt.om.client;

import javax.xml.datatype.XMLGregorianCalendar;

public class Feed {
	protected String category;
	protected String dataLoadInstanceID;
	protected String sourceSystem;
	protected Long partitionId;
	protected String region;
	protected String site;
	protected String dataType;
	protected String dataSubType;
	protected String feedBusinessDate;
	protected boolean incrementalFeed;
	protected boolean adjustmentFeed;
	protected boolean sourceName;
	protected String retrievalKey;
	protected XMLGregorianCalendar fromDateTime;
	protected XMLGregorianCalendar untilDateTime;

	protected int part;
	protected int maxPart;
	protected String other;
	protected String owner;
	protected Long calcKey;
	protected Boolean isReplacement;
	private Object[] any;
	
	
	
	

	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDataLoadInstanceID() {
		return dataLoadInstanceID;
	}
	public void setDataLoadInstanceID(String dataLoadInstanceID) {
		this.dataLoadInstanceID = dataLoadInstanceID;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public Long getPartitionId() {
		return partitionId;
	}
	public void setPartitionId(Long partitionId) {
		this.partitionId = partitionId;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
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
	public String getDataSubType() {
		return dataSubType;
	}
	public void setDataSubType(String dataSubType) {
		this.dataSubType = dataSubType;
	}
	public String getFeedBusinessDate() {
		return feedBusinessDate;
	}
	public void setFeedBusinessDate(String feedBusinessDate) {
		this.feedBusinessDate = feedBusinessDate;
	}
	public boolean isIncrementalFeed() {
		return incrementalFeed;
	}
	public void setIncrementalFeed(boolean incrementalFeed) {
		this.incrementalFeed = incrementalFeed;
	}
	public boolean isAdjustmentFeed() {
		return adjustmentFeed;
	}
	public void setAdjustmentFeed(boolean adjustmentFeed) {
		this.adjustmentFeed = adjustmentFeed;
	}
	public boolean isSourceName() {
		return sourceName;
	}
	public void setSourceName(boolean sourceName) {
		this.sourceName = sourceName;
	}
	public String getRetrievalKey() {
		return retrievalKey;
	}
	public void setRetrievalKey(String retrievalKey) {
		this.retrievalKey = retrievalKey;
	}
	public XMLGregorianCalendar getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(XMLGregorianCalendar fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public XMLGregorianCalendar getUntilDateTime() {
		return untilDateTime;
	}
	public void setUntilDateTime(XMLGregorianCalendar untilDateTime) {
		this.untilDateTime = untilDateTime;
	}
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	public int getMaxPart() {
		return maxPart;
	}
	public void setMaxPart(int maxPart) {
		this.maxPart = maxPart;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Long getCalcKey() {
		return calcKey;
	}
	public void setCalcKey(Long calKey) {
		this.calcKey = calKey;
	}
	public Boolean getIsReplacement() {
		return isReplacement;
	}
	public void setIsReplacement(Boolean isReplacement) {
		this.isReplacement = isReplacement;
	}
	public Object[] getAny() {
		return any;
	}
	public void setAny(Object[] any) {
		this.any = any;
	}
	
	
	
	

}

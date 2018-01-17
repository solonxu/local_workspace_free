package com.maplequad.gbm.grt.om.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feed", propOrder = {
    "category",
    "sourceSystem",
    "partitionId",
    "site",
    "region",
    "dataType",
    "dataSubType",
    "feedBusinessDate",
    "incrementalFeed",
    "isReplacement",
    "adjustmentFeed",
    "sourceName",
    "retrievalKey",
    "fromDateTime",
    "untilDateTime",
    "part",
    "maxPart",
    "other",
    "calcKey",
    "owner",
    "dataLoadInstanceID",
    "any"
})
public class Feed {
	   @XmlElement(name = "Category", required = true)
	    protected String category;
	    @XmlElement(name = "SourceSystem", required = true)
	    protected String sourceSystem;
	    @XmlElement(name = "PartitionId")
	    protected Long partitionId;
	    @XmlElement(name = "Site", required = true)
	    protected String site;
	    @XmlElement(name = "Region", required = true)
	    protected String region;
	    @XmlElement(name = "DataType", required = true)
	    protected String dataType;
	    @XmlElement(name = "DataSubType", required = true)
	    protected String dataSubType;
	    @XmlElement(name = "FeedBusinessDate", required = true)
	    protected String feedBusinessDate;
	    @XmlElement(name = "IncrementalFeed")
	    protected boolean incrementalFeed;
	    @XmlElement(name = "IsReplacement")
	    protected boolean isReplacement;
	    @XmlElement(name = "AdjustmentFeed")
	    protected boolean adjustmentFeed;
	    @XmlElement(name = "SourceName")
	    protected String sourceName;
	    @XmlElement(name = "RetrievalKey")
	    protected String retrievalKey;
	    @XmlElement(name = "FromDateTime")
	    @XmlSchemaType(name = "dateTime")
	    protected XMLGregorianCalendar fromDateTime;
	    @XmlElement(name = "UntilDateTime")
	    @XmlSchemaType(name = "dateTime")
	    protected XMLGregorianCalendar untilDateTime;
	    @XmlElement(name = "Part")
	    protected int part;
	    @XmlElement(name = "MaxPart")
	    protected int maxPart;
	    @XmlElement(name = "Other")
	    protected String other;
	    @XmlElement(name = "CalcKey")
	    protected String calcKey;

	    @XmlElement(name = "DataLoadInstanceID")
		protected String dataLoadInstanceID;
	    
	//    @XmlAnyElement( lax = true)
	    private Object[] any;
	
	    @XmlElement(name = "Owner")
	    protected String owner;

	
	

	
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
	public String getSourceName() {
		return this.sourceName;
	}
	public void setSourceName(String sourceName) {
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
	public String getCalcKey() {
		return calcKey;
	}
	public void setCalcKey(String calKey) {
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

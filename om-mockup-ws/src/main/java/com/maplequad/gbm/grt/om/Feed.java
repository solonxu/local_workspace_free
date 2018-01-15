
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>feed complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="feed"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Category" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="SourceSystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PartitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="Site" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Region" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DataType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DataSubType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FeedBusinessDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IncrementalFeed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="IsReplacement" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="AdjustmentFeed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="SourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RetrievalKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FromDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="UntilDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="Part" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="MaxPart" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Other" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CalcKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
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
    "calcKey"
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

    /**
     * 获取category属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置category属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * 获取sourceSystem属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * 设置sourceSystem属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystem(String value) {
        this.sourceSystem = value;
    }

    /**
     * 获取partitionId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPartitionId() {
        return partitionId;
    }

    /**
     * 设置partitionId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPartitionId(Long value) {
        this.partitionId = value;
    }

    /**
     * 获取site属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSite() {
        return site;
    }

    /**
     * 设置site属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSite(String value) {
        this.site = value;
    }

    /**
     * 获取region属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置region属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * 获取dataType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 设置dataType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

    /**
     * 获取dataSubType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSubType() {
        return dataSubType;
    }

    /**
     * 设置dataSubType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSubType(String value) {
        this.dataSubType = value;
    }

    /**
     * 获取feedBusinessDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedBusinessDate() {
        return feedBusinessDate;
    }

    /**
     * 设置feedBusinessDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedBusinessDate(String value) {
        this.feedBusinessDate = value;
    }

    /**
     * 获取incrementalFeed属性的值。
     * 
     */
    public boolean isIncrementalFeed() {
        return incrementalFeed;
    }

    /**
     * 设置incrementalFeed属性的值。
     * 
     */
    public void setIncrementalFeed(boolean value) {
        this.incrementalFeed = value;
    }

    /**
     * 获取isReplacement属性的值。
     * 
     */
    public boolean isIsReplacement() {
        return isReplacement;
    }

    /**
     * 设置isReplacement属性的值。
     * 
     */
    public void setIsReplacement(boolean value) {
        this.isReplacement = value;
    }

    /**
     * 获取adjustmentFeed属性的值。
     * 
     */
    public boolean isAdjustmentFeed() {
        return adjustmentFeed;
    }

    /**
     * 设置adjustmentFeed属性的值。
     * 
     */
    public void setAdjustmentFeed(boolean value) {
        this.adjustmentFeed = value;
    }

    /**
     * 获取sourceName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * 设置sourceName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceName(String value) {
        this.sourceName = value;
    }

    /**
     * 获取retrievalKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetrievalKey() {
        return retrievalKey;
    }

    /**
     * 设置retrievalKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetrievalKey(String value) {
        this.retrievalKey = value;
    }

    /**
     * 获取fromDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFromDateTime() {
        return fromDateTime;
    }

    /**
     * 设置fromDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromDateTime(XMLGregorianCalendar value) {
        this.fromDateTime = value;
    }

    /**
     * 获取untilDateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUntilDateTime() {
        return untilDateTime;
    }

    /**
     * 设置untilDateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUntilDateTime(XMLGregorianCalendar value) {
        this.untilDateTime = value;
    }

    /**
     * 获取part属性的值。
     * 
     */
    public int getPart() {
        return part;
    }

    /**
     * 设置part属性的值。
     * 
     */
    public void setPart(int value) {
        this.part = value;
    }

    /**
     * 获取maxPart属性的值。
     * 
     */
    public int getMaxPart() {
        return maxPart;
    }

    /**
     * 设置maxPart属性的值。
     * 
     */
    public void setMaxPart(int value) {
        this.maxPart = value;
    }

    /**
     * 获取other属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOther() {
        return other;
    }

    /**
     * 设置other属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOther(String value) {
        this.other = value;
    }

    /**
     * 获取calcKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalcKey() {
        return calcKey;
    }

    /**
     * 设置calcKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalcKey(String value) {
        this.calcKey = value;
    }

}

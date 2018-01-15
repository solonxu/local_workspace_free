
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>feed complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡcategory���Ե�ֵ��
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
     * ����category���Ե�ֵ��
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
     * ��ȡsourceSystem���Ե�ֵ��
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
     * ����sourceSystem���Ե�ֵ��
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
     * ��ȡpartitionId���Ե�ֵ��
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
     * ����partitionId���Ե�ֵ��
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
     * ��ȡsite���Ե�ֵ��
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
     * ����site���Ե�ֵ��
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
     * ��ȡregion���Ե�ֵ��
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
     * ����region���Ե�ֵ��
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
     * ��ȡdataType���Ե�ֵ��
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
     * ����dataType���Ե�ֵ��
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
     * ��ȡdataSubType���Ե�ֵ��
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
     * ����dataSubType���Ե�ֵ��
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
     * ��ȡfeedBusinessDate���Ե�ֵ��
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
     * ����feedBusinessDate���Ե�ֵ��
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
     * ��ȡincrementalFeed���Ե�ֵ��
     * 
     */
    public boolean isIncrementalFeed() {
        return incrementalFeed;
    }

    /**
     * ����incrementalFeed���Ե�ֵ��
     * 
     */
    public void setIncrementalFeed(boolean value) {
        this.incrementalFeed = value;
    }

    /**
     * ��ȡisReplacement���Ե�ֵ��
     * 
     */
    public boolean isIsReplacement() {
        return isReplacement;
    }

    /**
     * ����isReplacement���Ե�ֵ��
     * 
     */
    public void setIsReplacement(boolean value) {
        this.isReplacement = value;
    }

    /**
     * ��ȡadjustmentFeed���Ե�ֵ��
     * 
     */
    public boolean isAdjustmentFeed() {
        return adjustmentFeed;
    }

    /**
     * ����adjustmentFeed���Ե�ֵ��
     * 
     */
    public void setAdjustmentFeed(boolean value) {
        this.adjustmentFeed = value;
    }

    /**
     * ��ȡsourceName���Ե�ֵ��
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
     * ����sourceName���Ե�ֵ��
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
     * ��ȡretrievalKey���Ե�ֵ��
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
     * ����retrievalKey���Ե�ֵ��
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
     * ��ȡfromDateTime���Ե�ֵ��
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
     * ����fromDateTime���Ե�ֵ��
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
     * ��ȡuntilDateTime���Ե�ֵ��
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
     * ����untilDateTime���Ե�ֵ��
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
     * ��ȡpart���Ե�ֵ��
     * 
     */
    public int getPart() {
        return part;
    }

    /**
     * ����part���Ե�ֵ��
     * 
     */
    public void setPart(int value) {
        this.part = value;
    }

    /**
     * ��ȡmaxPart���Ե�ֵ��
     * 
     */
    public int getMaxPart() {
        return maxPart;
    }

    /**
     * ����maxPart���Ե�ֵ��
     * 
     */
    public void setMaxPart(int value) {
        this.maxPart = value;
    }

    /**
     * ��ȡother���Ե�ֵ��
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
     * ����other���Ե�ֵ��
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
     * ��ȡcalcKey���Ե�ֵ��
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
     * ����calcKey���Ե�ֵ��
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

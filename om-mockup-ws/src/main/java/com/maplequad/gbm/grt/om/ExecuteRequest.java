
package com.maplequad.gbm.grt.om;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>executeRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="executeRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.maplequad.com/gbm/grt/om}requestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RunType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BusinessDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ApplyLastProcessingDate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ManualRun" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="SourceSystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Site" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Feed" type="{http://www.maplequad.com/gbm/grt/om}feed" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RefInstanceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeRequest", propOrder = {
    "runType",
    "businessDate",
    "applyLastProcessingDate",
    "manualRun",
    "sourceSystem",
    "region",
    "site",
    "feed",
    "refInstanceId"
})
public class ExecuteRequest
    extends RequestBase
{

    @XmlElement(name = "RunType", required = true)
    protected String runType;
    @XmlElement(name = "BusinessDate", required = true)
    protected String businessDate;
    @XmlElement(name = "ApplyLastProcessingDate")
    protected Boolean applyLastProcessingDate;
    @XmlElement(name = "ManualRun")
    protected Boolean manualRun;
    @XmlElement(name = "SourceSystem", required = true)
    protected String sourceSystem;
    @XmlElement(name = "Region")
    protected String region;
    @XmlElement(name = "Site")
    protected String site;
    @XmlElement(name = "Feed")
    protected List<Feed> feed;
    @XmlElement(name = "RefInstanceId")
    protected Long refInstanceId;

    /**
     * 获取runType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRunType() {
        return runType;
    }

    /**
     * 设置runType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunType(String value) {
        this.runType = value;
    }

    /**
     * 获取businessDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessDate() {
        return businessDate;
    }

    /**
     * 设置businessDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessDate(String value) {
        this.businessDate = value;
    }

    /**
     * 获取applyLastProcessingDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isApplyLastProcessingDate() {
        return applyLastProcessingDate;
    }

    /**
     * 设置applyLastProcessingDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setApplyLastProcessingDate(Boolean value) {
        this.applyLastProcessingDate = value;
    }

    /**
     * 获取manualRun属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isManualRun() {
        return manualRun;
    }

    /**
     * 设置manualRun属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setManualRun(Boolean value) {
        this.manualRun = value;
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
     * Gets the value of the feed property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feed property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeed().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Feed }
     * 
     * 
     */
    public List<Feed> getFeed() {
        if (feed == null) {
            feed = new ArrayList<Feed>();
        }
        return this.feed;
    }

    /**
     * 获取refInstanceId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRefInstanceId() {
        return refInstanceId;
    }

    /**
     * 设置refInstanceId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRefInstanceId(Long value) {
        this.refInstanceId = value;
    }

}

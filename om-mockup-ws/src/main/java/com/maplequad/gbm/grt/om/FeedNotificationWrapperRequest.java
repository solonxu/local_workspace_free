
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>feedNotificationWrapperRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="feedNotificationWrapperRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FeedNotificationRequest" type="{http://www.maplequad.com/gbm/grt/om}feedNotificationRequest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feedNotificationWrapperRequest", propOrder = {
    "feedNotificationRequest"
})
public class FeedNotificationWrapperRequest {

    @XmlElement(name = "FeedNotificationRequest")
    protected FeedNotificationRequest feedNotificationRequest;

    /**
     * 获取feedNotificationRequest属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FeedNotificationRequest }
     *     
     */
    public FeedNotificationRequest getFeedNotificationRequest() {
        return feedNotificationRequest;
    }

    /**
     * 设置feedNotificationRequest属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FeedNotificationRequest }
     *     
     */
    public void setFeedNotificationRequest(FeedNotificationRequest value) {
        this.feedNotificationRequest = value;
    }

}

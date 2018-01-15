
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>feedNotificationWrapperRequestResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="feedNotificationWrapperRequestResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FeedNotificationResponse" type="{http://www.maplequad.com/gbm/grt/om}feedNotificationResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feedNotificationWrapperRequestResponse", propOrder = {
    "feedNotificationResponse"
})
public class FeedNotificationWrapperRequestResponse {

    @XmlElement(name = "FeedNotificationResponse")
    protected FeedNotificationResponse feedNotificationResponse;

    /**
     * 获取feedNotificationResponse属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FeedNotificationResponse }
     *     
     */
    public FeedNotificationResponse getFeedNotificationResponse() {
        return feedNotificationResponse;
    }

    /**
     * 设置feedNotificationResponse属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FeedNotificationResponse }
     *     
     */
    public void setFeedNotificationResponse(FeedNotificationResponse value) {
        this.feedNotificationResponse = value;
    }

}

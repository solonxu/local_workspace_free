
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>feedNotificationWrapperRequestResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡfeedNotificationResponse���Ե�ֵ��
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
     * ����feedNotificationResponse���Ե�ֵ��
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

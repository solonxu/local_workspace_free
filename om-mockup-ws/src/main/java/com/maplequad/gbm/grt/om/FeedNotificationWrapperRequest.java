
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>feedNotificationWrapperRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡfeedNotificationRequest���Ե�ֵ��
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
     * ����feedNotificationRequest���Ե�ֵ��
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

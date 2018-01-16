
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feedNotificationWrapperRequestResponse", propOrder = {
    "feedNotificationResponse"
})
public class FeedNotificationWrapperRequestResponse {

    @XmlElement(name = "FeedNotificationResponse")
    protected FeedNotificationResponse feedNotificationResponse;

 
    public FeedNotificationResponse getFeedNotificationResponse() {
        return feedNotificationResponse;
    }

    public void setFeedNotificationResponse(FeedNotificationResponse value) {
        this.feedNotificationResponse = value;
    }

}


package com.maplequad.gbm.grt.om;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feedNotificationRequest", propOrder = {
    "feed"
})
public class FeedNotificationRequest
    extends RequestBase
{

    @XmlElement(name = "Feed")
    protected List<Feed> feed;

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

}

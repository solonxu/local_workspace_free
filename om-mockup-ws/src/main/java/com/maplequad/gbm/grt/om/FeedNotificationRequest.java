
package com.maplequad.gbm.grt.om;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>feedNotificationRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="feedNotificationRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.maplequad.com/gbm/grt/om}requestBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Feed" type="{http://www.maplequad.com/gbm/grt/om}feed" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
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

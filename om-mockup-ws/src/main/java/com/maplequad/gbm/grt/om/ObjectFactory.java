
package com.maplequad.gbm.grt.om;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.maplequad.gbm.grt.om package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FeedNotificationWrapperRequest_QNAME = new QName("http://www.maplequad.com/gbm/grt/om", "feedNotificationWrapperRequest");
    private final static QName _FeedNotificationWrapperRequestResponse_QNAME = new QName("http://www.maplequad.com/gbm/grt/om", "feedNotificationWrapperRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.maplequad.gbm.grt.om
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FeedNotificationWrapperRequest }
     * 
     */
    public FeedNotificationWrapperRequest createFeedNotificationWrapperRequest() {
        return new FeedNotificationWrapperRequest();
    }

    /**
     * Create an instance of {@link FeedNotificationWrapperRequestResponse }
     * 
     */
    public FeedNotificationWrapperRequestResponse createFeedNotificationWrapperRequestResponse() {
        return new FeedNotificationWrapperRequestResponse();
    }

    /**
     * Create an instance of {@link FeedNotificationRequest }
     * 
     */
    public FeedNotificationRequest createFeedNotificationRequest() {
        return new FeedNotificationRequest();
    }

    /**
     * Create an instance of {@link RequestBase }
     * 
     */
    public RequestBase createRequestBase() {
        return new RequestBase();
    }

    /**
     * Create an instance of {@link Feed }
     * 
     */
    public Feed createFeed() {
        return new Feed();
    }

    /**
     * Create an instance of {@link FeedNotificationResponse }
     * 
     */
    public FeedNotificationResponse createFeedNotificationResponse() {
        return new FeedNotificationResponse();
    }

    /**
     * Create an instance of {@link ResponseBase }
     * 
     */
    public ResponseBase createResponseBase() {
        return new ResponseBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeedNotificationWrapperRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.maplequad.com/gbm/grt/om", name = "feedNotificationWrapperRequest")
    public JAXBElement<FeedNotificationWrapperRequest> createFeedNotificationWrapperRequest(FeedNotificationWrapperRequest value) {
        return new JAXBElement<FeedNotificationWrapperRequest>(_FeedNotificationWrapperRequest_QNAME, FeedNotificationWrapperRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeedNotificationWrapperRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.maplequad.com/gbm/grt/om", name = "feedNotificationWrapperRequestResponse")
    public JAXBElement<FeedNotificationWrapperRequestResponse> createFeedNotificationWrapperRequestResponse(FeedNotificationWrapperRequestResponse value) {
        return new JAXBElement<FeedNotificationWrapperRequestResponse>(_FeedNotificationWrapperRequestResponse_QNAME, FeedNotificationWrapperRequestResponse.class, null, value);
    }

}

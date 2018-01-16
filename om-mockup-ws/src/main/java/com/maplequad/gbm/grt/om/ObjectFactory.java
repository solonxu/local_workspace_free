
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

    private final static QName _ExecuteWrapperRequest_QNAME = new QName("http://www.maplequad.com/gbm/grt/om", "executeWrapperRequest");
    private final static QName _ExecuteWrapperRequestResponse_QNAME = new QName("http://www.maplequad.com/gbm/grt/om", "executeWrapperRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.maplequad.gbm.grt.om
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExecuteWrapperRequest }
     * 
     */
    public ExecuteWrapperRequest createExecuteWrapperRequest() {
        return new ExecuteWrapperRequest();
    }

    /**
     * Create an instance of {@link ExecuteWrapperRequestResponse }
     * 
     */
    public ExecuteWrapperRequestResponse createExecuteWrapperRequestResponse() {
        return new ExecuteWrapperRequestResponse();
    }

    /**
     * Create an instance of {@link ExecuteRequest }
     * 
     */
    public ExecuteRequest createExecuteRequest() {
        return new ExecuteRequest();
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
     * Create an instance of {@link ExecuteResponse }
     * 
     */
    public ExecuteResponse createExecuteResponse() {
        return new ExecuteResponse();
    }

    /**
     * Create an instance of {@link ResponseBase }
     * 
     */
    public ResponseBase createResponseBase() {
        return new ResponseBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteWrapperRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.maplequad.com/gbm/grt/om", name = "executeWrapperRequest")
    public JAXBElement<ExecuteWrapperRequest> createExecuteWrapperRequest(ExecuteWrapperRequest value) {
        return new JAXBElement<ExecuteWrapperRequest>(_ExecuteWrapperRequest_QNAME, ExecuteWrapperRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteWrapperRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.maplequad.com/gbm/grt/om", name = "executeWrapperRequestResponse")
    public JAXBElement<ExecuteWrapperRequestResponse> createExecuteWrapperRequestResponse(ExecuteWrapperRequestResponse value) {
        return new JAXBElement<ExecuteWrapperRequestResponse>(_ExecuteWrapperRequestResponse_QNAME, ExecuteWrapperRequestResponse.class, null, value);
    }

}

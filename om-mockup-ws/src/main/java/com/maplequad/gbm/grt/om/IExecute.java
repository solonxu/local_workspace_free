package com.maplequad.gbm.grt.om;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-01-15T12:36:55.520+08:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://www.maplequad.com/gbm/grt/om", name = "IExecute")
@XmlSeeAlso({ObjectFactory.class})
public interface IExecute {

    @WebMethod
    @RequestWrapper(localName = "executeWrapperRequest", targetNamespace = "http://www.maplequad.com/gbm/grt/om", className = "com.maplequad.gbm.grt.om.ExecuteWrapperRequest")
    @ResponseWrapper(localName = "executeWrapperRequestResponse", targetNamespace = "http://www.maplequad.com/gbm/grt/om", className = "com.maplequad.gbm.grt.om.ExecuteWrapperRequestResponse")
    @WebResult(name = "ExecuteResponse", targetNamespace = "")
    public com.maplequad.gbm.grt.om.ExecuteResponse executeWrapperRequest(
        @WebParam(name = "ExecuteRequest", targetNamespace = "")
        com.maplequad.gbm.grt.om.ExecuteRequest executeRequest
    );
}

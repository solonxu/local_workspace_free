
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeWrapperRequestResponse", propOrder = {
    "executeResponse"
})
public class ExecuteWrapperRequestResponse {

    @XmlElement(name = "ExecuteResponse")
    protected ExecuteResponse executeResponse;

    public ExecuteResponse getExecuteResponse() {
        return executeResponse;
    }

   
    public void setExecuteResponse(ExecuteResponse value) {
        this.executeResponse = value;
    }

}

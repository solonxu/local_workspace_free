
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>executeWrapperRequestResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="executeWrapperRequestResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExecuteResponse" type="{http://www.maplequad.com/gbm/grt/om}executeResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeWrapperRequestResponse", propOrder = {
    "executeResponse"
})
public class ExecuteWrapperRequestResponse {

    @XmlElement(name = "ExecuteResponse")
    protected ExecuteResponse executeResponse;

    /**
     * ��ȡexecuteResponse���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ExecuteResponse }
     *     
     */
    public ExecuteResponse getExecuteResponse() {
        return executeResponse;
    }

    /**
     * ����executeResponse���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ExecuteResponse }
     *     
     */
    public void setExecuteResponse(ExecuteResponse value) {
        this.executeResponse = value;
    }

}

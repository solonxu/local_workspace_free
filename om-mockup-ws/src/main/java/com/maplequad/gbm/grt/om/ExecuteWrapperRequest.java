
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>executeWrapperRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="executeWrapperRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExecuteRequest" type="{http://www.maplequad.com/gbm/grt/om}executeRequest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeWrapperRequest", propOrder = {
    "executeRequest"
})
public class ExecuteWrapperRequest {

    @XmlElement(name = "ExecuteRequest")
    protected ExecuteRequest executeRequest;

    /**
     * ��ȡexecuteRequest���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ExecuteRequest }
     *     
     */
    public ExecuteRequest getExecuteRequest() {
        return executeRequest;
    }

    /**
     * ����executeRequest���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ExecuteRequest }
     *     
     */
    public void setExecuteRequest(ExecuteRequest value) {
        this.executeRequest = value;
    }

}

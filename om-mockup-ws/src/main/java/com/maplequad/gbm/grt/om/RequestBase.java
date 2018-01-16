
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>requestBase complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="requestBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InstanceId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="ProcessId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestBase", propOrder = {
    "instanceId",
    "processId"
})
@XmlSeeAlso({
    ExecuteRequest.class
})
public class RequestBase {

    @XmlElement(name = "InstanceId")
    protected long instanceId;
    @XmlElement(name = "ProcessId", required = true)
    protected String processId;

    /**
     * ��ȡinstanceId���Ե�ֵ��
     * 
     */
    public long getInstanceId() {
        return instanceId;
    }

    /**
     * ����instanceId���Ե�ֵ��
     * 
     */
    public void setInstanceId(long value) {
        this.instanceId = value;
    }

    /**
     * ��ȡprocessId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * ����processId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessId(String value) {
        this.processId = value;
    }

}

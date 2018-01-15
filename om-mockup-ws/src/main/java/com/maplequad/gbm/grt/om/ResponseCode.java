
package com.maplequad.gbm.grt.om;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>responseCode的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="responseCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="FAIL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "responseCode")
@XmlEnum
public enum ResponseCode {

    OK,
    FAIL;

    public String value() {
        return name();
    }

    public static ResponseCode fromValue(String v) {
        return valueOf(v);
    }

}

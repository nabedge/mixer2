
package org.mixer2.jaxb.xhtml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ULStyleのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * <p>
 * <pre>
 * &lt;simpleType name="ULStyle">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="disc"/>
 *     &lt;enumeration value="square"/>
 *     &lt;enumeration value="circle"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ULStyle")
@XmlEnum
public enum ULStyle {

    @XmlEnumValue("disc")
    DISC("disc"),
    @XmlEnumValue("square")
    SQUARE("square"),
    @XmlEnumValue("circle")
    CIRCLE("circle");
    private final String value;

    ULStyle(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ULStyle fromValue(String v) {
        for (ULStyle c: ULStyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

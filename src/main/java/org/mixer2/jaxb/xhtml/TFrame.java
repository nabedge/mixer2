
package org.mixer2.jaxb.xhtml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TFrameのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * <p>
 * <pre>
 * &lt;simpleType name="TFrame">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="void"/>
 *     &lt;enumeration value="above"/>
 *     &lt;enumeration value="below"/>
 *     &lt;enumeration value="hsides"/>
 *     &lt;enumeration value="lhs"/>
 *     &lt;enumeration value="rhs"/>
 *     &lt;enumeration value="vsides"/>
 *     &lt;enumeration value="box"/>
 *     &lt;enumeration value="border"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TFrame")
@XmlEnum
public enum TFrame {

    @XmlEnumValue("void")
    VOID("void"),
    @XmlEnumValue("above")
    ABOVE("above"),
    @XmlEnumValue("below")
    BELOW("below"),
    @XmlEnumValue("hsides")
    HSIDES("hsides"),
    @XmlEnumValue("lhs")
    LHS("lhs"),
    @XmlEnumValue("rhs")
    RHS("rhs"),
    @XmlEnumValue("vsides")
    VSIDES("vsides"),
    @XmlEnumValue("box")
    BOX("box"),
    @XmlEnumValue("border")
    BORDER("border");
    private final String value;

    TFrame(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TFrame fromValue(String v) {
        for (TFrame c: TFrame.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

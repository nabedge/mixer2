
package org.mixer2.jaxb.xhtml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ULStyle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ULStyle"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="disc"/&gt;
 *     &lt;enumeration value="square"/&gt;
 *     &lt;enumeration value="circle"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
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

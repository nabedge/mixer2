
package org.mixer2.jaxb.xhtml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TFrame.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TFrame"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="void"/&gt;
 *     &lt;enumeration value="above"/&gt;
 *     &lt;enumeration value="below"/&gt;
 *     &lt;enumeration value="hsides"/&gt;
 *     &lt;enumeration value="lhs"/&gt;
 *     &lt;enumeration value="rhs"/&gt;
 *     &lt;enumeration value="vsides"/&gt;
 *     &lt;enumeration value="box"/&gt;
 *     &lt;enumeration value="border"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
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

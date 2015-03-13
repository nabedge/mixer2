
package org.mixer2.jaxb.xhtml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Scope.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Scope"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="row"/&gt;
 *     &lt;enumeration value="col"/&gt;
 *     &lt;enumeration value="rowgroup"/&gt;
 *     &lt;enumeration value="colgroup"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Scope")
@XmlEnum
public enum Scope {

    @XmlEnumValue("row")
    ROW("row"),
    @XmlEnumValue("col")
    COL("col"),
    @XmlEnumValue("rowgroup")
    ROWGROUP("rowgroup"),
    @XmlEnumValue("colgroup")
    COLGROUP("colgroup");
    private final String value;

    Scope(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Scope fromValue(String v) {
        for (Scope c: Scope.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

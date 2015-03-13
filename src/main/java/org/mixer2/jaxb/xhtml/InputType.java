
package org.mixer2.jaxb.xhtml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InputType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InputType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="text"/&gt;
 *     &lt;enumeration value="password"/&gt;
 *     &lt;enumeration value="checkbox"/&gt;
 *     &lt;enumeration value="radio"/&gt;
 *     &lt;enumeration value="submit"/&gt;
 *     &lt;enumeration value="reset"/&gt;
 *     &lt;enumeration value="file"/&gt;
 *     &lt;enumeration value="hidden"/&gt;
 *     &lt;enumeration value="image"/&gt;
 *     &lt;enumeration value="button"/&gt;
 *     &lt;enumeration value="tel"/&gt;
 *     &lt;enumeration value="search"/&gt;
 *     &lt;enumeration value="url"/&gt;
 *     &lt;enumeration value="email"/&gt;
 *     &lt;enumeration value="datetime"/&gt;
 *     &lt;enumeration value="date"/&gt;
 *     &lt;enumeration value="month"/&gt;
 *     &lt;enumeration value="week"/&gt;
 *     &lt;enumeration value="time"/&gt;
 *     &lt;enumeration value="datetime-local"/&gt;
 *     &lt;enumeration value="number"/&gt;
 *     &lt;enumeration value="range"/&gt;
 *     &lt;enumeration value="color"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "InputType")
@XmlEnum
public enum InputType {

    @XmlEnumValue("text")
    TEXT("text"),
    @XmlEnumValue("password")
    PASSWORD("password"),
    @XmlEnumValue("checkbox")
    CHECKBOX("checkbox"),
    @XmlEnumValue("radio")
    RADIO("radio"),
    @XmlEnumValue("submit")
    SUBMIT("submit"),
    @XmlEnumValue("reset")
    RESET("reset"),
    @XmlEnumValue("file")
    FILE("file"),
    @XmlEnumValue("hidden")
    HIDDEN("hidden"),
    @XmlEnumValue("image")
    IMAGE("image"),
    @XmlEnumValue("button")
    BUTTON("button"),
    @XmlEnumValue("tel")
    TEL("tel"),
    @XmlEnumValue("search")
    SEARCH("search"),
    @XmlEnumValue("url")
    URL("url"),
    @XmlEnumValue("email")
    EMAIL("email"),
    @XmlEnumValue("datetime")
    DATETIME("datetime"),
    @XmlEnumValue("date")
    DATE("date"),
    @XmlEnumValue("month")
    MONTH("month"),
    @XmlEnumValue("week")
    WEEK("week"),
    @XmlEnumValue("time")
    TIME("time"),
    @XmlEnumValue("datetime-local")
    DATETIME_LOCAL("datetime-local"),
    @XmlEnumValue("number")
    NUMBER("number"),
    @XmlEnumValue("range")
    RANGE("range"),
    @XmlEnumValue("color")
    COLOR("color");
    private final String value;

    InputType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InputType fromValue(String v) {
        for (InputType c: InputType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

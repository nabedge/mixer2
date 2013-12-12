
package org.mixer2.jaxb.xhtml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>InputTypeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * <p>
 * <pre>
 * &lt;simpleType name="InputType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="text"/>
 *     &lt;enumeration value="password"/>
 *     &lt;enumeration value="checkbox"/>
 *     &lt;enumeration value="radio"/>
 *     &lt;enumeration value="submit"/>
 *     &lt;enumeration value="reset"/>
 *     &lt;enumeration value="file"/>
 *     &lt;enumeration value="hidden"/>
 *     &lt;enumeration value="image"/>
 *     &lt;enumeration value="button"/>
 *     &lt;enumeration value="tel"/>
 *     &lt;enumeration value="search"/>
 *     &lt;enumeration value="url"/>
 *     &lt;enumeration value="email"/>
 *     &lt;enumeration value="datetime"/>
 *     &lt;enumeration value="date"/>
 *     &lt;enumeration value="month"/>
 *     &lt;enumeration value="week"/>
 *     &lt;enumeration value="time"/>
 *     &lt;enumeration value="datetime-local"/>
 *     &lt;enumeration value="number"/>
 *     &lt;enumeration value="range"/>
 *     &lt;enumeration value="color"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
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

//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.6によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2013.07.04 時間 09:23:41 PM JST 
//


package org.mixer2.jaxb.xhtml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LAlignのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * <p>
 * <pre>
 * &lt;simpleType name="LAlign">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="top"/>
 *     &lt;enumeration value="bottom"/>
 *     &lt;enumeration value="left"/>
 *     &lt;enumeration value="right"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LAlign")
@XmlEnum
public enum LAlign {

    @XmlEnumValue("top")
    TOP("top"),
    @XmlEnumValue("bottom")
    BOTTOM("bottom"),
    @XmlEnumValue("left")
    LEFT("left"),
    @XmlEnumValue("right")
    RIGHT("right");
    private final String value;

    LAlign(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LAlign fromValue(String v) {
        for (LAlign c: LAlign.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

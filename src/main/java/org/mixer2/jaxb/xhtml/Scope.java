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
 * <p>ScopeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * <p>
 * <pre>
 * &lt;simpleType name="Scope">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="row"/>
 *     &lt;enumeration value="col"/>
 *     &lt;enumeration value="rowgroup"/>
 *     &lt;enumeration value="colgroup"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
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

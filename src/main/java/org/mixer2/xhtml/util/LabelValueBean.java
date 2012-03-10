package org.mixer2.xhtml.util;

/**
 * 主にoptionタグで使用するためのbean。
 * valueがoptionタグのvalue属性、labelがタグ内の文字列を表します
 *
 * @author watanabe
 *
 */
public class LabelValueBean {

    private String label;

    private String value;

    public LabelValueBean(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
   }

}

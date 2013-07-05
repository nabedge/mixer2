
package org.mixer2.jaxb.xhtml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Integer>
{


    public Integer unmarshal(String value) {
        return new Integer(value);
    }

    public String marshal(Integer value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

}

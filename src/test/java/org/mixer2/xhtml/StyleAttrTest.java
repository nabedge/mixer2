package org.mixer2.xhtml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import org.apache.commons.lang.SystemUtils;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;


public class StyleAttrTest {

    private String templateFileName = "StyleAttrTest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @Before
    public void init() throws IOException {
        templateFilePath = getClass().getResource(templateFileName).toString();
        if(SystemUtils.IS_OS_WINDOWS){
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void getStyle() throws IOException, TagTypeUnmatchException {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        TreeMap<String,String> styleMap = html.getById("span1",Span.class).getStyleAsTreeMap();
        assertEquals("large", styleMap.get("font-weight"));
        assertEquals("0", styleMap.get("margin"));
        assertEquals("0", styleMap.get("padding"));
    }

    @Test
    public void setStyle() throws IOException, TagTypeUnmatchException {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        TreeMap<String,String> styleMap;
        styleMap = html.getById("div1",Div.class).getStyleAsTreeMap();
        assertEquals("solid", styleMap.get("border-style"));

        styleMap.put("font-weight", "bold");
        html.getById("div1",Div.class).setStyleByTreeMap(styleMap);
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        styleMap = html.getById("div1",Div.class).getStyleAsTreeMap();
        assertEquals("solid", styleMap.get("border-style"));
        assertEquals("bold", styleMap.get("font-weight"));

    }

    @Test
    public void setStyleNew() throws IOException, TagTypeUnmatchException {
        Html html;
        TreeMap<String,String> styleMap;

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        styleMap = html.getById("div1",Div.class).getStyleAsTreeMap();
        assertEquals("solid", styleMap.get("border-style"));

        TreeMap<String,String> newStyleMap = new TreeMap<String,String>();
        newStyleMap.put("border-color", "red");
        html.getById("div1",Div.class).setStyleByTreeMap(newStyleMap);

        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        styleMap = html.getById("div1",Div.class).getStyleAsTreeMap();
        assertNull(styleMap.get("border-style"));
        assertEquals("red", styleMap.get("border-color"));

    }

}

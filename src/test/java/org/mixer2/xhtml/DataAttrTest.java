package org.mixer2.xhtml;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Span;

public class DataAttrTest {

    private String templateFileName = "DataAttrTest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Before
    public void init() throws Exception {
        templateFilePath = getClass().getResource(templateFileName).toString();
        String osname = System.getProperty("os.name");
        if (osname.indexOf("Windows") >= 0) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void getData() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        String DataRole = html.getById("span1", Span.class).getData("role");
        assertEquals("foo", DataRole);
    }

    @Test
    public void setData() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.getById("span2", Span.class).setData("hoge", "あいうえお");
        // System.out.println(m2e.saveToString(html.getById("span2",
        // Span.class)));
        // System.out.println(m2e.saveToString(html.getById("span2",
        // Span.class)));
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        String dataHoge = html.getById("span2", Span.class).getData("hoge");
        assertEquals("あいうえお", dataHoge);
    }

    @Test
    public void removeData() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Span span = html.getById("span3", Span.class);
        // System.out.println(m2e.saveToString(span));
        span.removeData("foo");
        // System.out.println(m2e.saveToString(span));
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        assertNull(html.getById("span3", Span.class).getData("foo"));
    }

    @Test
    public void getAria() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Span span = html.getById("span3", Span.class);
        assertThat(span.getAria("foo"), is("ariafoo"));
    }

    @Test
    public void setAria() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.getById("span2", Span.class).setAria("hoge", "あいうえお");
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        String ariaHoge = html.getById("span2", Span.class).getAria("hoge");
        assertThat(ariaHoge, is("あいうえお"));
    }

    @Test
    public void removeAria() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Span span = html.getById("span3", Span.class);
//        System.out.println(m2e.saveToString(span));
        span.removeAria("foo");
//        System.out.println(m2e.saveToString(span));
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        assertNull(html.getById("span3", Span.class).getAria("foo"));
    }
}

package org.mixer2.xhtml;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;


public class DataAttrTest {

    private String templateFileName = "DataAttrTest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = new Mixer2Engine();

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Before
    public void init() throws IOException {
        templateFilePath = getClass().getResource(templateFileName).toString();
        String osname = System.getProperty("os.name");
        if(osname.indexOf("Windows")>=0){
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void getData() throws IOException, TagTypeUnmatchException {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        String DataRole = html.getById("span1", Span.class).getData("role");
        assertEquals("foo", DataRole);
    }

    @Test
    public void setData() throws IOException, TagTypeUnmatchException {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.getById("span2", Span.class).setData("hoge", "あいうえお");
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        String DataHoge = html.getById("span2", Span.class).getData("hoge");
        assertEquals("あいうえお", DataHoge);
    }

}

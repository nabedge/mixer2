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

public class CssClassTest {
    private String templateFileName = "CssClassTest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    private Html html;

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
    public void test() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Span span = html.getById("test1", Span.class);
        assertEquals(span.hasCssClass("aaa"), true);
        assertEquals(span.hasCssClass("bbb"), true);
        assertEquals(span.hasCssClass("ccc"), true);
        assertEquals(span.hasCssClass("ddd"), false);

        span.removeCssClass("bbb");
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        assertEquals(span.hasCssClass("aaa"), true);
        assertEquals(span.hasCssClass("bbb"), false);
        assertEquals(span.hasCssClass("ccc"), true);

        span.addCssClass("ddd");
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        assertEquals(span.hasCssClass("aaa"), true);
        assertEquals(span.hasCssClass("bbb"), false);
        assertEquals(span.hasCssClass("ccc"), true);
        assertEquals(span.hasCssClass("ddd"), true);
    }

}

package org.mixer2.xhtml;

import static org.junit.Assert.*;

import java.io.File;
import java.io.StringWriter;

import org.apache.commons.lang.SystemUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Span;

public class Snippet_divTest {
    private String templateFileName = "snippet_div.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    private Html html;

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Before
    public void init() throws Exception {
        templateFilePath = getClass().getResource(templateFileName).toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void test() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Div div = html.getById("foo", Div.class);
        Span span = new Span();
        span.getContent().add("def");
        div.getContent().add(span);
        div.getContent().add("<script>alert(1);</script>");
        StringWriter sw = new StringWriter();
        m2e.saveToStringWriter(div, sw);
        String result = sw.toString();
        //System.out.println(result);
        assertTrue(result.contains("&lt;script&gt;alert(1);&lt;/script&gt;"));
        assertTrue(result.trim().startsWith("<div "));
        assertTrue(result.trim().endsWith("</div>"));
        assertFalse(result.contains("</html>"));
    }
}

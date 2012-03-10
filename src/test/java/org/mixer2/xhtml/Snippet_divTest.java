package org.mixer2.xhtml;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class Snippet_divTest {
    private String templateFileName = "snippet_div.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = new Mixer2Engine();
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
        // System.out.println(m2e.saveToString(html));
        Div div = html.getById("foo", Div.class);
        Span span = new Span();
        span.getContent().add("aeiou");
        div.getContent().add(span);
        StringWriter sw = new StringWriter();
        m2e.saveToStringWriter(div, sw);
        // m2e.loadHtmlTemplate(sw.toString());
        // System.out.println(sw.toString());
    }
}

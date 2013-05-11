package org.mixer2.xhtml.replace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mixer2.xhtml.TagCreator.span;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.I;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class ReplaceDescendantsTest {

    private String templateFileName = "ReplaceDescendantsTest01.html";
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
    public void test1() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        Span span;

        span = span();
        span.getCssClass().add("newspan");
        span.getContent().add("newspan");

        assertNotNull(html.getById("span1", Span.class));
        assertEquals("span1", html.getById("span1", Span.class).getContent()
                .get(0));
        assertNotNull(html.getById("span2", Span.class));
        assertEquals("span2", html.getById("span2", Span.class).getContent()
                .get(0));
        //
        html.replaceDescendants(Span.class, span);
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        //
        assertNull(html.getById("span1", Span.class));
        assertNull(html.getById("span2", Span.class));
        List<Span> spanList = html.getDescendants(Span.class);
        for (Span s : spanList) {
            assertEquals("newspan", s.getContent().get(0));
        }

        // ////////////////////////////////////////////////////////////////

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        span = span();
        span.getCssClass().add("newspan");
        span.getContent().add("newspan");
        assertNotNull(html.getById("i1", I.class));
        assertNotNull(html.getById("span2", Span.class));
        //
        html.replaceDescendants("mark1", span);
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        //
        assertNull(html.getById("i1", I.class));
        assertNull(html.getById("span2", Span.class));
        assertEquals(2, html.getDescendants("newspan", Span.class).size());

    }
}

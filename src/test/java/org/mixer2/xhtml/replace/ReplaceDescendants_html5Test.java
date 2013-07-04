package org.mixer2.xhtml.replace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.Br;
import org.mixer2.jaxb.xhtml.Footer;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Li;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class ReplaceDescendants_html5Test {

    private String templateFileName = "ReplaceDescendantsTest_html5.html";
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
    public void replaceByClass() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
//        System.out.println(m2e.saveToString(html));
        A repA = new A();
        repA.addCssClass("repA");
        repA.setHref("hoge");
        repA.getContent().add("fuga");

        assertNotNull(html.getById("a1", A.class));
        assertNotNull(html.getById("a2", A.class));
        assertNotNull(html.getById("a3", A.class));
        assertNotNull(html.getById("dummy_a", A.class));

        html.replaceDescendants("bbb", repA);

        assertNotNull(html.getById("a1", A.class));
        assertNull(html.getById("a2", A.class));
        assertNull(html.getById("a3", A.class));
        assertNull(html.getById("dummy_a", A.class));
        assertEquals(3, html.getDescendants("repA", A.class).size());
        assertEquals("a1", ((A)html.getById("li_a", Li.class).getContent().get(0)).getId());
        assertEquals("repA", ((A)html.getById("li_b", Li.class).getContent().get(0)).getCssClass().get(0));
        assertEquals("repA", ((A)html.getById("li_c", Li.class).getContent().get(0)).getCssClass().get(0));
        List<Object> list = html.getById("footer", Footer.class).getContent();
        for (int i=0; i>list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof Br) {
                A a = (A) list.get(i+1);
                assertEquals("fuga", a.getContent().get(0));
            }
        }
    }
}

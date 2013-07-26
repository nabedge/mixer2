package org.mixer2.xhtml;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.lang.SystemUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.H1;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Li;

public class CopyTest {

    private String templateFileName = "copytest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

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
    public void testHtml() throws Exception {
        Html original = m2e.loadHtmlTemplate(new File(templateFilePath));
        Html copy = original.copy(Html.class);
        assertEquals("bar", copy.getById("li_sample01", Li.class)
                .getData("foo"));
        assertEquals("111", copy.getById("test_h1", H1.class).getData("xxx"));
        assertEquals("222", copy.getById("test_h1", H1.class).getData("yyy"));
        assertEquals(m2e.saveToString(original), m2e.saveToString(copy));
    }

    @Test
    public void testDiv() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Div helloWorldDiv = html.getById("hellomsg", Div.class);
        Div newDiv = helloWorldDiv.copyNoException(Div.class);
        newDiv.setId("bar");
        newDiv.unsetContent();
        newDiv.getContent().add("Life is beautiful.");
        assertEquals("Div", newDiv.getClass().getSimpleName());
        assertEquals("Hello World !", helloWorldDiv.getContent().get(0));
        assertEquals("Life is beautiful.", newDiv.getContent().get(0));
        assertEquals("hellomsg", helloWorldDiv.getId());
        assertEquals("bar", newDiv.getId());
        assertEquals("bar", newDiv.getData("foo"));
        assertEquals("foo", newDiv.getData("bar"));
    }

}

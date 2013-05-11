package org.mixer2.xhtml;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class CopyTest {

    private String templateFileName = "copytest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

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
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Div helloWorldDiv = html.getById("hellomsg",Div.class);
        Div newDiv = helloWorldDiv.copy(Div.class);
        newDiv.setId("bar");
        newDiv.unsetContent();
        newDiv.getContent().add("Life is beautiful.");
        assertEquals("Div", newDiv.getClass().getSimpleName());
        assertEquals("Hello World !", helloWorldDiv.getContent().get(0));
        assertEquals("Life is beautiful.", newDiv.getContent().get(0));
        assertEquals("hellomsg", helloWorldDiv.getId());
        assertEquals("bar", newDiv.getId());
    }

}

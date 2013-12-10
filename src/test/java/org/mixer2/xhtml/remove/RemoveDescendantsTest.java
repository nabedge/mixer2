package org.mixer2.xhtml.remove;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Script;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class RemoveDescendantsTest {

    private String templateFileName = "RemoveDescendantsTest.html";
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
    public void removeScripts() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertNotNull(html.getById("fooscript1", Script.class));
        assertNotNull(html.getById("fooscript2", Script.class));
        assertNotNull(html.getById("fooscript3", Script.class));
        html.removeDescendants("fooscript", Script.class);
        assertNull(html.getById("fooscript1", Script.class));
        assertNotNull(html.getById("fooscript2", Script.class));
        assertNull(html.getById("fooscript3", Script.class));
    }

    @Test
    public void testRemoveDescendants() throws IOException,
            TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        //
        assertNotNull(html.getById("a1", A.class));
        assertNotNull(html.getById("a2", A.class));
        assertNotNull(html.getById("a3", A.class));
        html.removeDescendants(A.class);
        assertNull(html.getById("a1", A.class));
        assertNull(html.getById("a2", A.class));
        assertNull(html.getById("a3", A.class));
        //
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.removeDescendants("foo", A.class);
        assertNull(html.getById("a1", A.class));
        assertNotNull(html.getById("a2", A.class));
        assertNull(html.getById("a3", A.class));

    }
}

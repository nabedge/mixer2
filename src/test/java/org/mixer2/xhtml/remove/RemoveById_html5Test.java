package org.mixer2.xhtml.remove;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Article;
import org.mixer2.jaxb.xhtml.Br;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 *
 * @author watanabe
 *
 */
public class RemoveById_html5Test {

    private String templateFileName = "RemoveByIdTest_html5.html";
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
    public void testRemoveById() throws IOException, TagTypeUnmatchException {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        //
        assertNotNull(html.getById("dummy_br", Br.class));
        html.removeById("dummy_br");
        assertNull(html.getById("dummy_br"));
        //
        assertNotNull(html.getById("article2", Article.class));
        html.removeById("article2");
        assertNull(html.getById("article2", Article.class));
    }
}

package org.mixer2.xhtml;

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
import org.mixer2.jaxb.xhtml.Footer;
import org.mixer2.jaxb.xhtml.Header;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Nav;
import org.mixer2.jaxb.xhtml.Track;
import org.mixer2.jaxb.xhtml.Video;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class UnsetId_html5Test {

    private String templateFileName = "UnsetIdTest_html5.html";
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
    public void unsetIdTest_dl_dd() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        assertNotNull(html.getById("header_id",Header.class));
        assertNotNull(html.getById("footer",Footer.class));
        assertNotNull(html.getById("nav_id",Nav.class));
        assertNotNull(html.getById("article1",Article.class));
        assertNotNull(html.getById("video1",Video.class));
        assertNotNull(html.getById("track1",Track.class));
        assertNotNull(html.getById("dummy_br",Br.class));
        html.unsetAllId();
        assertNull(html.getById("header_id",Header.class));
        assertNull(html.getById("footer",Footer.class));
        assertNull(html.getById("nav_id",Nav.class));
        assertNull(html.getById("article1",Article.class));
        assertNull(html.getById("video1",Video.class));
        assertNull(html.getById("track1",Track.class));
        assertNull(html.getById("dummy_br",Br.class));

    }

}

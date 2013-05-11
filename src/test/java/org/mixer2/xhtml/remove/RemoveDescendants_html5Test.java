package org.mixer2.xhtml.remove;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Area;
import org.mixer2.jaxb.xhtml.Article;
import org.mixer2.jaxb.xhtml.Bdi;
import org.mixer2.jaxb.xhtml.Bdo;
import org.mixer2.jaxb.xhtml.Figcaption;
import org.mixer2.jaxb.xhtml.Footer;
import org.mixer2.jaxb.xhtml.Header;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Nav;
import org.mixer2.jaxb.xhtml.Pre;
import org.mixer2.jaxb.xhtml.Section;
import org.mixer2.jaxb.xhtml.Td;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class RemoveDescendants_html5Test {

    private String templateFileName = "RemoveDescendantsTest_html5.html";
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

    /**
     * タグとclassを指定して削除
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void removeByTagAndClass() throws IOException,
            TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        assertNotNull(html.getById("header", Header.class));
        assertNotNull(html.getById("footer", Footer.class));
        assertNotNull(html.getById("figcaption1", Figcaption.class));
        assertNotNull(html.getById("figcaption2", Figcaption.class));
        html.removeDescendants("bbb", Figcaption.class);
        assertNotNull(html.getById("header", Header.class));
        assertNotNull(html.getById("footer", Footer.class));
        assertNotNull(html.getById("figcaption1", Figcaption.class));
        assertNull(html.getById("figcaption2", Figcaption.class));
    }

    /**
     * classを指定して削除
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void removeByCssClass() throws IOException,
            TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertNotNull(html.getById("header", Header.class)); // class="aaa bbb ccc"
        assertNotNull(html.getById("nav", Nav.class));// class=bbb ccc
        assertNotNull(html.getById("area1", Area.class));// class=aaa
        assertNotNull(html.getById("area2", Area.class));// class=bbb
        assertNotNull(html.getById("article1", Article.class));// class=aaa ccc
        assertNotNull(html.getById("section1", Section.class));// class=aaa bbb
        assertNotNull(html.getById("bdi1", Bdi.class));// class=aaa
        assertNotNull(html.getById("bdi2", Bdi.class));// class=bbb
        assertNotNull(html.getById("bdo1", Bdo.class));// class=aaa
        assertNotNull(html.getById("bdo2", Bdo.class));// class=bbb
        assertNotNull(html.getById("pre1", Pre.class));// class=bbb
        assertNotNull(html.getById("figcaption1", Figcaption.class)); // class=aaa
        assertNotNull(html.getById("figcaption2", Figcaption.class)); // class=bbb
        assertNotNull(html.getById("td1", Td.class)); // class=aaa
        assertNotNull(html.getById("td2", Td.class)); // class=bbb
        assertNotNull(html.getById("td3", Td.class)); // class=aaa
        assertNotNull(html.getById("td4", Td.class)); // class=bbb
        assertNotNull(html.getById("td5", Td.class)); // class=aaa
        assertNotNull(html.getById("td6", Td.class)); // class=bbb
        assertNotNull(html.getById("td7", Td.class)); // class=aaa
        assertNotNull(html.getById("td8", Td.class)); // class=bbb
        assertNotNull(html.getById("footer", Footer.class)); // class=bbb
        html.removeDescendants("bbb");
        assertNull(html.getById("header", Header.class)); // class="aaa bbb ccc"
        assertNull(html.getById("nav", Nav.class));// class=bbb ccc
        assertNotNull(html.getById("area1", Area.class));// class=aaa
        assertNull(html.getById("area2", Area.class));// class=bbb
        assertNotNull(html.getById("article1", Article.class));// class=aaa ccc
        assertNull(html.getById("section1", Section.class));// class=aaa bbb
        assertNotNull(html.getById("bdi1", Bdi.class));// class=aaa
        assertNull(html.getById("bdi2", Bdi.class));// class=bbb
        assertNotNull(html.getById("bdo1", Bdo.class));// class=aaa
        assertNull(html.getById("bdo2", Bdo.class));// class=bbb
        assertNull(html.getById("pre1", Pre.class));// class=bbb
        assertNotNull(html.getById("figcaption1", Figcaption.class)); // class=aaa
        assertNull(html.getById("figcaption2", Figcaption.class)); // class=bbb
        assertNotNull(html.getById("td1", Td.class)); // class=aaa
        assertNull(html.getById("td2", Td.class)); // class=bbb
        assertNotNull(html.getById("td3", Td.class)); // class=aaa
        assertNull(html.getById("td4", Td.class)); // class=bbb
        assertNotNull(html.getById("td5", Td.class)); // class=aaa
        assertNull(html.getById("td6", Td.class)); // class=bbb
        assertNotNull(html.getById("td7", Td.class)); // class=aaa
        assertNull(html.getById("td8", Td.class)); // class=bbb
        assertNull(html.getById("footer", Footer.class)); // class=bbb

    }

    /**
     * タグを指定して削除
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void removeByTag() throws IOException,
            TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertNotNull(html.getById("bdi1", Bdi.class));// class=aaa
        assertNotNull(html.getById("bdi2", Bdi.class));// class=bbb
        html.removeDescendants(Bdi.class);
        assertNull(html.getById("bdi1", Bdi.class));// class=aaa
        assertNull(html.getById("bdi2", Bdi.class));// class=bbb

    }


}

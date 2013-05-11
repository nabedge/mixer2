package org.mixer2.xhtml.replace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mixer2.xhtml.TagCreator.div;
import static org.mixer2.xhtml.TagCreator.img;
import static org.mixer2.xhtml.TagCreator.li;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Img;
import org.mixer2.jaxb.xhtml.Li;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 * @author watanabe
 *
 */
public class ReplaceById02Test {

    private String templateFileName = "ReplaceByIdTest02.html";
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

        Img img = img();
        img.setId("newimg");
        img.setSrc("new.png");
        assertNotNull(html.getById("img1", Img.class));
        //
        html.replaceById("img1", img);
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        //
        assertNull(html.getById("img1", Img.class));
        assertNotNull(html.getById("newimg", Img.class));

    }

    @Test
    public void test2() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        assertNotNull(html.getById("li1", Li.class));
        assertEquals("li1", html.getById("li1", Li.class).getContent().get(0));
        Li li = li();
        li.setId("li1");
        li.getContent().add("new li1");
        //
        html.replaceById("li1", li);
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        //
        assertNotNull(html.getById("li1", Li.class));
        String str = (String) html.getById("li1", Li.class).getContent().get(0);
        assertEquals("new li1", str.trim());

        Div div = div();
        div.getContent().add("aaa");
        try {
            html.replaceById("li1", div);
            fail("ulの下のliをdivで置換しようとしているため例外が発生するはず");
        } catch (TagTypeUnmatchException ex) {
        }

    }
}

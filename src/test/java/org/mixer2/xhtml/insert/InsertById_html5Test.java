package org.mixer2.xhtml.insert;

import static org.junit.Assert.assertEquals;
import static org.mixer2.xhtml.TagCreator.pWithId;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Br;
import org.mixer2.jaxb.xhtml.Footer;
import org.mixer2.jaxb.xhtml.Header;
import org.mixer2.jaxb.xhtml.Hgroup;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.P;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 *
 * @author watanabe
 *
 */
public class InsertById_html5Test {

    private String templateFileName = "InsertById_html5.html";
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
     * hgroupタグの後にpタグを挿入
     */
    @Test
    public void insertAfterHgroup() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        P p = pWithId("p1");
        p.getContent().add("paragraph");
        html.insertAfterId("hgroup1", p);
//        html = m2e.loadHtmlTemplate(m2e.saveToString(html));

        List<Object> objList = html.getById("header1", Header.class).getContent();
        for (ListIterator<Object> i = objList.listIterator(); i.hasNext();) {
            Object obj = i.next();
            if (obj instanceof Hgroup) {
                assertEquals("p1",((P) i.next()).getId());
                break;
            }
        }
    }

    /**
     * hgroupタグの後にpタグを挿入
     */
    @Test
    public void insertBeforeHgroup() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        P p = pWithId("p1");
        p.getContent().add("paragraph");
        html.insertBeforeId("hgroup1", p);

        List<Object> objList = html.getById("header1", Header.class).getContent();
        for (int i=0; i<objList.size(); i++) {
            if (objList.get(i) instanceof Hgroup) {
                assertEquals("p1",((P) objList.get(i - 1)).getId());
                break;
            }
        }
    }

    /**
     * @throws IOException
     * @throws TagTypeUnmatchException
     *
     */
    @Test
    public void insertAfterDummyBr() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.insertAfterId("dummy_br", "test");
        List<Object> list = html.getById("footer",Footer.class).getContent();
        for (int i=0; i<list.size(); i++) {
            java.lang.Object obj = list.get(i);
            if (obj instanceof Br) {
                assertEquals(list.get(i + 1), "test");
                break;
            }
        }
    }
}

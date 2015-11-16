package org.mixer2.xhtml.remove;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Header;
import org.mixer2.jaxb.xhtml.Hgroup;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.xhtml.Mixer2EngineSingleton;

/**
 *
 * @author jfut
 * @author watanabe
 */
public class Remove_html5Test {

    private String templateFileName = "RemoveTest_html5.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    private Html html;

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Before
    public void init() throws Exception {
        templateFilePath = getClass().getResource(templateFileName).toString();
        String osname = System.getProperty("os.name");
        if(osname.indexOf("Windows")>=0){
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    /**
     * idのないheaderタグを削除してみる
     * @throws Exception
     */
    @Test
    public void removeHeaderToOtherHeader() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants(Header.class).size());
        Header header = html.getDescendants(Header.class).get(0);

        boolean result = html.remove(header);

        assertEquals(true, result);
        assertEquals(0, html.getDescendants(Header.class).size());
    }

    /**
     * idのないhgroupタグを親要素のheaderを起点に削除してみる
     * @throws Exception
     */
    @Test
    public void removeHgroupFromHeader() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants(Header.class).size());
        Header header = html.getDescendants(Header.class).get(0);
        assertEquals(1, html.getDescendants(Hgroup.class).size());

        Hgroup hgroup = html.getDescendants(Hgroup.class).get(0);

        boolean result = header.remove(hgroup);

        assertEquals(true, result);
        assertEquals(1, html.getDescendants(Header.class).size());
        assertEquals(0, html.getDescendants(Hgroup.class).size());
    }

    /**
     * idのないheaderタグを違う親要素のhtmlを起点に削除してみる
     * @throws IOException
     */
    @Test
    public void removeFail() throws IOException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants(Header.class).size());

        Header header = html.getDescendants(Header.class).get(0);
        assertEquals(3, header.getContent().size());

        Html otherHtml = new Html();

        boolean result = otherHtml.remove(header);

        assertEquals(false, result);
        assertEquals(1, html.getDescendants(Header.class).size());
        Header notReplacedHeader = html.getDescendants(Header.class).get(0);
        assertEquals(3, notReplacedHeader.getContent().size());
    }

}

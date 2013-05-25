package org.mixer2.xhtml.replace;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.H1;
import org.mixer2.jaxb.xhtml.Header;
import org.mixer2.jaxb.xhtml.Hgroup;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 * @author jfut
 *
 */
public class Replace_html5Test {

    private String templateFileName = "ReplaceTest_html5.html";
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
     * idのないheaderタグ内のコンテンツを別のheaderタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceHeaderToOtherHeader() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants(Header.class).size());
        Header header = html.getDescendants(Header.class).get(0);

        Header newHeader = new Header();
        newHeader.getContent().add("content!");
        boolean result = html.replace(header, newHeader);
        assertEquals(true, result);
        assertEquals(1, html.getDescendants(Header.class).size());

        Header replacedHeader = html.getDescendants(Header.class).get(0);
        assertEquals("content!", replacedHeader.getContent().get(0));
    }

    /**
     * idのないheaderタグ内のコンテンツを別のdivタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceHeaderToDiv() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants(Header.class).size());
        assertEquals(0, html.getDescendants("header").size());
        Header header = html.getDescendants(Header.class).get(0);

        Div newHeaderDiv = new Div();
        newHeaderDiv.addCssClass("header");
        newHeaderDiv.getContent().add("content!");
        boolean result = html.replace(header, newHeaderDiv);
        assertEquals(true, result);
        assertEquals(0, html.getDescendants(Header.class).size());
        assertEquals(1, html.getDescendants("header").size());

        Div replacedHeaderDiv = html.getDescendants("header").get(0).cast(Div.class);
        assertEquals("content!", replacedHeaderDiv.getContent().get(0));
    }

    /**
     * idのないhgroupタグ内のコンテンツを親要素のheaderを起点に別のhgroupタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceHgroupFromHeader() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants(Header.class).size());
        Header header = html.getDescendants(Header.class).get(0);
        assertEquals(1, html.getDescendants(Hgroup.class).size());
        Hgroup hgroup = html.getDescendants(Hgroup.class).get(0);

        H1 newH1 = new H1();
        newH1.getContent().add("content!");
        Hgroup newHgroup = new Hgroup();
        newHgroup.getH1OrH2OrH3().add(newH1);
        boolean result = header.replace(hgroup, newHgroup);
        assertEquals(true, result);
        assertEquals(1, html.getDescendants(Header.class).size());
        assertEquals(1, html.getDescendants(Hgroup.class).size());

        Hgroup replacedHgroup = html.getDescendants(Hgroup.class).get(0);
        assertEquals("content!", replacedHgroup.getH1OrH2OrH3().get(0).getContent().get(0));
    }

    /**
     * idのないheaderタグ内のコンテンツを違う親要素のhtmlを起点に別のheaderタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceFail() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants(Header.class).size());
        Header header = html.getDescendants(Header.class).get(0);
        assertEquals(3, header.getContent().size());

        Html otherHtml = new Html();

        Header newHeader = new Header();
        newHeader.getContent().add("content!");
        boolean result = otherHtml.replace(header, newHeader);
        assertEquals(false, result);
        assertEquals(1, html.getDescendants(Header.class).size());

        Header replacedHeader = html.getDescendants(Header.class).get(0);
        assertEquals(3, replacedHeader.getContent().size());
    }

}

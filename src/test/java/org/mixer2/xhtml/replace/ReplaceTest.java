package org.mixer2.xhtml.replace;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Body;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.P;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 * @author jfut
 *
 */
public class ReplaceTest {

    private String templateFileName = "ReplaceTest.html";
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
     * idのないdivタグ内のコンテンツを別のdivタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceDivToOtherDiv() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
        assertEquals(0, html.getDescendants("new_div", Div.class).size());
        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        Div newDiv = new Div();
        newDiv.addCssClass("new_div");
        newDiv.getContent().add("content!");
        boolean result = html.replace(dummyDiv, newDiv);
        assertEquals(true, result);
        assertEquals(0, html.getDescendants("dummy", Div.class).size());
        assertEquals(1, html.getDescendants("new_div", Div.class).size());

        Div replacedDiv = html.getDescendants("new_div", Div.class).get(0);
        assertEquals("content!", replacedDiv.getContent().get(0));
    }

    /**
     * idのないdivタグ内のコンテンツを別のpタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceDivToP() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
        assertEquals(0, html.getDescendants("new_p", P.class).size());
        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        P newP = new P();
        newP.addCssClass("new_p");
        newP.getContent().add("content!");
        boolean result = html.replace(dummyDiv, newP);
        assertEquals(true, result);
        assertEquals(0, html.getDescendants("dummy", Div.class).size());
        assertEquals(1, html.getDescendants("new_p", P.class).size());

        P replacedP = html.getDescendants("new_p", P.class).get(0);
        assertEquals("content!", replacedP.getContent().get(0));
    }

    /**
     * idのないdivタグ内のコンテンツを親要素のbodyを起点に別のdivタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceDivFromBody() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants(Body.class).size());
        Body body = html.getDescendants(Body.class).get(0);
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
        assertEquals(0, html.getDescendants("new_div", Div.class).size());
        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        Div newDiv = new Div();
        newDiv.addCssClass("new_div");
        newDiv.getContent().add("content!");
        boolean result = body.replace(dummyDiv, newDiv);
        assertEquals(true, result);
        assertEquals(0, html.getDescendants("dummy", Div.class).size());
        assertEquals(1, html.getDescendants("new_div", Div.class).size());

        Div replacedDiv = html.getDescendants("new_div", Div.class).get(0);
        assertEquals("content!", replacedDiv.getContent().get(0));
    }

    /**
     * idのないdivタグ内のコンテンツを違う親要素のhtmlを起点に別のdivタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceFail() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
        assertEquals(0, html.getDescendants("new_div", Div.class).size());
        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        Html otherHtml = new Html();

        Div newDiv = new Div();
        newDiv.addCssClass("new_div");
        newDiv.getContent().add("content!");
        boolean result = otherHtml.replace(dummyDiv, newDiv);
        assertEquals(false, result);
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
        assertEquals(0, html.getDescendants("new_div", Div.class).size());
    }

}

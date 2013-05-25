package org.mixer2.xhtml.replace;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Body;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.P;
import org.mixer2.xhtml.Mixer2EngineSingleton;

/**
 * 
 * @author jfut
 * @author watanabe
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
     * idのないdivタグを別のdivタグで置換してみる
     * 
     * @throws Exception
     */
    @Test
    public void replaceDivToOtherDiv() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
        assertEquals(0, html.getDescendants("new_div", Div.class).size());

        Div newDiv = new Div();
        newDiv.addCssClass("new_div");
        newDiv.getContent().add("content!");
        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        boolean result = html.replace(dummyDiv, newDiv);
        
        assertEquals(true, result);
        assertEquals(0, html.getDescendants("dummy", Div.class).size());
        assertEquals(1, html.getDescendants("new_div", Div.class).size());

        Div replacedDiv = html.getDescendants("new_div", Div.class).get(0);
        assertEquals("content!", replacedDiv.getContent().get(0));
    }

    /**
     * idのないdivタグを別のpタグで置換してみる
     * @throws Exception
     */
    @Test
    public void replaceDivToP() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
        assertEquals(0, html.getDescendants("new_p", P.class).size());

        P newP = new P();
        newP.addCssClass("new_p");
        newP.getContent().add("content!");
        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        boolean result = html.replace(dummyDiv, newP);
        
        assertEquals(true, result);
        assertEquals(0, html.getDescendants("dummy", Div.class).size());
        assertEquals(1, html.getDescendants("new_p", P.class).size());

        P replacedP = html.getDescendants("new_p", P.class).get(0);
        assertEquals("content!", replacedP.getContent().get(0));
    }

    /**
     * idのないdivタグを親要素のbodyを起点に別のdivタグで置換してみる
     * @throws Exception
     */
    @Test
    public void replaceDivFromBody() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants(Body.class).size());
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
        assertEquals(0, html.getDescendants("new_div", Div.class).size());

        Div newDiv = new Div();
        newDiv.addCssClass("new_div");
        newDiv.getContent().add("content!");
        Body body = html.getBody();
        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        boolean result = body.replace(dummyDiv, newDiv);
        
        assertEquals(true, result);
        assertEquals(0, html.getDescendants("dummy", Div.class).size());
        assertEquals(1, html.getDescendants("new_div", Div.class).size());

        Div replacedDiv = html.getDescendants("new_div", Div.class).get(0);
        assertEquals("content!", replacedDiv.getContent().get(0));
    }

    /**
     * idのないdivタグを違う親要素のhtmlを起点に別のdivタグで置換してみる
     * @throws Exception
     */
    @Test
    public void replaceFail() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
        assertEquals(0, html.getDescendants("new_div", Div.class).size());

        Html otherHtml = new Html();

        Div newDiv = new Div();
        newDiv.addCssClass("new_div");
        newDiv.getContent().add("content!");
        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        boolean result = otherHtml.replace(dummyDiv, newDiv);
        
        assertEquals(false, result);
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
        assertEquals(0, html.getDescendants("new_div", Div.class).size());
    }

}

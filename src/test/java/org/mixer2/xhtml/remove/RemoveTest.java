package org.mixer2.xhtml.remove;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Body;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.xhtml.Mixer2EngineSingleton;

/**
 * 
 * @author jfut
 * @author watanabe
 */
public class RemoveTest {

    private String templateFileName = "RemoveTest.html";
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
     * idのないdivタグを削除してみる
     * 
     * @throws Exception
     */
    @Test
    public void removeDiv() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants("dummy", Div.class).size());

        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        boolean result = html.remove(dummyDiv);

        assertEquals(true, result);
        assertEquals(0, html.getDescendants("dummy", Div.class).size());
    }

    /**
     * idのないdivタグを親要素のbodyを起点に削除してみる
     * @throws Exception
     */
    @Test
    public void removeDivFromBody() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants(Body.class).size());
        assertEquals(1, html.getDescendants("dummy", Div.class).size());

        Body body = html.getBody();
        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        boolean result = body.remove(dummyDiv);

        assertEquals(true, result);
        assertEquals(0, html.getDescendants("dummy", Div.class).size());
    }

    /**
     * idのないdivタグを違う親要素のhtmlを起点に削除してみる
     * @throws Exception
     */
    @Test
    public void removeFail() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getDescendants("dummy", Div.class).size());

        Html otherHtml = new Html();

        Div dummyDiv = html.getDescendants("dummy", Div.class).get(0);

        boolean result = otherHtml.remove(dummyDiv);

        assertEquals(false, result);
        assertEquals(1, html.getDescendants("dummy", Div.class).size());
    }

}

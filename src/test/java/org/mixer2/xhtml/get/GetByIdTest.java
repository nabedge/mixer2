package org.mixer2.xhtml.get;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.B;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Li;
import org.mixer2.jaxb.xhtml.Pre;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.jaxb.xhtml.Strong;
import org.mixer2.jaxb.xhtml.Td;
import org.mixer2.jaxb.xhtml.Thead;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 *
 * @author watanabe
 *
 */
public class GetByIdTest {

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    private String templateFileName = "GetByIdTest.html";
    private String templateFilePath;
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
    public void testGetById() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        assertTrue(html.getById("div_a", Div.class).getContent().get(0).equals(
                "div_a"));
        assertTrue(html.getById("span2", Span.class).getContent().get(0)
                .equals("span2"));
        assertTrue(html.getById("bbb", B.class).getContent().get(1).equals(
                html.getById("span2", Span.class)));
        assertTrue(html.getById("href_google", A.class).getHref().equals(
                "http://www.google.com/"));
        assertTrue(html.getById("pre_a", Pre.class).getContent().get(0).equals(
                "pre_a"));

        Td td = html.getById("thead_a", Thead.class).getTr().get(0).getThOrTd()
                .get(0).cast(Td.class);
        assertTrue(td.getContent().get(0).equals("thead00"));

        assertTrue(html.getById("thead01", Td.class).getContent().get(0)
                .equals("thead01"));
        assertTrue(html.getById("ol_a_li01", Li.class).getContent().get(0)
                .equals("ol_a_li01"));
        assertTrue(html.getById("strong_a", Strong.class).getContent().get(0)
                .equals("XML!"));
    }

    /**
     * AbstractJaxbクラスで設定したダミーのgetId()メソッドでも
     * id属性をきちんと取得できるかどうかのテスト。
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void getByIdOnAbstractJaxb() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        List<AbstractJaxb> ajList = html.getDescendants("h_foo");
        assertEquals("h1", ajList.get(0).getId());
        assertEquals("h2", ajList.get(1).getId());
        assertEquals("h3", ajList.get(2).getId());
        assertEquals("h4", ajList.get(3).getId());
        assertEquals("h5", ajList.get(4).getId());
        assertEquals("h6", ajList.get(5).getId());
    }
}

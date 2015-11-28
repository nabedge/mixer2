package org.mixer2.xhtml.replace;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.TagCreator;

/**
 * 
 */
public class ReplaceInnerTest {

    @SuppressWarnings("unused")
    private Log log = LogFactory.getLog(ReplaceInnerTest.class);

    private String templateFileName = "ReplaceInnerTest.html";
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
        if (osname.indexOf("Windows") >= 0) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void test00() throws Exception {
        Div div = TagCreator.div();
        P p = TagCreator.p();
        p.getContent().add("foo");
        div.replaceInner(p.copy(P.class)); // *** using copy()
        p.getContent().add("bar");
        String result = m2e.saveToString(div);
        Assert.assertThat(result, is("<div><p>foo</p></div>"));
    }

    @Test
    public void test01() throws Exception {
        Div div = TagCreator.div();
        P p = TagCreator.p();
        p.getContent().add("foo");
        div.replaceInner(p); // *** without copy()
        p.getContent().add("bar");
        String result = m2e.saveToString(div);
        Assert.assertThat(result, is("<div><p>foo bar</p></div>"));
    }

    @Test
    public void testReplaceInnerByString() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Li li = html.getById("li_a", Li.class);
        li.replaceInner("foo");
        Html html2 = m2e.loadHtmlTemplate(m2e.saveToString(html));
        Li li2 = html2.getById("li_a", Li.class);
        Assert.assertTrue("foo".equals(li2.getContent().get(0).toString()));
    }

    @Test
    public void testReplaceInnerByTag() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Div div = html.getById("descTest", Div.class);
        P p = TagCreator.p();
        p.getContent().add("ppp");
        div.replaceInner(p);
        Html html2 = m2e.loadHtmlTemplate(m2e.saveToString(html));
        Div div2 = html2.getById("descTest", Div.class);
        Assert.assertTrue(div2.getContent().size() == 1);
        Assert.assertTrue(((P) div2.getContent().get(0)).getContent().get(0)
                .toString().equals("ppp"));
    }

    @Test
    public void testReplaceInnnerByList() throws Exception {

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        A a = html.getById("href_google", A.class);

        List<java.lang.Object> list = new ArrayList<java.lang.Object>();
        Span span = TagCreator.span();
        span.getContent().add("span1");
        B b = TagCreator.b();
        b.getContent().add("b1");
        list.addAll(Arrays.asList(span, "foo", b));

        a.replaceInner(list);

        Html html2 = m2e.loadHtmlTemplate(m2e.saveToString(html));
        A a2 = html2.getById("href_google", A.class);
        List<java.lang.Object> list2 = a2.getContent();

        Assert.assertTrue(list2.get(0) instanceof Span);
        Assert.assertTrue(((Span) list.get(0)).getContent().get(0)
                .equals("span1"));

        Assert.assertTrue(list2.get(1) instanceof String);
        Assert.assertTrue(list.get(1).toString().equals("foo"));

        Assert.assertTrue(list2.get(2) instanceof B);
        Assert.assertTrue(((B) list.get(2)).getContent().get(0).equals("b1"));
    }

    @Test
    public void testReplaceInnerByList_li() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Li li0 = TagCreator.li();
        Li li1 = TagCreator.li();
        Li li2 = TagCreator.li();
        li0.getContent().add("li0");
        li1.getContent().add("li1");
        li2.getContent().add("li2");
        List<Li> list =Arrays.asList(li0,li1,li2);
        Ol ol = html.getById("ol_a",Ol.class);
        ol.replaceInner(list);
        Assert.assertTrue(ol.getLi().size() == 3);
        Assert.assertTrue(ol.getLi().get(2).getContent().get(0) == "li2");
    }
}

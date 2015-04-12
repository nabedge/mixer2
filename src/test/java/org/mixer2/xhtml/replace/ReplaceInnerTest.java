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
import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.B;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Li;
import org.mixer2.jaxb.xhtml.P;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.jaxb.xhtml.Table;
import org.mixer2.jaxb.xhtml.Tr;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.TagCreator;
import org.mixer2.xhtml.builder.TableBuilder;

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

        List<Object> list = new ArrayList<java.lang.Object>();
        Span span = TagCreator.span();
        span.getContent().add("span1");
        B b = TagCreator.b();
        b.getContent().add("b1");
        list.addAll(Arrays.asList(span, "foo", b));

        a.replaceInner(list);

        Html html2 = m2e.loadHtmlTemplate(m2e.saveToString(html));
        A a2 = html2.getById("href_google", A.class);
        List<Object> list2 = a2.getContent();

        Assert.assertTrue(list2.get(0) instanceof Span);
        Assert.assertTrue(((Span) list.get(0)).getContent().get(0)
                .equals("span1"));

        Assert.assertTrue(list2.get(1) instanceof String);
        Assert.assertTrue(list.get(1).toString().equals("foo"));

        Assert.assertTrue(list2.get(2) instanceof B);
        Assert.assertTrue(((B) list.get(2)).getContent().get(0).equals("b1"));
    }
}

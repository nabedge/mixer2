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
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Li;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.jaxb.xhtml.Table;
import org.mixer2.jaxb.xhtml.Tbody;
import org.mixer2.jaxb.xhtml.Td;
import org.mixer2.jaxb.xhtml.Tr;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class GetDescendantsTest {

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    private String templateFileName = "GetDescendantsTest.html";
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
    public void getDescendants01() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        List<Span> spanList;

        spanList = html.getById("descTest", Div.class).getDescendants(
                Span.class);
        assertTrue(spanList.size() == 4);
        spanList = html.getDescendants("desc_foo", Span.class);
        assertTrue(spanList.size() == 2);
        assertTrue(spanList.get(0).getId().equals("desc_span01"));
        assertTrue(spanList.get(1).getContent().get(0).equals("bbb"));

    }

    @Test
    public void getDescendants02() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        List<AbstractJaxb> ajList;
        ajList = html.getById("descTest", Div.class).getDescendants("desc_bar");
        assertTrue(ajList.get(0).getClass().equals(Li.class));
        assertTrue(((Li) ajList.get(0)).getContent().get(0).equals(
                "desc_bar_li"));
        assertTrue(ajList.get(1).getClass().equals(A.class));
        assertTrue(((A) ajList.get(1)).getContent().get(0)
                .equals("example.com"));

        ajList = html.getById("descTest", Div.class).getDescendants(
                "desc_foo_2");
        assertEquals(ajList.size(), 3);
        assertTrue(ajList.get(0).getClass().equals(Tr.class));
        assertTrue(ajList.get(1).getClass().equals(Td.class));
        assertTrue(ajList.get(2).getClass().equals(Span.class));

    }

    @Test
    public void getDescendants_tbody() throws IOException,
            TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Table table = html.getById("tbl", Table.class);

        List<Tbody> tbodyList;

        tbodyList = table.getDescendants(Tbody.class);
        assertEquals(2, tbodyList.size());
        tbodyList = table.getDescendants("tbody_class_b", Tbody.class);
        assertEquals(1, tbodyList.size());

    }

}

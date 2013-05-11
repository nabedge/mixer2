package org.mixer2.xhtml.insert;

import static org.junit.Assert.assertEquals;
import static org.mixer2.xhtml.TagCreator.li;
import static org.mixer2.xhtml.TagCreator.td;
import static org.mixer2.xhtml.TagCreator.tr;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Li;
import org.mixer2.jaxb.xhtml.Ol;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.jaxb.xhtml.Table;
import org.mixer2.jaxb.xhtml.Td;
import org.mixer2.jaxb.xhtml.Tr;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 *
 * @author watanabe
 *
 */
public class InsertById01Test {

    private String templateFileName = "InsertByIdTest01.html";
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
     * olにliタグを挿入してみる
     */
    @Test
    public void liTest() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        List<Li> liList;
        Li li = li();
        li.setId("newli");
        li.getContent().add("aaa");

        liList = html.getById("ol1", Ol.class).getLi();
        assertEquals(2, liList.size());
        assertEquals("li1", liList.get(0).getId());
        assertEquals("li2", liList.get(1).getId());
        //
        html.insertAfterId("li1", li);
        // System.out.println(html.getById("ol1", Ol.class).toString());
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        //
        liList = html.getById("ol1", Ol.class).getLi();
        assertEquals(3, liList.size());
        assertEquals("li1", liList.get(0).getId());
        assertEquals("newli", liList.get(1).getId());
        assertEquals("li2", liList.get(2).getId());

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.insertBeforeId("li1", li);
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        liList = html.getById("ol1", Ol.class).getLi();
        assertEquals(3, liList.size());
        assertEquals("newli", liList.get(0).getId());
        assertEquals("li1", liList.get(1).getId());
        assertEquals("li2", liList.get(2).getId());

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.insertAfterId("li2", li);
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        liList = html.getById("ol1", Ol.class).getLi();
        assertEquals(3, liList.size());
        assertEquals("li1", liList.get(0).getId());
        assertEquals("li2", liList.get(1).getId());
        assertEquals("newli", liList.get(2).getId());

    }

    /**
     * 文字列を挿入してみる
     */
    @Test
    public void stringTest() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getById("test2div", Div.class).getContent().size());
        html.insertAfterId("test2span", "bar");
        // html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        assertEquals("test2span", ((Span) html.getById("test2div", Div.class)
                .getContent().get(0)).getId());
        assertEquals("bar", html.getById("test2div", Div.class).getContent()
                .get(1));

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(1, html.getById("test2div", Div.class).getContent().size());
        html.insertBeforeId("test2span", "bar");
        assertEquals("bar", html.getById("test2div", Div.class).getContent()
                .get(0));
        assertEquals("test2span", ((Span) html.getById("test2div", Div.class)
                .getContent().get(1)).getId());

    }

    @Test
    public void trtdTest() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Tr tr = tr();
        Td td = td();
        tr.setId("newtr");
        td.setId("newtd");
        td.getContent().add("bar");
        tr.getThOrTd().add(td);

        assertEquals(1, html.getById("trtdtest", Table.class).getTr().size());
        assertEquals("foo", html.getById("td1", Td.class).getContent().get(0));
        html.insertAfterId("tr1", tr.copy(Tr.class));
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        assertEquals(2, html.getById("trtdtest", Table.class).getTr().size());
        Td tmpTd = (Td) html.getById("trtdtest", Table.class).getTr().get(1)
                .getThOrTd().get(0);
        assertEquals("bar", ((String) tmpTd.getContent().get(0)).trim());

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.insertBeforeId("tr1", tr.copy(Tr.class));
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        assertEquals(2, html.getById("trtdtest", Table.class).getTr().size());
        Td tmpTd2 = (Td) html.getById("trtdtest", Table.class).getTr().get(0)
                .getThOrTd().get(0);
        assertEquals("bar", ((String) tmpTd2.getContent().get(0)).trim());

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.insertAfterId("td1", td);
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        assertEquals(1, html.getById("trtdtest", Table.class).getTr().size());
        assertEquals(2, html.getById("trtdtest", Table.class).getTr().get(0)
                .getThOrTd().size());
        Td tmpTd3;
        tmpTd3 = (Td) html.getById("trtdtest", Table.class).getTr().get(0)
                .getThOrTd().get(0);
        assertEquals("td1", tmpTd3.getId());
        tmpTd3 = (Td) html.getById("trtdtest", Table.class).getTr().get(0)
                .getThOrTd().get(1);
        assertEquals("newtd", tmpTd3.getId());

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.insertBeforeId("td1", td);
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        assertEquals(1, html.getById("trtdtest", Table.class).getTr().size());
        assertEquals(2, html.getById("trtdtest", Table.class).getTr().get(0)
                .getThOrTd().size());
        Td tmpTd4;
        tmpTd4 = (Td) html.getById("trtdtest", Table.class).getTr().get(0)
                .getThOrTd().get(1);
        assertEquals("td1", tmpTd4.getId());
        tmpTd4 = (Td) html.getById("trtdtest", Table.class).getTr().get(0)
                .getThOrTd().get(0);
        assertEquals("newtd", tmpTd4.getId());

    }

}

package org.mixer2.xhtml.replace;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mixer2.xhtml.TagCreator.li;
import static org.mixer2.xhtml.TagCreator.span;
import static org.mixer2.xhtml.TagCreator.td;
import static org.mixer2.xhtml.TagCreator.tr;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.TagCreator;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 * @author watanabe
 *
 */
public class ReplaceByIdTest {

    private String templateFileName = "ReplaceByIdTest.html";
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
    
    @Test
    public void style() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertNotNull(html.getById("style1", Style.class));
        Style style = TagCreator.styleWithId("style2");
        style.setType("text/css");
        style.setContent("foobar { color:red; }");
        html.replaceById("style1", style);
        assertNull(html.getById("style1", Style.class));
        assertNotNull(html.getById("style2", Style.class));
    }
    
    @Test
    public void script() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertNotNull(html.getById("fooScript", Script.class));
        
        Script barScript = TagCreator.scriptWithId("barScript");
        barScript.setSrc("bar.js");
        barScript.setType("text/javascript");

        html.replaceById("fooScript", barScript);
        assertNull(html.getById("fooScript", Script.class));
        assertNotNull(html.getById("barScript", Script.class));
    }

    @Test
    public void testReplaceById_tbody() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        Tbody tbody = TagCreator.tbody();
        Tr tr = TagCreator.tr();
        Td td = TagCreator.td();
        td.setId("td_hoge");
        td.getContent().add("foobar");
        tr.getThOrTd().add(td);
        tbody.getTr().add(tr);

        assertNotNull(html.getById("tbody_dummy", Tbody.class));
        html.replaceById("tbody_dummy", tbody);
        assertNull(html.getById("tbody_dummy", Tbody.class));
        assertNotNull(html.getById("td_hoge", Td.class));
    }

    @Test
    public void testReplaceById() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        Span span = span();
        span.setId("hellospan");
        span.getContent().add("hello");
        assertNotNull(html.getById("hellomsg", Div.class));
        html.replaceById("hellomsg", span);
        assertNull(html.getById("hellomsg", Div.class));
        assertTrue(((Span) html.getBody().getContent().get(0)).getId().equals(
                "hellospan"));

        Li li = li();
        li.setId("newli");
        li.getContent().add("new li!");
        assertNotNull(html.getById("ol_a_li02", Li.class));
        try {
            html.replaceById("ol_a_li02", span);
            fail("liが入るべきところにspanを入れているためExceptionが発生するはず");
        } catch (TagTypeUnmatchException e) {
            //
        }
        html.replaceById("ol_a_li02", li);
        assertNull(html.getById("ol_a_li02", Li.class));
        assertTrue(html.getById("ol_a", Ol.class).getLi().get(1).getId()
                .equals("newli"));

        Td td1 = td();
        td1.setId("newtd1");
        td1.getContent().add("new td 1");
        Tr tr = tr();
        tr.getThOrTd().add(td1);
        assertNotNull(html.getById("tr_dummy", Tr.class));
        html.getById("tbl", Table.class).getTbody().get(1).unsetTr();
        html.getById("tbl", Table.class).getTbody().get(1).getTr().add(tr);
        assertNull(html.getById("tr_dummy", Tr.class));
        assertNotNull(html.getById("tbl", Table.class).getTbody().get(1)
                .getTr().get(0).getById("newtd1", Td.class));

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.replaceById("hellomsg", "replacedByString");
        assertTrue(((String) html.getBody().getContent().get(0))
                .startsWith("replacedByString"));
    }

}

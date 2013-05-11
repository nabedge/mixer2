package org.mixer2.xhtml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Dd;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class UnsetId01Test {

    private String templateFileName = "UnsetIdTest01.html";
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
    public void getIdTest() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        List<AbstractJaxb> ajList = html.getDescendants("idtest");
        assertEquals("h1", ajList.get(0).getId());
        assertEquals("h2", ajList.get(1).getId());
    }

    @Test
    public void setIdTest() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        List<AbstractJaxb> ajList;
        ajList = html.getDescendants("idtest");
        ajList.get(2).setId("h3set");
        ajList.get(3).setId("h4set");
        ajList.get(4).setId(null);
        html = m2e.loadHtmlTemplate(m2e.saveToString(html));
        ajList = html.getDescendants("idtest");
        assertEquals(6, ajList.size());
        assertEquals("h1", ajList.get(0).getId());
        assertEquals("h2", ajList.get(1).getId());
        assertEquals("h3set", ajList.get(2).getId());
        assertEquals("h4set", ajList.get(3).getId());
        assertEquals(null, ajList.get(4).getId());
        assertEquals("h6", ajList.get(5).getId());

        // isSetId()
        assertEquals(false, ajList.get(4).isSetId());
        assertEquals(true, ajList.get(5).isSetId());
    }

    @Test
    public void unsetIdTest01() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Div div = html.getById("unsettest01");
        List<Dd> ddList;
        ddList = div.getDescendants(Dd.class);
        assertEquals("unsettest01_dd01", ddList.get(0).getId());
        assertEquals("unsettest01_dd02", ddList.get(1).getId());
        div.unsetAllId();
        ddList = div.getDescendants(Dd.class);
        assertNull(ddList.get(0).getId());
        assertNull(ddList.get(1).getId());
    }

}

package org.mixer2.xhtml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Dd;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class UnsetId02Test {

    private String templateFileName = "UnsetIdTest02.html";
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
    public void unsetIdTest_dl_dd() throws IOException, TagTypeUnmatchException {
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

    @Test
    public void unsetIdpatternTest_dl_dd() throws IOException,
            TagTypeUnmatchException {
        List<Dd> ddList;
        Pattern pattern;
        Div div;

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        div = html.getById("unsettest01");
        ddList = div.getDescendants(Dd.class);
        assertEquals("unsettest01_dd01", ddList.get(0).getId());
        assertEquals("unsettest01_dd02", ddList.get(1).getId());
        pattern = Pattern.compile("^unsettest01_.+$");
        div.unsetAllId(pattern);
        ddList = div.getDescendants(Dd.class);
        assertNull(ddList.get(0).getId());
        assertNull(ddList.get(1).getId());

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        div = html.getById("unsettest01");
        ddList = div.getDescendants(Dd.class);
        pattern = Pattern.compile("^foo$");
        div.unsetAllId(pattern);
        ddList = div.getDescendants(Dd.class);
        assertEquals("unsettest01_dd01", ddList.get(0).getId());
        assertEquals("unsettest01_dd02", ddList.get(1).getId());

    }

}

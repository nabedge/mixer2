package org.mixer2.xhtml.get;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Form;
import org.mixer2.jaxb.xhtml.H6;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Option;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.jaxb.xhtml.Strong;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class GetDescendants02Test {

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    private String templateFileName = "GetDescendantsTest02.html";
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
    public void getDescendants02() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        List<AbstractJaxb> ajList;

        ajList = html.getById("div1", Div.class).getDescendants("foo");
        assertEquals(6, ajList.size());
        assertEquals(H6.class, ajList.get(5).getClass());
        H6 h6 = (H6) ajList.get(5);
        assertEquals(2, h6.getDescendants("bar").size());
        assertEquals(1, h6.getDescendants("bar", Span.class).size());
        assertEquals(1, h6.getDescendants("bar", Strong.class).size());

        List<Form> formList;
        formList = html.getDescendants(Form.class);
        assertEquals(2, formList.size());

        formList = html.getDescendants("bar", Form.class);
        assertEquals(1, formList.size());
        assertEquals("form2", ((Form) formList.get(0)).getId());

        ajList = html.getById("div2", Div.class).getDescendants("bar");
        assertEquals(3, ajList.size());
        assertEquals(Div.class, ajList.get(0).getClass());
        assertEquals("div2", ((Div) ajList.get(0)).getId());
        assertEquals(Option.class, ajList.get(1).getClass());
        assertEquals("option2", ((Option) ajList.get(1)).getId());
        assertEquals(Form.class, ajList.get(2).getClass());
        assertEquals("form2", ((Form) ajList.get(2)).getId());
    }
}

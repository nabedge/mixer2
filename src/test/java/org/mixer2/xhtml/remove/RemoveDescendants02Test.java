package org.mixer2.xhtml.remove;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Dd;
import org.mixer2.jaxb.xhtml.Dt;
import org.mixer2.jaxb.xhtml.H1;
import org.mixer2.jaxb.xhtml.H2;
import org.mixer2.jaxb.xhtml.H3;
import org.mixer2.jaxb.xhtml.H4;
import org.mixer2.jaxb.xhtml.H5;
import org.mixer2.jaxb.xhtml.H6;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Img;
import org.mixer2.jaxb.xhtml.Li;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class RemoveDescendants02Test {

    private String templateFileName = "RemoveDescendantsTest02.html";
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
    public void testRemoveDescendants() throws IOException,
            TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));

        Html html01 = html.copy(Html.class);
        assertNotNull(html01.getById("dd1", Dd.class));
        assertNotNull(html01.getById("dd2", Dd.class));
        html01.removeDescendants(Dd.class);
        assertNull(html01.getById("dd1", Dd.class));
        assertNull(html01.getById("dd2", Dd.class));

        Html html02 = html.copy(Html.class);
        assertNotNull(html02.getById("dd1", Dd.class));
        assertNotNull(html02.getById("dd2", Dd.class));
        html02.removeDescendants("foo", Dd.class);
        assertNull(html02.getById("dd1", Dd.class));
        assertNotNull(html02.getById("dd2", Dd.class));

        Html html03 = html.copy(Html.class);
        assertNotNull(html03.getById("li1", Li.class));
        assertNotNull(html03.getById("li2", Li.class));
        assertNotNull(html03.getById("li3", Li.class));
        assertNotNull(html03.getById("li4", Li.class));
        assertNotNull(html03.getById("img1", Img.class));
        assertNotNull(html03.getById("img2", Img.class));
        assertNotNull(html03.getById("h1", H1.class));
        assertNotNull(html03.getById("h2", H2.class));
        assertNotNull(html03.getById("h3", H3.class));
        assertNotNull(html03.getById("h4", H4.class));
        assertNotNull(html03.getById("h5", H5.class));
        assertNotNull(html03.getById("h6", H6.class));
        assertNotNull(html03.getById("dt1", Dt.class));
        assertNotNull(html03.getById("dd1", Dd.class));
        assertNotNull(html03.getById("dd2", Dd.class));
        html03.removeDescendants("bar");
        assertNotNull(html03.getById("li1", Li.class));
        assertNull(html03.getById("li2", Li.class));
        assertNotNull(html03.getById("li3", Li.class));
        assertNull(html03.getById("li4", Li.class));
        assertNotNull(html03.getById("img1", Img.class));
        assertNull(html03.getById("img2", Img.class));
        assertNotNull(html03.getById("h1", H1.class));
        assertNotNull(html03.getById("h2", H2.class));
        assertNotNull(html03.getById("h3", H3.class));
        assertNotNull(html03.getById("h4", H4.class));
        assertNotNull(html03.getById("h5", H5.class));
        assertNull(html03.getById("h6", H6.class));
        assertNotNull(html03.getById("dt1", Dt.class));
        assertNotNull(html03.getById("dd1", Dd.class));
        assertNull(html03.getById("dd2", Dd.class));

    }
}

package org.mixer2.xhtml;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.lang.SystemUtils;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;

public class ToStringTest {

    private String templateFileName = "HelloWorld.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @Before
    public void init() throws Exception {
        templateFilePath = getClass().getResource(templateFileName).toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void test() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertEquals(-1, html.toString().indexOf("=<null>"));
        // System.out.println(html.toString());
    }

}

package org.mixer2.xhtml;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;

/**
 * @author watanabe
 *
 */
public class CdataTest {

    private String templateFileName = "CdataTest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = new Mixer2Engine();
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
    public void test() throws IOException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        // System.out.println(html.getHead().toString());
        // StringWriter sw = new StringWriter();
        // sw = m2e.save(html, sw);
        // System.out.println(sw.toString());
        // System.out.println(m2e.saveToString(html));
        m2e.saveToString(html);
    }

}

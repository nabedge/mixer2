package org.mixer2.xhtml;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;

@Ignore("ignore for issue0004 ")
public class MarshalAndUnmarshalTest {

    private String templateFileName = "sample-xhtml1-transitional.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Before
    public void init() throws Exception {
        templateFilePath = getClass().getResource(templateFileName).toString();
        String osname = System.getProperty("os.name");
        if(osname.indexOf("Windows")>=0){
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void getSame() throws Exception{
        String original = FileUtils.readFileToString(new File(templateFilePath));
        Html html1 = m2e.loadHtmlTemplate(original);
        String str1 = m2e.saveToString(html1);
        Html html2 = m2e.loadHtmlTemplate(str1);
        String str2 = m2e.saveToString(html2);
        assertEquals(str1, str2);
    }

}

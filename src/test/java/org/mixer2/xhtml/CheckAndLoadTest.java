package org.mixer2.xhtml;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.SystemUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.exception.Mixer2JAXBException;

public class CheckAndLoadTest {

    private String templateFileName = "invalid-xhtml.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Before
    public void init() throws Exception {
        templateFilePath = getClass().getResource(templateFileName).toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test(expected = Mixer2JAXBException.class)
    public void exceptionThrowTest() throws Exception {
        m2e.checkAndLoadHtmlTemplate(new File(templateFilePath));
    }

    @Test
    public void getSAXParseExceptionTest() {
        try {
            m2e.checkAndLoadHtmlTemplate(new File(templateFilePath));
        } catch (Mixer2JAXBException e) {
            // System.out.println("###");
            // e.getCause().getCause().printStackTrace();
            // System.out.println("###");
            assertNotNull(e.getSAXParseException());
            assertNotNull(e.getSAXParseExceptionMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

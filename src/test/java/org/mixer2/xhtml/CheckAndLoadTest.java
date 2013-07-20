package org.mixer2.xhtml;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.UnmarshalException;

import org.apache.commons.lang.SystemUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.xhtml.exception.Mixer2JAXBException;

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

    @Ignore
    @Test(expected = Mixer2JAXBException.class)
    public void exceptionThrowTest() throws Exception {
        m2e.checkAndLoadHtmlTemplate(new File(templateFilePath));
    }

    @Ignore
    @Test
    public void getMsgFromException() {
        try {
            m2e.checkAndLoadHtmlTemplate(new File(templateFilePath));
        } catch (Mixer2JAXBException e) {
            //e.printStackTrace();
            Throwable linkedException = e.getLinkedException();
            if (linkedException instanceof javax.xml.bind.UnmarshalException) {
                UnmarshalException ue = (UnmarshalException) linkedException;
                linkedException = ue.getLinkedException();
                if (linkedException instanceof org.xml.sax.SAXParseException) {
                    String msg = linkedException.getMessage();
                    System.out.println(msg + "\n");
                    linkedException.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}

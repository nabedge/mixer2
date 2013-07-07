package org.mixer2.xhtml;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.P;

public class Dummy {

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    
    private static Log log = LogFactory.getLog(Dummy.class);

    @AfterClass
    public static void afterClass() {
    }

    @Before
    public void init() throws IOException {
    }

    @Test
    public void helloWorld_html5() throws Exception {
        String templateFileName = "HelloWorld_html5.html";
        String templateFilePath = getClass().getResource(templateFileName)
                .toString();
        String osname = System.getProperty("os.name");
        if (osname.indexOf("Windows") >= 0) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        P p = html.getById("hellomsg", P.class);
        p.unsetContent();
        p.getContent().add("Hello World !");
        log.info(m2e.saveToString(html));
        p.setData("foodata", "bardata");
        p.setAria("fooaria", "bararia");
        p.setId("fooId");
        html.setData("xxx","yyy");
        p.setOnclick("fooOnClick");
        log.info(m2e.saveToString(html));
        log.info(m2e.saveToString(html.copy(Html.class)));
        
    }

}

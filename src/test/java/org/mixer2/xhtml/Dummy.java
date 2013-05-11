package org.mixer2.xhtml;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Meta;
import org.mixer2.jaxb.xhtml.P;

import static org.mixer2.xhtml.TagCreator.*;

@SuppressWarnings("unused")
public class Dummy {

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

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
        html.getById("hellomsg", P.class).getContent().clear();
        html.getById("hellomsg", P.class).getContent().add("Hello World !");
        System.out.println(m2e.saveToString(html));
    }

//    @Test
//    public void dummy01() throws Exception {
//        Div div = new Div();
//        AbstractJaxb aj = (AbstractJaxb) div;
//        System.out.println("div: " + div.getClass().getSimpleName());
//        System.out.println("aj: " + aj.getClass().getSimpleName());
//    }

}

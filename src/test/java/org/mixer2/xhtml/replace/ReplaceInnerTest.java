package org.mixer2.xhtml.replace;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.B;
import org.mixer2.jaxb.xhtml.Body;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.P;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.TagCreator;

/**
 * 
 */
public class ReplaceInnerTest {

    private Log log = LogFactory.getLog(ReplaceInnerTest.class);
    
    private String templateFileName = "ReplaceInnerTest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    private Html html;

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
    public void test1() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        A a = html.getById("href_google", A.class);
        List<Object> list = new ArrayList<java.lang.Object>();
        Span span = TagCreator.span();
        span.getContent().add("span1");
        B b = TagCreator.b();
        b.getContent().add("b1");
        list.addAll(Arrays.asList(span,"foo",b));
        a.replaceInner(list);
        log.info(m2e.saveToString(a));
        // TODO assert
    }

}

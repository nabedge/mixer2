package org.mixer2.xhtml;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Script;

public class PreAndScriptTest {

    private static Log log = LogFactory.getLog(PreAndScriptTest.class);
    private String templateFileName = "preAndScript.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    private Html html;

    @Before
    public void init() throws IOException {
        templateFilePath = getClass().getResource(templateFileName).toString();
        if(SystemUtils.IS_OS_WINDOWS){
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }
    
    @Test
    public void createNewScript() throws Exception {
        Script script = TagCreator.script();
        script.setType("text/javascript");
        script.setSrc("foo.js");
        //script.setContent("");
        String str = m2e.saveToString(script);
        // if error, NullPointerException !
        log.info(str);
    }
    

    @Test
    public void test() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        String xmlStr = m2e.saveToString(html);
        //log.info(xmlStr);
        Document doc = Jsoup.parse(xmlStr);
        assertThat(doc.getElementById("fooJs").data(), is(" "));
    }

    @Test
    public void test2() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        String xmlStr = m2e.saveToString(html);
        assertTrue(xmlStr.contains("//<![CDATA["));
        assertTrue(xmlStr.contains("if (foo > 0 || bar < 100) {"));
        assertTrue(xmlStr.contains("//]]>"));
    }
    
}

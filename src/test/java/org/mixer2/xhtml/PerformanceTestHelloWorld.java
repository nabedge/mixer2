package org.mixer2.xhtml;

import java.io.File;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class PerformanceTestHelloWorld {

    private int loop = 10000;

    private VelocityEngine velocityEngine = new VelocityEngine();
    private Template velocityTemplate;
    private static Mixer2Engine m2e = new Mixer2Engine();
    private static Log log = LogFactory.getLog(PerformanceTestHelloWorld.class);
    private Html html;
    private Document jsoupDocument;

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Before
    public void init() throws Exception {

        // /// for velocity
        Properties p = new Properties();
        p.setProperty("file.resource.loader.path", "");
        p.setProperty("runtime.log.logsystem.class",
                "org.apache.velocity.runtime.log.NullLogSystem");
        velocityEngine.init(p);
        String osname = System.getProperty("os.name");

        String velocityTemplatePath = getClass().getResource(
                "PerformanceTestHelloWorld.vm").toString();
        if (osname.indexOf("Windows") >= 0) {
            velocityTemplatePath = velocityTemplatePath.replaceFirst("file:/",
                    "");
        } else {
            velocityTemplatePath = velocityTemplatePath.replaceFirst("file:",
                    "");
        }
        velocityTemplate = velocityEngine.getTemplate(velocityTemplatePath);

        // //// for mixer2
        String mixer2TemplatePath = getClass()
                .getResource("PerformanceTestHelloWorld.html").toString()
                .replaceFirst("file:/", "");

        if (osname.indexOf("Windows") >= 0) {
            mixer2TemplatePath = mixer2TemplatePath.replaceFirst("file:/", "");
        } else {
            mixer2TemplatePath = mixer2TemplatePath.replaceFirst("file:", "");
        }
        html = m2e.loadHtmlTemplate(new File(mixer2TemplatePath));

        // for jsoup
        jsoupDocument = Jsoup.parse(new File(mixer2TemplatePath), "UTF-8");
    }

    @Test
    public void helloWorldByMixer2() throws TagTypeUnmatchException {
        long start = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            html.getById("hellomsg", Div.class).unsetContent();
            html.getById("hellomsg", Div.class).getContent()
                    .add("Hello World ! " + i);
            StringWriter sw = new StringWriter();
            m2e.saveToStringWriter(html, sw);
            // System.out.println(sw.toString());
        }
        long end = System.nanoTime();
        long time = (end - start) / 1000000;
        log.info("HelloWorldByJsoup, loop=" + loop + ", milliTime= " + time);
    }

    @Test
    public void helloWorldByVelocity() throws Exception {
        long start = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            VelocityContext context = new VelocityContext();
            context.put("hellomsg", "Hello World ! " + i);
            StringWriter sw = new StringWriter();
            velocityTemplate.merge(context, sw);
            // System.out.println(sw.toString());
        }
        long end = System.nanoTime();
        long time = (end - start) / 1000000;
        log.info("HelloWorldByJsoup, loop=" + loop + ", milliTime= " + time);
    }

    @Test
    public void helloWorldByJsoup() {
        long start = System.nanoTime();
        for (int i = 0; i < loop; i++) {
            jsoupDocument.getElementById("hellomsg").text("Hello World !");
        }
        long end = System.nanoTime();
        long time = (end - start) / 1000000;
        log.info("HelloWorldByJsoup, loop=" + loop + ", milliTime= " + time);
    }

}

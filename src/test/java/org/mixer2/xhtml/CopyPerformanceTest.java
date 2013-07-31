package org.mixer2.xhtml;

import java.io.File;

import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Meta;


public class CopyPerformanceTest {

    private static Log log = LogFactory.getLog(CopyPerformanceTest.class);
    private String templateFileName = "sample-xhtml1-transitional.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    private int loop = 1000;

    @BeforeClass
    public static void beforeClass() {
    }

    @Before
    public void before() {
        templateFilePath = getClass().getResource(templateFileName).toString();
        String osname = System.getProperty("os.name");
        if(osname.indexOf("Windows")>=0){
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test()
    public void wholeHtmlCopy() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        @SuppressWarnings("unused")
		Html tmp = null;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0; i<loop; i++) {
            tmp = html.copy(Html.class);
        }
        stopWatch.stop();
        log.info("whale html: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
    }

    @Test()
    public void smallTagCopy() throws Exception {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Meta tmp = html.getById("meta-content-type", Meta.class);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0; i<loop; i++) {
            tmp = tmp.copy(Meta.class);
        }
        stopWatch.stop();
        log.info(" small tag: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
    }

}

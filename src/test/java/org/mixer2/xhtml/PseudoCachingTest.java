package org.mixer2.xhtml;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;


public class PseudoCachingTest {

    private static Log log = LogFactory.getLog(PseudoCachingTest.class);
    private String templateFileName = "sample-xhtml1-transitional.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    private int loop = 1000;
    private ConcurrentHashMap<String, Html> cacheMap = new ConcurrentHashMap<String,Html>();
    
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

    private Html loadHtmlTemplateThroughCache(String templateFilePath) throws Exception {
        Html html = cacheMap.get(templateFilePath);
        if (html == null) {
            html = m2e.loadHtmlTemplate(new File(templateFilePath));
            cacheMap.putIfAbsent(templateFilePath, html.copy(Html.class));
        }
    	return html.copy(Html.class);
    }
    
    @Test
    public void assertSame() throws Exception{
        Html html1 = loadHtmlTemplateThroughCache(templateFilePath);
        Html html2 = m2e.loadHtmlTemplate(new File(templateFilePath));
    	Assert.assertEquals(m2e.saveToString(html1), m2e.saveToString(html2));
    }

    @Test
    public void loopWithCache() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0; i<loop; i++) {
            loadHtmlTemplateThroughCache(templateFilePath);
        }
        stopWatch.stop();
        log.info("using cache: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
    }

    @Test
    public void loopWithoutCache() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        File file;
        for (int i=0; i<loop; i++) {
            file = new File(templateFilePath);
            m2e.loadHtmlTemplate(file);
        }
        stopWatch.stop();
        log.info("   no cache: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
    }
}

package org.mixer2.xhtml;

import java.io.File;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;


public class PseudoCachingTest {

    private String templateFileName = "sample-xhtml1-transitional.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    private int loop = 1000;
    private Html cachedHtml = null;
    
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
    	if (cachedHtml == null) {
            cachedHtml = m2e.loadHtmlTemplate(new File(templateFilePath));
    	}
    	Html result = null;
        result = cachedHtml.copy(Html.class);
    	return result;
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
        System.out.println("using cache: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
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
        System.out.println("   no cache: loop= " + loop + ", time(msec)= " + stopWatch.getTime());
    }
}

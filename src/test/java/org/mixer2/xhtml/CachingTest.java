package org.mixer2.xhtml;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;


public class CachingTest {

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

    private Html loadHtmlTemplateThroughCache(String templateFilePath) throws IOException {
    	if (cachedHtml == null) {
            cachedHtml = m2e.loadHtmlTemplate(new File(templateFilePath));
    	}
    	Html result = null;
    	try {
			result = cachedHtml.copy(Html.class);
		} catch (TagTypeUnmatchException e) {
			e.printStackTrace();
		}
    	return result;
    }

    @Test
    public void loopWithCache() throws IOException {
        for (int i=0; i<loop; i++) {
            loadHtmlTemplateThroughCache(templateFilePath);
        }
    }

    @Test
    public void loopWithoutCache() throws IOException {
        File file;
        for (int i=0; i<loop; i++) {
            file = new File(templateFilePath);
            m2e.loadHtmlTemplate(file);
        }
    }
}

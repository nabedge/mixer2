package org.mixer2.xhtml;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.cache.Cache;
import javax.cache.CacheBuilder;
import javax.cache.CacheManager;
import javax.cache.Caching;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;


public class CachingTest {

    private String templateFileName = "sample-html5.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = new Mixer2Engine();

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Before
    public void init() throws IOException {
        CacheManager cacheManager = Caching.getCacheManager();
        CacheBuilder<String,Html> cacheBuilder = cacheManager.createCacheBuilder("org.mixer2.jaxb.xhtml");
        Cache<String, Html> cache = cacheBuilder.build();
        m2e.setCache(cache);
        templateFilePath = getClass().getResource(templateFileName).toString();
        String osname = System.getProperty("os.name");
        if(osname.indexOf("Windows")>=0){
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void test01() throws IOException {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Html html2;
        // create cache
        m2e.loadHtmlTemplateThroughCache(new File(templateFilePath));
        // get from cache
        html2 = m2e.loadHtmlTemplateThroughCache(new File(templateFilePath));
        assertEquals(m2e.saveToString(html), m2e.saveToString(html2));
    }

}

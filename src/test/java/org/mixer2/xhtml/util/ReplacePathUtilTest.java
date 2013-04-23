package org.mixer2.xhtml.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.util.regex.Pattern;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Link;
import org.mixer2.jaxb.xhtml.Script;

public class ReplacePathUtilTest extends ReplacePathUtil {

    private String templateFileName = "ReplacePathUtilTest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = new Mixer2Engine();
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
    public void testReplacePath() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        ReplacePathUtil.replacePath(html, Pattern.compile("^.*/foo/bar/"), "/ctx/foobar/");
        assertThat(html.getById("link01", Link.class).getHref(), is("/ctx/foobar/foo.css"));
        assertThat(html.getById("script01", Script.class).getSrc(), is("/ctx/foobar/foo.js"));
    }

}

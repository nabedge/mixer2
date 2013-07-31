package org.mixer2.xhtml;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.lang.SystemUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Meta;

public class SampleHtml5 {
    private String templateFileName = "sample-html5.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @Before
    public void init() throws Exception {
        templateFilePath = getClass().getResource(templateFileName).toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void copyTest() throws Exception {
        InputStream in = new FileInputStream(templateFilePath);
        Html html = m2e.loadHtmlTemplate(in);
        Html html2 = html.copy(Html.class);
        assertEquals(m2e.saveToString(html), m2e.saveToString(html2));
    }

    @Test
    public void test() throws Exception {
        InputStream in = new FileInputStream(templateFilePath);
        Html html = m2e.loadHtmlTemplate(in);
        assertNotNull(html.getById("summary1"));
        assertNotNull(html.getById("output1"));
        assertNotNull(html.getById("canvas1"));
        assertNotNull(html.getById("audio1"));
        assertNotNull(html.getById("abbr1"));
        assertNotNull(html.getById("time1"));
        assertNotNull(html.getById("mark1"));
        assertNotNull(html.getById("meter1"));
        assertNotNull(html.getById("progress1"));
        assertNotNull(html.getById("ruby1"));
        assertNotNull(html.getById("rt2"));

        // open graph meta tag
        Meta meta = html.getHead().getById("metaWithProperty", Meta.class);
        Assert.assertThat(meta.getProperty(), is("og:title"));
        Assert.assertThat(meta.getContent(), is("sample page"));
    }

    @Test
    public void emptyTagTest() throws Exception {
        InputStream in = new FileInputStream(templateFilePath);
        Html html = m2e.loadHtmlTemplate(in);
        String str = m2e.saveToString(html);
        //System.out.println(str);
        assertTrue(str.contains("<meta charset=\"utf-8\"/>"));
        assertTrue(str.contains("<br id=\"dummy_br\"/>"));
    }
}

package org.mixer2.xhtml;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Meta;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class SampleHtml5 {
    private String templateFileName = "sample-html5.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = new Mixer2Engine();

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Before
    public void init() throws IOException {
        templateFilePath = getClass().getResource(templateFileName).toString();
        String osname = System.getProperty("os.name");
        if(osname.indexOf("Windows")>=0){
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void test() throws IOException, TagTypeUnmatchException,
            JAXBException {
        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));
//        System.out.println(m2e.saveToString(html));

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
        Meta meta = html.getHead().getById("metaWithProperty",Meta.class);
        Assert.assertThat(meta.getProperty(), is("og:title"));
        Assert.assertThat(meta.getContent(), is("sample page"));

    }

}

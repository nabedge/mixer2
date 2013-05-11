package org.mixer2.xhtml.get;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Article;
import org.mixer2.jaxb.xhtml.Audio;
import org.mixer2.jaxb.xhtml.Br;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Meter;
import org.mixer2.jaxb.xhtml.P;
import org.mixer2.jaxb.xhtml.Progress;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.jaxb.xhtml.Track;
import org.mixer2.jaxb.xhtml.Video;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 *
 * @author watanabe
 *
 */
public class GetById_html5Test  {

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    private String templateFileName = "GetByIdTest_html5.html";
    private String templateFilePath;
    private Html html;

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
    public void testGetById() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
//        System.out.println(html.toString());

        assertNotNull(html.getById("dummy_br", Br.class));
        assertEquals("paragraph 5", html.getById("p5",P.class).getContent().get(0));
        assertEquals("paragraph 5", html.getById("article2",Article.class).getById("p5",P.class).getContent().get(0));
        assertEquals("autoplay",html.getById("video1", Video.class).getAutoplay());
        assertEquals("brave.ja.vtt",html.getById("track1",Track.class).getSrc());
        assertEquals("audio1.src", html.getById("audio1", Audio.class).getSrc());

        Progress progress1 = html.getById("progress1", Progress.class);
        assertEquals("0", ((Span) progress1.getContent().get(0)).getContent().get(0));
        assertEquals("%", progress1.getContent().get(1));

//        System.out.println(m2e.saveToString(html));
        assertEquals("8", html.getById("meter1", Meter.class).getMax());
    }

}

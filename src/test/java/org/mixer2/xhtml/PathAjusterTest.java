package org.mixer2.xhtml;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.Form;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Iframe;
import org.mixer2.jaxb.xhtml.Img;
import org.mixer2.jaxb.xhtml.Link;
import org.mixer2.jaxb.xhtml.Script;
import org.mixer2.jaxb.xhtml.Track;

public class PathAjusterTest {

    private String templateFileName = "PathAjusterTest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
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
        PathAdjuster.replacePath(html, Pattern.compile("^.*/foo/bar/"), "/ctx/foobar/");
        assertThat(html.getById("link01", Link.class).getHref(), is("/ctx/foobar/foo.css"));
        assertThat(html.getById("script01", Script.class).getSrc(), is("/ctx/foobar/foo.js"));
    }

    @Test
    public void testReplacePathIncludesClass() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        List<String> clazz = new ArrayList<String>();
        clazz.add("foo");
        PathAdjuster.replacePathIncludeClass(html, Pattern.compile("^.*$"), "zzz", clazz);
        assertThat(html.getById("track1",Track.class).getSrc(), is("zzz"));
        assertThat(html.getById("track2",Track.class).getSrc(), not("zzz"));
    }

    @Test
    public void testReplacePathIncludesTag() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        List<Class<?>> tagTypes = new ArrayList<Class<?>>();
        tagTypes.add(A.class);
        tagTypes.add(Form.class);
        PathAdjuster.replacePathIncludeTag(html, Pattern.compile(".*"), "zzz", tagTypes);
        assertThat(html.getById("track1", Track.class).getSrc(), not("zzz"));
        assertThat(html.getById("a_001", A.class).getHref(), is("zzz"));
        assertThat(html.getById("form01", Form.class).getAction(), is("zzz"));
    }

    @Test
    public void testReplacePathInclude() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        List<String> clazz = new ArrayList<String>();
        clazz.add("bar");
        List<Class<?>> tagTypes = new ArrayList<Class<?>>();
        tagTypes.add(Img.class);
        tagTypes.add(Iframe.class);
        PathAdjuster.replacePathInclude(html, Pattern.compile(".*"), "zzz", clazz, tagTypes);

        assertThat(html.getById("img_01", Img.class).getSrc(), is("xyz"));
        assertThat(html.getById("img_02", Img.class).getSrc(), is("zzz"));
        assertThat(html.getById("iframe_01", Iframe.class).getSrc(), is("zzz"));
        assertThat(html.getById("iframe_02", Iframe.class).getSrc(), is("example.html"));
    }

    @Test
    public void testReplacePathExcludeClass() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        List<String> clazz = new ArrayList<String>();
        clazz.add("foo");
        PathAdjuster.replacePathExcludeClass(html, Pattern.compile("^.*$"), "zzz", clazz);
        assertThat(html.getById("track1",Track.class).getSrc(), not("zzz"));
        assertThat(html.getById("track2",Track.class).getSrc(), is("zzz"));
    }

    @Test
    public void testReplacePathExcludesTag() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        List<Class<?>> tagTypes = new ArrayList<Class<?>>();
        tagTypes.add(Iframe.class);
        tagTypes.add(Form.class);
        PathAdjuster.replacePathExcludeTag(html, Pattern.compile(".*"), "zzz", tagTypes);
        assertThat(html.getById("track1", Track.class).getSrc(), is("zzz"));
        assertThat(html.getById("a_001", A.class).getHref(), is("zzz"));
        assertThat(html.getById("form01", Form.class).getAction(), not("zzz"));
        assertThat(html.getById("iframe_01", Iframe.class).getSrc(), not("zzz"));
    }

    @Test
    public void testReplacePathExclude() throws Exception {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        List<String> clazz = new ArrayList<String>();
        clazz.add("bar");
        List<Class<?>> tagTypes = new ArrayList<Class<?>>();
        tagTypes.add(Img.class);
        tagTypes.add(Iframe.class);
        PathAdjuster.replacePathExclude(html, Pattern.compile(".*"), "zzz", clazz, tagTypes);

        assertThat(html.getById("form01", Form.class).getAction(), is("zzz"));
        assertThat(html.getById("img_01", Img.class).getSrc(), is("zzz"));
        assertThat(html.getById("img_02", Img.class).getSrc(), not("zzz"));
        assertThat(html.getById("iframe_01", Iframe.class).getSrc(), not("zzz"));
        assertThat(html.getById("iframe_02", Iframe.class).getSrc(), is("zzz"));
        assertThat(html.getById("track1", Track.class).getSrc(), is("zzz"));
        assertThat(html.getById("track2", Track.class).getSrc(), is("zzz"));
    }

}

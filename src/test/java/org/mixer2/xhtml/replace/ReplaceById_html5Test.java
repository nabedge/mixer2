package org.mixer2.xhtml.replace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Br;
import org.mixer2.jaxb.xhtml.Footer;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Optgroup;
import org.mixer2.jaxb.xhtml.Option;
import org.mixer2.jaxb.xhtml.Select;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 * @author watanabe
 *
 */
public class ReplaceById_html5Test {

    private String templateFileName = "ReplaceByIdTest_html5.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
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

    /**
     * selectタグ内のoptionタグを別のoptionタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceOption() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertNotNull(html.getById("option_1", Option.class));
        assertNotNull(html.getById("option_2", Option.class));
        Option option = new Option();
        option.setId("newoption");
        option.setValue("hoge");
        option.setContent("content!");
        html.replaceById("option_2", option);
        assertNotNull(html.getById("option_1", Option.class));
        assertNull(html.getById("option_2", Option.class));
        Optgroup optgroup = html.getById("optgroup2", Optgroup.class);
        assertEquals("newoption",optgroup.getOption().get(1).getId());
    }

    /**
     * selectタグ内のoptgroupタグを別のoptionタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceOptgroupByOption() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertNotNull(html.getById("optgroup1", Optgroup.class));
        assertNotNull(html.getById("optgroup2", Optgroup.class));
        Option option = new Option();
        option.setId("newoption");
        option.setValue("hoge");
        option.setContent("content!");
        html.replaceById("optgroup2", option);
        assertNotNull(html.getById("optgroup1", Optgroup.class));
        assertNull(html.getById("optgroup2", Optgroup.class));
        Select select = html.getById("select1", Select.class);
        assertEquals("newoption", select.getOptgroupOrOption().get(1).cast(Option.class).getId());
    }


    /**
     * footerタグ内のbrタグをspanタグで置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceById() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertNotNull(html.getById("dummy_br2", Br.class));

        Span dummy_span = new Span();
        dummy_span.setId("dummy_span");
        html.replaceById("dummy_br2", dummy_span);
        assertNull(html.getById("dummy_br2", Br.class));

        List<Object> list = html.getById("footer", Footer.class).getContent();
        for (int i=0; i<list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof Br){
                assertEquals("dummy_span", ((Span)list.get(i + 1)).getId());
                break;
            }
        }
    }

    /**
     * footerタグ内のbrタグを文字列で置換してみる
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void replaceByIdWithString() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        assertNotNull(html.getById("dummy_br2", Br.class));

        html.replaceById("dummy_br2", "hogehoge");
        assertNull(html.getById("dummy_br2", Br.class));

        List<Object> list = html.getById("footer", Footer.class).getContent();
        for (int i=0; i<list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof Br){
                assertEquals("hogehoge", list.get(i + 1));
                break;
            }
        }
    }

}

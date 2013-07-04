package org.mixer2.xhtml.insert;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Li;
import org.mixer2.jaxb.xhtml.Menu;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 *
 * @author watanabe
 *
 */
public class InsertById02Test {

    private String templateFileName = "InsertByIdTest02.html";
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
     * menuタグ内で文字列を挿入してみる
     */
    @Test
    public void menu_String_Test() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.insertAfterId("menu2", "insert_after_menu2");
        List<Object> objList = html.getById("li2",Li.class).getContent();
        //System.out.println(objList.get(2).toString());
        assertEquals(objList.get(2), "insert_after_menu2");
    }
    /**
     * menuタグ内でliを挿入してみる
     */
    @Test
    public void menu_li_Test() throws IOException, TagTypeUnmatchException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        //
        Li newli01 = new Li();
        newli01.setId("newli01");
        newli01.getContent().add("newli01!");
        html.insertAfterId("li2", newli01);
        //
        List<Li> liList = html.getById("menu0", Menu.class).getDescendants(Li.class);
        assertEquals("newli01", liList.get(2).getId());
    }

}

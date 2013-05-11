package org.mixer2.xhtml.builder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Table;
import org.mixer2.jaxb.xhtml.Tr;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

public class TableBuilderSampleTest {

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    private String templateFilePath;

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }

    @Before
    public void init() throws IOException {
        templateFilePath = getClass().getResource(
                "TableBuilderSample.html").toString();
        String osname = System.getProperty("os.name");
        if (osname.indexOf("Windows") >= 0) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void sample() throws TagTypeUnmatchException, IOException {

        Html html = m2e.loadHtmlTemplate(new File(templateFilePath));

        html.removeDescendants("comment");

        TableBuilder tBuilder = new TableBuilder();

        String[][] data = new String[][] {
                // id, name, price
                { "1", "cookie", "2.50" }, { "2", "candy", "3.75" } };

        for (String[] row : data) {
            tBuilder.addTr().addTd(row[0]).addTd(row[1]).addTd(row[2]);
        }

        Table newtable = tBuilder.build();
        Table table = html.getById("search_result", Table.class);
        Tr headTr = table.getTr().get(0);
        table.getTr().clear();
        table.getTr().add(headTr);
        table.getTr().addAll(newtable.getTr());

        // System.out.println(mixer2Engine.saveToString(html));
    }

    @Test
    public void sample2() {
        TableBuilder tableBuilder = new TableBuilder();
        tableBuilder.thead.tr(0).addTd("id").addTd("name").addTd("price");
        tableBuilder.tbody(0).tr(0).addTd("1").addTd("cookie").addTd("2.75");
        tableBuilder.tbody(0).tr(1).addTd("2").addTd("candy").addTd("3.25");
        // System.out.println(mixer2Engine.saveToString(tableBuilder.build()));

    }

    @Test
    public void sample3() {
        HashMap<String, Object> attrMap = new HashMap<String, Object>();
        attrMap.put("id", "foo_id");
        attrMap.put("class", "class_1 class_2"); // classの属性名はcssClassでもかまいません
        TableBuilder tableBuilder = new TableBuilder();
        tableBuilder.tr(0).td(0).add("foo");
        tableBuilder.tr(0).td(0).setAttr(attrMap);
        tableBuilder.tr(0).td(0).setAttr("title", "foo_title");
        // System.out.println(mixer2Engine.saveToString(tableBuilder.tr(0).buildTr()));
        // System.out.println(mixer2Engine.saveToString(tableBuilder.build()));
    }

}

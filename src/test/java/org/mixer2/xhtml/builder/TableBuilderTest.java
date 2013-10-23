package org.mixer2.xhtml.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.jaxb.xhtml.Table;
import org.mixer2.jaxb.xhtml.Td;
import org.mixer2.jaxb.xhtml.Tr;
import org.mixer2.xhtml.Mixer2EngineSingleton;

public class TableBuilderTest {

    @SuppressWarnings("unused")
	private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @AfterClass
    public static void afterClass() {
        m2e = null;
    }
    
    @Test
    public void colSpanTest () throws Exception {
        Map<String, Object> attrMap = new HashMap<String,Object>();
        attrMap.put("id", "fooId");
        attrMap.put("colspan", new Integer(2));
        TableBuilder tb = new TableBuilder();
        tb.addTr().addTd("a").addTd("b");
        tb.addTr().addTd("c", attrMap);
        Table table = tb.build();
        assertEquals(2, table.getById("fooId", Td.class).getColspan());
    }
    
    @Test
    public void methodChainTest1() throws Exception {
        TableBuilder tBuilder = new TableBuilder();
        tBuilder.tr(0).addTd("foo").addTd("bar");
        Table table = tBuilder.build();
        Td td00 = table.getTr().get(0).getThOrTd().get(0).cast(Td.class);
        Td td01 = table.getTr().get(0).getThOrTd().get(1).cast(Td.class);
        assertEquals("foo", td00.getContent().get(0));
        assertEquals("bar", td01.getContent().get(0));
//        m2e.saveToString(table);
    }

    @Test
    public void methodChainTest2() throws Exception {
        ArrayList<Object> tdList0 = new ArrayList<Object>();
        tdList0.add("td00");
        tdList0.add("td01");
        ArrayList<Object> tdList1 = new ArrayList<Object>();
        tdList1.add("td10");
        tdList1.add("td11");
        TableBuilder tBuilder = new TableBuilder();
        tBuilder.addTr(tdList0).addTr(tdList1);
        Table table = tBuilder.build();
        //
        Td td00 = table.getTr().get(0).getThOrTd().get(0).cast(Td.class);
        Td td01 = table.getTr().get(0).getThOrTd().get(1).cast(Td.class);
        Td td10 = table.getTr().get(1).getThOrTd().get(0).cast(Td.class);
        Td td11 = table.getTr().get(1).getThOrTd().get(1).cast(Td.class);
        assertEquals("td00", td00.getContent().get(0));
        assertEquals("td01", td01.getContent().get(0));
        assertEquals("td10", td10.getContent().get(0));
        assertEquals("td11", td11.getContent().get(0));
    }

    @Test
    public void methodChainTest3() throws Exception {
        TableBuilder tBuilder = new TableBuilder();
        tBuilder.tr(0).addTd("tr0_td0").addTd("tr0_td1");
        tBuilder.addTr().addTd("tr1_td0").addTd("tr1_td1");
        tBuilder.tbody(0).addTr().addTd("tbody0_tr0_td0").addTd("tbody0_tr0_td1");
        tBuilder.addTbody().addTr().addTd("tbody1_tr0_td0").addTd("tbody1_tr0_td1");
        tBuilder.thead.addTr().addTd("thead_tr0_td0").addTd("thead_tr0_td1");
        tBuilder.thead.tr(1).addTd("thead_tr1_td0").addTd("thead_tr1_td1");
        tBuilder.tfoot.addTr().addTd("tfoot_tr0_td0").addTd("tfoot_tr0_td1");
        tBuilder.tfoot.tr(1).addTd("tfoot_tr1_td0").addTd("tfoot_tr1_td1");
        Table table = tBuilder.build();
        table.setBorder(1);
        //System.out.println(m2e.saveToString(table));
        assertEquals("tr1_td0", table.getTr().get(1).getThOrTd().get(0).getContent().get(0));
        assertEquals("tbody0_tr0_td1", table.getTbody().get(0).getTr().get(0).getThOrTd().get(1).getContent().get(0));
        assertEquals("thead_tr1_td1", table.getThead().getTr().get(1).getThOrTd().get(1).getContent().get(0));
        assertEquals("tfoot_tr0_td0", table.getTfoot().getTr().get(0).getThOrTd().get(0).getContent().get(0));
    }

    @Test
    public void makeCellTest() throws Exception {

        Span span1 = new Span();
        span1.getContent().add("span1");
        Span span2 = new Span();
        span2.getContent().add("span2");
        TableBuilder tbuilder = new TableBuilder();

        // col1, row1
        tbuilder.tr(0).td(0).add("aaa");

        HashMap<String, Object> attrMap = new HashMap<String, Object>();
        attrMap.put("id", "id1");
        ArrayList<String> cssClass = new ArrayList<String>();
        cssClass.add("class_1");
        cssClass.add("class_2");
        attrMap.put("class", cssClass);
        attrMap.put("style", "font-size:larger;");
        attrMap.put("title", "title1");

        tbuilder.tr(0).td(0).setAttr(attrMap);
        tbuilder.tr(0).td(0).add(span1);

        // col2, row1
        tbuilder.tr(0).td(1).add("bbb");

        // col1 row2
        tbuilder.tr(1).td(0).add("ccc");

        // col2 row2
        tbuilder.tr(1).td(1).add("ddd");
        tbuilder.tr(1).td(1).add(span2);
        Table table = tbuilder.build();
        //
        // System.out.println(m2e.saveToString(table));

        // col1, row1
        Td td1 = table.getTr().get(0).getThOrTd().get(0).cast(Td.class);
        // // attr
        assertEquals("id1", td1.getId());
        assertEquals("class_1", td1.getCssClass().get(0));
        assertEquals("class_2", td1.getCssClass().get(1));
        assertEquals("font-size:larger;", td1.getStyle());
        assertEquals("title1", td1.getTitle());
        // // content
        assertEquals("aaa", td1.getContent().get(0));
        assertEquals("span1", ((Span) td1.cast(Td.class).getContent().get(1))
                .getContent().get(0));

        // col2, row1
        assertEquals("bbb", table.getTr().get(0).getThOrTd().get(1).cast(
                Td.class).getContent().get(0));

        // col1, row2
        assertEquals("ccc", table.getTr().get(1).getThOrTd().get(0).cast(
                Td.class).getContent().get(0));

        // col2, row2
        assertEquals("ddd", table.getTr().get(1).getThOrTd().get(1).cast(
                Td.class).getContent().get(0));
        assertEquals("span2", ((Span) table.getTr().get(1).getThOrTd().get(1)
                .cast(Td.class).getContent().get(1)).getContent().get(0));
    }

    @Test
    public void addCellTest() throws Exception {
        TableBuilder tBuilder = new TableBuilder();

        // col0 row0
        tBuilder.tr(0).addTd("aaa");

        // col1 row0
        Span span1 = new Span();
        span1.getContent().add("span1");
        HashMap<String, Object> attrMap = new HashMap<String, Object>();
        attrMap.put("id", "id1");
        tBuilder.tr(0).addTd(span1, attrMap);

        // col0 row1
        HashMap<String, Object> attrMap2 = new HashMap<String, Object>();
        attrMap2.put("id", "id2");
        tBuilder.tr(1).addTd("bbb", attrMap2);

        // col1 row1
        Span span2 = new Span();
        span2.getContent().add("span2");
        tBuilder.tr(1).addTd(span2);

        //
        Table table = tBuilder.build();
        //
        // System.out.println(m2e.saveToString(table));

        //
        Td td00 = table.getTr().get(0).getThOrTd().get(0).cast(Td.class);
        assertEquals("aaa", td00.getContent().get(0));

        //
        Td td01 = table.getTr().get(0).getThOrTd().get(1).cast(Td.class);
        assertEquals("id1", td01.getId());
        assertEquals("span1", ((Span) td01.getContent().get(0)).getContent()
                .get(0));

        // Td td10
        Td td10 = table.getTr().get(1).getThOrTd().get(0).cast(Td.class);
        assertEquals("id2", td10.getId());
        assertEquals("bbb", td10.getContent().get(0));

        //
        Td td11 = table.getTr().get(1).getThOrTd().get(1).cast(Td.class);
        assertEquals("span2", ((Span) td11.getContent().get(0)).getContent()
                .get(0));
    }

    @Test
    public void addRowTest() throws Exception {
        TableBuilder tBuilder = new TableBuilder();
        ArrayList<Object> tdList0 = new ArrayList<Object>();
        //
        tdList0.add("aaa");
        //
        Div div0 = new Div();
        div0.getContent().add("div0");
        tdList0.add(div0);
        //
        tBuilder.addTr(tdList0);
        //
        ArrayList<Object> tdList1 = new ArrayList<Object>();
        tdList1.add("ccc");
        tdList1.add("ddd");

        HashMap<String, Object> attrMap = new HashMap<String, Object>();
        attrMap.put("id", "id_foo");
        tBuilder.addTr(tdList1, attrMap);

        //
        Table table = tBuilder.build();
        // System.out.println(m2e.saveToString(table));
        //
        Td td00 = table.getTr().get(0).getThOrTd().get(0).cast(Td.class);
        assertEquals("aaa", td00.getContent().get(0));
        //
        Td td01 = table.getTr().get(0).getThOrTd().get(1).cast(Td.class);
        assertEquals("div0", ((Div) td01.getContent().get(0)).getContent().get(
                0));
        //
        Tr tr = table.getTr().get(1);
        assertEquals("id_foo", tr.getId());
    }

    @Test
    public void tbodyTest() throws Exception {
        ArrayList<Object> tdList0 = new ArrayList<Object>();
        tdList0.add("aaa");
        tdList0.add("bbb");
        ArrayList<Object> tdList1 = new ArrayList<Object>();
        tdList1.add("ccc");
        tdList1.add("ddd");
        List<List<Object>> data = new ArrayList<List<Object>>();
        data.add(tdList0);
        data.add(tdList1);

        HashMap<String, Object> attrMap = new HashMap<String, Object>();
        attrMap.put("id", "tbody1");

        //
        TableBuilder tBuilder = new TableBuilder();
        tBuilder.tbody(0).tr(0).td(0).add("foo");
        tBuilder.tbody(0).tr(0).td(1).add("bar");
        tBuilder.addTbody(data, attrMap);
        Table table = tBuilder.build();
        //
        // System.out.println(m2e.saveToString(table));
        assertEquals("tbody1", table.getTbody().get(1).getId());
        assertEquals("ddd", table.getTbody().get(1).getTr().get(1).getThOrTd()
                .get(1).cast(Td.class).getContent().get(0));
    }

    @Test
    public void nullDataTest() {
        TableBuilder tBuilder = new TableBuilder();
        Table table = tBuilder.build();
        // NullPointerExceptionなどが発生しなければOK
        assertNotNull(table);
        // System.out.println(m2e.saveToString(table));
    }

    @Test
    public void theadTest() throws Exception {
        TableBuilder tBuilder = new TableBuilder();
        ArrayList<Object> tdList0 = new ArrayList<Object>();
        tdList0.add("aaa");
        tdList0.add("bbb");
        //
        tBuilder.thead.tr(0).addTd("foo").addTd("bar");
        tBuilder.thead.addTr(tdList0);
        tBuilder.thead.setAttr("id", "thead_00");
        Table table = tBuilder.build();
        //
        assertEquals("bar", table.getThead().getTr().get(0).getThOrTd().get(1)
                .cast(Td.class).getContent().get(0));
        assertEquals("thead_00", table.getThead().getId());
    }

    @Test
    public void tfootTest() throws Exception {
        TableBuilder tBuilder = new TableBuilder();
        ArrayList<Object> tdList0 = new ArrayList<Object>();
        tdList0.add("aaa");
        tdList0.add("bbb");
        //
        tBuilder.tfoot.tr(0).addTd("foo").addTd("bar");
        tBuilder.tfoot.addTr(tdList0);
        tBuilder.tfoot.setAttr("id", "tfoot_00");

        Table table = tBuilder.build();
        //
        assertEquals("bar", table.getTfoot().getTr().get(0).getThOrTd().get(1)
                .cast(Td.class).getContent().get(0));
        assertEquals("tfoot_00", table.getTfoot().getId());
        // System.out.println(m2e.saveToString(table));
    }

    @Test
    public void cssClassTest() throws Exception {
        TableBuilder tBuilder = new TableBuilder();
        tBuilder.tr(0).setAttr("class", "class_a1 class_a2    ");
        tBuilder.tr(0).td(0).add("a");
        String[] classArray = new String[] { "class_b1", "class_b2" };
        tBuilder.tr(1).td(0).add("b");
        tBuilder.tr(1).td(0).setAttr("class", Arrays.asList(classArray));
        tBuilder.tr(1).td(0).setAttr("title", "title_b");
        Table table = tBuilder.build();

//        System.out.println(m2e.saveToString(table));

        assertEquals("class_a1",table.getTr().get(0).getCssClass().get(0));
        assertEquals("class_a2",table.getTr().get(0).getCssClass().get(1));
        assertEquals("a",table.getTr().get(0).getThOrTd().get(0).cast(Td.class).getContent().get(0));
        assertEquals("class_b1",table.getTr().get(1).getThOrTd().get(0).cast(Td.class).getCssClass().get(0));
        assertEquals("class_b2",table.getTr().get(1).getThOrTd().get(0).cast(Td.class).getCssClass().get(1));
        assertEquals("title_b",table.getTr().get(1).getThOrTd().get(0).cast(Td.class).getTitle());
        assertEquals("b",table.getTr().get(1).getThOrTd().get(0).cast(Td.class).getContent().get(0));
    }

}

package org.mixer2.xhtml.formutil;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Form;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Option;
import org.mixer2.jaxb.xhtml.Select;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;
import org.mixer2.xhtml.util.FormUtil;
import org.mixer2.xhtml.util.LabelValueBean;

public class FormUtilSelectTest {

    private String templateFileName = "FormUtilSelectTest.html";
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

    @Test
    public void test1() throws IOException, TagTypeUnmatchException,
            IllegalAccessException, InvocationTargetException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Form form = html.getById("test1", Form.class);
        Bean bean = new Bean();
        bean.setSelect1("a");
        FormUtil.populateForm(form, bean);

        assertThat(form.getById("option1a", Option.class).getSelected(),
                is("selected"));
        assertThat(form.getById("option1b", Option.class).getSelected(),
                is(nullValue()));
        assertThat(form.getById("option1c", Option.class).getSelected(),
                is(nullValue()));

    }

    @Test
    public void test2() throws IOException, TagTypeUnmatchException,
            IllegalAccessException, InvocationTargetException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Form form = html.getById("test2", Form.class);
        Bean bean = new Bean();
        bean.setSelect2(new String[] { "a", "b", "c" });
        FormUtil.populateForm(form, bean);

        assertThat(form.getById("option2a", Option.class).getSelected(),
                is("selected"));
        assertThat(form.getById("option2b", Option.class).getSelected(),
                is("selected"));
        assertThat(form.getById("option2c", Option.class).getSelected(),
                is("selected"));
        assertThat(form.getById("option2d", Option.class).getSelected(),
                is(nullValue()));
        assertThat(form.getById("option2e", Option.class).getSelected(),
                is(nullValue()));
    }

    /**
     * selectボックスにoptionタグを入れ込むテスト
     *
     * @throws IOException
     * @throws TagTypeUnmatchException
     */
    @Test
    public void test3() throws IOException, TagTypeUnmatchException {

        List<LabelValueBean> lvList = new ArrayList<LabelValueBean>();
        lvList.add(new LabelValueBean("English", "en"));
        lvList.add(new LabelValueBean("Japanese", "ja"));

        List<Option> optionList = new ArrayList<Option>();
        optionList = FormUtil.makeOptionList(lvList, optionList);

        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        html.getById("select3", Select.class).getOptgroupOrOption()
                .addAll(optionList);
        // System.out.println(m2e.saveToString(html));
        assertEquals("English", html.getById("select3", Select.class)
                .getOptgroupOrOption().get(0).cast(Option.class).getContent());
        assertEquals("ja", html.getById("select3", Select.class)
                .getOptgroupOrOption().get(1).cast(Option.class).getValue());

    }

    public class Bean {
        private String select1;
        private String[] select2;

        public String getSelect1() {
            return select1;
        }

        public void setSelect1(String select1) {
            this.select1 = select1;
        }

        public String[] getSelect2() {
            return select2;
        }

        public void setSelect2(String[] select2) {
            this.select2 = select2;
        }
    }
}

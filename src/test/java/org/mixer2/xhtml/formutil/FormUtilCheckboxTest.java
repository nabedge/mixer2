package org.mixer2.xhtml.formutil;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Form;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Input;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;
import org.mixer2.xhtml.util.FormUtil;

public class FormUtilCheckboxTest {

    private String templateFileName = "FormUtilCheckboxTest.html";
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
    public void test01() throws IOException, TagTypeUnmatchException,
            IllegalAccessException, InvocationTargetException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        Form form = html.getById("test01", Form.class);
        Bean bean = new Bean();

        // この段階ではvalueがaのboxだけがcheckされている。
        assertThat(form.getById("c01", Input.class).getChecked(), is("checked"));
        assertThat(form.getById("c02", Input.class).getChecked(),
                is(nullValue()));
        assertThat(form.getById("c03", Input.class).getChecked(),
                is(nullValue()));

        // beanでform内の値を変える
        bean.setCheckbox01(new String[] { "b" });
        FormUtil.populateForm(form, bean);

        // name属性を与えていないcheckboxは変化なし
        assertThat(form.getById("c00", Input.class).getChecked(),
                is(nullValue()));
        assertThat(form.getById("c00", Input.class).getValue(), is("xxx"));

        // valueがaのボックスはcheckedが外れている
        assertThat(form.getById("c01", Input.class).getValue(), is("a"));
        assertThat(form.getById("c01", Input.class).getChecked(),
                is(nullValue()));

        // valueがbのboxはcheckされていること。
        assertThat(form.getById("c02", Input.class).getValue(), is("b"));
        assertThat(form.getById("c02", Input.class).getChecked(), is("checked"));

        // valueがcのboxはcheckされていない（変化がない）こと。
        assertThat(form.getById("c03", Input.class).getValue(), is("c"));
        assertThat(form.getById("c03", Input.class).getChecked(),
                is(nullValue()));
    }

    public class Bean {
        private String[] checkbox01;

        public String[] getCheckbox01() {
            return checkbox01;
        }

        public void setCheckbox01(String[] checkbox01) {
            this.checkbox01 = checkbox01;
        }

    }

}

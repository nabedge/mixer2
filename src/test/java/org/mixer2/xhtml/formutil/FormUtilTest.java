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
import org.mixer2.jaxb.xhtml.Option;
import org.mixer2.jaxb.xhtml.Textarea;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;
import org.mixer2.xhtml.util.FormUtil;

public class FormUtilTest {

    private String templateFileName = "FormUtilTest.html";
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
    public void populateFormTest() throws IOException, TagTypeUnmatchException,
            IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        html = m2e.loadHtmlTemplate(new File(templateFilePath));
        // System.out.println(m2e.saveToString(html));
        Form form = html.getById("the_form", Form.class);
        Bean bean = new Bean();
        FormUtil.populateForm(form, bean);

        // hidden
        assertThat(form.getById("hidden1", Input.class).getValue(),
                is("bean_hidden1"));

        // text
        assertThat(form.getById("text1", Input.class).getValue(),
                is("bean_text1"));
        assertThat(form.getById("text2", Input.class).getValue(),
                is("bean_text2"));

        // textarea
        assertThat(form.getById("textarea1", Textarea.class).getContent(),
                is("bean_textarea1"));
        assertThat(form.getById("textarea2", Textarea.class).getContent(),
                is("bean_textarea2"));

        // select and option
        assertThat(form.getById("select1_option_a", Option.class).getValue(),
                is("option_a"));
        assertThat(
                form.getById("select1_option_a", Option.class).getSelected(),
                is("selected"));
        assertThat(form.getById("select1_option_b", Option.class).getValue(),
                is("option_b"));
        assertThat(
                form.getById("select1_option_b", Option.class).getSelected(),
                is(nullValue()));
        assertThat(form.getById("select1_option_c", Option.class).getValue(),
                is("option_c"));
        assertThat(
                form.getById("select1_option_c", Option.class).getSelected(),
                is(nullValue()));

        // select and option
        assertThat(form.getById("select1_option_a", Option.class).getValue(),
                is("option_a"));
        assertThat(
                form.getById("select2_option_a", Option.class).getSelected(),
                is(nullValue()));
        assertThat(form.getById("select1_option_b", Option.class).getValue(),
                is("option_b"));
        assertThat(
                form.getById("select2_option_b", Option.class).getSelected(),
                is("selected"));
        assertThat(form.getById("select1_option_c", Option.class).getValue(),
                is("option_c"));
        assertThat(
                form.getById("select2_option_c", Option.class).getSelected(),
                is("selected"));

        // radio1_radio_a
        assertThat(form.getById("radio1_radio_a", Input.class).getValue(),
                is("radio_a"));
        assertThat(form.getById("radio1_radio_a", Input.class).getChecked(),
                is(nullValue()));
        assertThat(form.getById("radio1_radio_b", Input.class).getValue(),
                is("radio_b"));
        assertThat(form.getById("radio1_radio_b", Input.class).getChecked(),
                is("checked"));
        assertThat(form.getById("radio1_radio_c", Input.class).getValue(),
                is("radio_c"));
        assertThat(form.getById("radio1_radio_c", Input.class).getChecked(),
                is(nullValue()));

        // checkbox1
        assertThat(
                form.getById("checkbox1_checkbox_a", Input.class).getValue(),
                is("checkbox_a"));
        assertThat(form.getById("checkbox1_checkbox_a", Input.class)
                .getChecked(), is("checked"));
        assertThat(
                form.getById("checkbox1_checkbox_b", Input.class).getValue(),
                is("checkbox_b"));
        assertThat(form.getById("checkbox1_checkbox_b", Input.class)
                .getChecked(), is(nullValue()));
        assertThat(
                form.getById("checkbox1_checkbox_c", Input.class).getValue(),
                is("checkbox_c"));
        assertThat(form.getById("checkbox1_checkbox_c", Input.class)
                .getChecked(), is(nullValue()));

        // checkbox2
        assertThat(
                form.getById("checkbox2_checkbox_a", Input.class).getValue(),
                is("checkbox_a"));
        assertThat(form.getById("checkbox2_checkbox_a", Input.class)
                .getChecked(), is(nullValue()));
        assertThat(
                form.getById("checkbox2_checkbox_b", Input.class).getValue(),
                is("checkbox_b"));
        assertThat(form.getById("checkbox2_checkbox_b", Input.class)
                .getChecked(), is("checked"));
        assertThat(
                form.getById("checkbox2_checkbox_c", Input.class).getValue(),
                is("checkbox_c"));
        assertThat(form.getById("checkbox2_checkbox_c", Input.class)
                .getChecked(), is("checked"));

        // checkbox3
        assertThat(form.getById("checkbox3", Input.class).getChecked(),
                is("checked"));
    }

    public class Bean {
        private String hidden1 = "bean_hidden1";

        private String text1 = "bean_text1";
        private String text2 = "bean_text2";

        private String textarea1 = "bean_textarea1";
        private String textarea2 = "bean_textarea2";

        private String select1 = "option_a";
        private String[] select2 = { "option_b", "option_c" };

        private String radio1 = "radio_b";
        private String radio2 = "radio_c";

        private String checkbox1 = "checkbox_a";
        private String[] checkbox2 = { "checkbox_b", "checkbox_c" };

        private boolean checkbox3 = true;

        public String getHidden1() {
            return hidden1;
        }

        public void setHidden1(String hidden1) {
            this.hidden1 = hidden1;
        }

        public String getText1() {
            return text1;
        }

        public void setText1(String text1) {
            this.text1 = text1;
        }

        public String getText2() {
            return text2;
        }

        public void setText2(String text2) {
            this.text2 = text2;
        }

        public String getTextarea1() {
            return textarea1;
        }

        public void setTextarea1(String textarea1) {
            this.textarea1 = textarea1;
        }

        public String getTextarea2() {
            return textarea2;
        }

        public void setTextarea2(String textarea2) {
            this.textarea2 = textarea2;
        }

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

        public String getRadio1() {
            return radio1;
        }

        public void setRadio1(String radio1) {
            this.radio1 = radio1;
        }

        public String getRadio2() {
            return radio2;
        }

        public void setRadio2(String radio2) {
            this.radio2 = radio2;
        }

        public String getCheckbox1() {
            return checkbox1;
        }

        public void setCheckbox1(String checkbox1) {
            this.checkbox1 = checkbox1;
        }

        public String[] getCheckbox2() {
            return checkbox2;
        }

        public void setCheckbox2(String[] checkbox2) {
            this.checkbox2 = checkbox2;
        }

        public boolean isCheckbox3() {
            return checkbox3;
        }

        public void setCheckbox3(boolean checkbox3) {
            this.checkbox3 = checkbox3;
        }
    }

}

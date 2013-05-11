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

public class FormUtilSampleTest {

    private String templateFileName = "FormUtilSampleTest.html";
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
        Form form = html.getById("the_form", Form.class);

        Bean bean = new Bean();
        bean.setFullName("Harry Potter");
        bean.setSex("male");
        bean.setSubscribeNewsLetter(true);
        bean.setCountry("U.K");
        bean.setInterests(new String[] { "Quidditch",
                "Defence Against the Dark Arts" });

        FormUtil.populateForm(form, bean);
        // System.out.println(m2e.saveToString(html));

        for (Input input : form.getDescendants(Input.class)) {
            if ("interests".equals(input.getName())) {
                if ("Quidditch".equals(input.getValue())) {
                    assertThat(input.getChecked(), is("checked"));
                }
                if ("Herbology".equals(input.getValue())) {
                    assertThat(input.getChecked(), is(nullValue()));
                }
                if ("Defence Against the Dark Arts".equals(input.getValue())) {
                    assertThat(input.getChecked(), is("checked"));
                }
            }
        }
    }

    public class Bean {

        private String fullName;
        private String sex;
        private boolean subscribeNewsLetter;
        private String country;
        private String[] interests;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public boolean isSubscribeNewsLetter() {
            return subscribeNewsLetter;
        }

        public void setSubscribeNewsLetter(boolean subscribeNewsLetter) {
            this.subscribeNewsLetter = subscribeNewsLetter;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String[] getInterests() {
            return interests;
        }

        public void setInterests(String[] interests) {
            this.interests = interests;
        }
    }
}

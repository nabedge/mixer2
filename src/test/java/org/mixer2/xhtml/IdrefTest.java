package org.mixer2.xhtml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Form;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Input;
import org.mixer2.jaxb.xhtml.Label;

public class IdrefTest {
    @SuppressWarnings("unused")
    private static Log log = LogFactory.getLog(IdrefTest.class);
    private String templateFileName = "IdrefTest.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @Before
    public void init() throws Exception {
        templateFilePath = getClass().getResource(templateFileName).toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void setForPropOfLabelTag() throws Exception {
        InputStream in = new FileInputStream(templateFilePath);
        Html html = m2e.loadHtmlTemplate(in);
        
        Form fooForm = html.getById("fooForm", Form.class);

        Label label_familyName = TagCreator.label();
        label_familyName.getContent().add("family name:");
        label_familyName.setFor(fooForm.getById("familyName", Input.class));
        fooForm.insertBeforeId("familyName", label_familyName);
        
        Label label_lastName = TagCreator.label();
        label_lastName.getContent().add("last name:");
        label_lastName.setFor(fooForm.getById("lastName", Input.class));
        fooForm.insertBeforeId("lastName", label_lastName);
        
        String str = m2e.saveToString(html);
        Assert.assertTrue(str.contains("<label for=\"familyName\">family name:</label>"));
        Assert.assertTrue(str.contains("<label for=\"lastName\">last name:</label>"));
    }

    @Test
    public void getForPropOfLabelTag() throws Exception {
        InputStream in = new FileInputStream(templateFilePath);
        Html html = m2e.loadHtmlTemplate(in);
        
        Form barForm = html.getById("barForm", Form.class);
        Label label = barForm.getById("barInputLabel", Label.class);
        assertTrue(label.getFor().getClass().equals(Input.class));
        assertEquals("barInput", ((Input)label.getFor()).getId());
    }
}

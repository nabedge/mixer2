package org.mixer2.xhtml;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Textarea;

public class EmptyTextAreaTest {

    @SuppressWarnings("unused")
    private static Log log = LogFactory.getLog(EmptyTextAreaTest.class);

    private String templateFileName = "emptyTextArea.html";
    private String templateFilePath;
    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @Before
    public void init() throws IOException {
        templateFilePath = getClass().getResource(templateFileName).toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void test() throws Exception {
        File file = new File(templateFilePath);
        Html html = m2e.loadHtmlTemplate(file);
        html.getById("fooTextarea", Textarea.class).setContent("");
        String str = m2e.saveToString(html);
        log.info(str);
        Assert.assertTrue(str.contains(">" + SystemUtils.LINE_SEPARATOR + "</textarea>"));
    }
}

package org.mixer2.issues;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.lang.SystemUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.P;
import org.mixer2.xhtml.Mixer2EngineSingleton;

/**
 * see https://github.com/nabedge/mixer2/issues/8
 * 
 * @author nabedge
 *
 */
public class Issue0008 {

    private String templateFileName = "issue0008.html";
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
    public void test() throws Exception {
        InputStream in = new FileInputStream(templateFilePath);
        Html html = m2e.loadHtmlTemplate(in);
        A a = html.getBody().getById("link1", A.class);
        Assert.assertNotNull(a.getById("barP", P.class));
        Assert.assertNotNull(a.getById("barDiv", Div.class));
    }

}

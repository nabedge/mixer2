package org.mixer2.issues;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SystemUtils;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.P;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.TagCreator;

/**
 * see https://github.com/nabedge/mixer2/issues/4
 * 
 * @author nabedge
 *
 */
public class Issue0004 {

    private String templateFileName = "issue0004.html";
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
    public void templateTest() throws Exception {
        InputStream in = new FileInputStream(templateFilePath);
        Html html = m2e.loadHtmlTemplate(in);
        String str = "<p><a href=\"link1\">link1</a><a href=\"link2\">link2</a></p>";
        //System.out.println(m2e.saveToString(html));
        assertTrue(m2e.saveToString(html).contains(str));
    }

    @Test
    public void zeroTemplateTest() throws Exception {
        List<Object> aList = new ArrayList<Object>();
        for (int i = 1; i <= 2; i++) {
            A linkA = TagCreator.a();
            linkA.getContent().add("link" + i);
            linkA.setHref("link" + i);
            aList.add(linkA);
        }
        P p = TagCreator.p();
        p.getContent().addAll(aList);
        String str = "<p><a href=\"link1\">link1</a><a href=\"link2\">link2</a></p>";
        //System.out.println(m2e.saveToString(p));
        assertTrue(m2e.saveToString(p).contains(str));
    }

}

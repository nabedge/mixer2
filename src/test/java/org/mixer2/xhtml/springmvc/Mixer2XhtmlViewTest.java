package org.mixer2.xhtml.springmvc;

import static org.hamcrest.CoreMatchers.is;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.springmvc.Mixer2XhtmlView;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class Mixer2XhtmlViewTest {

    private String templateFileName = "HelloWorld_html5.html";

    private String templateFilePath;

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @Before
    public void init() throws IOException {
        templateFilePath = getClass().getResource(templateFileName).toString();
        String osname = System.getProperty("os.name");
        if (osname.indexOf("Windows") >= 0) {
            templateFilePath = templateFilePath.replaceFirst("file:/", "");
        } else {
            templateFilePath = templateFilePath.replaceFirst("file:", "");
        }
    }

    @Test
    public void testMixer2XhtmlView() throws Exception {
        Html html = m2e.loadHtmlTemplate(new FileInputStream(templateFilePath));
        MockHttpServletRequest req = new MockHttpServletRequest();
        MockHttpServletResponse res = new MockHttpServletResponse();
        Mixer2XhtmlView view = new Mixer2XhtmlView(m2e, html);
        Map<String,Object> model = new HashMap<String, Object>();
        view.render(model, req, res);
        Html result = m2e.loadHtmlTemplate(res.getContentAsString());
        Assert.assertThat(m2e.saveToString(result), is(m2e.saveToString(html)));
    }

}

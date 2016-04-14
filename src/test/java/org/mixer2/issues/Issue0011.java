package org.mixer2.issues;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.Mixer2EngineSingleton;
import org.mixer2.xhtml.TagCreator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * see https://github.com/nabedge/mixer2/issues/11
 * 
 * @author nabedge
 *
 */
public class Issue0011 {

    private static Log log = LogFactory.getLog(Issue0011.class);

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();

    @Test
    public void test() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        sb.append("<head>");
        sb.append("<title>test</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<iframe>");
        sb.append("</iframe>");
        sb.append("</body>");
        sb.append("</html>");
        String str = sb.toString();
        Html html = m2e.loadHtmlTemplate(str);
        String result = m2e.saveToString(html);
        //log.info(result);
        assertThat(result.contains("<iframe>"), is(true));
        assertThat(result.contains("</iframe>"), is(true));
    }

    @Test
    public void test2() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        sb.append("<head>");
        sb.append("<title>test</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<iframe id=\"fooId\" src=\"barSrc\"><p>foo</p></iframe>");
        sb.append("</body>");
        sb.append("</html>");
        String str = sb.toString();
        Html html = m2e.loadHtmlTemplate(str);
        String result = m2e.saveToString(html);
        //log.info(result);
        assertThat(result.contains("<iframe "), is(true));
        assertThat(result.contains("id=\"fooId\""), is(true));
        assertThat(result.contains("src=\"barSrc\""), is(true));
        assertThat(result.contains("<p>foo</p>"), is(true));
        assertThat(result.contains("</iframe>"), is(true));
    }

    @Test
    public void test3() throws Exception {
        Iframe iframe = TagCreator.iframe();
        String iframeStr = m2e.saveToString(iframe);
        //log.info(iframeStr);
        assertThat(iframeStr.matches("<iframe>.*</iframe>"), is(true));
        // assertThat(m2e.saveToString(iframe).matches("<iframe/>"), is(true));
    }

    @Test
    public void test4() throws Exception {
        Iframe iframe = TagCreator.iframe();
        iframe.setId("foo");
        String iframeStr = m2e.saveToString(iframe);
        assertThat(iframeStr.matches("<iframe id=\"foo\">.*</iframe>"), is(true));
        // assertThat(m2e.saveToString(iframe).matches("<iframe/>"), is(true));
    }

}

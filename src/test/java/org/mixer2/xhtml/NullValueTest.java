package org.mixer2.xhtml;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.P;

// Pタグの中身がnullだとreplaceByIdがおかしくなるっぽい件。
// まだうまくテストを実装できてない。
@Ignore
public class NullValueTest {

    private static Mixer2Engine m2e = Mixer2EngineSingleton.getInstance();
    
    @Test
    public final void replaceById() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        sb.append("<body>");
        sb.append("<p id=\"foo\">bar</p>");
        sb.append("</body>");
        sb.append("</html>");
        Html html = m2e.loadHtmlTemplate(sb.toString());
        P nullP = TagCreator.pWithId("nullP");
        List<Object> list = new ArrayList<Object>();
        list.add(nullP);
        html.getBody().getContent().addAll(0, list);
        System.out.println(m2e.saveToString(html));
        html.replaceById("foo", TagCreator.spanWithId("xyz"));
        System.out.println(m2e.saveToString(html));
    }

}

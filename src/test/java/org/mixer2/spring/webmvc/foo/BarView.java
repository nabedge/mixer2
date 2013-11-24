package org.mixer2.spring.webmvc.foo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.spring.webmvc.AbstractMixer2XhtmlView;
import org.mixer2.xhtml.TagCreator;

public class BarView extends AbstractMixer2XhtmlView {

    @Override
    protected Html renderHtml(Html html, Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String barMessage = (String) model.get("barMessage");
        Span barSpan = TagCreator.span();
        barSpan.setId("barSpan");
        barSpan.getContent().add(barMessage);
        html.getBody().getContent().add(barSpan);
        return html;
    }

}

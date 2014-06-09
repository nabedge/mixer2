package org.mixer2.spring.webmvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.xhtml.TagCreator;

public class Mixer2XhtmlViewResolverTestView extends AbstractMixer2XhtmlView {

    @Override
    protected Html renderHtml(Html html, Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Span span = TagCreator.span();
        span.setId("newSpan");
        span.getContent().add("new span");
        html.getBody().getContent().add(span);
        return html;
    }

}

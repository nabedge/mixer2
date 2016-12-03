package org.mixer2.spring.boot.web.view;

import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.spring.webmvc.AbstractMixer2XhtmlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class DefaultView extends AbstractMixer2XhtmlView {
    @Override
    protected Html renderHtml(Html html, Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return html;
    }
}

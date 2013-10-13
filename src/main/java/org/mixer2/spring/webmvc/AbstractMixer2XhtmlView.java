package org.mixer2.spring.webmvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

public abstract class AbstractMixer2XhtmlView extends AbstractUrlBasedView {

    private static String lineBreakChar = System.getProperty("line.separator");

    private ResourceLoader resourceLoader;

    private String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">";

    private Mixer2Engine mixer2Engine;

    public static final AbstractMixer2XhtmlView createDefaultView() {
        return new AbstractMixer2XhtmlView() {
            @Override
            protected Html renderHtml(Html templateHtml, Map<String, Object> model, HttpServletRequest request,
                    HttpServletResponse response) {
                return templateHtml;
            };
        };
    }

    public AbstractMixer2XhtmlView() {
        setContentType("text/html; charset=UTF-8");
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public void setMixer2Engine(Mixer2Engine mixer2Engine) {
        this.mixer2Engine = mixer2Engine;
    }

    protected Mixer2Engine getMixer2Engine() {
        return mixer2Engine;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        Assert.notNull(mixer2Engine, "Property 'mixer2Engine' is required.");
        Assert.notNull(resourceLoader, "Property 'resourceLoader' is required.");
    }

    @Override
    protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Html templateHtml = mixer2Engine
                .checkAndLoadHtmlTemplate(resourceLoader.getResource(getUrl()).getInputStream());

        Html renderedHtml = renderHtml(templateHtml, model, request, response);

        response.setContentType(getContentType());

        responseHtml(renderedHtml, response);

    }

    protected void responseHtml(Html renderedHtml, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        StringBuilder sb = new StringBuilder();
        if (docType != null && !docType.trim().isEmpty()) {
            sb.append(docType.trim());
            sb.append(lineBreakChar);
        }
        sb.append(getMixer2Engine().saveToString(renderedHtml).trim());
        writer.write(sb.toString());
    }

    protected abstract Html renderHtml(Html html, Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception;

}

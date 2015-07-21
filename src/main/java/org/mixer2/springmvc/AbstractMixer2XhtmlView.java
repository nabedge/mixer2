package org.mixer2.springmvc;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.AbstractView;

/**
 * Abstract class to create view class for Spring MVC.
 * <p>
 * <strong>NOTICE: view component scope shuld be "prototype"</strong>
 * </p>
 * 
 * <b>implementation sample</b>
 * 
 * <pre><code>
 * {@literal @}Component
 * {@literal @}Scope("prototype")
 * public class HelloWorldView extends AbstractMixer2XhtmlView {
 * 
 *   {@literal @}Autowired
 *   protected Mixer2Engine mixer2Engine;
 * 
 *   {@literal @}Autowired
 *   protected ResourceLoader resourceLoader;
 * 
 *   private String mainTemplate = "classpath:helloWorldTemplate.html";
 * 
 *   {@literal @}Override
 *   protected Html createHtml(Map&lt;String, Object&gt; model,
 *           HttpServletRequest request, HttpServletResponse response)
 *           throws IOException, TagTypeUnmatchException {
 * 
 *      // load html template
 *      Html html = mixer2Engine.loadHtmlTemplate(resourceLoader.getResource(
 *              mainTemplate).getInputStream());
 *              
 *      Div div = html.getById("message", Div.class);
 *      div.unsetContent();
 *      div.getContent().add(model.get("helloMessage"));
 *      
 *      return html;
 *   }
 * </code></pre>
 * 
 * @deprecated use {@link org.mixer2.spring.webmvc.AbstractMixer2XhtmlView}
 * @see Mixer2XhtmlViewResolver
 * @author nabedge
 * 
 */
@Deprecated
public abstract class AbstractMixer2XhtmlView extends AbstractView {

    private String contentType = "text/html; charset=UTF-8";

    private String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">";

    private Html html;

    private Mixer2Engine mixer2Engine;

    private Locale locale;

    abstract protected Html createHtml(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception;

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Assert.notNull(getMixer2Engine());
        Html html = createHtml(model, request, response);
        Assert.notNull(html);

        response.setContentType(getContentType());
        PrintWriter writer = response.getWriter();
        StringBuilder sb = new StringBuilder();
        if (getDocType() != null) {
            sb.append(getDocType().trim());
            sb.append(System.getProperty("line.separator"));
        }
        sb.append(getMixer2Engine().saveToString(html).trim());
        writer.write(sb.toString());
        writer.close();
        sb = null;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Html getHtml() {
        return html;
    }

    public void setHtml(Html html) {
        this.html = html;
    }

    public Mixer2Engine getMixer2Engine() {
        return mixer2Engine;
    }

    public void setMixer2Engine(Mixer2Engine mixer2Engine) {
        this.mixer2Engine = mixer2Engine;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return this.locale;
    }

}

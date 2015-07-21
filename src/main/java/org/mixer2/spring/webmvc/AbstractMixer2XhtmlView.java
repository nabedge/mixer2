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

/**
 * Abstract class to create view class for Spring MVC.
 * <p>
 * use this class with {@link Mixer2XhtmlViewResolver}
 * </p>
 * 
 * <b>implementation sample</b>
 * 
 * <pre><code>
 * public class HelloWorldView extends AbstractMixer2XhtmlView {
 * 
 *    {@literal @}Autowired
 *    private FooBar fooBar;
 * 
 *    {@literal @}Override
 *    protected Html renderHtml(Html html, Map&lt;String, Object&gt; model, HttpServletRequest request,
 *          HttpServletResponse response) throws TagTypeUnmatchException {
 *        
 *        {@literal @}SuppressWarnings("unchecked")
 *        String message = (String) model.get("helloMessage");
 *        Div div = html.getById("message", Div.class);
 *        div.unsetContent();
 *        div.getContent().add(message);
 *      
 *        return html;
 * }
 * </code></pre>
 * 
 * <p>
 * You NEED NOT to add "@Component" annotation because 
 * {@link Mixer2XhtmlViewResolver} instantiate the view class
 * through AutowireCapableBeanFactory.
 * </p>
 * 
 * @see <a href="http://mixer2.org/site/helloworld.html">helloworld</a>
 * @see <a href="http://mixer2.org/site/springmvcsample.html">spring mvc sample</a>
 * @see <a href="https://github.com/nabedge/mixer2-sample/tree/master/mixer2-fruitshop-springboot">spring mvc sample code</a>
 * @author kazuki43zoo
 * @author nabedge
 * 
 */
public abstract class AbstractMixer2XhtmlView extends AbstractUrlBasedView {

    private static String lineBreakChar = System.getProperty("line.separator");

    protected ResourceLoader resourceLoader;

    protected String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">";

    protected Mixer2Engine mixer2Engine;

    public static final AbstractMixer2XhtmlView createDefaultView() {
        return new AbstractMixer2XhtmlView() {
            @Override
            protected Html renderHtml(Html templateHtml,
                    Map<String, Object> model, HttpServletRequest request,
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

    public String getDocType() {
    	return docType;
    }
    
    public void setMixer2Engine(Mixer2Engine mixer2Engine) {
        this.mixer2Engine = mixer2Engine;
    }

    public Mixer2Engine getMixer2Engine() {
        return mixer2Engine;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader setResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        Assert.notNull(mixer2Engine, "Property 'mixer2Engine' is required.");
        Assert.notNull(resourceLoader, "Property 'resourceLoader' is required.");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Html templateHtml = mixer2Engine
                .checkAndLoadHtmlTemplate(resourceLoader.getResource(getUrl())
                        .getInputStream());
        Html renderedHtml = renderHtml(templateHtml, model, request, response);
        response.setContentType(getContentType());
        responseHtml(renderedHtml, response);
    }

    protected void responseHtml(Html renderedHtml, HttpServletResponse response)
            throws IOException {
        PrintWriter writer = response.getWriter();
        StringBuilder sb = new StringBuilder();
        if (docType != null && !docType.trim().isEmpty()) {
            sb.append(docType.trim());
            sb.append(lineBreakChar);
        }
        sb.append(getMixer2Engine().saveToString(renderedHtml).trim());
        writer.write(modifyHtmlStringHook(sb.toString()));
    }

    /**
     * Override this method if you modify html as string right before http response.
     * 
     * @param htmlString String object that is saveToString()ed by mixer2Engine.
     * @return
     */
    protected String modifyHtmlStringHook(String htmlString) {
        return htmlString;
    }

    /**
     * Need implementation.
     * 
     * @param html
     *            {@link org.mixer2.jaxb.xhtml.Html Html} instance of xhtml
     *            template that is loaded by {@link Mixer2XhtmlViewResolver}.
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     * {@link Mixer2XhtmlViewResolver}
     */
    protected abstract Html renderHtml(Html html, Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception;

}

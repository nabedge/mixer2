package org.mixer2.springmvc;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.springframework.web.servlet.view.AbstractView;

/**
 * View for SpringMVC .
 * <p>
 * A method of Controller can return this type.
 * (You need not to use JSP.)
 * </p>
 *
 * <h4>your should add dependency for your application:</h4>
 *
 * <pre>{@code
 *   <dependency>
 *     <groupId>org.springframework</groupId>
 *     <artifactId>spring-webmvc</artifactId>
 *     <version>3.1.2.RELEASE (or higher)</version>
 *   </dependency>
 * }</pre>
 *
 * <h4>Controller Sample</h4>
 *
 * <pre><code>
 *   {@literal @}Controller
 *   public class FooController {
 *
 *     {@literal @}Autowired
 *     Mixer2Engine mixer2Engine;
 *
 *     {@literal @}Autowired
 *     ResourceLoader resourceLoader;
 *
 *     {@literal @}RequestMapping(value = "/foo")
 *     public Mixer2XhtmlView foo() {
 *         String template = "classpath:HelloWorld.html";
 *         Html html = mixer2Engine.loadHtmlTemplate(
 *             resourceLoader.getResource(template).getInputStream());
 *         html.getById("hellomsg", Div.class).getContent().clear();
 *         html.getById("hellomsg", Div.class).getContent().add("Hello Mixer2 !");
 *         return new Mixer2XhtmlView(mixer2Engine, html);
 *     }
 *
 *     {@literal @}RequestMapping(value = "/bar")
 *     public ModelAndView bar() {
 *         String template = "classpath:HelloWorld.html";
 *         Html html = mixer2Engine.loadHtmlTemplate(
 *             resourceLoader.getResource(template).getInputStream());
 *         html.getById("hellomsg", Div.class).getContent().clear();
 *         html.getById("hellomsg", Div.class).getContent().add("Life is beautiful !");
 *
 *         // You can also set Mixer2XhtmlView into normal ModelAndView .
 *         ModelAndView modelAndView = new ModelAndView();
 *         modelAndView.setView(new Mixer2XhtmlView(mixer2Engine, html));
 *         return modelAndView;
 *     }
 *   }
 * </code></pre>
 *
 */
public class Mixer2XhtmlView extends AbstractView {

    private String contentType = "text/html; charset=UTF-8";

    private String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">";

    private Html html;

    private Mixer2Engine mixer2Engine;

    public Mixer2XhtmlView(Mixer2Engine mixer2Engine, Html html) {
        this.mixer2Engine = mixer2Engine;
        this.html = html;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        response.setContentType(getContentType());
        PrintWriter writer = response.getWriter();
        StringBuffer sb = new StringBuffer();
        if (docType != null) {
            sb.append(docType.trim());
            sb.append(File.separator);
        }
        sb.append(getMixer2Engine().saveToString(getHtml()).trim());
        writer.write(sb.toString());
        writer.close();
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

}

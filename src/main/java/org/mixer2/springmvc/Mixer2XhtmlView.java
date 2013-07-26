package org.mixer2.springmvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.springframework.util.Assert;

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
 *         html.getById("hellomsg", Div.class).unsetContent();
 *         html.getById("hellomsg", Div.class).getContent().add("Hello Mixer2 !");
 *         return new Mixer2XhtmlView(mixer2Engine, html);
 *     }
 *
 *     {@literal @}RequestMapping(value = "/bar")
 *     public ModelAndView bar() {
 *         String template = "classpath:HelloWorld.html";
 *         Html html = mixer2Engine.loadHtmlTemplate(
 *             resourceLoader.getResource(template).getInputStream());
 *         html.getById("hellomsg", Div.class).unsetContent();
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
 * <p>
 * Also, You can implement the original view class  
 * using {@link AbstractMixer2XhtmlView}
 * </p>
 */
public class Mixer2XhtmlView extends AbstractMixer2XhtmlView {

    public Mixer2XhtmlView(Mixer2Engine mixer2Engine, Html html) {
        Assert.notNull(mixer2Engine);
        Assert.notNull(html);
        setMixer2Engine(mixer2Engine);
        setHtml(html);
    }
    
    @Override
    protected Html createHtml(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return getHtml();
    }

}

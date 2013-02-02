package org.mixer2.springmvc;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Html;
import org.springframework.core.Ordered;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

/**
 * View Resolver for SpringMVC .<br>
 * If a controller method returns org.mixer2.xhtml.Html,
 * this view resolver catch it and returns {@link Mixer2XhtmlView}.
 * <br>
 * your should add dependency for your application:
 *
 * <pre>{@code
 *   <dependency>
 *     <groupId>org.springframework</groupId>
 *     <artifactId>spring-webmvc</artifactId>
 *     <version>3.1.2.RELEASE (or higher)</version>
 *   </dependency>
 * }</pre>
 *
 * <h4>Spring bean definition</h4>
 *
 * <pre>{@code
 *   <beans>
 *     <bean id="mixer2Engine" class="org.mixer2.Mixer2Engine" scope="singleton"/>
 *     <bean
 *         class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
 *         <property name="customModelAndViewResolvers">
 *             <list>
 *                 <bean class="org.mixer2.springmvc.Mixer2XhtmlViewResolver">
 *                     <property name="mixer2Engine" ref="mixer2Engine"/>
 *                 </bean>
 *             </list>
 *         </property>
 *         <property name="order" value="0"/>
 *     </bean>
 *     <!-- NOTICE! You should NOT use mvc:annotation-driven if you use custom AnnotationMethodHandlerAdapter  -->
 *     <!-- <mvc:annotation-driven/> -->
 *   </beans>
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
 *     {@literal @}RequestMapping(value = "/bar")
 *     public Html bar() {
 *         String template = "classpath:HelloWorld.html";
 *         Html html = m2e.loadHtmlTemplate(
 *             resourceLoader.getResource(template).getInputStream());
 *         html.getById("hellomsg", Div.class).getContent().clear();
 *         html.getById("hellomsg", Div.class).getContent().add("Hello Mixer2 !");
 *         return html;
 *     }
 *
 *   }
 * </code></pre>
 *
 */
public class Mixer2XhtmlViewResolver implements ModelAndViewResolver, Ordered {

    private static Log log = LogFactory.getLog(ModelAndViewResolver.class);

    private Mixer2Engine mixer2Engine;

    private String contentType = "text/html; charset=UTF-8";

    private String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">";

    private int order = 0;

    public Mixer2XhtmlViewResolver() {
        log.debug("Mixer2XhtmlViewResolver initialized.");
    }

    @Override
    public ModelAndView resolveModelAndView(Method handlerMethod,
            @SuppressWarnings("rawtypes") Class handlerType,
            Object returnValue, ExtendedModelMap implicitModel,
            NativeWebRequest webRequest) {

        if (returnValue instanceof org.mixer2.jaxb.xhtml.Html) {
            log.debug("returnValue is org.mixer2.jaxb.xhtml.Html . making Mixer2XhtmlView... ");
            Html html = (Html) returnValue;
            Mixer2XhtmlView view = new Mixer2XhtmlView();
            view.setContentType(getContentType());
            view.setDocType(getDocType());
            view.setMixer2Engine(getMixer2Engine());
            ModelAndView mv = new ModelAndView();
            mv.setView(view);
            implicitModel.put(org.mixer2.jaxb.xhtml.Html.class.getName(), html);
            mv.addAllObjects(implicitModel);
            return mv;
        }
        return UNRESOLVED;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Mixer2Engine getMixer2Engine() {
        return mixer2Engine;
    }

    public void setMixer2Engine(Mixer2Engine mixer2Engine) {
        this.mixer2Engine = mixer2Engine;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

}

package org.mixer2.springmvc;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.Mixer2Engine;
import org.springframework.beans.BeansException;
import org.springframework.core.Ordered;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * View Resolver for SpringMVC .<br>
 * your should add dependency for your application:
 *
 * <pre>{@code
 * <dependency>
 *     <groupId>org.springframework</groupId>
 *     <artifactId>spring-webmvc</artifactId>
 *     <version>3.1.2.RELEASE (or higher)</version>
 * </dependency>
 * }</pre>
 *
 * <b>Spring MVC configuration Sample</b>
 *
 * <pre>{@code
 * <bean id="mixer2Engine" class="org.mixer2.Mixer2Engine" />
 * <bean class="org.mixer2.springmvc.Mixer2XhtmlViewResolver">
 *     <property name="mixer2Engine" ref="mixer2Engine" />
 *     <property name="order" value="1" />
 * </bean>
 * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 *      <property name="order" value="2" />
 * </bean>
 * }</pre>
 * 
 * <p>
 * Using this ViewResolver, 
 * Your controller method can returns 
 * <strong>view class name as String</strong>.<br>
 * See also {@link AbstractMixer2XhtmlView}.
 * </p>
 * 
 * <pre><code>
 * {@literal @}Controller
 * public class HelloWorldController {
 *
 *  {@literal @}Autowired
 *  protected helloMessageService helloMessageService;
 *
 *  {@literal @}RequestMapping(value = "/hello", method = RequestMethod.GET)
 *  public String showHello({@literal @}PathVariable long itemId, Model model) {
 *      String helloMessage = helloMessageService.getMessage();
 *      model.addAttribute("helloMessage", helloMessage);
 *      return "helloWorldView"; // attach "HelloWorldView" class.
 *  }
 * }
 * </code></pre>
 * 
 * @deprecated use {@link org.mixer2.spring.webmvc.Mixer2XhtmlViewResolver}
 * @see AbstractMixer2XhtmlView
 * @author nabedge
 *
 */
@Deprecated
public class Mixer2XhtmlViewResolver extends WebApplicationObjectSupport
        implements ViewResolver, Ordered {

    protected Mixer2Engine mixer2Engine;

    private static Log log = LogFactory.getLog(Mixer2XhtmlViewResolver.class);

    private int order = Integer.MAX_VALUE;

    @Override
    public View resolveViewName(String viewName, Locale locale) {
        WebApplicationContext wac = getWebApplicationContext();
        AbstractMixer2XhtmlView view = null;
        try {
            view = wac.getBean(viewName, AbstractMixer2XhtmlView.class);
            view.setMixer2Engine(mixer2Engine);
            view.setLocale(locale);
        } catch (BeansException e) {
            log.debug(e.getMessage());
            return null;
        }
        return view;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setMixer2Engine(Mixer2Engine mixer2Engine) {
        this.mixer2Engine = mixer2Engine;
    }

    public Mixer2Engine getMixer2Engine() {
        return this.mixer2Engine;
    }

}

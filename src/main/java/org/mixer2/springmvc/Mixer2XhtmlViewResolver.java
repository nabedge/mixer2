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

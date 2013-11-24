package org.mixer2.spring.webmvc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.spring.webmvc.foo.BarView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class Mixer2XhtmlViewResolverTest {

    @Configuration
    static class ContextConfiguration {
        @Bean
        public Mixer2Engine mixer2Engine() {
            return new Mixer2Engine();
        }
        @Bean
        public Mixer2XhtmlViewResolver mixer2XhtmlViewResolver() {
            Mixer2XhtmlViewResolver resolver = new Mixer2XhtmlViewResolver();
            resolver.setOrder(1);
            resolver.setPrefix("classpath:org/mixer2/spring/webmvc/");
            resolver.setSuffix(".html");
            resolver.setBasePackage("org.mixer2.spring.webmvc");
            resolver.setMixer2Engine(mixer2Engine());
            return resolver;
        }
    }
    
    @Autowired
    private Mixer2Engine mixer2Engine;
    
    @Autowired
    private Mixer2XhtmlViewResolver resolver;
    
    @Test
    public final void useAbstractMixer2XhtmlViewAsDefault() throws Exception {
        AbstractUrlBasedView view = resolver.buildView("HelloWorld");
        assertTrue(view instanceof AbstractMixer2XhtmlView);
        
        AbstractMixer2XhtmlView m2View = (AbstractMixer2XhtmlView) view;
        Map<String,Object> model = new HashMap<String,Object>();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        m2View.renderMergedOutputModel(model, request, response);
        
        Html html = mixer2Engine.loadHtmlTemplate(response.getContentAsString());
        Div div = html.getBody().getById("hellomsg",Div.class);
        String msg = div.getContent().get(0).toString().trim();
        assertThat(msg, is("Hello World !"));
    }

    @Test
    public final void useImplementedView() throws Exception {
        AbstractUrlBasedView view = resolver.buildView("Mixer2XhtmlViewResolverTest");
        assertTrue(view instanceof Mixer2XhtmlViewResolverTestView);

        Mixer2XhtmlViewResolverTestView m2View = (Mixer2XhtmlViewResolverTestView) view;
        Map<String,Object> model = new HashMap<String,Object>();
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        m2View.renderMergedOutputModel(model, request, response);
        
        Html html = mixer2Engine.loadHtmlTemplate(response.getContentAsString());
        Span span = html.getBody().getById("newSpan", Span.class);
        assertThat(span.getContent().get(0).toString(), is("new span"));
    }

    @Test
    public final void pathSeparatedTest() throws Exception {
        AbstractUrlBasedView view = resolver.buildView("foo/bar");
        assertTrue(view instanceof BarView);

        BarView barView = (BarView) view;
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("barMessage", "Hello Bar !");
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        barView.renderMergedOutputModel(model, request, response);

        Html html = mixer2Engine.loadHtmlTemplate(response.getContentAsString());
        Span span = html.getBody().getById("barSpan", Span.class);
        assertThat(span.getContent().get(0).toString(), is("Hello Bar !"));
    }
}

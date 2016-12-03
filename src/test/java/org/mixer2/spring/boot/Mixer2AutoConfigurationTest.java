package org.mixer2.spring.boot;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mixer2.Mixer2Engine;
import org.mixer2.jaxb.exception.Mixer2JAXBException;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.spring.boot.app.view.CustomScreenView;
import org.mixer2.spring.boot.config.SubPackageAppConfig;
import org.mixer2.spring.boot.web.view.DefaultView;
import org.mixer2.spring.webmvc.AbstractMixer2XhtmlView;
import org.mixer2.spring.webmvc.Mixer2XhtmlViewResolver;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.View;

import java.util.Locale;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class Mixer2AutoConfigurationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private AnnotationConfigApplicationContext context;

    @Before
    public void init() {
        this.context = new AnnotationConfigApplicationContext();
    }

    @After
    public void closeContext() {
        if (this.context != null) {
            this.context.close();
        }
    }

    @Test
    public void testDefaultConfiguration() throws Exception {
        this.context.register(AppConfig.class, Mixer2AutoConfiguration.class);
        this.context.refresh();

        assertThat(this.context.getBeanNamesForType(Mixer2Engine.class).length, is(1));

        Mixer2XhtmlViewResolver viewResolver = this.context.getBean(Mixer2XhtmlViewResolver.class);
        assertThat(viewResolver.getOrder(), is(1));
        assertThat(viewResolver.isCache(), is(true));
        assertThat(viewResolver.getCacheLimit(), is(1024));
        assertThat(viewResolver.isCacheUnresolved(), is(true));

        DefaultView view = (DefaultView) viewResolver.resolveViewName("default", Locale.US);
        MockHttpServletResponse response = new MockHttpServletResponse();
        view.render(null, new MockHttpServletRequest(), response);
        assertThat(response.getContentAsString(), is("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<body>default</body>\n</html>"));
        assertThat(response.getContentType(), is("text/html; charset=UTF-8"));

    }

    @Test
    public void testCustomUsingProperties() throws Exception {
        EnvironmentTestUtils.addEnvironment(this.context,
            "mixer2.order:0",
            "mixer2.prefix:classpath:/m2mockup/custom-templates/",
            "mixer2.suffix:.htm",
            "mixer2.view-base-package:org.mixer2.spring.boot.app.view",
            "mixer2.view-class-name-suffix:ScreenView",
            "mixer2.content-type:text/html; charset=UTF-16",
            "mixer2.doc-type:<!DOCTYPE html>");
        this.context.register(AppConfig.class, Mixer2AutoConfiguration.class);
        this.context.refresh();

        assertThat(this.context.getBeanNamesForType(Mixer2Engine.class).length, is(1));
        Mixer2XhtmlViewResolver viewResolver = this.context.getBean(Mixer2XhtmlViewResolver.class);
        assertThat(viewResolver.getOrder(), is(0));

        CustomScreenView view = (CustomScreenView) viewResolver.resolveViewName("custom", Locale.US);
        MockHttpServletResponse response = new MockHttpServletResponse();
        view.render(null, new MockHttpServletRequest(), response);
        assertThat(response.getContentAsString(), is("<!DOCTYPE html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<body>custom default</body>\n</html>"));
        assertThat(response.getContentType(), is("text/html; charset=UTF-16"));
    }

    @Test
    public void testCustomCacheIsFalseUsingProperties() throws Exception {
        EnvironmentTestUtils.addEnvironment(this.context,
            "mixer2.cache:false",
            "mixer2.cache-limit:4000",
            "mixer2.cache-unresolved:false");
        this.context.register(AppConfig.class, Mixer2AutoConfiguration.class);
        this.context.refresh();

        assertThat(this.context.getBeanNamesForType(Mixer2Engine.class).length, is(1));
        Mixer2XhtmlViewResolver viewResolver = this.context.getBean(Mixer2XhtmlViewResolver.class);
        assertThat(viewResolver.isCache(), is(false));
        assertThat(viewResolver.getCacheLimit(), is(0));
        assertThat(viewResolver.isCacheUnresolved(), is(true));

    }

    @Test
    public void testCustomCacheParametersUsingProperties() throws Exception {
        EnvironmentTestUtils.addEnvironment(this.context,
            "mixer2.cache:true",
            "mixer2.cache-limit:512",
            "mixer2.cache-unresolved:false");
        this.context.register(AppConfig.class, Mixer2AutoConfiguration.class);
        this.context.refresh();

        assertThat(this.context.getBeanNamesForType(Mixer2Engine.class).length, is(1));
        Mixer2XhtmlViewResolver viewResolver = this.context.getBean(Mixer2XhtmlViewResolver.class);
        assertThat(viewResolver.isCache(), is(true));
        assertThat(viewResolver.getCacheLimit(), is(512));
        assertThat(viewResolver.isCacheUnresolved(), is(false));
    }

    @Test
    public void testNotFoundTemplateFileOnDefaultConfiguration() throws Exception {
        this.context.register(AppConfig.class, Mixer2AutoConfiguration.class);
        this.context.refresh();

        Mixer2XhtmlViewResolver viewResolver = this.context.getBean(Mixer2XhtmlViewResolver.class);
        View view = viewResolver.resolveViewName("foo", Locale.US);
        assertThat(view, nullValue());
    }

    @Test
    public void testNotFoundTemplateFileOnReturnNullIfTemplateFileNotFoundIsFalse() throws Exception {
        EnvironmentTestUtils.addEnvironment(this.context,
            "mixer2.return-null-if-template-file-not-found:false");
        this.context.register(AppConfig.class, Mixer2AutoConfiguration.class);
        this.context.refresh();

        Mixer2XhtmlViewResolver viewResolver = this.context.getBean(Mixer2XhtmlViewResolver.class);
        AbstractMixer2XhtmlView view = (AbstractMixer2XhtmlView) viewResolver.resolveViewName("foo", Locale.US);
        assertThat(view.getUrl(), is("classpath:/m2mockup/templates/foo.html"));
    }


    @Test
    public void testNotFoundViewClassOnDefaultConfiguration() throws Exception {
        this.context.register(AppConfig.class, Mixer2AutoConfiguration.class);
        this.context.refresh();

        Mixer2XhtmlViewResolver viewResolver = this.context.getBean(Mixer2XhtmlViewResolver.class);
        View view = viewResolver.resolveViewName("bar", Locale.US);
        MockHttpServletResponse response = new MockHttpServletResponse();
        view.render(null, new MockHttpServletRequest(), response);
        assertThat(response.getContentAsString(), is("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<body>bar</body>\n</html>"));
        assertThat(response.getContentType(), is("text/html; charset=UTF-8"));

    }

    @Test
    public void testNotFoundViewClassOnRaiseErrorIfViewClassNotFoundIsTrue() throws Exception {
        EnvironmentTestUtils.addEnvironment(this.context,
            "mixer2.raise-error-if-view-class-not-found:true");
        this.context.register(AppConfig.class, Mixer2AutoConfiguration.class);
        this.context.refresh();

        expectedException.expect(ClassNotFoundException.class);
        expectedException.expectMessage(is("org.mixer2.spring.boot.web.view.BarView"));

        Mixer2XhtmlViewResolver viewResolver = context.getBean(Mixer2XhtmlViewResolver.class);
        viewResolver.resolveViewName("bar", Locale.US);

    }


    @Test
    public void testFoundMultipleBasePackage() throws Exception {
        EnvironmentTestUtils.addEnvironment(this.context,
            "mixer2.raise-error-if-view-class-not-found:true");
        this.context.register(AppConfig.class, SubPackageAppConfig.class, Mixer2AutoConfiguration.class);
        this.context.refresh();

        expectedException.expect(ClassNotFoundException.class);
        expectedException.expectMessage(is("BarView"));

        Mixer2XhtmlViewResolver viewResolver = this.context.getBean(Mixer2XhtmlViewResolver.class);
        viewResolver.resolveViewName("bar", Locale.US);

    }

    @Test
    public void testCustomConfiguration() throws Mixer2JAXBException {
        this.context.register(CustomConfig.class, Mixer2AutoConfiguration.class);
        this.context.refresh();

        Mixer2Engine engine = this.context.getBean(Mixer2Engine.class);
        try {
            engine.checkAndLoadHtmlTemplate("foo");
        } catch (UnsupportedOperationException e) {
            assertThat(e.getMessage(), is("error"));
        }

        Mixer2XhtmlViewResolver viewResolver = this.context.getBean(Mixer2XhtmlViewResolver.class);
        assertThat(viewResolver.isCache(), is(false));

    }

    @SpringBootApplication
    static class AppConfig {
    }

    static class CustomConfig {

        @Bean
        Mixer2Engine mixer2Engine() {
            return new Mixer2Engine() {
                @Override
                public Html checkAndLoadHtmlTemplate(String str) throws Mixer2JAXBException {
                    throw new UnsupportedOperationException("error");
                }
            };
        }

        @Bean
        Mixer2XhtmlViewResolver mixer2XhtmlViewResolver() {
            Mixer2XhtmlViewResolver viewResolver = new Mixer2XhtmlViewResolver();
            viewResolver.setCache(false);
            return viewResolver;
        }

    }

}

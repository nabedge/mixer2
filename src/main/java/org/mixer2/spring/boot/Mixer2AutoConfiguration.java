package org.mixer2.spring.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.Mixer2Engine;
import org.mixer2.spring.webmvc.Mixer2XhtmlViewResolver;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

import java.util.List;

@Configuration
@ConditionalOnClass(Mixer2Engine.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(Mixer2Properties.class)
public class Mixer2AutoConfiguration {

    private static Log log = LogFactory.getLog(Mixer2AutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public Mixer2Engine mixer2Engine() {
        return new Mixer2Engine();
    }

    @Configuration
    @ConditionalOnClass(ViewResolver.class)
    public static class Mixer2ViewConfiguration {

        private final Mixer2Engine mixer2Engine;
        private final Mixer2Properties properties;
        private final BeanFactory beanFactory;

        @Autowired
        public Mixer2ViewConfiguration(Mixer2Engine mixer2Engine, Mixer2Properties properties, BeanFactory beanFactory) {
            this.mixer2Engine = mixer2Engine;
            this.properties = properties;
            this.beanFactory = beanFactory;
        }

        @Bean
        @ConditionalOnMissingBean
        public Mixer2XhtmlViewResolver mixer2XhtmlViewResolver() {
            Mixer2XhtmlViewResolver resolver = new Mixer2XhtmlViewResolver();
            resolver.setOrder(properties.getOrder());
            resolver.setMixer2Engine(this.mixer2Engine);
            resolver.setPrefix(properties.getPrefix());
            resolver.setSuffix(properties.getSuffix());
            if (properties.getViewBasePackage() != null) {
                resolver.setBasePackage(properties.getViewBasePackage());
            } else if (AutoConfigurationPackages.has(beanFactory)) {
                List<String> packages = AutoConfigurationPackages.get(beanFactory);
                if (packages.size() == 1) {
                    String viewBasePackage = packages.get(0) + ".web.view";
                    resolver.setBasePackage(viewBasePackage);
                    if (log.isDebugEnabled()) {
                        log.debug("Apply '" + viewBasePackage + "' to the base package of view.");
                    }
                } else {
                    if (log.isDebugEnabled()) {
                        log.debug("Skip auto-detecting base package of view because found multiple base packages. found base packages : " + packages);
                    }
                }
            }
            if (properties.getViewClassNameSuffix() != null) {
                resolver.setClassNameSuffix(properties.getViewClassNameSuffix());
            }
            if (properties.getContentType() != null) {
                resolver.setContentType(properties.getContentType());
            }
            if (properties.getDocType() != null) {
                resolver.setDocType(properties.getDocType());
            }
            if (properties.getReturnNullIfTemplateFileNotFound() != null) {
                resolver.setReturnNullIfTemplateFileNotFound(properties.getReturnNullIfTemplateFileNotFound());
            }
            if (properties.getRaiseErrorIfViewClassNotFound() != null) {
                resolver.setRaiseErrorIfViewClassNotFound(properties.getRaiseErrorIfViewClassNotFound());
            }
            if (properties.getCache() != null) {
                resolver.setCache(properties.getCache());
            }
            if (resolver.isCache()) {
                if (properties.getCacheLimit() != null) {
                    resolver.setCacheLimit(properties.getCacheLimit());
                }
                if (properties.getCacheUnresolved() != null) {
                    resolver.setCacheUnresolved(properties.getCacheUnresolved());
                }
            }
            return resolver;
        }

    }

}

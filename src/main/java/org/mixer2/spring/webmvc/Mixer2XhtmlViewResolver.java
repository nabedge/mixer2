package org.mixer2.spring.webmvc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.Mixer2Engine;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class Mixer2XhtmlViewResolver extends UrlBasedViewResolver {

    private static final String PATH_SEPARATOR = "/";

    private static final String PACKAGE_SEPARATOR = ".";

    private static final Pattern PATH_SEPARATOR_PATTERN = Pattern.compile(PATH_SEPARATOR);

    private static Log log = LogFactory.getLog(Mixer2XhtmlViewResolver.class);

    private Mixer2Engine mixer2Engine;

    private String basePackage = "";

    private String classNameSuffix = "View";

    private String docType;

    public Mixer2XhtmlViewResolver() {
        setViewClass(AbstractMixer2XhtmlView.class);
    }

    public void setMixer2Engine(Mixer2Engine mixer2Engine) {
        this.mixer2Engine = mixer2Engine;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setClassNameSuffix(String classNameSuffix) {
        this.classNameSuffix = classNameSuffix;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    protected AbstractUrlBasedView buildView(String viewName) throws Exception {

        // create view object.
        AbstractMixer2XhtmlView view = null;
        String fqcnOfView = (StringUtils.hasLength(basePackage) ? basePackage + PACKAGE_SEPARATOR : "")
                + toViewClassNamePrefix(viewName) + (StringUtils.hasLength(classNameSuffix) ? classNameSuffix : "");
        try {
            Class<?> viewClass = ClassUtils.forName(fqcnOfView, ClassUtils.getDefaultClassLoader());
            view = BeanUtils.instantiateClass(viewClass, AbstractMixer2XhtmlView.class);
            getApplicationContext().getAutowireCapableBeanFactory().autowireBean(view);
        } catch (ClassNotFoundException e) {
            view = createDefaultView();
            log.debug("Applied default view. viewName is '" + viewName + "'. fqcnOfView is '" + fqcnOfView + "'.");
        }

        // inject properties of AbstractMixer2XhtmlView.
        view.setMixer2Engine(mixer2Engine);
        view.setResourceLoader(getApplicationContext());
        if (docType != null) {
            view.setDocType(docType);
        }

        // inject properties of parent class.
        view.setUrl(getPrefix() + viewName + getSuffix());
        String contentType = getContentType();
        if (contentType != null) {
            view.setContentType(contentType);
        }
        view.setRequestContextAttribute(getRequestContextAttribute());
        view.setAttributesMap(getAttributesMap());
        return view;
    }

    protected String toViewClassNamePrefix(String viewName) {
        if (viewName.contains(PATH_SEPARATOR)) {
            int lastIndexOfPathSeparator = viewName.lastIndexOf(PATH_SEPARATOR);
            Matcher pathSeparatorMatcher = PATH_SEPARATOR_PATTERN.matcher(viewName.substring(0,
                    lastIndexOfPathSeparator));
            String packageName = pathSeparatorMatcher.replaceAll(PACKAGE_SEPARATOR);
            String lastElement = viewName.substring(lastIndexOfPathSeparator + 1);
            return packageName + PACKAGE_SEPARATOR + StringUtils.capitalize(lastElement);
        } else {
            return StringUtils.capitalize(viewName);
        }
    }

    protected AbstractMixer2XhtmlView createDefaultView() {
        return AbstractMixer2XhtmlView.createDefaultView();
    }

}

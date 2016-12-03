package org.mixer2.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

@ConfigurationProperties(prefix = "mixer2")
public class Mixer2Properties implements Serializable {

    private static final long serialVersionUID = -8282705230257476884L;

    private int order = 1;

    private String prefix = "classpath:/m2mockup/templates/";

    private String suffix = ".html";

    private String viewBasePackage;

    private String viewClassNameSuffix;

    private String docType;

    private String contentType;

    private Boolean returnNullIfTemplateFileNotFound;

    private Boolean raiseErrorIfViewClassNotFound;

    private Integer cacheLimit;

    private Boolean cacheUnresolved;

    private Boolean cache;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getViewBasePackage() {
        return viewBasePackage;
    }

    public void setViewBasePackage(String viewBasePackage) {
        this.viewBasePackage = viewBasePackage;
    }

    public String getViewClassNameSuffix() {
        return viewClassNameSuffix;
    }

    public void setViewClassNameSuffix(String viewClassNameSuffix) {
        this.viewClassNameSuffix = viewClassNameSuffix;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Boolean getReturnNullIfTemplateFileNotFound() {
        return returnNullIfTemplateFileNotFound;
    }

    public void setReturnNullIfTemplateFileNotFound(Boolean returnNullIfTemplateFileNotFound) {
        this.returnNullIfTemplateFileNotFound = returnNullIfTemplateFileNotFound;
    }

    public Boolean getRaiseErrorIfViewClassNotFound() {
        return raiseErrorIfViewClassNotFound;
    }

    public void setRaiseErrorIfViewClassNotFound(Boolean raiseErrorIfViewClassNotFound) {
        this.raiseErrorIfViewClassNotFound = raiseErrorIfViewClassNotFound;
    }

    public Integer getCacheLimit() {
        return cacheLimit;
    }

    public void setCacheLimit(Integer cacheLimit) {
        this.cacheLimit = cacheLimit;
    }

    public Boolean getCacheUnresolved() {
        return cacheUnresolved;
    }

    public void setCacheUnresolved(Boolean cacheUnresolved) {
        this.cacheUnresolved = cacheUnresolved;
    }

    public Boolean getCache() {
        return cache;
    }

    public void setCache(Boolean cache) {
        this.cache = cache;
    }

}

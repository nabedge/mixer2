package org.mixer2.xhtml;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @deprecated Misspelled class name. use {@link PathAdjuster}
 */
@Deprecated
public class PathAjuster {

    public static <T extends AbstractJaxb> void replacePath(T target,
            Pattern pattern, String replacement) {
        PathAdjuster.replacePath(target, pattern, replacement);
    }

    public static <T extends AbstractJaxb> void replacePathIncludeClass(
            T target, Pattern pattern, String replacement,
            List<String> includeClazz) {
        PathAdjuster.replacePathIncludeClass(target, pattern, replacement,
                includeClazz);
    }

    public static <T extends AbstractJaxb> void replacePathIncludeTag(T target,
            Pattern pattern, String replacement, List<Class<?>> includeTagType) {
        PathAdjuster.replacePathIncludeTag(target, pattern, replacement,
                includeTagType);
    }

    public static <T extends AbstractJaxb> void replacePathInclude(T target,
            Pattern pattern, String replacement, List<String> includeClazz,
            List<Class<?>> includeTagType) {
        PathAdjuster.replacePathInclude(target, pattern, replacement,
                includeClazz, includeTagType);
    }

    public static <T extends AbstractJaxb> void replacePathExcludeClass(
            T target, Pattern pattern, String replacement,
            List<String> excludeClazz) {
        PathAdjuster.replacePathExcludeClass(target, pattern, replacement,
                excludeClazz);
    }

    public static <T extends AbstractJaxb> void replacePathExcludeTag(T target,
            Pattern pattern, String replacement, List<Class<?>> excludeTagType) {
        PathAdjuster.replacePathExcludeTag(target, pattern, replacement,
                excludeTagType);
    }

    public static <T extends AbstractJaxb> void replacePathExclude(T target,
            Pattern pattern, String replacement, List<String> excludeClazz,
            List<Class<?>> excludeTagType) {
        PathAdjuster.replacePathExclude(target, pattern, replacement,
                excludeClazz, excludeTagType);
    }

}

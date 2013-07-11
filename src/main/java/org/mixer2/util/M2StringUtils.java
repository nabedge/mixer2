package org.mixer2.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class M2StringUtils {

    private static Log log = LogFactory.getLog(M2StringUtils.class);

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !M2StringUtils.isEmpty(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !M2StringUtils.isBlank(str);
    }

    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        List<String> list = Arrays.asList("log", "serialVersionUID");
        for (Field field : type.getDeclaredFields()) {
            String name = field.getName();
            if (! list.contains(name)) {
                fields.add(field);
            }
        }
        if (type.getSuperclass() != null) {
            fields = getAllFields(fields, type.getSuperclass());
        }
        return fields;
    }

    public static String stringifier(Object bean) {
        StringBuilder sb = new StringBuilder();
        List<Field> fields = getAllFields(new LinkedList<Field>(),
                bean.getClass());
        sb.append(bean.getClass().getName() + "[");
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = null;
            try {
                value = field.get(bean);
            } catch (IllegalArgumentException e) {
                log.warn("IllegalArgumentException", e);
            } catch (IllegalAccessException e) {
                log.warn("IllegalAccessException", e);
            }
            if ("otherAttributes".equals(name) && ((HashMap<?, ?>) value).isEmpty()) {
                value = null;
            }
            if (value != null) {
                sb.append(name);
                sb.append("=");
                sb.append(value);
                sb.append("");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

}

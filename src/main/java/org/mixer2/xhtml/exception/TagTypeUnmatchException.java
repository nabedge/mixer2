package org.mixer2.xhtml.exception;

/**
 * 
 * @author watanabe
 * 
 */
@SuppressWarnings("serial")
public class TagTypeUnmatchException extends Exception {

    public TagTypeUnmatchException(Class<?> expected, Class<?> actual) {
        super(expected.getName() + " expected but " + actual.getName()
                + " given.");
    }

    public TagTypeUnmatchException(String message) {
        super(message);
    }

}

package org.mixer2.util;

public class XMLStringUtil {

    private XMLStringUtil() {
    }

    /**
     * Replace XML invalid chars with one white space.
     * @param input
     * @return
     */
    public static String getXMLValidString(final String input) {
        return XMLStringUtil.getXMLValidString(input, false, ' ');
    }

    /**
     * Remove or replace XML invalid chars from input.
     * 
     * @param input
     * @param replace
     *            Whether or not to replace invalid characters by replacement
     * @param replacement
     *            The character to replace any invalid character found
     * @return The String that is cleaned from the invalid in XML characters.
     * @see #isXMLValid(char)
     */
    public static String getXMLValidString(final String input,
            final boolean replace, final char replacement) {
        if (input == null) {
            return null;
        }

        if ("".equals(input)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (XMLStringUtil.isXMLValid(c)) {
                sb.append(c);
            } else if (replace) {
                sb.append(replacement);
            }
        }
        return sb.toString();
    }

    /**
     * <p>
     * Checker for XML valid character.
     * </p>
     * <p>
     * The Valid XML char is one of:<br>
     * #x9 | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD] | [#x10000-#x10FFFF]
     * </p>
     * 
     * @see <a href="http://www.w3.org/TR/REC-xml/#charsets">http://www.w3.org/TR/REC-xml/#charsets</a>
     * 
     * @param c
     *            The <code>char</code> to test.
     * @return <code>true</code> if <code>c</code> is one of:<br>
     *         #x9 | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD].
     * 
     */
    public static boolean isXMLValid(final char c) {
        boolean result = (c == '\u0009') //
                || (c == '\n') //
                || (c == '\r') //
                || ((c >= '\u0020') && (c <= '\uD7FF')) //
                || ((c >= '\uE000') && (c <= '\uFFFD'));
        return result;
    }
}

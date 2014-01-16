package org.mixer2.xhtml;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.transform.TransformerFactory;

/**
 * Utility for create XML Factory.
 * <p>
 * This come arround to jvm bug. The hreshold is 1.7.0_40 .
 * </p>
 * 
 * @see https://github.com/nabedge/mixer2/issues/10
 * @see http://bugs.sun.com/view_bug.do?bug_id=7191547
 * @author nabedge
 * 
 */
public class XMLFactoryUtil {

    /**
     * system property key for XMLInputFactory.newFactory(factoryId, null)
     */
    public static final String XMLInputFactoryId = "org.mixer2.xhtml.XMLInputFactoryId";

    public static final String defaultXMLInputFactoryFqcn = "com.sun.xml.internal.stream.XMLInputFactoryImpl";

    /**
     * system property key for XMLOutputFactory.newFactory(factoryId, null)
     */
    public static final String XMLOutputFactoryId = "org.mixer2.xhtml.XMLOutputFactoryId";

    public static final String defaultXMLOutputFactoryFqcn = "com.sun.xml.internal.stream.XMLOutputFactoryImpl";

    /**
     * system property key for XMLEventFactory.newFactory(factoryId, null)
     */
    public static final String XMLEventFactoryId = "org.mixer2.xhtml.XMLEventFactoryId";

    public static final String defaultXMLEventFactoryFqcn = "com.sun.xml.internal.stream.events.XMLEventFactoryImpl";

    public static final String defaultTransformerFactoryFqcn = "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl";

    public static final String defaultSAXParserFactoryFqcn = "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl";

    public static XMLInputFactory newXMLInputFactory() {
        if (jvmVersionCheck()) {
            System.setProperty(XMLInputFactoryId, defaultXMLInputFactoryFqcn);
            return XMLInputFactory.newFactory(XMLInputFactoryId, null);
        } else {
            return XMLInputFactory.newFactory();
        }
    }

    public static XMLOutputFactory newXMLOutputFactory() {
        if (jvmVersionCheck()) {
            System.setProperty(XMLOutputFactoryId, defaultXMLOutputFactoryFqcn);
            return XMLOutputFactory.newFactory(XMLOutputFactoryId, null);
        } else {
            return XMLOutputFactory.newFactory();
        }
    }

    public static XMLEventFactory newXMLEventFactory() {
        if (jvmVersionCheck()) {
            System.setProperty(XMLEventFactoryId, defaultXMLEventFactoryFqcn);
            return XMLEventFactory.newFactory(XMLEventFactoryId, null);
        } else {
            return XMLEventFactory.newFactory();
        }
    }

    public static TransformerFactory newTransformerFactory() {
        return TransformerFactory.newInstance(defaultTransformerFactoryFqcn,
                null);
    }

    public static SAXParserFactory newSAXParserFactory() {
        return SAXParserFactory.newInstance(defaultSAXParserFactoryFqcn, null);
    }

    public static boolean jvmVersionCheck() {
        String specVersion = System.getProperty("java.specification.version");
        float floatSpecVersion = Float.parseFloat(specVersion);

        // for java 1.6.x or older
        if (floatSpecVersion < 1.7) {
            return false;
        }
        // for java 1.8.x or later
        if (floatSpecVersion >= 1.8) {
            return true;
        }
        // for java 1.7.x
        // threshold is 1.7.0_40
        // see http://bugs.sun.com/view_bug.do?bug_id=7191547
        String version = System.getProperty("java.version");
        String[] split = version.split("_");
        if (split.length >= 2) {
            int update = Integer.parseInt(split[1]);
            if (update >= 40) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}

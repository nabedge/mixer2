package org.mixer2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.exception.Mixer2JAXBException;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Iframe;
import org.mixer2.jaxb.xhtml.Script;
import org.mixer2.jaxb.xhtml.Textarea;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.NamedEntityEnum;
import org.mixer2.xhtml.TagCustomizeWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * mixer2 engine. The instance of this class should be a singleton because of
 * high cost to initialize.
 * </p>
 * 
 * @author nabedge
 * 
 */
public class Mixer2Engine {

    private JAXBContext jaxbContext = null;

    private static Log log = LogFactory.getLog(Mixer2Engine.class);

    public Mixer2Engine() {
        init();
    }

    /**
     * <p>
     * initialize method. This is called automatically by constructor method.
     * </p>
     */
    public synchronized void init() {
        log.info("initializing mixer2 engine...");
        try {
            jaxbContext = JAXBContext.newInstance("org.mixer2.jaxb.xhtml");
        } catch (JAXBException e) {
            log.fatal("can't make newInstance of JAXBContext.", e);
        }
    }

    /**
     * <p>
     * load (unmarshal) a xhtml template to Html type object. Doctype
     * declaration on template will be deleted.
     * </p>
     * <p>
     * If error to parse xhtml string, returns null.
     * </p>
     * 
     * @param file
     * @return html tag object. If parse error, returns null.
     * @throws IOException
     */
    public Html loadHtmlTemplate(File file) throws IOException {
        return loadHtmlTemplate(fileToStringBuilder(file));
    }

    /**
     * <p>
     * This is the same as
     * {@link #loadHtmlTemplate(File)} but if fail to
     * parse xhtml, throws Mixer2JAXBException.
     * </p>
     * 
     * @see #loadHtmlTemplate(File)
     * @param file
     * @return
     * @throws IOException
     * @throws Mixer2JAXBException
     *             if xhtml parse error.
     */
    public Html checkAndLoadHtmlTemplate(File file) throws IOException,
            Mixer2JAXBException {
        return checkAndLoadHtmlTemplate(fileToStringBuilder(file));
    }

    /**
     * 
     * @see #loadHtmlTemplate(File)
     * @param str
     * @return html tag object. If parse error, returns null.
     */
    public Html loadHtmlTemplate(String str) {
        StringBuilder sb = new StringBuilder(str);
        return loadHtmlTemplate(sb);
    }

    /**
     * @see #checkAndLoadHtmlTemplate(File)
     * @param str
     * @return
     * @throws Mixer2JAXBException
     */
    public Html checkAndLoadHtmlTemplate(String str) throws Mixer2JAXBException {
        StringBuilder sb = new StringBuilder(str);
        return checkAndLoadHtmlTemplate(sb);
    }

    /**
     * 
     * @see #loadHtmlTemplate(File)
     * @param sb
     * @return html tag object. If parse error, returns null.
     */
    public Html loadHtmlTemplate(StringBuffer sb) {
        return loadHtmlTemplate(new StringBuilder(sb));
    }

    public Html checkAndLoadHtmlTemplate(StringBuffer sb)
            throws Mixer2JAXBException {
        return checkAndLoadHtmlTemplate(new StringBuilder(sb));
    }

    /**
     * 
     * @see #loadHtmlTemplate(File)
     * @param sb
     *            xhtml template string.
     * @return html tag object. If parse error, returns null.
     */
    public Html loadHtmlTemplate(StringBuilder sb) {
        Html html = null;
        try {
            html = unmarshal(sb);
        } catch (JAXBException e) {
            log.warn("unmarshal failed.", e);
        }
        return html;
    }

    /**
     * @see #checkAndLoadHtmlTemplate(File)
     * @param sb
     *            xhtml template string.
     * @return
     * @throws Mixer2JAXBException
     */
    public Html checkAndLoadHtmlTemplate(StringBuilder sb)
            throws Mixer2JAXBException {
        Html html = null;
        try {
            html = unmarshal(sb);
        } catch (JAXBException e) {
            throw new Mixer2JAXBException(e);
        }
        return html;
    }

    /**
     * <p>
     * load html template from input stream. inputStream will be closed at the
     * end of this method. Doctype declaration on template will be deleted. If
     * failed to parse error, returns null.
     * </p>
     * 
     * @param inputStream
     * @return html tag object. If parse error, returns null.
     * @throws IOException
     *             if inputStream is null.
     */
    public Html loadHtmlTemplate(InputStream inputStream) throws IOException {
        StringBuilder sb = inputStreamToStringBuilder(inputStream);
        return loadHtmlTemplate(sb);
    }

    /**
     * This is the same as
     * {@link #loadHtmlTemplate(InputStream)} but if fail to
     * parse xhtml, throws Mixer2JAXBException.
     * 
     * @see #loadHtmlTemplate(InputStream)
     * @param inputStream
     * @return html tag object.
     * @throws IOException
     * @throws Mixer2JAXBException
     */
    public Html checkAndLoadHtmlTemplate(InputStream inputStream)
            throws IOException, Mixer2JAXBException {
        StringBuilder sb = inputStreamToStringBuilder(inputStream);
        return checkAndLoadHtmlTemplate(sb);
    }

    /**
     * <p>
     * marshal tag object to string and return it.
     * </p>
     */
    public <T extends AbstractJaxb> String saveToString(T tag) {
        StringWriter sw = new StringWriter();
        saveToStringWriter(tag, sw);
        return sw.toString();
    }

    /**
     * <p>
     * marshal tag object and write to StringWriter.
     * </p>
     */
    public <T extends AbstractJaxb> void saveToStringWriter(T tag,
            StringWriter writer) {

        // add one white space into script tag
        // having empty content.
        for (Script script : tag.getDescendants(Script.class)) {
            if (script.getContent() == null || script.getContent().length() < 1) {
                script.setContent(" ");
            }
        }

        // add one white space into iframe tag having empty content.
        for (Iframe iframe : tag.getDescendants(Iframe.class)) {
            if (iframe.getContent() == null || iframe.getContent().size() < 1) {
                iframe.getContent().add(" ");
            }
        }
        
        // add one line break into textarea tag
        // having empty content.
        for (Textarea textarea : tag.getDescendants(Textarea.class)) {
            if (textarea.getContent() == null || textarea.getContent().length() < 1) {
                textarea.setContent(System.getProperty("line.separator"));
            }
        }

        tag.removeEmptyCssClass();
        StringWriter tmpWriter = new StringWriter();
        Marshaller m;
        try {
            m = jaxbContext.createMarshaller();
            m.setProperty(Marshaller.JAXB_ENCODING, Charset.defaultCharset()
                    .name());
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);
            XMLEventWriter xmlEventWriter = XMLOutputFactory.newInstance()
                    .createXMLEventWriter(tmpWriter);
            m.marshal(tag, new TagCustomizeWriter(xmlEventWriter));
        } catch (JAXBException e) {
            log.warn("marshal failed.", e);
        } catch (XMLStreamException e) {
            log.warn("XMLStreamException happend. while saveToWriter().", e);
        } catch (FactoryConfigurationError e) {
            log.warn(
                    "FactoryConfigurationError happend. while saveToWriter().",
                    e);
        }

        // transform xhtml strings
        String xmlStr;
        if (tag.getClass().getSimpleName().toLowerCase().equals("html")) {
            xmlStr = tmpWriter.toString().trim();
        } else {
            xmlStr = tmpWriter.toString().trim()
                    .replaceFirst("xmlns=\"[^\"]+\"", "");
        }
        Reader xml = new StringReader(xmlStr);
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
                    "yes");
            transformer.transform(new StreamSource(xml), new StreamResult(
                    writer));
        } catch (TransformerConfigurationException e) {
            log.warn(
                    "TransformerConfigurationException happend. while saveToWriter().",
                    e);
        } catch (TransformerException e) {
            log.warn("TransformerException happend. while saveToWriter().", e);
        }
    }

	/**
     * <p>
     * marshal the inner objects of tag to string and return it.
     * </p>
     * <pre>
     *     &lt;-- html --&gt;
     *     &lt;div id="foo"&gt;aaa&lt;span&gt;bbb&lt;/span&gt;ccc&lt;/div&gt;
     * </pre>
     * <pre>
     *     // code
     *     List&lt;Object&gt; list = html.getById("foo", Div.class).getContent();
     *     String contents = mixer2Engine.saveToString(list);
     *     // "contents" has "aaa&lt;span&gt;bbb&lt;/span&gt;ccc"
     * </pre>
     *
     * @param list
     * @return
     */
    public String saveToString(List<Object> list) {
        StringBuilder sb = new StringBuilder();
        for(Object obj : list) {
            if (obj == null) {
                continue;
            } else if (obj instanceof AbstractJaxb) {
                sb.append(this.saveToString((AbstractJaxb) obj));
            } else {
                sb.append(obj.toString());
            }
        }
        return sb.toString();
    }

    /**
     * <p>
     * remove doctype declaration
     * </p>
     */
    public StringBuilder removeDoctypeDeclaration(StringBuilder sb) {
        if (sb == null) {
            return null;
        }
        String patternStr = "(\\s*)<!DOCTYPE [^>]+>(.+)";
        Pattern ptn = Pattern.compile(patternStr, Pattern.DOTALL);
        Matcher m = ptn.matcher(sb);
        if (m.find()) {
            return new StringBuilder(m.group(1).trim() + "\n"
                    + m.group(2).trim());
        } else {
            return sb;
        }
    }

    /**
     * @see #removeDoctypeDeclaration(StringBuilder)
     * @param sb
     * @return
     */
    public StringBuffer removeDoctypeDeclaration(StringBuffer sb) {
        return removeDoctypeDeclaration(sb);
    }

    /**
     * <p>
     * replace the reference of character entity reference to numeric character
     * reference.
     * </p>
     * 
     * @param sb
     *            xhtml template
     * @return replaced xhtml template
     */
    public StringBuilder replaceNamedEntity(StringBuilder sb) {
        for (NamedEntityEnum nEnum : NamedEntityEnum.values()) {
            int i;
            while ((i = sb.indexOf(nEnum.getName())) > -1) {
                sb.replace(i, i + nEnum.getName().length(), nEnum.getNumber());
            }
        }
        return sb;
    }

    protected StringBuilder fileToStringBuilder(File file) throws IOException {
        if (file == null) {
            throw new IOException("File is null.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int c;
            while ((c = bufferedReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
        }
        return stringBuilder;
    }

    protected StringBuilder inputStreamToStringBuilder(InputStream inputStream)
            throws IOException {
        if (inputStream == null) {
            throw new IOException("InputStream is null.");
        }

        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            int c;
            while ((c = bufferedReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            inputStream.close();
        }
        return stringBuilder;
    }

    protected StringBuilder replaceIframeEndTag(StringBuilder sb) {
        if (sb == null) {
            return null;
        }
        String patternStr = "</iframe>";
        String replaceStr = " </iframe>";
        Pattern ptn = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
        String result = ptn.matcher(sb).replaceAll(replaceStr);
        return new StringBuilder(result);
    }

    /**
     * <p>
     * unmarshal from html string to html object.
     * </p>
     * 
     * @param sb
     * @return
     * @throws JAXBException
     */
    protected Html unmarshal(StringBuilder sb) throws JAXBException {
        Html html = null;
        sb = replaceIframeEndTag(sb);
        sb = removeDoctypeDeclaration(sb);
        sb = replaceNamedEntity(sb);
        StringReader stringReader = new StringReader(sb.toString());
        html = (Html) jaxbContext.createUnmarshaller().unmarshal(stringReader);
        return html;
    }
    
}

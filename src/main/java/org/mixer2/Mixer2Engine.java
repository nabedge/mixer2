package org.mixer2;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.exception.Mixer2JAXBException;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.Script;
import org.mixer2.jaxb.xhtml.Textarea;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.NamedEntityEnum;
import org.mixer2.xhtml.TagCustomizeWriter;

/**
 * <p>
 * mixer2 engine. The instance of this class should be a singleton because of
 * high cost to initialize.
 * </p>
 * <p>
 * mixer2のエンジンです。現在はxhtml1.0またはhtml5の XML構文で書かれたテンプレートだけを取り扱います
 * このクラスのインスタンスは、APサーバもしくはDIコンテナ内において、 singletonとして使いまわすことをお勧めします。
 * </p>
 * 
 * @author watanabe
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
     * <p>
     * 初期化です。 インスタンス化する際にコンストラクタから自動的に呼び出されます。
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
     * <p>
     * xhtmlテンプレートをJAXBのHtmlオブジェクト型にロード（unmarshal)します。
     * テンプレート上にDOCTYPE宣言が指定されていてもそれは削除されます。
     * </p>
     * <p>
     * xhtml文字列のパースに失敗した場合はnullを返します。
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
     * <p>
     * {@link #loadHtmlTemplate(File)}と同じですが
     * xhtmlのパースに失敗するとMixer2JAXBExceptionをスローします。
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
     * <p>
     * 任意のタグオブジェクトをmarshalして文字列にして返します。
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
     * <p>
     * 任意のタグのオブジェクトをmarshalして指定されたStringWriterに書き込みます。
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
     * remove doctype declaration
     * </p>
     * <p>
     * DOCTYPE宣言を除去します。
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
     * <p>
     * 文字列内の&amp;copy; や &amp;trade; のようなHTMLの特殊文字の参照を、 数値実体参照に置換します。
     * 主にxhtmlテンプレートをHtmlオブジェクトにunmarshalする直前に使用します。
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
        sb = removeDoctypeDeclaration(sb);
        sb = replaceNamedEntity(sb);
        StringReader stringReader = new StringReader(sb.toString());
        html = (Html) jaxbContext.createUnmarshaller().unmarshal(stringReader);
        return html;
    }
    
}

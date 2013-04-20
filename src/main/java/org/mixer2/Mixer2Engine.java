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

import javax.cache.Cache;
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

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.NamedEntityEnum;
import org.mixer2.xhtml.TagCustomizeWriter;

/**
 * <p>
 * mixer2 engine.
 * The instance of this class should be a singleton
 * because of high cost to initialize.
 * </p>
 * <p>
 * mixer2のエンジンです。現在はxhtml1.0またはhtml5の
 * XML構文で書かれたテンプレートだけを取り扱います
 * このクラスのインスタンスは、APサーバもしくはDIコンテナ内において、
 * singletonとして使いまわすことをお勧めします。
 * </p>
 *
 * @author watanabe
 *
 */
public class Mixer2Engine {

    private JAXBContext jaxbContext = null;

    private Cache<String, Html> cache = null;

    private static Log log = LogFactory.getLog(Mixer2Engine.class);

    public Mixer2Engine() {
        init();
    }

    /**
     * <p>
     * set cache object for loaded(unmashalled) template.
     * The key of cache is String, sha1 hash value of template string.
     * You need not to create cache key.
     * </p>
     * <p>
     * unmarshal済みのテンプレートをキャッシュするためのオブジェクトをセットします。
     * キャッシュのキーはStringで、テンプレート文字列自体のsha1ハッシュ値が自動的に使われます。
     * </p>
     * @param cache
     */
    public void setCache(Cache<String, Html> cache) {
        this.cache = cache;
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
            log.fatal("can't make newInstance of JAXBContext.");
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * load (unmarshal) a template to Html type object.
     * Doctype declaration on template will be deleted.
     * </p>
     * <p>
     * テンプレートをJAXBのHtmlオブジェクト型にロード（unmarshal)します。
     * テンプレート上にDOCTYPE宣言が指定されていてもそれは削除されます。
     * </p>
     * @param file
     * @return
     * @throws IOException
     */
    public Html loadHtmlTemplate(File file) throws IOException {
        return loadHtmlTemplate(fileToStringBuffer(file));
    }

    public Html loadHtmlTemplate(String str) {
        StringBuffer sb = new StringBuffer(str);
        return loadHtmlTemplate(sb);
    }

    public Html loadHtmlTemplate(StringBuffer sb) {
        Html html = null;
        sb = removeDoctypeDeclaration(sb);
        sb = replaceNamedEntity(sb);
        StringReader stringReader = new StringReader(sb.toString());
        try {
            html = (Html) jaxbContext.createUnmarshaller().unmarshal(
                    stringReader);
        } catch (JAXBException e) {
            log.warn("unmarshal failed.");
            e.printStackTrace();
        }
        return html;
    }

    /**
     * <p>
     * load html template from input stream.
     * inputStream will be closed at the end of this method.
     * </p>
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public Html loadHtmlTemplate(InputStream inputStream) throws IOException  {
        if (inputStream == null) {
            throw new IOException("InputStream is null.");
        }
        
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            int c;
            while ((c = bufferedReader.read()) != -1) {
                stringBuffer.append((char) c);
            }
        } finally {
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        }
        return loadHtmlTemplate(stringBuffer);
    }

    /**
     * <p>
     * load (unmarshal) a template to Html type object.
     * If there is cache of the template, return it.
     * Otherwise, unmarshal, save Html object to cache, and reaturn it.
     * Doctype declaration on template will be deleted.
     * </p>
     * <p>
     * テンプレートをJAXBのHtmlオブジェクト型にロード（unmarshal)します。
     * ただし、既にcacheがある場合にはそれを返します。
     * cacheがない場合にはFileをunmarshalした結果をcacheに保存しつつそれを返します。
     * テンプレート上にDOCTYPE宣言が指定されていてもそれは削除されます。
     * </p>
     */
    public Html loadHtmlTemplateThroughCache(File file) throws IOException {
        StringBuffer sb = fileToStringBuffer(file);
        return loadHtmlTemplateThroughCache(sb);
    }

    public Html loadHtmlTemplateThroughCache(StringBuffer sb) {
        Html html = null;
        String cacheKey = DigestUtils.shaHex(sb.toString());
        if (cache == null) {
            if (log.isDebugEnabled()) {
                log.debug("cache object is null. processing without cache...");
            }
        } else {
            html = cache.get(cacheKey);
            if (log.isDebugEnabled() && html != null) {
                log.debug("cache hit ! " + cacheKey);
            }
        }
        if (html == null) {
            html = loadHtmlTemplate(sb);
            if (cache != null) {
                cache.putIfAbsent(cacheKey, html);
            }
        }
        return html;
    }

    public Html loadHtmlTemplateThroughCache(String str) {
        StringBuffer sb = new StringBuffer(str);
        return loadHtmlTemplateThroughCache(sb);
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
        tag.removeEmptyCssClass();
        StringWriter tmpWriter = new StringWriter();
        Marshaller m;
        try {
            m = jaxbContext.createMarshaller();
            m.setProperty(Marshaller.JAXB_ENCODING, Charset.defaultCharset()
                    .name());
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);
            // m.marshal(html, writer);
            XMLEventWriter xmlEventWriter = XMLOutputFactory.newInstance()
                    .createXMLEventWriter(tmpWriter);
            m.marshal(tag, new TagCustomizeWriter(xmlEventWriter));
        } catch (JAXBException e) {
            log.warn("marshal failed.");
            e.printStackTrace();
        } catch (XMLStreamException e) {
            log.warn("XMLStreamException happend. while saveToWriter().");
            e.printStackTrace();
        } catch (FactoryConfigurationError e) {
            log.warn("FactoryConfigurationError happend. while saveToWriter().");
            e.printStackTrace();
        }

        // 整形する
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
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
                    "yes");
            transformer.transform(new StreamSource(xml), new StreamResult(
                    writer));
        } catch (TransformerConfigurationException e) {
            log.warn("TransformerConfigurationException happend. while saveToWriter().");
            e.printStackTrace();
        } catch (TransformerException e) {
            log.warn("TransformerException happend. while saveToWriter().");
            e.printStackTrace();
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
    public StringBuffer removeDoctypeDeclaration(StringBuffer sb) {
        if (sb == null) {
            return null;
        }
        String patternStr = "(\\s*)<!DOCTYPE [^>]+>(.+)";
        Pattern ptn = Pattern.compile(patternStr, Pattern.DOTALL);
        Matcher m = ptn.matcher(sb);
        if (m.find()) {
            return new StringBuffer(m.group(1).trim() + "\n"
                    + m.group(2).trim());
        } else {
            return sb;
        }
    }

    /**
     * <p>
     * replace the reference of character entity reference to numeric character reference.
     * </p>
     * <p>
     * 文字列内の&amp;copy; や &amp;trade; のようなHTMLの特殊文字の参照を、
     * 数値実体参照に置換します。
     * 主にxhtmlテンプレートをHtmlオブジェクトにunmarshalする直前に使用します。
     * </p>
     *
     * @param sb xhtml template
     * @return replaced xhtml template
     */
    public StringBuffer replaceNamedEntity(StringBuffer sb) {
        for (NamedEntityEnum nEnum : NamedEntityEnum.values()) {
            int i;
            while ((i = sb.indexOf(nEnum.getName())) > -1) {
                sb.replace(i, i + nEnum.getName().length(), nEnum.getNumber());
            }
        }
        return sb;
    }

    /**
     * <p>
     * remove all cache.
     * if cache is null, do nothing.
     * </p>
     */
    public void removeAllCache() {
        if (this.cache != null) {
            cache.removeAll();
        }
    }

    private StringBuffer fileToStringBuffer(File file) throws IOException {
        if (file == null) {
            throw new IOException("File is null.");
        }
        StringBuffer stringBuffer = new StringBuffer();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int c;
            while ((c = bufferedReader.read()) != -1) {
                stringBuffer.append((char) c);
            }
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        return stringBuffer;
    }

}

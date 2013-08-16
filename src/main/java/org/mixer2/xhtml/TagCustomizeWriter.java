package org.mixer2.xhtml;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * <p>
 * mixer2Engine内のJAXB MarshallerにセットされるXMLEventWriterです。
 * </p>
 * <p>
 * なお、個別のタグに関係する実装は、scriptタグに関する実装のみです。 例えばテンプレートに次のようにインラインでJavaScriptが書かれているとすると、
 * </p>
 * 
 * <pre>
 * &lt;script type=&quot;text/javascript&quot;&gt;
 * //&lt;![CDATA[
 * if (1 &gt; 0) { alert('foo');}
 * //]]&gt;
 * &lt;/script&gt;
 * </pre>
 * <p>
 * 通常のMarshalでは、下記のように不等号記号が文字参照に置換されてしまい、 JavaScriptとして正常に作動しなくなってしまいます。 このEventWriterはそれを防いでいます。
 * </p>
 * 
 * <pre>
 * if (a &amp;gt; 0) { alert('foo');} // this javascript can't work!
 * </pre>
 * <p>
 * 同様に、外部ファイルのJavascriptを読み込む場合についても細工されます。 下記のようなテンプレートがあったとして、
 * </p>
 * 
 * <pre>
 * &lt;script type=&quot;text/javascript&quot; src=&quot;foo.js&quot;&gt;&lt;/script&gt;
 * </pre>
 * <p>
 * 通常のXMLEventWriterでは、下記のように空要素として出力してしまいます。 これはFireFox等ではJavaScriptが作動しません。
 * </p>
 * 
 * <pre>
 * &lt;script type=&quot;text/javascript&quot; src=&quot;foo.js&quot; /&gt;
 * </pre>
 * <p>
 * そのため、このクラスでは、script要素の内容として、空白を1個入れることで 回避しています。
 * </p>
 * 
 * <pre>
 * &lt;script type=&quot;text/javascript&quot; src=&quot;foo.js&quot;&gt;(one white space)&lt;/script&gt;
 * </pre>
 * @author watanabe
 */
public class TagCustomizeWriter implements XMLEventWriter {

    private String targetTagName = "script";

    private XMLEventWriter writer;

    private XMLEventFactory xmlEventFactory;

    private XMLEvent lineBreakEvent;
    
    private String LINE_SEPARATOR = System.getProperty("line.separator");
    
    private boolean scriptElementFlag = false;
    
    private boolean scriptAttributeFlag = false;

    public TagCustomizeWriter(XMLEventWriter writer) {
        this.writer = writer;
        xmlEventFactory = XMLEventFactory.newInstance();
        lineBreakEvent = xmlEventFactory.createCharacters(LINE_SEPARATOR);
    }

    @Override
    public void add(XMLEvent event) throws XMLStreamException {
        
        TagEnum tagEnum;

        if (event.isEndElement()) {
            scriptElementFlag = false;
            scriptAttributeFlag = false;
            EndElement ee = event.asEndElement();
            String tagName = ee.getName().getLocalPart().toUpperCase();
            if ("HEAD".equals(tagName) || "HTML".equals(tagName)) {
                writer.add(lineBreakEvent);
            }
        }

        if (event.isStartElement()) {
            StartElement se = event.asStartElement();
            String tagName = se.getName().getLocalPart().toUpperCase();
            if (tagName.equals(targetTagName.toUpperCase())) {
                scriptElementFlag = true;
            }
            tagEnum = TagEnum.valueOf(tagName);
            if (tagEnum.getAddLineBreak()) {
                writer.add(lineBreakEvent);
            }
        }
        
        if (scriptElementFlag && event.isAttribute()) {
            String str = event.toString().toLowerCase();
            if (str.startsWith("type") && str.contains("javascript")) {
                scriptAttributeFlag = true;
            }
        }
        
        if (scriptElementFlag && scriptAttributeFlag && event.isCharacters()) {
            scriptElementFlag = false;
            scriptAttributeFlag = false;
            String script = event.asCharacters().getData().trim();
            if (script.length() < 1) {
                event = xmlEventFactory.createSpace(" ");
                writer.add(event);
                return;
            }
            if (script.startsWith("//")) {
                script = script.replaceFirst("//", "");
            }
            if (script.endsWith("//")) {
                script = script.substring(0, script.length() - 2);
            }
            event = xmlEventFactory.createCData("\n" + script + "\n//");
            XMLEvent event_before = xmlEventFactory.createCharacters("\n//");
            XMLEvent event_after = xmlEventFactory.createCharacters("\n");
            writer.add(event_before);
            writer.add(event);
            writer.add(event_after);
            return;
        }

        writer.add(event);
    }

    @Override
    public void flush() throws XMLStreamException {
    }

    @Override
    public void close() throws XMLStreamException {
    }

    @Override
    public void add(XMLEventReader reader) throws XMLStreamException {
    }

    @Override
    public String getPrefix(String uri) throws XMLStreamException {
        return null;
    }

    @Override
    public void setPrefix(String prefix, String uri) throws XMLStreamException {
    }

    @Override
    public void setDefaultNamespace(String uri) throws XMLStreamException {
    }

    @Override
    public void setNamespaceContext(NamespaceContext context) throws XMLStreamException {
    }

    @Override
    public NamespaceContext getNamespaceContext() {
        return null;
    }

}

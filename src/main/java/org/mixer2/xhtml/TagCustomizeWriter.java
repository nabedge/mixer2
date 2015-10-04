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
 * XMLEventWriter for JAXB marshaller in mixer2Engine.
 * </p>
 * <p>
 * This class has only implements for script tag.
 * For example, the template has in-line javascript below.
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
 * Normal marshaling replace &lt;,&gt; into reference. This javascript can not work.
 * This EventWriter prevent it.
 * </p>
 * 
 * <pre>
 * if (a &amp;gt; 0) { alert('foo');} // this javascript can't work!
 * </pre>
 * <p>
 * Also, this class is for external javascript.
 * </p>
 * 
 * <pre>
 * &lt;script type=&quot;text/javascript&quot; src=&quot;foo.js&quot;&gt;&lt;/script&gt;
 * </pre>
 * <p>
 * With the template above, normal marshaling outputs it as empty element. 
 * This code can not work on firefox as java-script.
 * </p>
 * 
 * <pre>
 * &lt;script type=&quot;text/javascript&quot; src=&quot;foo.js&quot; /&gt;
 * </pre>
 * <p>
 * This class one white space into script tag.
 * </p>
 * 
 * <pre>
 * &lt;script type=&quot;text/javascript&quot; src=&quot;foo.js&quot;&gt;(one white space)&lt;/script&gt;
 * </pre>
 * @author nabedge
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

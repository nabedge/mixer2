
package org.mixer2.jaxb.xhtml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.mixer2.xhtml.AbstractJaxb;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}option" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}block"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}inline"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}misc"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.w3.org/1999/xhtml}attrs"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "datalist")
public class Datalist
    extends AbstractJaxb
    implements Serializable
{

    private final static long serialVersionUID = 10000L;
    @XmlElementRefs({
        @XmlElementRef(name = "audio", namespace = "http://www.w3.org/1999/xhtml", type = Audio.class),
        @XmlElementRef(name = "section", namespace = "http://www.w3.org/1999/xhtml", type = Section.class),
        @XmlElementRef(name = "input", namespace = "http://www.w3.org/1999/xhtml", type = Input.class),
        @XmlElementRef(name = "basefont", namespace = "http://www.w3.org/1999/xhtml", type = Basefont.class),
        @XmlElementRef(name = "dl", namespace = "http://www.w3.org/1999/xhtml", type = Dl.class),
        @XmlElementRef(name = "h2", namespace = "http://www.w3.org/1999/xhtml", type = H2 .class),
        @XmlElementRef(name = "bdo", namespace = "http://www.w3.org/1999/xhtml", type = Bdo.class),
        @XmlElementRef(name = "acronym", namespace = "http://www.w3.org/1999/xhtml", type = Acronym.class),
        @XmlElementRef(name = "textarea", namespace = "http://www.w3.org/1999/xhtml", type = Textarea.class),
        @XmlElementRef(name = "applet", namespace = "http://www.w3.org/1999/xhtml", type = Applet.class),
        @XmlElementRef(name = "header", namespace = "http://www.w3.org/1999/xhtml", type = Header.class),
        @XmlElementRef(name = "hr", namespace = "http://www.w3.org/1999/xhtml", type = Hr.class),
        @XmlElementRef(name = "fieldset", namespace = "http://www.w3.org/1999/xhtml", type = Fieldset.class),
        @XmlElementRef(name = "time", namespace = "http://www.w3.org/1999/xhtml", type = Time.class),
        @XmlElementRef(name = "noscript", namespace = "http://www.w3.org/1999/xhtml", type = Noscript.class),
        @XmlElementRef(name = "wbr", namespace = "http://www.w3.org/1999/xhtml", type = Wbr.class),
        @XmlElementRef(name = "code", namespace = "http://www.w3.org/1999/xhtml", type = Code.class),
        @XmlElementRef(name = "br", namespace = "http://www.w3.org/1999/xhtml", type = Br.class),
        @XmlElementRef(name = "del", namespace = "http://www.w3.org/1999/xhtml", type = Del.class),
        @XmlElementRef(name = "table", namespace = "http://www.w3.org/1999/xhtml", type = Table.class),
        @XmlElementRef(name = "ol", namespace = "http://www.w3.org/1999/xhtml", type = Ol.class),
        @XmlElementRef(name = "h1", namespace = "http://www.w3.org/1999/xhtml", type = H1 .class),
        @XmlElementRef(name = "h5", namespace = "http://www.w3.org/1999/xhtml", type = H5 .class),
        @XmlElementRef(name = "iframe", namespace = "http://www.w3.org/1999/xhtml", type = Iframe.class),
        @XmlElementRef(name = "bdi", namespace = "http://www.w3.org/1999/xhtml", type = Bdi.class),
        @XmlElementRef(name = "label", namespace = "http://www.w3.org/1999/xhtml", type = Label.class),
        @XmlElementRef(name = "menu", namespace = "http://www.w3.org/1999/xhtml", type = Menu.class),
        @XmlElementRef(name = "samp", namespace = "http://www.w3.org/1999/xhtml", type = Samp.class),
        @XmlElementRef(name = "video", namespace = "http://www.w3.org/1999/xhtml", type = Video.class),
        @XmlElementRef(name = "strike", namespace = "http://www.w3.org/1999/xhtml", type = Strike.class),
        @XmlElementRef(name = "dir", namespace = "http://www.w3.org/1999/xhtml", type = Dir.class),
        @XmlElementRef(name = "div", namespace = "http://www.w3.org/1999/xhtml", type = Div.class),
        @XmlElementRef(name = "hgroup", namespace = "http://www.w3.org/1999/xhtml", type = Hgroup.class),
        @XmlElementRef(name = "em", namespace = "http://www.w3.org/1999/xhtml", type = Em.class),
        @XmlElementRef(name = "footer", namespace = "http://www.w3.org/1999/xhtml", type = Footer.class),
        @XmlElementRef(name = "b", namespace = "http://www.w3.org/1999/xhtml", type = B.class),
        @XmlElementRef(name = "output", namespace = "http://www.w3.org/1999/xhtml", type = Output.class),
        @XmlElementRef(name = "s", namespace = "http://www.w3.org/1999/xhtml", type = S.class),
        @XmlElementRef(name = "abbr", namespace = "http://www.w3.org/1999/xhtml", type = Abbr.class),
        @XmlElementRef(name = "tt", namespace = "http://www.w3.org/1999/xhtml", type = Tt.class),
        @XmlElementRef(name = "i", namespace = "http://www.w3.org/1999/xhtml", type = I.class),
        @XmlElementRef(name = "figcaption", namespace = "http://www.w3.org/1999/xhtml", type = Figcaption.class),
        @XmlElementRef(name = "figure", namespace = "http://www.w3.org/1999/xhtml", type = Figure.class),
        @XmlElementRef(name = "sub", namespace = "http://www.w3.org/1999/xhtml", type = Sub.class),
        @XmlElementRef(name = "ul", namespace = "http://www.w3.org/1999/xhtml", type = Ul.class),
        @XmlElementRef(name = "isindex", namespace = "http://www.w3.org/1999/xhtml", type = Isindex.class),
        @XmlElementRef(name = "h6", namespace = "http://www.w3.org/1999/xhtml", type = H6 .class),
        @XmlElementRef(name = "span", namespace = "http://www.w3.org/1999/xhtml", type = Span.class),
        @XmlElementRef(name = "ruby", namespace = "http://www.w3.org/1999/xhtml", type = Ruby.class),
        @XmlElementRef(name = "h3", namespace = "http://www.w3.org/1999/xhtml", type = H3 .class),
        @XmlElementRef(name = "mark", namespace = "http://www.w3.org/1999/xhtml", type = Mark.class),
        @XmlElementRef(name = "canvas", namespace = "http://www.w3.org/1999/xhtml", type = Canvas.class),
        @XmlElementRef(name = "ins", namespace = "http://www.w3.org/1999/xhtml", type = Ins.class),
        @XmlElementRef(name = "u", namespace = "http://www.w3.org/1999/xhtml", type = U.class),
        @XmlElementRef(name = "meter", namespace = "http://www.w3.org/1999/xhtml", type = Meter.class),
        @XmlElementRef(name = "button", namespace = "http://www.w3.org/1999/xhtml", type = Button.class),
        @XmlElementRef(name = "source", namespace = "http://www.w3.org/1999/xhtml", type = Source.class),
        @XmlElementRef(name = "address", namespace = "http://www.w3.org/1999/xhtml", type = Address.class),
        @XmlElementRef(name = "a", namespace = "http://www.w3.org/1999/xhtml", type = A.class),
        @XmlElementRef(name = "nav", namespace = "http://www.w3.org/1999/xhtml", type = Nav.class),
        @XmlElementRef(name = "rt", namespace = "http://www.w3.org/1999/xhtml", type = Rt.class),
        @XmlElementRef(name = "strong", namespace = "http://www.w3.org/1999/xhtml", type = Strong.class),
        @XmlElementRef(name = "font", namespace = "http://www.w3.org/1999/xhtml", type = Font.class),
        @XmlElementRef(name = "h4", namespace = "http://www.w3.org/1999/xhtml", type = H4 .class),
        @XmlElementRef(name = "small", namespace = "http://www.w3.org/1999/xhtml", type = Small.class),
        @XmlElementRef(name = "sup", namespace = "http://www.w3.org/1999/xhtml", type = Sup.class),
        @XmlElementRef(name = "keygen", namespace = "http://www.w3.org/1999/xhtml", type = Keygen.class),
        @XmlElementRef(name = "object", namespace = "http://www.w3.org/1999/xhtml", type = org.mixer2.jaxb.xhtml.Object.class),
        @XmlElementRef(name = "progress", namespace = "http://www.w3.org/1999/xhtml", type = Progress.class),
        @XmlElementRef(name = "pre", namespace = "http://www.w3.org/1999/xhtml", type = Pre.class),
        @XmlElementRef(name = "map", namespace = "http://www.w3.org/1999/xhtml", type = org.mixer2.jaxb.xhtml.Map.class),
        @XmlElementRef(name = "datalist", namespace = "http://www.w3.org/1999/xhtml", type = Datalist.class),
        @XmlElementRef(name = "script", namespace = "http://www.w3.org/1999/xhtml", type = Script.class),
        @XmlElementRef(name = "aside", namespace = "http://www.w3.org/1999/xhtml", type = Aside.class),
        @XmlElementRef(name = "dfn", namespace = "http://www.w3.org/1999/xhtml", type = Dfn.class),
        @XmlElementRef(name = "option", namespace = "http://www.w3.org/1999/xhtml", type = Option.class),
        @XmlElementRef(name = "center", namespace = "http://www.w3.org/1999/xhtml", type = Center.class),
        @XmlElementRef(name = "cite", namespace = "http://www.w3.org/1999/xhtml", type = Cite.class),
        @XmlElementRef(name = "kbd", namespace = "http://www.w3.org/1999/xhtml", type = Kbd.class),
        @XmlElementRef(name = "details", namespace = "http://www.w3.org/1999/xhtml", type = Details.class),
        @XmlElementRef(name = "command", namespace = "http://www.w3.org/1999/xhtml", type = Command.class),
        @XmlElementRef(name = "select", namespace = "http://www.w3.org/1999/xhtml", type = Select.class),
        @XmlElementRef(name = "embed", namespace = "http://www.w3.org/1999/xhtml", type = Embed.class),
        @XmlElementRef(name = "p", namespace = "http://www.w3.org/1999/xhtml", type = P.class),
        @XmlElementRef(name = "blockquote", namespace = "http://www.w3.org/1999/xhtml", type = Blockquote.class),
        @XmlElementRef(name = "q", namespace = "http://www.w3.org/1999/xhtml", type = Q.class),
        @XmlElementRef(name = "big", namespace = "http://www.w3.org/1999/xhtml", type = Big.class),
        @XmlElementRef(name = "noframes", namespace = "http://www.w3.org/1999/xhtml", type = Noframes.class),
        @XmlElementRef(name = "track", namespace = "http://www.w3.org/1999/xhtml", type = Track.class),
        @XmlElementRef(name = "img", namespace = "http://www.w3.org/1999/xhtml", type = Img.class),
        @XmlElementRef(name = "rp", namespace = "http://www.w3.org/1999/xhtml", type = Rp.class),
        @XmlElementRef(name = "var", namespace = "http://www.w3.org/1999/xhtml", type = Var.class),
        @XmlElementRef(name = "article", namespace = "http://www.w3.org/1999/xhtml", type = Article.class)
    })
    @XmlMixed
    protected List<java.lang.Object> content;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "class")
    @XmlSchemaType(name = "NMTOKENS")
    protected List<String> cssClass;
    @XmlAttribute
    protected String style;
    @XmlAttribute
    protected String title;
    @XmlAttribute
    protected String accesskey;
    @XmlAttribute
    protected Boolean contenteditable;
    @XmlAttribute
    protected String contextmenu;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String dir;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String draggable;
    @XmlAttribute
    protected List<String> dropzone;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String hidden;
    @XmlAttribute(name = "lang")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String langCode;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String role;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String spellcheck;
    @XmlAttribute
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Integer tabindex;
    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String lang;
    @XmlAttribute
    protected String onclick;
    @XmlAttribute
    protected String ondblclick;
    @XmlAttribute
    protected String onmousedown;
    @XmlAttribute
    protected String onmouseup;
    @XmlAttribute
    protected String onmouseover;
    @XmlAttribute
    protected String onmousemove;
    @XmlAttribute
    protected String onmouseout;
    @XmlAttribute
    protected String onkeypress;
    @XmlAttribute
    protected String onkeydown;
    @XmlAttribute
    protected String onkeyup;
    @XmlAttribute
    protected String onabort;
    @XmlAttribute
    protected String onblur;
    @XmlAttribute
    protected String oncanplay;
    @XmlAttribute
    protected String oncanplaythrough;
    @XmlAttribute
    protected String onchange;
    @XmlAttribute
    protected String oncontextmenu;
    @XmlAttribute
    protected String oncuechange;
    @XmlAttribute
    protected String ondrag;
    @XmlAttribute
    protected String ondragend;
    @XmlAttribute
    protected String ondragenter;
    @XmlAttribute
    protected String ondragleave;
    @XmlAttribute
    protected String ondragover;
    @XmlAttribute
    protected String ondragstart;
    @XmlAttribute
    protected String ondrop;
    @XmlAttribute
    protected String ondurationchange;
    @XmlAttribute
    protected String onemptied;
    @XmlAttribute
    protected String onended;
    @XmlAttribute
    protected String onerror;
    @XmlAttribute
    protected String onfocus;
    @XmlAttribute
    protected String onformchange;
    @XmlAttribute
    protected String onforminput;
    @XmlAttribute
    protected String oninput;
    @XmlAttribute
    protected String oninvalid;
    @XmlAttribute
    protected String onload;
    @XmlAttribute
    protected String onloadeddata;
    @XmlAttribute
    protected String onloadedmetadata;
    @XmlAttribute
    protected String onloadstart;
    @XmlAttribute
    protected String onmousewheel;
    @XmlAttribute
    protected String onpause;
    @XmlAttribute
    protected String onplay;
    @XmlAttribute
    protected String onplaying;
    @XmlAttribute
    protected String onprogress;
    @XmlAttribute
    protected String onratechange;
    @XmlAttribute
    protected String onreadystatechange;
    @XmlAttribute
    protected String onreset;
    @XmlAttribute
    protected String onscroll;
    @XmlAttribute
    protected String onseeked;
    @XmlAttribute
    protected String onseeking;
    @XmlAttribute
    protected String onselect;
    @XmlAttribute
    protected String onshow;
    @XmlAttribute
    protected String onstalled;
    @XmlAttribute
    protected String onsubmit;
    @XmlAttribute
    protected String onsuspend;
    @XmlAttribute
    protected String ontimeupdate;
    @XmlAttribute
    protected String onvolumechange;
    @XmlAttribute
    protected String onwaiting;
    @XmlAnyAttribute
    private java.util.Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Audio }
     * {@link Input }
     * {@link Section }
     * {@link H2 }
     * {@link Dl }
     * {@link Basefont }
     * {@link Acronym }
     * {@link Bdo }
     * {@link Textarea }
     * {@link Applet }
     * {@link Header }
     * {@link Fieldset }
     * {@link Hr }
     * {@link Time }
     * {@link Noscript }
     * {@link Wbr }
     * {@link Code }
     * {@link Table }
     * {@link Del }
     * {@link Br }
     * {@link H1 }
     * {@link Ol }
     * {@link H5 }
     * {@link Iframe }
     * {@link Menu }
     * {@link Label }
     * {@link Bdi }
     * {@link Samp }
     * {@link Strike }
     * {@link Video }
     * {@link Dir }
     * {@link Div }
     * {@link Hgroup }
     * {@link Em }
     * {@link B }
     * {@link Footer }
     * {@link Abbr }
     * {@link S }
     * {@link Output }
     * {@link Tt }
     * {@link Figcaption }
     * {@link I }
     * {@link Figure }
     * {@link Sub }
     * {@link Ul }
     * {@link Isindex }
     * {@link Span }
     * {@link H6 }
     * {@link Ruby }
     * {@link Mark }
     * {@link H3 }
     * {@link Canvas }
     * {@link Meter }
     * {@link U }
     * {@link Ins }
     * {@link Button }
     * {@link Address }
     * {@link Source }
     * {@link A }
     * {@link String }
     * {@link Nav }
     * {@link Rt }
     * {@link Strong }
     * {@link Small }
     * {@link H4 }
     * {@link Font }
     * {@link Sup }
     * {@link Keygen }
     * {@link org.mixer2.jaxb.xhtml.Object }
     * {@link Progress }
     * {@link org.mixer2.jaxb.xhtml.Map }
     * {@link Pre }
     * {@link Script }
     * {@link Datalist }
     * {@link Aside }
     * {@link Dfn }
     * {@link Option }
     * {@link Cite }
     * {@link Center }
     * {@link Kbd }
     * {@link Details }
     * {@link Select }
     * {@link Command }
     * {@link P }
     * {@link Embed }
     * {@link Blockquote }
     * {@link Big }
     * {@link Q }
     * {@link Noframes }
     * {@link Track }
     * {@link Rp }
     * {@link Img }
     * {@link Var }
     * {@link Article }
     * 
     * 
     */
    public List<java.lang.Object> getContent() {
        if (content == null) {
            content = new ArrayList<java.lang.Object>();
        }
        return this.content;
    }

    public boolean isSetContent() {
        return ((this.content!= null)&&(!this.content.isEmpty()));
    }

    public void unsetContent() {
        this.content = null;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
    }

    /**
     * Gets the value of the cssClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cssClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCssClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCssClass() {
        if (cssClass == null) {
            cssClass = new ArrayList<String>();
        }
        return this.cssClass;
    }

    public boolean isSetCssClass() {
        return ((this.cssClass!= null)&&(!this.cssClass.isEmpty()));
    }

    public void unsetCssClass() {
        this.cssClass = null;
    }

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

    public boolean isSetStyle() {
        return (this.style!= null);
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    public boolean isSetTitle() {
        return (this.title!= null);
    }

    /**
     * Gets the value of the accesskey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccesskey() {
        return accesskey;
    }

    /**
     * Sets the value of the accesskey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccesskey(String value) {
        this.accesskey = value;
    }

    public boolean isSetAccesskey() {
        return (this.accesskey!= null);
    }

    /**
     * Gets the value of the contenteditable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isContenteditable() {
        return contenteditable;
    }

    /**
     * Sets the value of the contenteditable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContenteditable(boolean value) {
        this.contenteditable = value;
    }

    public boolean isSetContenteditable() {
        return (this.contenteditable!= null);
    }

    public void unsetContenteditable() {
        this.contenteditable = null;
    }

    /**
     * Gets the value of the contextmenu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextmenu() {
        return contextmenu;
    }

    /**
     * Sets the value of the contextmenu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextmenu(String value) {
        this.contextmenu = value;
    }

    public boolean isSetContextmenu() {
        return (this.contextmenu!= null);
    }

    /**
     * Gets the value of the dir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDir() {
        if (dir == null) {
            return "auto";
        } else {
            return dir;
        }
    }

    /**
     * Sets the value of the dir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDir(String value) {
        this.dir = value;
    }

    public boolean isSetDir() {
        return (this.dir!= null);
    }

    /**
     * Gets the value of the draggable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDraggable() {
        if (draggable == null) {
            return "auto";
        } else {
            return draggable;
        }
    }

    /**
     * Sets the value of the draggable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDraggable(String value) {
        this.draggable = value;
    }

    public boolean isSetDraggable() {
        return (this.draggable!= null);
    }

    /**
     * Gets the value of the dropzone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dropzone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDropzone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDropzone() {
        if (dropzone == null) {
            dropzone = new ArrayList<String>();
        }
        return this.dropzone;
    }

    public boolean isSetDropzone() {
        return ((this.dropzone!= null)&&(!this.dropzone.isEmpty()));
    }

    public void unsetDropzone() {
        this.dropzone = null;
    }

    /**
     * Gets the value of the hidden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHidden() {
        return hidden;
    }

    /**
     * Sets the value of the hidden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHidden(String value) {
        this.hidden = value;
    }

    public boolean isSetHidden() {
        return (this.hidden!= null);
    }

    /**
     * Gets the value of the langCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangCode() {
        return langCode;
    }

    /**
     * Sets the value of the langCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangCode(String value) {
        this.langCode = value;
    }

    public boolean isSetLangCode() {
        return (this.langCode!= null);
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    public boolean isSetRole() {
        return (this.role!= null);
    }

    /**
     * Gets the value of the spellcheck property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpellcheck() {
        return spellcheck;
    }

    /**
     * Sets the value of the spellcheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpellcheck(String value) {
        this.spellcheck = value;
    }

    public boolean isSetSpellcheck() {
        return (this.spellcheck!= null);
    }

    /**
     * Gets the value of the tabindex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getTabindex() {
        return tabindex;
    }

    /**
     * Sets the value of the tabindex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTabindex(Integer value) {
        this.tabindex = value;
    }

    public boolean isSetTabindex() {
        return (this.tabindex!= null);
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    public boolean isSetLang() {
        return (this.lang!= null);
    }

    /**
     * Gets the value of the onclick property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnclick() {
        return onclick;
    }

    /**
     * Sets the value of the onclick property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnclick(String value) {
        this.onclick = value;
    }

    public boolean isSetOnclick() {
        return (this.onclick!= null);
    }

    /**
     * Gets the value of the ondblclick property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOndblclick() {
        return ondblclick;
    }

    /**
     * Sets the value of the ondblclick property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOndblclick(String value) {
        this.ondblclick = value;
    }

    public boolean isSetOndblclick() {
        return (this.ondblclick!= null);
    }

    /**
     * Gets the value of the onmousedown property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnmousedown() {
        return onmousedown;
    }

    /**
     * Sets the value of the onmousedown property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnmousedown(String value) {
        this.onmousedown = value;
    }

    public boolean isSetOnmousedown() {
        return (this.onmousedown!= null);
    }

    /**
     * Gets the value of the onmouseup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnmouseup() {
        return onmouseup;
    }

    /**
     * Sets the value of the onmouseup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnmouseup(String value) {
        this.onmouseup = value;
    }

    public boolean isSetOnmouseup() {
        return (this.onmouseup!= null);
    }

    /**
     * Gets the value of the onmouseover property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnmouseover() {
        return onmouseover;
    }

    /**
     * Sets the value of the onmouseover property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnmouseover(String value) {
        this.onmouseover = value;
    }

    public boolean isSetOnmouseover() {
        return (this.onmouseover!= null);
    }

    /**
     * Gets the value of the onmousemove property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnmousemove() {
        return onmousemove;
    }

    /**
     * Sets the value of the onmousemove property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnmousemove(String value) {
        this.onmousemove = value;
    }

    public boolean isSetOnmousemove() {
        return (this.onmousemove!= null);
    }

    /**
     * Gets the value of the onmouseout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnmouseout() {
        return onmouseout;
    }

    /**
     * Sets the value of the onmouseout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnmouseout(String value) {
        this.onmouseout = value;
    }

    public boolean isSetOnmouseout() {
        return (this.onmouseout!= null);
    }

    /**
     * Gets the value of the onkeypress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnkeypress() {
        return onkeypress;
    }

    /**
     * Sets the value of the onkeypress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnkeypress(String value) {
        this.onkeypress = value;
    }

    public boolean isSetOnkeypress() {
        return (this.onkeypress!= null);
    }

    /**
     * Gets the value of the onkeydown property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnkeydown() {
        return onkeydown;
    }

    /**
     * Sets the value of the onkeydown property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnkeydown(String value) {
        this.onkeydown = value;
    }

    public boolean isSetOnkeydown() {
        return (this.onkeydown!= null);
    }

    /**
     * Gets the value of the onkeyup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnkeyup() {
        return onkeyup;
    }

    /**
     * Sets the value of the onkeyup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnkeyup(String value) {
        this.onkeyup = value;
    }

    public boolean isSetOnkeyup() {
        return (this.onkeyup!= null);
    }

    /**
     * Gets the value of the onabort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnabort() {
        return onabort;
    }

    /**
     * Sets the value of the onabort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnabort(String value) {
        this.onabort = value;
    }

    public boolean isSetOnabort() {
        return (this.onabort!= null);
    }

    /**
     * Gets the value of the onblur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnblur() {
        return onblur;
    }

    /**
     * Sets the value of the onblur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnblur(String value) {
        this.onblur = value;
    }

    public boolean isSetOnblur() {
        return (this.onblur!= null);
    }

    /**
     * Gets the value of the oncanplay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOncanplay() {
        return oncanplay;
    }

    /**
     * Sets the value of the oncanplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOncanplay(String value) {
        this.oncanplay = value;
    }

    public boolean isSetOncanplay() {
        return (this.oncanplay!= null);
    }

    /**
     * Gets the value of the oncanplaythrough property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOncanplaythrough() {
        return oncanplaythrough;
    }

    /**
     * Sets the value of the oncanplaythrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOncanplaythrough(String value) {
        this.oncanplaythrough = value;
    }

    public boolean isSetOncanplaythrough() {
        return (this.oncanplaythrough!= null);
    }

    /**
     * Gets the value of the onchange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnchange() {
        return onchange;
    }

    /**
     * Sets the value of the onchange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnchange(String value) {
        this.onchange = value;
    }

    public boolean isSetOnchange() {
        return (this.onchange!= null);
    }

    /**
     * Gets the value of the oncontextmenu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOncontextmenu() {
        return oncontextmenu;
    }

    /**
     * Sets the value of the oncontextmenu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOncontextmenu(String value) {
        this.oncontextmenu = value;
    }

    public boolean isSetOncontextmenu() {
        return (this.oncontextmenu!= null);
    }

    /**
     * Gets the value of the oncuechange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOncuechange() {
        return oncuechange;
    }

    /**
     * Sets the value of the oncuechange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOncuechange(String value) {
        this.oncuechange = value;
    }

    public boolean isSetOncuechange() {
        return (this.oncuechange!= null);
    }

    /**
     * Gets the value of the ondrag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOndrag() {
        return ondrag;
    }

    /**
     * Sets the value of the ondrag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOndrag(String value) {
        this.ondrag = value;
    }

    public boolean isSetOndrag() {
        return (this.ondrag!= null);
    }

    /**
     * Gets the value of the ondragend property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOndragend() {
        return ondragend;
    }

    /**
     * Sets the value of the ondragend property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOndragend(String value) {
        this.ondragend = value;
    }

    public boolean isSetOndragend() {
        return (this.ondragend!= null);
    }

    /**
     * Gets the value of the ondragenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOndragenter() {
        return ondragenter;
    }

    /**
     * Sets the value of the ondragenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOndragenter(String value) {
        this.ondragenter = value;
    }

    public boolean isSetOndragenter() {
        return (this.ondragenter!= null);
    }

    /**
     * Gets the value of the ondragleave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOndragleave() {
        return ondragleave;
    }

    /**
     * Sets the value of the ondragleave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOndragleave(String value) {
        this.ondragleave = value;
    }

    public boolean isSetOndragleave() {
        return (this.ondragleave!= null);
    }

    /**
     * Gets the value of the ondragover property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOndragover() {
        return ondragover;
    }

    /**
     * Sets the value of the ondragover property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOndragover(String value) {
        this.ondragover = value;
    }

    public boolean isSetOndragover() {
        return (this.ondragover!= null);
    }

    /**
     * Gets the value of the ondragstart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOndragstart() {
        return ondragstart;
    }

    /**
     * Sets the value of the ondragstart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOndragstart(String value) {
        this.ondragstart = value;
    }

    public boolean isSetOndragstart() {
        return (this.ondragstart!= null);
    }

    /**
     * Gets the value of the ondrop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOndrop() {
        return ondrop;
    }

    /**
     * Sets the value of the ondrop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOndrop(String value) {
        this.ondrop = value;
    }

    public boolean isSetOndrop() {
        return (this.ondrop!= null);
    }

    /**
     * Gets the value of the ondurationchange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOndurationchange() {
        return ondurationchange;
    }

    /**
     * Sets the value of the ondurationchange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOndurationchange(String value) {
        this.ondurationchange = value;
    }

    public boolean isSetOndurationchange() {
        return (this.ondurationchange!= null);
    }

    /**
     * Gets the value of the onemptied property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnemptied() {
        return onemptied;
    }

    /**
     * Sets the value of the onemptied property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnemptied(String value) {
        this.onemptied = value;
    }

    public boolean isSetOnemptied() {
        return (this.onemptied!= null);
    }

    /**
     * Gets the value of the onended property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnended() {
        return onended;
    }

    /**
     * Sets the value of the onended property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnended(String value) {
        this.onended = value;
    }

    public boolean isSetOnended() {
        return (this.onended!= null);
    }

    /**
     * Gets the value of the onerror property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnerror() {
        return onerror;
    }

    /**
     * Sets the value of the onerror property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnerror(String value) {
        this.onerror = value;
    }

    public boolean isSetOnerror() {
        return (this.onerror!= null);
    }

    /**
     * Gets the value of the onfocus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnfocus() {
        return onfocus;
    }

    /**
     * Sets the value of the onfocus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnfocus(String value) {
        this.onfocus = value;
    }

    public boolean isSetOnfocus() {
        return (this.onfocus!= null);
    }

    /**
     * Gets the value of the onformchange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnformchange() {
        return onformchange;
    }

    /**
     * Sets the value of the onformchange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnformchange(String value) {
        this.onformchange = value;
    }

    public boolean isSetOnformchange() {
        return (this.onformchange!= null);
    }

    /**
     * Gets the value of the onforminput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnforminput() {
        return onforminput;
    }

    /**
     * Sets the value of the onforminput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnforminput(String value) {
        this.onforminput = value;
    }

    public boolean isSetOnforminput() {
        return (this.onforminput!= null);
    }

    /**
     * Gets the value of the oninput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOninput() {
        return oninput;
    }

    /**
     * Sets the value of the oninput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOninput(String value) {
        this.oninput = value;
    }

    public boolean isSetOninput() {
        return (this.oninput!= null);
    }

    /**
     * Gets the value of the oninvalid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOninvalid() {
        return oninvalid;
    }

    /**
     * Sets the value of the oninvalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOninvalid(String value) {
        this.oninvalid = value;
    }

    public boolean isSetOninvalid() {
        return (this.oninvalid!= null);
    }

    /**
     * Gets the value of the onload property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnload() {
        return onload;
    }

    /**
     * Sets the value of the onload property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnload(String value) {
        this.onload = value;
    }

    public boolean isSetOnload() {
        return (this.onload!= null);
    }

    /**
     * Gets the value of the onloadeddata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnloadeddata() {
        return onloadeddata;
    }

    /**
     * Sets the value of the onloadeddata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnloadeddata(String value) {
        this.onloadeddata = value;
    }

    public boolean isSetOnloadeddata() {
        return (this.onloadeddata!= null);
    }

    /**
     * Gets the value of the onloadedmetadata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnloadedmetadata() {
        return onloadedmetadata;
    }

    /**
     * Sets the value of the onloadedmetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnloadedmetadata(String value) {
        this.onloadedmetadata = value;
    }

    public boolean isSetOnloadedmetadata() {
        return (this.onloadedmetadata!= null);
    }

    /**
     * Gets the value of the onloadstart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnloadstart() {
        return onloadstart;
    }

    /**
     * Sets the value of the onloadstart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnloadstart(String value) {
        this.onloadstart = value;
    }

    public boolean isSetOnloadstart() {
        return (this.onloadstart!= null);
    }

    /**
     * Gets the value of the onmousewheel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnmousewheel() {
        return onmousewheel;
    }

    /**
     * Sets the value of the onmousewheel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnmousewheel(String value) {
        this.onmousewheel = value;
    }

    public boolean isSetOnmousewheel() {
        return (this.onmousewheel!= null);
    }

    /**
     * Gets the value of the onpause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnpause() {
        return onpause;
    }

    /**
     * Sets the value of the onpause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnpause(String value) {
        this.onpause = value;
    }

    public boolean isSetOnpause() {
        return (this.onpause!= null);
    }

    /**
     * Gets the value of the onplay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnplay() {
        return onplay;
    }

    /**
     * Sets the value of the onplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnplay(String value) {
        this.onplay = value;
    }

    public boolean isSetOnplay() {
        return (this.onplay!= null);
    }

    /**
     * Gets the value of the onplaying property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnplaying() {
        return onplaying;
    }

    /**
     * Sets the value of the onplaying property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnplaying(String value) {
        this.onplaying = value;
    }

    public boolean isSetOnplaying() {
        return (this.onplaying!= null);
    }

    /**
     * Gets the value of the onprogress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnprogress() {
        return onprogress;
    }

    /**
     * Sets the value of the onprogress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnprogress(String value) {
        this.onprogress = value;
    }

    public boolean isSetOnprogress() {
        return (this.onprogress!= null);
    }

    /**
     * Gets the value of the onratechange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnratechange() {
        return onratechange;
    }

    /**
     * Sets the value of the onratechange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnratechange(String value) {
        this.onratechange = value;
    }

    public boolean isSetOnratechange() {
        return (this.onratechange!= null);
    }

    /**
     * Gets the value of the onreadystatechange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnreadystatechange() {
        return onreadystatechange;
    }

    /**
     * Sets the value of the onreadystatechange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnreadystatechange(String value) {
        this.onreadystatechange = value;
    }

    public boolean isSetOnreadystatechange() {
        return (this.onreadystatechange!= null);
    }

    /**
     * Gets the value of the onreset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnreset() {
        return onreset;
    }

    /**
     * Sets the value of the onreset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnreset(String value) {
        this.onreset = value;
    }

    public boolean isSetOnreset() {
        return (this.onreset!= null);
    }

    /**
     * Gets the value of the onscroll property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnscroll() {
        return onscroll;
    }

    /**
     * Sets the value of the onscroll property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnscroll(String value) {
        this.onscroll = value;
    }

    public boolean isSetOnscroll() {
        return (this.onscroll!= null);
    }

    /**
     * Gets the value of the onseeked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnseeked() {
        return onseeked;
    }

    /**
     * Sets the value of the onseeked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnseeked(String value) {
        this.onseeked = value;
    }

    public boolean isSetOnseeked() {
        return (this.onseeked!= null);
    }

    /**
     * Gets the value of the onseeking property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnseeking() {
        return onseeking;
    }

    /**
     * Sets the value of the onseeking property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnseeking(String value) {
        this.onseeking = value;
    }

    public boolean isSetOnseeking() {
        return (this.onseeking!= null);
    }

    /**
     * Gets the value of the onselect property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnselect() {
        return onselect;
    }

    /**
     * Sets the value of the onselect property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnselect(String value) {
        this.onselect = value;
    }

    public boolean isSetOnselect() {
        return (this.onselect!= null);
    }

    /**
     * Gets the value of the onshow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnshow() {
        return onshow;
    }

    /**
     * Sets the value of the onshow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnshow(String value) {
        this.onshow = value;
    }

    public boolean isSetOnshow() {
        return (this.onshow!= null);
    }

    /**
     * Gets the value of the onstalled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnstalled() {
        return onstalled;
    }

    /**
     * Sets the value of the onstalled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnstalled(String value) {
        this.onstalled = value;
    }

    public boolean isSetOnstalled() {
        return (this.onstalled!= null);
    }

    /**
     * Gets the value of the onsubmit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnsubmit() {
        return onsubmit;
    }

    /**
     * Sets the value of the onsubmit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnsubmit(String value) {
        this.onsubmit = value;
    }

    public boolean isSetOnsubmit() {
        return (this.onsubmit!= null);
    }

    /**
     * Gets the value of the onsuspend property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnsuspend() {
        return onsuspend;
    }

    /**
     * Sets the value of the onsuspend property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnsuspend(String value) {
        this.onsuspend = value;
    }

    public boolean isSetOnsuspend() {
        return (this.onsuspend!= null);
    }

    /**
     * Gets the value of the ontimeupdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOntimeupdate() {
        return ontimeupdate;
    }

    /**
     * Sets the value of the ontimeupdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOntimeupdate(String value) {
        this.ontimeupdate = value;
    }

    public boolean isSetOntimeupdate() {
        return (this.ontimeupdate!= null);
    }

    /**
     * Gets the value of the onvolumechange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnvolumechange() {
        return onvolumechange;
    }

    /**
     * Sets the value of the onvolumechange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnvolumechange(String value) {
        this.onvolumechange = value;
    }

    public boolean isSetOnvolumechange() {
        return (this.onvolumechange!= null);
    }

    /**
     * Gets the value of the onwaiting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnwaiting() {
        return onwaiting;
    }

    /**
     * Sets the value of the onwaiting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnwaiting(String value) {
        this.onwaiting = value;
    }

    public boolean isSetOnwaiting() {
        return (this.onwaiting!= null);
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public java.util.Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}

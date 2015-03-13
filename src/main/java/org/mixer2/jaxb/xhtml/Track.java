
package org.mixer2.jaxb.xhtml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;
import org.mixer2.xhtml.AbstractJaxb;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attGroup ref="{http://www.w3.org/1999/xhtml}attrs"/&gt;
 *       &lt;attribute name="src" type="{http://www.w3.org/1999/xhtml}URI" /&gt;
 *       &lt;attribute name="kind" default="subtitles"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *             &lt;enumeration value="subtitles"/&gt;
 *             &lt;enumeration value="captions"/&gt;
 *             &lt;enumeration value="descriptions"/&gt;
 *             &lt;enumeration value="chapters"/&gt;
 *             &lt;enumeration value="metadata"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="srclang" type="{http://www.w3.org/1999/xhtml}LanguageCode" /&gt;
 *       &lt;attribute name="label" type="{http://www.w3.org/1999/xhtml}Text" /&gt;
 *       &lt;attribute name="default"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *             &lt;enumeration value="default"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "track")
public class Track
    extends AbstractJaxb
    implements Cloneable, CopyTo, Equals, HashCode
{

    @XmlAttribute(name = "src")
    protected String src;
    @XmlAttribute(name = "kind")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String kind;
    @XmlAttribute(name = "srclang")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String srclang;
    @XmlAttribute(name = "label")
    protected String label;
    @XmlAttribute(name = "default")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String _default;
    @XmlAttribute(name = "onclick")
    protected String onclick;
    @XmlAttribute(name = "ondblclick")
    protected String ondblclick;
    @XmlAttribute(name = "onmousedown")
    protected String onmousedown;
    @XmlAttribute(name = "onmouseup")
    protected String onmouseup;
    @XmlAttribute(name = "onmouseover")
    protected String onmouseover;
    @XmlAttribute(name = "onmousemove")
    protected String onmousemove;
    @XmlAttribute(name = "onmouseout")
    protected String onmouseout;
    @XmlAttribute(name = "onkeypress")
    protected String onkeypress;
    @XmlAttribute(name = "onkeydown")
    protected String onkeydown;
    @XmlAttribute(name = "onkeyup")
    protected String onkeyup;
    @XmlAttribute(name = "onabort")
    protected String onabort;
    @XmlAttribute(name = "onblur")
    protected String onblur;
    @XmlAttribute(name = "oncanplay")
    protected String oncanplay;
    @XmlAttribute(name = "oncanplaythrough")
    protected String oncanplaythrough;
    @XmlAttribute(name = "onchange")
    protected String onchange;
    @XmlAttribute(name = "oncontextmenu")
    protected String oncontextmenu;
    @XmlAttribute(name = "oncuechange")
    protected String oncuechange;
    @XmlAttribute(name = "ondrag")
    protected String ondrag;
    @XmlAttribute(name = "ondragend")
    protected String ondragend;
    @XmlAttribute(name = "ondragenter")
    protected String ondragenter;
    @XmlAttribute(name = "ondragleave")
    protected String ondragleave;
    @XmlAttribute(name = "ondragover")
    protected String ondragover;
    @XmlAttribute(name = "ondragstart")
    protected String ondragstart;
    @XmlAttribute(name = "ondrop")
    protected String ondrop;
    @XmlAttribute(name = "ondurationchange")
    protected String ondurationchange;
    @XmlAttribute(name = "onemptied")
    protected String onemptied;
    @XmlAttribute(name = "onended")
    protected String onended;
    @XmlAttribute(name = "onerror")
    protected String onerror;
    @XmlAttribute(name = "onfocus")
    protected String onfocus;
    @XmlAttribute(name = "onformchange")
    protected String onformchange;
    @XmlAttribute(name = "onforminput")
    protected String onforminput;
    @XmlAttribute(name = "oninput")
    protected String oninput;
    @XmlAttribute(name = "oninvalid")
    protected String oninvalid;
    @XmlAttribute(name = "onload")
    protected String onload;
    @XmlAttribute(name = "onloadeddata")
    protected String onloadeddata;
    @XmlAttribute(name = "onloadedmetadata")
    protected String onloadedmetadata;
    @XmlAttribute(name = "onloadstart")
    protected String onloadstart;
    @XmlAttribute(name = "onmousewheel")
    protected String onmousewheel;
    @XmlAttribute(name = "onpause")
    protected String onpause;
    @XmlAttribute(name = "onplay")
    protected String onplay;
    @XmlAttribute(name = "onplaying")
    protected String onplaying;
    @XmlAttribute(name = "onprogress")
    protected String onprogress;
    @XmlAttribute(name = "onratechange")
    protected String onratechange;
    @XmlAttribute(name = "onreadystatechange")
    protected String onreadystatechange;
    @XmlAttribute(name = "onreset")
    protected String onreset;
    @XmlAttribute(name = "onscroll")
    protected String onscroll;
    @XmlAttribute(name = "onseeked")
    protected String onseeked;
    @XmlAttribute(name = "onseeking")
    protected String onseeking;
    @XmlAttribute(name = "onselect")
    protected String onselect;
    @XmlAttribute(name = "onshow")
    protected String onshow;
    @XmlAttribute(name = "onstalled")
    protected String onstalled;
    @XmlAttribute(name = "onsubmit")
    protected String onsubmit;
    @XmlAttribute(name = "onsuspend")
    protected String onsuspend;
    @XmlAttribute(name = "ontimeupdate")
    protected String ontimeupdate;
    @XmlAttribute(name = "onvolumechange")
    protected String onvolumechange;
    @XmlAttribute(name = "onwaiting")
    protected String onwaiting;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "class")
    @XmlSchemaType(name = "NMTOKENS")
    protected List<String> cssClass;
    @XmlAttribute(name = "style")
    protected String style;
    @XmlAttribute(name = "title")
    protected String title;
    @XmlAttribute(name = "accesskey")
    protected String accesskey;
    @XmlAttribute(name = "contenteditable")
    protected Boolean contenteditable;
    @XmlAttribute(name = "contextmenu")
    protected String contextmenu;
    @XmlAttribute(name = "dir")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String dir;
    @XmlAttribute(name = "draggable")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String draggable;
    @XmlAttribute(name = "dropzone")
    protected List<String> dropzone;
    @XmlAttribute(name = "hidden")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String hidden;
    @XmlAttribute(name = "lang")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String langCode;
    @XmlAttribute(name = "role")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String role;
    @XmlAttribute(name = "spellcheck")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String spellcheck;
    @XmlAttribute(name = "tabindex")
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Integer tabindex;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String lang;
    @XmlAttribute(name = "itemscope")
    protected String itemscope;
    @XmlAttribute(name = "itemtype")
    protected String itemtype;
    @XmlAttribute(name = "itemprop")
    @XmlSchemaType(name = "NMTOKENS")
    protected List<String> itemprop;
    @XmlAttribute(name = "itemref")
    @XmlSchemaType(name = "NMTOKENS")
    protected List<String> itemref;
    @XmlAttribute(name = "itemid")
    protected String itemid;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the src property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrc() {
        return src;
    }

    /**
     * Sets the value of the src property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrc(String value) {
        this.src = value;
    }

    public boolean isSetSrc() {
        return (this.src!= null);
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKind() {
        if (kind == null) {
            return "subtitles";
        } else {
            return kind;
        }
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKind(String value) {
        this.kind = value;
    }

    public boolean isSetKind() {
        return (this.kind!= null);
    }

    /**
     * Gets the value of the srclang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrclang() {
        return srclang;
    }

    /**
     * Sets the value of the srclang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrclang(String value) {
        this.srclang = value;
    }

    public boolean isSetSrclang() {
        return (this.srclang!= null);
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    public boolean isSetLabel() {
        return (this.label!= null);
    }

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefault(String value) {
        this._default = value;
    }

    public boolean isSetDefault() {
        return (this._default!= null);
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
     * Gets the value of the itemscope property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemscope() {
        return itemscope;
    }

    /**
     * Sets the value of the itemscope property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemscope(String value) {
        this.itemscope = value;
    }

    public boolean isSetItemscope() {
        return (this.itemscope!= null);
    }

    /**
     * Gets the value of the itemtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemtype() {
        return itemtype;
    }

    /**
     * Sets the value of the itemtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemtype(String value) {
        this.itemtype = value;
    }

    public boolean isSetItemtype() {
        return (this.itemtype!= null);
    }

    /**
     * Gets the value of the itemprop property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemprop property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemprop().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getItemprop() {
        if (itemprop == null) {
            itemprop = new ArrayList<String>();
        }
        return this.itemprop;
    }

    public boolean isSetItemprop() {
        return ((this.itemprop!= null)&&(!this.itemprop.isEmpty()));
    }

    public void unsetItemprop() {
        this.itemprop = null;
    }

    /**
     * Gets the value of the itemref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getItemref() {
        if (itemref == null) {
            itemref = new ArrayList<String>();
        }
        return this.itemref;
    }

    public boolean isSetItemref() {
        return ((this.itemref!= null)&&(!this.itemref.isEmpty()));
    }

    public void unsetItemref() {
        this.itemref = null;
    }

    /**
     * Gets the value of the itemid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemid() {
        return itemid;
    }

    /**
     * Sets the value of the itemid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemid(String value) {
        this.itemid = value;
    }

    public boolean isSetItemid() {
        return (this.itemid!= null);
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
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public java.lang.Object clone() {
        return copyTo(createNewInstance());
    }

    public java.lang.Object copyTo(java.lang.Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public java.lang.Object copyTo(ObjectLocator locator, java.lang.Object target, CopyStrategy strategy) {
        final java.lang.Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof Track) {
            final Track copy = ((Track) draftCopy);
            if (this.isSetSrc()) {
                String sourceSrc;
                sourceSrc = this.getSrc();
                String copySrc = ((String) strategy.copy(LocatorUtils.property(locator, "src", sourceSrc), sourceSrc));
                copy.setSrc(copySrc);
            } else {
                copy.src = null;
            }
            if (this.isSetKind()) {
                String sourceKind;
                sourceKind = this.getKind();
                String copyKind = ((String) strategy.copy(LocatorUtils.property(locator, "kind", sourceKind), sourceKind));
                copy.setKind(copyKind);
            } else {
                copy.kind = null;
            }
            if (this.isSetSrclang()) {
                String sourceSrclang;
                sourceSrclang = this.getSrclang();
                String copySrclang = ((String) strategy.copy(LocatorUtils.property(locator, "srclang", sourceSrclang), sourceSrclang));
                copy.setSrclang(copySrclang);
            } else {
                copy.srclang = null;
            }
            if (this.isSetLabel()) {
                String sourceLabel;
                sourceLabel = this.getLabel();
                String copyLabel = ((String) strategy.copy(LocatorUtils.property(locator, "label", sourceLabel), sourceLabel));
                copy.setLabel(copyLabel);
            } else {
                copy.label = null;
            }
            if (this.isSetDefault()) {
                String sourceDefault;
                sourceDefault = this.getDefault();
                String copyDefault = ((String) strategy.copy(LocatorUtils.property(locator, "_default", sourceDefault), sourceDefault));
                copy.setDefault(copyDefault);
            } else {
                copy._default = null;
            }
            if (this.isSetOnclick()) {
                String sourceOnclick;
                sourceOnclick = this.getOnclick();
                String copyOnclick = ((String) strategy.copy(LocatorUtils.property(locator, "onclick", sourceOnclick), sourceOnclick));
                copy.setOnclick(copyOnclick);
            } else {
                copy.onclick = null;
            }
            if (this.isSetOndblclick()) {
                String sourceOndblclick;
                sourceOndblclick = this.getOndblclick();
                String copyOndblclick = ((String) strategy.copy(LocatorUtils.property(locator, "ondblclick", sourceOndblclick), sourceOndblclick));
                copy.setOndblclick(copyOndblclick);
            } else {
                copy.ondblclick = null;
            }
            if (this.isSetOnmousedown()) {
                String sourceOnmousedown;
                sourceOnmousedown = this.getOnmousedown();
                String copyOnmousedown = ((String) strategy.copy(LocatorUtils.property(locator, "onmousedown", sourceOnmousedown), sourceOnmousedown));
                copy.setOnmousedown(copyOnmousedown);
            } else {
                copy.onmousedown = null;
            }
            if (this.isSetOnmouseup()) {
                String sourceOnmouseup;
                sourceOnmouseup = this.getOnmouseup();
                String copyOnmouseup = ((String) strategy.copy(LocatorUtils.property(locator, "onmouseup", sourceOnmouseup), sourceOnmouseup));
                copy.setOnmouseup(copyOnmouseup);
            } else {
                copy.onmouseup = null;
            }
            if (this.isSetOnmouseover()) {
                String sourceOnmouseover;
                sourceOnmouseover = this.getOnmouseover();
                String copyOnmouseover = ((String) strategy.copy(LocatorUtils.property(locator, "onmouseover", sourceOnmouseover), sourceOnmouseover));
                copy.setOnmouseover(copyOnmouseover);
            } else {
                copy.onmouseover = null;
            }
            if (this.isSetOnmousemove()) {
                String sourceOnmousemove;
                sourceOnmousemove = this.getOnmousemove();
                String copyOnmousemove = ((String) strategy.copy(LocatorUtils.property(locator, "onmousemove", sourceOnmousemove), sourceOnmousemove));
                copy.setOnmousemove(copyOnmousemove);
            } else {
                copy.onmousemove = null;
            }
            if (this.isSetOnmouseout()) {
                String sourceOnmouseout;
                sourceOnmouseout = this.getOnmouseout();
                String copyOnmouseout = ((String) strategy.copy(LocatorUtils.property(locator, "onmouseout", sourceOnmouseout), sourceOnmouseout));
                copy.setOnmouseout(copyOnmouseout);
            } else {
                copy.onmouseout = null;
            }
            if (this.isSetOnkeypress()) {
                String sourceOnkeypress;
                sourceOnkeypress = this.getOnkeypress();
                String copyOnkeypress = ((String) strategy.copy(LocatorUtils.property(locator, "onkeypress", sourceOnkeypress), sourceOnkeypress));
                copy.setOnkeypress(copyOnkeypress);
            } else {
                copy.onkeypress = null;
            }
            if (this.isSetOnkeydown()) {
                String sourceOnkeydown;
                sourceOnkeydown = this.getOnkeydown();
                String copyOnkeydown = ((String) strategy.copy(LocatorUtils.property(locator, "onkeydown", sourceOnkeydown), sourceOnkeydown));
                copy.setOnkeydown(copyOnkeydown);
            } else {
                copy.onkeydown = null;
            }
            if (this.isSetOnkeyup()) {
                String sourceOnkeyup;
                sourceOnkeyup = this.getOnkeyup();
                String copyOnkeyup = ((String) strategy.copy(LocatorUtils.property(locator, "onkeyup", sourceOnkeyup), sourceOnkeyup));
                copy.setOnkeyup(copyOnkeyup);
            } else {
                copy.onkeyup = null;
            }
            if (this.isSetOnabort()) {
                String sourceOnabort;
                sourceOnabort = this.getOnabort();
                String copyOnabort = ((String) strategy.copy(LocatorUtils.property(locator, "onabort", sourceOnabort), sourceOnabort));
                copy.setOnabort(copyOnabort);
            } else {
                copy.onabort = null;
            }
            if (this.isSetOnblur()) {
                String sourceOnblur;
                sourceOnblur = this.getOnblur();
                String copyOnblur = ((String) strategy.copy(LocatorUtils.property(locator, "onblur", sourceOnblur), sourceOnblur));
                copy.setOnblur(copyOnblur);
            } else {
                copy.onblur = null;
            }
            if (this.isSetOncanplay()) {
                String sourceOncanplay;
                sourceOncanplay = this.getOncanplay();
                String copyOncanplay = ((String) strategy.copy(LocatorUtils.property(locator, "oncanplay", sourceOncanplay), sourceOncanplay));
                copy.setOncanplay(copyOncanplay);
            } else {
                copy.oncanplay = null;
            }
            if (this.isSetOncanplaythrough()) {
                String sourceOncanplaythrough;
                sourceOncanplaythrough = this.getOncanplaythrough();
                String copyOncanplaythrough = ((String) strategy.copy(LocatorUtils.property(locator, "oncanplaythrough", sourceOncanplaythrough), sourceOncanplaythrough));
                copy.setOncanplaythrough(copyOncanplaythrough);
            } else {
                copy.oncanplaythrough = null;
            }
            if (this.isSetOnchange()) {
                String sourceOnchange;
                sourceOnchange = this.getOnchange();
                String copyOnchange = ((String) strategy.copy(LocatorUtils.property(locator, "onchange", sourceOnchange), sourceOnchange));
                copy.setOnchange(copyOnchange);
            } else {
                copy.onchange = null;
            }
            if (this.isSetOncontextmenu()) {
                String sourceOncontextmenu;
                sourceOncontextmenu = this.getOncontextmenu();
                String copyOncontextmenu = ((String) strategy.copy(LocatorUtils.property(locator, "oncontextmenu", sourceOncontextmenu), sourceOncontextmenu));
                copy.setOncontextmenu(copyOncontextmenu);
            } else {
                copy.oncontextmenu = null;
            }
            if (this.isSetOncuechange()) {
                String sourceOncuechange;
                sourceOncuechange = this.getOncuechange();
                String copyOncuechange = ((String) strategy.copy(LocatorUtils.property(locator, "oncuechange", sourceOncuechange), sourceOncuechange));
                copy.setOncuechange(copyOncuechange);
            } else {
                copy.oncuechange = null;
            }
            if (this.isSetOndrag()) {
                String sourceOndrag;
                sourceOndrag = this.getOndrag();
                String copyOndrag = ((String) strategy.copy(LocatorUtils.property(locator, "ondrag", sourceOndrag), sourceOndrag));
                copy.setOndrag(copyOndrag);
            } else {
                copy.ondrag = null;
            }
            if (this.isSetOndragend()) {
                String sourceOndragend;
                sourceOndragend = this.getOndragend();
                String copyOndragend = ((String) strategy.copy(LocatorUtils.property(locator, "ondragend", sourceOndragend), sourceOndragend));
                copy.setOndragend(copyOndragend);
            } else {
                copy.ondragend = null;
            }
            if (this.isSetOndragenter()) {
                String sourceOndragenter;
                sourceOndragenter = this.getOndragenter();
                String copyOndragenter = ((String) strategy.copy(LocatorUtils.property(locator, "ondragenter", sourceOndragenter), sourceOndragenter));
                copy.setOndragenter(copyOndragenter);
            } else {
                copy.ondragenter = null;
            }
            if (this.isSetOndragleave()) {
                String sourceOndragleave;
                sourceOndragleave = this.getOndragleave();
                String copyOndragleave = ((String) strategy.copy(LocatorUtils.property(locator, "ondragleave", sourceOndragleave), sourceOndragleave));
                copy.setOndragleave(copyOndragleave);
            } else {
                copy.ondragleave = null;
            }
            if (this.isSetOndragover()) {
                String sourceOndragover;
                sourceOndragover = this.getOndragover();
                String copyOndragover = ((String) strategy.copy(LocatorUtils.property(locator, "ondragover", sourceOndragover), sourceOndragover));
                copy.setOndragover(copyOndragover);
            } else {
                copy.ondragover = null;
            }
            if (this.isSetOndragstart()) {
                String sourceOndragstart;
                sourceOndragstart = this.getOndragstart();
                String copyOndragstart = ((String) strategy.copy(LocatorUtils.property(locator, "ondragstart", sourceOndragstart), sourceOndragstart));
                copy.setOndragstart(copyOndragstart);
            } else {
                copy.ondragstart = null;
            }
            if (this.isSetOndrop()) {
                String sourceOndrop;
                sourceOndrop = this.getOndrop();
                String copyOndrop = ((String) strategy.copy(LocatorUtils.property(locator, "ondrop", sourceOndrop), sourceOndrop));
                copy.setOndrop(copyOndrop);
            } else {
                copy.ondrop = null;
            }
            if (this.isSetOndurationchange()) {
                String sourceOndurationchange;
                sourceOndurationchange = this.getOndurationchange();
                String copyOndurationchange = ((String) strategy.copy(LocatorUtils.property(locator, "ondurationchange", sourceOndurationchange), sourceOndurationchange));
                copy.setOndurationchange(copyOndurationchange);
            } else {
                copy.ondurationchange = null;
            }
            if (this.isSetOnemptied()) {
                String sourceOnemptied;
                sourceOnemptied = this.getOnemptied();
                String copyOnemptied = ((String) strategy.copy(LocatorUtils.property(locator, "onemptied", sourceOnemptied), sourceOnemptied));
                copy.setOnemptied(copyOnemptied);
            } else {
                copy.onemptied = null;
            }
            if (this.isSetOnended()) {
                String sourceOnended;
                sourceOnended = this.getOnended();
                String copyOnended = ((String) strategy.copy(LocatorUtils.property(locator, "onended", sourceOnended), sourceOnended));
                copy.setOnended(copyOnended);
            } else {
                copy.onended = null;
            }
            if (this.isSetOnerror()) {
                String sourceOnerror;
                sourceOnerror = this.getOnerror();
                String copyOnerror = ((String) strategy.copy(LocatorUtils.property(locator, "onerror", sourceOnerror), sourceOnerror));
                copy.setOnerror(copyOnerror);
            } else {
                copy.onerror = null;
            }
            if (this.isSetOnfocus()) {
                String sourceOnfocus;
                sourceOnfocus = this.getOnfocus();
                String copyOnfocus = ((String) strategy.copy(LocatorUtils.property(locator, "onfocus", sourceOnfocus), sourceOnfocus));
                copy.setOnfocus(copyOnfocus);
            } else {
                copy.onfocus = null;
            }
            if (this.isSetOnformchange()) {
                String sourceOnformchange;
                sourceOnformchange = this.getOnformchange();
                String copyOnformchange = ((String) strategy.copy(LocatorUtils.property(locator, "onformchange", sourceOnformchange), sourceOnformchange));
                copy.setOnformchange(copyOnformchange);
            } else {
                copy.onformchange = null;
            }
            if (this.isSetOnforminput()) {
                String sourceOnforminput;
                sourceOnforminput = this.getOnforminput();
                String copyOnforminput = ((String) strategy.copy(LocatorUtils.property(locator, "onforminput", sourceOnforminput), sourceOnforminput));
                copy.setOnforminput(copyOnforminput);
            } else {
                copy.onforminput = null;
            }
            if (this.isSetOninput()) {
                String sourceOninput;
                sourceOninput = this.getOninput();
                String copyOninput = ((String) strategy.copy(LocatorUtils.property(locator, "oninput", sourceOninput), sourceOninput));
                copy.setOninput(copyOninput);
            } else {
                copy.oninput = null;
            }
            if (this.isSetOninvalid()) {
                String sourceOninvalid;
                sourceOninvalid = this.getOninvalid();
                String copyOninvalid = ((String) strategy.copy(LocatorUtils.property(locator, "oninvalid", sourceOninvalid), sourceOninvalid));
                copy.setOninvalid(copyOninvalid);
            } else {
                copy.oninvalid = null;
            }
            if (this.isSetOnload()) {
                String sourceOnload;
                sourceOnload = this.getOnload();
                String copyOnload = ((String) strategy.copy(LocatorUtils.property(locator, "onload", sourceOnload), sourceOnload));
                copy.setOnload(copyOnload);
            } else {
                copy.onload = null;
            }
            if (this.isSetOnloadeddata()) {
                String sourceOnloadeddata;
                sourceOnloadeddata = this.getOnloadeddata();
                String copyOnloadeddata = ((String) strategy.copy(LocatorUtils.property(locator, "onloadeddata", sourceOnloadeddata), sourceOnloadeddata));
                copy.setOnloadeddata(copyOnloadeddata);
            } else {
                copy.onloadeddata = null;
            }
            if (this.isSetOnloadedmetadata()) {
                String sourceOnloadedmetadata;
                sourceOnloadedmetadata = this.getOnloadedmetadata();
                String copyOnloadedmetadata = ((String) strategy.copy(LocatorUtils.property(locator, "onloadedmetadata", sourceOnloadedmetadata), sourceOnloadedmetadata));
                copy.setOnloadedmetadata(copyOnloadedmetadata);
            } else {
                copy.onloadedmetadata = null;
            }
            if (this.isSetOnloadstart()) {
                String sourceOnloadstart;
                sourceOnloadstart = this.getOnloadstart();
                String copyOnloadstart = ((String) strategy.copy(LocatorUtils.property(locator, "onloadstart", sourceOnloadstart), sourceOnloadstart));
                copy.setOnloadstart(copyOnloadstart);
            } else {
                copy.onloadstart = null;
            }
            if (this.isSetOnmousewheel()) {
                String sourceOnmousewheel;
                sourceOnmousewheel = this.getOnmousewheel();
                String copyOnmousewheel = ((String) strategy.copy(LocatorUtils.property(locator, "onmousewheel", sourceOnmousewheel), sourceOnmousewheel));
                copy.setOnmousewheel(copyOnmousewheel);
            } else {
                copy.onmousewheel = null;
            }
            if (this.isSetOnpause()) {
                String sourceOnpause;
                sourceOnpause = this.getOnpause();
                String copyOnpause = ((String) strategy.copy(LocatorUtils.property(locator, "onpause", sourceOnpause), sourceOnpause));
                copy.setOnpause(copyOnpause);
            } else {
                copy.onpause = null;
            }
            if (this.isSetOnplay()) {
                String sourceOnplay;
                sourceOnplay = this.getOnplay();
                String copyOnplay = ((String) strategy.copy(LocatorUtils.property(locator, "onplay", sourceOnplay), sourceOnplay));
                copy.setOnplay(copyOnplay);
            } else {
                copy.onplay = null;
            }
            if (this.isSetOnplaying()) {
                String sourceOnplaying;
                sourceOnplaying = this.getOnplaying();
                String copyOnplaying = ((String) strategy.copy(LocatorUtils.property(locator, "onplaying", sourceOnplaying), sourceOnplaying));
                copy.setOnplaying(copyOnplaying);
            } else {
                copy.onplaying = null;
            }
            if (this.isSetOnprogress()) {
                String sourceOnprogress;
                sourceOnprogress = this.getOnprogress();
                String copyOnprogress = ((String) strategy.copy(LocatorUtils.property(locator, "onprogress", sourceOnprogress), sourceOnprogress));
                copy.setOnprogress(copyOnprogress);
            } else {
                copy.onprogress = null;
            }
            if (this.isSetOnratechange()) {
                String sourceOnratechange;
                sourceOnratechange = this.getOnratechange();
                String copyOnratechange = ((String) strategy.copy(LocatorUtils.property(locator, "onratechange", sourceOnratechange), sourceOnratechange));
                copy.setOnratechange(copyOnratechange);
            } else {
                copy.onratechange = null;
            }
            if (this.isSetOnreadystatechange()) {
                String sourceOnreadystatechange;
                sourceOnreadystatechange = this.getOnreadystatechange();
                String copyOnreadystatechange = ((String) strategy.copy(LocatorUtils.property(locator, "onreadystatechange", sourceOnreadystatechange), sourceOnreadystatechange));
                copy.setOnreadystatechange(copyOnreadystatechange);
            } else {
                copy.onreadystatechange = null;
            }
            if (this.isSetOnreset()) {
                String sourceOnreset;
                sourceOnreset = this.getOnreset();
                String copyOnreset = ((String) strategy.copy(LocatorUtils.property(locator, "onreset", sourceOnreset), sourceOnreset));
                copy.setOnreset(copyOnreset);
            } else {
                copy.onreset = null;
            }
            if (this.isSetOnscroll()) {
                String sourceOnscroll;
                sourceOnscroll = this.getOnscroll();
                String copyOnscroll = ((String) strategy.copy(LocatorUtils.property(locator, "onscroll", sourceOnscroll), sourceOnscroll));
                copy.setOnscroll(copyOnscroll);
            } else {
                copy.onscroll = null;
            }
            if (this.isSetOnseeked()) {
                String sourceOnseeked;
                sourceOnseeked = this.getOnseeked();
                String copyOnseeked = ((String) strategy.copy(LocatorUtils.property(locator, "onseeked", sourceOnseeked), sourceOnseeked));
                copy.setOnseeked(copyOnseeked);
            } else {
                copy.onseeked = null;
            }
            if (this.isSetOnseeking()) {
                String sourceOnseeking;
                sourceOnseeking = this.getOnseeking();
                String copyOnseeking = ((String) strategy.copy(LocatorUtils.property(locator, "onseeking", sourceOnseeking), sourceOnseeking));
                copy.setOnseeking(copyOnseeking);
            } else {
                copy.onseeking = null;
            }
            if (this.isSetOnselect()) {
                String sourceOnselect;
                sourceOnselect = this.getOnselect();
                String copyOnselect = ((String) strategy.copy(LocatorUtils.property(locator, "onselect", sourceOnselect), sourceOnselect));
                copy.setOnselect(copyOnselect);
            } else {
                copy.onselect = null;
            }
            if (this.isSetOnshow()) {
                String sourceOnshow;
                sourceOnshow = this.getOnshow();
                String copyOnshow = ((String) strategy.copy(LocatorUtils.property(locator, "onshow", sourceOnshow), sourceOnshow));
                copy.setOnshow(copyOnshow);
            } else {
                copy.onshow = null;
            }
            if (this.isSetOnstalled()) {
                String sourceOnstalled;
                sourceOnstalled = this.getOnstalled();
                String copyOnstalled = ((String) strategy.copy(LocatorUtils.property(locator, "onstalled", sourceOnstalled), sourceOnstalled));
                copy.setOnstalled(copyOnstalled);
            } else {
                copy.onstalled = null;
            }
            if (this.isSetOnsubmit()) {
                String sourceOnsubmit;
                sourceOnsubmit = this.getOnsubmit();
                String copyOnsubmit = ((String) strategy.copy(LocatorUtils.property(locator, "onsubmit", sourceOnsubmit), sourceOnsubmit));
                copy.setOnsubmit(copyOnsubmit);
            } else {
                copy.onsubmit = null;
            }
            if (this.isSetOnsuspend()) {
                String sourceOnsuspend;
                sourceOnsuspend = this.getOnsuspend();
                String copyOnsuspend = ((String) strategy.copy(LocatorUtils.property(locator, "onsuspend", sourceOnsuspend), sourceOnsuspend));
                copy.setOnsuspend(copyOnsuspend);
            } else {
                copy.onsuspend = null;
            }
            if (this.isSetOntimeupdate()) {
                String sourceOntimeupdate;
                sourceOntimeupdate = this.getOntimeupdate();
                String copyOntimeupdate = ((String) strategy.copy(LocatorUtils.property(locator, "ontimeupdate", sourceOntimeupdate), sourceOntimeupdate));
                copy.setOntimeupdate(copyOntimeupdate);
            } else {
                copy.ontimeupdate = null;
            }
            if (this.isSetOnvolumechange()) {
                String sourceOnvolumechange;
                sourceOnvolumechange = this.getOnvolumechange();
                String copyOnvolumechange = ((String) strategy.copy(LocatorUtils.property(locator, "onvolumechange", sourceOnvolumechange), sourceOnvolumechange));
                copy.setOnvolumechange(copyOnvolumechange);
            } else {
                copy.onvolumechange = null;
            }
            if (this.isSetOnwaiting()) {
                String sourceOnwaiting;
                sourceOnwaiting = this.getOnwaiting();
                String copyOnwaiting = ((String) strategy.copy(LocatorUtils.property(locator, "onwaiting", sourceOnwaiting), sourceOnwaiting));
                copy.setOnwaiting(copyOnwaiting);
            } else {
                copy.onwaiting = null;
            }
            if (this.isSetId()) {
                String sourceId;
                sourceId = this.getId();
                String copyId = ((String) strategy.copy(LocatorUtils.property(locator, "id", sourceId), sourceId));
                copy.setId(copyId);
            } else {
                copy.id = null;
            }
            if (this.isSetCssClass()) {
                List<String> sourceCssClass;
                sourceCssClass = (this.isSetCssClass()?this.getCssClass():null);
                @SuppressWarnings("unchecked")
                List<String> copyCssClass = ((List<String> ) strategy.copy(LocatorUtils.property(locator, "cssClass", sourceCssClass), sourceCssClass));
                copy.unsetCssClass();
                if (copyCssClass!= null) {
                    List<String> uniqueCssClassl = copy.getCssClass();
                    uniqueCssClassl.addAll(copyCssClass);
                }
            } else {
                copy.unsetCssClass();
            }
            if (this.isSetStyle()) {
                String sourceStyle;
                sourceStyle = this.getStyle();
                String copyStyle = ((String) strategy.copy(LocatorUtils.property(locator, "style", sourceStyle), sourceStyle));
                copy.setStyle(copyStyle);
            } else {
                copy.style = null;
            }
            if (this.isSetTitle()) {
                String sourceTitle;
                sourceTitle = this.getTitle();
                String copyTitle = ((String) strategy.copy(LocatorUtils.property(locator, "title", sourceTitle), sourceTitle));
                copy.setTitle(copyTitle);
            } else {
                copy.title = null;
            }
            if (this.isSetAccesskey()) {
                String sourceAccesskey;
                sourceAccesskey = this.getAccesskey();
                String copyAccesskey = ((String) strategy.copy(LocatorUtils.property(locator, "accesskey", sourceAccesskey), sourceAccesskey));
                copy.setAccesskey(copyAccesskey);
            } else {
                copy.accesskey = null;
            }
            if (this.isSetContenteditable()) {
                boolean sourceContenteditable;
                sourceContenteditable = (this.isSetContenteditable()?this.isContenteditable():false);
                boolean copyContenteditable = strategy.copy(LocatorUtils.property(locator, "contenteditable", sourceContenteditable), sourceContenteditable);
                copy.setContenteditable(copyContenteditable);
            } else {
                copy.unsetContenteditable();
            }
            if (this.isSetContextmenu()) {
                String sourceContextmenu;
                sourceContextmenu = this.getContextmenu();
                String copyContextmenu = ((String) strategy.copy(LocatorUtils.property(locator, "contextmenu", sourceContextmenu), sourceContextmenu));
                copy.setContextmenu(copyContextmenu);
            } else {
                copy.contextmenu = null;
            }
            if (this.isSetDir()) {
                String sourceDir;
                sourceDir = this.getDir();
                String copyDir = ((String) strategy.copy(LocatorUtils.property(locator, "dir", sourceDir), sourceDir));
                copy.setDir(copyDir);
            } else {
                copy.dir = null;
            }
            if (this.isSetDraggable()) {
                String sourceDraggable;
                sourceDraggable = this.getDraggable();
                String copyDraggable = ((String) strategy.copy(LocatorUtils.property(locator, "draggable", sourceDraggable), sourceDraggable));
                copy.setDraggable(copyDraggable);
            } else {
                copy.draggable = null;
            }
            if (this.isSetDropzone()) {
                List<String> sourceDropzone;
                sourceDropzone = (this.isSetDropzone()?this.getDropzone():null);
                @SuppressWarnings("unchecked")
                List<String> copyDropzone = ((List<String> ) strategy.copy(LocatorUtils.property(locator, "dropzone", sourceDropzone), sourceDropzone));
                copy.unsetDropzone();
                if (copyDropzone!= null) {
                    List<String> uniqueDropzonel = copy.getDropzone();
                    uniqueDropzonel.addAll(copyDropzone);
                }
            } else {
                copy.unsetDropzone();
            }
            if (this.isSetHidden()) {
                String sourceHidden;
                sourceHidden = this.getHidden();
                String copyHidden = ((String) strategy.copy(LocatorUtils.property(locator, "hidden", sourceHidden), sourceHidden));
                copy.setHidden(copyHidden);
            } else {
                copy.hidden = null;
            }
            if (this.isSetLangCode()) {
                String sourceLangCode;
                sourceLangCode = this.getLangCode();
                String copyLangCode = ((String) strategy.copy(LocatorUtils.property(locator, "langCode", sourceLangCode), sourceLangCode));
                copy.setLangCode(copyLangCode);
            } else {
                copy.langCode = null;
            }
            if (this.isSetRole()) {
                String sourceRole;
                sourceRole = this.getRole();
                String copyRole = ((String) strategy.copy(LocatorUtils.property(locator, "role", sourceRole), sourceRole));
                copy.setRole(copyRole);
            } else {
                copy.role = null;
            }
            if (this.isSetSpellcheck()) {
                String sourceSpellcheck;
                sourceSpellcheck = this.getSpellcheck();
                String copySpellcheck = ((String) strategy.copy(LocatorUtils.property(locator, "spellcheck", sourceSpellcheck), sourceSpellcheck));
                copy.setSpellcheck(copySpellcheck);
            } else {
                copy.spellcheck = null;
            }
            if (this.isSetTabindex()) {
                Integer sourceTabindex;
                sourceTabindex = this.getTabindex();
                Integer copyTabindex = ((Integer) strategy.copy(LocatorUtils.property(locator, "tabindex", sourceTabindex), sourceTabindex));
                copy.setTabindex(copyTabindex);
            } else {
                copy.tabindex = null;
            }
            if (this.isSetLang()) {
                String sourceLang;
                sourceLang = this.getLang();
                String copyLang = ((String) strategy.copy(LocatorUtils.property(locator, "lang", sourceLang), sourceLang));
                copy.setLang(copyLang);
            } else {
                copy.lang = null;
            }
            if (this.isSetItemscope()) {
                String sourceItemscope;
                sourceItemscope = this.getItemscope();
                String copyItemscope = ((String) strategy.copy(LocatorUtils.property(locator, "itemscope", sourceItemscope), sourceItemscope));
                copy.setItemscope(copyItemscope);
            } else {
                copy.itemscope = null;
            }
            if (this.isSetItemtype()) {
                String sourceItemtype;
                sourceItemtype = this.getItemtype();
                String copyItemtype = ((String) strategy.copy(LocatorUtils.property(locator, "itemtype", sourceItemtype), sourceItemtype));
                copy.setItemtype(copyItemtype);
            } else {
                copy.itemtype = null;
            }
            if (this.isSetItemprop()) {
                List<String> sourceItemprop;
                sourceItemprop = (this.isSetItemprop()?this.getItemprop():null);
                @SuppressWarnings("unchecked")
                List<String> copyItemprop = ((List<String> ) strategy.copy(LocatorUtils.property(locator, "itemprop", sourceItemprop), sourceItemprop));
                copy.unsetItemprop();
                if (copyItemprop!= null) {
                    List<String> uniqueItempropl = copy.getItemprop();
                    uniqueItempropl.addAll(copyItemprop);
                }
            } else {
                copy.unsetItemprop();
            }
            if (this.isSetItemref()) {
                List<String> sourceItemref;
                sourceItemref = (this.isSetItemref()?this.getItemref():null);
                @SuppressWarnings("unchecked")
                List<String> copyItemref = ((List<String> ) strategy.copy(LocatorUtils.property(locator, "itemref", sourceItemref), sourceItemref));
                copy.unsetItemref();
                if (copyItemref!= null) {
                    List<String> uniqueItemrefl = copy.getItemref();
                    uniqueItemrefl.addAll(copyItemref);
                }
            } else {
                copy.unsetItemref();
            }
            if (this.isSetItemid()) {
                String sourceItemid;
                sourceItemid = this.getItemid();
                String copyItemid = ((String) strategy.copy(LocatorUtils.property(locator, "itemid", sourceItemid), sourceItemid));
                copy.setItemid(copyItemid);
            } else {
                copy.itemid = null;
            }
        }
        return draftCopy;
    }

    public java.lang.Object createNewInstance() {
        return new Track();
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, java.lang.Object object, EqualsStrategy strategy) {
        if (!(object instanceof Track)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Track that = ((Track) object);
        {
            String lhsSrc;
            lhsSrc = this.getSrc();
            String rhsSrc;
            rhsSrc = that.getSrc();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "src", lhsSrc), LocatorUtils.property(thatLocator, "src", rhsSrc), lhsSrc, rhsSrc)) {
                return false;
            }
        }
        {
            String lhsKind;
            lhsKind = this.getKind();
            String rhsKind;
            rhsKind = that.getKind();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "kind", lhsKind), LocatorUtils.property(thatLocator, "kind", rhsKind), lhsKind, rhsKind)) {
                return false;
            }
        }
        {
            String lhsSrclang;
            lhsSrclang = this.getSrclang();
            String rhsSrclang;
            rhsSrclang = that.getSrclang();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "srclang", lhsSrclang), LocatorUtils.property(thatLocator, "srclang", rhsSrclang), lhsSrclang, rhsSrclang)) {
                return false;
            }
        }
        {
            String lhsLabel;
            lhsLabel = this.getLabel();
            String rhsLabel;
            rhsLabel = that.getLabel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "label", lhsLabel), LocatorUtils.property(thatLocator, "label", rhsLabel), lhsLabel, rhsLabel)) {
                return false;
            }
        }
        {
            String lhsDefault;
            lhsDefault = this.getDefault();
            String rhsDefault;
            rhsDefault = that.getDefault();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "_default", lhsDefault), LocatorUtils.property(thatLocator, "_default", rhsDefault), lhsDefault, rhsDefault)) {
                return false;
            }
        }
        {
            String lhsOnclick;
            lhsOnclick = this.getOnclick();
            String rhsOnclick;
            rhsOnclick = that.getOnclick();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onclick", lhsOnclick), LocatorUtils.property(thatLocator, "onclick", rhsOnclick), lhsOnclick, rhsOnclick)) {
                return false;
            }
        }
        {
            String lhsOndblclick;
            lhsOndblclick = this.getOndblclick();
            String rhsOndblclick;
            rhsOndblclick = that.getOndblclick();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ondblclick", lhsOndblclick), LocatorUtils.property(thatLocator, "ondblclick", rhsOndblclick), lhsOndblclick, rhsOndblclick)) {
                return false;
            }
        }
        {
            String lhsOnmousedown;
            lhsOnmousedown = this.getOnmousedown();
            String rhsOnmousedown;
            rhsOnmousedown = that.getOnmousedown();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onmousedown", lhsOnmousedown), LocatorUtils.property(thatLocator, "onmousedown", rhsOnmousedown), lhsOnmousedown, rhsOnmousedown)) {
                return false;
            }
        }
        {
            String lhsOnmouseup;
            lhsOnmouseup = this.getOnmouseup();
            String rhsOnmouseup;
            rhsOnmouseup = that.getOnmouseup();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onmouseup", lhsOnmouseup), LocatorUtils.property(thatLocator, "onmouseup", rhsOnmouseup), lhsOnmouseup, rhsOnmouseup)) {
                return false;
            }
        }
        {
            String lhsOnmouseover;
            lhsOnmouseover = this.getOnmouseover();
            String rhsOnmouseover;
            rhsOnmouseover = that.getOnmouseover();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onmouseover", lhsOnmouseover), LocatorUtils.property(thatLocator, "onmouseover", rhsOnmouseover), lhsOnmouseover, rhsOnmouseover)) {
                return false;
            }
        }
        {
            String lhsOnmousemove;
            lhsOnmousemove = this.getOnmousemove();
            String rhsOnmousemove;
            rhsOnmousemove = that.getOnmousemove();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onmousemove", lhsOnmousemove), LocatorUtils.property(thatLocator, "onmousemove", rhsOnmousemove), lhsOnmousemove, rhsOnmousemove)) {
                return false;
            }
        }
        {
            String lhsOnmouseout;
            lhsOnmouseout = this.getOnmouseout();
            String rhsOnmouseout;
            rhsOnmouseout = that.getOnmouseout();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onmouseout", lhsOnmouseout), LocatorUtils.property(thatLocator, "onmouseout", rhsOnmouseout), lhsOnmouseout, rhsOnmouseout)) {
                return false;
            }
        }
        {
            String lhsOnkeypress;
            lhsOnkeypress = this.getOnkeypress();
            String rhsOnkeypress;
            rhsOnkeypress = that.getOnkeypress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onkeypress", lhsOnkeypress), LocatorUtils.property(thatLocator, "onkeypress", rhsOnkeypress), lhsOnkeypress, rhsOnkeypress)) {
                return false;
            }
        }
        {
            String lhsOnkeydown;
            lhsOnkeydown = this.getOnkeydown();
            String rhsOnkeydown;
            rhsOnkeydown = that.getOnkeydown();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onkeydown", lhsOnkeydown), LocatorUtils.property(thatLocator, "onkeydown", rhsOnkeydown), lhsOnkeydown, rhsOnkeydown)) {
                return false;
            }
        }
        {
            String lhsOnkeyup;
            lhsOnkeyup = this.getOnkeyup();
            String rhsOnkeyup;
            rhsOnkeyup = that.getOnkeyup();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onkeyup", lhsOnkeyup), LocatorUtils.property(thatLocator, "onkeyup", rhsOnkeyup), lhsOnkeyup, rhsOnkeyup)) {
                return false;
            }
        }
        {
            String lhsOnabort;
            lhsOnabort = this.getOnabort();
            String rhsOnabort;
            rhsOnabort = that.getOnabort();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onabort", lhsOnabort), LocatorUtils.property(thatLocator, "onabort", rhsOnabort), lhsOnabort, rhsOnabort)) {
                return false;
            }
        }
        {
            String lhsOnblur;
            lhsOnblur = this.getOnblur();
            String rhsOnblur;
            rhsOnblur = that.getOnblur();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onblur", lhsOnblur), LocatorUtils.property(thatLocator, "onblur", rhsOnblur), lhsOnblur, rhsOnblur)) {
                return false;
            }
        }
        {
            String lhsOncanplay;
            lhsOncanplay = this.getOncanplay();
            String rhsOncanplay;
            rhsOncanplay = that.getOncanplay();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "oncanplay", lhsOncanplay), LocatorUtils.property(thatLocator, "oncanplay", rhsOncanplay), lhsOncanplay, rhsOncanplay)) {
                return false;
            }
        }
        {
            String lhsOncanplaythrough;
            lhsOncanplaythrough = this.getOncanplaythrough();
            String rhsOncanplaythrough;
            rhsOncanplaythrough = that.getOncanplaythrough();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "oncanplaythrough", lhsOncanplaythrough), LocatorUtils.property(thatLocator, "oncanplaythrough", rhsOncanplaythrough), lhsOncanplaythrough, rhsOncanplaythrough)) {
                return false;
            }
        }
        {
            String lhsOnchange;
            lhsOnchange = this.getOnchange();
            String rhsOnchange;
            rhsOnchange = that.getOnchange();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onchange", lhsOnchange), LocatorUtils.property(thatLocator, "onchange", rhsOnchange), lhsOnchange, rhsOnchange)) {
                return false;
            }
        }
        {
            String lhsOncontextmenu;
            lhsOncontextmenu = this.getOncontextmenu();
            String rhsOncontextmenu;
            rhsOncontextmenu = that.getOncontextmenu();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "oncontextmenu", lhsOncontextmenu), LocatorUtils.property(thatLocator, "oncontextmenu", rhsOncontextmenu), lhsOncontextmenu, rhsOncontextmenu)) {
                return false;
            }
        }
        {
            String lhsOncuechange;
            lhsOncuechange = this.getOncuechange();
            String rhsOncuechange;
            rhsOncuechange = that.getOncuechange();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "oncuechange", lhsOncuechange), LocatorUtils.property(thatLocator, "oncuechange", rhsOncuechange), lhsOncuechange, rhsOncuechange)) {
                return false;
            }
        }
        {
            String lhsOndrag;
            lhsOndrag = this.getOndrag();
            String rhsOndrag;
            rhsOndrag = that.getOndrag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ondrag", lhsOndrag), LocatorUtils.property(thatLocator, "ondrag", rhsOndrag), lhsOndrag, rhsOndrag)) {
                return false;
            }
        }
        {
            String lhsOndragend;
            lhsOndragend = this.getOndragend();
            String rhsOndragend;
            rhsOndragend = that.getOndragend();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ondragend", lhsOndragend), LocatorUtils.property(thatLocator, "ondragend", rhsOndragend), lhsOndragend, rhsOndragend)) {
                return false;
            }
        }
        {
            String lhsOndragenter;
            lhsOndragenter = this.getOndragenter();
            String rhsOndragenter;
            rhsOndragenter = that.getOndragenter();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ondragenter", lhsOndragenter), LocatorUtils.property(thatLocator, "ondragenter", rhsOndragenter), lhsOndragenter, rhsOndragenter)) {
                return false;
            }
        }
        {
            String lhsOndragleave;
            lhsOndragleave = this.getOndragleave();
            String rhsOndragleave;
            rhsOndragleave = that.getOndragleave();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ondragleave", lhsOndragleave), LocatorUtils.property(thatLocator, "ondragleave", rhsOndragleave), lhsOndragleave, rhsOndragleave)) {
                return false;
            }
        }
        {
            String lhsOndragover;
            lhsOndragover = this.getOndragover();
            String rhsOndragover;
            rhsOndragover = that.getOndragover();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ondragover", lhsOndragover), LocatorUtils.property(thatLocator, "ondragover", rhsOndragover), lhsOndragover, rhsOndragover)) {
                return false;
            }
        }
        {
            String lhsOndragstart;
            lhsOndragstart = this.getOndragstart();
            String rhsOndragstart;
            rhsOndragstart = that.getOndragstart();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ondragstart", lhsOndragstart), LocatorUtils.property(thatLocator, "ondragstart", rhsOndragstart), lhsOndragstart, rhsOndragstart)) {
                return false;
            }
        }
        {
            String lhsOndrop;
            lhsOndrop = this.getOndrop();
            String rhsOndrop;
            rhsOndrop = that.getOndrop();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ondrop", lhsOndrop), LocatorUtils.property(thatLocator, "ondrop", rhsOndrop), lhsOndrop, rhsOndrop)) {
                return false;
            }
        }
        {
            String lhsOndurationchange;
            lhsOndurationchange = this.getOndurationchange();
            String rhsOndurationchange;
            rhsOndurationchange = that.getOndurationchange();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ondurationchange", lhsOndurationchange), LocatorUtils.property(thatLocator, "ondurationchange", rhsOndurationchange), lhsOndurationchange, rhsOndurationchange)) {
                return false;
            }
        }
        {
            String lhsOnemptied;
            lhsOnemptied = this.getOnemptied();
            String rhsOnemptied;
            rhsOnemptied = that.getOnemptied();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onemptied", lhsOnemptied), LocatorUtils.property(thatLocator, "onemptied", rhsOnemptied), lhsOnemptied, rhsOnemptied)) {
                return false;
            }
        }
        {
            String lhsOnended;
            lhsOnended = this.getOnended();
            String rhsOnended;
            rhsOnended = that.getOnended();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onended", lhsOnended), LocatorUtils.property(thatLocator, "onended", rhsOnended), lhsOnended, rhsOnended)) {
                return false;
            }
        }
        {
            String lhsOnerror;
            lhsOnerror = this.getOnerror();
            String rhsOnerror;
            rhsOnerror = that.getOnerror();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onerror", lhsOnerror), LocatorUtils.property(thatLocator, "onerror", rhsOnerror), lhsOnerror, rhsOnerror)) {
                return false;
            }
        }
        {
            String lhsOnfocus;
            lhsOnfocus = this.getOnfocus();
            String rhsOnfocus;
            rhsOnfocus = that.getOnfocus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onfocus", lhsOnfocus), LocatorUtils.property(thatLocator, "onfocus", rhsOnfocus), lhsOnfocus, rhsOnfocus)) {
                return false;
            }
        }
        {
            String lhsOnformchange;
            lhsOnformchange = this.getOnformchange();
            String rhsOnformchange;
            rhsOnformchange = that.getOnformchange();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onformchange", lhsOnformchange), LocatorUtils.property(thatLocator, "onformchange", rhsOnformchange), lhsOnformchange, rhsOnformchange)) {
                return false;
            }
        }
        {
            String lhsOnforminput;
            lhsOnforminput = this.getOnforminput();
            String rhsOnforminput;
            rhsOnforminput = that.getOnforminput();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onforminput", lhsOnforminput), LocatorUtils.property(thatLocator, "onforminput", rhsOnforminput), lhsOnforminput, rhsOnforminput)) {
                return false;
            }
        }
        {
            String lhsOninput;
            lhsOninput = this.getOninput();
            String rhsOninput;
            rhsOninput = that.getOninput();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "oninput", lhsOninput), LocatorUtils.property(thatLocator, "oninput", rhsOninput), lhsOninput, rhsOninput)) {
                return false;
            }
        }
        {
            String lhsOninvalid;
            lhsOninvalid = this.getOninvalid();
            String rhsOninvalid;
            rhsOninvalid = that.getOninvalid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "oninvalid", lhsOninvalid), LocatorUtils.property(thatLocator, "oninvalid", rhsOninvalid), lhsOninvalid, rhsOninvalid)) {
                return false;
            }
        }
        {
            String lhsOnload;
            lhsOnload = this.getOnload();
            String rhsOnload;
            rhsOnload = that.getOnload();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onload", lhsOnload), LocatorUtils.property(thatLocator, "onload", rhsOnload), lhsOnload, rhsOnload)) {
                return false;
            }
        }
        {
            String lhsOnloadeddata;
            lhsOnloadeddata = this.getOnloadeddata();
            String rhsOnloadeddata;
            rhsOnloadeddata = that.getOnloadeddata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onloadeddata", lhsOnloadeddata), LocatorUtils.property(thatLocator, "onloadeddata", rhsOnloadeddata), lhsOnloadeddata, rhsOnloadeddata)) {
                return false;
            }
        }
        {
            String lhsOnloadedmetadata;
            lhsOnloadedmetadata = this.getOnloadedmetadata();
            String rhsOnloadedmetadata;
            rhsOnloadedmetadata = that.getOnloadedmetadata();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onloadedmetadata", lhsOnloadedmetadata), LocatorUtils.property(thatLocator, "onloadedmetadata", rhsOnloadedmetadata), lhsOnloadedmetadata, rhsOnloadedmetadata)) {
                return false;
            }
        }
        {
            String lhsOnloadstart;
            lhsOnloadstart = this.getOnloadstart();
            String rhsOnloadstart;
            rhsOnloadstart = that.getOnloadstart();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onloadstart", lhsOnloadstart), LocatorUtils.property(thatLocator, "onloadstart", rhsOnloadstart), lhsOnloadstart, rhsOnloadstart)) {
                return false;
            }
        }
        {
            String lhsOnmousewheel;
            lhsOnmousewheel = this.getOnmousewheel();
            String rhsOnmousewheel;
            rhsOnmousewheel = that.getOnmousewheel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onmousewheel", lhsOnmousewheel), LocatorUtils.property(thatLocator, "onmousewheel", rhsOnmousewheel), lhsOnmousewheel, rhsOnmousewheel)) {
                return false;
            }
        }
        {
            String lhsOnpause;
            lhsOnpause = this.getOnpause();
            String rhsOnpause;
            rhsOnpause = that.getOnpause();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onpause", lhsOnpause), LocatorUtils.property(thatLocator, "onpause", rhsOnpause), lhsOnpause, rhsOnpause)) {
                return false;
            }
        }
        {
            String lhsOnplay;
            lhsOnplay = this.getOnplay();
            String rhsOnplay;
            rhsOnplay = that.getOnplay();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onplay", lhsOnplay), LocatorUtils.property(thatLocator, "onplay", rhsOnplay), lhsOnplay, rhsOnplay)) {
                return false;
            }
        }
        {
            String lhsOnplaying;
            lhsOnplaying = this.getOnplaying();
            String rhsOnplaying;
            rhsOnplaying = that.getOnplaying();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onplaying", lhsOnplaying), LocatorUtils.property(thatLocator, "onplaying", rhsOnplaying), lhsOnplaying, rhsOnplaying)) {
                return false;
            }
        }
        {
            String lhsOnprogress;
            lhsOnprogress = this.getOnprogress();
            String rhsOnprogress;
            rhsOnprogress = that.getOnprogress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onprogress", lhsOnprogress), LocatorUtils.property(thatLocator, "onprogress", rhsOnprogress), lhsOnprogress, rhsOnprogress)) {
                return false;
            }
        }
        {
            String lhsOnratechange;
            lhsOnratechange = this.getOnratechange();
            String rhsOnratechange;
            rhsOnratechange = that.getOnratechange();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onratechange", lhsOnratechange), LocatorUtils.property(thatLocator, "onratechange", rhsOnratechange), lhsOnratechange, rhsOnratechange)) {
                return false;
            }
        }
        {
            String lhsOnreadystatechange;
            lhsOnreadystatechange = this.getOnreadystatechange();
            String rhsOnreadystatechange;
            rhsOnreadystatechange = that.getOnreadystatechange();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onreadystatechange", lhsOnreadystatechange), LocatorUtils.property(thatLocator, "onreadystatechange", rhsOnreadystatechange), lhsOnreadystatechange, rhsOnreadystatechange)) {
                return false;
            }
        }
        {
            String lhsOnreset;
            lhsOnreset = this.getOnreset();
            String rhsOnreset;
            rhsOnreset = that.getOnreset();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onreset", lhsOnreset), LocatorUtils.property(thatLocator, "onreset", rhsOnreset), lhsOnreset, rhsOnreset)) {
                return false;
            }
        }
        {
            String lhsOnscroll;
            lhsOnscroll = this.getOnscroll();
            String rhsOnscroll;
            rhsOnscroll = that.getOnscroll();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onscroll", lhsOnscroll), LocatorUtils.property(thatLocator, "onscroll", rhsOnscroll), lhsOnscroll, rhsOnscroll)) {
                return false;
            }
        }
        {
            String lhsOnseeked;
            lhsOnseeked = this.getOnseeked();
            String rhsOnseeked;
            rhsOnseeked = that.getOnseeked();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onseeked", lhsOnseeked), LocatorUtils.property(thatLocator, "onseeked", rhsOnseeked), lhsOnseeked, rhsOnseeked)) {
                return false;
            }
        }
        {
            String lhsOnseeking;
            lhsOnseeking = this.getOnseeking();
            String rhsOnseeking;
            rhsOnseeking = that.getOnseeking();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onseeking", lhsOnseeking), LocatorUtils.property(thatLocator, "onseeking", rhsOnseeking), lhsOnseeking, rhsOnseeking)) {
                return false;
            }
        }
        {
            String lhsOnselect;
            lhsOnselect = this.getOnselect();
            String rhsOnselect;
            rhsOnselect = that.getOnselect();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onselect", lhsOnselect), LocatorUtils.property(thatLocator, "onselect", rhsOnselect), lhsOnselect, rhsOnselect)) {
                return false;
            }
        }
        {
            String lhsOnshow;
            lhsOnshow = this.getOnshow();
            String rhsOnshow;
            rhsOnshow = that.getOnshow();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onshow", lhsOnshow), LocatorUtils.property(thatLocator, "onshow", rhsOnshow), lhsOnshow, rhsOnshow)) {
                return false;
            }
        }
        {
            String lhsOnstalled;
            lhsOnstalled = this.getOnstalled();
            String rhsOnstalled;
            rhsOnstalled = that.getOnstalled();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onstalled", lhsOnstalled), LocatorUtils.property(thatLocator, "onstalled", rhsOnstalled), lhsOnstalled, rhsOnstalled)) {
                return false;
            }
        }
        {
            String lhsOnsubmit;
            lhsOnsubmit = this.getOnsubmit();
            String rhsOnsubmit;
            rhsOnsubmit = that.getOnsubmit();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onsubmit", lhsOnsubmit), LocatorUtils.property(thatLocator, "onsubmit", rhsOnsubmit), lhsOnsubmit, rhsOnsubmit)) {
                return false;
            }
        }
        {
            String lhsOnsuspend;
            lhsOnsuspend = this.getOnsuspend();
            String rhsOnsuspend;
            rhsOnsuspend = that.getOnsuspend();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onsuspend", lhsOnsuspend), LocatorUtils.property(thatLocator, "onsuspend", rhsOnsuspend), lhsOnsuspend, rhsOnsuspend)) {
                return false;
            }
        }
        {
            String lhsOntimeupdate;
            lhsOntimeupdate = this.getOntimeupdate();
            String rhsOntimeupdate;
            rhsOntimeupdate = that.getOntimeupdate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ontimeupdate", lhsOntimeupdate), LocatorUtils.property(thatLocator, "ontimeupdate", rhsOntimeupdate), lhsOntimeupdate, rhsOntimeupdate)) {
                return false;
            }
        }
        {
            String lhsOnvolumechange;
            lhsOnvolumechange = this.getOnvolumechange();
            String rhsOnvolumechange;
            rhsOnvolumechange = that.getOnvolumechange();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onvolumechange", lhsOnvolumechange), LocatorUtils.property(thatLocator, "onvolumechange", rhsOnvolumechange), lhsOnvolumechange, rhsOnvolumechange)) {
                return false;
            }
        }
        {
            String lhsOnwaiting;
            lhsOnwaiting = this.getOnwaiting();
            String rhsOnwaiting;
            rhsOnwaiting = that.getOnwaiting();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "onwaiting", lhsOnwaiting), LocatorUtils.property(thatLocator, "onwaiting", rhsOnwaiting), lhsOnwaiting, rhsOnwaiting)) {
                return false;
            }
        }
        {
            String lhsId;
            lhsId = this.getId();
            String rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        {
            List<String> lhsCssClass;
            lhsCssClass = (this.isSetCssClass()?this.getCssClass():null);
            List<String> rhsCssClass;
            rhsCssClass = (that.isSetCssClass()?that.getCssClass():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cssClass", lhsCssClass), LocatorUtils.property(thatLocator, "cssClass", rhsCssClass), lhsCssClass, rhsCssClass)) {
                return false;
            }
        }
        {
            String lhsStyle;
            lhsStyle = this.getStyle();
            String rhsStyle;
            rhsStyle = that.getStyle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "style", lhsStyle), LocatorUtils.property(thatLocator, "style", rhsStyle), lhsStyle, rhsStyle)) {
                return false;
            }
        }
        {
            String lhsTitle;
            lhsTitle = this.getTitle();
            String rhsTitle;
            rhsTitle = that.getTitle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "title", lhsTitle), LocatorUtils.property(thatLocator, "title", rhsTitle), lhsTitle, rhsTitle)) {
                return false;
            }
        }
        {
            String lhsAccesskey;
            lhsAccesskey = this.getAccesskey();
            String rhsAccesskey;
            rhsAccesskey = that.getAccesskey();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accesskey", lhsAccesskey), LocatorUtils.property(thatLocator, "accesskey", rhsAccesskey), lhsAccesskey, rhsAccesskey)) {
                return false;
            }
        }
        {
            boolean lhsContenteditable;
            lhsContenteditable = (this.isSetContenteditable()?this.isContenteditable():false);
            boolean rhsContenteditable;
            rhsContenteditable = (that.isSetContenteditable()?that.isContenteditable():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contenteditable", lhsContenteditable), LocatorUtils.property(thatLocator, "contenteditable", rhsContenteditable), lhsContenteditable, rhsContenteditable)) {
                return false;
            }
        }
        {
            String lhsContextmenu;
            lhsContextmenu = this.getContextmenu();
            String rhsContextmenu;
            rhsContextmenu = that.getContextmenu();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contextmenu", lhsContextmenu), LocatorUtils.property(thatLocator, "contextmenu", rhsContextmenu), lhsContextmenu, rhsContextmenu)) {
                return false;
            }
        }
        {
            String lhsDir;
            lhsDir = this.getDir();
            String rhsDir;
            rhsDir = that.getDir();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dir", lhsDir), LocatorUtils.property(thatLocator, "dir", rhsDir), lhsDir, rhsDir)) {
                return false;
            }
        }
        {
            String lhsDraggable;
            lhsDraggable = this.getDraggable();
            String rhsDraggable;
            rhsDraggable = that.getDraggable();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "draggable", lhsDraggable), LocatorUtils.property(thatLocator, "draggable", rhsDraggable), lhsDraggable, rhsDraggable)) {
                return false;
            }
        }
        {
            List<String> lhsDropzone;
            lhsDropzone = (this.isSetDropzone()?this.getDropzone():null);
            List<String> rhsDropzone;
            rhsDropzone = (that.isSetDropzone()?that.getDropzone():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dropzone", lhsDropzone), LocatorUtils.property(thatLocator, "dropzone", rhsDropzone), lhsDropzone, rhsDropzone)) {
                return false;
            }
        }
        {
            String lhsHidden;
            lhsHidden = this.getHidden();
            String rhsHidden;
            rhsHidden = that.getHidden();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "hidden", lhsHidden), LocatorUtils.property(thatLocator, "hidden", rhsHidden), lhsHidden, rhsHidden)) {
                return false;
            }
        }
        {
            String lhsLangCode;
            lhsLangCode = this.getLangCode();
            String rhsLangCode;
            rhsLangCode = that.getLangCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "langCode", lhsLangCode), LocatorUtils.property(thatLocator, "langCode", rhsLangCode), lhsLangCode, rhsLangCode)) {
                return false;
            }
        }
        {
            String lhsRole;
            lhsRole = this.getRole();
            String rhsRole;
            rhsRole = that.getRole();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "role", lhsRole), LocatorUtils.property(thatLocator, "role", rhsRole), lhsRole, rhsRole)) {
                return false;
            }
        }
        {
            String lhsSpellcheck;
            lhsSpellcheck = this.getSpellcheck();
            String rhsSpellcheck;
            rhsSpellcheck = that.getSpellcheck();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "spellcheck", lhsSpellcheck), LocatorUtils.property(thatLocator, "spellcheck", rhsSpellcheck), lhsSpellcheck, rhsSpellcheck)) {
                return false;
            }
        }
        {
            Integer lhsTabindex;
            lhsTabindex = this.getTabindex();
            Integer rhsTabindex;
            rhsTabindex = that.getTabindex();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tabindex", lhsTabindex), LocatorUtils.property(thatLocator, "tabindex", rhsTabindex), lhsTabindex, rhsTabindex)) {
                return false;
            }
        }
        {
            String lhsLang;
            lhsLang = this.getLang();
            String rhsLang;
            rhsLang = that.getLang();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lang", lhsLang), LocatorUtils.property(thatLocator, "lang", rhsLang), lhsLang, rhsLang)) {
                return false;
            }
        }
        {
            String lhsItemscope;
            lhsItemscope = this.getItemscope();
            String rhsItemscope;
            rhsItemscope = that.getItemscope();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemscope", lhsItemscope), LocatorUtils.property(thatLocator, "itemscope", rhsItemscope), lhsItemscope, rhsItemscope)) {
                return false;
            }
        }
        {
            String lhsItemtype;
            lhsItemtype = this.getItemtype();
            String rhsItemtype;
            rhsItemtype = that.getItemtype();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemtype", lhsItemtype), LocatorUtils.property(thatLocator, "itemtype", rhsItemtype), lhsItemtype, rhsItemtype)) {
                return false;
            }
        }
        {
            List<String> lhsItemprop;
            lhsItemprop = (this.isSetItemprop()?this.getItemprop():null);
            List<String> rhsItemprop;
            rhsItemprop = (that.isSetItemprop()?that.getItemprop():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemprop", lhsItemprop), LocatorUtils.property(thatLocator, "itemprop", rhsItemprop), lhsItemprop, rhsItemprop)) {
                return false;
            }
        }
        {
            List<String> lhsItemref;
            lhsItemref = (this.isSetItemref()?this.getItemref():null);
            List<String> rhsItemref;
            rhsItemref = (that.isSetItemref()?that.getItemref():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemref", lhsItemref), LocatorUtils.property(thatLocator, "itemref", rhsItemref), lhsItemref, rhsItemref)) {
                return false;
            }
        }
        {
            String lhsItemid;
            lhsItemid = this.getItemid();
            String rhsItemid;
            rhsItemid = that.getItemid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemid", lhsItemid), LocatorUtils.property(thatLocator, "itemid", rhsItemid), lhsItemid, rhsItemid)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(java.lang.Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theSrc;
            theSrc = this.getSrc();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "src", theSrc), currentHashCode, theSrc);
        }
        {
            String theKind;
            theKind = this.getKind();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "kind", theKind), currentHashCode, theKind);
        }
        {
            String theSrclang;
            theSrclang = this.getSrclang();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "srclang", theSrclang), currentHashCode, theSrclang);
        }
        {
            String theLabel;
            theLabel = this.getLabel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "label", theLabel), currentHashCode, theLabel);
        }
        {
            String theDefault;
            theDefault = this.getDefault();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "_default", theDefault), currentHashCode, theDefault);
        }
        {
            String theOnclick;
            theOnclick = this.getOnclick();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onclick", theOnclick), currentHashCode, theOnclick);
        }
        {
            String theOndblclick;
            theOndblclick = this.getOndblclick();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ondblclick", theOndblclick), currentHashCode, theOndblclick);
        }
        {
            String theOnmousedown;
            theOnmousedown = this.getOnmousedown();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onmousedown", theOnmousedown), currentHashCode, theOnmousedown);
        }
        {
            String theOnmouseup;
            theOnmouseup = this.getOnmouseup();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onmouseup", theOnmouseup), currentHashCode, theOnmouseup);
        }
        {
            String theOnmouseover;
            theOnmouseover = this.getOnmouseover();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onmouseover", theOnmouseover), currentHashCode, theOnmouseover);
        }
        {
            String theOnmousemove;
            theOnmousemove = this.getOnmousemove();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onmousemove", theOnmousemove), currentHashCode, theOnmousemove);
        }
        {
            String theOnmouseout;
            theOnmouseout = this.getOnmouseout();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onmouseout", theOnmouseout), currentHashCode, theOnmouseout);
        }
        {
            String theOnkeypress;
            theOnkeypress = this.getOnkeypress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onkeypress", theOnkeypress), currentHashCode, theOnkeypress);
        }
        {
            String theOnkeydown;
            theOnkeydown = this.getOnkeydown();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onkeydown", theOnkeydown), currentHashCode, theOnkeydown);
        }
        {
            String theOnkeyup;
            theOnkeyup = this.getOnkeyup();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onkeyup", theOnkeyup), currentHashCode, theOnkeyup);
        }
        {
            String theOnabort;
            theOnabort = this.getOnabort();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onabort", theOnabort), currentHashCode, theOnabort);
        }
        {
            String theOnblur;
            theOnblur = this.getOnblur();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onblur", theOnblur), currentHashCode, theOnblur);
        }
        {
            String theOncanplay;
            theOncanplay = this.getOncanplay();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "oncanplay", theOncanplay), currentHashCode, theOncanplay);
        }
        {
            String theOncanplaythrough;
            theOncanplaythrough = this.getOncanplaythrough();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "oncanplaythrough", theOncanplaythrough), currentHashCode, theOncanplaythrough);
        }
        {
            String theOnchange;
            theOnchange = this.getOnchange();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onchange", theOnchange), currentHashCode, theOnchange);
        }
        {
            String theOncontextmenu;
            theOncontextmenu = this.getOncontextmenu();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "oncontextmenu", theOncontextmenu), currentHashCode, theOncontextmenu);
        }
        {
            String theOncuechange;
            theOncuechange = this.getOncuechange();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "oncuechange", theOncuechange), currentHashCode, theOncuechange);
        }
        {
            String theOndrag;
            theOndrag = this.getOndrag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ondrag", theOndrag), currentHashCode, theOndrag);
        }
        {
            String theOndragend;
            theOndragend = this.getOndragend();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ondragend", theOndragend), currentHashCode, theOndragend);
        }
        {
            String theOndragenter;
            theOndragenter = this.getOndragenter();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ondragenter", theOndragenter), currentHashCode, theOndragenter);
        }
        {
            String theOndragleave;
            theOndragleave = this.getOndragleave();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ondragleave", theOndragleave), currentHashCode, theOndragleave);
        }
        {
            String theOndragover;
            theOndragover = this.getOndragover();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ondragover", theOndragover), currentHashCode, theOndragover);
        }
        {
            String theOndragstart;
            theOndragstart = this.getOndragstart();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ondragstart", theOndragstart), currentHashCode, theOndragstart);
        }
        {
            String theOndrop;
            theOndrop = this.getOndrop();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ondrop", theOndrop), currentHashCode, theOndrop);
        }
        {
            String theOndurationchange;
            theOndurationchange = this.getOndurationchange();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ondurationchange", theOndurationchange), currentHashCode, theOndurationchange);
        }
        {
            String theOnemptied;
            theOnemptied = this.getOnemptied();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onemptied", theOnemptied), currentHashCode, theOnemptied);
        }
        {
            String theOnended;
            theOnended = this.getOnended();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onended", theOnended), currentHashCode, theOnended);
        }
        {
            String theOnerror;
            theOnerror = this.getOnerror();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onerror", theOnerror), currentHashCode, theOnerror);
        }
        {
            String theOnfocus;
            theOnfocus = this.getOnfocus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onfocus", theOnfocus), currentHashCode, theOnfocus);
        }
        {
            String theOnformchange;
            theOnformchange = this.getOnformchange();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onformchange", theOnformchange), currentHashCode, theOnformchange);
        }
        {
            String theOnforminput;
            theOnforminput = this.getOnforminput();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onforminput", theOnforminput), currentHashCode, theOnforminput);
        }
        {
            String theOninput;
            theOninput = this.getOninput();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "oninput", theOninput), currentHashCode, theOninput);
        }
        {
            String theOninvalid;
            theOninvalid = this.getOninvalid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "oninvalid", theOninvalid), currentHashCode, theOninvalid);
        }
        {
            String theOnload;
            theOnload = this.getOnload();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onload", theOnload), currentHashCode, theOnload);
        }
        {
            String theOnloadeddata;
            theOnloadeddata = this.getOnloadeddata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onloadeddata", theOnloadeddata), currentHashCode, theOnloadeddata);
        }
        {
            String theOnloadedmetadata;
            theOnloadedmetadata = this.getOnloadedmetadata();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onloadedmetadata", theOnloadedmetadata), currentHashCode, theOnloadedmetadata);
        }
        {
            String theOnloadstart;
            theOnloadstart = this.getOnloadstart();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onloadstart", theOnloadstart), currentHashCode, theOnloadstart);
        }
        {
            String theOnmousewheel;
            theOnmousewheel = this.getOnmousewheel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onmousewheel", theOnmousewheel), currentHashCode, theOnmousewheel);
        }
        {
            String theOnpause;
            theOnpause = this.getOnpause();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onpause", theOnpause), currentHashCode, theOnpause);
        }
        {
            String theOnplay;
            theOnplay = this.getOnplay();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onplay", theOnplay), currentHashCode, theOnplay);
        }
        {
            String theOnplaying;
            theOnplaying = this.getOnplaying();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onplaying", theOnplaying), currentHashCode, theOnplaying);
        }
        {
            String theOnprogress;
            theOnprogress = this.getOnprogress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onprogress", theOnprogress), currentHashCode, theOnprogress);
        }
        {
            String theOnratechange;
            theOnratechange = this.getOnratechange();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onratechange", theOnratechange), currentHashCode, theOnratechange);
        }
        {
            String theOnreadystatechange;
            theOnreadystatechange = this.getOnreadystatechange();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onreadystatechange", theOnreadystatechange), currentHashCode, theOnreadystatechange);
        }
        {
            String theOnreset;
            theOnreset = this.getOnreset();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onreset", theOnreset), currentHashCode, theOnreset);
        }
        {
            String theOnscroll;
            theOnscroll = this.getOnscroll();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onscroll", theOnscroll), currentHashCode, theOnscroll);
        }
        {
            String theOnseeked;
            theOnseeked = this.getOnseeked();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onseeked", theOnseeked), currentHashCode, theOnseeked);
        }
        {
            String theOnseeking;
            theOnseeking = this.getOnseeking();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onseeking", theOnseeking), currentHashCode, theOnseeking);
        }
        {
            String theOnselect;
            theOnselect = this.getOnselect();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onselect", theOnselect), currentHashCode, theOnselect);
        }
        {
            String theOnshow;
            theOnshow = this.getOnshow();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onshow", theOnshow), currentHashCode, theOnshow);
        }
        {
            String theOnstalled;
            theOnstalled = this.getOnstalled();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onstalled", theOnstalled), currentHashCode, theOnstalled);
        }
        {
            String theOnsubmit;
            theOnsubmit = this.getOnsubmit();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onsubmit", theOnsubmit), currentHashCode, theOnsubmit);
        }
        {
            String theOnsuspend;
            theOnsuspend = this.getOnsuspend();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onsuspend", theOnsuspend), currentHashCode, theOnsuspend);
        }
        {
            String theOntimeupdate;
            theOntimeupdate = this.getOntimeupdate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ontimeupdate", theOntimeupdate), currentHashCode, theOntimeupdate);
        }
        {
            String theOnvolumechange;
            theOnvolumechange = this.getOnvolumechange();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onvolumechange", theOnvolumechange), currentHashCode, theOnvolumechange);
        }
        {
            String theOnwaiting;
            theOnwaiting = this.getOnwaiting();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "onwaiting", theOnwaiting), currentHashCode, theOnwaiting);
        }
        {
            String theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            List<String> theCssClass;
            theCssClass = (this.isSetCssClass()?this.getCssClass():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cssClass", theCssClass), currentHashCode, theCssClass);
        }
        {
            String theStyle;
            theStyle = this.getStyle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "style", theStyle), currentHashCode, theStyle);
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTitle), currentHashCode, theTitle);
        }
        {
            String theAccesskey;
            theAccesskey = this.getAccesskey();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accesskey", theAccesskey), currentHashCode, theAccesskey);
        }
        {
            boolean theContenteditable;
            theContenteditable = (this.isSetContenteditable()?this.isContenteditable():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contenteditable", theContenteditable), currentHashCode, theContenteditable);
        }
        {
            String theContextmenu;
            theContextmenu = this.getContextmenu();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contextmenu", theContextmenu), currentHashCode, theContextmenu);
        }
        {
            String theDir;
            theDir = this.getDir();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dir", theDir), currentHashCode, theDir);
        }
        {
            String theDraggable;
            theDraggable = this.getDraggable();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "draggable", theDraggable), currentHashCode, theDraggable);
        }
        {
            List<String> theDropzone;
            theDropzone = (this.isSetDropzone()?this.getDropzone():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dropzone", theDropzone), currentHashCode, theDropzone);
        }
        {
            String theHidden;
            theHidden = this.getHidden();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hidden", theHidden), currentHashCode, theHidden);
        }
        {
            String theLangCode;
            theLangCode = this.getLangCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "langCode", theLangCode), currentHashCode, theLangCode);
        }
        {
            String theRole;
            theRole = this.getRole();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "role", theRole), currentHashCode, theRole);
        }
        {
            String theSpellcheck;
            theSpellcheck = this.getSpellcheck();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "spellcheck", theSpellcheck), currentHashCode, theSpellcheck);
        }
        {
            Integer theTabindex;
            theTabindex = this.getTabindex();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tabindex", theTabindex), currentHashCode, theTabindex);
        }
        {
            String theLang;
            theLang = this.getLang();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lang", theLang), currentHashCode, theLang);
        }
        {
            String theItemscope;
            theItemscope = this.getItemscope();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemscope", theItemscope), currentHashCode, theItemscope);
        }
        {
            String theItemtype;
            theItemtype = this.getItemtype();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemtype", theItemtype), currentHashCode, theItemtype);
        }
        {
            List<String> theItemprop;
            theItemprop = (this.isSetItemprop()?this.getItemprop():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemprop", theItemprop), currentHashCode, theItemprop);
        }
        {
            List<String> theItemref;
            theItemref = (this.isSetItemref()?this.getItemref():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemref", theItemref), currentHashCode, theItemref);
        }
        {
            String theItemid;
            theItemid = this.getItemid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemid", theItemid), currentHashCode, theItemid);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}

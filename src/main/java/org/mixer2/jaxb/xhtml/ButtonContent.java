
package org.mixer2.jaxb.xhtml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;
import org.mixer2.xhtml.AbstractJaxb;


/**
 * 
 *       button uses "Flow" but excludes a, form, form controls, iframe
 *       
 * 
 * <p>button.content complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="button.content">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}p"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}heading"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}div"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}lists"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}blocktext"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}table"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}br"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}span"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}bdo"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}object"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}applet"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}img"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}map"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}fontstyle"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}phrase"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}misc"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}embed"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "button.content", propOrder = {
    "content"
})
@XmlSeeAlso({
    Button.class
})
public class ButtonContent
    extends AbstractJaxb
    implements Cloneable, CopyTo
{

    @XmlElementRefs({
        @XmlElementRef(name = "s", namespace = "http://www.w3.org/1999/xhtml", type = S.class),
        @XmlElementRef(name = "dfn", namespace = "http://www.w3.org/1999/xhtml", type = Dfn.class),
        @XmlElementRef(name = "u", namespace = "http://www.w3.org/1999/xhtml", type = U.class),
        @XmlElementRef(name = "samp", namespace = "http://www.w3.org/1999/xhtml", type = Samp.class),
        @XmlElementRef(name = "big", namespace = "http://www.w3.org/1999/xhtml", type = Big.class),
        @XmlElementRef(name = "address", namespace = "http://www.w3.org/1999/xhtml", type = Address.class),
        @XmlElementRef(name = "object", namespace = "http://www.w3.org/1999/xhtml", type = org.mixer2.jaxb.xhtml.Object.class),
        @XmlElementRef(name = "h3", namespace = "http://www.w3.org/1999/xhtml", type = H3 .class),
        @XmlElementRef(name = "script", namespace = "http://www.w3.org/1999/xhtml", type = Script.class),
        @XmlElementRef(name = "applet", namespace = "http://www.w3.org/1999/xhtml", type = Applet.class),
        @XmlElementRef(name = "em", namespace = "http://www.w3.org/1999/xhtml", type = Em.class),
        @XmlElementRef(name = "tt", namespace = "http://www.w3.org/1999/xhtml", type = Tt.class),
        @XmlElementRef(name = "basefont", namespace = "http://www.w3.org/1999/xhtml", type = Basefont.class),
        @XmlElementRef(name = "audio", namespace = "http://www.w3.org/1999/xhtml", type = Audio.class),
        @XmlElementRef(name = "h5", namespace = "http://www.w3.org/1999/xhtml", type = H5 .class),
        @XmlElementRef(name = "dl", namespace = "http://www.w3.org/1999/xhtml", type = Dl.class),
        @XmlElementRef(name = "b", namespace = "http://www.w3.org/1999/xhtml", type = B.class),
        @XmlElementRef(name = "sub", namespace = "http://www.w3.org/1999/xhtml", type = Sub.class),
        @XmlElementRef(name = "output", namespace = "http://www.w3.org/1999/xhtml", type = Output.class),
        @XmlElementRef(name = "h6", namespace = "http://www.w3.org/1999/xhtml", type = H6 .class),
        @XmlElementRef(name = "ul", namespace = "http://www.w3.org/1999/xhtml", type = Ul.class),
        @XmlElementRef(name = "font", namespace = "http://www.w3.org/1999/xhtml", type = Font.class),
        @XmlElementRef(name = "embed", namespace = "http://www.w3.org/1999/xhtml", type = Embed.class),
        @XmlElementRef(name = "strike", namespace = "http://www.w3.org/1999/xhtml", type = Strike.class),
        @XmlElementRef(name = "cite", namespace = "http://www.w3.org/1999/xhtml", type = Cite.class),
        @XmlElementRef(name = "acronym", namespace = "http://www.w3.org/1999/xhtml", type = Acronym.class),
        @XmlElementRef(name = "p", namespace = "http://www.w3.org/1999/xhtml", type = P.class),
        @XmlElementRef(name = "command", namespace = "http://www.w3.org/1999/xhtml", type = Command.class),
        @XmlElementRef(name = "dir", namespace = "http://www.w3.org/1999/xhtml", type = Dir.class),
        @XmlElementRef(name = "ins", namespace = "http://www.w3.org/1999/xhtml", type = Ins.class),
        @XmlElementRef(name = "noframes", namespace = "http://www.w3.org/1999/xhtml", type = Noframes.class),
        @XmlElementRef(name = "abbr", namespace = "http://www.w3.org/1999/xhtml", type = Abbr.class),
        @XmlElementRef(name = "rp", namespace = "http://www.w3.org/1999/xhtml", type = Rp.class),
        @XmlElementRef(name = "small", namespace = "http://www.w3.org/1999/xhtml", type = Small.class),
        @XmlElementRef(name = "span", namespace = "http://www.w3.org/1999/xhtml", type = Span.class),
        @XmlElementRef(name = "mark", namespace = "http://www.w3.org/1999/xhtml", type = Mark.class),
        @XmlElementRef(name = "noscript", namespace = "http://www.w3.org/1999/xhtml", type = Noscript.class),
        @XmlElementRef(name = "h2", namespace = "http://www.w3.org/1999/xhtml", type = H2 .class),
        @XmlElementRef(name = "meter", namespace = "http://www.w3.org/1999/xhtml", type = Meter.class),
        @XmlElementRef(name = "bdo", namespace = "http://www.w3.org/1999/xhtml", type = Bdo.class),
        @XmlElementRef(name = "strong", namespace = "http://www.w3.org/1999/xhtml", type = Strong.class),
        @XmlElementRef(name = "var", namespace = "http://www.w3.org/1999/xhtml", type = Var.class),
        @XmlElementRef(name = "bdi", namespace = "http://www.w3.org/1999/xhtml", type = Bdi.class),
        @XmlElementRef(name = "map", namespace = "http://www.w3.org/1999/xhtml", type = Map.class),
        @XmlElementRef(name = "i", namespace = "http://www.w3.org/1999/xhtml", type = I.class),
        @XmlElementRef(name = "keygen", namespace = "http://www.w3.org/1999/xhtml", type = Keygen.class),
        @XmlElementRef(name = "kbd", namespace = "http://www.w3.org/1999/xhtml", type = Kbd.class),
        @XmlElementRef(name = "code", namespace = "http://www.w3.org/1999/xhtml", type = Code.class),
        @XmlElementRef(name = "rt", namespace = "http://www.w3.org/1999/xhtml", type = Rt.class),
        @XmlElementRef(name = "img", namespace = "http://www.w3.org/1999/xhtml", type = Img.class),
        @XmlElementRef(name = "del", namespace = "http://www.w3.org/1999/xhtml", type = Del.class),
        @XmlElementRef(name = "h4", namespace = "http://www.w3.org/1999/xhtml", type = H4 .class),
        @XmlElementRef(name = "br", namespace = "http://www.w3.org/1999/xhtml", type = Br.class),
        @XmlElementRef(name = "table", namespace = "http://www.w3.org/1999/xhtml", type = Table.class),
        @XmlElementRef(name = "q", namespace = "http://www.w3.org/1999/xhtml", type = Q.class),
        @XmlElementRef(name = "sup", namespace = "http://www.w3.org/1999/xhtml", type = Sup.class),
        @XmlElementRef(name = "video", namespace = "http://www.w3.org/1999/xhtml", type = Video.class),
        @XmlElementRef(name = "h1", namespace = "http://www.w3.org/1999/xhtml", type = H1 .class),
        @XmlElementRef(name = "progress", namespace = "http://www.w3.org/1999/xhtml", type = Progress.class),
        @XmlElementRef(name = "time", namespace = "http://www.w3.org/1999/xhtml", type = Time.class),
        @XmlElementRef(name = "center", namespace = "http://www.w3.org/1999/xhtml", type = Center.class),
        @XmlElementRef(name = "ruby", namespace = "http://www.w3.org/1999/xhtml", type = Ruby.class),
        @XmlElementRef(name = "hr", namespace = "http://www.w3.org/1999/xhtml", type = Hr.class),
        @XmlElementRef(name = "hgroup", namespace = "http://www.w3.org/1999/xhtml", type = Hgroup.class),
        @XmlElementRef(name = "pre", namespace = "http://www.w3.org/1999/xhtml", type = Pre.class),
        @XmlElementRef(name = "div", namespace = "http://www.w3.org/1999/xhtml", type = Div.class),
        @XmlElementRef(name = "ol", namespace = "http://www.w3.org/1999/xhtml", type = Ol.class),
        @XmlElementRef(name = "blockquote", namespace = "http://www.w3.org/1999/xhtml", type = Blockquote.class)
    })
    @XmlMixed
    protected List<java.lang.Object> content;

    /**
     * 
     *       button uses "Flow" but excludes a, form, form controls, iframe
     *       Gets the value of the content property.
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
     * {@link S }
     * {@link Dfn }
     * {@link U }
     * {@link Samp }
     * {@link Big }
     * {@link Address }
     * {@link H3 }
     * {@link org.mixer2.jaxb.xhtml.Object }
     * {@link Script }
     * {@link Applet }
     * {@link Em }
     * {@link Tt }
     * {@link Basefont }
     * {@link Audio }
     * {@link B }
     * {@link Dl }
     * {@link H5 }
     * {@link Sub }
     * {@link Output }
     * {@link H6 }
     * {@link Font }
     * {@link Ul }
     * {@link Strike }
     * {@link Embed }
     * {@link Cite }
     * {@link String }
     * {@link Acronym }
     * {@link P }
     * {@link Command }
     * {@link Dir }
     * {@link Ins }
     * {@link Noframes }
     * {@link Abbr }
     * {@link Rp }
     * {@link Small }
     * {@link Span }
     * {@link Mark }
     * {@link Noscript }
     * {@link H2 }
     * {@link Bdo }
     * {@link Meter }
     * {@link Strong }
     * {@link Var }
     * {@link Bdi }
     * {@link Map }
     * {@link I }
     * {@link Keygen }
     * {@link Kbd }
     * {@link Code }
     * {@link Img }
     * {@link Rt }
     * {@link H4 }
     * {@link Del }
     * {@link Br }
     * {@link Table }
     * {@link Q }
     * {@link Progress }
     * {@link H1 }
     * {@link Video }
     * {@link Sup }
     * {@link Center }
     * {@link Time }
     * {@link Ruby }
     * {@link Hgroup }
     * {@link Hr }
     * {@link Div }
     * {@link Pre }
     * {@link Ol }
     * {@link Blockquote }
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

    public java.lang.Object clone() {
        return copyTo(createNewInstance());
    }

    public java.lang.Object copyTo(java.lang.Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public java.lang.Object copyTo(ObjectLocator locator, java.lang.Object target, CopyStrategy strategy) {
        final java.lang.Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof ButtonContent) {
            final ButtonContent copy = ((ButtonContent) draftCopy);
            if (this.isSetContent()) {
                List<java.lang.Object> sourceContent;
                sourceContent = (this.isSetContent()?this.getContent():null);
                @SuppressWarnings("unchecked")
                List<java.lang.Object> copyContent = ((List<java.lang.Object> ) strategy.copy(LocatorUtils.property(locator, "content", sourceContent), sourceContent));
                copy.unsetContent();
                if (copyContent!= null) {
                    List<java.lang.Object> uniqueContentl = copy.getContent();
                    uniqueContentl.addAll(copyContent);
                }
            } else {
                copy.unsetContent();
            }
        }
        return draftCopy;
    }

    public java.lang.Object createNewInstance() {
        return new ButtonContent();
    }

}

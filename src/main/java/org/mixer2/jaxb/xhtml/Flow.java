
package org.mixer2.jaxb.xhtml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.mixer2.xhtml.AbstractJaxb;


/**
 * 
 *       "Flow" mixes block and inline and is used for list items etc.
 *       
 * 
 * <p>Java class for Flow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Flow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}block"/>
 *         &lt;element ref="{http://www.w3.org/1999/xhtml}form"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}inline"/>
 *         &lt;group ref="{http://www.w3.org/1999/xhtml}misc"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flow", propOrder = {
    "content"
})
@XmlSeeAlso({
    Body.class,
    Div.class,
    Del.class,
    Ins.class,
    Noscript.class,
    Ruby.class,
    Iframe.class,
    Footer.class,
    Header.class,
    Figcaption.class,
    Figure.class,
    Nav.class,
    Canvas.class,
    Aside.class,
    Article.class,
    Section.class,
    Td.class,
    Th.class,
    Noframes.class,
    Center.class,
    Blockquote.class,
    Video.class,
    Audio.class,
    Time.class,
    Meter.class,
    Mark.class,
    Progress.class,
    Dd.class,
    Li.class
})
public class Flow
    extends AbstractJaxb
    implements Serializable
{

    private final static long serialVersionUID = 10000L;
    @XmlElementRefs({
        @XmlElementRef(name = "audio", namespace = "http://www.w3.org/1999/xhtml", type = Audio.class),
        @XmlElementRef(name = "section", namespace = "http://www.w3.org/1999/xhtml", type = Section.class),
        @XmlElementRef(name = "input", namespace = "http://www.w3.org/1999/xhtml", type = Input.class),
        @XmlElementRef(name = "form", namespace = "http://www.w3.org/1999/xhtml", type = Form.class),
        @XmlElementRef(name = "dl", namespace = "http://www.w3.org/1999/xhtml", type = Dl.class),
        @XmlElementRef(name = "h2", namespace = "http://www.w3.org/1999/xhtml", type = H2 .class),
        @XmlElementRef(name = "basefont", namespace = "http://www.w3.org/1999/xhtml", type = Basefont.class),
        @XmlElementRef(name = "bdo", namespace = "http://www.w3.org/1999/xhtml", type = Bdo.class),
        @XmlElementRef(name = "acronym", namespace = "http://www.w3.org/1999/xhtml", type = Acronym.class),
        @XmlElementRef(name = "textarea", namespace = "http://www.w3.org/1999/xhtml", type = Textarea.class),
        @XmlElementRef(name = "applet", namespace = "http://www.w3.org/1999/xhtml", type = Applet.class),
        @XmlElementRef(name = "header", namespace = "http://www.w3.org/1999/xhtml", type = Header.class),
        @XmlElementRef(name = "fieldset", namespace = "http://www.w3.org/1999/xhtml", type = Fieldset.class),
        @XmlElementRef(name = "hr", namespace = "http://www.w3.org/1999/xhtml", type = Hr.class),
        @XmlElementRef(name = "time", namespace = "http://www.w3.org/1999/xhtml", type = Time.class),
        @XmlElementRef(name = "noscript", namespace = "http://www.w3.org/1999/xhtml", type = Noscript.class),
        @XmlElementRef(name = "wbr", namespace = "http://www.w3.org/1999/xhtml", type = Wbr.class),
        @XmlElementRef(name = "code", namespace = "http://www.w3.org/1999/xhtml", type = Code.class),
        @XmlElementRef(name = "del", namespace = "http://www.w3.org/1999/xhtml", type = Del.class),
        @XmlElementRef(name = "table", namespace = "http://www.w3.org/1999/xhtml", type = Table.class),
        @XmlElementRef(name = "br", namespace = "http://www.w3.org/1999/xhtml", type = Br.class),
        @XmlElementRef(name = "ol", namespace = "http://www.w3.org/1999/xhtml", type = Ol.class),
        @XmlElementRef(name = "h1", namespace = "http://www.w3.org/1999/xhtml", type = H1 .class),
        @XmlElementRef(name = "h5", namespace = "http://www.w3.org/1999/xhtml", type = H5 .class),
        @XmlElementRef(name = "iframe", namespace = "http://www.w3.org/1999/xhtml", type = Iframe.class),
        @XmlElementRef(name = "label", namespace = "http://www.w3.org/1999/xhtml", type = Label.class),
        @XmlElementRef(name = "bdi", namespace = "http://www.w3.org/1999/xhtml", type = Bdi.class),
        @XmlElementRef(name = "menu", namespace = "http://www.w3.org/1999/xhtml", type = Menu.class),
        @XmlElementRef(name = "samp", namespace = "http://www.w3.org/1999/xhtml", type = Samp.class),
        @XmlElementRef(name = "strike", namespace = "http://www.w3.org/1999/xhtml", type = Strike.class),
        @XmlElementRef(name = "video", namespace = "http://www.w3.org/1999/xhtml", type = Video.class),
        @XmlElementRef(name = "dir", namespace = "http://www.w3.org/1999/xhtml", type = Dir.class),
        @XmlElementRef(name = "div", namespace = "http://www.w3.org/1999/xhtml", type = Div.class),
        @XmlElementRef(name = "hgroup", namespace = "http://www.w3.org/1999/xhtml", type = Hgroup.class),
        @XmlElementRef(name = "em", namespace = "http://www.w3.org/1999/xhtml", type = Em.class),
        @XmlElementRef(name = "b", namespace = "http://www.w3.org/1999/xhtml", type = B.class),
        @XmlElementRef(name = "footer", namespace = "http://www.w3.org/1999/xhtml", type = Footer.class),
        @XmlElementRef(name = "abbr", namespace = "http://www.w3.org/1999/xhtml", type = Abbr.class),
        @XmlElementRef(name = "output", namespace = "http://www.w3.org/1999/xhtml", type = Output.class),
        @XmlElementRef(name = "s", namespace = "http://www.w3.org/1999/xhtml", type = S.class),
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
        @XmlElementRef(name = "small", namespace = "http://www.w3.org/1999/xhtml", type = Small.class),
        @XmlElementRef(name = "font", namespace = "http://www.w3.org/1999/xhtml", type = Font.class),
        @XmlElementRef(name = "h4", namespace = "http://www.w3.org/1999/xhtml", type = H4 .class),
        @XmlElementRef(name = "sup", namespace = "http://www.w3.org/1999/xhtml", type = Sup.class),
        @XmlElementRef(name = "keygen", namespace = "http://www.w3.org/1999/xhtml", type = Keygen.class),
        @XmlElementRef(name = "object", namespace = "http://www.w3.org/1999/xhtml", type = org.mixer2.jaxb.xhtml.Object.class),
        @XmlElementRef(name = "progress", namespace = "http://www.w3.org/1999/xhtml", type = Progress.class),
        @XmlElementRef(name = "pre", namespace = "http://www.w3.org/1999/xhtml", type = Pre.class),
        @XmlElementRef(name = "map", namespace = "http://www.w3.org/1999/xhtml", type = Map.class),
        @XmlElementRef(name = "script", namespace = "http://www.w3.org/1999/xhtml", type = Script.class),
        @XmlElementRef(name = "datalist", namespace = "http://www.w3.org/1999/xhtml", type = Datalist.class),
        @XmlElementRef(name = "aside", namespace = "http://www.w3.org/1999/xhtml", type = Aside.class),
        @XmlElementRef(name = "dfn", namespace = "http://www.w3.org/1999/xhtml", type = Dfn.class),
        @XmlElementRef(name = "cite", namespace = "http://www.w3.org/1999/xhtml", type = Cite.class),
        @XmlElementRef(name = "center", namespace = "http://www.w3.org/1999/xhtml", type = Center.class),
        @XmlElementRef(name = "kbd", namespace = "http://www.w3.org/1999/xhtml", type = Kbd.class),
        @XmlElementRef(name = "details", namespace = "http://www.w3.org/1999/xhtml", type = Details.class),
        @XmlElementRef(name = "command", namespace = "http://www.w3.org/1999/xhtml", type = Command.class),
        @XmlElementRef(name = "select", namespace = "http://www.w3.org/1999/xhtml", type = Select.class),
        @XmlElementRef(name = "embed", namespace = "http://www.w3.org/1999/xhtml", type = Embed.class),
        @XmlElementRef(name = "p", namespace = "http://www.w3.org/1999/xhtml", type = P.class),
        @XmlElementRef(name = "blockquote", namespace = "http://www.w3.org/1999/xhtml", type = Blockquote.class),
        @XmlElementRef(name = "big", namespace = "http://www.w3.org/1999/xhtml", type = Big.class),
        @XmlElementRef(name = "q", namespace = "http://www.w3.org/1999/xhtml", type = Q.class),
        @XmlElementRef(name = "noframes", namespace = "http://www.w3.org/1999/xhtml", type = Noframes.class),
        @XmlElementRef(name = "track", namespace = "http://www.w3.org/1999/xhtml", type = Track.class),
        @XmlElementRef(name = "rp", namespace = "http://www.w3.org/1999/xhtml", type = Rp.class),
        @XmlElementRef(name = "img", namespace = "http://www.w3.org/1999/xhtml", type = Img.class),
        @XmlElementRef(name = "var", namespace = "http://www.w3.org/1999/xhtml", type = Var.class),
        @XmlElementRef(name = "article", namespace = "http://www.w3.org/1999/xhtml", type = Article.class)
    })
    @XmlMixed
    protected List<java.lang.Object> content;

    /**
     * 
     *       "Flow" mixes block and inline and is used for list items etc.
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
     * {@link Audio }
     * {@link Form }
     * {@link Input }
     * {@link Section }
     * {@link Basefont }
     * {@link H2 }
     * {@link Dl }
     * {@link Acronym }
     * {@link Bdo }
     * {@link Textarea }
     * {@link Applet }
     * {@link Header }
     * {@link Hr }
     * {@link Fieldset }
     * {@link Time }
     * {@link Noscript }
     * {@link Wbr }
     * {@link Code }
     * {@link Br }
     * {@link Table }
     * {@link Del }
     * {@link H1 }
     * {@link Ol }
     * {@link H5 }
     * {@link Iframe }
     * {@link Menu }
     * {@link Bdi }
     * {@link Label }
     * {@link Samp }
     * {@link Video }
     * {@link Strike }
     * {@link Dir }
     * {@link Div }
     * {@link Hgroup }
     * {@link Em }
     * {@link Footer }
     * {@link B }
     * {@link S }
     * {@link Output }
     * {@link Abbr }
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
     * {@link H4 }
     * {@link Font }
     * {@link Small }
     * {@link Sup }
     * {@link Keygen }
     * {@link org.mixer2.jaxb.xhtml.Object }
     * {@link Progress }
     * {@link Map }
     * {@link Pre }
     * {@link Datalist }
     * {@link Script }
     * {@link Aside }
     * {@link Dfn }
     * {@link Center }
     * {@link Cite }
     * {@link Kbd }
     * {@link Details }
     * {@link Select }
     * {@link Command }
     * {@link P }
     * {@link Embed }
     * {@link Blockquote }
     * {@link Q }
     * {@link Big }
     * {@link Noframes }
     * {@link Track }
     * {@link Img }
     * {@link Rp }
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

}

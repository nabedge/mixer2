package org.mixer2.xhtml.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 *
 * @see org.mixer2.xhtml.AbstractJaxb#replaceDescendants(Class, String)
 * @see org.mixer2.xhtml.AbstractJaxb#replaceDescendants(Class, AbstractJaxb)
 * @see org.mixer2.xhtml.AbstractJaxb#replaceDescendants(String, String)
 * @see org.mixer2.xhtml.AbstractJaxb#replaceDescendants(String, AbstractJaxb)
 * @see org.mixer2.xhtml.AbstractJaxb#replaceDescendants(String, Class, String)
 * @see org.mixer2.xhtml.AbstractJaxb#replaceDescendants(String, Class, AbstractJaxb)
 * @author watanabe
 *
 */
public class ReplaceDescendantsUtil {

    @SuppressWarnings("unused")
    private static Log log = LogFactory.getLog(ReplaceDescendantsUtil.class);

    /**
     * タグとclass指定で子孫要素を置換する なお、replaceのディープコピーで置換されます。
     *
     * @param <T>
     *            tag type. (i.e. Div.class, Span.class...)
     * @param target
     *            object for scan
     * @param tagType
     *            tag class
     * @param clazz
     *            class property of tag
     * @param replace
     *            replacement tag object.
     * @return
     * @throws TagTypeUnmatchException
     */
    public static <T extends AbstractJaxb> void replaceDescendants(T target,
            Class<T> tagType, String clazz, T replace)
            throws TagTypeUnmatchException {
        execute(target, tagType, clazz, replace);
    }

    public static <T extends AbstractJaxb> void replaceDescendants(T target,
            Class<T> tagType, String clazz, String replace)
            throws TagTypeUnmatchException {
        execute(target, tagType, clazz, replace);
    }

    /**
     * タグ指定で子孫要素を置換する なお、replaceのディープコピーで置換されます。
     *
     * @param <T>
     *            tag type. (i.e. Div.class, Span.class...)
     * @param target
     *            object for scan
     * @param tagType
     *            tag class
     * @param replace
     *            replacement tag object.
     * @return
     * @throws TagTypeUnmatchException
     */
    public static <T extends AbstractJaxb> void replaceDescendants(T target,
            Class<T> tagType, T replace) throws TagTypeUnmatchException {
        execute(target, tagType, null, replace);
    }

    public static <T extends AbstractJaxb> void replaceDescendants(T target,
            Class<T> tagType, String replace) throws TagTypeUnmatchException {
        execute(target, tagType, null, replace);
    }

    /**
     * class属性の指定で子孫要素を置換する なお、replaceのディープコピーで置換されます。
     *
     * @param target
     *            object for scan
     * @param clazz
     *            class property of tag
     * @param replace
     *            replacement tag object
     * @return
     * @throws TagTypeUnmatchException
     */
    public static <T extends AbstractJaxb> void replaceDescendants(T target,
            String clazz, T replace) throws TagTypeUnmatchException {
        execute(target, null, clazz, replace);
    }

    public static <T extends AbstractJaxb> void replaceDescendants(T target,
            String clazz, String replace) throws TagTypeUnmatchException {
        execute(target, null, clazz, replace);
    }

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> void replaceDescendantsWithinObjectList(
            List<java.lang.Object> list, Class<T> tagType, String clazz,
            java.lang.Object replace) throws TagTypeUnmatchException {
        java.lang.Object tmpobj;

        for (ListIterator<java.lang.Object> i = list.listIterator(); i.hasNext();) {
            tmpobj = i.next();
            if (tmpobj instanceof AbstractJaxb) {
                if (match(tmpobj.getClass(), ((AbstractJaxb) tmpobj).getCssClass(),
                        tagType, clazz)) {
                    if (replace instanceof String) {
                        i.set(replace);
                    } else {
                        Class<? extends AbstractJaxb> cls = ((T) replace)
                                .getClass();
                        i.set(((T) replace).copy(cls));
                    }
                } else {
                    if (replace instanceof AbstractJaxb) {
                        replaceDescendants((T) tmpobj, tagType, clazz,
                                (T) replace);
                    }
                    if (replace instanceof String) {
                        replaceDescendants((T) tmpobj, tagType, clazz,
                                (String) replace);
                    }
                }
            }
        }

    }

    @SuppressWarnings({ "unchecked" })
    private static <T extends AbstractJaxb> void execute(java.lang.Object target,
            Class<T> tagType, String clazz, java.lang.Object replace)
            throws TagTypeUnmatchException {

        @SuppressWarnings("rawtypes")
        Class cls;

        TagEnum tagEnum;

        // target must be Tag
        if (target instanceof AbstractJaxb) {
            tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                    .toUpperCase());
        } else {
            return;
        }

        switch (tagEnum) {
        case A:
            A a = (A) target;
            if (match(a.getClass(), a.getCssClass(), tagType, clazz)) {
                return;
            }
            if (a.isSetContent()) {
                replaceDescendantsWithinObjectList(a.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case ABBR:
            Abbr abbr = (Abbr) target;
            if (match(abbr.getClass(), abbr.getCssClass(), tagType, clazz)) {
                return;
            }
            if (abbr.isSetContent()) {
                replaceDescendantsWithinObjectList(abbr.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            if (match(acronym.getClass(), acronym.getCssClass(), tagType, clazz)) {
                return;
            }
            if (acronym.isSetContent()) {
                replaceDescendantsWithinObjectList(acronym.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case ADDRESS:
            Address address = (Address) target;
            if (match(address.getClass(), address.getCssClass(), tagType, clazz)) {
                return;
            }
            if (address.isSetContent()) {
                replaceDescendantsWithinObjectList(address.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case APPLET:
            Applet applet = (Applet) target;
            if (match(applet.getClass(), applet.getCssClass(), tagType, clazz)) {
                return;
            }
            if (applet.isSetContent()) {
                replaceDescendantsWithinObjectList(applet.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case AREA:
            Area area = (Area) target;
            if (match(area.getClass(), area.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case B:
            B b = (B) target;
            if (match(b.getClass(), b.getCssClass(), tagType, clazz)) {
                return;
            }
            if (b.isSetContent()) {
                replaceDescendantsWithinObjectList(b.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case BASE:
            Base base = (Base) target;
            if (match(base.getClass(), base.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element.
            break;
        case BASEFONT:
            Basefont basefont = (Basefont) target;
            if (match(basefont.getClass(), basefont.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element.
            break;
        case BDO:
            Bdo bdo = (Bdo) target;
            if (match(bdo.getClass(), bdo.getCssClass(), tagType, clazz)) {
                return;
            }
            if (bdo.isSetContent()) {
                replaceDescendantsWithinObjectList(bdo.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case BIG:
            Big big = (Big) target;
            if (match(big.getClass(), big.getCssClass(), tagType, clazz)) {
                return;
            }
            if (big.isSetContent()) {
                replaceDescendantsWithinObjectList(big.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case BLOCKQUOTE:
            Blockquote blockquote = (Blockquote) target;
            if (match(blockquote.getClass(), blockquote.getCssClass(), tagType,
                    clazz)) {
                return;
            }
            if (blockquote.isSetContent()) {
                replaceDescendantsWithinObjectList(blockquote.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case BODY:
            Body body = (Body) target;
            if (match(body.getClass(), body.getCssClass(), tagType, clazz)) {
                return;
            }
            if (body.isSetContent()) {
                replaceDescendantsWithinObjectList(body.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case BR:
            Br br = (Br) target;
            if (match(br.getClass(), br.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case BUTTON:
            Button button = (Button) target;
            if (match(button.getClass(), button.getCssClass(), tagType, clazz)) {
                return;
            }
            if (button.isSetContent()) {
                replaceDescendantsWithinObjectList(button.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case CAPTION:
            Caption caption = (Caption) target;
            if (match(caption.getClass(), caption.getCssClass(), tagType, clazz)) {
                return;
            }
            if (caption.isSetContent()) {
                replaceDescendantsWithinObjectList(caption.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case CENTER:
            Center center = (Center) target;
            if (match(center.getClass(), center.getCssClass(), tagType, clazz)) {
                return;
            }
            if (center.isSetContent()) {
                replaceDescendantsWithinObjectList(center.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case CITE:
            Cite cite = (Cite) target;
            if (match(cite.getClass(), cite.getCssClass(), tagType, clazz)) {
                return;
            }
            if (cite.isSetContent()) {
                replaceDescendantsWithinObjectList(cite.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case CODE:
            Code code = (Code) target;
            if (match(code.getClass(), code.getCssClass(), tagType, clazz)) {
                return;
            }
            if (code.isSetContent()) {
                replaceDescendantsWithinObjectList(code.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case COL:
            Col col = (Col) target;
            if (match(col.getClass(), col.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case COLGROUP:
            Colgroup colgroup = (Colgroup) target;
            if (match(colgroup.getClass(), colgroup.getCssClass(), tagType,
                    clazz)) {
                return;
            }
            if (colgroup.isSetCol()) {
                for (ListIterator<Col> i = colgroup.getCol().listIterator(); i
                        .hasNext();) {
                    Col tmpcol = i.next();
                    if (match(tmpcol.getClass(), tmpcol.getCssClass(), tagType,
                            clazz)) {
                        if (replace.getClass().equals(Col.class)) {
                            i.set(((Col) replace).copy(Col.class));
                        } else {
                            throw new TagTypeUnmatchException(Col.class,
                                    replace.getClass());
                        }
                    }
                }
            }
            break;
        case DD:
            Dd dd = (Dd) target;
            if (match(dd.getClass(), dd.getCssClass(), tagType, clazz)) {
                return;
            }
            if (dd.isSetContent()) {
                replaceDescendantsWithinObjectList(dd.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case DEL:
            Del del = (Del) target;
            if (match(del.getClass(), del.getCssClass(), tagType, clazz)) {
                return;
            }
            if (del.isSetContent()) {
                replaceDescendantsWithinObjectList(del.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case DFN:
            Dfn dfn = (Dfn) target;
            if (match(dfn.getClass(), dfn.getCssClass(), tagType, clazz)) {
                return;
            }
            if (dfn.isSetContent()) {
                replaceDescendantsWithinObjectList(dfn.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case DIR:
            Dir dir = (Dir) target;
            if (match(dir.getClass(), dir.getCssClass(), tagType, clazz)) {
                return;
            }
            if (dir.isSetLi()) {
                for (ListIterator<Li> i = dir.getLi().listIterator(); i
                        .hasNext();) {
                    Li li = i.next();
                    if (match(li.getClass(), li.getCssClass(), tagType, clazz)) {
                        if (replace.getClass().equals(Li.class)) {
                            i.set(((Li) replace).copy(Li.class));
                        } else {
                            throw new TagTypeUnmatchException(Li.class,
                                    replace.getClass());
                        }
                    } else {
                        replaceDescendantsWithinObjectList(li.getContent(),
                                tagType, clazz, replace);
                    }
                }
            }
            break;
        case DIV:
            Div div = (Div) target;
            if (match(div.getClass(), div.getCssClass(), tagType, clazz)) {
                return;
            }
            if (div.isSetContent()) {
                replaceDescendantsWithinObjectList(div.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case DL:
            Dl dl = (Dl) target;
            if (match(dl.getClass(), dl.getCssClass(), tagType, clazz)) {
                return;
            }
            if (dl.isSetDtOrDd()) {
                for (ListIterator<AbstractJaxb> i = dl.getDtOrDd()
                        .listIterator(); i.hasNext();) {
                    AbstractJaxb aj = i.next();
                    if (match(aj.getClass(), aj.getCssClass(), tagType,
                            clazz)) {
                        if (replace.getClass().equals(Dt.class)) {
                            i.set(((Dt) replace).copy(Dt.class));
                        } else if (replace.getClass().equals(Dd.class)) {
                            i.set(((Dd) replace).copy(Dd.class));
                        } else {
                            throw new TagTypeUnmatchException(
                                    "Dt or Dd expected but replace is "
                                            + replace.getClass());
                        }
                    } else {
                        execute(aj, tagType, clazz, replace);
                    }
                }
            }
            break;
        case DT:
            Dt dt = (Dt) target;
            if (match(dt.getClass(), dt.getCssClass(), tagType, clazz)) {
                return;
            }
            if (dt.isSetContent()) {
                replaceDescendantsWithinObjectList(dt.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case EM:
            Em em = (Em) target;
            if (match(em.getClass(), em.getCssClass(), tagType, clazz)) {
                return;
            }
            if (em.isSetContent()) {
                replaceDescendantsWithinObjectList(em.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case FIELDSET:
            Fieldset fieldset = (Fieldset) target;
            if (match(fieldset.getClass(), fieldset.getCssClass(), tagType,
                    clazz)) {
                return;
            }
            if (fieldset.isSetContent()) {
                replaceDescendantsWithinObjectList(fieldset.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case FONT:
            Font font = (Font) target;
            if (match(font.getClass(), font.getCssClass(), tagType, clazz)) {
                return;
            }
            if (font.isSetContent()) {
                replaceDescendantsWithinObjectList(font.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case FORM:
            Form form = (Form) target;
            if (match(form.getClass(), form.getCssClass(), tagType, clazz)) {
                return;
            }
            if (form.isSetContent()) {
                replaceDescendantsWithinObjectList(form.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case H1:
            H1 h1 = (H1) target;
            if (match(h1.getClass(), h1.getCssClass(), tagType, clazz)) {
                return;
            }
            if (h1.isSetContent()) {
                replaceDescendantsWithinObjectList(h1.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case H2:
            H2 h2 = (H2) target;
            if (match(h2.getClass(), h2.getCssClass(), tagType, clazz)) {
                return;
            }
            if (h2.isSetContent()) {
                replaceDescendantsWithinObjectList(h2.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case H3:
            H3 h3 = (H3) target;
            if (match(h3.getClass(), h3.getCssClass(), tagType, clazz)) {
                return;
            }
            if (h3.isSetContent()) {
                replaceDescendantsWithinObjectList(h3.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case H4:
            H4 h4 = (H4) target;
            if (match(h4.getClass(), h4.getCssClass(), tagType, clazz)) {
                return;
            }
            if (h4.isSetContent()) {
                replaceDescendantsWithinObjectList(h4.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case H5:
            H5 h5 = (H5) target;
            if (match(h5.getClass(), h5.getCssClass(), tagType, clazz)) {
                return;
            }
            if (h5.isSetContent()) {
                replaceDescendantsWithinObjectList(h5.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case H6:
            H6 h6 = (H6) target;
            if (match(h6.getClass(), h6.getCssClass(), tagType, clazz)) {
                return;
            }
            if (h6.isSetContent()) {
                replaceDescendantsWithinObjectList(h6.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case HGROUP:
            Hgroup hgroup = (Hgroup) target;
            if (match(hgroup.getClass(), hgroup.getCssClass(), tagType, clazz)) {
                return;
            }
            if (hgroup.isSetH1OrH2OrH3()) {
                for (ListIterator<Inline> i = hgroup.getH1OrH2OrH3().listIterator(); i.hasNext();) {
                    Inline inline = i.next();
                    if (match(inline.getClass(), inline.getCssClass(), tagType,
                            clazz)) {
                        if (replace instanceof H1 ||replace instanceof H2 ||replace instanceof H3 ||replace instanceof H4 ||replace instanceof H5 ||replace instanceof H6) {
                            cls = ((T) replace).getClass();
                            i.set((Inline) ((T) replace).copy(cls));
                        } else {
                            throw new TagTypeUnmatchException("h1-h6 expected but replace is " + replace.getClass());
                        }
                    } else {
                        execute(inline, tagType, clazz, replace);
                    }
                }
            }
            break;
        case HEAD:
            Head head = (Head) target;
            if (match(head.getClass(), head.getCssClass(), tagType, clazz)) {
                return;
            }
            for (ListIterator<AbstractJaxb> i = head.getContent()
                    .listIterator(); i.hasNext();) {
                AbstractJaxb aj = i.next();
                if (match(aj.getClass(), aj.getCssClass(), tagType,
                        clazz)) {
                    if (replace instanceof AbstractJaxb) {
                        cls = ((T) replace).getClass();
                        i.set(((T) replace).copy(cls));
                    } else {
                        throw new TagTypeUnmatchException(
                                "head object can not include "
                                        + replace.getClass());
                    }
                } else {
                    execute(aj, tagType, clazz, replace);
                }
            }
            break;
        case HR:
            Hr hr = (Hr) target;
            if (match(hr.getClass(), hr.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element.
            break;
        case HTML:
            Html html = (Html) target;
            if (html.isSetHead()) {
                execute(html.getHead(), tagType, clazz, replace);
            }
            if (html.isSetBody()) {
                execute(html.getBody(), tagType, clazz, replace);
            }
            break;
        case I:
            I i = (I) target;
            if (match(i.getClass(), i.getCssClass(), tagType, clazz)) {
                return;
            }
            if (i.isSetContent()) {
                replaceDescendantsWithinObjectList(i.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case IFRAME:
            Iframe iframe = (Iframe) target;
            if (match(iframe.getClass(), iframe.getCssClass(), tagType, clazz)) {
                return;
            }
            if (iframe.isSetContent()) {
                replaceDescendantsWithinObjectList(iframe.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case IMG:
            Img img = (Img) target;
            if (match(img.getClass(), img.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case INPUT:
            Input input = (Input) target;
            if (match(input.getClass(), input.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case INS:
            Ins ins = (Ins) target;
            if (match(ins.getClass(), ins.getCssClass(), tagType, clazz)) {
                return;
            }
            if (ins.isSetContent()) {
                replaceDescendantsWithinObjectList(ins.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case ISINDEX:
            Isindex isindex = (Isindex) target;
            if (match(isindex.getClass(), isindex.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case KBD:
            Kbd kbd = (Kbd) target;
            if (match(kbd.getClass(), kbd.getCssClass(), tagType, clazz)) {
                return;
            }
            if (kbd.isSetContent()) {
                replaceDescendantsWithinObjectList(kbd.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case LABEL:
            Label label = (Label) target;
            if (match(label.getClass(), label.getCssClass(), tagType, clazz)) {
                return;
            }
            if (label.isSetContent()) {
                replaceDescendantsWithinObjectList(label.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case LEGEND:
            Legend legend = (Legend) target;
            if (match(legend.getClass(), legend.getCssClass(), tagType, clazz)) {
                return;
            }
            if (legend.isSetContent()) {
                replaceDescendantsWithinObjectList(legend.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case LI:
            Li li = (Li) target;
            if (match(li.getClass(), li.getCssClass(), tagType, clazz)) {
                return;
            }
            if (li.isSetContent()) {
                replaceDescendantsWithinObjectList(li.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case LINK:
            Link link = (Link) target;
            if (match(link.getClass(), link.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element.
            break;
        case MAP:
            Map map = (Map) target;
            if (match(map.getClass(), map.getCssClass(), tagType, clazz)) {
                return;
            }
            if (map.isSetArea()) {
                for (ListIterator<Area> j = map.getArea().listIterator(); j
                        .hasNext();) {
                    Area tmparea = j.next();
                    if (match(tmparea.getClass(), tmparea.getCssClass(),
                            tagType, clazz)) {
                        if (replace.getClass().equals(Area.class)) {
                            j.set(((Area) replace).copy(Area.class));
                        } else {
                            throw new TagTypeUnmatchException(Area.class,
                                    replace.getClass());
                        }
                    }
                }
            }
            if (map.isSetPOrH1OrH2()) {
                for (ListIterator<AbstractJaxb> j = map.getPOrH1OrH2()
                        .listIterator(); j.hasNext();) {
                    AbstractJaxb aj = j.next();
                    if (match(aj.getClass(), aj.getCssClass(), tagType,
                            clazz)) {
                        if (replace instanceof AbstractJaxb) {
                            cls = replace.getClass();
                            j.set(((T) replace).copy(cls));
                        } else {
                            throw new TagTypeUnmatchException(
                                    "map object can not include "
                                            + replace.getClass());
                        }
                    } else {
                        execute(aj, tagType, clazz, replace);
                    }
                }
            }
            break;
        case MENU:
            Menu menu = (Menu) target;
            if (match(menu.getClass(), menu.getCssClass(), tagType, clazz)) {
                return;
            }
            if (menu.isSetContent()) {
                replaceDescendantsWithinObjectList(menu.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case META:
            Meta meta = (Meta) target;
            if (match(meta.getClass(), meta.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element.
            break;
        case NOFRAMES:
            Noframes noframes = (Noframes) target;
            if (match(noframes.getClass(), noframes.getCssClass(), tagType,
                    clazz)) {
                return;
            }
            if (noframes.isSetContent()) {
                replaceDescendantsWithinObjectList(noframes.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case NOSCRIPT:
            Noscript noscript = (Noscript) target;
            if (match(noscript.getClass(), noscript.getCssClass(), tagType,
                    clazz)) {
                return;
            }
            if (noscript.isSetContent()) {
                replaceDescendantsWithinObjectList(noscript.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
            if (match(object.getClass(), object.getCssClass(), tagType, clazz)) {
                return;
            }
            if (object.isSetContent()) {
                replaceDescendantsWithinObjectList(object.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case OL:
            Ol ol = (Ol) target;
            if (match(ol.getClass(), ol.getCssClass(), tagType, clazz)) {
                return;
            }
            if (ol.isSetLi()) {
                for (ListIterator<Li> j = ol.getLi().listIterator(); j
                        .hasNext();) {
                    Li li2 = j.next();
                    if (match(li2.getClass(), li2.getCssClass(), tagType, clazz)) {
                        if (replace.getClass().equals(Li.class)) {
                            j.set(((Li) replace).copy(Li.class));
                        } else {
                            throw new TagTypeUnmatchException(Li.class,
                                    replace.getClass());
                        }
                    } else {
                        replaceDescendantsWithinObjectList(li2.getContent(),
                                tagType, clazz, replace);
                    }
                }
            }
            break;
        case OPTGROUP:
            Optgroup optgroup = (Optgroup) target;
            if (match(optgroup.getClass(), optgroup.getCssClass(), tagType,
                    clazz)) {
                return;
            }
            if (optgroup.isSetOption()) {
                for (ListIterator<Option> j = optgroup.getOption()
                        .listIterator(); j.hasNext();) {
                    Option op = j.next();
                    if (match(op.getClass(), op.getCssClass(), tagType, clazz)) {
                        if (replace.getClass().equals(Option.class)) {
                            j.set(((Option) replace).copy(Option.class));
                        } else {
                            throw new TagTypeUnmatchException(Option.class,
                                    replace.getClass());
                        }
                    }
                }
            }
            break;
        case OPTION:
            Option option = (Option) target;
            if (match(option.getClass(), option.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case P:
            P p = (P) target;
            if (match(p.getClass(), p.getCssClass(), tagType, clazz)) {
                return;
            }
            if (p.isSetContent()) {
                replaceDescendantsWithinObjectList(p.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case PARAM:
            Param param = (Param) target;
            if (match(param.getClass(), param.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case PRE:
            Pre pre = (Pre) target;
            if (match(pre.getClass(), pre.getCssClass(), tagType, clazz)) {
                return;
            }
            if (pre.isSetContent()) {
                replaceDescendantsWithinObjectList(pre.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case Q:
            Q q = (Q) target;
            if (match(q.getClass(), q.getCssClass(), tagType, clazz)) {
                return;
            }
            if (q.isSetContent()) {
                replaceDescendantsWithinObjectList(q.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case S:
            S s = (S) target;
            if (match(s.getClass(), s.getCssClass(), tagType, clazz)) {
                return;
            }
            if (s.isSetContent()) {
                replaceDescendantsWithinObjectList(s.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case SAMP:
            Samp samp = (Samp) target;
            if (match(samp.getClass(), samp.getCssClass(), tagType, clazz)) {
                return;
            }
            if (samp.isSetContent()) {
                replaceDescendantsWithinObjectList(samp.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case SCRIPT:
            Script script = (Script) target;
            if (match(script.getClass(), script.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element.
            break;
        case SELECT:
            Select select = (Select) target;
            if (match(select.getClass(), select.getCssClass(), tagType, clazz)) {
                return;
            }
            if (select.isSetOptgroupOrOption()) {
                for (ListIterator<AbstractJaxb> j = select
                        .getOptgroupOrOption().listIterator(); j.hasNext();) {
                    AbstractJaxb aj = j.next();
                    if (match(aj.getClass(), aj.getCssClass(), tagType,
                            clazz)) {
                        if (replace.getClass().equals(Optgroup.class)) {
                            j.set(((Optgroup) replace).copy(Optgroup.class));
                        } else if (replace.getClass().equals(Option.class)) {
                            j.set(((Option) replace).copy(Option.class));
                        } else {
                            throw new TagTypeUnmatchException(
                                    "optgroup or option expected but replace is "
                                            + replace.getClass());
                        }
                    } else {
                        execute(aj, tagType, clazz, replace);
                    }
                }
            }
            break;
        case SMALL:
            Small small = (Small) target;
            if (match(small.getClass(), small.getCssClass(), tagType, clazz)) {
                return;
            }
            if (small.isSetContent()) {
                replaceDescendantsWithinObjectList(small.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case SPAN:
            Span span = (Span) target;
            if (match(span.getClass(), span.getCssClass(), tagType, clazz)) {
                return;
            }
            if (span.isSetContent()) {
                replaceDescendantsWithinObjectList(span.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case STRIKE:
            Strike strike = (Strike) target;
            if (match(strike.getClass(), strike.getCssClass(), tagType, clazz)) {
                return;
            }
            if (strike.isSetContent()) {
                replaceDescendantsWithinObjectList(strike.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case STRONG:
            Strong strong = (Strong) target;
            if (match(strong.getClass(), strong.getCssClass(), tagType, clazz)) {
                return;
            }
            if (strong.isSetContent()) {
                replaceDescendantsWithinObjectList(strong.getContent(),
                        tagType, clazz, replace);
            }
            break;
        case STYLE:
            Style style = (Style) target;
            if (match(style.getClass(), style.getCssClass(), tagType, clazz)) {
                return;
            }
            break;
        case SUB:
            Sub sub = (Sub) target;
            if (match(sub.getClass(), sub.getCssClass(), tagType, clazz)) {
                return;
            }
            if (sub.isSetContent()) {
                replaceDescendantsWithinObjectList(sub.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case SUP:
            Sup sup = (Sup) target;
            if (match(sup.getClass(), sup.getCssClass(), tagType, clazz)) {
                return;
            }
            if (sup.isSetContent()) {
                replaceDescendantsWithinObjectList(sup.getContent(), tagType,
                        clazz, replace);
            }
            break;

        case TABLE:
            Table table = (Table) target;
            if (match(table.getClass(), table.getCssClass(), tagType, clazz)) {
                return;
            }
            if (table.isSetCaption()) {
                if (match(table.getCaption().getClass(), table.getCaption()
                        .getCssClass(), tagType, clazz)) {
                    table.setCaption(((Caption) replace).copy(Caption.class));
                }
            }

            if (table.isSetCol()) {
                for (ListIterator<Col> j = table.getCol().listIterator(); j
                        .hasNext();) {
                    Col col1 = j.next();
                    if (match(col1.getClass(), col1.getCssClass(), tagType,
                            clazz)) {
                        if (replace.getClass().equals(Col.class)) {
                            j.set(((Col) replace).copy(Col.class));
                        } else {
                            throw new TagTypeUnmatchException(Col.class,
                                    replace.getClass());
                        }
                    }
                }
            }
            if (table.isSetColgroup()) {
                for (ListIterator<Colgroup> j = table.getColgroup()
                        .listIterator(); j.hasNext();) {
                    Colgroup cg = j.next();
                    if (match(cg.getClass(), cg.getCssClass(), tagType, clazz)) {
                        if (replace.getClass().equals(Colgroup.class)) {
                            j.set(((Colgroup) replace).copy(Colgroup.class));
                        } else {
                            throw new TagTypeUnmatchException(Colgroup.class,
                                    replace.getClass());
                        }
                    } else {
                        execute(cg, tagType, clazz, replace);
                    }
                }
            }
            if (table.isSetTbody()) {
                for (ListIterator<Tbody> j = table.getTbody().listIterator(); j
                        .hasNext();) {
                    Tbody tbody = j.next();
                    if (match(tbody.getClass(), tbody.getCssClass(), tagType,
                            clazz)) {
                        if (replace.getClass().equals(Tbody.class)) {
                            j.set(((Tbody) replace).copy(Tbody.class));
                        } else {
                            throw new TagTypeUnmatchException(
                                    "Tbody,Tr expected but "
                                            + replace.getClass());
                        }
                    } else {
                        execute(tbody, tagType, clazz, replace);
                    }
                }
            }
            if (table.isSetThead()) {
                if (match(Head.class, table.getThead().getCssClass(), tagType,
                        clazz)) {
                    table.setThead(((Thead) replace).copy(Thead.class));
                }
            }
            if (table.isSetTfoot()) {
                if (match(Tfoot.class, table.getTfoot().getCssClass(), tagType,
                        clazz)) {
                    table.setTfoot(((Tfoot) replace).copy(Tfoot.class));
                }
            }
            if (table.isSetTr()) {
                for (ListIterator<Tr> j = table.getTr().listIterator(); j
                        .hasNext();) {
                    Tr tr = j.next();
                    if (match(Tr.class, tr.getCssClass(), tagType, clazz)) {
                        if (replace.getClass().equals(Tr.class)) {
                            j.set(((Tr) replace).copy(Tr.class));
                        } else {
                            throw new TagTypeUnmatchException(Tr.class,
                                    replace.getClass());
                        }
                    } else {
                        execute(tr, tagType, clazz, replace);
                    }
                }
            }
            break;
        case TBODY:
            Tbody tbody = (Tbody) target;
            if (match(tbody.getClass(), tbody.getCssClass(), tagType, clazz)) {
                return;
            }
            if (tbody.isSetTr()) {
                for (ListIterator<Tr> j = tbody.getTr().listIterator(); j
                        .hasNext();) {
                    Tr tr = j.next();
                    if (match(Tr.class, tr.getCssClass(), tagType, clazz)) {
                        if (replace.getClass().equals(Tr.class)) {
                            j.set(((Tr) replace).copy(Tr.class));
                        } else {
                            throw new TagTypeUnmatchException(Tr.class,
                                    replace.getClass());
                        }
                    } else {
                        execute(tr, tagType, clazz, replace);
                    }
                }
            }
            break;
        case TD:
            Td td = (Td) target;
            if (match(td.getClass(), td.getCssClass(), tagType, clazz)) {
                return;
            }
            if (td.isSetContent()) {
                replaceDescendantsWithinObjectList(td.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case TEXTAREA:
            Textarea textarea = (Textarea) target;
            if (match(textarea.getClass(), textarea.getCssClass(), tagType,
                    clazz)) {
                return;
            }
            break;
        case TFOOT:
            Tfoot tfoot = (Tfoot) target;
            if (match(tfoot.getClass(), tfoot.getCssClass(), tagType, clazz)) {
                return;
            }
            if (tfoot.isSetTr()) {
                for (ListIterator<Tr> j = tfoot.getTr().listIterator(); j
                        .hasNext();) {
                    Tr tr = j.next();
                    if (match(Tr.class, tr.getCssClass(), tagType, clazz)) {
                        if (replace.getClass().equals(Tr.class)) {
                            j.set(((Tr) replace).copy(Tr.class));
                        } else {
                            throw new TagTypeUnmatchException(Tr.class,
                                    replace.getClass());
                        }
                    } else {
                        execute(tr, tagType, clazz, replace);
                    }
                }
            }
            break;
        case TH:
            Th th = (Th) target;
            if (match(th.getClass(), th.getCssClass(), tagType, clazz)) {
                return;
            }
            if (th.isSetContent()) {
                replaceDescendantsWithinObjectList(th.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case THEAD:
            Thead thead = (Thead) target;
            if (match(thead.getClass(), thead.getCssClass(), tagType, clazz)) {
                return;
            }
            if (thead.isSetTr()) {
                for (ListIterator<Tr> j = thead.getTr().listIterator(); j
                        .hasNext();) {
                    Tr tr = j.next();
                    if (match(Tr.class, tr.getCssClass(), tagType, clazz)) {
                        if (replace.getClass().equals(Tr.class)) {
                            j.set(((Tr) replace).copy(Tr.class));
                        } else {
                            throw new TagTypeUnmatchException(Tr.class,
                                    replace.getClass());
                        }
                    } else {
                        execute(tr, tagType, clazz, replace);
                    }
                }
            }
            break;
        case TITLE:
            Title title = (Title) target;
            if (match(title.getClass(), title.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element.
            break;
        case TR:
            Tr tr = (Tr) target;
            if (match(tr.getClass(), tr.getCssClass(), tagType, clazz)) {
                return;
            }
            if (tr.isSetThOrTd()) {
                for (ListIterator<Flow> j = tr.getThOrTd().listIterator(); j
                        .hasNext();) {
                    Flow flow = j.next();
                    if (match(flow.getClass(), flow.getCssClass(), tagType,
                            clazz)) {
                        if (replace.getClass().equals(Th.class)) {

                            j.set(((Th) replace).copy(Th.class));
                        } else if (replace.getClass().equals(Td.class)) {

                            j.set(((Td) replace).copy(Td.class));
                        } else {
                            throw new TagTypeUnmatchException(
                                    "th or td expected but replace is "
                                            + replace.getClass());
                        }
                    } else {
                        execute(flow, tagType, clazz, replace);
                    }
                }
            }
            break;
        case TT:
            Tt tt = (Tt) target;
            if (match(tt.getClass(), tt.getCssClass(), tagType, clazz)) {
                return;
            }
            if (tt.isSetContent()) {
                replaceDescendantsWithinObjectList(tt.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case U:
            U u = (U) target;
            if (match(u.getClass(), u.getCssClass(), tagType, clazz)) {
                return;
            }
            if (u.isSetContent()) {
                replaceDescendantsWithinObjectList(u.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case UL:
            Ul ul = (Ul) target;
            if (match(ul.getClass(), ul.getCssClass(), tagType, clazz)) {
                return;
            }
            if (ul.isSetLi()) {
                for (ListIterator<Li> j = ul.getLi().listIterator(); j
                        .hasNext();) {
                    Li li2 = j.next();
                    if (match(li2.getClass(), li2.getCssClass(), tagType, clazz)) {
                        if (replace.getClass().equals(Li.class)) {
                            j.set(((Li) replace).copy(Li.class));
                        } else {
                            throw new TagTypeUnmatchException(Li.class,
                                    replace.getClass());
                        }
                    } else {
                        execute(li2, tagType, clazz, replace);
                    }
                }
            }
            break;
        case VAR:
            Var var = (Var) target;
            if (match(var.getClass(), var.getCssClass(), tagType, clazz)) {
                return;
            }
            if (var.isSetContent()) {
                replaceDescendantsWithinObjectList(var.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case ARTICLE:
            Article article = (Article)target;
            if (match(article.getClass(), article.getCssClass(), tagType, clazz)) {
                return;
            }
            if (article.isSetContent()) {
                replaceDescendantsWithinObjectList(article.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case ASIDE:
            Aside aside = (Aside)target;
            if (match(aside.getClass(), aside.getCssClass(), tagType, clazz)) {
                return;
            }
            if (aside.isSetContent()) {
                replaceDescendantsWithinObjectList(aside.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case AUDIO:
            Audio audio = (Audio)target;
            if (match(audio.getClass(), audio.getCssClass(), tagType, clazz)) {
                return;
            }
            if (audio.isSetContent()) {
                replaceDescendantsWithinObjectList(audio.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case BDI:
            Bdi bdi =(Bdi) target;
            if (match(bdi.getClass(), bdi.getCssClass(), tagType, clazz)) {
                return;
            }
            if (bdi.isSetContent()) {
                replaceDescendantsWithinObjectList(bdi.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case CANVAS:
            Canvas canvas = (Canvas)target;
            if (match(canvas.getClass(), canvas.getCssClass(), tagType, clazz)) {
                return;
            }
            if (canvas.isSetContent()) {
                replaceDescendantsWithinObjectList(canvas.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case COMMAND:
            Command command = (Command)target;
            if (match(command.getClass(), command.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case DATALIST:
            Datalist datalist = (Datalist)target;
            if (match(datalist.getClass(), datalist.getCssClass(), tagType, clazz)) {
                return;
            }
            if (datalist.isSetContent()) {
                replaceDescendantsWithinObjectList(datalist.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case DETAILS:
            Details details = (Details)target;
            if (match(details.getClass(), details.getCssClass(), tagType, clazz)) {
                return;
            }
            if (details.isSetContent()) {
                replaceDescendantsWithinObjectList(details.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case EMBED:
            Embed embed = (Embed)target;
            if (match(embed.getClass(), embed.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case FIGCAPTION:
            Figcaption figcaption = (Figcaption)target;
            if (match(figcaption.getClass(), figcaption.getCssClass(), tagType, clazz)) {
                return;
            }
            if (figcaption.isSetContent()) {
                replaceDescendantsWithinObjectList(figcaption.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case FIGURE:
            Figure figure = (Figure)target;
            if (match(figure.getClass(), figure.getCssClass(), tagType, clazz)) {
                return;
            }
            if (figure.isSetContent()) {
                replaceDescendantsWithinObjectList(figure.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case FOOTER:
            Footer footer = (Footer)target;
            if (match(footer.getClass(), footer.getCssClass(), tagType, clazz)) {
                return;
            }
            if (footer.isSetContent()) {
                replaceDescendantsWithinObjectList(footer.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case HEADER:
            Header header = (Header)target;
            if (match(header.getClass(), header.getCssClass(), tagType, clazz)) {
                return;
            }
            if (header.isSetContent()) {
                replaceDescendantsWithinObjectList(header.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case KEYGEN:
            Keygen keygen = (Keygen)target;
            if (match(keygen.getClass(), keygen.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case MARK:
            Mark mark = (Mark)target;
            if (match(mark.getClass(), mark.getCssClass(), tagType, clazz)) {
                return;
            }
            if (mark.isSetContent()) {
                replaceDescendantsWithinObjectList(mark.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case METER:
            Meter meter =(Meter)target;
            if (match(meter.getClass(), meter.getCssClass(), tagType, clazz)) {
                return;
            }
            if (meter.isSetContent()) {
                replaceDescendantsWithinObjectList(meter.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case NAV:
            Nav nav = (Nav)target;
            if (match(nav.getClass(), nav.getCssClass(), tagType, clazz)) {
                return;
            }
            if (nav.isSetContent()) {
                replaceDescendantsWithinObjectList(nav.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case OUTPUT:
            Output output = (Output)target;
            if (match(output.getClass(), output.getCssClass(), tagType, clazz)) {
                return;
            }
            if (output.isSetContent()) {
                replaceDescendantsWithinObjectList(output.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case PROGRESS:
            Progress progress = (Progress)target;
            if (match(progress.getClass(), progress.getCssClass(), tagType, clazz)) {
                return;
            }
            if (progress.isSetContent()) {
                replaceDescendantsWithinObjectList(progress.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case RP:
            Rp rp = (Rp)target;
            if (match(rp.getClass(), rp.getCssClass(), tagType, clazz)) {
                return;
            }
            if (rp.isSetContent()) {
                replaceDescendantsWithinObjectList(rp.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case RT:
            Rt rt = (Rt)target;
            if (match(rt.getClass(), rt.getCssClass(), tagType, clazz)) {
                return;
            }
            if (rt.isSetContent()) {
                replaceDescendantsWithinObjectList(rt.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case RUBY:
            Ruby ruby = (Ruby)target;
            if (match(ruby.getClass(), ruby.getCssClass(), tagType, clazz)) {
                return;
            }
            if (ruby.isSetContent()) {
                replaceDescendantsWithinObjectList(ruby.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case SECTION:
            Section section = (Section)target;
            if (match(section.getClass(), section.getCssClass(), tagType, clazz)) {
                return;
            }
            if (section.isSetContent()) {
                replaceDescendantsWithinObjectList(section.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case SOURCE:
            Source source = (Source)target;
            if (match(source.getClass(), source.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case SUMMARY:
            Summary summary = (Summary)target;
            if (match(summary.getClass(), summary.getCssClass(), tagType, clazz)) {
                return;
            }
            if (summary.isSetContent()) {
                replaceDescendantsWithinObjectList(summary.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case TIME:
            Time time = (Time)target;
            if (match(time.getClass(), time.getCssClass(), tagType, clazz)) {
                return;
            }
            if (time.isSetContent()) {
                replaceDescendantsWithinObjectList(time.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case TRACK:
            Track track = (Track)target;
            if (match(track.getClass(), track.getCssClass(), tagType, clazz)) {
                return;
            }
            // empty element
            break;
        case VIDEO:
            Video video = (Video)target;
            if (match(video.getClass(), video.getCssClass(), tagType, clazz)) {
                return;
            }
            if (video.isSetContent()) {
                replaceDescendantsWithinObjectList(video.getContent(), tagType,
                        clazz, replace);
            }
            break;
        case WBR:
            Wbr wbr = (Wbr)target;
            if (match(wbr.getClass(), wbr.getCssClass(), tagType, clazz)) {
                return;
            }
            break;
        }

    }

    private static boolean match(Class<?> targetType,
            List<String> targetCssClass, Class<?> tagType, String clazz) {
        if (tagType == null && clazz == null) {
            return false;
        }
        if (targetCssClass == null) {
            targetCssClass = new ArrayList<String>();
        }
        if (tagType != null && clazz == null) {
            if (targetType.equals(tagType)) {
                return true;
            }
        }
        if (tagType == null && clazz != null) {
            if (targetCssClass.contains(clazz)) {
                return true;
            }
        }
        if (tagType != null && clazz != null) {
            if (targetType.equals(tagType) && targetCssClass.contains(clazz)) {
                return true;
            }
        }
        return false;
    }

}

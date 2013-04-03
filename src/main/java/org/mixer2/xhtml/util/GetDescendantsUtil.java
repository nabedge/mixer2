package org.mixer2.xhtml.util;

import java.util.ArrayList;
import java.util.List;

import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;

/**
 *
 * @see org.mixer2.xhtml.AbstractJaxb#getDescendants(Class)
 * @see org.mixer2.xhtml.AbstractJaxb#getDescendants(String)
 * @see org.mixer2.xhtml.AbstractJaxb#getDescendants(String, Class)
 * @author watanabe
 */
public class GetDescendantsUtil {

    /**
     * タグとclass指定で子孫要素を返す
     *
     * @param <T>
     *            tag class type. (i.e. Div.class, Span.class...)
     * @param target
     *            objects for scan
     * @param resultList
     *            usually, pass new ArrayList
     * @param clazz
     *            class property of tag
     * @param tagType
     *            tag class
     * @return
     */
    public static <T extends AbstractJaxb> List<T> getDescendants(T target,
            List<T> resultList, String clazz, Class<T> tagType) {
        return execute(target, resultList, tagType, clazz);
    }

    /**
     * タグ指定で子孫要素を返す
     *
     * @param <T>
     *            tag class type. (i.e. Div.class, Span.class...)
     * @param target
     *            objects for scan
     * @param resultList
     *            usually, pass new ArrayList
     * @param tagType
     *            tag class
     * @return
     */
    public static <T extends AbstractJaxb> List<T> getDescendants(T target,
            List<T> resultList, Class<T> tagType) {
        return execute(target, resultList, tagType, null);
    }

    /**
     * class属性の指定で子孫要素を返す
     *
     * @param target
     *            objects for scan
     * @param resultList
     *            usually, pass new ArrayList
     * @param clazz
     *            class property of tag
     * @return
     */
    public static <T extends AbstractJaxb> List<T> getDescendants(T target,
            List<T> resultList, String clazz) {
        return execute(target, resultList, null, clazz);
    }

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> List<T> execute(
            java.lang.Object target, List<T> resultList, Class<T> tagType,
            String clazz) {

        TagEnum tagEnum;

        if (target instanceof AbstractJaxb) {
            tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                    .toUpperCase());
        } else {
            return resultList;
        }

        switch (tagEnum) {
        case A:
            A a = (A) target;
            if (match(a.getClass(), a.getCssClass(), tagType, clazz)) {
                resultList.add((T) a);
            }
            for (java.lang.Object obj : a.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case ABBR:
            Abbr abbr = (Abbr) target;
            if (match(abbr.getClass(), abbr.getCssClass(), tagType, clazz)) {
                resultList.add((T) abbr);
            }
            for (java.lang.Object obj : abbr.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            if (match(acronym.getClass(), acronym.getCssClass(), tagType, clazz)) {
                resultList.add((T) acronym);
            }
            for (java.lang.Object obj : acronym.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case ADDRESS:
            Address address = (Address) target;
            if (match(address.getClass(), address.getCssClass(), tagType, clazz)) {
                resultList.add((T) address);
            }
            for (java.lang.Object obj : address.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case APPLET:
            Applet applet = (Applet) target;
            if (match(applet.getClass(), applet.getCssClass(), tagType, clazz)) {
                resultList.add((T) applet);
            }
            for (java.lang.Object obj : applet.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case AREA:
            Area area = (Area) target;
            if (match(area.getClass(), area.getCssClass(), tagType, clazz)) {
                resultList.add((T) area);
            }
            // empty element
            break;
        case B:
            B b = (B) target;
            if (match(b.getClass(), b.getCssClass(), tagType, clazz)) {
                resultList.add((T) b);
            }
            for (java.lang.Object obj : b.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case BASE:
            Base base = (Base) target;
            if (match(base.getClass(), base.getCssClass(), tagType, clazz)) {
                resultList.add((T) base);
            }
            // empty element.
            break;
        case BASEFONT:
            Basefont basefont = (Basefont) target;
            if (match(basefont.getClass(), basefont.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) basefont);
            }
            // empty element.
            break;
        case BDO:
            Bdo bdo = (Bdo) target;
            if (match(bdo.getClass(), bdo.getCssClass(), tagType, clazz)) {
                resultList.add((T) bdo);
            }
            for (java.lang.Object obj : bdo.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case BIG:
            Big big = (Big) target;
            if (match(big.getClass(), big.getCssClass(), tagType, clazz)) {
                resultList.add((T) big);
            }
            for (java.lang.Object obj : big.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case BLOCKQUOTE:
            Blockquote blockquote = (Blockquote) target;
            if (match(blockquote.getClass(), blockquote.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) blockquote);
            }
            for (java.lang.Object obj : blockquote.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case BODY:
            Body body = (Body) target;
            if (match(body.getClass(), body.getCssClass(), tagType, clazz)) {
                resultList.add((T) body);
            }
            for (java.lang.Object obj : body.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case BR:
            Br br = (Br) target;
            if (match(br.getClass(), br.getCssClass(), tagType, clazz)) {
                resultList.add((T) br);
            }
            // empty element
            break;
        case BUTTON:
            Button button = (Button) target;
            if (match(button.getClass(), button.getCssClass(), tagType, clazz)) {
                resultList.add((T) button);
            }
            for (java.lang.Object obj : button.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case CAPTION:
            Caption caption = (Caption) target;
            if (match(caption.getClass(), caption.getCssClass(), tagType, clazz)) {
                resultList.add((T) caption);
            }
            for (java.lang.Object obj : caption.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case CENTER:
            Center center = (Center) target;
            if (match(center.getClass(), center.getCssClass(), tagType, clazz)) {
                resultList.add((T) center);
            }
            for (java.lang.Object obj : center.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case CITE:
            Cite cite = (Cite) target;
            if (match(cite.getClass(), cite.getCssClass(), tagType, clazz)) {
                resultList.add((T) cite);
            }
            for (java.lang.Object obj : cite.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case CODE:
            Code code = (Code) target;
            if (match(code.getClass(), code.getCssClass(), tagType, clazz)) {
                resultList.add((T) code);
            }
            for (java.lang.Object obj : code.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case COL:
            Col col = (Col) target;
            if (match(col.getClass(), col.getCssClass(), tagType, clazz)) {
                resultList.add((T) col);
            }
            // empty element
            break;
        case COLGROUP:
            Colgroup colgroup = (Colgroup) target;
            if (match(colgroup.getClass(), colgroup.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) colgroup);
            }
            if (colgroup.isSetCol()) {
                for (Col col1 : colgroup.getCol()) {
                    resultList = execute(col1, resultList, tagType, clazz);
                }
            }
            break;
        case DD:
            Dd dd = (Dd) target;
            if (match(dd.getClass(), dd.getCssClass(), tagType, clazz)) {
                resultList.add((T) dd);
            }
            for (java.lang.Object obj : dd.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case DEL:
            Del del = (Del) target;
            if (match(del.getClass(), del.getCssClass(), tagType, clazz)) {
                resultList.add((T) del);
            }
            for (java.lang.Object obj : del.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case DFN:
            Dfn dfn = (Dfn) target;
            if (match(dfn.getClass(), dfn.getCssClass(), tagType, clazz)) {
                resultList.add((T) dfn);
            }
            for (java.lang.Object obj : dfn.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case DIR:
            Dir dir = (Dir) target;
            if (match(dir.getClass(), dir.getCssClass(), tagType, clazz)) {
                resultList.add((T) dir);
            }
            if (dir.isSetLi()) {
                for (Li li : dir.getLi()) {
                    resultList = execute(li, resultList, tagType, clazz);
                }
            }
            break;
        case DIV:
            Div div = (Div) target;
            if (match(div.getClass(), div.getCssClass(), tagType, clazz)) {
                resultList.add((T) div);
            }
            for (java.lang.Object obj : div.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case DL:
            Dl dl = (Dl) target;
            if (match(dl.getClass(), dl.getCssClass(), tagType, clazz)) {
                resultList.add((T) dl);
            }
            if (dl.isSetDtOrDd()) {
                for (java.lang.Object obj : dl.getDtOrDd()) {
                    resultList = execute(obj, resultList, tagType, clazz);
                }
            }
            break;
        case DT:
            Dt dt = (Dt) target;
            if (match(dt.getClass(), dt.getCssClass(), tagType, clazz)) {
                resultList.add((T) dt);
            }
            for (java.lang.Object obj : dt.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case EM:
            Em em = (Em) target;
            if (match(em.getClass(), em.getCssClass(), tagType, clazz)) {
                resultList.add((T) em);
            }
            for (java.lang.Object obj : em.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case FIELDSET:
            Fieldset fieldset = (Fieldset) target;
            if (match(fieldset.getClass(), fieldset.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) fieldset);
            }
            for (java.lang.Object obj : fieldset.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case FONT:
            Font font = (Font) target;
            if (match(font.getClass(), font.getCssClass(), tagType, clazz)) {
                resultList.add((T) font);
            }
            for (java.lang.Object obj : font.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case FORM:
            Form form = (Form) target;
            if (match(form.getClass(), form.getCssClass(), tagType, clazz)) {
                resultList.add((T) form);
            }
            for (java.lang.Object obj : form.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case H1:
            H1 h1 = (H1) target;
            if (match(h1.getClass(), h1.getCssClass(), tagType, clazz)) {
                resultList.add((T) h1);
            }
            for (java.lang.Object obj : h1.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case H2:
            H2 h2 = (H2) target;
            if (match(h2.getClass(), h2.getCssClass(), tagType, clazz)) {
                resultList.add((T) h2);
            }
            for (java.lang.Object obj : h2.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case H3:
            H3 h3 = (H3) target;
            if (match(h3.getClass(), h3.getCssClass(), tagType, clazz)) {
                resultList.add((T) h3);
            }
            for (java.lang.Object obj : h3.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case H4:
            H4 h4 = (H4) target;
            if (match(h4.getClass(), h4.getCssClass(), tagType, clazz)) {
                resultList.add((T) h4);
            }
            for (java.lang.Object obj : h4.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case H5:
            H5 h5 = (H5) target;
            if (match(h5.getClass(), h5.getCssClass(), tagType, clazz)) {
                resultList.add((T) h5);
            }
            for (java.lang.Object obj : h5.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case H6:
            H6 h6 = (H6) target;
            if (match(h6.getClass(), h6.getCssClass(), tagType, clazz)) {
                resultList.add((T) h6);
            }
            for (java.lang.Object obj : h6.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case HGROUP:
            Hgroup hgroup = (Hgroup)target;
            if (match(hgroup.getClass(), hgroup.getCssClass(), tagType, clazz)) {
                resultList.add((T) hgroup);
            }
            for (java.lang.Object obj : hgroup.getH1OrH2OrH3()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case HEAD:
            Head head = (Head) target;
            if (match(head.getClass(), head.getCssClass(), tagType, clazz)) {
                resultList.add((T) head);
            }
            for (java.lang.Object obj : head.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case HR:
            Hr hr = (Hr) target;
            if (match(hr.getClass(), hr.getCssClass(), tagType, clazz)) {
                resultList.add((T) hr);
            }
            // empty element.
            break;
        case HTML:
            Html html = (Html) target;
            if (html.isSetHead()) {
                resultList = execute(html.getHead(), resultList, tagType, clazz);
            }
            if (html.isSetBody()) {
                resultList = execute(html.getBody(), resultList, tagType, clazz);
            }
            break;
        case I:
            I i = (I) target;
            if (match(i.getClass(), i.getCssClass(), tagType, clazz)) {
                resultList.add((T) i);
            }
            for (java.lang.Object obj : i.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case IFRAME:
            Iframe iframe = (Iframe) target;
            if (match(iframe.getClass(), iframe.getCssClass(), tagType, clazz)) {
                resultList.add((T) iframe);
            }
            for (java.lang.Object obj : iframe.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case IMG:
            Img img = (Img) target;
            if (match(img.getClass(), img.getCssClass(), tagType, clazz)) {
                resultList.add((T) img);
            }
            // empty element
            break;
        case INPUT:
            Input input = (Input) target;
            if (match(input.getClass(), input.getCssClass(), tagType, clazz)) {
                resultList.add((T) input);
            }
            // empty element
            break;
        case INS:
            Ins ins = (Ins) target;
            if (match(ins.getClass(), ins.getCssClass(), tagType, clazz)) {
                resultList.add((T) ins);
            }
            for (java.lang.Object obj : ins.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case ISINDEX:
            Isindex isindex = (Isindex) target;
            if (match(isindex.getClass(), isindex.getCssClass(), tagType, clazz)) {
                resultList.add((T) isindex);
            }
            // empty element
            break;
        case KBD:
            Kbd kbd = (Kbd) target;
            if (match(kbd.getClass(), kbd.getCssClass(), tagType, clazz)) {
                resultList.add((T) kbd);
            }
            for (java.lang.Object obj : kbd.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case LABEL:
            Label label = (Label) target;
            if (match(label.getClass(), label.getCssClass(), tagType, clazz)) {
                resultList.add((T) label);
            }
            for (java.lang.Object obj : label.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case LEGEND:
            Legend legend = (Legend) target;
            if (match(legend.getClass(), legend.getCssClass(), tagType, clazz)) {
                resultList.add((T) legend);
            }
            for (java.lang.Object obj : legend.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case LI:
            Li li = (Li) target;
            if (match(li.getClass(), li.getCssClass(), tagType, clazz)) {
                resultList.add((T) li);
            }
            for (java.lang.Object obj : li.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case LINK:
            Link link = (Link) target;
            if (match(link.getClass(), link.getCssClass(), tagType, clazz)) {
                resultList.add((T) link);
            }
            // empty element.
            break;
        case MAP:
            Map map = (Map) target;
            if (match(map.getClass(), map.getCssClass(), tagType, clazz)) {
                resultList.add((T) map);
            }
            if (map.isSetArea()) {
                for (java.lang.Object obj : map.getArea()) {
                    resultList = execute(obj, resultList, tagType, clazz);
                }
            }
            if (map.isSetPOrH1OrH2()) {
                for (java.lang.Object obj : map.getPOrH1OrH2()) {
                    resultList = execute(obj, resultList, tagType, clazz);
                }
            }
            break;
        case MENU:
            Menu menu = (Menu) target;
            if (match(menu.getClass(), menu.getCssClass(), tagType, clazz)) {
                resultList.add((T) menu);
            }
            for (java.lang.Object obj : menu.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case META:
            Meta meta = (Meta) target;
            if (match(meta.getClass(), meta.getCssClass(), tagType, clazz)) {
                resultList.add((T) meta);
            }
            // empty element.
            break;
        case NOFRAMES:
            Noframes noframes = (Noframes) target;
            if (match(noframes.getClass(), noframes.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) noframes);
            }
            for (java.lang.Object obj : noframes.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case NOSCRIPT:
            Noscript noscript = (Noscript) target;
            if (match(noscript.getClass(), noscript.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) noscript);
            }
            for (java.lang.Object obj : noscript.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
            if (match(object.getClass(), object.getCssClass(), tagType, clazz)) {
                resultList.add((T) object);
            }
            for (java.lang.Object obj : object.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case OL:
            Ol ol = (Ol) target;
            if (match(ol.getClass(), ol.getCssClass(), tagType, clazz)) {
                resultList.add((T) ol);
            }
            if (ol.isSetLi()) {
                for (Li li1 : ol.getLi()) {
                    resultList = execute(li1, resultList, tagType, clazz);
                }
            }
            break;
        case OPTGROUP:
            Optgroup optgroup = (Optgroup) target;
            if (match(optgroup.getClass(), optgroup.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) optgroup);
            }
            if (optgroup.isSetOption()) {
                for (Option option : optgroup.getOption()) {
                    resultList = execute(option, resultList, tagType, clazz);
                }
            }
            break;
        case OPTION:
            Option option = (Option) target;
            if (match(option.getClass(), option.getCssClass(), tagType, clazz)) {
                resultList.add((T) option);
            }
            // empty element
            break;
        case P:
            P p = (P) target;
            if (match(p.getClass(), p.getCssClass(), tagType, clazz)) {
                resultList.add((T) p);
            }
            for (java.lang.Object obj : p.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case PARAM:
            Param param = (Param) target;
            if (match(param.getClass(), param.getCssClass(), tagType, clazz)) {
                resultList.add((T) param);
            }
            // empty element
            break;
        case PRE:
            Pre pre = (Pre) target;
            if (match(pre.getClass(), pre.getCssClass(), tagType, clazz)) {
                resultList.add((T) pre);
            }
            for (java.lang.Object obj : pre.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case Q:
            Q q = (Q) target;
            if (match(q.getClass(), q.getCssClass(), tagType, clazz)) {
                resultList.add((T) q);
            }
            for (java.lang.Object obj : q.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case S:
            S s = (S) target;
            if (match(s.getClass(), s.getCssClass(), tagType, clazz)) {
                resultList.add((T) s);
            }
            for (java.lang.Object obj : s.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case SAMP:
            Samp samp = (Samp) target;
            if (match(samp.getClass(), samp.getCssClass(), tagType, clazz)) {
                resultList.add((T) samp);
            }
            for (java.lang.Object obj : samp.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case SCRIPT:
            Script script = (Script) target;
            if (match(script.getClass(), script.getCssClass(), tagType, clazz)) {
                resultList.add((T) script);
            }
            // empty element.
            break;
        case SELECT:
            Select select = (Select) target;
            if (match(select.getClass(), select.getCssClass(), tagType, clazz)) {
                resultList.add((T) select);
            }
            if (select.isSetOptgroupOrOption()) {
                for (java.lang.Object obj : select.getOptgroupOrOption()) {
                    resultList = execute(obj, resultList, tagType, clazz);
                }
            }
            break;
        case SMALL:
            Small small = (Small) target;
            if (match(small.getClass(), small.getCssClass(), tagType, clazz)) {
                resultList.add((T) small);
            }
            for (java.lang.Object obj : small.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case SPAN:
            Span span = (Span) target;
            if (match(span.getClass(), span.getCssClass(), tagType, clazz)) {
                resultList.add((T) span);
            }
            for (java.lang.Object obj : span.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case STRIKE:
            Strike strike = (Strike) target;
            if (match(strike.getClass(), strike.getCssClass(), tagType, clazz)) {
                resultList.add((T) strike);
            }
            for (java.lang.Object obj : strike.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case STRONG:
            Strong strong = (Strong) target;
            if (match(strong.getClass(), strong.getCssClass(), tagType, clazz)) {
                resultList.add((T) strong);
            }
            for (java.lang.Object obj : strong.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case STYLE:
            Style style = (Style) target;
            if (match(style.getClass(), style.getCssClass(), tagType, clazz)) {
                resultList.add((T) style);
            }
            break;
        case SUB:
            Sub sub = (Sub) target;
            if (match(sub.getClass(), sub.getCssClass(), tagType, clazz)) {
                resultList.add((T) sub);
            }
            for (java.lang.Object obj : sub.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case SUP:
            Sup sup = (Sup) target;
            if (match(sup.getClass(), sup.getCssClass(), tagType, clazz)) {
                resultList.add((T) sup);
            }
            for (java.lang.Object obj : sup.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case TABLE:
            Table table = (Table) target;
            if (match(table.getClass(), table.getCssClass(), tagType, clazz)) {
                resultList.add((T) table);
            }
            if (table.isSetCaption()) {
                resultList = execute(table.getCaption(), resultList, tagType,
                        clazz);
            }
            if (table.isSetCol()) {
                for (Col col1 : table.getCol()) {
                    resultList = execute(col1, resultList, tagType, clazz);
                }
            }
            if (table.isSetColgroup()) {
                for (Colgroup colgroup1 : table.getColgroup()) {
                    resultList = execute(colgroup1, resultList, tagType, clazz);
                }
            }
            if (table.isSetTbody()) {
                for (Tbody tmpTbody : table.getTbody()) {
                    resultList = execute(tmpTbody, resultList, tagType, clazz);
                }
            }
            if (table.isSetThead()) {
                resultList = execute(table.getThead(), resultList, tagType,
                        clazz);
            }
            if (table.isSetTfoot()) {
                resultList = execute(table.getTfoot(), resultList, tagType,
                        clazz);
            }
            if (table.isSetTr()) {
                for (Tr tr : table.getTr()) {
                    resultList = execute(tr, resultList, tagType, clazz);
                }
            }
            break;
        case TBODY:
            Tbody tbody = (Tbody) target;
            if (match(tbody.getClass(), tbody.getCssClass(), tagType, clazz)) {
                resultList.add((T) tbody);
            }
            if (tbody.isSetTr()) {
                for (Tr tr : tbody.getTr()) {
                    resultList = execute(tr, resultList, tagType, clazz);
                }
            }
            break;
        case TD:
            Td td = (Td) target;
            if (match(td.getClass(), td.getCssClass(), tagType, clazz)) {
                resultList.add((T) td);
            }
            for (java.lang.Object obj : td.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case TEXTAREA:
            Textarea textarea = (Textarea) target;
            if (match(textarea.getClass(), textarea.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) textarea);
            }
            break;
        case TFOOT:
            Tfoot tfoot = (Tfoot) target;
            if (match(tfoot.getClass(), tfoot.getCssClass(), tagType, clazz)) {
                resultList.add((T) tfoot);
            }
            if (tfoot.isSetTr()) {
                for (Tr tr : tfoot.getTr()) {
                    resultList = execute(tr, resultList, tagType, clazz);
                }
            }
            break;
        case TH:
            Th th = (Th) target;
            if (match(th.getClass(), th.getCssClass(), tagType, clazz)) {
                resultList.add((T) th);
            }
            for (java.lang.Object obj : th.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case THEAD:
            Thead thead = (Thead) target;
            if (match(thead.getClass(), thead.getCssClass(), tagType, clazz)) {
                resultList.add((T) thead);
            }
            if (thead.isSetTr()) {
                for (Tr tr : thead.getTr()) {
                    resultList = execute(tr, resultList, tagType, clazz);
                }
            }
            break;
        case TITLE:
            Title title = (Title) target;
            if (match(title.getClass(), title.getCssClass(), tagType, clazz)) {
                resultList.add((T) title);
            }
            // empty element.
            break;
        case TR:
            Tr tr = (Tr) target;
            if (match(tr.getClass(), tr.getCssClass(), tagType, clazz)) {
                resultList.add((T) tr);
            }
            if (tr.isSetThOrTd()) {
                for (java.lang.Object obj : tr.getThOrTd()) {
                    resultList = execute(obj, resultList, tagType, clazz);
                }
            }
            break;
        case TT:
            Tt tt = (Tt) target;
            if (match(tt.getClass(), tt.getCssClass(), tagType, clazz)) {
                resultList.add((T) tt);
            }
            for (java.lang.Object obj : tt.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case U:
            U u = (U) target;
            if (match(u.getClass(), u.getCssClass(), tagType, clazz)) {
                resultList.add((T) u);
            }
            for (java.lang.Object obj : u.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case UL:
            Ul ul = (Ul) target;
            if (match(ul.getClass(), ul.getCssClass(), tagType, clazz)) {
                resultList.add((T) ul);
            }
            if (ul.isSetLi()) {
                for (Li li1 : ul.getLi()) {
                    resultList = execute(li1, resultList, tagType, clazz);
                }
            }
            break;
        case VAR:
            Var var = (Var) target;
            if (match(var.getClass(), var.getCssClass(), tagType, clazz)) {
                resultList.add((T) var);
            }
            for (java.lang.Object obj : var.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case ARTICLE:
            Article article = (Article) target;
            if (match(article.getClass(), article.getCssClass(), tagType, clazz)) {
                resultList.add((T) article);
            }
            for (java.lang.Object obj : article.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case ASIDE:
            Aside aside = (Aside) target;
            if (match(aside.getClass(), aside.getCssClass(), tagType, clazz)) {
                resultList.add((T) aside);
            }
            for (java.lang.Object obj : aside.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case AUDIO:
            Audio audio = (Audio) target;
            if (match(audio.getClass(), audio.getCssClass(), tagType, clazz)) {
                resultList.add((T) audio);
            }
            for (java.lang.Object obj : audio.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case BDI:
            Bdi bdi = (Bdi) target;
            if (match(bdi.getClass(), bdi.getCssClass(), tagType, clazz)) {
                resultList.add((T) bdi);
            }
            for (java.lang.Object obj : bdi.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case CANVAS:
            Canvas canvas = (Canvas) target;
            if (match(canvas.getClass(), canvas.getCssClass(), tagType, clazz)) {
                resultList.add((T) canvas);
            }
            for (java.lang.Object obj : canvas.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case COMMAND:
            Command command = (Command) target;
            if (match(command.getClass(), command.getCssClass(), tagType, clazz)) {
                resultList.add((T) command);
            }
            // empty tag
            break;
        case DATALIST:
            Datalist datalist = (Datalist) target;
            if (match(datalist.getClass(), datalist.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) datalist);
            }
            for (java.lang.Object obj : datalist.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case DETAILS:
            Details details = (Details) target;
            if (match(details.getClass(), details.getCssClass(), tagType, clazz)) {
                resultList.add((T) details);
            }
            for (java.lang.Object obj : details.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case EMBED:
            Embed embed = (Embed) target;
            if (match(embed.getClass(), embed.getCssClass(), tagType, clazz)) {
                resultList.add((T) embed);
            }
            // empty tag
            break;
        case FIGCAPTION:
            Figcaption figcaption = (Figcaption) target;
            if (match(figcaption.getClass(), figcaption.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) figcaption);
            }
            for (java.lang.Object obj : figcaption.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case FIGURE:
            Figure figure = (Figure) target;
            if (match(figure.getClass(), figure.getCssClass(), tagType, clazz)) {
                resultList.add((T) figure);
            }
            for (java.lang.Object obj : figure.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case FOOTER:
            Footer footer = (Footer) target;
            if (match(footer.getClass(), footer.getCssClass(), tagType, clazz)) {
                resultList.add((T) footer);
            }
            for (java.lang.Object obj : footer.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case HEADER:
            Header header = (Header) target;
            if (match(header.getClass(), header.getCssClass(), tagType, clazz)) {
                resultList.add((T) header);
            }
            for (java.lang.Object obj : header.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case KEYGEN:
            Keygen keygen = (Keygen) target;
            if (match(keygen.getClass(), keygen.getCssClass(), tagType, clazz)) {
                resultList.add((T) keygen);
            }
            // empty element
            break;
        case MARK:
            Mark mark = (Mark) target;
            if (match(mark.getClass(), mark.getCssClass(), tagType, clazz)) {
                resultList.add((T) mark);
            }
            for (java.lang.Object obj : mark.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case METER:
            Meter meter = (Meter) target;
            if (match(meter.getClass(), meter.getCssClass(), tagType, clazz)) {
                resultList.add((T) meter);
            }
            for (java.lang.Object obj : meter.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case NAV:
            Nav nav = (Nav) target;
            if (match(nav.getClass(), nav.getCssClass(), tagType, clazz)) {
                resultList.add((T) nav);
            }
            for (java.lang.Object obj : nav.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case OUTPUT:
            Output output = (Output) target;
            if (match(output.getClass(), output.getCssClass(), tagType, clazz)) {
                resultList.add((T) output);
            }
            for (java.lang.Object obj : output.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case PROGRESS:
            Progress progress = (Progress) target;
            if (match(progress.getClass(), progress.getCssClass(), tagType,
                    clazz)) {
                resultList.add((T) progress);
            }
            for (java.lang.Object obj : progress.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case RP:
            Rp rp = (Rp) target;
            if (match(rp.getClass(), rp.getCssClass(), tagType, clazz)) {
                resultList.add((T) rp);
            }
            for (java.lang.Object obj : rp.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case RT:
            Rt rt = (Rt) target;
            if (match(rt.getClass(), rt.getCssClass(), tagType, clazz)) {
                resultList.add((T) rt);
            }
            for (java.lang.Object obj : rt.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case RUBY:
            Ruby ruby = (Ruby) target;
            if (match(ruby.getClass(), ruby.getCssClass(), tagType, clazz)) {
                resultList.add((T) ruby);
            }
            for (java.lang.Object obj : ruby.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case SECTION:
            Section section = (Section) target;
            if (match(section.getClass(), section.getCssClass(), tagType, clazz)) {
                resultList.add((T) section);
            }
            for (java.lang.Object obj : section.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case SOURCE:
            Source source = (Source) target;
            if (match(source.getClass(), source.getCssClass(), tagType, clazz)) {
                resultList.add((T) source);
            }
            // empty element
            break;
        case SUMMARY:
            Summary summary = (Summary) target;
            if (match(summary.getClass(), summary.getCssClass(), tagType, clazz)) {
                resultList.add((T) summary);
            }
            for (java.lang.Object obj : summary.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case TIME:
            Time time = (Time) target;
            if (match(time.getClass(), time.getCssClass(), tagType, clazz)) {
                resultList.add((T) time);
            }
            for (java.lang.Object obj : time.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case TRACK:
            Track track = (Track) target;
            if (match(track.getClass(), track.getCssClass(), tagType, clazz)) {
                resultList.add((T) track);
            }
            // empty element
            break;
        case VIDEO:
            Video video = (Video) target;
            if (match(video.getClass(), video.getCssClass(), tagType, clazz)) {
                resultList.add((T) video);
            }
            for (java.lang.Object obj : video.getContent()) {
                resultList = execute(obj, resultList, tagType, clazz);
            }
            break;
        case WBR:
            Wbr wbr = (Wbr) target;
            if (match(wbr.getClass(), wbr.getCssClass(), tagType, clazz)) {
                resultList.add((T) wbr);
            }
            // empty element
            break;
        }
        return resultList;
    }

    private static boolean match(Class<?> targetClass,
            List<String> targetCssClass, Class<?> tagType, String cls) {
        if (tagType == null && cls == null) {
            return false;
        }
        if (targetCssClass == null) {
            targetCssClass = new ArrayList<String>();
        }
        if (tagType != null && cls == null) {
            if (targetClass.equals(tagType)) {
                return true;
            }
        }
        if (tagType == null && cls != null) {
            if (targetCssClass.contains(cls)) {
                return true;
            }
        }
        if (tagType != null && cls != null) {
            if (targetClass.equals(tagType) && targetCssClass.contains(cls)) {
                return true;
            }
        }
        return false;
    }
}

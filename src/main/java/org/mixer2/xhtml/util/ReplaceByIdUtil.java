package org.mixer2.xhtml.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 *
 * @see org.mixer2.xhtml.AbstractJaxb#replaceById(String, String)
 * @see org.mixer2.xhtml.AbstractJaxb#replaceById(String, AbstractJaxb)
 * @author watanabe
 *
 */
public class ReplaceByIdUtil {

    @SuppressWarnings("unused")
    private static Log log = LogFactory.getLog(ReplaceByIdUtil.class);

    /**
     * targetの子孫要素のうち、指定したid属性を持つ要素を置換します。 なお、replaceのディープコピーで置換されます。
     * target自身を置換することはできません。
     *
     * @param <T>
     * @param id
     * @param target
     * @param replace
     * @return
     * @throws TagTypeUnmatchException
     * @throws Exception
     */
    public static <T extends AbstractJaxb> boolean replaceById(String id,
            T target, T replace) throws TagTypeUnmatchException {
        return execute(id, target, replace.copy(replace.getClass()));
    }

    public static <T extends AbstractJaxb> boolean replaceById(String id,
            T target, String replace) throws TagTypeUnmatchException {
        return execute(id, target, replace);
    }

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> boolean replaceByIdWithinObjectList(
            String id, List<java.lang.Object> list, java.lang.Object replace)
            throws TagTypeUnmatchException {

        for (int i = 0; i < list.size(); i++) {
            java.lang.Object obj = list.get(i);
            if (obj == null || obj instanceof java.lang.String) {
                continue;
            }
            if (id.equals(((AbstractJaxb)obj).getId())) {
                list.set(i, replace);
                return true;
            } else {
                if (replace instanceof AbstractJaxb
                        && execute(id, (T) obj, (T) replace)) {
                    return true;
                }
                if (replace instanceof String
                        && execute(id, (T) obj, (String) replace)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static <T extends AbstractJaxb> boolean execute(String id,
            T target, java.lang.Object replace) throws TagTypeUnmatchException {

        TagEnum tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                .toUpperCase());

        if (id.equals(target.getId())) {
            return false;
        }

        switch (tagEnum) {
        case A:
            A a = (A) target;
            if (a.isSetContent()) {
                return replaceByIdWithinObjectList(id, a.getContent(), replace);
            }
            break;
        case ABBR:
            Abbr abbr = (Abbr) target;
            if (abbr.isSetContent()) {
                return replaceByIdWithinObjectList(id, abbr.getContent(),
                        replace);
            }
            break;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            if (acronym.isSetContent()) {
                return replaceByIdWithinObjectList(id, acronym.getContent(),
                        replace);
            }
            break;
        case ADDRESS:
            Address address = (Address) target;
            if (address.isSetContent()) {
                return replaceByIdWithinObjectList(id, address.getContent(),
                        replace);
            }
            break;
        case APPLET:
            Applet applet = (Applet) target;
            if (applet.isSetContent()) {
                return replaceByIdWithinObjectList(id, applet.getContent(),
                        replace);
            }
            break;
        case AREA:
            // area is empty element.
            break;
        case B:
            B b = (B) target;
            if (b.isSetContent()) {
                return replaceByIdWithinObjectList(id, b.getContent(), replace);
            }
            break;
        case BASE:
            // empty element.
            break;
        case BASEFONT:
            // empty element.
            break;
        case BDO:
            Bdo bdo = (Bdo) target;
            if (bdo.isSetContent()) {
                return replaceByIdWithinObjectList(id, bdo.getContent(),
                        replace);
            }
            break;
        case BIG:
            Big big = (Big) target;
            if (big.isSetContent()) {
                return replaceByIdWithinObjectList(id, big.getContent(),
                        replace);
            }
            break;
        case BLOCKQUOTE:
            Blockquote blockquote = (Blockquote) target;
            if (blockquote.isSetContent()) {
                return replaceByIdWithinObjectList(id, blockquote.getContent(),
                        replace);
            }
            break;
        case BODY:
            Body body = (Body) target;
            if (body.isSetContent()) {
                return replaceByIdWithinObjectList(id, body.getContent(),
                        replace);
            }
            break;
        case BR:
            // empty element.
            break;
        case BUTTON:
            Button button = (Button) target;
            if (button.isSetContent()) {
                return replaceByIdWithinObjectList(id, button.getContent(),
                        replace);
            }
            break;
        case CAPTION:
            Caption caption = (Caption) target;
            if (caption.isSetContent()) {
                return replaceByIdWithinObjectList(id, caption.getContent(),
                        replace);
            }
            break;
        case CENTER:
            Center center = (Center) target;
            if (center.isSetContent()) {
                return replaceByIdWithinObjectList(id, center.getContent(),
                        replace);
            }
            break;
        case CITE:
            Cite cite = (Cite) target;
            if (cite.isSetContent()) {
                return replaceByIdWithinObjectList(id, cite.getContent(),
                        replace);
            }
            break;
        case CODE:
            Code code = (Code) target;
            if (code.isSetContent()) {
                return replaceByIdWithinObjectList(id, code.getContent(),
                        replace);
            }
            break;
        case COL:
            // empty element.
            break;
        case COLGROUP:
            Colgroup colgroup = (Colgroup) target;
            if (colgroup.isSetCol()) {
                for (int i = 0; i < colgroup.getCol().size(); i++) {
                    Col col1 = colgroup.getCol().get(i);
                    if (col1.isSetId() && col1.getId().equals(col1)) {
                        if (replace instanceof Col) {
                            colgroup.getCol().set(i, (Col) replace);
                            return true;
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
            if (dd.isSetContent()) {
                return replaceByIdWithinObjectList(id, dd.getContent(), replace);
            }
            break;
        case DEL:
            Del del = (Del) target;
            if (del.isSetContent()) {
                return replaceByIdWithinObjectList(id, del.getContent(),
                        replace);
            }
            break;
        case DFN:
            Dfn dfn = (Dfn) target;
            if (dfn.isSetContent()) {
                return replaceByIdWithinObjectList(id, dfn.getContent(),
                        replace);
            }
            break;
        case DIR:
            Dir dir = (Dir) target;
            if (dir.isSetLi()) {
                for (int i = 0; i < dir.getLi().size(); i++) {
                    Li li = dir.getLi().get(i);
                    if (li.isSetId() && li.getId().equals(id)) {
                        if (replace instanceof Li) {
                            dir.getLi().set(i, (Li) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Li.class, replace
                                    .getClass());
                        }
                    } else {
                        if (execute(id, li, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case DIV:
            Div div = (Div) target;
            if (div.isSetContent()) {
                return replaceByIdWithinObjectList(id, div.getContent(),
                        replace);
            }
            break;
        case DL:
            Dl dl = (Dl) target;
            if (dl.isSetDtOrDd()) {
                for (int i = 0; i < dl.getDtOrDd().size(); i++) {
                    AbstractJaxb obj = dl.getDtOrDd().get(i);
                    if (id.equals(obj.getId())) {
                        if (obj instanceof Dt || obj instanceof Dd) {
                            dl.getDtOrDd().set(i, (AbstractJaxb) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Dd.class, obj
                                    .getClass());
                        }
                    } else {
                        if (execute(id, obj, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case DT:
            Dt dt = (Dt) target;
            if (dt.isSetContent()) {
                return replaceByIdWithinObjectList(id, dt.getContent(), replace);
            }
            break;
        case EM:
            Em em = (Em) target;
            if (em.isSetContent()) {
                return replaceByIdWithinObjectList(id, em.getContent(), replace);
            }
            break;
        case FIELDSET:
            Fieldset fieldset = (Fieldset) target;
            if (fieldset.isSetContent()) {
                return replaceByIdWithinObjectList(id, fieldset.getContent(),
                        replace);
            }
            break;
        case FONT:
            Font font = (Font) target;
            if (font.isSetContent()) {
                return replaceByIdWithinObjectList(id, font.getContent(),
                        replace);
            }
            break;
        case FORM:
            Form form = (Form) target;
            if (form.isSetContent()) {
                return replaceByIdWithinObjectList(id, form.getContent(),
                        replace);
            }
            break;
        case H1:
            H1 h1 = (H1) target;
            if (h1.isSetContent()) {
                return replaceByIdWithinObjectList(id, h1.getContent(), replace);
            }
            break;
        case H2:
            H2 h2 = (H2) target;
            if (h2.isSetContent()) {
                return replaceByIdWithinObjectList(id, h2.getContent(), replace);
            }
            break;
        case H3:
            H3 h3 = (H3) target;
            if (h3.isSetContent()) {
                return replaceByIdWithinObjectList(id, h3.getContent(), replace);
            }
            break;
        case H4:
            H4 h4 = (H4) target;
            if (h4.isSetContent()) {
                return replaceByIdWithinObjectList(id, h4.getContent(), replace);
            }
            break;
        case H5:
            H5 h5 = (H5) target;
            if (h5.isSetContent()) {
                return replaceByIdWithinObjectList(id, h5.getContent(), replace);
            }
            break;
        case H6:
            H6 h6 = (H6) target;
            if (h6.isSetContent()) {
                return replaceByIdWithinObjectList(id, h6.getContent(), replace);
            }
            break;
        case HGROUP:
            Hgroup hgroup = (Hgroup) target;
            if (hgroup.isSetH1OrH2OrH3()) {
                for (AbstractJaxb aj : hgroup.getH1OrH2OrH3()) {
                    if (execute(id, aj, replace)) {
                        return true;
                    }
                }
            }
            break;
        case HEAD:
            Head head = (Head) target;
            for (int j = 0; j < head.getContent().size(); j++) {
                AbstractJaxb obj = head.getContent().get(j);
                if (obj.isSetId() && obj.getId().equals(id)) {
                    head.getContent().set(j, (AbstractJaxb) replace);
                    return true;
                } else {
                    if (execute(id, obj, replace)) {
                        return true;
                    }
                }
            }
            break;
        case HR:
            // hr is empty element.
            break;
        case HTML:
            Html html = (Html) target;
            if (html.isSetHead()) {
                if (execute(id, html.getHead(), replace)) {
                    return true;
                }
            }
            if (html.isSetBody()) {
                if (execute(id, html.getBody(), replace)) {
                    return true;
                }
            }
            break;
        case I:
            I i = (I) target;
            if (i.isSetContent()) {
                return replaceByIdWithinObjectList(id, i.getContent(), replace);
            }
            break;
        case IFRAME:
            Iframe iframe = (Iframe) target;
            if (iframe.isSetContent()) {
                return replaceByIdWithinObjectList(id, iframe.getContent(),
                        replace);
            }
            break;
        case IMG:
            // img is empty element.
            break;
        case INPUT:
            // input is empty element.
            break;
        case INS:
            Ins ins = (Ins) target;
            if (ins.isSetContent()) {
                return replaceByIdWithinObjectList(id, ins.getContent(),
                        replace);
            }
            break;
        case ISINDEX:
            // empty element.
            break;
        case KBD:
            Kbd kbd = (Kbd) target;
            if (kbd.isSetContent()) {
                return replaceByIdWithinObjectList(id, kbd.getContent(),
                        replace);
            }
            break;
        case LABEL:
            Label label = (Label) target;
            if (label.isSetContent()) {
                return replaceByIdWithinObjectList(id, label.getContent(),
                        replace);
            }
            break;
        case LEGEND:
            Legend legend = (Legend) target;
            if (legend.isSetContent()) {
                return replaceByIdWithinObjectList(id, legend.getContent(),
                        replace);
            }
            break;
        case LI:
            Li li = (Li) target;
            if (li.isSetContent()) {
                return replaceByIdWithinObjectList(id, li.getContent(), replace);
            }
            break;
        case LINK:
            // empty element.
            break;
        case MAP:
            Map map = (Map) target;
            if (map.isSetArea()) {
                for (int j = 0; j < map.getArea().size(); j++) {
                    Area area2 = map.getArea().get(j);
                    if (area2.isSetId() && id.equals(area2.getId())) {
                        map.getArea().set(j, (Area) replace);
                        return true;
                    }
                    // area has no child element.
                }
            }
            if (map.isSetPOrH1OrH2()) {
                for (int k = 0; k < map.getPOrH1OrH2().size(); k++) {
                    AbstractJaxb obj = map.getPOrH1OrH2().get(k);
                    if (id.equals(obj.getId())) {
                        map.getPOrH1OrH2().set(k, (AbstractJaxb) replace);
                        return true;
                    } else {
                        if (execute(id, obj, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case MENU:
            Menu menu = (Menu) target;
            if (menu.isSetContent()) {
                return replaceByIdWithinObjectList(id, menu.getContent(),
                        replace);
            }
            break;
        case META:
            // empty element.
            break;
        case NOFRAMES:
            Noframes noframes = (Noframes) target;
            if (noframes.isSetContent()) {
                return replaceByIdWithinObjectList(id, noframes.getContent(),
                        replace);
            }
            break;
        case NOSCRIPT:
            Noscript noscript = (Noscript) target;
            if (noscript.isSetContent()) {
                return replaceByIdWithinObjectList(id, noscript.getContent(),
                        replace);
            }
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
            if (object.isSetContent()) {
                return replaceByIdWithinObjectList(id, object.getContent(),
                        replace);
            }
            break;
        case OL:
            Ol ol = (Ol) target;
            if (ol.isSetLi()) {
                for (int j = 0; j < ol.getLi().size(); j++) {
                    Li li2 = ol.getLi().get(j);
                    if (li2.isSetId() && li2.getId().equals(id)) {
                        if (replace instanceof Li) {
                            ol.getLi().set(j, (Li) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Li.class, replace
                                    .getClass());
                        }
                    } else {
                        if (execute(id, li2, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case OPTGROUP:
            Optgroup optgroup = (Optgroup) target;
            if (optgroup.isSetOption()) {
                for (int j = 0; j < optgroup.getOption().size(); j++) {
                    Option option = optgroup.getOption().get(j);
                    if (option.isSetId() && option.getId().equals(id)) {
                        if (replace instanceof Option) {
                            optgroup.getOption().set(j, (Option) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Option.class,
                                    replace.getClass());
                        }
                    } else {
                        if (execute(id, option, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case OPTION:
            // option tag includes no other element.
            break;
        case P:
            P p = (P) target;
            if (p.isSetContent()) {
                return replaceByIdWithinObjectList(id, p.getContent(), replace);
            }
            break;
        case PARAM:
            // param is empty element.
            break;
        case PRE:
            Pre pre = (Pre) target;
            if (pre.isSetContent()) {
                return replaceByIdWithinObjectList(id, pre.getContent(),
                        replace);
            }
            break;
        case Q:
            Q q = (Q) target;
            if (q.isSetContent()) {
                return replaceByIdWithinObjectList(id, q.getContent(), replace);
            }
            break;
        case S:
            S s = (S) target;
            if (s.isSetContent()) {
                return replaceByIdWithinObjectList(id, s.getContent(), replace);
            }
            break;
        case SAMP:
            Samp samp = (Samp) target;
            if (samp.isSetContent()) {
                return replaceByIdWithinObjectList(id, samp.getContent(),
                        replace);
            }
            break;
        case SCRIPT:
            // script include no other element.
            break;
        case SELECT:
            Select select = (Select) target;
            if (select.isSetOptgroupOrOption()) {
                for (int j = 0; j < select.getOptgroupOrOption().size(); j++) {
                    AbstractJaxb obj = select.getOptgroupOrOption().get(j);
                    if (id.equals(obj.getId())) {
                        if (obj.getClass().equals(Optgroup.class)
                                || obj.getClass().equals(Option.class)) {
                            select.getOptgroupOrOption().set(j,
                                    (AbstractJaxb) replace);
                        } else {
                            throw new TagTypeUnmatchException(
                                    "Option or Optgroup expected, but replace is "
                                            + replace.getClass());
                        }
                        return true;
                    } else {
                        if (execute(id, obj, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case SMALL:
            Small small = (Small) target;
            if (small.isSetContent()) {
                return replaceByIdWithinObjectList(id, small.getContent(),
                        replace);
            }
            break;
        case SPAN:
            Span span = (Span) target;
            if (span.isSetContent()) {
                return replaceByIdWithinObjectList(id, span.getContent(),
                        replace);
            }
            break;
        case STRIKE:
            Strike strike = (Strike) target;
            if (strike.isSetContent()) {
                return replaceByIdWithinObjectList(id, strike.getContent(),
                        replace);
            }
            break;
        case STRONG:
            Strong strong = (Strong) target;
            if (strong.isSetContent()) {
                return replaceByIdWithinObjectList(id, strong.getContent(),
                        replace);
            }
            break;
        case STYLE:
            // has no other element.
            break;
        case SUB:
            Sub sub = (Sub) target;
            if (sub.isSetContent()) {
                return replaceByIdWithinObjectList(id, sub.getContent(),
                        replace);
            }
            break;
        case SUP:
            Sup sup = (Sup) target;
            if (sup.isSetContent()) {
                return replaceByIdWithinObjectList(id, sup.getContent(),
                        replace);
            }
            break;
        case TABLE:
            Table table = (Table) target;
            if (table.isSetCaption()) {
                Caption capt = table.getCaption();
                if (capt.isSetId() && id.equals(capt.getId())) {
                    if (replace instanceof Caption) {
                        table.setCaption((Caption) replace);
                        return true;
                    } else {
                        throw new TagTypeUnmatchException(Caption.class,
                                replace.getClass());
                    }
                } else {
                    if (replaceByIdWithinObjectList(id, capt.getContent(),
                            replace)) {
                        return true;
                    }
                }
            }
            if (table.isSetCol()) {
                for (int j = 0; j < table.getCol().size(); j++) {
                    Col col2 = table.getCol().get(j);
                    if (col2.isSetId() && col2.getId().equals(id)) {
                        if (replace instanceof Col) {
                            table.getCol().set(j, (Col) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Col.class,
                                    replace.getClass());
                        }
                    }
                }
            }
            if (table.isSetColgroup()) {
                for (int j = 0; j < table.getColgroup().size(); j++) {
                    Colgroup cg = table.getColgroup().get(j);
                    if (cg.isSetId() && cg.getId().equals(id)) {
                        if (replace instanceof Colgroup) {
                            table.getColgroup().set(j, (Colgroup) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Colgroup.class,
                                    replace.getClass());
                        }
                    } else {
                        if (execute(id, cg, replace)) {
                            return true;
                        }
                    }
                }
            }
            if (table.isSetTbody()) {
                for (int j = 0; j < table.getTbody().size(); j++) {
                    Tbody tbody = table.getTbody().get(j);
                    if (tbody.isSetId() && tbody.getId().equals(tbody)) {
                        if (replace instanceof Tbody) {
                            table.getTbody().set(j, (Tbody) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Tbody.class,
                                    replace.getClass());
                        }
                    } else {
                        if (execute(id, tbody, replace)) {
                            return true;
                        }
                    }
                }
            }
            if (table.isSetThead()) {
                Thead thead = table.getThead();
                if (thead.isSetId() && thead.getId().equals(id)) {
                    if (replace instanceof Thead) {
                        table.setThead((Thead) replace);
                        return true;
                    } else {
                        throw new TagTypeUnmatchException(Thead.class, replace
                                .getClass());
                    }
                } else {
                    if (execute(id, thead, replace)) {
                        return true;
                    }
                }
            }
            if (table.isSetTfoot()) {
                Tfoot tfoot = table.getTfoot();
                if (tfoot.isSetId() && tfoot.getId().equals(id)) {
                    if (replace instanceof Tfoot) {
                        table.setTfoot((Tfoot) replace);
                        return true;
                    } else {
                        throw new TagTypeUnmatchException(Tfoot.class, replace
                                .getClass());
                    }
                } else {
                    if (execute(id, tfoot, replace)) {
                        return true;
                    }
                }
            }
            if (table.isSetTr()) {
                for (int j = 0; j < table.getTr().size(); j++) {
                    Tr tr = table.getTr().get(j);
                    if (tr.isSetId() && tr.getId().equals(id)) {
                        if (replace instanceof Tr) {
                            table.getTr().set(j, (Tr) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Tr.class, replace
                                    .getClass());
                        }
                    } else {
                        if (execute(id, tr, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TBODY:
            Tbody tbody = (Tbody) target;
            if (tbody.isSetTr()) {
                for (int j = 0; j < tbody.getTr().size(); j++) {
                    Tr tr = tbody.getTr().get(j);
                    if (tr.isSetId() && tr.getId().equals(id)) {
                        if (replace instanceof Tr) {
                            tbody.getTr().set(j, (Tr) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Tr.class, replace
                                    .getClass());
                        }
                    } else {
                        if (execute(id, tr, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TD:
            Td td = (Td) target;
            if (td.isSetContent()) {
                return replaceByIdWithinObjectList(id, td.getContent(), replace);
            }
            break;
        case TEXTAREA:
            // textarea has no other element.
            break;
        case TFOOT:
            Tfoot tfoot = (Tfoot) target;
            if (tfoot.isSetTr()) {
                for (int j = 0; j < tfoot.getTr().size(); j++) {
                    Tr tr = tfoot.getTr().get(j);
                    if (tr.isSetId() && tr.getId().equals(id)) {
                        if (replace instanceof Tr) {
                            tfoot.getTr().set(j, (Tr) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Tr.class, replace
                                    .getClass());
                        }
                    } else {
                        if (execute(id, tr, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TH:
            Th th = (Th) target;
            if (th.isSetContent()) {
                return replaceByIdWithinObjectList(id, th.getContent(), replace);
            }
            break;
        case THEAD:
            Thead thead = (Thead) target;
            if (thead.isSetTr()) {
                for (int j = 0; j < thead.getTr().size(); j++) {
                    Tr tr = thead.getTr().get(j);
                    if (tr.isSetId() && tr.getId().equals(id)) {
                        if (replace instanceof Tr) {
                            thead.getTr().set(j, (Tr) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Tr.class, replace
                                    .getClass());
                        }
                    } else {
                        if (execute(id, tr, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TITLE:
            // has no other element.
            break;
        case TR:
            Tr tr = (Tr) target;
            if (tr.isSetThOrTd()) {
                for (int j = 0; j < tr.getThOrTd().size(); j++) {
                    Flow obj = tr.getThOrTd().get(j);
                    if (id.equals(obj.getId())) {
                        if (replace.getClass().equals(Td.class)) {
                            tr.getThOrTd().set(j, (Td) replace);
                            return true;
                        } else if (replace.getClass().equals(Th.class)) {
                            tr.getThOrTd().set(j, (Th) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(
                                    "Td or Th expected, but replace is "
                                            + replace.getClass());
                        }
                    } else {
                        if (execute(id, obj, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TT:
            Tt tt = (Tt) target;
            if (tt.isSetContent()) {
                return replaceByIdWithinObjectList(id, tt.getContent(), replace);
            }
            break;
        case U:
            U u = (U) target;
            if (u.isSetContent()) {
                return replaceByIdWithinObjectList(id, u.getContent(), replace);
            }
            break;
        case UL:
            Ul ul = (Ul) target;
            if (ul.isSetLi()) {
                for (int j = 0; j < ul.getLi().size(); j++) {
                    Li li2 = ul.getLi().get(j);
                    if (li2.isSetId() && li2.getId().equals(id)) {
                        if (replace instanceof Li) {
                            ul.getLi().set(j, (Li) replace);
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Li.class, replace
                                    .getClass());
                        }
                    } else {
                        if (execute(id, li2, replace)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case VAR:
            Var var = (Var) target;
            if (var.isSetContent()) {
                return replaceByIdWithinObjectList(id, var.getContent(),
                        replace);
            }
            break;
        case ARTICLE:
            Article article = (Article) target;
            if (article.isSetContent()) {
                return replaceByIdWithinObjectList(id, article.getContent(),
                        replace);
            }
            break;
        case ASIDE:
            Aside aside = (Aside) target;
            if (aside.isSetContent()) {
                return replaceByIdWithinObjectList(id, aside.getContent(),
                        replace);
            }
            break;
        case AUDIO:
            Audio audio = (Audio) target;
            if (audio.isSetContent()) {
                return replaceByIdWithinObjectList(id, audio.getContent(),
                        replace);
            }
            break;
        case BDI:
            Bdi bdi = (Bdi) target;
            if (bdi.isSetContent()) {
                return replaceByIdWithinObjectList(id, bdi.getContent(),
                        replace);
            }
            break;
        case CANVAS:
            Canvas canvas = (Canvas) target;
            if (canvas.isSetContent()) {
                return replaceByIdWithinObjectList(id, canvas.getContent(),
                        replace);
            }
            break;
        case COMMAND:
            // empty element
            break;
        case DATALIST:
            Datalist datalist = (Datalist) target;
            if (datalist.isSetContent()) {
                return replaceByIdWithinObjectList(id, datalist.getContent(),
                        replace);
            }
            break;
        case DETAILS:
            Details details = (Details) target;
            if (details.isSetContent()) {
                return replaceByIdWithinObjectList(id, details.getContent(),
                        replace);
            }
            break;
        case EMBED:
            // empty element
            break;
        case FIGCAPTION:
            Figcaption figcaption = (Figcaption) target;
            if (figcaption.isSetContent()) {
                return replaceByIdWithinObjectList(id, figcaption.getContent(),
                        replace);
            }
            break;
        case FIGURE:
            Figure figure = (Figure) target;
            if (figure.isSetContent()) {
                return replaceByIdWithinObjectList(id, figure.getContent(),
                        replace);
            }
            break;
        case FOOTER:
            Footer footer = (Footer) target;
            if (footer.isSetContent()) {
                return replaceByIdWithinObjectList(id, footer.getContent(),
                        replace);
            }
            break;
        case HEADER:
            Header header = (Header) target;
            if (header.isSetContent()) {
                return replaceByIdWithinObjectList(id, header.getContent(),
                        replace);
            }
            break;
        case KEYGEN:
            // empty element
            break;
        case MARK:
            Mark mark = (Mark) target;
            if (mark.isSetContent()) {
                return replaceByIdWithinObjectList(id, mark.getContent(),
                        replace);
            }
            break;
        case METER:
            Meter meter = (Meter) target;
            if (meter.isSetContent()) {
                return replaceByIdWithinObjectList(id, meter.getContent(),
                        replace);
            }
            break;
        case NAV:
            Nav nav = (Nav) target;
            if (nav.isSetContent()) {
                return replaceByIdWithinObjectList(id, nav.getContent(),
                        replace);
            }
            break;
        case OUTPUT:
            Output output = (Output) target;
            if (output.isSetContent()) {
                return replaceByIdWithinObjectList(id, output.getContent(),
                        replace);
            }
            break;
        case PROGRESS:
            Progress progress = (Progress) target;
            if (progress.isSetContent()) {
                return replaceByIdWithinObjectList(id, progress.getContent(),
                        replace);
            }
            break;
        case RP:
            Rp rp = (Rp) target;
            if (rp.isSetContent()) {
                return replaceByIdWithinObjectList(id, rp.getContent(), replace);
            }
            break;
        case RT:
            Rt rt = (Rt) target;
            if (rt.isSetContent()) {
                return replaceByIdWithinObjectList(id, rt.getContent(), replace);
            }
            break;
        case RUBY:
            Ruby ruby = (Ruby) target;
            if (ruby.isSetContent()) {
                return replaceByIdWithinObjectList(id, ruby.getContent(),
                        replace);
            }
            break;
        case SECTION:
            Section section = (Section) target;
            if (section.isSetContent()) {
                return replaceByIdWithinObjectList(id, section.getContent(),
                        replace);
            }
            break;
        case SOURCE:
            // empty element
            break;
        case SUMMARY:
            Summary summary = (Summary) target;
            if (summary.isSetContent()) {
                return replaceByIdWithinObjectList(id, summary.getContent(),
                        replace);
            }
            break;
        case TIME:
            Time time = (Time) target;
            if (time.isSetContent()) {
                return replaceByIdWithinObjectList(id, time.getContent(),
                        replace);
            }
            break;
        case TRACK:
            // empty element
            break;
        case VIDEO:
            Video video = (Video) target;
            if (video.isSetContent()) {
                return replaceByIdWithinObjectList(id, video.getContent(),
                        replace);
            }
            break;
        case WBR:
            // empty element
            break;
        }

        return false;
    }
}

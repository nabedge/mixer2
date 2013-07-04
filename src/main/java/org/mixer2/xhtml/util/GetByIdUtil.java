package org.mixer2.xhtml.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.util.CastUtil;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;

/**
 *
 * @see org.mixer2.xhtml.AbstractJaxb#getById(String)
 * @see org.mixer2.xhtml.AbstractJaxb#getById(String, Class)
 * @author watanabe
 */
public class GetByIdUtil {

    @SuppressWarnings("unused")
    private static Log log = LogFactory.getLog(GetByIdUtil.class);

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> T getByIdWithinObjectList(
            String id, List<java.lang.Object> list) {
        T result = null;
        for (java.lang.Object obj : list) {
            if (obj instanceof AbstractJaxb) {
                result = getById(id, (T) obj);
                if (result != null) {
                    return result;
                }
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T extends AbstractJaxb> T getById(String id, T target) {

        T result = null;
        if (id == null) {
            return result;
        }
        TagEnum tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                .toUpperCase());
        // log.debug("tagEnum: " + tagEnum);

        switch (tagEnum) {
        case A:
            A a = (A) target;
            if (id.equals(a.getId())) {
                return target;
            }
            if (a.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        a.getContent()));
            }
            break;
        case ABBR:
            Abbr abbr = (Abbr) target;
            if (id.equals(abbr.getId())) {
                return target;
            }
            if (abbr.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        abbr.getContent()));
            }
            break;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            if (id.equals(acronym.getId())) {
                return target;
            }
            if (acronym.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        acronym.getContent()));
            }
            break;
        case ADDRESS:
            Address address = (Address) target;
            if (id.equals(address.getId())) {
                return target;
            }
            if (address.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        address.getContent()));
            }
            break;
        case APPLET:
            Applet applet = (Applet) target;
            if (id.equals(applet.getId())) {
                return target;
            }
            if (applet.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        applet.getContent()));
            }
            break;
        case AREA:
            Area area = (Area) target;
            if (id.equals(area.getId())) {
                return target;
            }
            // area is empty element.
            break;
        case B:
            B b = (B) target;
            if (id.equals(b.getId())) {
                return target;
            }
            if (b.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        b.getContent()));
            }
            break;
        case BASE:
            Base base = (Base) target;
            if (id.equals(base.getId())) {
                return target;
            }
            // empty element.
            break;
        case BASEFONT:
            Basefont basefont = (Basefont) target;
            if (id.equals(basefont.getId())) {
                return target;
            }
            // empty element.
            break;
        case BDO:
            Bdo bdo = (Bdo) target;
            if (id.equals(bdo.getId())) {
                return target;
            }
            if (bdo.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        bdo.getContent()));
            }
            break;
        case BIG:
            Big big = (Big) target;
            if (id.equals(big.getId())) {
                return target;
            }
            if (big.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        big.getContent()));
            }
            break;
        case BLOCKQUOTE:
            Blockquote blockquote = (Blockquote) target;
            if (id.equals(blockquote.getId())) {
                return target;
            }
            if (blockquote.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        blockquote.getContent()));
            }
            break;
        case BODY:
            Body body = (Body) target;
            if (id.equals(body.getId())) {
                return target;
            }
            if (body.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        body.getContent()));
            }
            break;
        case BR:
            Br br = (Br) target;
            if (id.equals(br.getId())) {
                return target;
            }
            // empty element.
            break;
        case BUTTON:
            Button button = (Button) target;
            if (id.equals(button.getId())) {
                return target;
            }
            if (button.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        button.getContent()));
            }
            break;
        case CAPTION:
            Caption caption = (Caption) target;
            if (id.equals(caption.getId())) {
                return target;
            }
            if (caption.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        caption.getContent()));
            }
            break;
        case CENTER:
            Center center = (Center) target;
            if (id.equals(center.getId())) {
                return target;
            }
            if (center.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        center.getContent()));
            }
            break;
        case CITE:
            Cite cite = (Cite) target;
            if (id.equals(cite.getId())) {
                return target;
            }
            if (cite.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        cite.getContent()));
            }
            break;
        case CODE:
            Code code = (Code) target;
            if (id.equals(code.getId())) {
                return target;
            }
            if (code.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        code.getContent()));
            }
            break;
        case COL:
            Col col = (Col) target;
            if (id.equals(col.getId())) {
                return target;
            }
            // empty element.
            break;
        case COLGROUP:
            Colgroup colgroup = (Colgroup) target;
            if (id.equals(colgroup.getId())) {
                return target;
            }
            if (colgroup.isSetCol()) {
                for (Col c : colgroup.getCol()) {
                    result = getById(id, (T) c);
                    if (result != null) {
                        return result;
                    }
                }
            }
            break;
        case DD:
            Dd dd = (Dd) target;
            if (id.equals(dd.getId())) {
                return target;
            }
            if (dd.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        dd.getContent()));
            }
            break;
        case DEL:
            Del del = (Del) target;
            if (id.equals(del.getId())) {
                return target;
            }
            if (del.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        del.getContent()));
            }
            break;
        case DFN:
            Dfn dfn = (Dfn) target;
            if (id.equals(dfn.getId())) {
                return target;
            }
            if (dfn.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        dfn.getContent()));
            }
            break;
        case DIR:
            Dir dir = (Dir) target;
            if (id.equals(dir.getId())) {
                return target;
            }
            if (dir.isSetLi()) {
                for (Li li : dir.getLi()) {
                    result = getById(id, (T) li);
                    if (result != null) {
                        return result;
                    }
                }
            }
            break;
        case DIV:
            Div div = (Div) target;
            if (id.equals(div.getId())) {
                return target;
            }
            if (div.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        div.getContent()));
            }
            break;
        case DL:
            Dl dl = (Dl) target;
            if (id.equals(dl.getId())) {
                return target;
            }
            if (dl.isSetDtOrDd()) {
                for (java.lang.Object obj : dl.getDtOrDd()) {
                    if (obj.getClass().equals(Dt.class)) {
                        Dt dt = (Dt) obj;
                        if (id.equals(dt.getId())) {
                            return (T) dt;
                        } else {
                            result = getById(id, (T) dt);
                            if (result != null) {
                                return result;
                            }
                        }
                    }
                    if (obj.getClass().equals(Dd.class)) {
                        Dd dd2 = (Dd) obj;
                        if (id.equals(dd2.getId())) {
                            return (T) dd2;
                        } else {
                            result = getById(id, (T) dd2);
                            if (result != null) {
                                return result;
                            }
                        }
                    }
                }
            }
            break;
        case DT:
            Dt dt = (Dt) target;
            if (id.equals(dt.getId())) {
                return target;
            }
            if (dt.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        dt.getContent()));
            }
            break;
        case EM:
            Em em = (Em) target;
            if (id.equals(em.getId())) {
                return target;
            }
            if (em.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        em.getContent()));
            }
            break;
        case FIELDSET:
            Fieldset fieldset = (Fieldset) target;
            if (id.equals(fieldset.getId())) {
                return target;
            }
            if (fieldset.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        fieldset.getContent()));
            }
            break;
        case FONT:
            Font font = (Font) target;
            if (id.equals(font.getId())) {
                return target;
            }
            if (font.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        font.getContent()));
            }
            break;
        case FORM:
            Form form = (Form) target;
            if (id.equals(form.getId())) {
                return target;
            }
            if (form.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        form.getContent()));
            }
            break;
        case H1:
            H1 h1 = (H1) target;
            if (id.equals(h1.getId())) {
                return target;
            }
            if (h1.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        h1.getContent()));
            }
            break;
        case H2:
            H2 h2 = (H2) target;
            if (id.equals(h2.getId())) {
                return target;
            }
            if (h2.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        h2.getContent()));
            }
            break;
        case H3:
            H3 h3 = (H3) target;
            if (id.equals(h3.getId())) {
                return target;
            }
            if (h3.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        h3.getContent()));
            }
            break;
        case H4:
            H4 h4 = (H4) target;
            if (id.equals(h4.getId())) {
                return target;
            }
            if (h4.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        h4.getContent()));
            }
            break;
        case H5:
            H5 h5 = (H5) target;
            if (id.equals(h5.getId())) {
                return target;
            }
            if (h5.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        h5.getContent()));
            }
            break;
        case H6:
            H6 h6 = (H6) target;
            if (id.equals(h6.getId())) {
                return target;
            }
            if (h6.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        h6.getContent()));
            }
            break;
        case HGROUP:
            Hgroup hgroup = (Hgroup)target;
            if (id.equals(hgroup.getId())) {
                return target;
            }
            if (hgroup.isSetH1OrH2OrH3()) {
                for (AbstractJaxb aj : hgroup.getH1OrH2OrH3()) {
                    result = getById(id, (T) aj);
                    if (result != null) {
                        return result;
                    }
                }
            }
            break;
        case HEAD:
            Head head = (Head) target;
            if (id.equals(head.getId())) {
                return target;
            }
            for (AbstractJaxb aj : head.getContent()) {
                result = getById(id, (T) aj);
                if (result != null) {
                    return result;
                }
            }
            break;
        case HR:
            Hr hr = (Hr) target;
            if (id.equals(hr.getId())) {
                return target;
            }
            // hr is empty element.
            break;
        case HTML:
            Html html = (Html) target;
            if (id.equals(html.getId())) {
                return target;
            }
            if (html.isSetHead()) {
                if (id.equals(html.getHead().getId())) {
                    return (T) html.getHead();
                }
                result = getById(id, (T) html.getHead());
            }
            if (result == null && html.isSetBody()) {
                if (id.equals(html.getBody().getId())) {
                    return (T) html.getBody();
                }
                result = getById(id, (T) html.getBody());
            }
            break;
        case I:
            I i = (I) target;
            if (id.equals(i.getId())) {
                return target;
            }
            if (i.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        i.getContent()));
            }
            break;
        case IFRAME:
            Iframe iframe = (Iframe) target;
            if (id.equals(iframe.getId())) {
                return target;
            }
            if (iframe.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        iframe.getContent()));
            }
            break;
        case IMG:
            Img img = (Img) target;
            if (id.equals(img.getId())) {
                return target;
            }
            // img is empty element.
            break;
        case INPUT:
            Input input = (Input) target;
            if (id.equals(input.getId())) {
                return target;
            }
            // input is empty element.
            break;
        case INS:
            Ins ins = (Ins) target;
            if (id.equals(ins.getId())) {
                return target;
            }
            if (ins.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        ins.getContent()));
            }
            break;
        case ISINDEX:
            Isindex isindex = (Isindex) target;
            if (id.equals(isindex.getId())) {
                return target;
            }
            // empty element.
            break;
        case KBD:
            Kbd kbd = (Kbd) target;
            if (id.equals(kbd.getId())) {
                return target;
            }
            if (kbd.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        kbd.getContent()));
            }
            break;
        case LABEL:
            Label label = (Label) target;
            if (id.equals(label.getId())) {
                return target;
            }
            if (label.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        label.getContent()));
            }
            break;
        case LEGEND:
            Legend legend = (Legend) target;
            if (id.equals(legend.getId())) {
                return target;
            }
            if (legend.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        legend.getContent()));
            }
            break;
        case LI:
            Li li = (Li) target;
            if (id.equals(li.getId())) {
                return target;
            }
            if (li.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        li.getContent()));
            }
            break;
        case LINK:
            Link link = (Link) target;
            if (id.equals(link.getId())) {
                return target;
            }
            // empty element.
            break;
        case MAP:
            Map map = (Map) target;
            if (id.equals(map.getId())) {
                return target;
            }
            if (map.isSetArea()) {
                for (Area area2 : map.getArea()) {
                    if (id.equals(area2.getId())) {
                        return (T) area2;
                    } else {
                        result = getById(id, (T) area2);
                        if (result != null) {
                            return result;
                        }
                    }
                }
            }
            if (map.isSetPOrH1OrH2()) {
                for (AbstractJaxb obj : map.getPOrH1OrH2()) {
                    result = getById(id, (T) obj);
                    if (result != null) {
                        return result;
                    }
                }
            }
            break;
        case MENU:
            Menu menu = (Menu) target;
            if (id.equals(menu.getId())) {
                return target;
            }
            if (menu.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        menu.getContent()));
            }
            break;
        case META:
            Meta meta = (Meta) target;
            if (id.equals(meta.getId())) {
                return target;
            }
            // empty element.
            break;
        case NOFRAMES:
            Noframes noframes = (Noframes) target;
            if (id.equals(noframes.getId())) {
                return target;
            }
            if (noframes.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        noframes.getContent()));
            }
            break;
        case NOSCRIPT:
            Noscript noscript = (Noscript) target;
            if (id.equals(noscript.getId())) {
                return target;
            }
            if (noscript.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        noscript.getContent()));
            }
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
            if (id.equals(object.getId())) {
                return target;
            }
            if (object.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        object.getContent()));
            }
            break;
        case OL:
            Ol ol = (Ol) target;
            if (id.equals(ol.getId())) {
                return target;
            }
            if (ol.isSetLi()) {
                for (Li li2 : ol.getLi()) {
                    result = getById(id, (T) li2);
                    if (result != null) {
                        return result;
                    }
                }
            }
            break;
        case OPTGROUP:
            Optgroup optgroup = (Optgroup) target;
            if (id.equals(optgroup.getId())) {
                return target;
            }
            if (optgroup.isSetOption()) {
                for (Option option : optgroup.getOption()) {
                    result = getById(id, (T) option);
                    if (result != null) {
                        return result;
                    }
                }
            }
            break;
        case OPTION:
            Option option = (Option) target;
            if (id.equals(option.getId())) {
                return target;
            }
            // option tag includes no other element.
            break;
        case P:
            P p = (P) target;
            if (id.equals(p.getId())) {
                return target;
            }
            if (p.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        p.getContent()));
            }
            break;
        case PARAM:
            Param param = (Param) target;
            if (id.equals(param.getId())) {
                return target;
            }
            // param is empty element.
            break;
        case PRE:
            Pre pre = (Pre) target;
            if (id.equals(pre.getId())) {
                return target;
            }
            if (pre.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        pre.getContent()));
            }
            break;
        case Q:
            Q q = (Q) target;
            if (id.equals(q.getId())) {
                return target;
            }
            if (q.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        q.getContent()));
            }
            break;
        case S:
            S s = (S) target;
            if (id.equals(s.getId())) {
                return target;
            }
            if (s.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        s.getContent()));
            }
            break;
        case SAMP:
            Samp samp = (Samp) target;
            if (id.equals(samp.getId())) {
                return target;
            }
            if (samp.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        samp.getContent()));
            }
            break;
        case SCRIPT:
            Script script = (Script) target;
            if (id.equals(script.getId())) {
                return target;
            }
            // script include no other element.
            break;
        case SELECT:
            Select select = (Select) target;
            if (id.equals(select.getId())) {
                return target;
            }
            if (select.isSetOptgroupOrOption()) {
                for (AbstractJaxb obj : select.getOptgroupOrOption()) {
                    result = getById(id, (T) obj);
                    if (result != null) {
                        return result;
                    }
                }
            }
            break;
        case SMALL:
            Small small = (Small) target;
            if (id.equals(small.getId())) {
                return target;
            }
            if (small.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        small.getContent()));
            }
            break;
        case SPAN:
            Span span = (Span) target;
            if (id.equals(span.getId())) {
                return target;
            }
            if (span.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        span.getContent()));
            }
            break;
        case STRIKE:
            Strike strike = (Strike) target;
            if (id.equals(strike.getId())) {
                return target;
            }
            if (strike.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        strike.getContent()));
            }
            break;
        case STRONG:
            Strong strong = (Strong) target;
            if (id.equals(strong.getId())) {
                return target;
            }
            if (strong.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        strong.getContent()));
            }
            break;
        case STYLE:
            Style style = (Style) target;
            if (id.equals(style.getId())) {
                return target;
            }
            // has no other element.
            break;
        case SUB:
            Sub sub = (Sub) target;
            if (id.equals(sub.getId())) {
                return target;
            }
            if (sub.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        sub.getContent()));
            }
            break;
        case SUP:
            Sup sup = (Sup) target;
            if (id.equals(sup.getId())) {
                return target;
            }
            if (sup.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        sup.getContent()));
            }
            break;
        case TABLE:
            Table table = (Table) target;
            if (id.equals(table.getId())) {
                return target;
            }
            if (table.isSetCaption()) {
                Caption capt = table.getCaption();
                if (id.equals(capt.getId())) {
                    return (T) capt;
                } else {
                    result = getById(id, (T) capt);
                    if (result != null) {
                        return result;
                    }
                }
            }
            if (table.isSetCol()) {
                for (Col col2 : table.getCol()) {
                    if (id.equals(col2.getId())) {
                        return (T) col2;
                    }
                }
            }
            if (table.isSetColgroup()) {
                for (Colgroup colgroup2 : table.getColgroup()) {
                    if (id.equals(colgroup2.getId())) {
                        return (T) colgroup2;
                    } else {
                        result = getById(id, (T) colgroup2);
                        if (result != null) {
                            return result;
                        }
                    }
                }
            }
            if (table.isSetTbody()) {
                for (Tbody tbody : table.getTbody()) {
                    if (id.equals(tbody.getId())) {
                        return (T) tbody;
                    } else {
                        result = getById(id, (T) tbody);
                        if (result != null) {
                            return result;
                        }
                    }
                }
            }
            if (table.isSetThead()) {
                Thead thead = table.getThead();
                if (id.equals(thead.getId())) {
                    return (T) thead;
                } else {
                    result = getById(id, (T) thead);
                    if (result != null) {
                        return result;
                    }
                }
            }
            if (table.isSetTfoot()) {
                Tfoot tfoot = table.getTfoot();
                if (id.equals(tfoot.getId())) {
                    return (T) tfoot;
                } else {
                    result = getById(id, (T) tfoot);
                    if (result != null) {
                        return result;
                    }
                }
            }
            if (table.isSetTr()) {
                for (Tr tr : table.getTr()) {
                    if (id.equals(tr.getId())) {
                        return (T) tr;
                    } else {
                        result = getById(id, (T) tr);
                        if (result != null) {
                            return result;
                        }
                    }
                }
            }
            break;
        case TBODY:
            Tbody tbody = (Tbody) target;
            if (id.equals(tbody.getId())) {
                return target;
            }
            if (tbody.isSetTr()) {
                for (Tr tr : tbody.getTr()) {
                    result = getById(id, (T) tr);
                    if (result != null) {
                        return result;
                    }
                }
            }
            break;
        case TD:
            Td td = (Td) target;
            if (id.equals(td.getId())) {
                return target;
            }
            if (td.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        td.getContent()));
            }
            break;
        case TEXTAREA:
            Textarea textarea = (Textarea) target;
            if (id.equals(textarea.getId())) {
                return target;
            }
            // textarea has no other element.
            break;
        case TFOOT:
            Tfoot tfoot = (Tfoot) target;
            if (id.equals(tfoot.getId())) {
                return target;
            }
            if (tfoot.isSetTr()) {
                for (Tr tr : tfoot.getTr()) {
                    if (id.equals(tr.getId())) {
                        return (T) tr;
                    } else {
                        result = getById(id, (T) tr);
                        if (result != null) {
                            return result;
                        }
                    }
                }
            }
            break;
        case TH:
            Th th = (Th) target;
            if (id.equals(th.getId())) {
                return target;
            }
            if (th.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        th.getContent()));
            }
            break;
        case THEAD:
            Thead thead = (Thead) target;
            if (id.equals(thead.getId())) {
                return target;
            }
            if (thead.isSetTr()) {
                for (Tr tr : thead.getTr()) {
                    if (id.equals(tr.getId())) {
                        return (T) tr;
                    } else {
                        result = getById(id, (T) tr);
                        if (result != null) {
                            return result;
                        }
                    }
                }
            }
            break;
        case TITLE:
            Title title = (Title) target;
            if (id.equals(title.getId())) {
                return target;
            }
            // has no other element.
            break;
        case TR:
            Tr tr = (Tr) target;
            if (id.equals(tr.getId())) {
                return target;
            }
            if (tr.isSetThOrTd()) {
                for (java.lang.Object obj : tr.getThOrTd()) {
                    if (obj.getClass().equals(Td.class)) {
                        td = (Td) obj;
                        if (id.equals(td.getId())) {
                            return (T) td;
                        } else {
                            result = getById(id, (T) td);
                            if (result != null) {
                                return result;
                            }
                        }
                    }
                    if (obj.getClass().equals(Th.class)) {
                        th = (Th) obj;
                        if (id.equals(th.getId())) {
                            return (T) th;
                        } else {
                            result = getById(id, (T) th);
                            if (result != null) {
                                return result;
                            }
                        }
                    }
                }
            }
            break;
        case TT:
            Tt tt = (Tt) target;
            if (id.equals(tt.getId())) {
                return target;
            }
            if (tt.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        tt.getContent()));
            }
            break;
        case U:
            U u = (U) target;
            if (id.equals(u.getId())) {
                return target;
            }
            if (u.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        u.getContent()));
            }
            break;
        case UL:
            Ul ul = (Ul) target;
            if (id.equals(ul.getId())) {
                return target;
            }
            if (ul.isSetLi()) {
                for (Li li2 : ul.getLi()) {
                    result = getById(id, (T) li2);
                    if (result != null) {
                        return result;
                    }
                }
            }
            break;
        case VAR:
            Var var = (Var) target;
            if (id.equals(var.getId())) {
                return target;
            }
            if (var.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        var.getContent()));
            }
            break;
        case ARTICLE:
            Article article = (Article) target;
            if (id.equals(article.getId())) {
                return target;
            }
            if (article.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        article.getContent()));
            }
            break;
        case ASIDE:
            Aside aside = (Aside) target;
            if (id.equals(aside.getId())) {
                return target;
            }
            if (aside.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        aside.getContent()));
            }
            break;
        case AUDIO:
            Audio audio = (Audio) target;
            if (id.equals(audio.getId())) {
                return target;
            }
            if (audio.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        audio.getContent()));
            }
            break;
        case BDI:
            Bdi bdi = (Bdi) target;
            if (id.equals(bdi.getId())) {
                return target;
            }
            if (bdi.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        bdi.getContent()));
            }
            break;
        case CANVAS:
            Canvas canvas = (Canvas) target;
            if (id.equals(canvas.getId())) {
                return target;
            }
            if (canvas.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        canvas.getContent()));
            }
            break;
        case COMMAND:
            Command command = (Command) target;
            if (id.equals(command.getId())) {
                return target;
            }
            // empty tag
            break;
        case DATALIST:
            Datalist datalist = (Datalist) target;
            if (id.equals(datalist.getId())) {
                return target;
            }
            if (datalist.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        datalist.getContent()));
            }
            break;
        case DETAILS:
            Details details = (Details) target;
            if (id.equals(details.getId())) {
                return target;
            }
            if (details.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        details.getContent()));
            }
            break;
        case EMBED:
            Embed embed = (Embed) target;
            if (id.equals(embed.getId())) {
                return target;
            }
            // empty element
            break;
        case FIGCAPTION:
            Figcaption figcaption = (Figcaption) target;
            if (id.equals(figcaption.getId())) {
                return target;
            }
            if (figcaption.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        figcaption.getContent()));
            }
            break;
        case FIGURE:
            Figure figure = (Figure) target;
            if (id.equals(figure.getId())) {
                return target;
            }
            if (figure.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        figure.getContent()));
            }
            break;
        case FOOTER:
            Footer footer = (Footer) target;
            if (id.equals(footer.getId())) {
                return target;
            }
            if (footer.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        footer.getContent()));
            }
            break;
        case HEADER:
            Header header = (Header) target;
            if (id.equals(header.getId())) {
                return target;
            }
            if (header.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        header.getContent()));
            }
            break;
        case KEYGEN:
            Keygen keygen = (Keygen) target;
            if (id.equals(keygen.getId())) {
                return target;
            }
            // empty element
            break;
        case MARK:
            Mark mark = (Mark) target;
            if (id.equals(mark.getId())) {
                return target;
            }
            if (mark.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        mark.getContent()));
            }
            break;
        case METER:
            Meter meter = (Meter) target;
            if (id.equals(meter.getId())) {
                return target;
            }
            if (meter.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        meter.getContent()));
            }
            break;
        case NAV:
            Nav nav = (Nav) target;
            if (id.equals(nav.getId())) {
                return target;
            }
            if (nav.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        nav.getContent()));
            }
            break;
        case OUTPUT:
            Output output = (Output) target;
            if (id.equals(output.getId())) {
                return target;
            }
            if (output.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        output.getContent()));
            }
            break;
        case PROGRESS:
            Progress progress = (Progress) target;
            if (id.equals(progress.getId())) {
                return target;
            }
            if (progress.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        progress.getContent()));
            }
            break;
        case RP:
            Rp rp = (Rp) target;
            if (id.equals(rp.getId())) {
                return target;
            }
            if (rp.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        rp.getContent()));
            }
            break;
        case RT:
            Rt rt = (Rt) target;
            if (id.equals(rt.getId())) {
                return target;
            }
            if (rt.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        rt.getContent()));
            }
            break;
        case RUBY:
            Ruby ruby = (Ruby) target;
            if (id.equals(ruby.getId())) {
                return target;
            }
            if (ruby.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        ruby.getContent()));
            }
            break;
        case SECTION:
            Section section = (Section) target;
            if (id.equals(section.getId())) {
                return target;
            }
            if (section.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        section.getContent()));
            }
            break;
        case SOURCE:
            Source source = (Source) target;
            if (id.equals(source.getId())) {
                return target;
            }
            // empty element
            break;
        case SUMMARY:
            Summary summary = (Summary) target;
            if (id.equals(summary.getId())) {
                return target;
            }
            if (summary.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        summary.getContent()));
            }
            break;
        case TIME:
            Time time = (Time) target;
            if (id.equals(time.getId())) {
                return target;
            }
            if (time.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        time.getContent()));
            }
            break;
        case TRACK:
            Track track = (Track) target;
            if (id.equals(track.getId())) {
                return target;
            }
            // empty element
            break;
        case VIDEO:
            Video video = (Video) target;
            if (id.equals(video.getId())) {
                return target;
            }
            if (video.isSetContent()) {
                result = CastUtil.<T> cast(getByIdWithinObjectList(id,
                        video.getContent()));
            }
            break;
        case WBR:
            Wbr wbr = (Wbr) target;
            if (id.equals(wbr.getId())) {
                return target;
            }
            // empty element
            break;
        }

        return result;
    }

}

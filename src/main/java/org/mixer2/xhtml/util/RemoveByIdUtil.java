package org.mixer2.xhtml.util;

import java.util.List;

import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.Abbr;
import org.mixer2.jaxb.xhtml.Acronym;
import org.mixer2.jaxb.xhtml.Address;
import org.mixer2.jaxb.xhtml.Applet;
import org.mixer2.jaxb.xhtml.Area;
import org.mixer2.jaxb.xhtml.Article;
import org.mixer2.jaxb.xhtml.Aside;
import org.mixer2.jaxb.xhtml.Audio;
import org.mixer2.jaxb.xhtml.B;
import org.mixer2.jaxb.xhtml.Bdi;
import org.mixer2.jaxb.xhtml.Bdo;
import org.mixer2.jaxb.xhtml.Big;
import org.mixer2.jaxb.xhtml.Blockquote;
import org.mixer2.jaxb.xhtml.Body;
import org.mixer2.jaxb.xhtml.Button;
import org.mixer2.jaxb.xhtml.Canvas;
import org.mixer2.jaxb.xhtml.Caption;
import org.mixer2.jaxb.xhtml.Center;
import org.mixer2.jaxb.xhtml.Cite;
import org.mixer2.jaxb.xhtml.Code;
import org.mixer2.jaxb.xhtml.Col;
import org.mixer2.jaxb.xhtml.Colgroup;
import org.mixer2.jaxb.xhtml.Datalist;
import org.mixer2.jaxb.xhtml.Dd;
import org.mixer2.jaxb.xhtml.Del;
import org.mixer2.jaxb.xhtml.Details;
import org.mixer2.jaxb.xhtml.Dfn;
import org.mixer2.jaxb.xhtml.Dir;
import org.mixer2.jaxb.xhtml.Div;
import org.mixer2.jaxb.xhtml.Dl;
import org.mixer2.jaxb.xhtml.Dt;
import org.mixer2.jaxb.xhtml.Em;
import org.mixer2.jaxb.xhtml.Fieldset;
import org.mixer2.jaxb.xhtml.Figcaption;
import org.mixer2.jaxb.xhtml.Figure;
import org.mixer2.jaxb.xhtml.Font;
import org.mixer2.jaxb.xhtml.Footer;
import org.mixer2.jaxb.xhtml.Form;
import org.mixer2.jaxb.xhtml.H1;
import org.mixer2.jaxb.xhtml.H2;
import org.mixer2.jaxb.xhtml.H3;
import org.mixer2.jaxb.xhtml.H4;
import org.mixer2.jaxb.xhtml.H5;
import org.mixer2.jaxb.xhtml.H6;
import org.mixer2.jaxb.xhtml.Head;
import org.mixer2.jaxb.xhtml.Header;
import org.mixer2.jaxb.xhtml.Hgroup;
import org.mixer2.jaxb.xhtml.Html;
import org.mixer2.jaxb.xhtml.I;
import org.mixer2.jaxb.xhtml.Iframe;
import org.mixer2.jaxb.xhtml.Ins;
import org.mixer2.jaxb.xhtml.Kbd;
import org.mixer2.jaxb.xhtml.Label;
import org.mixer2.jaxb.xhtml.Legend;
import org.mixer2.jaxb.xhtml.Li;
import org.mixer2.jaxb.xhtml.Map;
import org.mixer2.jaxb.xhtml.Mark;
import org.mixer2.jaxb.xhtml.Menu;
import org.mixer2.jaxb.xhtml.Meter;
import org.mixer2.jaxb.xhtml.Nav;
import org.mixer2.jaxb.xhtml.Noframes;
import org.mixer2.jaxb.xhtml.Noscript;
import org.mixer2.jaxb.xhtml.Ol;
import org.mixer2.jaxb.xhtml.Optgroup;
import org.mixer2.jaxb.xhtml.Option;
import org.mixer2.jaxb.xhtml.Output;
import org.mixer2.jaxb.xhtml.P;
import org.mixer2.jaxb.xhtml.Pre;
import org.mixer2.jaxb.xhtml.Progress;
import org.mixer2.jaxb.xhtml.Q;
import org.mixer2.jaxb.xhtml.Rp;
import org.mixer2.jaxb.xhtml.Rt;
import org.mixer2.jaxb.xhtml.Ruby;
import org.mixer2.jaxb.xhtml.S;
import org.mixer2.jaxb.xhtml.Samp;
import org.mixer2.jaxb.xhtml.Section;
import org.mixer2.jaxb.xhtml.Select;
import org.mixer2.jaxb.xhtml.Small;
import org.mixer2.jaxb.xhtml.Span;
import org.mixer2.jaxb.xhtml.Strike;
import org.mixer2.jaxb.xhtml.Strong;
import org.mixer2.jaxb.xhtml.Sub;
import org.mixer2.jaxb.xhtml.Summary;
import org.mixer2.jaxb.xhtml.Sup;
import org.mixer2.jaxb.xhtml.Table;
import org.mixer2.jaxb.xhtml.Tbody;
import org.mixer2.jaxb.xhtml.Td;
import org.mixer2.jaxb.xhtml.Tfoot;
import org.mixer2.jaxb.xhtml.Th;
import org.mixer2.jaxb.xhtml.Thead;
import org.mixer2.jaxb.xhtml.Time;
import org.mixer2.jaxb.xhtml.Tr;
import org.mixer2.jaxb.xhtml.Tt;
import org.mixer2.jaxb.xhtml.U;
import org.mixer2.jaxb.xhtml.Ul;
import org.mixer2.jaxb.xhtml.Var;
import org.mixer2.jaxb.xhtml.Video;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;

/**
 *
 * @see org.mixer2.xhtml.AbstractJaxb#removeById(String)
 * @author watanabe
 *
 */
public class RemoveByIdUtil {

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> boolean removeByIdWithinObjectList(
            String id, List<java.lang.Object> list) {

        java.lang.Object tmpobj;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            tmpobj = list.get(i);
            if (tmpobj instanceof AbstractJaxb) {
                if (id.equals(((AbstractJaxb) tmpobj).getId())) {
                    list.remove(i);
                    return true;
                } else {
                    if (removeById(id, (T) tmpobj)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static <T extends AbstractJaxb> boolean removeById(String id,
            T target) {
        TagEnum tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                .toUpperCase());

        if (id.equals(target.getId())) {
            return false;
        }

        switch (tagEnum) {
        case A:
            A a = (A) target;
            if (a.isSetContent()) {
                return removeByIdWithinObjectList(id, a.getContent());
            }
            break;
        case ABBR:
            Abbr abbr = (Abbr) target;
            if (abbr.isSetContent()) {
                return removeByIdWithinObjectList(id, abbr.getContent());
            }
            break;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            if (acronym.isSetContent()) {
                return removeByIdWithinObjectList(id, acronym.getContent());
            }
            break;
        case ADDRESS:
            Address address = (Address) target;
            if (address.isSetContent()) {
                return removeByIdWithinObjectList(id, address.getContent());
            }
            break;
        case APPLET:
            Applet applet = (Applet) target;
            if (applet.isSetContent()) {
                return removeByIdWithinObjectList(id, applet.getContent());
            }
            break;
        case AREA:
            // area is empty element.
            break;
        case B:
            B b = (B) target;
            if (b.isSetContent()) {
                return removeByIdWithinObjectList(id, b.getContent());
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
                return removeByIdWithinObjectList(id, bdo.getContent());
            }
            break;
        case BIG:
            Big big = (Big) target;
            if (big.isSetContent()) {
                return removeByIdWithinObjectList(id, big.getContent());
            }
            break;
        case BLOCKQUOTE:
            Blockquote blockquote = (Blockquote) target;
            if (blockquote.isSetContent()) {
                return removeByIdWithinObjectList(id, blockquote.getContent());
            }
            break;
        case BODY:
            Body body = (Body) target;
            if (body.isSetContent()) {
                return removeByIdWithinObjectList(id, body.getContent());
            }
            break;
        case BR:
            // empty element.
            break;
        case BUTTON:
            Button button = (Button) target;
            if (button.isSetContent()) {
                return removeByIdWithinObjectList(id, button.getContent());
            }
            break;
        case CAPTION:
            Caption caption = (Caption) target;
            if (caption.isSetContent()) {
                return removeByIdWithinObjectList(id, caption.getContent());
            }
            break;
        case CENTER:
            Center center = (Center) target;
            if (center.isSetContent()) {
                return removeByIdWithinObjectList(id, center.getContent());
            }
            break;
        case CITE:
            Cite cite = (Cite) target;
            if (cite.isSetContent()) {
                return removeByIdWithinObjectList(id, cite.getContent());
            }
            break;
        case CODE:
            Code code = (Code) target;
            if (code.isSetContent()) {
                return removeByIdWithinObjectList(id, code.getContent());
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
                        colgroup.getCol().remove(i);
                        return true;
                    }
                }
            }
            break;
        case DD:
            Dd dd = (Dd) target;
            if (dd.isSetContent()) {
                return removeByIdWithinObjectList(id, dd.getContent());
            }
            break;
        case DEL:
            Del del = (Del) target;
            if (del.isSetContent()) {
                return removeByIdWithinObjectList(id, del.getContent());
            }
            break;
        case DFN:
            Dfn dfn = (Dfn) target;
            if (dfn.isSetContent()) {
                return removeByIdWithinObjectList(id, dfn.getContent());
            }
            break;
        case DIR:
            Dir dir = (Dir) target;
            if (dir.isSetLi()) {
                for (int i = 0; i < dir.getLi().size(); i++) {
                    Li li = dir.getLi().get(i);
                    if (li.isSetId() && li.getId().equals(id)) {
                        dir.getLi().remove(i);
                        return true;
                    } else {
                        if (removeById(id, li)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case DIV:
            Div div = (Div) target;
            if (div.isSetContent()) {
                return removeByIdWithinObjectList(id, div.getContent());
            }
            break;
        case DL:
            Dl dl = (Dl) target;
            if (dl.isSetDtOrDd()) {
                for (int i = 0; i < dl.getDtOrDd().size(); i++) {
                    AbstractJaxb obj = dl.getDtOrDd().get(i);
                    if (id.equals(obj.getId())) {
                        dl.getDtOrDd().remove(i);
                        return true;
                    } else {
                        if (removeById(id, obj)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case DT:
            Dt dt = (Dt) target;
            if (dt.isSetContent()) {
                return removeByIdWithinObjectList(id, dt.getContent());
            }
            break;
        case EM:
            Em em = (Em) target;
            if (em.isSetId() && em.getId().equals(id)) {
                return false;
            }
            if (em.isSetContent()) {
                return removeByIdWithinObjectList(id, em.getContent());
            }
            break;
        case FIELDSET:
            Fieldset fieldset = (Fieldset) target;
            if (fieldset.isSetContent()) {
                return removeByIdWithinObjectList(id, fieldset.getContent());
            }
            break;
        case FONT:
            Font font = (Font) target;
            if (font.isSetContent()) {
                return removeByIdWithinObjectList(id, font.getContent());
            }
            break;
        case FORM:
            Form form = (Form) target;
            if (form.isSetContent()) {
                return removeByIdWithinObjectList(id, form.getContent());
            }
            break;
        case H1:
            H1 h1 = (H1) target;
            if (h1.isSetContent()) {
                return removeByIdWithinObjectList(id, h1.getContent());
            }
            break;
        case H2:
            H2 h2 = (H2) target;
            if (h2.isSetContent()) {
                return removeByIdWithinObjectList(id, h2.getContent());
            }
            break;
        case H3:
            H3 h3 = (H3) target;
            if (h3.isSetContent()) {
                return removeByIdWithinObjectList(id, h3.getContent());
            }
            break;
        case H4:
            H4 h4 = (H4) target;
            if (h4.isSetContent()) {
                return removeByIdWithinObjectList(id, h4.getContent());
            }
            break;
        case H5:
            H5 h5 = (H5) target;
            if (h5.isSetContent()) {
                return removeByIdWithinObjectList(id, h5.getContent());
            }
            break;
        case H6:
            H6 h6 = (H6) target;
            if (h6.isSetContent()) {
                return removeByIdWithinObjectList(id, h6.getContent());
            }
            break;
        case HGROUP:
            Hgroup hgroup = (Hgroup)target;
            if (hgroup.isSetH1OrH2OrH3()) {
                for (AbstractJaxb obj : hgroup.getH1OrH2OrH3()) {
                    if (removeById(id,obj)) {
                        return true;
                    }
                }
            }
            break;
        case HEAD:
            Head head = (Head) target;
            for (int j =0; j<head.getContent().size(); j++) {
                AbstractJaxb obj = head.getContent().get(j);
                if (id.equals(obj.getId())) {
                    head.getContent().remove(j);
                    return true;
                } else {
                    if (removeById(id, obj)) {
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
                if (removeById(id, html.getHead())) {
                    return true;
                }
            }
            if (html.isSetBody()) {
                if (removeById(id, html.getBody())) {
                    return true;
                }
            }
            break;
        case I:
            I i = (I) target;
            if (i.isSetContent()) {
                return removeByIdWithinObjectList(id, i.getContent());
            }
            break;
        case IFRAME:
            Iframe iframe = (Iframe) target;
            if (iframe.isSetContent()) {
                return removeByIdWithinObjectList(id, iframe.getContent());
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
                return removeByIdWithinObjectList(id, ins.getContent());
            }
            break;
        case ISINDEX:
            // empty element.
            break;
        case KBD:
            Kbd kbd = (Kbd) target;
            if (kbd.isSetContent()) {
                return removeByIdWithinObjectList(id, kbd.getContent());
            }
            break;
        case LABEL:
            Label label = (Label) target;
            if (label.isSetContent()) {
                return removeByIdWithinObjectList(id, label.getContent());
            }
            break;
        case LEGEND:
            Legend legend = (Legend) target;
            if (legend.isSetContent()) {
                return removeByIdWithinObjectList(id, legend.getContent());
            }
            break;
        case LI:
            Li li = (Li) target;
            if (li.isSetContent()) {
                return removeByIdWithinObjectList(id, li.getContent());
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
                        map.getArea().remove(j);
                        return true;
                    }
                    // area has no child element.
                }
            }
            if (map.isSetPOrH1OrH2()) {
                for (int k = 0; k < map.getPOrH1OrH2().size(); k++) {
                    AbstractJaxb obj = map.getPOrH1OrH2().get(k);
                    if (id.equals(obj.getId())) {
                        map.getPOrH1OrH2().remove(k);
                        return true;
                    } else {
                        if (removeById(id, obj)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case MENU:
            Menu menu = (Menu) target;
            if (menu.isSetContent()) {
                return removeByIdWithinObjectList(id, menu.getContent());
            }
            break;
        case META:
            // empty element.
            break;
        case NOFRAMES:
            Noframes noframes = (Noframes) target;
            if (noframes.isSetContent()) {
                return removeByIdWithinObjectList(id, noframes.getContent());
            }
            break;
        case NOSCRIPT:
            Noscript noscript = (Noscript) target;
            if (noscript.isSetContent()) {
                return removeByIdWithinObjectList(id, noscript.getContent());
            }
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
            if (object.isSetContent()) {
                return removeByIdWithinObjectList(id, object.getContent());
            }
            break;
        case OL:
            Ol ol = (Ol) target;
            if (ol.isSetLi()) {
                for (int j = 0; j < ol.getLi().size(); j++) {
                    Li li2 = ol.getLi().get(j);
                    if (li2.isSetId() && li2.getId().equals(id)) {
                        ol.getLi().remove(j);
                        return true;
                    } else {
                        if (removeById(id, li2)) {
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
                        optgroup.getOption().remove(j);
                        return true;
                    } else {
                        if (removeById(id, option)) {
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
                return removeByIdWithinObjectList(id, p.getContent());
            }
            break;
        case PARAM:
            // param is empty element.
            break;
        case PRE:
            Pre pre = (Pre) target;
            if (pre.isSetContent()) {
                return removeByIdWithinObjectList(id, pre.getContent());
            }
            break;
        case Q:
            Q q = (Q) target;
            if (q.isSetContent()) {
                return removeByIdWithinObjectList(id, q.getContent());
            }
            break;
        case S:
            S s = (S) target;
            if (s.isSetContent()) {
                return removeByIdWithinObjectList(id, s.getContent());
            }
            break;
        case SAMP:
            Samp samp = (Samp) target;
            if (samp.isSetContent()) {
                return removeByIdWithinObjectList(id, samp.getContent());
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
                        select.getOptgroupOrOption().remove(j);
                        return true;
                    } else {
                        if (removeById(id, obj)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case SMALL:
            Small small = (Small) target;
            if (small.isSetContent()) {
                return removeByIdWithinObjectList(id, small.getContent());
            }
            break;
        case SPAN:
            Span span = (Span) target;
            if (span.isSetContent()) {
                return removeByIdWithinObjectList(id, span.getContent());
            }
            break;
        case STRIKE:
            Strike strike = (Strike) target;
            if (strike.isSetContent()) {
                return removeByIdWithinObjectList(id, strike.getContent());
            }
            break;
        case STRONG:
            Strong strong = (Strong) target;
            if (strong.isSetContent()) {
                return removeByIdWithinObjectList(id, strong.getContent());
            }
            break;
        case STYLE:
            // has no other element.
            break;
        case SUB:
            Sub sub = (Sub) target;
            if (sub.isSetContent()) {
                return removeByIdWithinObjectList(id, sub.getContent());
            }
            break;
        case SUP:
            Sup sup = (Sup) target;
            if (sup.isSetContent()) {
                return removeByIdWithinObjectList(id, sup.getContent());
            }
            break;
        case TABLE:
            Table table = (Table) target;
            if (table.isSetCaption()) {
                Caption capt = table.getCaption();
                if (capt.isSetId() && id.equals(capt.getId())) {
                    table.setCaption(null);
                    return true;
                } else {
                    if (removeByIdWithinObjectList(id, capt.getContent())) {
                        return true;
                    }
                }
            }
            if (table.isSetCol()) {
                for (int j = 0; j < table.getCol().size(); j++) {
                    Col col2 = table.getCol().get(j);
                    if (col2.isSetId() && col2.getId().equals(id)) {
                        table.getCol().remove(j);
                        return true;
                    }
                }
            }
            if (table.isSetColgroup()) {
                for (int j = 0; j < table.getColgroup().size(); j++) {
                    Colgroup cg = table.getColgroup().get(j);
                    if (cg.isSetId() && cg.getId().equals(id)) {
                        table.getColgroup().remove(j);
                        return true;
                    }
                }
            }
            if (table.isSetTbody()) {
                for (int j = 0; j < table.getTbody().size(); j++) {
                    Tbody tbody = table.getTbody().get(j);
                    if (tbody.isSetId() && tbody.getId().equals(tbody)) {
                        table.getTbody().remove(j);
                        return true;
                    } else {
                        if (removeById(id, tbody)) {
                            return true;
                        }
                    }
                }
            }
            if (table.isSetThead()) {
                Thead thead = table.getThead();
                if (thead.isSetId() && thead.getId().equals(id)) {
                    table.setThead(null);
                    return true;
                } else {
                    if (removeById(id, thead)) {
                        return true;
                    }
                }
            }
            if (table.isSetTfoot()) {
                Tfoot tfoot = table.getTfoot();
                if (tfoot.isSetId() && tfoot.getId().equals(id)) {
                    table.setTfoot(null);
                    return true;
                } else {
                    if (removeById(id, tfoot)) {
                        return true;
                    }
                }
            }
            if (table.isSetTr()) {
                for (int j = 0; j < table.getTr().size(); j++) {
                    Tr tr = table.getTr().get(j);
                    if (tr.isSetId() && tr.getId().equals(id)) {
                        table.getTr().remove(j);
                        return true;
                    } else {
                        if (removeById(id, tr)) {
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
                        tbody.getTr().remove(j);
                        return true;
                    } else {
                        if (removeById(id, tr)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TD:
            Td td = (Td) target;
            if (td.isSetContent()) {
                return removeByIdWithinObjectList(id, td.getContent());
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
                        tfoot.getTr().remove(j);
                        return true;
                    } else {
                        if (removeById(id, tr)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TH:
            Th th = (Th) target;
            if (th.isSetContent()) {
                return removeByIdWithinObjectList(id, th.getContent());
            }
            break;
        case THEAD:
            Thead thead = (Thead) target;
            if (thead.isSetTr()) {
                for (int j = 0; j < thead.getTr().size(); j++) {
                    Tr tr = thead.getTr().get(j);
                    if (tr.isSetId() && tr.getId().equals(id)) {
                        thead.getTr().remove(j);
                        return true;
                    } else {
                        if (removeById(id, tr)) {
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
                    java.lang.Object obj = tr.getThOrTd().get(j);
                    if (obj.getClass().equals(Td.class)) {
                        td = (Td) obj;
                        if (td.isSetId() && td.getId().equals(id)) {
                            tr.getThOrTd().remove(j);
                            return true;
                        } else {
                            if (removeById(id, td)) {
                                return true;
                            }
                        }
                    }
                    if (obj.getClass().equals(Th.class)) {
                        th = (Th) obj;
                        if (th.isSetId() && th.getId().equals(id)) {
                            tr.getThOrTd().remove(j);
                            return true;
                        } else {
                            if (removeById(id, th)) {
                                return true;
                            }
                        }
                    }
                }
            }
            break;
        case TT:
            Tt tt = (Tt) target;
            if (tt.isSetContent()) {
                return removeByIdWithinObjectList(id, tt.getContent());
            }
            break;
        case U:
            U u = (U) target;
            if (u.isSetContent()) {
                return removeByIdWithinObjectList(id, u.getContent());
            }
            break;
        case UL:
            Ul ul = (Ul) target;
            if (ul.isSetLi()) {
                for (int j = 0; j < ul.getLi().size(); j++) {
                    Li li2 = ul.getLi().get(j);
                    if (li2.isSetId() && li2.getId().equals(id)) {
                        ul.getLi().remove(j);
                        return true;
                    } else {
                        if (removeById(id, li2)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case VAR:
            Var var = (Var) target;
            if (var.isSetContent()) {
                return removeByIdWithinObjectList(id, var.getContent());
            }
            break;
        case ARTICLE:
            Article article = (Article) target;
            if (article.isSetContent()) {
                return removeByIdWithinObjectList(id, article.getContent());
            }
            break;
        case ASIDE:
            Aside aside = (Aside) target;
            if (aside.isSetContent()) {
                return removeByIdWithinObjectList(id, aside.getContent());
            }
            break;
        case AUDIO:
            Audio audio = (Audio) target;
            if (audio.isSetContent()) {
                return removeByIdWithinObjectList(id, audio.getContent());
            }
            break;
        case BDI:
            Bdi bdi = (Bdi) target;
            if (bdi.isSetContent()) {
                return removeByIdWithinObjectList(id, bdi.getContent());
            }
            break;
        case CANVAS:
            Canvas canvas = (Canvas) target;
            if (canvas.isSetContent()) {
                return removeByIdWithinObjectList(id, canvas.getContent());
            }
            break;
        case COMMAND:
            // empty element.
            break;
        case DATALIST:
            Datalist datalist = (Datalist) target;
            if (datalist.isSetContent()) {
                return removeByIdWithinObjectList(id, datalist.getContent());
            }
            break;
        case DETAILS:
            Details details = (Details) target;
            if (details.isSetContent()) {
                return removeByIdWithinObjectList(id, details.getContent());
            }
            break;
        case EMBED:
            // empty element
            break;
        case FIGCAPTION:
            Figcaption figcaption = (Figcaption) target;
            if (figcaption.isSetContent()) {
                return removeByIdWithinObjectList(id, figcaption.getContent());
            }
            break;
        case FIGURE:
            Figure figure = (Figure) target;
            if (figure.isSetContent()) {
                return removeByIdWithinObjectList(id, figure.getContent());
            }
            break;
        case FOOTER:
            Footer footer = (Footer) target;
            if (footer.isSetContent()) {
                return removeByIdWithinObjectList(id, footer.getContent());
            }
            break;
        case HEADER:
            Header header = (Header) target;
            if (header.isSetContent()) {
                return removeByIdWithinObjectList(id, header.getContent());
            }
            break;
        case KEYGEN:
            // empty element
            break;
        case MARK:
            Mark mark = (Mark) target;
            if (mark.isSetContent()) {
                return removeByIdWithinObjectList(id, mark.getContent());
            }
            break;
        case METER:
            Meter meter = (Meter) target;
            if (meter.isSetContent()) {
                return removeByIdWithinObjectList(id, meter.getContent());
            }
            break;
        case NAV:
            Nav nav = (Nav) target;
            if (nav.isSetContent()) {
                return removeByIdWithinObjectList(id, nav.getContent());
            }
            break;
        case OUTPUT:
            Output output = (Output) target;
            if (output.isSetContent()) {
                return removeByIdWithinObjectList(id, output.getContent());
            }
            break;
        case PROGRESS:
            Progress progress = (Progress) target;
            if (progress.isSetContent()) {
                return removeByIdWithinObjectList(id, progress.getContent());
            }
            break;
        case RP:
            Rp rp = (Rp) target;
            if (rp.isSetContent()) {
                return removeByIdWithinObjectList(id, rp.getContent());
            }
            break;
        case RT:
            Rt rt = (Rt) target;
            if (rt.isSetContent()) {
                return removeByIdWithinObjectList(id, rt.getContent());
            }
            break;
        case RUBY:
            Ruby ruby = (Ruby) target;
            if (ruby.isSetContent()) {
                return removeByIdWithinObjectList(id, ruby.getContent());
            }
            break;
        case SECTION:
            Section section = (Section) target;
            if (section.isSetContent()) {
                return removeByIdWithinObjectList(id, section.getContent());
            }
            break;
        case SOURCE:
            // empty element
            break;
        case SUMMARY:
            Summary summary = (Summary) target;
            if (summary.isSetContent()) {
                return removeByIdWithinObjectList(id, summary.getContent());
            }
            break;
        case TIME:
            Time time = (Time) target;
            if (time.isSetContent()) {
                return removeByIdWithinObjectList(id, time.getContent());
            }
            break;
        case TRACK:
            // empty element
            break;
        case VIDEO:
            Video video = (Video) target;
            if (video.isSetContent()) {
                return removeByIdWithinObjectList(id, video.getContent());
            }
            break;
        case WBR:
            // empty element
            break;
        }

        return false;
    }

}

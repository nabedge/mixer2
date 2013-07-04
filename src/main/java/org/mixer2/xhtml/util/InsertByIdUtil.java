package org.mixer2.xhtml.util;

import java.util.List;
import java.util.ListIterator;

import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 *
 * @see org.mixer2.xhtml.AbstractJaxb#insertAfterId(String, String)
 * @see org.mixer2.xhtml.AbstractJaxb#insertAfterId(String, AbstractJaxb)
 * @see org.mixer2.xhtml.AbstractJaxb#insertBeforeId(String, String)
 * @see org.mixer2.xhtml.AbstractJaxb#insertBeforeId(String, AbstractJaxb)
 * @author watanabe
 *
 */
public class InsertByIdUtil {

    /**
     * 指定したid属性を持つ要素の次の要素としてinsObjectを挿入する なお、実際に挿入されるのはinsObjectのディープコピーです。
     *
     * @param <T>
     * @param id
     * @param insObject
     * @param target
     * @return
     * @throws TagTypeUnmatchException
     */
    public static <T extends AbstractJaxb> boolean insertAfterId(String id,
            T insObject, T target) throws TagTypeUnmatchException {
        return execute(OperationEnum.AFTER, id,
                insObject.copy(insObject.getClass()), target);
    }

    public static <T extends AbstractJaxb> boolean insertAfterId(String id,
            String insString, T target) throws TagTypeUnmatchException {
        return execute(OperationEnum.AFTER, id, insString, target);
    }

    public static <T extends AbstractJaxb> boolean insertBeforeId(String id,
            T insObject, T target) throws TagTypeUnmatchException {
        return execute(OperationEnum.BEFORE, id,
                insObject.copy(insObject.getClass()), target);
    }

    public static <T extends AbstractJaxb> boolean insertBeforeId(String id,
            String insString, T target) throws TagTypeUnmatchException {
        execute(OperationEnum.BEFORE, id, insString, target);
        return false;
    }

    private enum OperationEnum {
        AFTER, BEFORE;
    }

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> boolean executeWithinObjectList(
            OperationEnum opEnum, String id, java.lang.Object val,
            List<java.lang.Object> list) throws TagTypeUnmatchException {

        for (ListIterator<java.lang.Object> j = list.listIterator(); j
                .hasNext();) {
            java.lang.Object obj = j.next();
            if (obj instanceof AbstractJaxb) {
                if (id.equals(((AbstractJaxb) obj).getId())) {
                    switch (opEnum) {
                    case BEFORE:
                        int ii = j.previousIndex();
                        if (ii <= 0) {
                            list.add(0, val);
                        } else {
                            list.add(ii, val);
                        }
                        break;
                    case AFTER:
                        j.add(val);
                        break;
                    }
                    return true;
                } else {
                    if (execute(opEnum, id, val, (T) obj)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> boolean execute(
            OperationEnum opEnum, String id, java.lang.Object val, T target)
            throws TagTypeUnmatchException {

        TagEnum tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                .toUpperCase());

        TagEnum valTagEnum = null;
        if (val instanceof AbstractJaxb) {
            valTagEnum = TagEnum.valueOf(val.getClass().getSimpleName()
                    .toUpperCase());
        }

        int size = 0;

        switch (tagEnum) {
        case A:
            A a = (A) target;
            if (a.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, a.getContent())) {
                return true;
            }
            break;
        case ABBR:
            Abbr abbr = (Abbr) target;
            if (abbr.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            abbr.getContent())) {
                return true;
            }
            break;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            if (acronym.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            acronym.getContent())) {
                return true;
            }
            break;
        case ADDRESS:
            Address address = (Address) target;
            if (address.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            address.getContent())) {
                return true;
            }
            break;
        case APPLET:
            Applet applet = (Applet) target;
            if (applet.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            applet.getContent())) {
                return true;
            }
            break;
        case AREA:
            // empty element.
            break;
        case B:
            B b = (B) target;
            if (b.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, b.getContent())) {
                return true;
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
            if (bdo.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            bdo.getContent())) {
                return true;
            }
            break;
        case BIG:
            Big big = (Big) target;
            if (big.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            big.getContent())) {
                return true;
            }
            break;
        case BLOCKQUOTE:
            Blockquote blockquote = (Blockquote) target;
            if (blockquote.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            blockquote.getContent())) {
                return true;
            }
            break;
        case BODY:
            Body body = (Body) target;
            if (body.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            body.getContent())) {
                return true;
            }
            break;
        case BR:
            // empty element
            break;
        case BUTTON:
            Button button = (Button) target;
            if (button.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            button.getContent())) {
                return true;
            }
            break;
        case CAPTION:
            Caption caption = (Caption) target;
            if (caption.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            caption.getContent())) {
                return true;
            }
            break;
        case CENTER:
            Center center = (Center) target;
            if (center.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            center.getContent())) {
                return true;
            }
            break;
        case CITE:
            Cite cite = (Cite) target;
            if (cite.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            cite.getContent())) {
                return true;
            }
            break;
        case CODE:
            Code code = (Code) target;
            if (code.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            code.getContent())) {
                return true;
            }
            break;
        case COL:
            // empty element.
            break;
        case COLGROUP:
            Colgroup colgroup = (Colgroup) target;
            if (colgroup.isSetCol()) {
                for (ListIterator<Col> j = colgroup.getCol().listIterator(); j
                        .hasNext();) {
                    Col col = j.next();
                    if (id.equals(col.getId())) {
                        if (val.getClass().equals(Col.class)) {
                            switch (opEnum) {
                            case BEFORE:
                                int ii = j.previousIndex();
                                colgroup.getCol().add(ii, (Col) val);
                                break;
                            case AFTER:
                                j.add((Col) val);
                                break;
                            }
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Col.class,
                                    val.getClass());
                        }
                    }
                }
            }
            break;
        case DD:
            Dd dd = (Dd) target;
            if (dd.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, dd.getContent())) {
                return true;
            }
            break;
        case DEL:
            Del del = (Del) target;
            if (del.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            del.getContent())) {
                return true;
            }
            break;
        case DFN:
            Dfn dfn = (Dfn) target;
            if (dfn.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            dfn.getContent())) {
                return true;
            }
            break;
        case DIR:
            Dir dir = (Dir) target;
            if (dir.isSetLi()) {
                for (ListIterator<Li> j = dir.getLi().listIterator(); j
                        .hasNext();) {
                    Li li = j.next();
                    if (id.equals(li.getId())) {
                        if (val.getClass().equals(Li.class)) {
                            switch (opEnum) {
                            case BEFORE:
                                int ii = j.previousIndex();
                                dir.getLi().add(ii, (Li) val);
                                break;
                            case AFTER:
                                j.add((Li) val);
                                break;
                            }
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Li.class,
                                    val.getClass());
                        }
                    } else {
                        if (execute(opEnum, id, val, li)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case DIV:
            Div div = (Div) target;
            if (div.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            div.getContent())) {
                return true;
            }
            break;
        case DL:
            Dl dl = (Dl) target;
            if (dl.isSetDtOrDd()) {
                for (ListIterator<AbstractJaxb> j = dl.getDtOrDd()
                        .listIterator(); j.hasNext();) {
                    AbstractJaxb aj = j.next();
                    if (id.equals(aj.getId())) {
                        if (val instanceof AbstractJaxb) {
                            switch (opEnum) {
                            case BEFORE:
                                int ii = j.previousIndex();
                                dl.getDtOrDd().add(ii, (T) val);
                                break;
                            case AFTER:
                                j.add((Li) val);
                                break;
                            }
                            return true;
                        } else {

                        }
                    } else {
                        if (execute(opEnum, id, val, aj)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case DT:
            Dt dt = (Dt) target;
            if (dt.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, dt.getContent())) {
                return true;
            }
            break;
        case EM:
            Em em = (Em) target;
            if (em.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, em.getContent())) {
                return true;
            }
            break;
        case FIELDSET:
            Fieldset fieldset = (Fieldset) target;
            if (fieldset.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            fieldset.getContent())) {
                return true;
            }
            break;
        case FONT:
            Font font = (Font) target;
            if (font.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            font.getContent())) {
                return true;
            }
            break;
        case FORM:
            Form form = (Form) target;
            if (form.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            form.getContent())) {
                return true;
            }
            break;
        case H1:
            H1 h1 = (H1) target;
            if (h1.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, h1.getContent())) {
                return true;
            }
            break;
        case H2:
            H2 h2 = (H2) target;
            if (h2.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, h2.getContent())) {
                return true;
            }
            break;
        case H3:
            H3 h3 = (H3) target;
            if (h3.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, h3.getContent())) {
                return true;
            }
            break;
        case H4:
            H4 h4 = (H4) target;
            if (h4.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, h4.getContent())) {
                return true;
            }
            break;
        case H5:
            H5 h5 = (H5) target;
            if (h5.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, h5.getContent())) {
                return true;
            }
            break;
        case H6:
            H6 h6 = (H6) target;
            if (h6.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, h6.getContent())) {
                return true;
            }
            break;
        case HGROUP:
            Hgroup hgroup = (Hgroup) target;
            if (hgroup.isSetH1OrH2OrH3()) {
                for (ListIterator<Inline> j = hgroup.getH1OrH2OrH3()
                        .listIterator(); j.hasNext();) {
                    Inline inline = j.next();
                    if (id.equals(inline.getId())) {
                        if (val instanceof H1 || val instanceof H2
                                || val instanceof H3 || val instanceof H4
                                || val instanceof H5 || val instanceof H6) {
                            switch (opEnum) {
                            case BEFORE:
                                int ii = j.previousIndex();
                                hgroup.getH1OrH2OrH3().add(ii, (Inline) val);
                                break;
                            case AFTER:
                                j.add((Inline) val);
                                break;
                            }
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(
                                    "h1-h6以外のタグをhgroupにInsertしようとしました");
                        }
                    } else {
                        if (execute(opEnum, id, val, inline)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case HEAD:
            Head head = (Head) target;
            for (ListIterator<AbstractJaxb> j = head.getContent()
                    .listIterator(); j.hasNext();) {
                AbstractJaxb aj = j.next();
                if (id.equals(aj.getId())) {
                    if (val instanceof AbstractJaxb) {
                        switch (opEnum) {
                        case BEFORE:
                            int ii = j.previousIndex();
                            head.getContent().add(ii, (AbstractJaxb) val);
                            break;
                        case AFTER:
                            j.add((AbstractJaxb) val);
                            break;
                        }
                        return true;
                    } else {
                        throw new TagTypeUnmatchException(AbstractJaxb.class,
                                aj.getClass());
                    }
                } else {
                    if (execute(opEnum, id, val, aj)) {
                        return true;
                    }
                }
            }
            break;
        case HR:
            // empty element
            break;
        case HTML:
            Html html = (Html) target;
            if (html.isSetHead()) {
                if (execute(opEnum, id, val, html.getHead())) {
                    return true;
                }
            }
            if (html.isSetBody()) {
                if (execute(opEnum, id, val, html.getBody())) {
                    return true;
                }
            }
            break;
        case I:
            I i = (I) target;
            if (i.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, i.getContent())) {
                return true;
            }
            break;
        case IFRAME:
            Iframe iframe = (Iframe) target;
            if (iframe.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            iframe.getContent())) {
                return true;
            }
            break;
        case IMG:
            // empty element
            break;
        case INPUT:
            // empty element
            break;
        case INS:
            Ins ins = (Ins) target;
            if (ins.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            ins.getContent())) {
                return true;
            }
            break;
        case ISINDEX:
            // empty element.
            break;
        case KBD:
            Kbd kbd = (Kbd) target;
            if (kbd.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            kbd.getContent())) {
                return true;
            }
            break;
        case LABEL:
            Label label = (Label) target;
            if (label.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            label.getContent())) {
                return true;
            }
            break;
        case LEGEND:
            Legend legend = (Legend) target;
            if (legend.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            legend.getContent())) {
                return true;
            }
            break;
        case LI:
            Li li = (Li) target;
            if (li.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, li.getContent())) {
                return true;
            }
            break;
        case LINK:
            // empty element
            break;
        case MAP:
            Map map = (Map) target;
            if (map.isSetArea()) {
                for (ListIterator<Area> j = map.getArea().listIterator(); j
                        .hasNext();) {
                    Area area = j.next();
                    if (id.equals(area.getId())) {
                        if (val instanceof Area) {
                            switch (opEnum) {
                            case BEFORE:
                                int ii = j.previousIndex();
                                map.getArea().add(ii, (Area) val);
                                break;
                            case AFTER:
                                j.add((Area) val);
                                break;
                            }
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Area.class,
                                    val.getClass());
                        }
                    }
                }
            }
            if (map.isSetPOrH1OrH2()) {
                for (ListIterator<AbstractJaxb> j = map.getPOrH1OrH2()
                        .listIterator(); j.hasNext();) {
                    AbstractJaxb aj = j.next();
                    if (id.equals(aj.getId())) {
                        if (val instanceof AbstractJaxb) {
                            switch (opEnum) {
                            case BEFORE:
                                int ii = j.previousIndex();
                                map.getPOrH1OrH2().add(ii, (AbstractJaxb) val);
                                break;
                            case AFTER:
                                j.add((AbstractJaxb) val);
                                break;
                            }
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(
                                    AbstractJaxb.class, val.getClass());
                        }
                    } else {
                        if (execute(opEnum, id, val, aj)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case MENU:
            Menu menu = (Menu) target;
            if (menu.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            menu.getContent())) {
                return true;
            }
            break;
        case META:
            // empty element
            break;
        case NOFRAMES:
            Noframes noframes = (Noframes) target;
            if (noframes.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            noframes.getContent())) {
                return true;
            }
            break;
        case NOSCRIPT:
            Noscript noscript = (Noscript) target;
            if (noscript.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            noscript.getContent())) {
                return true;
            }
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
            if (object.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            object.getContent())) {
                return true;
            }
            break;
        case OL:
            Ol ol = (Ol) target;
            if (ol.isSetLi()) {
                for (ListIterator<Li> j = ol.getLi().listIterator(); j
                        .hasNext();) {
                    Li tmpli = j.next();
                    if (id.equals(tmpli.getId())) {
                        if (val instanceof Li) {
                            switch (opEnum) {
                            case BEFORE:
                                int ii = j.previousIndex();
                                ol.getLi().add(ii, (Li) val);
                                break;
                            case AFTER:
                                j.add((Li) val);
                                break;
                            }
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Li.class,
                                    val.getClass());
                        }
                    } else {
                        if (execute(opEnum, id, val, tmpli)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case OPTGROUP:
            Optgroup optgroup = (Optgroup) target;
            if (optgroup.isSetOption()) {
                for (ListIterator<Option> j = optgroup.getOption()
                        .listIterator(); j.hasNext();) {
                    Option op = j.next();
                    if (id.equals(op.getId())) {
                        if (val instanceof Option) {
                            switch (opEnum) {
                            case BEFORE:
                                int ii = j.previousIndex();
                                optgroup.getOption().add(ii, (Option) val);
                                break;
                            case AFTER:
                                j.add((Option) val);
                                break;
                            }
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(Option.class,
                                    val.getClass());
                        }
                    }
                }
            }
            break;
        case OPTION:
            // empty element
            break;
        case P:
            P p = (P) target;
            if (p.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, p.getContent())) {
                return true;
            }
            break;
        case PARAM:
            // empty element
            break;
        case PRE:
            Pre pre = (Pre) target;
            if (pre.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            pre.getContent())) {
                return true;
            }
            break;
        case Q:
            Q q = (Q) target;
            if (q.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, q.getContent())) {
                return true;
            }
            break;
        case S:
            S s = (S) target;
            if (s.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, s.getContent())) {
                return true;
            }
            break;
        case SAMP:
            Samp samp = (Samp) target;
            if (samp.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            samp.getContent())) {
                return true;
            }
            break;
        case SCRIPT:
            // String content only
            break;
        case SELECT:
            Select select = (Select) target;
            if (select.isSetOptgroupOrOption()) {
                for (ListIterator<AbstractJaxb> j = select
                        .getOptgroupOrOption().listIterator(); j.hasNext();) {
                    AbstractJaxb aj = j.next();
                    if (id.equals(aj.getId())) {
                        if (val instanceof Optgroup || val instanceof Option) {
                            switch (opEnum) {
                            case BEFORE:
                                int ii = j.previousIndex();
                                select.getOptgroupOrOption().add(ii,
                                        (AbstractJaxb) val);
                                break;
                            case AFTER:
                                j.add((AbstractJaxb) val);
                                break;
                            }
                            return true;
                        } else {
                            throw new TagTypeUnmatchException(
                                    "Option or Optgroup expected but "
                                            + aj.getClass());
                        }
                    } else {
                        if (execute(opEnum, id, val, aj)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case SMALL:
            Small small = (Small) target;
            if (small.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            small.getContent())) {
                return true;
            }
            break;
        case SPAN:
            Span span = (Span) target;
            if (span.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            span.getContent())) {
                return true;
            }
            break;
        case STRIKE:
            Strike strike = (Strike) target;
            if (strike.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            strike.getContent())) {
                return true;
            }
            break;
        case STRONG:
            Strong strong = (Strong) target;
            if (strong.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            strong.getContent())) {
                return true;
            }
            break;
        case STYLE:
            // String only content
            break;
        case SUB:
            Sub sub = (Sub) target;
            if (sub.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            sub.getContent())) {
                return true;
            }
            break;
        case SUP:
            Sup sup = (Sup) target;
            if (sup.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            sup.getContent())) {
                return true;
            }
            break;
        case TABLE:
            Table table = (Table) target;
            if (table.isSetCaption()) {
                // captionタグは必ずtableタグ内の一番先頭に入る
                // したがって前後関係を考えずに先頭に挿入する
                Caption cap = table.getCaption();
                if (cap.isSetId() && cap.getId().equals(id)) {
                    switch (valTagEnum) {
                    case COL:
                        table.getCol().add(0, (Col) val);
                        break;
                    case COLGROUP:
                        table.getColgroup().add(0, (Colgroup) val);
                        break;
                    case TBODY:
                        table.getTbody().add(0, (Tbody) val);
                        break;
                    case THEAD:
                        table.setThead((Thead) val);
                        break;
                    case TFOOT:
                        table.setTfoot((Tfoot) val);
                        break;
                    case TR:
                        table.getTr().add(0, (Tr) val);
                        break;
                    default:
                        throw new TagTypeUnmatchException(
                                "col/colgroup/thead/tfoot/tbody/tr expected but "
                                        + val.getClass());
                    }
                    return true;
                } else {
                    if (execute(opEnum, id, val, cap)) {
                        return true;
                    }
                }
            }
            if (table.isSetCol()) {
                // COLは、テーブル内で CAPTIONの後で THEADの前に来なければならない
                size = table.getCol().size();
                for (int j = 0; j < size; j++) {
                    Col col = table.getCol().get(j);
                    if (col.isSetId() && col.getId().equals(id)) {
                        int k = j;
                        switch (opEnum) {
                        case BEFORE:
                            k = j;
                            break;
                        case AFTER:
                            k = j + 1;
                            break;
                        }
                        switch (valTagEnum) {
                        case CAPTION:
                            table.setCaption((Caption) val);
                            break;
                        case COL:
                            table.getCol().add(k, (Col) val);
                            break;
                        case COLGROUP:
                            table.getColgroup().add((Colgroup) val);
                            break;
                        case TBODY:
                            table.getTbody().add((Tbody) val);
                            break;
                        case THEAD:
                            table.setThead((Thead) val);
                            break;
                        case TFOOT:
                            table.setTfoot((Tfoot) val);
                            break;
                        case TR:
                            table.getTr().add((Tr) val);
                            break;
                        default:
                            throw new TagTypeUnmatchException(
                                    "caption/col/colgroup/thead/tfoot/tbody/tr expected but "
                                            + val.getClass());
                        }
                        return true;
                    }
                }
            }
            if (table.isSetColgroup()) {
                // COLGROUPは、テーブル内で CAPTIONの後で THEADの前に来なければならない
                size = table.getColgroup().size();
                for (int j = 0; j < size; j++) {
                    Colgroup colg = table.getColgroup().get(j);
                    if (colg.isSetId() && colg.getId().equals(id)) {
                        int k = j;
                        switch (opEnum) {
                        case BEFORE:
                            k = j;
                            break;
                        case AFTER:
                            k = j + 1;
                            break;
                        }
                        switch (valTagEnum) {
                        case CAPTION:
                            table.setCaption((Caption) val);
                            break;
                        case COL:
                            table.getCol().add((Col) val);
                            break;
                        case COLGROUP:
                            table.getColgroup().add(k, (Colgroup) val);
                            break;
                        case TBODY:
                            table.getTbody().add((Tbody) val);
                            break;
                        case THEAD:
                            table.setThead((Thead) val);
                            break;
                        case TFOOT:
                            table.setTfoot((Tfoot) val);
                            break;
                        case TR:
                            table.getTr().add((Tr) val);
                            break;
                        default:
                            throw new TagTypeUnmatchException(
                                    "caption/col/colgroup/thead/tfoot/tbody/tr expected but "
                                            + val.getClass());
                        }
                        return true;
                    } else {
                        if (execute(opEnum, id, val, colg)) {
                            return true;
                        }
                    }
                }
            }
            if (table.isSetTbody()) {
                // tbodyの前後に入れられるのはcol,colgroup,tr,tfoot,thead,tbody
                size = table.getTbody().size();
                for (int j = 0; j < size; j++) {
                    Tbody tbody = table.getTbody().get(j);
                    if (tbody.isSetId() && tbody.getId().equals(id)) {
                        int k = j;
                        switch (opEnum) {
                        case BEFORE:
                            k = j;
                            break;
                        case AFTER:
                            k = j + 1;
                            break;
                        }
                        switch (valTagEnum) {
                        case CAPTION:
                            table.setCaption((Caption) val);
                            break;
                        case COL:
                            table.getCol().add((Col) val);
                            break;
                        case COLGROUP:
                            table.getColgroup().add((Colgroup) val);
                            break;
                        case TBODY:
                            table.getTbody().add(k, (Tbody) val);
                            break;
                        case THEAD:
                            table.setThead((Thead) val);
                            break;
                        case TFOOT:
                            table.setTfoot((Tfoot) val);
                            break;
                        case TR:
                            table.getTr().add((Tr) val);
                            break;
                        default:
                            throw new TagTypeUnmatchException(
                                    "caption/col/colgroup/thead/tfoot/tbody/tr expected but "
                                            + val.getClass());
                        }
                        return true;
                    } else {
                        if (execute(opEnum, id, val, tbody)) {
                            return true;
                        }
                    }
                }
            }
            if (table.isSetThead()) {
                // theadタグの前後に入れられるのはcol,colgroup,tfoot,tr,tbody
                Thead thead = table.getThead();
                if (thead.isSetId() && thead.getId().equals(id)) {
                    switch (valTagEnum) {
                    case CAPTION:
                        table.setCaption((Caption) val);
                        break;
                    case COL:
                        table.getCol().add((Col) val);
                        break;
                    case COLGROUP:
                        table.getColgroup().add((Colgroup) val);
                        break;
                    case TBODY:
                        table.getTbody().add((Tbody) val);
                        break;
                    case THEAD:
                        table.setThead((Thead) val);
                        break;
                    case TFOOT:
                        table.setTfoot((Tfoot) val);
                        break;
                    case TR:
                        table.getTr().add((Tr) val);
                        break;
                    default:
                        throw new TagTypeUnmatchException(
                                "caption/col/colgroup/thead/tfoot/tbody/tr expected but "
                                        + val.getClass());
                    }
                    return true;
                } else {
                    if (execute(opEnum, id, val, thead)) {
                        return true;
                    }
                }
            }
            if (table.isSetTfoot()) {
                Tfoot tfoot = table.getTfoot();
                if (tfoot.isSetId() && tfoot.getId().equals(id)) {
                    switch (valTagEnum) {
                    case CAPTION:
                        table.setCaption((Caption) val);
                        break;
                    case COL:
                        table.getCol().add((Col) val);
                        break;
                    case COLGROUP:
                        table.getColgroup().add((Colgroup) val);
                        break;
                    case TBODY:
                        table.getTbody().add((Tbody) val);
                        break;
                    case THEAD:
                        table.setThead((Thead) val);
                        break;
                    case TFOOT:
                        table.setTfoot((Tfoot) val);
                        break;
                    case TR:
                        table.getTr().add((Tr) val);
                        break;
                    default:
                        throw new TagTypeUnmatchException(
                                "caption/col/colgroup/thead/tfoot/tbody/tr expected but "
                                        + val.getClass());
                    }
                    return true;
                } else {
                    if (execute(opEnum, id, val, tfoot)) {
                        return true;
                    }
                }
            }
            if (table.isSetTr()) {
                // trタグの前後に入れられるのはcaption,col,colgroup,thead,tfoot,tr,tbody
                size = table.getTr().size();
                for (int j = 0; j < size; j++) {
                    Tr tr = table.getTr().get(j);
                    if (tr.isSetId() && tr.getId().equals(id)) {
                        int k = j;
                        switch (opEnum) {
                        case BEFORE:
                            k = j;
                            break;
                        case AFTER:
                            k = j + 1;
                            break;
                        }
                        switch (valTagEnum) {
                        case CAPTION:
                            table.setCaption((Caption) val);
                            break;
                        case COL:
                            table.getCol().add((Col) val);
                            break;
                        case COLGROUP:
                            table.getColgroup().add((Colgroup) val);
                            break;
                        case TBODY:
                            table.getTbody().add((Tbody) val);
                            break;
                        case THEAD:
                            table.setThead((Thead) val);
                            break;
                        case TFOOT:
                            table.setTfoot((Tfoot) val);
                            break;
                        case TR:
                            table.getTr().add(k, (Tr) val);
                            break;
                        default:
                            throw new TagTypeUnmatchException(
                                    "caption/col/colgroup/thead/tfoot/tbody/tr expected but "
                                            + val.getClass());
                        }
                        return true;
                    } else {
                        if (execute(opEnum, id, val, tr)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TBODY:
            Tbody tbody = (Tbody) target;
            if (tbody.isSetTr()) {
                size = tbody.getTr().size();
                for (int j = 0; j < size; j++) {
                    Tr tr = tbody.getTr().get(j);
                    if (tr.isSetId() && tr.getId().equals(id)) {
                        int k = j;
                        switch (opEnum) {
                        case BEFORE:
                            k = j;
                            break;
                        case AFTER:
                            k = j + 1;
                            break;
                        }
                        if (val instanceof Tr) {
                            tbody.getTr().add(k, (Tr) val);
                        } else {
                            throw new TagTypeUnmatchException(Tr.class,
                                    val.getClass());
                        }
                        return true;
                    } else {
                        if (execute(opEnum, id, val, tr)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TD:
            Td td = (Td) target;
            if (td.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, td.getContent())) {
                return true;
            }
            break;
        case TEXTAREA:
            // has only String content
            break;
        case TFOOT:
            Tfoot tfoot = (Tfoot) target;
            if (tfoot.isSetTr()) {
                size = tfoot.getTr().size();
                for (int j = 0; j < size; j++) {
                    Tr tr = tfoot.getTr().get(j);
                    if (tr.isSetId() && tr.getId().equals(id)) {
                        int k = j;
                        switch (opEnum) {
                        case BEFORE:
                            k = j;
                            break;
                        case AFTER:
                            k = j + 1;
                            break;
                        }
                        if (val instanceof Tr) {
                            tfoot.getTr().add(k, (Tr) val);
                        } else {
                            throw new TagTypeUnmatchException(Tr.class,
                                    val.getClass());
                        }
                        return true;
                    } else {
                        if (execute(opEnum, id, val, tr)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TH:
            Th th = (Th) target;
            if (th.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, th.getContent())) {
                return true;
            }
            break;
        case THEAD:
            Thead thead = (Thead) target;
            if (thead.isSetTr()) {
                size = thead.getTr().size();
                for (int j = 0; j < size; j++) {
                    Tr tr = thead.getTr().get(j);
                    if (tr.isSetId() && tr.getId().equals(id)) {
                        int k = j;
                        switch (opEnum) {
                        case BEFORE:
                            k = j;
                            break;
                        case AFTER:
                            k = j + 1;
                            break;
                        }
                        if (val instanceof Tr) {
                            thead.getTr().add(k, (Tr) val);
                        } else {
                            throw new TagTypeUnmatchException(Tr.class,
                                    val.getClass());
                        }
                        return true;
                    } else {
                        if (execute(opEnum, id, val, tr)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TITLE:
            // has only String content
            break;
        case TR:
            Tr tr = (Tr) target;
            if (tr.isSetThOrTd()) {
                size = tr.getThOrTd().size();
                for (int j = 0; j < size; j++) {
                    Flow flow = tr.getThOrTd().get(j);
                    if (id.equals(flow.getId())) {
                        int k = j;
                        switch (opEnum) {
                        case BEFORE:
                            k = j;
                            break;
                        case AFTER:
                            k = j + 1;
                            break;
                        }
                        if (val instanceof Td) {
                            tr.getThOrTd().add(k, (Td) val);
                        } else if (val instanceof Th) {
                            tr.getThOrTd().add(k, (Th) val);
                        } else {
                            throw new TagTypeUnmatchException(
                                    "Th or Td expcted but " + val.getClass());
                        }
                    } else {
                        if (execute(opEnum, id, val, flow)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case TT:
            Tt tt = (Tt) target;
            if (tt.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, tt.getContent())) {
                return true;
            }
            break;
        case U:
            U u = (U) target;
            if (u.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, u.getContent())) {
                return true;
            }
            break;
        case UL:
            Ul ul = (Ul) target;
            if (ul.isSetLi()) {
                for (ListIterator<Li> j = ul.getLi().listIterator(); j
                        .hasNext();) {
                    Li tmpli = j.next();
                    if (id.equals(tmpli.getId())) {
                        if (val instanceof Li) {
                            switch (opEnum) {
                            case BEFORE:
                                int ii = j.previousIndex();
                                ul.getLi().add(ii, (Li) val);
                                break;
                            case AFTER:
                                j.add((Li) val);
                                break;

                            }
                        } else {
                            throw new TagTypeUnmatchException(Li.class,
                                    val.getClass());
                        }
                    } else {
                        if (execute(opEnum, id, val, tmpli)) {
                            return true;
                        }
                    }
                }
            }
            break;
        case VAR:
            Var var = (Var) target;
            if (var.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            var.getContent())) {
                return true;
            }
            break;
        case ARTICLE:
            Article article = (Article) target;
            if (article.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            article.getContent())) {
                return true;
            }
            break;
        case ASIDE:
            Aside aside = (Aside) target;
            if (aside.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            aside.getContent())) {
                return true;
            }
            break;
        case AUDIO:
            Audio audio = (Audio) target;
            if (audio.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            audio.getContent())) {
                return true;
            }
            break;
        case BDI:
            Bdi bdi = (Bdi) target;
            if (bdi.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            bdi.getContent())) {
                return true;
            }
            break;
        case CANVAS:
            Canvas canvas = (Canvas) target;
            if (canvas.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            canvas.getContent())) {
                return true;
            }
            break;
        case COMMAND:
            // empty element
            break;
        case DATALIST:
            Datalist datalist = (Datalist) target;
            if (datalist.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            datalist.getContent())) {
                return true;
            }
            break;
        case DETAILS:
            Details details = (Details) target;
            if (details.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            details.getContent())) {
                return true;
            }
            break;
        case EMBED:
            // empty element
            break;
        case FIGCAPTION:
            Figcaption figcaption = (Figcaption) target;
            if (figcaption.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            figcaption.getContent())) {
                return true;
            }
            break;
        case FIGURE:
            Figure figure = (Figure) target;
            if (figure.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            figure.getContent())) {
                return true;
            }
            break;
        case FOOTER:
            Footer footer = (Footer) target;
            if (footer.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            footer.getContent())) {
                return true;
            }
            break;
        case HEADER:
            Header header = (Header) target;
            if (header.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            header.getContent())) {
                return true;
            }
            break;
        case KEYGEN:
            // empty element
            break;
        case MARK:
            Mark mark = (Mark) target;
            if (mark.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            mark.getContent())) {
                return true;
            }
            break;
        case METER:
            Meter meter = (Meter) target;
            if (meter.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            meter.getContent())) {
                return true;
            }
            break;
        case NAV:
            Nav nav = (Nav) target;
            if (nav.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            nav.getContent())) {
                return true;
            }
            break;
        case OUTPUT:
            Output output = (Output) target;
            if (output.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            output.getContent())) {
                return true;
            }
            break;
        case PROGRESS:
            Progress progress = (Progress) target;
            if (progress.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            progress.getContent())) {
                return true;
            }
            break;
        case RP:
            Rp rp = (Rp) target;
            if (rp.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, rp.getContent())) {
                return true;
            }
            break;
        case RT:
            Rt rt = (Rt) target;
            if (rt.isSetContent()
                    && executeWithinObjectList(opEnum, id, val, rt.getContent())) {
                return true;
            }
            break;
        case RUBY:
            Ruby ruby = (Ruby) target;
            if (ruby.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            ruby.getContent())) {
                return true;
            }
            break;
        case SECTION:
            Section section = (Section) target;
            if (section.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            section.getContent())) {
                return true;
            }
            break;
        case SOURCE:
            // empty element
            break;
        case SUMMARY:
            Summary summary = (Summary) target;
            if (summary.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            summary.getContent())) {
                return true;
            }
            break;
        case TIME:
            Time time = (Time) target;
            if (time.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            time.getContent())) {
                return true;
            }
            break;
        case TRACK:
            // empty element
            break;
        case VIDEO:
            Video video = (Video) target;
            if (video.isSetContent()
                    && executeWithinObjectList(opEnum, id, val,
                            video.getContent())) {
                return true;
            }
            break;
        case WBR:
            // empty element
            break;
        }

        return false;
    }

}

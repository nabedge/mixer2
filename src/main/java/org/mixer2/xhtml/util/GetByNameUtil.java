package org.mixer2.xhtml.util;

import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;

import java.util.ArrayList;
import java.util.List;

public class GetByNameUtil {

    /**
     *
     * @param target     objects for scan
     * @param resultList usually, pass new ArrayList
     * @param name       "name" property of tag
     * @param tagType    tag class
     * @param <T>        tag class type. (i.e. Input.class, Select.class ...)
     * @return
     */
    public static <T extends AbstractJaxb> List<T> getByNameAsList(T target,
                                                                   List<T> resultList, String name, Class<T> tagType) {
        return execute(target, resultList, tagType, name);
    }

    /**
     *
     * @param target     objects for scan
     * @param name       "name" property of tag
     * @param tagType    tag class
     * @param <T>        tag class type. (i.e. Input.class, Select.class ...)
     * @return
     */
    public static <T extends AbstractJaxb> T getByName(T target, String name, Class<T> tagType) {
        List<T> list = getByNameAsList(target, new ArrayList<T>(), name, tagType);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> List<T> execute(
            java.lang.Object target, List<T> resultList, Class<T> tagType, String name) {

        TagEnum tagEnum;

        if (name == null || name.length() < 1) {
            return resultList;
        }
        if (target instanceof AbstractJaxb) {
            tagEnum = TagEnum.valueOf(target.getClass().getSimpleName().toUpperCase());
        } else {
            return resultList;
        }

        switch (tagEnum) {
            // a, object, select, meta, iframe, param, applet, img,
            // map, input, select, textarea, fieldset, button, output
            case A:
                A a = (A) target;
                if (name.equals(a.getName())) {
                    resultList.add((T) a);
                }
                for (java.lang.Object obj : a.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case ABBR:
                Abbr abbr = (Abbr) target;
                for (java.lang.Object obj : abbr.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case ACRONYM:
                Acronym acronym = (Acronym) target;
                for (java.lang.Object obj : acronym.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case ADDRESS:
                Address address = (Address) target;
                for (java.lang.Object obj : address.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case APPLET:
                Applet applet = (Applet) target;
                if (name.equals(applet.getName())) {
                    resultList.add((T) applet);
                }
                for (java.lang.Object obj : applet.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case AREA:
                Area area = (Area) target;
                // empty element
                break;
            case B:
                B b = (B) target;
                for (java.lang.Object obj : b.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case BASE:
                Base base = (Base) target;
                // empty element.
                break;
            case BASEFONT:
                Basefont basefont = (Basefont) target;
                // empty element.
                break;
            case BDO:
                Bdo bdo = (Bdo) target;
                for (java.lang.Object obj : bdo.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case BIG:
                Big big = (Big) target;
                for (java.lang.Object obj : big.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case BLOCKQUOTE:
                Blockquote blockquote = (Blockquote) target;
                for (java.lang.Object obj : blockquote.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case BODY:
                Body body = (Body) target;
                for (java.lang.Object obj : body.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case BR:
                Br br = (Br) target;
                // empty element
                break;
            case BUTTON:
                Button button = (Button) target;
                if (name.equals(button.getName())) {
                    resultList.add((T) button);
                }
                for (java.lang.Object obj : button.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case CAPTION:
                Caption caption = (Caption) target;
                for (java.lang.Object obj : caption.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case CENTER:
                Center center = (Center) target;
                for (java.lang.Object obj : center.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case CITE:
                Cite cite = (Cite) target;
                for (java.lang.Object obj : cite.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case CODE:
                Code code = (Code) target;
                for (java.lang.Object obj : code.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case COL:
                Col col = (Col) target;
                // empty element
                break;
            case COLGROUP:
                Colgroup colgroup = (Colgroup) target;
                if (colgroup.isSetCol()) {
                    for (Col col1 : colgroup.getCol()) {
                        resultList = execute(col1, resultList, tagType, name);
                    }
                }
                break;
            case DD:
                Dd dd = (Dd) target;
                for (java.lang.Object obj : dd.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case DEL:
                Del del = (Del) target;
                for (java.lang.Object obj : del.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case DFN:
                Dfn dfn = (Dfn) target;
                for (java.lang.Object obj : dfn.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case DIR:
                Dir dir = (Dir) target;
                if (dir.isSetLi()) {
                    for (Li li : dir.getLi()) {
                        resultList = execute(li, resultList, tagType, name);
                    }
                }
                break;
            case DIV:
                Div div = (Div) target;
                for (java.lang.Object obj : div.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case DL:
                Dl dl = (Dl) target;
                if (dl.isSetDtOrDd()) {
                    for (java.lang.Object obj : dl.getDtOrDd()) {
                        resultList =  execute(obj, resultList, tagType, name);
                    }
                }
                break;
            case DT:
                Dt dt = (Dt) target;
                for (java.lang.Object obj : dt.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case EM:
                Em em = (Em) target;
                for (java.lang.Object obj : em.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case FIELDSET:
                Fieldset fieldset = (Fieldset) target;
                if (name.equals(fieldset.getName())) {
                    resultList.add((T) fieldset);
                }
                for (java.lang.Object obj : fieldset.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case FONT:
                Font font = (Font) target;
                for (java.lang.Object obj : font.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case FORM:
                Form form = (Form) target;
                for (java.lang.Object obj : form.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case H1:
                H1 h1 = (H1) target;
                for (java.lang.Object obj : h1.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case H2:
                H2 h2 = (H2) target;
                for (java.lang.Object obj : h2.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case H3:
                H3 h3 = (H3) target;
                for (java.lang.Object obj : h3.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case H4:
                H4 h4 = (H4) target;
                for (java.lang.Object obj : h4.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case H5:
                H5 h5 = (H5) target;
                for (java.lang.Object obj : h5.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case H6:
                H6 h6 = (H6) target;
                for (java.lang.Object obj : h6.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case HGROUP:
                Hgroup hgroup = (Hgroup) target;
                for (java.lang.Object obj : hgroup.getH1OrH2OrH3()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case HEAD:
                Head head = (Head) target;
                for (java.lang.Object obj : head.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case HR:
                Hr hr = (Hr) target;
                // empty element.
                break;
            case HTML:
                Html html = (Html) target;
                if (html.isSetHead()) {
                    resultList = execute(html.getHead(), resultList, tagType, name);
                }
                if (html.isSetBody()) {
                    resultList = execute(html.getBody(), resultList, tagType, name);
                }
                break;
            case I:
                I i = (I) target;
                for (java.lang.Object obj : i.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case IFRAME:
                Iframe iframe = (Iframe) target;
                if (name.equals(iframe.getName())) {
                    resultList.add((T) iframe);
                }
                for (java.lang.Object obj : iframe.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case IMG:
                Img img = (Img) target;
                if (name.equals(img.getName())) {
                    resultList.add((T) img);
                }
                // empty element
                break;
            case INPUT:
                Input input = (Input) target;
                if (name.equals(input.getName())) {
                    resultList.add((T) input);
                }
                // empty element
                break;
            case INS:
                Ins ins = (Ins) target;
                for (java.lang.Object obj : ins.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case ISINDEX:
                Isindex isindex = (Isindex) target;
                // empty element
                break;
            case KBD:
                Kbd kbd = (Kbd) target;
                for (java.lang.Object obj : kbd.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case LABEL:
                Label label = (Label) target;
                for (java.lang.Object obj : label.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case LEGEND:
                Legend legend = (Legend) target;
                for (java.lang.Object obj : legend.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case LI:
                Li li = (Li) target;
                for (java.lang.Object obj : li.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case LINK:
                Link link = (Link) target;
                // empty element.
                break;
            case MAIN:
                Main main = (Main) target;
                for (java.lang.Object obj : main.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case MAP:
                Map map = (Map) target;
                if (name.equals(map.getName())) {
                    resultList.add((T) map);
                }
                if (map.isSetArea()) {
                    for (java.lang.Object obj : map.getArea()) {
                        resultList = execute(obj, resultList, tagType, name);
                    }
                }
                if (map.isSetPOrH1OrH2()) {
                    for (java.lang.Object obj : map.getPOrH1OrH2()) {
                        resultList = execute(obj, resultList, tagType, name);
                    }
                }
                break;
            case MENU:
                Menu menu = (Menu) target;
                for (java.lang.Object obj : menu.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case META:
                Meta meta = (Meta) target;
                if (name.equals(meta.getName())) {
                    resultList.add((T) meta);
                }
                // empty element.
                break;
            case NOFRAMES:
                Noframes noframes = (Noframes) target;
                for (java.lang.Object obj : noframes.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case NOSCRIPT:
                Noscript noscript = (Noscript) target;
                for (java.lang.Object obj : noscript.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case OBJECT:
                org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
                if (name.equals(object.getName())) {
                    resultList.add((T) object);
                }
                for (java.lang.Object obj : object.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case OL:
                Ol ol = (Ol) target;
                if (ol.isSetLi()) {
                    for (Li li1 : ol.getLi()) {
                        resultList = execute(li1, resultList, tagType, name);
                    }
                }
                break;
            case OPTGROUP:
                Optgroup optgroup = (Optgroup) target;
                if (optgroup.isSetOption()) {
                    for (Option option : optgroup.getOption()) {
                        resultList = execute(option, resultList, tagType, name);
                    }
                }
                break;
            case OPTION:
                Option option = (Option) target;
                // empty element
                break;
            case P:
                P p = (P) target;
                for (java.lang.Object obj : p.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case PARAM:
                Param param = (Param) target;
                if (name.equals(param.getName())) {
                    resultList.add((T) param);
                }
                // empty element
                break;
            case PRE:
                Pre pre = (Pre) target;
                for (java.lang.Object obj : pre.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case Q:
                Q q = (Q) target;
                for (java.lang.Object obj : q.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case S:
                S s = (S) target;
                for (java.lang.Object obj : s.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case SAMP:
                Samp samp = (Samp) target;
                for (java.lang.Object obj : samp.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case SCRIPT:
                Script script = (Script) target;
                // empty element.
                break;
            case SELECT:
                Select select = (Select) target;
                if (name.equals(select.getName())) {
                    resultList.add((T) select);
                }
                if (select.isSetOptgroupOrOption()) {
                    for (java.lang.Object obj : select.getOptgroupOrOption()) {
                        resultList = execute(obj, resultList, tagType, name);
                    }
                }
                break;
            case SMALL:
                Small small = (Small) target;
                for (java.lang.Object obj : small.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case SPAN:
                Span span = (Span) target;
                for (java.lang.Object obj : span.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case STRIKE:
                Strike strike = (Strike) target;
                for (java.lang.Object obj : strike.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case STRONG:
                Strong strong = (Strong) target;
                for (java.lang.Object obj : strong.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case STYLE:
                Style style = (Style) target;
                break;
            case SUB:
                Sub sub = (Sub) target;
                for (java.lang.Object obj : sub.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case SUP:
                Sup sup = (Sup) target;
                for (java.lang.Object obj : sup.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case TABLE:
                Table table = (Table) target;
                if (table.isSetCaption()) {
                    resultList = execute(table.getCaption(), resultList, tagType, name);
                }
                if (table.isSetCol()) {
                    for (Col col1 : table.getCol()) {
                        resultList = execute(col1, resultList, tagType, name);
                    }
                }
                if (table.isSetColgroup()) {
                    for (Colgroup colgroup1 : table.getColgroup()) {
                        resultList = execute(colgroup1, resultList, tagType, name);
                    }
                }
                if (table.isSetTbody()) {
                    for (Tbody tmpTbody : table.getTbody()) {
                        resultList = execute(tmpTbody, resultList, tagType, name);
                    }
                }
                if (table.isSetThead()) {
                    resultList = execute(table.getThead(), resultList, tagType, name);
                }
                if (table.isSetTfoot()) {
                    resultList = execute(table.getTfoot(), resultList, tagType, name);
                }
                if (table.isSetTr()) {
                    for (Tr tr : table.getTr()) {
                        resultList = execute(tr, resultList, tagType, name);
                    }
                }
                break;
            case TBODY:
                Tbody tbody = (Tbody) target;
                if (tbody.isSetTr()) {
                    for (Tr tr : tbody.getTr()) {
                        resultList = execute(tr, resultList, tagType, name);
                    }
                }
                break;
            case TD:
                Td td = (Td) target;
                for (java.lang.Object obj : td.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case TEXTAREA:
                Textarea textarea = (Textarea) target;
                if (name.equals(textarea.getName())) {
                    resultList.add((T) textarea);
                }
                break;
            case TFOOT:
                Tfoot tfoot = (Tfoot) target;
                if (tfoot.isSetTr()) {
                    for (Tr tr : tfoot.getTr()) {
                        resultList = execute(tr, resultList, tagType, name);
                    }
                }
                break;
            case TH:
                Th th = (Th) target;
                for (java.lang.Object obj : th.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case THEAD:
                Thead thead = (Thead) target;
                if (thead.isSetTr()) {
                    for (Tr tr : thead.getTr()) {
                        resultList = execute(tr, resultList, tagType, name);
                    }
                }
                break;
            case TITLE:
                Title title = (Title) target;
                // empty element.
                break;
            case TR:
                Tr tr = (Tr) target;
                if (tr.isSetThOrTd()) {
                    for (java.lang.Object obj : tr.getThOrTd()) {
                        resultList = execute(obj, resultList, tagType, name);
                    }
                }
                break;
            case TT:
                Tt tt = (Tt) target;
                for (java.lang.Object obj : tt.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case U:
                U u = (U) target;
                for (java.lang.Object obj : u.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case UL:
                Ul ul = (Ul) target;
                if (ul.isSetLi()) {
                    for (Li li1 : ul.getLi()) {
                        resultList = execute(li1, resultList, tagType, name);
                    }
                }
                break;
            case VAR:
                Var var = (Var) target;
                for (java.lang.Object obj : var.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case ARTICLE:
                Article article = (Article) target;
                for (java.lang.Object obj : article.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case ASIDE:
                Aside aside = (Aside) target;
                for (java.lang.Object obj : aside.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case AUDIO:
                Audio audio = (Audio) target;
                for (java.lang.Object obj : audio.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case BDI:
                Bdi bdi = (Bdi) target;
                for (java.lang.Object obj : bdi.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case CANVAS:
                Canvas canvas = (Canvas) target;
                for (java.lang.Object obj : canvas.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case COMMAND:
                Command command = (Command) target;
                // empty tag
                break;
            case DATALIST:
                Datalist datalist = (Datalist) target;
                for (java.lang.Object obj : datalist.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case DETAILS:
                Details details = (Details) target;
                for (java.lang.Object obj : details.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case EMBED:
                Embed embed = (Embed) target;
                // empty tag
                break;
            case FIGCAPTION:
                Figcaption figcaption = (Figcaption) target;
                for (java.lang.Object obj : figcaption.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case FIGURE:
                Figure figure = (Figure) target;
                for (java.lang.Object obj : figure.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case FOOTER:
                Footer footer = (Footer) target;
                for (java.lang.Object obj : footer.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case HEADER:
                Header header = (Header) target;
                for (java.lang.Object obj : header.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case KEYGEN:
                Keygen keygen = (Keygen) target;
                // empty element
                break;
            case MARK:
                Mark mark = (Mark) target;
                for (java.lang.Object obj : mark.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case METER:
                Meter meter = (Meter) target;
                for (java.lang.Object obj : meter.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case NAV:
                Nav nav = (Nav) target;
                for (java.lang.Object obj : nav.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case OUTPUT:
                Output output = (Output) target;
                if (name.equals(output.getName())) {
                    resultList.add((T) output);
                }
                for (java.lang.Object obj : output.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case PROGRESS:
                Progress progress = (Progress) target;
                for (java.lang.Object obj : progress.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case RP:
                Rp rp = (Rp) target;
                for (java.lang.Object obj : rp.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case RT:
                Rt rt = (Rt) target;
                for (java.lang.Object obj : rt.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case RUBY:
                Ruby ruby = (Ruby) target;
                for (java.lang.Object obj : ruby.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case SECTION:
                Section section = (Section) target;
                for (java.lang.Object obj : section.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case SOURCE:
                Source source = (Source) target;
                // empty element
                break;
            case SUMMARY:
                Summary summary = (Summary) target;
                for (java.lang.Object obj : summary.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case TIME:
                Time time = (Time) target;
                for (java.lang.Object obj : time.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case TRACK:
                Track track = (Track) target;
                // empty element
                break;
            case VIDEO:
                Video video = (Video) target;
                for (java.lang.Object obj : video.getContent()) {
                    resultList = execute(obj, resultList, tagType, name);
                }
                break;
            case WBR:
                Wbr wbr = (Wbr) target;
                // empty element
                break;
        }
        return resultList;
    }
}

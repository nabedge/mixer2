package org.mixer2.xhtml.util;

import java.util.ArrayList;
import java.util.Collection;
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
 * @see org.mixer2.xhtml.AbstractJaxb#replaceInner(String)
 * @see org.mixer2.xhtml.AbstractJaxb#replaceInner(AbstractJaxb)
 * @see 
 *      org.mixer2.xhtml.AbstractJaxb#replaceContent(java.util.List<java.lang.Object
 *      >)
 * 
 * @author nabedge/watanabe
 *
 */
public class ReplaceInnerUtil {

    @SuppressWarnings("unused")
    private static Log log = LogFactory.getLog(ReplaceInnerUtil.class);

    public static <T extends AbstractJaxb> void replaceInner(T target,
            T replacement) throws TagTypeUnmatchException {
        execute(target,replacement);
    }

    public static <T extends AbstractJaxb> void replaceInner(T target,
            String replacement) throws TagTypeUnmatchException {
        execute(target,replacement);
    }

    public static <T extends AbstractJaxb> void replaceInner(T target,
            List<java.lang.Object> replacement) throws TagTypeUnmatchException {
        execute(target,replacement);
    }

    @SuppressWarnings("unchecked")
    private static void replaceContent(List<java.lang.Object> list, java.lang.Object replacement) {
        list.clear();
        if (replacement instanceof List) {
            list.addAll((Collection<? extends java.lang.Object>) replacement);
        } else {
            list.add(replacement);
        }
    }
    
    @SuppressWarnings({ "unchecked", "unused" })
    private static <T extends AbstractJaxb> void execute(T target,
            java.lang.Object replacement) throws TagTypeUnmatchException {

        TagEnum tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                .toUpperCase());

        switch (tagEnum) {
        case A:
            A a = (A) target;
            replaceContent(a.getContent(), replacement);
            break;
        case ABBR:
            Abbr abbr = (Abbr) target;
            // TODO
            break;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            // TODO
            break;
        case ADDRESS:
            Address address = (Address) target;
            // TODO
            break;
        case APPLET:
            Applet applet = (Applet) target;
            // TODO
            break;
        case AREA:
            Area area = (Area) target;
            // empty tag
            break;
        case B:
            B b = (B) target;
            // TODO
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
            // TODO
            break;
        case BIG:
            Big big = (Big) target;
            // TODO
            break;
        case BLOCKQUOTE:
            Blockquote blockquote = (Blockquote) target;
            // TODO
            break;
        case BODY:
            Body body = (Body) target;
            // TODO
            break;
        case BR:
            Br br = (Br) target;
            // empty element
            break;
        case BUTTON:
            Button button = (Button) target;
            // TODO
            break;
        case CAPTION:
            Caption caption = (Caption) target;
            // TODO
            break;
        case CENTER:
            Center center = (Center) target;
            // TODO
            break;
        case CITE:
            Cite cite = (Cite) target;
            // TODO
            break;
        case CODE:
            Code code = (Code) target;
            // TODO
            break;
        case COL:
            Col col = (Col) target;
            // empty element
            break;
        case COLGROUP:
            Colgroup colgroup = (Colgroup) target;
            colgroup.unsetCol();
            if (replacement instanceof Col) {
                colgroup.getCol().add((Col)replacement);
            }
            if (replacement instanceof List<?>) {
                colgroup.getCol().addAll((Collection<? extends Col>) replacement);
            }
            break;
        case DD:
            Dd dd = (Dd) target;
            // TODO
            break;
        case DEL:
            Del del = (Del) target;
            // TODO
            break;
        case DFN:
            Dfn dfn = (Dfn) target;
            // TODO
            break;
        case DIR:
            Dir dir = (Dir) target;
            // TODO
            // if (match(dir.getClass(), dir.getCssClass(), tagType, clazz)) {
            // return;
            // }
            // if (dir.isSetLi()) {
            // for (ListIterator<Li> i = dir.getLi().listIterator(); i
            // .hasNext();) {
            // Li li = i.next();
            // if (match(li.getClass(), li.getCssClass(), tagType, clazz)) {
            // if (replace.getClass().equals(Li.class)) {
            // i.set(((Li) replace).copy(Li.class));
            // } else {
            // throw new TagTypeUnmatchException(Li.class,
            // replace.getClass());
            // }
            // } else {
            // replaceDescendantsWithinObjectList(li.getContent(),
            // tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case DIV:
            Div div = (Div) target;
            // TODO
            break;
        case DL:
            Dl dl = (Dl) target;
            // TODO
            // if (match(dl.getClass(), dl.getCssClass(), tagType, clazz)) {
            // return;
            // }
            // if (dl.isSetDtOrDd()) {
            // for (ListIterator<AbstractJaxb> i = dl.getDtOrDd()
            // .listIterator(); i.hasNext();) {
            // AbstractJaxb aj = i.next();
            // if (match(aj.getClass(), aj.getCssClass(), tagType,
            // clazz)) {
            // if (replace.getClass().equals(Dt.class)) {
            // i.set(((Dt) replace).copy(Dt.class));
            // } else if (replace.getClass().equals(Dd.class)) {
            // i.set(((Dd) replace).copy(Dd.class));
            // } else {
            // throw new TagTypeUnmatchException(
            // "Dt or Dd expected but replace is "
            // + replace.getClass());
            // }
            // } else {
            // execute(aj, tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case DT:
            Dt dt = (Dt) target;
            // TODO
            break;
        case EM:
            Em em = (Em) target;
            // TODO
            break;
        case FIELDSET:
            Fieldset fieldset = (Fieldset) target;
            // TODO
            break;
        case FONT:
            Font font = (Font) target;
            break;
        case FORM:
            Form form = (Form) target;
            break;
        case H1:
            H1 h1 = (H1) target;
            break;
        case H2:
            H2 h2 = (H2) target;
            break;
        case H3:
            H3 h3 = (H3) target;
            break;
        case H4:
            H4 h4 = (H4) target;
            break;
        case H5:
            H5 h5 = (H5) target;
            break;
        case H6:
            H6 h6 = (H6) target;
            break;
        case HGROUP:
            Hgroup hgroup = (Hgroup) target;
            // if (match(hgroup.getClass(), hgroup.getCssClass(), tagType,
            // clazz)) {
            // return;
            // }
            // if (hgroup.isSetH1OrH2OrH3()) {
            // for (ListIterator<Inline> i =
            // hgroup.getH1OrH2OrH3().listIterator(); i.hasNext();) {
            // Inline inline = i.next();
            // if (match(inline.getClass(), inline.getCssClass(), tagType,
            // clazz)) {
            // if (replace instanceof H1 ||replace instanceof H2 ||replace
            // instanceof H3 ||replace instanceof H4 ||replace instanceof H5
            // ||replace instanceof H6) {
            // cls = ((T) replace).getClass();
            // i.set((Inline) ((T) replace).copy(cls));
            // } else {
            // throw new
            // TagTypeUnmatchException("h1-h6 expected but replace is " +
            // replace.getClass());
            // }
            // } else {
            // execute(inline, tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case HEAD:
            Head head = (Head) target;
            break;
        case HR:
            Hr hr = (Hr) target;
            // empty element.
            break;
        case HTML:
            Html html = (Html) target;
            // if (html.isSetHead()) {
            // execute(html.getHead(), tagType, clazz, replace);
            // }
            // if (html.isSetBody()) {
            // execute(html.getBody(), tagType, clazz, replace);
            // }
            break;
        case I:
            I i = (I) target;
            break;
        case IFRAME:
            Iframe iframe = (Iframe) target;
            break;
        case IMG:
            Img img = (Img) target;
            // empty element
            break;
        case INPUT:
            Input input = (Input) target;
            // empty element
            break;
        case INS:
            Ins ins = (Ins) target;
            break;
        case ISINDEX:
            Isindex isindex = (Isindex) target;
            // empty element
            break;
        case KBD:
            Kbd kbd = (Kbd) target;
            break;
        case LABEL:
            Label label = (Label) target;
            break;
        case LEGEND:
            Legend legend = (Legend) target;
            break;
        case LI:
            Li li = (Li) target;
            break;
        case LINK:
            Link link = (Link) target;
            // empty element.
            break;
        case MAP:
            Map map = (Map) target;
            // if (match(map.getClass(), map.getCssClass(), tagType, clazz)) {
            // return;
            // }
            // if (map.isSetArea()) {
            // for (ListIterator<Area> j = map.getArea().listIterator(); j
            // .hasNext();) {
            // Area tmparea = j.next();
            // if (match(tmparea.getClass(), tmparea.getCssClass(),
            // tagType, clazz)) {
            // if (replace.getClass().equals(Area.class)) {
            // j.set(((Area) replace).copy(Area.class));
            // } else {
            // throw new TagTypeUnmatchException(Area.class,
            // replace.getClass());
            // }
            // }
            // }
            // }
            // if (map.isSetPOrH1OrH2()) {
            // for (ListIterator<AbstractJaxb> j = map.getPOrH1OrH2()
            // .listIterator(); j.hasNext();) {
            // AbstractJaxb aj = j.next();
            // if (match(aj.getClass(), aj.getCssClass(), tagType,
            // clazz)) {
            // if (replace instanceof AbstractJaxb) {
            // cls = replace.getClass();
            // j.set(((T) replace).copy(cls));
            // } else {
            // throw new TagTypeUnmatchException(
            // "map object can not include "
            // + replace.getClass());
            // }
            // } else {
            // execute(aj, tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case MENU:
            Menu menu = (Menu) target;
            break;
        case META:
            Meta meta = (Meta) target;
            // empty element.
            break;
        case NOFRAMES:
            Noframes noframes = (Noframes) target;
            break;
        case NOSCRIPT:
            Noscript noscript = (Noscript) target;
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
            break;
        case OL:
            Ol ol = (Ol) target;
            // if (match(ol.getClass(), ol.getCssClass(), tagType, clazz)) {
            // return;
            // }
            // if (ol.isSetLi()) {
            // for (ListIterator<Li> j = ol.getLi().listIterator(); j
            // .hasNext();) {
            // Li li2 = j.next();
            // if (match(li2.getClass(), li2.getCssClass(), tagType, clazz)) {
            // if (replace.getClass().equals(Li.class)) {
            // j.set(((Li) replace).copy(Li.class));
            // } else {
            // throw new TagTypeUnmatchException(Li.class,
            // replace.getClass());
            // }
            // } else {
            // replaceDescendantsWithinObjectList(li2.getContent(),
            // tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case OPTGROUP:
            Optgroup optgroup = (Optgroup) target;
            // if (match(optgroup.getClass(), optgroup.getCssClass(), tagType,
            // clazz)) {
            // return;
            // }
            // if (optgroup.isSetOption()) {
            // for (ListIterator<Option> j = optgroup.getOption()
            // .listIterator(); j.hasNext();) {
            // Option op = j.next();
            // if (match(op.getClass(), op.getCssClass(), tagType, clazz)) {
            // if (replace.getClass().equals(Option.class)) {
            // j.set(((Option) replace).copy(Option.class));
            // } else {
            // throw new TagTypeUnmatchException(Option.class,
            // replace.getClass());
            // }
            // }
            // }
            // }
            break;
        case OPTION:
            Option option = (Option) target;
            // empty element
            break;
        case P:
            P p = (P) target;
            break;
        case PARAM:
            Param param = (Param) target;
            // empty element
            break;
        case PRE:
            Pre pre = (Pre) target;
            break;
        case Q:
            Q q = (Q) target;
            break;
        case S:
            S s = (S) target;
            break;
        case SAMP:
            Samp samp = (Samp) target;
            break;
        case SCRIPT:
            Script script = (Script) target;
            // TODO repalcementはString型のみ！
            break;
        case SELECT:
            Select select = (Select) target;
            // if (match(select.getClass(), select.getCssClass(), tagType,
            // clazz)) {
            // return;
            // }
            // if (select.isSetOptgroupOrOption()) {
            // for (ListIterator<AbstractJaxb> j = select
            // .getOptgroupOrOption().listIterator(); j.hasNext();) {
            // AbstractJaxb aj = j.next();
            // if (match(aj.getClass(), aj.getCssClass(), tagType,
            // clazz)) {
            // if (replace.getClass().equals(Optgroup.class)) {
            // j.set(((Optgroup) replace).copy(Optgroup.class));
            // } else if (replace.getClass().equals(Option.class)) {
            // j.set(((Option) replace).copy(Option.class));
            // } else {
            // throw new TagTypeUnmatchException(
            // "optgroup or option expected but replace is "
            // + replace.getClass());
            // }
            // } else {
            // execute(aj, tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case SMALL:
            Small small = (Small) target;
            break;
        case SPAN:
            Span span = (Span) target;
            break;
        case STRIKE:
            Strike strike = (Strike) target;
            break;
        case STRONG:
            Strong strong = (Strong) target;
            break;
        case STYLE:
            Style style = (Style) target;
            // 中身はStringのみ!
            break;
        case SUB:
            Sub sub = (Sub) target;
            break;
        case SUP:
            Sup sup = (Sup) target;
            break;
        case TABLE:
            Table table = (Table) target;
            // if (match(table.getClass(), table.getCssClass(), tagType, clazz))
            // {
            // return;
            // }
            // if (table.isSetCaption()) {
            // if (match(table.getCaption().getClass(), table.getCaption()
            // .getCssClass(), tagType, clazz)) {
            // table.setCaption(((Caption) replace).copy(Caption.class));
            // }
            // }
            //
            // if (table.isSetCol()) {
            // for (ListIterator<Col> j = table.getCol().listIterator(); j
            // .hasNext();) {
            // Col col1 = j.next();
            // if (match(col1.getClass(), col1.getCssClass(), tagType,
            // clazz)) {
            // if (replace.getClass().equals(Col.class)) {
            // j.set(((Col) replace).copy(Col.class));
            // } else {
            // throw new TagTypeUnmatchException(Col.class,
            // replace.getClass());
            // }
            // }
            // }
            // }
            // if (table.isSetColgroup()) {
            // for (ListIterator<Colgroup> j = table.getColgroup()
            // .listIterator(); j.hasNext();) {
            // Colgroup cg = j.next();
            // if (match(cg.getClass(), cg.getCssClass(), tagType, clazz)) {
            // if (replace.getClass().equals(Colgroup.class)) {
            // j.set(((Colgroup) replace).copy(Colgroup.class));
            // } else {
            // throw new TagTypeUnmatchException(Colgroup.class,
            // replace.getClass());
            // }
            // } else {
            // execute(cg, tagType, clazz, replace);
            // }
            // }
            // }
            // if (table.isSetTbody()) {
            // for (ListIterator<Tbody> j = table.getTbody().listIterator(); j
            // .hasNext();) {
            // Tbody tbody = j.next();
            // if (match(tbody.getClass(), tbody.getCssClass(), tagType,
            // clazz)) {
            // if (replace.getClass().equals(Tbody.class)) {
            // j.set(((Tbody) replace).copy(Tbody.class));
            // } else {
            // throw new TagTypeUnmatchException(
            // "Tbody,Tr expected but "
            // + replace.getClass());
            // }
            // } else {
            // execute(tbody, tagType, clazz, replace);
            // }
            // }
            // }
            // if (table.isSetThead()) {
            // if (match(Head.class, table.getThead().getCssClass(), tagType,
            // clazz)) {
            // table.setThead(((Thead) replace).copy(Thead.class));
            // }
            // }
            // if (table.isSetTfoot()) {
            // if (match(Tfoot.class, table.getTfoot().getCssClass(), tagType,
            // clazz)) {
            // table.setTfoot(((Tfoot) replace).copy(Tfoot.class));
            // }
            // }
            // if (table.isSetTr()) {
            // for (ListIterator<Tr> j = table.getTr().listIterator(); j
            // .hasNext();) {
            // Tr tr = j.next();
            // if (match(Tr.class, tr.getCssClass(), tagType, clazz)) {
            // if (replace.getClass().equals(Tr.class)) {
            // j.set(((Tr) replace).copy(Tr.class));
            // } else {
            // throw new TagTypeUnmatchException(Tr.class,
            // replace.getClass());
            // }
            // } else {
            // execute(tr, tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case TBODY:
            Tbody tbody = (Tbody) target;
            // if (match(tbody.getClass(), tbody.getCssClass(), tagType, clazz))
            // {
            // return;
            // }
            // if (tbody.isSetTr()) {
            // for (ListIterator<Tr> j = tbody.getTr().listIterator(); j
            // .hasNext();) {
            // Tr tr = j.next();
            // if (match(Tr.class, tr.getCssClass(), tagType, clazz)) {
            // if (replace.getClass().equals(Tr.class)) {
            // j.set(((Tr) replace).copy(Tr.class));
            // } else {
            // throw new TagTypeUnmatchException(Tr.class,
            // replace.getClass());
            // }
            // } else {
            // execute(tr, tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case TD:
            Td td = (Td) target;
            break;
        case TEXTAREA:
            Textarea textarea = (Textarea) target;
            // TODO 中身はStringのみ！
            break;
        case TFOOT:
            Tfoot tfoot = (Tfoot) target;
            // if (match(tfoot.getClass(), tfoot.getCssClass(), tagType, clazz))
            // {
            // return;
            // }
            // if (tfoot.isSetTr()) {
            // for (ListIterator<Tr> j = tfoot.getTr().listIterator(); j
            // .hasNext();) {
            // Tr tr = j.next();
            // if (match(Tr.class, tr.getCssClass(), tagType, clazz)) {
            // if (replace.getClass().equals(Tr.class)) {
            // j.set(((Tr) replace).copy(Tr.class));
            // } else {
            // throw new TagTypeUnmatchException(Tr.class,
            // replace.getClass());
            // }
            // } else {
            // execute(tr, tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case TH:
            Th th = (Th) target;
            break;
        case THEAD:
            Thead thead = (Thead) target;
            // if (match(thead.getClass(), thead.getCssClass(), tagType, clazz))
            // {
            // return;
            // }
            // if (thead.isSetTr()) {
            // for (ListIterator<Tr> j = thead.getTr().listIterator(); j
            // .hasNext();) {
            // Tr tr = j.next();
            // if (match(Tr.class, tr.getCssClass(), tagType, clazz)) {
            // if (replace.getClass().equals(Tr.class)) {
            // j.set(((Tr) replace).copy(Tr.class));
            // } else {
            // throw new TagTypeUnmatchException(Tr.class,
            // replace.getClass());
            // }
            // } else {
            // execute(tr, tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case TITLE:
            Title title = (Title) target;
            // 中身はstringのみ！
            break;
        case TR:
            Tr tr = (Tr) target;
            // if (match(tr.getClass(), tr.getCssClass(), tagType, clazz)) {
            // return;
            // }
            // if (tr.isSetThOrTd()) {
            // for (ListIterator<Flow> j = tr.getThOrTd().listIterator(); j
            // .hasNext();) {
            // Flow flow = j.next();
            // if (match(flow.getClass(), flow.getCssClass(), tagType,
            // clazz)) {
            // if (replace.getClass().equals(Th.class)) {
            //
            // j.set(((Th) replace).copy(Th.class));
            // } else if (replace.getClass().equals(Td.class)) {
            //
            // j.set(((Td) replace).copy(Td.class));
            // } else {
            // throw new TagTypeUnmatchException(
            // "th or td expected but replace is "
            // + replace.getClass());
            // }
            // } else {
            // execute(flow, tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case TT:
            Tt tt = (Tt) target;
            break;
        case U:
            U u = (U) target;
            break;
        case UL:
            Ul ul = (Ul) target;
            // if (match(ul.getClass(), ul.getCssClass(), tagType, clazz)) {
            // return;
            // }
            // if (ul.isSetLi()) {
            // for (ListIterator<Li> j = ul.getLi().listIterator(); j
            // .hasNext();) {
            // Li li2 = j.next();
            // if (match(li2.getClass(), li2.getCssClass(), tagType, clazz)) {
            // if (replace.getClass().equals(Li.class)) {
            // j.set(((Li) replace).copy(Li.class));
            // } else {
            // throw new TagTypeUnmatchException(Li.class,
            // replace.getClass());
            // }
            // } else {
            // execute(li2, tagType, clazz, replace);
            // }
            // }
            // }
            break;
        case VAR:
            Var var = (Var) target;
            break;
        case ARTICLE:
            Article article = (Article) target;
            break;
        case ASIDE:
            Aside aside = (Aside) target;
            break;
        case AUDIO:
            Audio audio = (Audio) target;
            break;
        case BDI:
            Bdi bdi = (Bdi) target;
            break;
        case CANVAS:
            Canvas canvas = (Canvas) target;
            break;
        case COMMAND:
            Command command = (Command) target;
            // empty element
            break;
        case DATALIST:
            Datalist datalist = (Datalist) target;
            break;
        case DETAILS:
            Details details = (Details) target;
            break;
        case EMBED:
            Embed embed = (Embed) target;
            // empty element
            break;
        case FIGCAPTION:
            Figcaption figcaption = (Figcaption) target;
            break;
        case FIGURE:
            Figure figure = (Figure) target;
            break;
        case FOOTER:
            Footer footer = (Footer) target;
            break;
        case HEADER:
            Header header = (Header) target;
            break;
        case KEYGEN:
            Keygen keygen = (Keygen) target;
            // empty element
            break;
        case MARK:
            Mark mark = (Mark) target;
            break;
        case METER:
            Meter meter = (Meter) target;
            break;
        case NAV:
            Nav nav = (Nav) target;
            break;
        case OUTPUT:
            Output output = (Output) target;
            break;
        case PROGRESS:
            Progress progress = (Progress) target;
            break;
        case RP:
            Rp rp = (Rp) target;
            break;
        case RT:
            Rt rt = (Rt) target;
            break;
        case RUBY:
            Ruby ruby = (Ruby) target;
            break;
        case SECTION:
            Section section = (Section) target;
            break;
        case SOURCE:
            Source source = (Source) target;
            // empty element
            break;
        case SUMMARY:
            Summary summary = (Summary) target;
            break;
        case TIME:
            Time time = (Time) target;
            break;
        case TRACK:
            Track track = (Track) target;
            // empty element
            break;
        case VIDEO:
            Video video = (Video) target;
            break;
        case WBR:
            Wbr wbr = (Wbr) target;
            // empty element
            break;
        }
    }
}

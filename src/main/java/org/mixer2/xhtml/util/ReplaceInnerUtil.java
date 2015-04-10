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
 * @see org.mixer2.xhtml.AbstractJaxb#replaceContent(List<java.lang.Object>)
 * 
 * @author nabedge/watanabe
 *
 */
public class ReplaceInnerUtil {

	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(ReplaceInnerUtil.class);

	/**
	 * @see org.mixer2.xhtml.AbstractJaxb#replaceInner(AbstractJaxb)
	 * @param target
	 * @param replacement
	 * @throws TagTypeUnmatchException
	 */
	public static <T extends AbstractJaxb> void replaceInner(T target,
			T replacement) throws TagTypeUnmatchException {
		execute(target, replacement);
	}

	/**
	 * @see org.mixer2.xhtml.AbstractJaxb#replaceInner(String)
	 * @param target
	 * @param replacement
	 * @throws TagTypeUnmatchException
	 */
	public static <T extends AbstractJaxb> void replaceInner(T target,
			String replacement) throws TagTypeUnmatchException {
		execute(target, replacement);
	}

	/**
	 * @see org.mixer2.xhtml.AbstractJaxb#replaceInner(List<java.lang.Object>)
	 * @param target
	 * @param replacement
	 * @throws TagTypeUnmatchException
	 */
	public static <T extends AbstractJaxb> void replaceInner(T target,
			List<java.lang.Object> replacement) throws TagTypeUnmatchException {
		execute(target, replacement);
	}

	@SuppressWarnings("unchecked")
	private static void replaceContent(List<java.lang.Object> list,
			java.lang.Object replacement) {
		list.clear();
		if (replacement instanceof List) {
			for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
				if (isStringOrTag(o)) {
					list.add(o);
				}
			}
		} else {
			if (isStringOrTag(replacement)) {
				list.add(replacement);
			}
		}
	}

	private static boolean isStringOrTag(java.lang.Object obj) {
		if (obj instanceof String || obj instanceof AbstractJaxb) {
			return true;
		} else {
			return false;
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
			replaceContent(abbr.getContent(), replacement);
			break;
		case ACRONYM:
			Acronym acronym = (Acronym) target;
			replaceContent(acronym.getContent(), replacement);
			break;
		case ADDRESS:
			Address address = (Address) target;
			replaceContent(address.getContent(), replacement);
			break;
		case APPLET:
			Applet applet = (Applet) target;
			replaceContent(applet.getContent(), replacement);
			break;
		case AREA:
			Area area = (Area) target;
			// empty tag
			break;
		case B:
			B b = (B) target;
			replaceContent(b.getContent(), replacement);
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
			replaceContent(bdo.getContent(), replacement);
			break;
		case BIG:
			Big big = (Big) target;
			replaceContent(big.getContent(), replacement);
			break;
		case BLOCKQUOTE:
			Blockquote blockquote = (Blockquote) target;
			replaceContent(blockquote.getContent(), replacement);
			break;
		case BODY:
			Body body = (Body) target;
			replaceContent(body.getContent(), replacement);
			break;
		case BR:
			Br br = (Br) target;
			// empty element
			break;
		case BUTTON:
			Button button = (Button) target;
			replaceContent(button.getContent(), replacement);
			break;
		case CAPTION:
			Caption caption = (Caption) target;
			replaceContent(caption.getContent(), replacement);
			break;
		case CENTER:
			Center center = (Center) target;
			replaceContent(center.getContent(), replacement);
			break;
		case CITE:
			Cite cite = (Cite) target;
			replaceContent(cite.getContent(), replacement);
			break;
		case CODE:
			Code code = (Code) target;
			replaceContent(code.getContent(), replacement);
			break;
		case COL:
			Col col = (Col) target;
			// empty element
			break;
		case COLGROUP:
			Colgroup colgroup = (Colgroup) target;
			colgroup.unsetCol();
			if (replacement instanceof Col) {
				colgroup.getCol().add((Col) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Col) {
						colgroup.getCol().add((Col) o);
					}
				}
			}
			break;
		case DD:
			Dd dd = (Dd) target;
			replaceContent(dd.getContent(), replacement);
			break;
		case DEL:
			Del del = (Del) target;
			replaceContent(del.getContent(), replacement);
			break;
		case DFN:
			Dfn dfn = (Dfn) target;
			replaceContent(dfn.getContent(), replacement);
			break;
		case DIR:
			Dir dir = (Dir) target;
			dir.getLi().clear();
			if (replacement instanceof Li) {
				dir.getLi().add((Li) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Li) {
						dir.getLi().add((Li) o);
					}
				}
			}
			break;
		case DIV:
			Div div = (Div) target;
			replaceContent(div.getContent(), replacement);
			break;
		case DL:
			Dl dl = (Dl) target;
			if (replacement instanceof Dd) {
				dl.getDtOrDd().add((Dd) replacement);
			}
			if (replacement instanceof Dt) {
				dl.getDtOrDd().add((Dt) replacement);
			}
			if (replacement instanceof List) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Dd) {
						dl.getDtOrDd().add((Dd) o);
					}
					if (o instanceof Dt) {
						dl.getDtOrDd().add((Dt) o);
					}
				}
			}
			break;
		case DT:
			Dt dt = (Dt) target;
			replaceContent(dt.getContent(), replacement);
			break;
		case EM:
			Em em = (Em) target;
			replaceContent(em.getContent(), replacement);
			break;
		case FIELDSET:
			Fieldset fieldset = (Fieldset) target;
			replaceContent(fieldset.getContent(), replacement);
			break;
		case FONT:
			Font font = (Font) target;
			replaceContent(font.getContent(), replacement);
			break;
		case FORM:
			Form form = (Form) target;
			replaceContent(form.getContent(), replacement);
			break;
		case H1:
			H1 h1 = (H1) target;
			replaceContent(h1.getContent(), replacement);
			break;
		case H2:
			H2 h2 = (H2) target;
			replaceContent(h2.getContent(), replacement);
			break;
		case H3:
			H3 h3 = (H3) target;
			replaceContent(h3.getContent(), replacement);
			break;
		case H4:
			H4 h4 = (H4) target;
			replaceContent(h4.getContent(), replacement);
			break;
		case H5:
			H5 h5 = (H5) target;
			replaceContent(h5.getContent(), replacement);
			break;
		case H6:
			H6 h6 = (H6) target;
			replaceContent(h6.getContent(), replacement);
			break;
		case HGROUP:
			Hgroup hgroup = (Hgroup) target;
			hgroup.unsetH1OrH2OrH3();
			if (replacement instanceof H1 || replacement instanceof H2
					|| replacement instanceof H3 || replacement instanceof H4
					|| replacement instanceof H5 || replacement instanceof H6) {
				hgroup.getH1OrH2OrH3().add((Inline) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof H1 || o instanceof H2 || o instanceof H3
							|| o instanceof H4 || o instanceof H5
							|| o instanceof H6) {
						hgroup.getH1OrH2OrH3().add((Inline) o);
					}
				}
			}
			break;
		case HEAD:
			Head head = (Head) target;
			head.getContent().clear();
			if (replacement instanceof AbstractJaxb) {
				head.getContent().add((AbstractJaxb) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof AbstractJaxb) {
						head.getContent().add((AbstractJaxb) o);
					}
				}
			}
			break;
		case HR:
			Hr hr = (Hr) target;
			// empty element.
			break;
		case HTML:
			Html html = (Html) target;
			if (replacement instanceof Body) {
				html.setBody((Body) replacement);
			}
			if (replacement instanceof Head) {
				html.setHead((Head) replacement);
			}
			break;
		case I:
			I i = (I) target;
			replaceContent(i.getContent(), replacement);
			break;
		case IFRAME:
			Iframe iframe = (Iframe) target;
			replaceContent(iframe.getContent(), replacement);
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
			replaceContent(ins.getContent(), replacement);
			break;
		case ISINDEX:
			Isindex isindex = (Isindex) target;
			// empty element
			break;
		case KBD:
			Kbd kbd = (Kbd) target;
			replaceContent(kbd.getContent(), replacement);
			break;
		case LABEL:
			Label label = (Label) target;
			replaceContent(label.getContent(), replacement);
			break;
		case LEGEND:
			Legend legend = (Legend) target;
			replaceContent(legend.getContent(), replacement);
			break;
		case LI:
			Li li = (Li) target;
			replaceContent(li.getContent(), replacement);
			break;
		case LINK:
			Link link = (Link) target;
			// empty element.
			break;
		case MAP:
			Map map = (Map) target;
			map.unsetArea();
			map.unsetPOrH1OrH2();
			if (replacement instanceof Area) {
				map.getArea().add((Area) replacement);
				break;
			}
			if (replacement instanceof AbstractJaxb) {
				map.getPOrH1OrH2().add((AbstractJaxb) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Area) {
						map.getArea().add((Area) o);
						continue;
					}
					if (o instanceof AbstractJaxb) {
						map.getPOrH1OrH2().add((AbstractJaxb) o);
					}
				}
			}
			break;
		case MENU:
			Menu menu = (Menu) target;
			replaceContent(menu.getContent(), replacement);
			break;
		case META:
			Meta meta = (Meta) target;
			// empty element.
			break;
		case NOFRAMES:
			Noframes noframes = (Noframes) target;
			replaceContent(noframes.getContent(), replacement);
			break;
		case NOSCRIPT:
			Noscript noscript = (Noscript) target;
			replaceContent(noscript.getContent(), replacement);
			break;
		case OBJECT:
			org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
			replaceContent(object.getContent(), replacement);
			break;
		case OL:
			Ol ol = (Ol) target;
			ol.unsetLi();
			if (replacement instanceof Li) {
				ol.getLi().add((Li) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Li) {
						ol.getLi().add((Li) o);
					}
				}
			}
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

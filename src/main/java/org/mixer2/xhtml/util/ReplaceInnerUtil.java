package org.mixer2.xhtml.util;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;

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
	 */
	public static <T extends AbstractJaxb> void replaceInner(T target,
			T replacement) {
		execute(target, replacement);
	}

	/**
	 * @see org.mixer2.xhtml.AbstractJaxb#replaceInner(String)
	 * @param target
	 * @param replacement
	 */
	public static <T extends AbstractJaxb> void replaceInner(T target,
			String replacement) {
		execute(target, replacement);
	}

	/**
	 * @see org.mixer2.xhtml.AbstractJaxb#replaceInner(List<java.lang.Object>
	 *      replacement)
	 * @param target
	 * @param replacement
	 */
	public static <T extends AbstractJaxb> void replaceInner(T target,
			List<java.lang.Object> replacement) {
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
			java.lang.Object replacement) {

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
					if (o instanceof Dd || o instanceof Dt) {
						dl.getDtOrDd().add((AbstractJaxb) o);
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
			optgroup.getOption().clear();
			if (replacement instanceof Option) {
				optgroup.getOption().add((Option) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Option) {
						optgroup.getOption().add((Option) o);
					}
				}
			}
			break;
		case OPTION:
			Option option = (Option) target;
			// empty element
			break;
		case P:
			P p = (P) target;
			replaceContent(p.getContent(), replacement);
			break;
		case PARAM:
			Param param = (Param) target;
			// empty element
			break;
		case PRE:
			Pre pre = (Pre) target;
			replaceContent(pre.getContent(), replacement);
			break;
		case Q:
			Q q = (Q) target;
			replaceContent(q.getContent(), replacement);
			break;
		case S:
			S s = (S) target;
			replaceContent(s.getContent(), replacement);
			break;
		case SAMP:
			Samp samp = (Samp) target;
			replaceContent(samp.getContent(), replacement);
			break;
		case SCRIPT:
			Script script = (Script) target;
			if (replacement instanceof String) {
				script.setContent((String) replacement);
			}
			break;
		case SELECT:
			Select select = (Select) target;
			select.unsetOptgroupOrOption();
			if (replacement instanceof Optgroup
					|| replacement instanceof Option) {
				select.getOptgroupOrOption().add((AbstractJaxb) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Option || o instanceof Optgroup) {
						select.getOptgroupOrOption().add((AbstractJaxb) o);
					}
				}
			}
			break;
		case SMALL:
			Small small = (Small) target;
			replaceContent(small.getContent(), replacement);
			break;
		case SPAN:
			Span span = (Span) target;
			replaceContent(span.getContent(), replacement);
			break;
		case STRIKE:
			Strike strike = (Strike) target;
			replaceContent(strike.getContent(), replacement);
			break;
		case STRONG:
			Strong strong = (Strong) target;
			replaceContent(strong.getContent(), replacement);
			break;
		case STYLE:
			Style style = (Style) target;
			if (replacement instanceof String) {
				style.setContent((String) replacement);
			}
			break;
		case SUB:
			Sub sub = (Sub) target;
			replaceContent(sub.getContent(), replacement);
			break;
		case SUP:
			Sup sup = (Sup) target;
			replaceContent(sup.getContent(), replacement);
			break;
		case TABLE:
			Table table = (Table) target;
			table.unsetCol();
			table.unsetColgroup();
			table.unsetTr();
			table.unsetTbody();
			table.setThead(null);
			table.setTfoot(null);
			if (replacement instanceof Caption) {
				table.setCaption((Caption) replacement);
			}
			if (replacement instanceof Col) {
				table.getCol().add((Col) replacement);
			}
			if (replacement instanceof Colgroup) {
				table.getColgroup().add((Colgroup) replacement);
			}
			if (replacement instanceof Tr) {
				table.getTr().add((Tr) replacement);
			}
			if (replacement instanceof Tbody) {
				table.getTbody().add((Tbody) replacement);
			}
			if (replacement instanceof Thead) {
				table.setThead((Thead) replacement);
			}
			if (replacement instanceof Tfoot) {
				table.setTfoot((Tfoot) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Caption) {
						table.setCaption((Caption) o);
					}
					if (o instanceof Col) {
						table.getCol().add((Col) o);
					}
					if (o instanceof Colgroup) {
						table.getColgroup().add((Colgroup) o);
					}
					if (o instanceof Tr) {
						table.getTr().add((Tr) o);
					}
					if (o instanceof Tbody) {
						table.getTbody().add((Tbody) o);
					}
					if (o instanceof Thead) {
						table.setThead((Thead) o);
					}
					if (o instanceof Tfoot) {
						table.setTfoot((Tfoot) o);
					}
				}
			}
			break;
		case TBODY:
			Tbody tbody = (Tbody) target;
			tbody.getTr().clear();
			if (replacement instanceof Tr) {
				tbody.getTr().add((Tr) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Tr) {
						tbody.getTr().add((Tr) o);
					}
				}
			}
			break;
		case TD:
			Td td = (Td) target;
			replaceContent(td.getContent(), replacement);
			break;
		case TEXTAREA:
			Textarea textarea = (Textarea) target;
			if (replacement instanceof String) {
				textarea.setContent((String) replacement);
			}
			break;
		case TFOOT:
			Tfoot tfoot = (Tfoot) target;
			tfoot.unsetTr();
			if (replacement instanceof Tr) {
				tfoot.getTr().add((Tr) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Tr) {
						tfoot.getTr().add((Tr) o);
					}
				}
			}
			break;
		case TH:
			Th th = (Th) target;
			replaceContent(th.getContent(), replacement);
			break;
		case THEAD:
			Thead thead = (Thead) target;
			thead.unsetTr();
			if (replacement instanceof Tr) {
				thead.getTr().add((Tr) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Tr) {
						thead.getTr().add((Tr) o);
					}
				}
			}
			break;
		case TITLE:
			Title title = (Title) target;
			if (replacement instanceof String) {
				title.setContent((String) replacement);
			}
			break;
		case TR:
			Tr tr = (Tr) target;
			tr.unsetThOrTd();
			if (replacement instanceof Td || replacement instanceof Th) {
				tr.getThOrTd().add((Flow) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Td || o instanceof Th) {
						tr.getThOrTd().add((Flow) o);
					}
				}
			}
			break;
		case TT:
			Tt tt = (Tt) target;
			replaceContent(tt.getContent(), replacement);
			break;
		case U:
			U u = (U) target;
			replaceContent(u.getContent(), replacement);
			break;
		case UL:
			Ul ul = (Ul) target;
			ul.unsetLi();
			if (replacement instanceof Li) {
				ul.getLi().add((Li) replacement);
			}
			if (replacement instanceof List<?>) {
				for (java.lang.Object o : (Collection<? extends java.lang.Object>) replacement) {
					if (o instanceof Li) {
						ul.getLi().add((Li) o);
					}
				}
			}
			break;
		case VAR:
			Var var = (Var) target;
			replaceContent(var.getContent(), replacement);
			break;
		case ARTICLE:
			Article article = (Article) target;
			replaceContent(article.getContent(), replacement);
			break;
		case ASIDE:
			Aside aside = (Aside) target;
			replaceContent(aside.getContent(), replacement);
			break;
		case AUDIO:
			Audio audio = (Audio) target;
			replaceContent(audio.getContent(), replacement);
			break;
		case BDI:
			Bdi bdi = (Bdi) target;
			replaceContent(bdi.getContent(), replacement);
			break;
		case CANVAS:
			Canvas canvas = (Canvas) target;
			replaceContent(canvas.getContent(), replacement);
			break;
		case COMMAND:
			Command command = (Command) target;
			// empty element
			break;
		case DATALIST:
			Datalist datalist = (Datalist) target;
			replaceContent(datalist.getContent(), replacement);
			break;
		case DETAILS:
			Details details = (Details) target;
			replaceContent(details.getContent(), replacement);
			break;
		case EMBED:
			Embed embed = (Embed) target;
			// empty element
			break;
		case FIGCAPTION:
			Figcaption figcaption = (Figcaption) target;
			replaceContent(figcaption.getContent(), replacement);
			break;
		case FIGURE:
			Figure figure = (Figure) target;
			replaceContent(figure.getContent(), replacement);
			break;
		case FOOTER:
			Footer footer = (Footer) target;
			replaceContent(footer.getContent(), replacement);
			break;
		case HEADER:
			Header header = (Header) target;
			replaceContent(header.getContent(), replacement);
			break;
		case KEYGEN:
			Keygen keygen = (Keygen) target;
			// empty element
			break;
		case MARK:
			Mark mark = (Mark) target;
			replaceContent(mark.getContent(), replacement);
			break;
		case METER:
			Meter meter = (Meter) target;
			replaceContent(meter.getContent(), replacement);
			break;
		case NAV:
			Nav nav = (Nav) target;
			replaceContent(nav.getContent(), replacement);
			break;
		case OUTPUT:
			Output output = (Output) target;
			replaceContent(output.getContent(), replacement);
			break;
		case PROGRESS:
			Progress progress = (Progress) target;
			replaceContent(progress.getContent(), replacement);
			break;
		case RP:
			Rp rp = (Rp) target;
			replaceContent(rp.getContent(), replacement);
			break;
		case RT:
			Rt rt = (Rt) target;
			replaceContent(rt.getContent(), replacement);
			break;
		case RUBY:
			Ruby ruby = (Ruby) target;
			replaceContent(ruby.getContent(), replacement);
			break;
		case SECTION:
			Section section = (Section) target;
			replaceContent(section.getContent(), replacement);
			break;
		case SOURCE:
			Source source = (Source) target;
			// empty element
			break;
		case SUMMARY:
			Summary summary = (Summary) target;
			replaceContent(summary.getContent(), replacement);
			break;
		case TIME:
			Time time = (Time) target;
			replaceContent(time.getContent(), replacement);
			break;
		case TRACK:
			Track track = (Track) target;
			// empty element
			break;
		case VIDEO:
			Video video = (Video) target;
			replaceContent(video.getContent(), replacement);
			break;
		case WBR:
			Wbr wbr = (Wbr) target;
			// empty element
			break;
		}
	}
}

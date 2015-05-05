package org.mixer2.xhtml.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;

/**
 *
 * @see org.mixer2.xhtml.AbstractJaxb#removeInner()
 * 
 * @author nabedge/watanabe
 *
 */
public class RemoveInnerUtil {

	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(RemoveInnerUtil.class);

	/**
	 * @see org.mixer2.xhtml.AbstractJaxb#removeInner(AbstractJaxb)
	 * @param target
	 */
	public static <T extends AbstractJaxb> void removeInner(T target) {
		execute(target);
	}

	@SuppressWarnings("unused")
	private static <T extends AbstractJaxb> void execute(T target) {

		TagEnum tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
				.toUpperCase());

		switch (tagEnum) {
		case A:
			A a = (A) target;
			a.unsetContent();
			break;
		case ABBR:
			Abbr abbr = (Abbr) target;
			abbr.unsetContent();
			break;
		case ACRONYM:
			Acronym acronym = (Acronym) target;
			acronym.unsetContent();
			break;
		case ADDRESS:
			Address address = (Address) target;
			address.unsetContent();
			break;
		case APPLET:
			Applet applet = (Applet) target;
			applet.unsetContent();
			break;
		case AREA:
			Area area = (Area) target;
			// empty tag
			break;
		case B:
			B b = (B) target;
			b.unsetContent();
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
			bdo.unsetContent();
			break;
		case BIG:
			Big big = (Big) target;
			big.unsetContent();
			break;
		case BLOCKQUOTE:
			Blockquote blockquote = (Blockquote) target;
			blockquote.unsetContent();
			break;
		case BODY:
			Body body = (Body) target;
			body.unsetContent();
			break;
		case BR:
			Br br = (Br) target;
			// empty element
			break;
		case BUTTON:
			Button button = (Button) target;
			button.unsetContent();
			break;
		case CAPTION:
			Caption caption = (Caption) target;
			caption.unsetContent();
			break;
		case CENTER:
			Center center = (Center) target;
			center.unsetContent();
			break;
		case CITE:
			Cite cite = (Cite) target;
			cite.unsetContent();
			break;
		case CODE:
			Code code = (Code) target;
			code.unsetContent();
			break;
		case COL:
			Col col = (Col) target;
			// empty element
			break;
		case COLGROUP:
			Colgroup colgroup = (Colgroup) target;
			colgroup.unsetCol();
			break;
		case DD:
			Dd dd = (Dd) target;
			dd.unsetContent();
			break;
		case DEL:
			Del del = (Del) target;
			del.unsetContent();
			break;
		case DFN:
			Dfn dfn = (Dfn) target;
			dfn.unsetContent();
			break;
		case DIR:
			Dir dir = (Dir) target;
			dir.getLi().clear();
			break;
		case DIV:
			Div div = (Div) target;
			div.unsetContent();
			break;
		case DL:
			Dl dl = (Dl) target;
			dl.unsetDtOrDd();
			break;
		case DT:
			Dt dt = (Dt) target;
			dt.unsetContent();
			break;
		case EM:
			Em em = (Em) target;
			em.unsetContent();
			break;
		case FIELDSET:
			Fieldset fieldset = (Fieldset) target;
			fieldset.unsetContent();
			break;
		case FONT:
			Font font = (Font) target;
			font.unsetContent();
			break;
		case FORM:
			Form form = (Form) target;
			form.unsetContent();
			break;
		case H1:
			H1 h1 = (H1) target;
			h1.unsetContent();
			break;
		case H2:
			H2 h2 = (H2) target;
			h2.unsetContent();
			break;
		case H3:
			H3 h3 = (H3) target;
			h3.unsetContent();
			break;
		case H4:
			H4 h4 = (H4) target;
			h4.unsetContent();
			break;
		case H5:
			H5 h5 = (H5) target;
			h5.unsetContent();
			break;
		case H6:
			H6 h6 = (H6) target;
			h6.unsetContent();
			break;
		case HGROUP:
			Hgroup hgroup = (Hgroup) target;
			hgroup.unsetH1OrH2OrH3();
			break;
		case HEAD:
			Head head = (Head) target;
			head.getContent().clear();
			break;
		case HR:
			Hr hr = (Hr) target;
			// empty element.
			break;
		case HTML:
			Html html = (Html) target;
			html.setHead(null);
			html.setBody(null);
			break;
		case I:
			I i = (I) target;
			i.unsetContent();
			break;
		case IFRAME:
			Iframe iframe = (Iframe) target;
			iframe.unsetContent();
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
			ins.unsetContent();
			break;
		case ISINDEX:
			Isindex isindex = (Isindex) target;
			// empty element
			break;
		case KBD:
			Kbd kbd = (Kbd) target;
			kbd.unsetContent();
			break;
		case LABEL:
			Label label = (Label) target;
			label.unsetContent();
			break;
		case LEGEND:
			Legend legend = (Legend) target;
			legend.unsetContent();
			break;
		case LI:
			Li li = (Li) target;
			li.unsetContent();
			break;
		case LINK:
			Link link = (Link) target;
			// empty element.
			break;
		case MAP:
			Map map = (Map) target;
			map.unsetArea();
			map.unsetPOrH1OrH2();
			break;
		case MENU:
			Menu menu = (Menu) target;
			menu.unsetContent();
			break;
		case META:
			Meta meta = (Meta) target;
			// empty element.
			break;
		case NOFRAMES:
			Noframes noframes = (Noframes) target;
			noframes.unsetContent();
			break;
		case NOSCRIPT:
			Noscript noscript = (Noscript) target;
			noscript.unsetContent();
			break;
		case OBJECT:
			org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
			object.unsetContent();
			break;
		case OL:
			Ol ol = (Ol) target;
			ol.unsetLi();
			break;
		case OPTGROUP:
			Optgroup optgroup = (Optgroup) target;
			optgroup.getOption().clear();
			break;
		case OPTION:
			Option option = (Option) target;
			// empty element
			break;
		case P:
			P p = (P) target;
			p.unsetContent();
			break;
		case PARAM:
			Param param = (Param) target;
			// empty element
			break;
		case PRE:
			Pre pre = (Pre) target;
			pre.unsetContent();
			break;
		case Q:
			Q q = (Q) target;
			q.unsetContent();
			break;
		case S:
			S s = (S) target;
			s.unsetContent();
			break;
		case SAMP:
			Samp samp = (Samp) target;
			samp.unsetContent();
			break;
		case SCRIPT:
			Script script = (Script) target;
			script.setContent(null);
			break;
		case SELECT:
			Select select = (Select) target;
			select.unsetOptgroupOrOption();
			break;
		case SMALL:
			Small small = (Small) target;
			small.unsetContent();
			break;
		case SPAN:
			Span span = (Span) target;
			span.unsetContent();
			break;
		case STRIKE:
			Strike strike = (Strike) target;
			strike.unsetContent();
			break;
		case STRONG:
			Strong strong = (Strong) target;
			strong.unsetContent();
			break;
		case STYLE:
			Style style = (Style) target;
			style.setContent(null);
			break;
		case SUB:
			Sub sub = (Sub) target;
			sub.unsetContent();
			break;
		case SUP:
			Sup sup = (Sup) target;
			sup.unsetContent();
			break;
		case TABLE:
			Table table = (Table) target;
			table.unsetCol();
			table.unsetColgroup();
			table.unsetTr();
			table.unsetTbody();
			table.setThead(null);
			table.setTfoot(null);
			break;
		case TBODY:
			Tbody tbody = (Tbody) target;
			tbody.getTr().clear();
			break;
		case TD:
			Td td = (Td) target;
			td.unsetContent();
			break;
		case TEXTAREA:
			Textarea textarea = (Textarea) target;
			textarea.setContent(null);
			break;
		case TFOOT:
			Tfoot tfoot = (Tfoot) target;
			tfoot.unsetTr();
			break;
		case TH:
			Th th = (Th) target;
			th.unsetContent();
			break;
		case THEAD:
			Thead thead = (Thead) target;
			thead.unsetTr();
			break;
		case TITLE:
			Title title = (Title) target;
			title.setContent(null);
			break;
		case TR:
			Tr tr = (Tr) target;
			tr.unsetThOrTd();
			break;
		case TT:
			Tt tt = (Tt) target;
			tt.unsetContent();
			break;
		case U:
			U u = (U) target;
			u.unsetContent();
			break;
		case UL:
			Ul ul = (Ul) target;
			ul.unsetLi();
			break;
		case VAR:
			Var var = (Var) target;
			var.unsetContent();
			break;
		case ARTICLE:
			Article article = (Article) target;
			article.unsetContent();
			break;
		case ASIDE:
			Aside aside = (Aside) target;
			aside.unsetContent();
			break;
		case AUDIO:
			Audio audio = (Audio) target;
			audio.unsetContent();
			break;
		case BDI:
			Bdi bdi = (Bdi) target;
			bdi.unsetContent();
			break;
		case CANVAS:
			Canvas canvas = (Canvas) target;
			canvas.unsetContent();
			break;
		case COMMAND:
			Command command = (Command) target;
			// empty element
			break;
		case DATALIST:
			Datalist datalist = (Datalist) target;
			datalist.unsetContent();
			break;
		case DETAILS:
			Details details = (Details) target;
			details.unsetContent();
			break;
		case EMBED:
			Embed embed = (Embed) target;
			// empty element
			break;
		case FIGCAPTION:
			Figcaption figcaption = (Figcaption) target;
			figcaption.unsetContent();
			break;
		case FIGURE:
			Figure figure = (Figure) target;
			figure.unsetContent();
			break;
		case FOOTER:
			Footer footer = (Footer) target;
			footer.unsetContent();
			break;
		case HEADER:
			Header header = (Header) target;
			header.unsetContent();
			break;
		case KEYGEN:
			Keygen keygen = (Keygen) target;
			// empty
			break;
		case MARK:
			Mark mark = (Mark) target;
			mark.unsetContent();
			break;
		case METER:
			Meter meter = (Meter) target;
			meter.unsetContent();
			break;
		case NAV:
			Nav nav = (Nav) target;
			nav.unsetContent();
			break;
		case OUTPUT:
			Output output = (Output) target;
			output.unsetContent();
			break;
		case PROGRESS:
			Progress progress = (Progress) target;
			progress.unsetContent();
			break;
		case RP:
			Rp rp = (Rp) target;
			rp.unsetContent();
			break;
		case RT:
			Rt rt = (Rt) target;
			rt.unsetContent();
			break;
		case RUBY:
			Ruby ruby = (Ruby) target;
			ruby.unsetContent();
			break;
		case SECTION:
			Section section = (Section) target;
			section.unsetContent();
			break;
		case SOURCE:
			Source source = (Source) target;
			// empty
			break;
		case SUMMARY:
			Summary summary = (Summary) target;
			summary.unsetContent();
			break;
		case TIME:
			Time time = (Time) target;
			time.unsetContent();
			break;
		case TRACK:
			Track track = (Track) target;
			// empty element
			break;
		case VIDEO:
			Video video = (Video) target;
			video.unsetContent();
			break;
		case WBR:
			Wbr wbr = (Wbr) target;
			// empty element
			break;
		}
	}
}

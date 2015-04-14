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
	 * @see org.mixer2.xhtml.AbstractJaxb#replaceInner(AbstractJaxb)
	 * @param target
	 * @param replacement
	 */
	public static <T extends AbstractJaxb> void replaceInner(T target) {
		execute(target);
	}

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
			// TODO;
			break;
		case BLOCKQUOTE:
			Blockquote blockquote = (Blockquote) target;
			// TODO;
			break;
		case BODY:
			Body body = (Body) target;
			// TODO;
			break;
		case BR:
			Br br = (Br) target;
			// empty element
			break;
		case BUTTON:
			Button button = (Button) target;
			// TODO;
			break;
		case CAPTION:
			Caption caption = (Caption) target;
			// TODO;
			break;
		case CENTER:
			Center center = (Center) target;
			// TODO;
			break;
		case CITE:
			Cite cite = (Cite) target;
			// TODO;
			break;
		case CODE:
			Code code = (Code) target;
			// TODO;
			break;
		case COL:
			Col col = (Col) target;
			// empty element
			break;
		case COLGROUP:
			Colgroup colgroup = (Colgroup) target;
			colgroup.unsetCol();
			// TODO
			break;
		case DD:
			Dd dd = (Dd) target;
			// TODO;
			break;
		case DEL:
			Del del = (Del) target;
			// TODO;
			break;
		case DFN:
			Dfn dfn = (Dfn) target;
			// TODO;
			break;
		case DIR:
			Dir dir = (Dir) target;
			dir.getLi().clear();
			// TODO
			break;
		case DIV:
			Div div = (Div) target;
			// TODO;
			break;
		case DL:
			Dl dl = (Dl) target;
			// TODO
			break;
		case DT:
			Dt dt = (Dt) target;
			// TODO;
			break;
		case EM:
			Em em = (Em) target;
			// TODO;
			break;
		case FIELDSET:
			Fieldset fieldset = (Fieldset) target;
			// TODO;
			break;
		case FONT:
			Font font = (Font) target;
			// TODO;
			break;
		case FORM:
			Form form = (Form) target;
			// TODO;
			break;
		case H1:
			H1 h1 = (H1) target;
			// TODO;
			break;
		case H2:
			H2 h2 = (H2) target;
			// TODO;
			break;
		case H3:
			H3 h3 = (H3) target;
			// TODO;
			break;
		case H4:
			H4 h4 = (H4) target;
			// TODO;
			break;
		case H5:
			H5 h5 = (H5) target;
			// TODO;
			break;
		case H6:
			H6 h6 = (H6) target;
			// TODO;
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
			// TODO;
			break;
		case IFRAME:
			Iframe iframe = (Iframe) target;
			// TODO;
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
			// TODO;
			break;
		case ISINDEX:
			Isindex isindex = (Isindex) target;
			// empty element
			break;
		case KBD:
			Kbd kbd = (Kbd) target;
			// TODO;
			break;
		case LABEL:
			Label label = (Label) target;
			// TODO;
			break;
		case LEGEND:
			Legend legend = (Legend) target;
			// TODO;
			break;
		case LI:
			Li li = (Li) target;
			// TODO;
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
			// TODO;
			break;
		case META:
			Meta meta = (Meta) target;
			// empty element.
			break;
		case NOFRAMES:
			Noframes noframes = (Noframes) target;
			// TODO;
			break;
		case NOSCRIPT:
			Noscript noscript = (Noscript) target;
			// TODO;
			break;
		case OBJECT:
			org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
			// TODO;
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
			// TODO;
			break;
		case PARAM:
			Param param = (Param) target;
			// empty element
			break;
		case PRE:
			Pre pre = (Pre) target;
			// TODO;
			break;
		case Q:
			Q q = (Q) target;
			// TODO;
			break;
		case S:
			S s = (S) target;
			// TODO;
			break;
		case SAMP:
			Samp samp = (Samp) target;
			// TODO;
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
			// TODO;
			break;
		case SPAN:
			Span span = (Span) target;
			// TODO;
			break;
		case STRIKE:
			Strike strike = (Strike) target;
			// TODO;
			break;
		case STRONG:
			Strong strong = (Strong) target;
			// TODO;
			break;
		case STYLE:
			Style style = (Style) target;
			style.setContent(null);
			break;
		case SUB:
			Sub sub = (Sub) target;
			// TODO;
			break;
		case SUP:
			Sup sup = (Sup) target;
			// TODO;
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
			// TODO;
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
			// TODO;
			break;
		case THEAD:
			Thead thead = (Thead) target;
			thead.unsetTr();
			break;
		case TITLE:
			Title title = (Title) target;
			// TODO
			break;
		case TR:
			Tr tr = (Tr) target;
			tr.unsetThOrTd();
			break;
		case TT:
			Tt tt = (Tt) target;
			// TODO;
			break;
		case U:
			U u = (U) target;
			// TODO;
			break;
		case UL:
			Ul ul = (Ul) target;
			ul.unsetLi();
			break;
		case VAR:
			Var var = (Var) target;
			// TODO;
			break;
		case ARTICLE:
			Article article = (Article) target;
			// TODO;
			break;
		case ASIDE:
			Aside aside = (Aside) target;
			// TODO;
			break;
		case AUDIO:
			Audio audio = (Audio) target;
			// TODO;
			break;
		case BDI:
			Bdi bdi = (Bdi) target;
			// TODO;
			break;
		case CANVAS:
			Canvas canvas = (Canvas) target;
			// TODO;
			break;
		case COMMAND:
			Command command = (Command) target;
			// empty element
			break;
		case DATALIST:
			Datalist datalist = (Datalist) target;
			// TODO;
			break;
		case DETAILS:
			Details details = (Details) target;
			// TODO;
			break;
		case EMBED:
			Embed embed = (Embed) target;
			// empty element
			break;
		case FIGCAPTION:
			Figcaption figcaption = (Figcaption) target;
			// TODO;
			break;
		case FIGURE:
			Figure figure = (Figure) target;
			// TODO;
			break;
		case FOOTER:
			Footer footer = (Footer) target;
			// TODO;
			break;
		case HEADER:
			Header header = (Header) target;
			// TODO;
			break;
		case KEYGEN:
			Keygen keygen = (Keygen) target;
			// empty element
			break;
		case MARK:
			Mark mark = (Mark) target;
			// TODO;
			break;
		case METER:
			Meter meter = (Meter) target;
			// TODO;
			break;
		case NAV:
			Nav nav = (Nav) target;
			// TODO;
			break;
		case OUTPUT:
			Output output = (Output) target;
			// TODO;
			break;
		case PROGRESS:
			Progress progress = (Progress) target;
			// TODO;
			break;
		case RP:
			Rp rp = (Rp) target;
			// TODO;
			break;
		case RT:
			Rt rt = (Rt) target;
			// TODO;
			break;
		case RUBY:
			Ruby ruby = (Ruby) target;
			// TODO;
			break;
		case SECTION:
			Section section = (Section) target;
			// TODO;
			break;
		case SOURCE:
			Source source = (Source) target;
			// empty element
			break;
		case SUMMARY:
			Summary summary = (Summary) target;
			// TODO;
			break;
		case TIME:
			Time time = (Time) target;
			// TODO;
			break;
		case TRACK:
			Track track = (Track) target;
			// empty element
			break;
		case VIDEO:
			Video video = (Video) target;
			// TODO;
			break;
		case WBR:
			Wbr wbr = (Wbr) target;
			// empty element
			break;
		}
	}
}

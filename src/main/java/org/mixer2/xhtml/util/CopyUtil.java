package org.mixer2.xhtml.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;

// TODO
public class CopyUtil {

	private static Log log = LogFactory.getLog(CopyUtil.class);

	public static <T extends AbstractJaxb> void copyOtherAttr(T original, T copy) {
		if (!(original instanceof AbstractJaxb)
				|| !(copy instanceof AbstractJaxb)) {
			return;
		}
		execute(original, copy);
	}

	private static void execute(java.lang.Object original, java.lang.Object copy) {

		if (!original.getClass().equals(copy.getClass())) {
			log.warn("tag type is different between original and copy");
			return;
		}

		if (!(original instanceof AbstractJaxb)
				|| !(copy instanceof AbstractJaxb)) {
			return;
		}

		TagEnum tagEnum = TagEnum.valueOf(original.getClass().getSimpleName()
				.toUpperCase());

		int listSize;

		switch (tagEnum) {
		case A:
			A a_original = (A) original;
			A a_copy = (A) copy;
			a_copy.getOtherAttributes().putAll(a_original.getOtherAttributes());
			listSize = a_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(a_original.getContent().get(i), a_copy.getContent()
						.get(i));
			}
			break;
		case ABBR:
			Abbr abbr_original = (Abbr) original;
			Abbr abbr_copy = (Abbr) copy;
			abbr_copy.getOtherAttributes().putAll(
					abbr_original.getOtherAttributes());
			listSize = abbr_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(abbr_original.getContent().get(i), abbr_copy
						.getContent().get(i));
			}
			break;
		case ACRONYM:
			Acronym acronym_o = (Acronym) original;
			Acronym acronym_c = (Acronym) copy;
			acronym_c.getOtherAttributes().putAll(
					acronym_o.getOtherAttributes());
			listSize = acronym_o.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(acronym_o.getContent().get(i), acronym_c.getContent()
						.get(i));
			}
			break;
		case ADDRESS:
			Address address_original = (Address) original;
			Address address_copy = (Address) copy;
			address_copy.getOtherAttributes().putAll(
					address_original.getOtherAttributes());
			listSize = address_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(address_original.getContent().get(i), address_copy
						.getContent().get(i));
			}
			break;
		case APPLET:
			Applet applet_original = (Applet) original;
			Applet applet_copy = (Applet) copy;
			applet_copy.getOtherAttributes().putAll(
					applet_copy.getOtherAttributes());
			listSize = applet_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(applet_original.getContent().get(i), applet_copy
						.getContent().get(i));
			}
			break;
		case AREA:
			Area area_original = (Area) original;
			Area area_copy = (Area) copy;
			area_copy.getOtherAttributes().putAll(
					area_original.getOtherAttributes());
			// empty element
			break;
		case ARTICLE:
			Article article_original = (Article) original;
			Article article_copy = (Article) copy;
			article_copy.getOtherAttributes().putAll(
					article_original.getOtherAttributes());
			listSize = article_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(article_original.getContent().get(i), article_copy
						.getContent().get(i));
			}
			break;
		case ASIDE:
			Aside aside_original = (Aside) original;
			Aside aside_copy = (Aside) copy;
			aside_copy.getOtherAttributes().putAll(
					aside_original.getOtherAttributes());
			listSize = aside_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(aside_original.getContent().get(i), aside_copy
						.getContent().get(i));
			}
			break;
		case AUDIO:
			Audio audio_original = (Audio) original;
			Audio audio_copy = (Audio) copy;
			audio_copy.getOtherAttributes().putAll(
					audio_original.getOtherAttributes());
			// empty element
			break;
		case B:
			B b_original = (B) original;
			B b_copy = (B) copy;
			b_copy.getOtherAttributes().putAll(b_original.getOtherAttributes());
			listSize = b_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(b_original.getContent().get(i), b_copy.getContent()
						.get(i));
			}
			break;
		case BASE:
			Base base_original = (Base) original;
			Base base_copy = (Base) copy;
			base_copy.getOtherAttributes().putAll(
					base_original.getOtherAttributes());
			// empty element
			break;
		case BASEFONT:
			Basefont basefont_original = (Basefont) original;
			Basefont basefont_copy = (Basefont) copy;
			basefont_copy.getOtherAttributes().putAll(
					basefont_original.getOtherAttributes());
			// empty element
			break;
		case BDI:
			Bdi bdi_original = (Bdi) original;
			Bdi bdi_copy = (Bdi) copy;
			bdi_copy.getOtherAttributes().putAll(
					bdi_original.getOtherAttributes());
			listSize = bdi_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(bdi_original.getContent().get(i), bdi_copy.getContent()
						.get(i));
			}
			break;
		case BDO:
			Bdo bdo_original = (Bdo) original;
			Bdo bdo_copy = (Bdo) copy;
			bdo_copy.getOtherAttributes().putAll(
					bdo_original.getOtherAttributes());
			listSize = bdo_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(bdo_original.getContent().get(i), bdo_copy.getContent()
						.get(i));
			}
			break;
		case BIG:
			Big big_original = (Big) original;
			Big big_copy = (Big) copy;
			big_copy.getOtherAttributes().putAll(
					big_original.getOtherAttributes());
			listSize = big_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(big_original.getContent().get(i), big_copy.getContent()
						.get(i));
			}
			break;
		case BLOCKQUOTE:
			Blockquote blockquote_original = (Blockquote) original;
			Blockquote blockquote_copy = (Blockquote) copy;
			blockquote_copy.getOtherAttributes().putAll(
					blockquote_original.getOtherAttributes());
			listSize = blockquote_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(blockquote_original.getContent().get(i),
						blockquote_copy.getContent().get(i));
			}
			break;
		case BODY:
			Body body_o = (Body) original;
			Body body_c = (Body) copy;
			body_c.getOtherAttributes().putAll(body_o.getOtherAttributes());
			listSize = body_o.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(body_o.getContent().get(i), body_c.getContent().get(i));
			}
			break;
		case BR:
			Br br_original = (Br) original;
			Br br_copy = (Br) copy;
			br_copy.getOtherAttributes().putAll(
					br_original.getOtherAttributes());
			// empty element
			break;
		case BUTTON:
			Button button_original = (Button) original;
			Button button_copy = (Button) copy;
			button_copy.getOtherAttributes().putAll(
					button_original.getOtherAttributes());
			listSize = button_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(button_original.getContent().get(i), button_copy
						.getContent().get(i));
			}
			break;
		case CANVAS:
			Canvas canvas_original = (Canvas) original;
			Canvas canvas_copy = (Canvas) copy;
			canvas_copy.getOtherAttributes().putAll(
					canvas_original.getOtherAttributes());
			listSize = canvas_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(canvas_original.getContent().get(i), canvas_copy
						.getContent().get(i));
			}
			break;
		case CAPTION:
			Caption caption_original = (Caption) original;
			Caption caption_copy = (Caption) copy;
			caption_copy.getOtherAttributes().putAll(
					caption_original.getOtherAttributes());
			listSize = caption_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(caption_original.getContent().get(i), caption_copy
						.getContent().get(i));
			}
			break;
		case CENTER:
			Center center_original = (Center) original;
			Center center_copy = (Center) copy;
			center_copy.getOtherAttributes().putAll(
					center_original.getOtherAttributes());
			listSize = center_original.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(center_original.getContent().get(i), center_copy
						.getContent().get(i));
			}
			break;
		case CITE:
			break;
		case CODE:
			break;
		case COL:
			break;
		case COLGROUP:
			break;
		case COMMAND:
			break;
		case DATALIST:
			break;
		case DD:
			break;
		case DEL:
			break;
		case DETAILS:
			break;
		case DFN:
			break;
		case DIR:
			break;
		case DIV:
			Div div_o = (Div) original;
			Div div_c = (Div) copy;
			div_c.getOtherAttributes().putAll(div_o.getOtherAttributes());
			listSize = div_o.getContent().size();
			for (int i = 0; i < listSize; i++) {
				execute(div_o.getContent().get(i), div_c.getContent().get(i));
			}
			break;
		case DL:
			break;
		case DT:
			break;
		case EM:
			break;
		case EMBED:
			break;
		case FIELDSET:
			break;
		case FIGCAPTION:
			break;
		case FIGURE:
			break;
		case FONT:
			break;
		case FOOTER:
			break;
		case FORM:
			break;
		case H1:
			break;
		case H2:
			break;
		case H3:
			break;
		case H4:
			break;
		case H5:
			break;
		case H6:
			break;
		case HEAD:
			break;
		case HEADER:
			break;
		case HGROUP:
			break;
		case HR:
			break;
		case HTML:
			Html html_original = (Html) original;
			Html html_copy = (Html) copy;
			html_copy.getOtherAttributes().putAll(
					html_original.getOtherAttributes());
			if (html_original.isSetBody()) {
				execute(html_original.getBody(), html_copy.getBody());
			}
			if (html_original.isSetHead()) {
				execute(html_original.getHead(), html_copy.getHead());
			}
			break;
		case I:
			break;
		case IFRAME:
			break;
		case IMG:
			break;
		case INPUT:
			break;
		case INS:
			break;
		case ISINDEX:
			break;
		case KBD:
			break;
		case KEYGEN:
			break;
		case LABEL:
			break;
		case LEGEND:
			break;
		case LI:
			break;
		case LINK:
			break;
		case MAP:
			break;
		case MARK:
			break;
		case MENU:
			break;
		case META:
			break;
		case METER:
			break;
		case NAV:
			break;
		case NOFRAMES:
			break;
		case NOSCRIPT:
			break;
		case OBJECT:
			break;
		case OL:
			break;
		case OPTGROUP:
			break;
		case OPTION:
			break;
		case OUTPUT:
			break;
		case P:
			break;
		case PARAM:
			break;
		case PRE:
			break;
		case PROGRESS:
			break;
		case Q:
			break;
		case RP:
			break;
		case RT:
			break;
		case RUBY:
			break;
		case S:
			break;
		case SAMP:
			break;
		case SCRIPT:
			break;
		case SECTION:
			break;
		case SELECT:
			break;
		case SMALL:
			break;
		case SOURCE:
			break;
		case SPAN:
			break;
		case STRIKE:
			break;
		case STRONG:
			break;
		case STYLE:
			break;
		case SUB:
			break;
		case SUMMARY:
			break;
		case SUP:
			break;
		case TABLE:
			break;
		case TBODY:
			break;
		case TD:
			break;
		case TEXTAREA:
			break;
		case TFOOT:
			break;
		case TH:
			break;
		case THEAD:
			break;
		case TIME:
			break;
		case TITLE:
			break;
		case TR:
			break;
		case TRACK:
			break;
		case TT:
			break;
		case U:
			break;
		case UL:
			break;
		case VAR:
			break;
		case VIDEO:
			break;
		case WBR:
			break;
		default:
			break;
		}
	}

}

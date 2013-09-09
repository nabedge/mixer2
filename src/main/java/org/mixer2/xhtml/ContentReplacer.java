package org.mixer2.xhtml;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.A;
import org.mixer2.jaxb.xhtml.Abbr;
import org.mixer2.jaxb.xhtml.Acronym;
import org.mixer2.jaxb.xhtml.Address;

public class ContentReplacer {

    private static Log log = LogFactory.getLog(ContentReplacer.class);

    public static <T extends AbstractJaxb> boolean replace(T target,
            T replacement) {
        // TODO
        return true;
    }

    public static <T extends AbstractJaxb> boolean replace(T target,
            String replacement) {
        // TODO
        return true;
    }

    public static <T extends AbstractJaxb> boolean replace(T target,
            List<Object> replacement) {
        return _replace(target, replacement);
    }

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> boolean _replace(T target,
            Object replacement) {
        TagEnum tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                .toUpperCase());
        switch (tagEnum) {
        case A:
            A a = (A) target;
            a.unsetContent();
            if (replacement instanceof List) {
                a.getContent().addAll((List<Object>) replacement);
            } else {
                a.getContent().add(replacement);
            }
            return true;
        case ABBR:
            Abbr abbr = (Abbr) target;
            abbr.unsetContent();
            if (replacement instanceof List) {
                abbr.getContent().addAll((List<Object>) replacement);
            } else {
                abbr.getContent().add(replacement);
            }
            return true;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            acronym.unsetContent();
            if (replacement instanceof List) {
                acronym.getContent().addAll((List<Object>) replacement);
            } else {
                acronym.getContent().add(replacement);
            }
            return true;
        case ADDRESS:
            Address address = (Address) target;
            address.unsetContent();
            if (replacement instanceof List) {
                address.getContent().addAll((List<Object>) replacement);
            } else {
                address.getContent().add(replacement);
            }
            return true;
        case APPLET:
            break;
        case AREA:
            break;
        case ARTICLE:
            break;
        case ASIDE:
            break;
        case AUDIO:
            break;
        case B:
            break;
        case BASE:
            break;
        case BASEFONT:
            break;
        case BDI:
            break;
        case BDO:
            break;
        case BIG:
            break;
        case BLOCKQUOTE:
            break;
        case BODY:
            break;
        case BR:
            break;
        case BUTTON:
            break;
        case CANVAS:
            break;
        case CAPTION:
            break;
        case CENTER:
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
        return false;
    }
}

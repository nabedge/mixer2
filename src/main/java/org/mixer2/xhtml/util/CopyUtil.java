package org.mixer2.xhtml.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.jaxb.xhtml.Object;
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

        switch (tagEnum) {
        case A:
            A a_orig = (A) original;
            A a_copy = (A) copy;
            a_copy.getOtherAttributes().putAll(a_orig.getOtherAttributes());
            executeForObjectList(a_orig.getContent(), a_copy.getContent());
            break;
        case ABBR:
            Abbr abbr_orig = (Abbr) original;
            Abbr abbr_copy = (Abbr) copy;
            abbr_copy.getOtherAttributes().putAll(
                    abbr_orig.getOtherAttributes());
            executeForObjectList(abbr_orig.getContent(), abbr_copy.getContent());
            break;
        case ACRONYM:
            Acronym acronym_orig = (Acronym) original;
            Acronym acronym_copy = (Acronym) copy;
            acronym_copy.getOtherAttributes().putAll(
                    acronym_orig.getOtherAttributes());
            executeForObjectList(acronym_orig.getContent(),
                    acronym_copy.getContent());
            break;
        case ADDRESS:
            Address address_original = (Address) original;
            Address address_copy = (Address) copy;
            address_copy.getOtherAttributes().putAll(
                    address_original.getOtherAttributes());
            executeForObjectList(address_original.getContent(),
                    address_copy.getContent());
            break;
        case APPLET:
            Applet applet_original = (Applet) original;
            Applet applet_copy = (Applet) copy;
            applet_copy.getOtherAttributes().putAll(
                    applet_copy.getOtherAttributes());
            executeForObjectList(applet_original.getContent(),
                    applet_copy.getContent());
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
            executeForObjectList(article_original.getContent(),
                    article_copy.getContent());
            break;
        case ASIDE:
            Aside aside_original = (Aside) original;
            Aside aside_copy = (Aside) copy;
            aside_copy.getOtherAttributes().putAll(
                    aside_original.getOtherAttributes());
            executeForObjectList(aside_original.getContent(),
                    aside_copy.getContent());
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
            executeForObjectList(b_original.getContent(), b_copy.getContent());
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
            executeForObjectList(bdi_original.getContent(),
                    bdi_copy.getContent());
            break;
        case BDO:
            Bdo bdo_original = (Bdo) original;
            Bdo bdo_copy = (Bdo) copy;
            bdo_copy.getOtherAttributes().putAll(
                    bdo_original.getOtherAttributes());
            executeForObjectList(bdo_original.getContent(),
                    bdo_copy.getContent());
            break;
        case BIG:
            Big big_original = (Big) original;
            Big big_copy = (Big) copy;
            big_copy.getOtherAttributes().putAll(
                    big_original.getOtherAttributes());
            executeForObjectList(big_original.getContent(),
                    big_copy.getContent());
            break;
        case BLOCKQUOTE:
            Blockquote blockquote_original = (Blockquote) original;
            Blockquote blockquote_copy = (Blockquote) copy;
            blockquote_copy.getOtherAttributes().putAll(
                    blockquote_original.getOtherAttributes());
            executeForObjectList(blockquote_original.getContent(),
                    blockquote_copy.getContent());
            break;
        case BODY:
            Body body_orig = (Body) original;
            Body body_copy = (Body) copy;
            body_copy.getOtherAttributes().putAll(
                    body_orig.getOtherAttributes());
            executeForObjectList(body_orig.getContent(), body_copy.getContent());
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
            executeForObjectList(button_original.getContent(),
                    button_copy.getContent());
            break;
        case CANVAS:
            Canvas canvas_original = (Canvas) original;
            Canvas canvas_copy = (Canvas) copy;
            canvas_copy.getOtherAttributes().putAll(
                    canvas_original.getOtherAttributes());
            executeForObjectList(canvas_original.getContent(),
                    canvas_copy.getContent());
            break;
        case CAPTION:
            Caption caption_original = (Caption) original;
            Caption caption_copy = (Caption) copy;
            caption_copy.getOtherAttributes().putAll(
                    caption_original.getOtherAttributes());
            executeForObjectList(caption_original.getContent(),
                    caption_copy.getContent());
            break;
        case CENTER:
            Center center_original = (Center) original;
            Center center_copy = (Center) copy;
            center_copy.getOtherAttributes().putAll(
                    center_original.getOtherAttributes());
            executeForObjectList(center_original.getContent(),
                    center_copy.getContent());
            break;
        case CITE:
            Cite cite_original = (Cite) original;
            Cite cite_copy = (Cite) copy;
            cite_copy.getOtherAttributes().putAll(
                    cite_original.getOtherAttributes());
            executeForObjectList(cite_original.getContent(),
                    cite_copy.getContent());
            break;
        case CODE:
            Code code_orig = (Code) original;
            Code code_copy = (Code) copy;
            code_copy.getOtherAttributes().putAll(
                    code_orig.getOtherAttributes());
            executeForObjectList(code_orig.getContent(), code_copy.getContent());
            break;
        case COL:
            Col col_original = (Col) original;
            Col col_copy = (Col) copy;
            col_copy.getOtherAttributes().putAll(
                    col_original.getOtherAttributes());
            // empty element
            break;
        case COLGROUP:
            Colgroup colg_orig = (Colgroup) original;
            Colgroup colg_copy = (Colgroup) copy;
            colg_copy.getOtherAttributes().putAll(
                    colg_orig.getOtherAttributes());
            executeForObjectList(colg_orig.getCol(), colg_copy.getCol());
            break;
        case COMMAND:
            Command command_orig = (Command) original;
            Command command_copy = (Command) copy;
            command_copy.getOtherAttributes().putAll(
                    command_orig.getOtherAttributes());
            // empty element
            break;
        case DATALIST:
            Datalist datalist_orig = (Datalist) original;
            Datalist datalist_copy = (Datalist) copy;
            datalist_copy.getOtherAttributes().putAll(
                    datalist_orig.getOtherAttributes());
            executeForObjectList(datalist_orig.getContent(),
                    datalist_copy.getContent());
            break;
        case DD:
            Dd dd_orig = (Dd) original;
            Dd dd_copy = (Dd) copy;
            dd_copy.getOtherAttributes().putAll(dd_orig.getOtherAttributes());
            executeForObjectList(dd_orig.getContent(), dd_copy.getContent());
            break;
        case DEL:
            Del del_orig = (Del) original;
            Del del_copy = (Del) copy;
            del_copy.getOtherAttributes().putAll(del_orig.getOtherAttributes());
            executeForObjectList(del_orig.getContent(), del_copy.getContent());
            break;
        case DETAILS:
            Details details_orig = (Details) original;
            Details details_copy = (Details) copy;
            details_copy.getOtherAttributes().putAll(
                    details_orig.getOtherAttributes());
            executeForObjectList(details_orig.getContent(),
                    details_copy.getContent());
            break;
        case DFN:
            Dfn dfn_orig = (Dfn) original;
            Dfn dfn_copy = (Dfn) copy;
            dfn_copy.getOtherAttributes().putAll(dfn_orig.getOtherAttributes());
            executeForObjectList(dfn_orig.getContent(), dfn_copy.getContent());
            break;
        case DIR:
            Dir dir_orig = (Dir) original;
            Dir dir_copy = (Dir) copy;
            dir_copy.getOtherAttributes().putAll(dir_orig.getOtherAttributes());
            executeForObjectList(dir_orig.getLi(), dir_copy.getLi());
            break;
        case DIV:
            Div div_orig = (Div) original;
            Div div_copy = (Div) copy;
            div_copy.getOtherAttributes().putAll(div_orig.getOtherAttributes());
            executeForObjectList(div_orig.getContent(), div_copy.getContent());
            break;
        case DL:
            Dl dl_orig = (Dl) original;
            Dl dl_copy = (Dl) copy;
            dl_copy.getOtherAttributes().putAll(dl_orig.getOtherAttributes());
            executeForObjectList(dl_orig.getDtOrDd(), dl_copy.getDtOrDd());
            break;
        case DT:
            Dt dt_orig = (Dt) original;
            Dt dt_copy = (Dt) copy;
            dt_copy.getOtherAttributes().putAll(dt_orig.getOtherAttributes());
            executeForObjectList(dt_orig.getContent(), dt_copy.getContent());
            break;
        case EM:
            Em em_orig = (Em) original;
            Em em_copy = (Em) copy;
            em_copy.getOtherAttributes().putAll(em_orig.getOtherAttributes());
            executeForObjectList(em_orig.getContent(), em_copy.getContent());
            break;
        case EMBED:
            Embed embed_orig = (Embed) original;
            Embed embed_copy = (Embed) copy;
            embed_copy.getOtherAttributes().putAll(
                    embed_orig.getOtherAttributes());
            // empty element
            break;
        case FIELDSET:
            Fieldset fieldset_orig = (Fieldset) original;
            Fieldset fieldset_copy = (Fieldset) copy;
            fieldset_copy.getOtherAttributes().putAll(
                    fieldset_orig.getOtherAttributes());
            executeForObjectList(fieldset_orig.getContent(),
                    fieldset_copy.getContent());
            break;
        case FIGCAPTION:
            Figcaption figcaption_orig = (Figcaption) original;
            Figcaption figcaption_copy = (Figcaption) copy;
            figcaption_copy.getOtherAttributes().putAll(
                    figcaption_orig.getOtherAttributes());
            executeForObjectList(figcaption_orig.getContent(),
                    figcaption_copy.getContent());
            break;
        case FIGURE:
            Figure figure_orig = (Figure) original;
            Figure figure_copy = (Figure) copy;
            figure_copy.getOtherAttributes().putAll(
                    figure_orig.getOtherAttributes());
            executeForObjectList(figure_orig.getContent(),
                    figure_copy.getContent());
            break;
        case FONT:
            Font font_orig = (Font) original;
            Font font_copy = (Font) copy;
            font_copy.getOtherAttributes().putAll(
                    font_orig.getOtherAttributes());
            executeForObjectList(font_orig.getContent(), font_copy.getContent());
            break;
        case FOOTER:
            Footer footer_orig = (Footer) original;
            Footer footer_copy = (Footer) copy;
            footer_copy.getOtherAttributes().putAll(
                    footer_orig.getOtherAttributes());
            executeForObjectList(footer_orig.getContent(),
                    footer_copy.getContent());
            break;
        case FORM:
            Form form_orig = (Form) original;
            Form form_copy = (Form) copy;
            form_copy.getOtherAttributes().putAll(
                    form_orig.getOtherAttributes());
            executeForObjectList(form_orig.getContent(), form_copy.getContent());
            break;
        case H1:
            H1 h1_orig = (H1) original;
            H1 h1_copy = (H1) copy;
            h1_copy.getOtherAttributes().putAll(h1_orig.getOtherAttributes());
            executeForObjectList(h1_orig.getContent(), h1_copy.getContent());
            break;
        case H2:
            H2 h2_orig = (H2) original;
            H2 h2_copy = (H2) copy;
            h2_copy.getOtherAttributes().putAll(h2_orig.getOtherAttributes());
            executeForObjectList(h2_orig.getContent(), h2_copy.getContent());
            break;
        case H3:
            H3 h3_orig = (H3) original;
            H3 h3_copy = (H3) copy;
            h3_copy.getOtherAttributes().putAll(h3_orig.getOtherAttributes());
            executeForObjectList(h3_orig.getContent(), h3_copy.getContent());
            break;
        case H4:
            H4 h4_orig = (H4) original;
            H4 h4_copy = (H4) copy;
            h4_copy.getOtherAttributes().putAll(h4_orig.getOtherAttributes());
            executeForObjectList(h4_orig.getContent(), h4_copy.getContent());
            break;
        case H5:
            H5 h5_orig = (H5) original;
            H5 h5_copy = (H5) copy;
            h5_copy.getOtherAttributes().putAll(h5_orig.getOtherAttributes());
            executeForObjectList(h5_orig.getContent(), h5_copy.getContent());
            break;
        case H6:
            H6 h6_orig = (H6) original;
            H6 h6_copy = (H6) copy;
            h6_copy.getOtherAttributes().putAll(h6_orig.getOtherAttributes());
            executeForObjectList(h6_orig.getContent(), h6_copy.getContent());
            break;
        case HEAD:
            Head head_orig = (Head) original;
            Head head_copy = (Head) copy;
            head_copy.getOtherAttributes().putAll(
                    head_orig.getOtherAttributes());
            executeForObjectList(head_orig.getContent(), head_copy.getContent());
            break;
        case HEADER:
            Header header_orig = (Header) original;
            Header header_copy = (Header) copy;
            header_copy.getOtherAttributes().putAll(
                    header_orig.getOtherAttributes());
            executeForObjectList(header_orig.getContent(),
                    header_copy.getContent());
            break;
        case HGROUP:
            Hgroup hgroup_orig = (Hgroup) original;
            Hgroup hgroup_copy = (Hgroup) copy;
            hgroup_copy.getOtherAttributes().putAll(
                    hgroup_orig.getOtherAttributes());
            executeForObjectList(hgroup_orig.getH1OrH2OrH3(),
                    hgroup_copy.getH1OrH2OrH3());
            break;
        case HR:
            Hr hr_orig = (Hr) original;
            Hr hr_copy = (Hr) copy;
            hr_copy.getOtherAttributes().putAll(hr_orig.getOtherAttributes());
            // empty element
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
            I i_orig = (I) original;
            I i_copy = (I) copy;
            i_copy.getOtherAttributes().putAll(i_orig.getOtherAttributes());
            executeForObjectList(i_orig.getContent(), i_copy.getContent());
            break;
        case IFRAME:
            Iframe iframe_orig = (Iframe) original;
            Iframe iframe_copy = (Iframe) copy;
            iframe_copy.getOtherAttributes().putAll(
                    iframe_orig.getOtherAttributes());
            executeForObjectList(iframe_orig.getContent(),
                    iframe_copy.getContent());
            break;
        case IMG:
            Img img_orig = (Img) original;
            Img img_copy = (Img) copy;
            img_copy.getOtherAttributes().putAll(img_orig.getOtherAttributes());
            // empty element
            break;
        case INPUT:
            Input input_orig = (Input) original;
            Input input_copy = (Input) copy;
            input_copy.getOtherAttributes().putAll(
                    input_orig.getOtherAttributes());
            // empty element
            break;
        case INS:
            Ins ins_orig = (Ins) original;
            Ins ins_copy = (Ins) copy;
            ins_copy.getOtherAttributes().putAll(ins_orig.getOtherAttributes());
            executeForObjectList(ins_orig.getContent(), ins_copy.getContent());
            break;
        case ISINDEX:
            Isindex isindex_orig = (Isindex) original;
            Isindex isindex_copy = (Isindex) copy;
            isindex_copy.getOtherAttributes().putAll(
                    isindex_orig.getOtherAttributes());
            // empty element
            break;
        case KBD:
            Kbd kbd_orig = (Kbd) original;
            Kbd kbd_copy = (Kbd) copy;
            kbd_copy.getOtherAttributes().putAll(kbd_orig.getOtherAttributes());
            executeForObjectList(kbd_orig.getContent(), kbd_copy.getContent());
            break;
        case KEYGEN:
            Keygen keygen_orig = (Keygen) original;
            Keygen keygen_copy = (Keygen) copy;
            keygen_copy.getOtherAttributes().putAll(
                    keygen_orig.getOtherAttributes());
            // empty element
            break;
        case LABEL:
            Label label_orig = (Label) original;
            Label label_copy = (Label) copy;
            label_copy.getOtherAttributes().putAll(
                    label_orig.getOtherAttributes());
            executeForObjectList(label_orig.getContent(),
                    label_copy.getContent());
            break;
        case LEGEND:
            Legend legend_orig = (Legend) original;
            Legend legend_copy = (Legend) copy;
            legend_copy.getOtherAttributes().putAll(
                    legend_orig.getOtherAttributes());
            executeForObjectList(legend_orig.getContent(),
                    legend_copy.getContent());
            break;
        case LI:
            Li li_orig = (Li) original;
            Li li_copy = (Li) copy;
            li_copy.getOtherAttributes().putAll(li_orig.getOtherAttributes());
            executeForObjectList(li_orig.getContent(), li_copy.getContent());
            break;
        case LINK:
            Link link_orig = (Link) original;
            Link link_copy = (Link) copy;
            link_copy.getOtherAttributes().putAll(
                    link_orig.getOtherAttributes());
            // empty element
            break;
        case MAP:
            Map map_orig = (Map) original;
            Map map_copy = (Map) copy;
            map_copy.getOtherAttributes().putAll(map_orig.getOtherAttributes());
            executeForObjectList(map_orig.getArea(), map_copy.getArea());
            executeForObjectList(map_orig.getPOrH1OrH2(),
                    map_copy.getPOrH1OrH2());
            break;
        case MARK:
            Mark mark_orig = (Mark) original;
            Mark mark_copy = (Mark) copy;
            mark_copy.getOtherAttributes().putAll(
                    mark_orig.getOtherAttributes());
            executeForObjectList(mark_orig.getContent(), mark_copy.getContent());
            break;
        case MENU:
            Menu menu_orig = (Menu) original;
            Menu menu_copy = (Menu) copy;
            menu_copy.getOtherAttributes().putAll(
                    menu_orig.getOtherAttributes());
            executeForObjectList(menu_orig.getContent(), menu_copy.getContent());
            break;
        case META:
            Meta meta_orig = (Meta) original;
            Meta meta_copy = (Meta) copy;
            meta_copy.getOtherAttributes().putAll(
                    meta_orig.getOtherAttributes());
            // empty element
            break;
        case METER:
            Meter meter_orig = (Meter) original;
            Meter meter_copy = (Meter) copy;
            meter_copy.getOtherAttributes().putAll(
                    meter_orig.getOtherAttributes());
            executeForObjectList(meter_orig.getContent(),
                    meter_copy.getContent());
            break;
        case NAV:
            Nav nav_orig = (Nav) original;
            Nav nav_copy = (Nav) copy;
            nav_copy.getOtherAttributes().putAll(nav_orig.getOtherAttributes());
            executeForObjectList(nav_orig.getContent(), nav_copy.getContent());
            break;
        case NOFRAMES:
            Noframes noframes_orig = (Noframes) original;
            Noframes noframes_copy = (Noframes) copy;
            noframes_copy.getOtherAttributes().putAll(
                    noframes_orig.getOtherAttributes());
            executeForObjectList(noframes_orig.getContent(),
                    noframes_copy.getContent());
            break;
        case NOSCRIPT:
            Noscript noscript_orig = (Noscript) original;
            Noscript noscript_copy = (Noscript) copy;
            noscript_copy.getOtherAttributes().putAll(
                    noscript_orig.getOtherAttributes());
            executeForObjectList(noscript_orig.getContent(),
                    noscript_copy.getContent());
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object_orig = (Object) original;
            org.mixer2.jaxb.xhtml.Object object_copy = (Object) copy;
            object_copy.getOtherAttributes().putAll(
                    object_orig.getOtherAttributes());
            executeForObjectList(object_orig.getContent(),
                    object_copy.getContent());
            break;
        case OL:
            Ol ol_orig = (Ol)original;
            Ol ol_copy = (Ol)copy;
            ol_copy.getOtherAttributes().putAll(ol_orig.getOtherAttributes());
            executeForObjectList(ol_orig.getLi(), ol_copy.getLi());
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

    private static <T> void executeForObjectList(List<T> original, List<T> copy) {
        int listSize = original.size();
        for (int i = 0; i < listSize; i++) {
            execute(original.get(i), copy.get(i));
        }

    }

}

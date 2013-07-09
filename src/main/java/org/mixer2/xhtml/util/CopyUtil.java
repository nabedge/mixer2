package org.mixer2.xhtml.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.jaxb.xhtml.Object;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;

/**
 * 
 * @see org.mixer2.xhtml.AbstractJaxb#copy(Class)
 * 
 * @author watanabe
 */
public class CopyUtil {

    private static Log log = LogFactory.getLog(CopyUtil.class);

    public static <T extends AbstractJaxb> void copyOtherAttr(T original, T copy) {
        if (!(original instanceof AbstractJaxb)
                || !(copy instanceof AbstractJaxb)) {
            return;
        }
        execute(original, copy);
    }

    private static <T> void executeForObjectList(List<T> original, List<T> copy) {
        int listSize = original.size();
        for (int i = 0; i < listSize; i++) {
            execute(original.get(i), copy.get(i));
        }
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
            Ol ol_orig = (Ol) original;
            Ol ol_copy = (Ol) copy;
            ol_copy.getOtherAttributes().putAll(ol_orig.getOtherAttributes());
            executeForObjectList(ol_orig.getLi(), ol_copy.getLi());
            break;
        case OPTGROUP:
            Optgroup optgroup_orig = (Optgroup) original;
            Optgroup optgroup_copy = (Optgroup) copy;
            optgroup_copy.getOtherAttributes().putAll(
                    optgroup_orig.getOtherAttributes());
            executeForObjectList(optgroup_orig.getOption(),
                    optgroup_copy.getOption());
            break;
        case OPTION:
            Option option_orig = (Option) original;
            Option option_copy = (Option) copy;
            option_copy.getOtherAttributes().putAll(
                    option_orig.getOtherAttributes());
            // empty element
            break;
        case OUTPUT:
            Output output_orig = (Output) original;
            Output output_copy = (Output) copy;
            output_copy.getOtherAttributes().putAll(
                    output_orig.getOtherAttributes());
            executeForObjectList(output_orig.getContent(),
                    output_copy.getContent());
            break;
        case P:
            P p_orig = (P) original;
            P p_copy = (P) copy;
            p_copy.getOtherAttributes().putAll(p_orig.getOtherAttributes());
            executeForObjectList(p_orig.getContent(), p_copy.getContent());
            break;
        case PARAM:
            Param param_orig = (Param) original;
            Param param_copy = (Param) copy;
            param_copy.getOtherAttributes().putAll(
                    param_orig.getOtherAttributes());
            // empty element
            break;
        case PRE:
            Pre pre_orig = (Pre) original;
            Pre pre_copy = (Pre) copy;
            pre_copy.getOtherAttributes().putAll(pre_orig.getOtherAttributes());
            executeForObjectList(pre_orig.getContent(), pre_copy.getContent());
            break;
        case PROGRESS:
            Progress progress_orig = (Progress) original;
            Progress progress_copy = (Progress) copy;
            progress_copy.getOtherAttributes().putAll(
                    progress_orig.getOtherAttributes());
            executeForObjectList(progress_orig.getContent(),
                    progress_copy.getContent());
            break;
        case Q:
            Q q_orig = (Q) original;
            Q q_copy = (Q) copy;
            q_copy.getOtherAttributes().putAll(q_orig.getOtherAttributes());
            executeForObjectList(q_orig.getContent(), q_copy.getContent());
            break;
        case RP:
            Rp rp_orig = (Rp) original;
            Rp rp_copy = (Rp) copy;
            rp_copy.getOtherAttributes().putAll(rp_orig.getOtherAttributes());
            break;
        case RT:
            Rt rt_orig = (Rt) original;
            Rt rt_copy = (Rt) copy;
            rt_copy.getOtherAttributes().putAll(rt_orig.getOtherAttributes());
            executeForObjectList(rt_orig.getContent(), rt_copy.getContent());
            break;
        case RUBY:
            Ruby ruby_orig = (Ruby) original;
            Ruby ruby_copy = (Ruby) copy;
            ruby_copy.getOtherAttributes().putAll(
                    ruby_orig.getOtherAttributes());
            executeForObjectList(ruby_orig.getContent(), ruby_copy.getContent());
            break;
        case S:
            S s_orig = (S) original;
            S s_copy = (S) copy;
            s_copy.getOtherAttributes().putAll(s_orig.getOtherAttributes());
            executeForObjectList(s_orig.getContent(), s_copy.getContent());
            break;
        case SAMP:
            Samp samp_orig = (Samp) original;
            Samp samp_copy = (Samp) copy;
            samp_copy.getOtherAttributes().putAll(
                    samp_orig.getOtherAttributes());
            executeForObjectList(samp_orig.getContent(), samp_copy.getContent());
            break;
        case SCRIPT:
            Script script_orig = (Script) original;
            Script script_copy = (Script) copy;
            script_copy.getOtherAttributes().putAll(
                    script_orig.getOtherAttributes());
            // includes no other element.
            break;
        case SECTION:
            Section section_orig = (Section) original;
            Section section_copy = (Section) copy;
            section_copy.getOtherAttributes().putAll(
                    section_orig.getOtherAttributes());
            executeForObjectList(section_orig.getContent(),
                    section_copy.getContent());
            break;
        case SELECT:
            Select select_orig = (Select) original;
            Select select_copy = (Select) copy;
            select_copy.getOtherAttributes().putAll(
                    select_orig.getOtherAttributes());
            executeForObjectList(select_orig.getOptgroupOrOption(),
                    select_copy.getOptgroupOrOption());
            break;
        case SMALL:
            Small small_orig = (Small) original;
            Small small_copy = (Small) copy;
            small_copy.getOtherAttributes().putAll(
                    small_orig.getOtherAttributes());
            executeForObjectList(small_orig.getContent(),
                    small_copy.getContent());
            break;
        case SOURCE:
            Source source_orig = (Source) original;
            Source source_copy = (Source) copy;
            source_copy.getOtherAttributes().putAll(
                    source_orig.getOtherAttributes());
            // empty element
            break;
        case SPAN:
            Span span_orig = (Span) original;
            Span span_copy = (Span) copy;
            span_copy.getOtherAttributes().putAll(
                    span_orig.getOtherAttributes());
            executeForObjectList(span_orig.getContent(), span_copy.getContent());
            break;
        case STRIKE:
            Strike strike_orig = (Strike) original;
            Strike strike_copy = (Strike) copy;
            strike_copy.getOtherAttributes().putAll(
                    strike_orig.getOtherAttributes());
            executeForObjectList(strike_orig.getContent(),
                    strike_copy.getContent());
            break;
        case STRONG:
            Strong strong_orig = (Strong) original;
            Strong strong_copy = (Strong) copy;
            strong_copy.getOtherAttributes().putAll(
                    strong_orig.getOtherAttributes());
            executeForObjectList(strong_orig.getContent(),
                    strong_copy.getContent());
            break;
        case STYLE:
            Style style_orig = (Style) original;
            Style style_copy = (Style) copy;
            style_copy.getOtherAttributes().putAll(
                    style_orig.getOtherAttributes());
            // includes no other element.
            break;
        case SUB:
            Sub sub_orig = (Sub) original;
            Sub sub_copy = (Sub) copy;
            sub_copy.getOtherAttributes().putAll(sub_orig.getOtherAttributes());
            executeForObjectList(sub_orig.getContent(), sub_copy.getContent());
            break;
        case SUMMARY:
            Summary summary_orig = (Summary) original;
            Summary summary_copy = (Summary) copy;
            summary_copy.getOtherAttributes().putAll(
                    summary_orig.getOtherAttributes());
            executeForObjectList(summary_orig.getContent(),
                    summary_copy.getContent());
            break;
        case SUP:
            Sup sup_orig = (Sup) original;
            Sup sup_copy = (Sup) copy;
            sup_copy.getOtherAttributes().putAll(sup_orig.getOtherAttributes());
            executeForObjectList(sup_orig.getContent(), sup_copy.getContent());
            break;
        case TABLE:
            Table table_orig = (Table) original;
            Table table_copy = (Table) copy;
            table_copy.getOtherAttributes().putAll(
                    table_orig.getOtherAttributes());
            if (table_orig.isSetThead()) {
                execute(table_orig.getThead(), table_copy.getThead());
            }
            if (table_orig.isSetTfoot()) {
                execute(table_orig.getTfoot(), table_copy.getTfoot());
            }
            if (table_orig.isSetCaption()) {
                execute(table_orig.getCaption(), table_copy.getCaption());
            }
            executeForObjectList(table_orig.getTr(), table_copy.getTr());
            executeForObjectList(table_orig.getTbody(), table_copy.getTbody());
            executeForObjectList(table_orig.getCol(), table_copy.getCol());
            executeForObjectList(table_orig.getColgroup(),
                    table_copy.getColgroup());
            break;
        case TBODY:
            Tbody tbody_orig = (Tbody) original;
            Tbody tbody_copy = (Tbody) copy;
            tbody_copy.getOtherAttributes().putAll(
                    tbody_orig.getOtherAttributes());
            executeForObjectList(tbody_orig.getTr(), tbody_copy.getTr());
            break;
        case TD:
            Td td_orig = (Td) original;
            Td td_copy = (Td) copy;
            td_copy.getOtherAttributes().putAll(td_orig.getOtherAttributes());
            executeForObjectList(td_orig.getContent(), td_copy.getContent());
            break;
        case TEXTAREA:
            Textarea textarea_orig = (Textarea) original;
            Textarea textarea_copy = (Textarea) copy;
            textarea_copy.getOtherAttributes().putAll(
                    textarea_orig.getOtherAttributes());
            // icludes no other element.
            break;
        case TFOOT:
            Tfoot tfoot_orig = (Tfoot) original;
            Tfoot tfoot_copy = (Tfoot) copy;
            tfoot_copy.getOtherAttributes().putAll(
                    tfoot_orig.getOtherAttributes());
            executeForObjectList(tfoot_orig.getTr(), tfoot_copy.getTr());
            break;
        case TH:
            Th th_orig = (Th) original;
            Th th_copy = (Th) copy;
            th_copy.getOtherAttributes().putAll(th_orig.getOtherAttributes());
            executeForObjectList(th_orig.getContent(), th_copy.getContent());
            break;
        case THEAD:
            Thead thead_orig = (Thead) original;
            Thead thead_copy = (Thead) copy;
            thead_copy.getOtherAttributes().putAll(
                    thead_orig.getOtherAttributes());
            executeForObjectList(thead_orig.getTr(), thead_copy.getTr());
            break;
        case TIME:
            Time time_orig = (Time) original;
            Time time_copy = (Time) copy;
            time_copy.getOtherAttributes().putAll(
                    time_orig.getOtherAttributes());
            executeForObjectList(time_orig.getContent(), time_copy.getContent());
            break;
        case TITLE:
            Title title_orig = (Title) original;
            Title title_copy = (Title) copy;
            title_copy.getOtherAttributes().putAll(
                    title_orig.getOtherAttributes());
            // includes no other element.
            break;
        case TR:
            Tr tr_orig = (Tr) original;
            Tr tr_copy = (Tr) copy;
            tr_copy.getOtherAttributes().putAll(tr_orig.getOtherAttributes());
            executeForObjectList(tr_orig.getThOrTd(), tr_copy.getThOrTd());
            break;
        case TRACK:
            Track track_orig = (Track) original;
            Track track_copy = (Track) copy;
            track_copy.getOtherAttributes().putAll(
                    track_orig.getOtherAttributes());
            // empty element
            break;
        case TT:
            Tt tt_orig = (Tt) original;
            Tt tt_copy = (Tt) copy;
            tt_copy.getOtherAttributes().putAll(tt_orig.getOtherAttributes());
            executeForObjectList(tt_orig.getContent(), tt_copy.getContent());
            break;
        case U:
            U u_orig = (U) original;
            U u_copy = (U) copy;
            u_copy.getOtherAttributes().putAll(u_orig.getOtherAttributes());
            executeForObjectList(u_orig.getContent(), u_copy.getContent());
            break;
        case UL:
            Ul ul_orig = (Ul) original;
            Ul ul_copy = (Ul) copy;
            ul_copy.getOtherAttributes().putAll(ul_orig.getOtherAttributes());
            executeForObjectList(ul_orig.getLi(), ul_copy.getLi());
            break;
        case VAR:
            Var var_orig = (Var) original;
            Var var_copy = (Var) copy;
            var_copy.getOtherAttributes().putAll(var_orig.getOtherAttributes());
            executeForObjectList(var_orig.getContent(), var_copy.getContent());
            break;
        case VIDEO:
            Video video_orig = (Video)original;
            Video video_copy = (Video)copy;
            video_copy.getOtherAttributes().putAll(video_orig.getOtherAttributes());
            executeForObjectList(video_orig.getContent(), video_copy.getContent());
            break;
        case WBR:
            Wbr wbr_orig = (Wbr)original;
            Wbr wbr_copy = (Wbr)copy;
            wbr_copy.getOtherAttributes().putAll(wbr_orig.getOtherAttributes());
            // empty element
            break;
        default:
            break;
        }
    }
}

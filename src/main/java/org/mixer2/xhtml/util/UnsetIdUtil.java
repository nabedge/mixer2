package org.mixer2.xhtml.util;

import java.util.List;
import java.util.regex.Pattern;

import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;

/**
 *
 * @see org.mixer2.xhtml.AbstractJaxb#unsetAllId()
 * @see org.mixer2.xhtml.AbstractJaxb#unsetAllId(Pattern)
 * @author watanabe
 *
 */
public class UnsetIdUtil {

    public static <T extends AbstractJaxb> void unsetAllId(T target) {
        execute(target, null);
    }

    public static <T extends AbstractJaxb> void unsetAllId(T target,
            Pattern pattern) {
        execute(target, pattern);
    }

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> void unsetAllIdWithinObjectList(
            List<java.lang.Object> list, Pattern pattern) {
        for (java.lang.Object obj : list) {
            if (obj instanceof AbstractJaxb) {
                execute((T) obj, pattern);
            }
        }
    }

    private static boolean idMatch(String id, Pattern pattern) {
        if (pattern == null || id == null) {
            return true;
        }
        if (pattern.matcher(id).matches()) {
            return true;
        } else {
            return false;
        }
    }

    private static <T extends AbstractJaxb> void execute(T target,
            Pattern pattern) {

        TagEnum tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                .toUpperCase());

        switch (tagEnum) {
        case A:
            A a = (A) target;
            if (idMatch(a.getId(), pattern)) {
                a.setId(null);
            }
            unsetAllIdWithinObjectList(a.getContent(), pattern);
            break;
        case ABBR:
            Abbr abbr = (Abbr) target;
            if (idMatch(abbr.getId(), pattern)) {
                abbr.setId(null);
            }
            unsetAllIdWithinObjectList(abbr.getContent(), pattern);
            break;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            if (idMatch(acronym.getId(), pattern)) {
                acronym.setId(null);
            }
            unsetAllIdWithinObjectList(acronym.getContent(), pattern);
            break;
        case ADDRESS:
            Address address = (Address) target;
            if (idMatch(address.getId(), pattern)) {
                address.setId(null);
            }
            unsetAllIdWithinObjectList(address.getContent(), pattern);
            break;
        case APPLET:
            Applet applet = (Applet) target;
            if (idMatch(applet.getId(), pattern)) {
                applet.setId(null);
            }
            unsetAllIdWithinObjectList(applet.getContent(), pattern);
            break;
        case AREA:
            Area area = (Area) target;
            if (idMatch(area.getId(), pattern)) {
                area.setId(null);
            }
            // area is empty element.
            break;
        case B:
            B b = (B) target;
            if (idMatch(b.getId(), pattern)) {
                b.setId(null);
            }
            unsetAllIdWithinObjectList(b.getContent(), pattern);
            break;
        case BASE:
            Base base = (Base) target;
            if (idMatch(base.getId(), pattern)) {
                base.setId(null);
            }
            // empty element.
            break;
        case BASEFONT:
            Basefont basefont = (Basefont) target;
            if (idMatch(basefont.getId(), pattern)) {
                basefont.setId(null);
            }
            // empty element.
            break;
        case BDO:
            Bdo bdo = (Bdo) target;
            if (idMatch(bdo.getId(), pattern)) {
                bdo.setId(null);
            }
            unsetAllIdWithinObjectList(bdo.getContent(), pattern);
            break;
        case BIG:
            Big big = (Big) target;
            if (idMatch(big.getId(), pattern)) {
                big.setId(null);
            }
            unsetAllIdWithinObjectList(big.getContent(), pattern);
            break;
        case BLOCKQUOTE:
            Blockquote blockquote = (Blockquote) target;
            if (idMatch(blockquote.getId(), pattern)) {
                blockquote.setId(null);
            }
            unsetAllIdWithinObjectList(blockquote.getContent(), pattern);
            break;
        case BODY:
            Body body = (Body) target;
            if (idMatch(body.getId(), pattern)) {
                body.setId(null);
            }
            unsetAllIdWithinObjectList(body.getContent(), pattern);
            break;
        case BR:
            Br br = (Br) target;
            if (idMatch(br.getId(), pattern)) {
                br.setId(null);
            }
            // empty element.
            break;
        case BUTTON:
            Button button = (Button) target;
            if (idMatch(button.getId(), pattern)) {
                button.setId(null);
            }
            unsetAllIdWithinObjectList(button.getContent(), pattern);
            break;
        case CAPTION:
            Caption caption = (Caption) target;
            if (idMatch(caption.getId(), pattern)) {
                caption.setId(null);
            }
            unsetAllIdWithinObjectList(caption.getContent(), pattern);
            break;
        case CENTER:
            Center center = (Center) target;
            if (idMatch(center.getId(), pattern)) {
                center.setId(null);
            }
            unsetAllIdWithinObjectList(center.getContent(), pattern);
            break;
        case CITE:
            Cite cite = (Cite) target;
            if (idMatch(cite.getId(), pattern)) {
                cite.setId(null);
            }
            unsetAllIdWithinObjectList(cite.getContent(), pattern);
            break;
        case CODE:
            Code code = (Code) target;
            if (idMatch(code.getId(), pattern)) {
                code.setId(null);
            }
            unsetAllIdWithinObjectList(code.getContent(), pattern);
            break;
        case COL:
            Col col = (Col) target;
            if (idMatch(col.getId(), pattern)) {
                col.setId(null);
            }
            // empty element.
            break;
        case COLGROUP:
            Colgroup colgroup = (Colgroup) target;
            if (idMatch(colgroup.getId(), pattern)) {
                colgroup.setId(null);
            }
            for (Col tmpcol : colgroup.getCol()) {
                execute(tmpcol, pattern);
            }
            break;
        case DD:
            Dd dd = (Dd) target;
            if (idMatch(dd.getId(), pattern)) {
                dd.setId(null);
            }
            unsetAllIdWithinObjectList(dd.getContent(), pattern);
            break;
        case DEL:
            Del del = (Del) target;
            if (idMatch(del.getId(), pattern)) {
                del.setId(null);
            }
            unsetAllIdWithinObjectList(del.getContent(), pattern);
            break;
        case DFN:
            Dfn dfn = (Dfn) target;
            if (idMatch(dfn.getId(), pattern)) {
                dfn.setId(null);
            }
            unsetAllIdWithinObjectList(dfn.getContent(), pattern);
            break;
        case DIR:
            Dir dir = (Dir) target;
            if (idMatch(dir.getId(), pattern)) {
                dir.setId(null);
            }
            for (Li tmpli : dir.getLi()) {
                execute(tmpli, pattern);
            }
            break;
        case DIV:
            Div div = (Div) target;
            if (idMatch(div.getId(), pattern)) {
                div.setId(null);
            }
            unsetAllIdWithinObjectList(div.getContent(), pattern);
            break;
        case DL:
            Dl dl = (Dl) target;
            if (idMatch(dl.getId(), pattern)) {
                dl.setId(null);
            }
            for (AbstractJaxb aj : dl.getDtOrDd()) {
                execute(aj, pattern);
            }
            break;
        case DT:
            Dt dt = (Dt) target;
            if (idMatch(dt.getId(), pattern)) {
                dt.setId(null);
            }
            unsetAllIdWithinObjectList(dt.getContent(), pattern);
            break;
        case EM:
            Em em = (Em) target;
            if (idMatch(em.getId(), pattern)) {
                em.setId(null);
            }
            unsetAllIdWithinObjectList(em.getContent(), pattern);
            break;
        case FIELDSET:
            Fieldset fieldset = (Fieldset) target;
            if (idMatch(fieldset.getId(), pattern)) {
                fieldset.setId(null);
            }
            unsetAllIdWithinObjectList(fieldset.getContent(), pattern);
            break;
        case FONT:
            Font font = (Font) target;
            if (idMatch(font.getId(), pattern)) {
                font.setId(null);
            }
            unsetAllIdWithinObjectList(font.getContent(), pattern);
            break;
        case FORM:
            Form form = (Form) target;
            if (idMatch(form.getId(), pattern)) {
                form.setId(null);
            }
            unsetAllIdWithinObjectList(form.getContent(), pattern);
            break;
        case H1:
            H1 h1 = (H1) target;
            if (idMatch(h1.getId(), pattern)) {
                h1.setId(null);
            }
            unsetAllIdWithinObjectList(h1.getContent(), pattern);
            break;
        case H2:
            H2 h2 = (H2) target;
            if (idMatch(h2.getId(), pattern)) {
                h2.setId(null);
            }
            unsetAllIdWithinObjectList(h2.getContent(), pattern);
            break;
        case H3:
            H3 h3 = (H3) target;
            if (idMatch(h3.getId(), pattern)) {
                h3.setId(null);
            }
            unsetAllIdWithinObjectList(h3.getContent(), pattern);
            break;
        case H4:
            H4 h4 = (H4) target;
            if (idMatch(h4.getId(), pattern)) {
                h4.setId(null);
            }
            unsetAllIdWithinObjectList(h4.getContent(), pattern);
            break;
        case H5:
            H5 h5 = (H5) target;
            if (idMatch(h5.getId(), pattern)) {
                h5.setId(null);
            }
            unsetAllIdWithinObjectList(h5.getContent(), pattern);
            break;
        case H6:
            H6 h6 = (H6) target;
            if (idMatch(h6.getId(), pattern)) {
                h6.setId(null);
            }
            unsetAllIdWithinObjectList(h6.getContent(), pattern);
            break;
        case HGROUP:
            Hgroup hgroup = (Hgroup) target;
            if (idMatch(hgroup.getId(), pattern)) {
                hgroup.setId(null);
            }
            for (AbstractJaxb aj : hgroup.getH1OrH2OrH3()) {
                execute(aj, pattern);
            }
            break;
        case HEAD:
            Head head = (Head) target;
            if (idMatch(head.getId(), pattern)) {
                head.setId(null);
            }
            for (AbstractJaxb aj : head.getContent()) {
                execute(aj, pattern);
            }
            break;
        case HR:
            Hr hr = (Hr) target;
            if (idMatch(hr.getId(), pattern)) {
                hr.setId(null);
            }
            // hr is empty element.
            break;
        case HTML:
            Html html = (Html) target;
            if (idMatch(html.getId(), pattern)) {
                html.setId(null);
            }
            execute(html.getHead(), pattern);
            execute(html.getBody(), pattern);
            break;
        case I:
            I i = (I) target;
            if (idMatch(i.getId(), pattern)) {
                i.setId(null);
            }
            unsetAllIdWithinObjectList(i.getContent(), pattern);
            break;
        case IFRAME:
            Iframe iframe = (Iframe) target;
            if (idMatch(iframe.getId(), pattern)) {
                iframe.setId(null);
            }
            unsetAllIdWithinObjectList(iframe.getContent(), pattern);
            break;
        case IMG:
            Img img = (Img) target;
            if (idMatch(img.getId(), pattern)) {
                img.setId(null);
            }
            // img is empty element.
            break;
        case INPUT:
            Input input = (Input) target;
            if (idMatch(input.getId(), pattern)) {
                input.setId(null);
            }
            // input is empty element.
            break;
        case INS:
            Ins ins = (Ins) target;
            if (idMatch(ins.getId(), pattern)) {
                ins.setId(null);
            }
            unsetAllIdWithinObjectList(ins.getContent(), pattern);
            break;
        case ISINDEX:
            Isindex isindex = (Isindex) target;
            if (idMatch(isindex.getId(), pattern)) {
                isindex.setId(null);
            }
            // empty element.
            break;
        case KBD:
            Kbd kbd = (Kbd) target;
            if (idMatch(kbd.getId(), pattern)) {
                kbd.setId(null);
            }
            unsetAllIdWithinObjectList(kbd.getContent(), pattern);
            break;
        case LABEL:
            Label label = (Label) target;
            if (idMatch(label.getId(), pattern)) {
                label.setId(null);
            }
            unsetAllIdWithinObjectList(label.getContent(), pattern);
            break;
        case LEGEND:
            Legend legend = (Legend) target;
            if (idMatch(legend.getId(), pattern)) {
                legend.setId(null);
            }
            unsetAllIdWithinObjectList(legend.getContent(), pattern);
            break;
        case LI:
            Li li = (Li) target;
            if (idMatch(li.getId(), pattern)) {
                li.setId(null);
            }
            unsetAllIdWithinObjectList(li.getContent(), pattern);
            break;
        case LINK:
            Link link = (Link) target;
            if (idMatch(link.getId(), pattern)) {
                link.setId(null);
            }
            // empty element.
            break;
        case MAP:
            Map map = (Map) target;
            if (idMatch(map.getId(), pattern)) {
                map.setId(null);
            }
            for (Area tmpArea : map.getArea()) {
                execute(tmpArea, pattern);
            }
            break;
        case MENU:
            Menu menu = (Menu) target;
            if (idMatch(menu.getId(), pattern)) {
                menu.setId(null);
            }
            unsetAllIdWithinObjectList(menu.getContent(), pattern);
            break;
        case META:
            Meta meta = (Meta) target;
            if (idMatch(meta.getId(), pattern)) {
                meta.setId(null);
            }
            // empty element.
            break;
        case NOFRAMES:
            Noframes noframes = (Noframes) target;
            if (idMatch(noframes.getId(), pattern)) {
                noframes.setId(null);
            }
            unsetAllIdWithinObjectList(noframes.getContent(), pattern);
            break;
        case NOSCRIPT:
            Noscript noscript = (Noscript) target;
            if (idMatch(noscript.getId(), pattern)) {
                noscript.setId(null);
            }
            unsetAllIdWithinObjectList(noscript.getContent(), pattern);
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
            if (idMatch(object.getId(), pattern)) {
                object.setId(null);
            }
            unsetAllIdWithinObjectList(object.getContent(), pattern);
            break;
        case OL:
            Ol ol = (Ol) target;
            if (idMatch(ol.getId(), pattern)) {
                ol.setId(null);
            }
            for (Li tmpli : ol.getLi()) {
                execute(tmpli, pattern);
            }
            break;
        case OPTGROUP:
            Optgroup optgroup = (Optgroup) target;
            if (idMatch(optgroup.getId(), pattern)) {
                optgroup.setId(null);
            }
            for (Option tmpOption : optgroup.getOption()) {
                execute(tmpOption, pattern);
            }
            break;
        case OPTION:
            Option option = (Option) target;
            if (idMatch(option.getId(), pattern)) {
                option.setId(null);
            }
            // option tag includes no other element.
            break;
        case P:
            P p = (P) target;
            if (idMatch(p.getId(), pattern)) {
                p.setId(null);
            }
            unsetAllIdWithinObjectList(p.getContent(), pattern);
            break;
        case PARAM:
            Param param = (Param) target;
            if (idMatch(param.getId(), pattern)) {
                param.setId(null);
            }
            // empty element.
            break;
        case PRE:
            Pre pre = (Pre) target;
            if (idMatch(pre.getId(), pattern)) {
                pre.setId(null);
            }
            unsetAllIdWithinObjectList(pre.getContent(), pattern);
            break;
        case Q:
            Q q = (Q) target;
            if (idMatch(q.getId(), pattern)) {
                q.setId(null);
            }
            unsetAllIdWithinObjectList(q.getContent(), pattern);
            break;
        case S:
            S s = (S) target;
            if (idMatch(s.getId(), pattern)) {
                s.setId(null);
            }
            unsetAllIdWithinObjectList(s.getContent(), pattern);
            break;
        case SAMP:
            Samp samp = (Samp) target;
            if (idMatch(samp.getId(), pattern)) {
                samp.setId(null);
            }
            unsetAllIdWithinObjectList(samp.getContent(), pattern);
            break;
        case SCRIPT:
            Script script = (Script) target;
            if (idMatch(script.getId(), pattern)) {
                script.setId(null);
            }
            // script include no other element.
            break;
        case SELECT:
            Select select = (Select) target;
            if (idMatch(select.getId(), pattern)) {
                select.setId(null);
            }
            for (AbstractJaxb aj : select.getOptgroupOrOption()) {
                execute(aj, pattern);
            }
            break;
        case SMALL:
            Small small = (Small) target;
            if (idMatch(small.getId(), pattern)) {
                small.setId(null);
            }
            unsetAllIdWithinObjectList(small.getContent(), pattern);
            break;
        case SPAN:
            Span span = (Span) target;
            if (idMatch(span.getId(), pattern)) {
                span.setId(null);
            }
            unsetAllIdWithinObjectList(span.getContent(), pattern);
            break;
        case STRIKE:
            Strike strike = (Strike) target;
            if (idMatch(strike.getId(), pattern)) {
                strike.setId(null);
            }
            unsetAllIdWithinObjectList(strike.getContent(), pattern);
            break;
        case STRONG:
            Strong strong = (Strong) target;
            if (idMatch(strong.getId(), pattern)) {
                strong.setId(null);
            }
            unsetAllIdWithinObjectList(strong.getContent(), pattern);
            break;
        case STYLE:
            Style style = (Style) target;
            if (idMatch(style.getId(), pattern)) {
                style.setId(null);
            }
            // has no other element.
            break;
        case SUB:
            Sub sub = (Sub) target;
            if (idMatch(sub.getId(), pattern)) {
                sub.setId(null);
            }
            unsetAllIdWithinObjectList(sub.getContent(), pattern);
            break;
        case SUP:
            Sup sup = (Sup) target;
            if (idMatch(sup.getId(), pattern)) {
                sup.setId(null);
            }
            unsetAllIdWithinObjectList(sup.getContent(), pattern);
            break;
        case TABLE:
            Table table = (Table) target;
            if (idMatch(table.getId(), pattern)) {
                table.setId(null);
            }
            if (table.isSetCaption()) {
                execute(table.getCaption(), pattern);
            }
            for (Col tmpCol : table.getCol()) {
                execute(tmpCol, pattern);
            }
            for (Colgroup tmpColgroup : table.getColgroup()) {
                execute(tmpColgroup, pattern);
            }
            for (Tbody tmpTbody : table.getTbody()) {
                execute(tmpTbody, pattern);
            }
            if (table.isSetThead()) {
                execute(table.getThead(), pattern);
            }
            if (table.isSetTfoot()) {
                execute(table.getTfoot(), pattern);
            }
            for (Tr tmpTr : table.getTr()) {
                execute(tmpTr, pattern);
            }
            break;
        case TBODY:
            Tbody tbody = (Tbody) target;
            if (idMatch(tbody.getId(), pattern)) {
                tbody.setId(null);
            }
            for (Tr tmpTr : tbody.getTr()) {
                execute(tmpTr, pattern);
            }
            break;
        case TD:
            Td td = (Td) target;
            if (idMatch(td.getId(), pattern)) {
                td.setId(null);
            }
            unsetAllIdWithinObjectList(td.getContent(), pattern);
            break;
        case TEXTAREA:
            Textarea textarea = (Textarea) target;
            if (idMatch(textarea.getId(), pattern)) {
                textarea.setId(null);
            }
            // textarea has no other element.
            break;
        case TFOOT:
            Tfoot tfoot = (Tfoot) target;
            if (idMatch(tfoot.getId(), pattern)) {
                tfoot.setId(null);
            }
            for (Tr tmpTr : tfoot.getTr()) {
                execute(tmpTr, pattern);
            }
            break;
        case TH:
            Th th = (Th) target;
            if (idMatch(th.getId(), pattern)) {
                th.setId(null);
            }
            unsetAllIdWithinObjectList(th.getContent(), pattern);
            break;
        case THEAD:
            Thead thead = (Thead) target;
            if (idMatch(thead.getId(), pattern)) {
                thead.setId(null);
            }
            for (Tr tmpTr : thead.getTr()) {
                execute(tmpTr, pattern);
            }
            break;
        case TITLE:
            Title title = (Title) target;
            if (idMatch(title.getId(), pattern)) {
                title.setId(null);
            }
            // has no other element.
            break;
        case TR:
            Tr tr = (Tr) target;
            if (idMatch(tr.getId(), pattern)) {
                tr.setId(null);
            }
            for (AbstractJaxb aj : tr.getThOrTd()) {
                execute(aj, pattern);
            }
            break;
        case TT:
            Tt tt = (Tt) target;
            if (idMatch(tt.getId(), pattern)) {
                tt.setId(null);
            }
            unsetAllIdWithinObjectList(tt.getContent(), pattern);
            break;
        case U:
            U u = (U) target;
            if (idMatch(u.getId(), pattern)) {
                u.setId(null);
            }
            unsetAllIdWithinObjectList(u.getContent(), pattern);
            break;
        case UL:
            Ul ul = (Ul) target;
            if (idMatch(ul.getId(), pattern)) {
                ul.setId(null);
            }
            for (Li tmpLi : ul.getLi()) {
                execute(tmpLi, pattern);
            }
            break;
        case VAR:
            Var var = (Var) target;
            if (idMatch(var.getId(), pattern)) {
                var.setId(null);
            }
            unsetAllIdWithinObjectList(var.getContent(), pattern);
            break;
        case ARTICLE:
            Article article = (Article) target;
            if (idMatch(article.getId(), pattern)) {
                article.setId(null);
            }
            unsetAllIdWithinObjectList(article.getContent(), pattern);
            break;
        case ASIDE:
            Aside aside = (Aside) target;
            if (idMatch(aside.getId(), pattern)) {
                aside.setId(null);
            }
            unsetAllIdWithinObjectList(aside.getContent(), pattern);
            break;
        case AUDIO:
            Audio audio = (Audio) target;
            if (idMatch(audio.getId(), pattern)) {
                audio.setId(null);
            }
            unsetAllIdWithinObjectList(audio.getContent(), pattern);
            break;
        case BDI:
            Bdi bdi = (Bdi) target;
            if (idMatch(bdi.getId(), pattern)) {
                bdi.setId(null);
            }
            unsetAllIdWithinObjectList(bdi.getContent(), pattern);
            break;
        case CANVAS:
            Canvas canvas = (Canvas) target;
            if (idMatch(canvas.getId(), pattern)) {
                canvas.setId(null);
            }
            unsetAllIdWithinObjectList(canvas.getContent(), pattern);
            break;
        case COMMAND:
            Command command = (Command) target;
            if (idMatch(command.getId(), pattern)) {
                command.setId(null);
            }
            // empty element
            break;
        case DATALIST:
            Datalist datalist = (Datalist) target;
            if (idMatch(datalist.getId(), pattern)) {
                datalist.setId(null);
            }
            unsetAllIdWithinObjectList(datalist.getContent(), pattern);
            break;
        case DETAILS:
            Details details = (Details) target;
            if (idMatch(details.getId(), pattern)) {
                details.setId(null);
            }
            unsetAllIdWithinObjectList(details.getContent(), pattern);
            break;
        case EMBED:
            Embed embed = (Embed) target;
            if (idMatch(embed.getId(), pattern)) {
                embed.setId(null);
            }
            // empty element
            break;
        case FIGCAPTION:
            Figcaption figcaption = (Figcaption)target;
            if (idMatch(figcaption.getId(), pattern)) {
                figcaption.setId(null);
            }
            unsetAllIdWithinObjectList(figcaption.getContent(), pattern);
            break;
        case FIGURE:
            Figure figure = (Figure)target;
            if (idMatch(figure.getId(), pattern)) {
                figure.setId(null);
            }
            unsetAllIdWithinObjectList(figure.getContent(), pattern);
            break;
        case FOOTER:
            Footer footer = (Footer) target;
            if (idMatch(footer.getId(), pattern)) {
                footer.setId(null);
            }
            unsetAllIdWithinObjectList(footer.getContent(), pattern);
            break;
        case HEADER:
            Header header = (Header) target;
            if (idMatch(header.getId(), pattern)) {
                header.setId(null);
            }
            unsetAllIdWithinObjectList(header.getContent(), pattern);
            break;
        case KEYGEN:
            Keygen keygen = (Keygen)target;
            if (idMatch(keygen.getId(), pattern)) {
                keygen.setId(null);
            }
            // empty element
            break;
        case MARK:
            Mark mark = (Mark)target;
            if (idMatch(mark.getId(), pattern)) {
                mark.setId(null);
            }
            unsetAllIdWithinObjectList(mark.getContent(), pattern);
            break;
        case METER:
            Meter meter = (Meter)target;
            if (idMatch(meter.getId(), pattern)) {
                meter.setId(null);
            }
            unsetAllIdWithinObjectList(meter.getContent(), pattern);
            break;
        case NAV:
            Nav nav = (Nav)target;
            if (idMatch(nav.getId(), pattern)) {
                nav.setId(null);
            }
            unsetAllIdWithinObjectList(nav.getContent(), pattern);
            break;
        case OUTPUT:
            Output output = (Output)target;
            if (idMatch(output.getId(), pattern)) {
                output.setId(null);
            }
            unsetAllIdWithinObjectList(output.getContent(), pattern);
            break;
        case PROGRESS:
            Progress progress = (Progress)target;
            if (idMatch(progress.getId(), pattern)) {
                progress.setId(null);
            }
            unsetAllIdWithinObjectList(progress.getContent(), pattern);
            break;
        case RP:
            Rp rp = (Rp) target;
            if (idMatch(rp.getId(), pattern)) {
                rp.setId(null);
            }
            unsetAllIdWithinObjectList(rp.getContent(), pattern);
            break;
        case RT:
            Rt rt = (Rt)target;
            if (idMatch(rt.getId(), pattern)) {
                rt.setId(null);
            }
            unsetAllIdWithinObjectList(rt.getContent(), pattern);
            break;
        case RUBY:
            Ruby ruby = (Ruby)target;
            if (idMatch(ruby.getId(), pattern)) {
                ruby.setId(null);
            }
            unsetAllIdWithinObjectList(ruby.getContent(), pattern);
            break;
        case SECTION:
            Section section = (Section)target;
            if (idMatch(section.getId(), pattern)) {
                section.setId(null);
            }
            unsetAllIdWithinObjectList(section.getContent(), pattern);
            break;
        case SOURCE:
            Source source = (Source)target;
            if (idMatch(source.getId(), pattern)) {
                source.setId(null);
            }
            break;
        case SUMMARY:
            Summary summary = (Summary)target;
            if (idMatch(summary.getId(), pattern)) {
                summary.setId(null);
            }
            unsetAllIdWithinObjectList(summary.getContent(), pattern);
            break;
        case TIME:
            Time time = (Time) target;
            if (idMatch(time.getId(), pattern)) {
                time.setId(null);
            }
            unsetAllIdWithinObjectList(time.getContent(), pattern);
            break;
        case TRACK:
            Track track = (Track) target;
            if (idMatch(track.getId(), pattern)) {
                track.setId(null);
            }
            // empty element
            break;
        case VIDEO:
            Video video = (Video) target;
            if (idMatch(video.getId(), pattern)) {
                video.setId(null);
            }
            unsetAllIdWithinObjectList(video.getContent(), pattern);
            break;
        case WBR:
            Wbr wbr = (Wbr) target;
            if (idMatch(wbr.getId(), pattern)) {
                wbr.setId(null);
            }
            // empty element
            break;
        }
    }
}

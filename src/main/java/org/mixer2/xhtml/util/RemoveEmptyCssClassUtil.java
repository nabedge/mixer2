package org.mixer2.xhtml.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.*;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.TagEnum;

/**
 *
 * @see org.mixer2.xhtml.AbstractJaxb#removeEmptyCssClass()
 * @author watanabe
 *
 */
public class RemoveEmptyCssClassUtil {

    @SuppressWarnings("unused")
    private static Log log = LogFactory.getLog(RemoveEmptyCssClassUtil.class);

    @SuppressWarnings("unchecked")
    private static <T extends AbstractJaxb> void removeCssClassWithinObjectList(
            List<java.lang.Object> list) {
        for (java.lang.Object obj : list) {
            if (obj instanceof AbstractJaxb) {
                removeEmptyCssClass((T) obj);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends AbstractJaxb> void removeEmptyCssClass(T target) {

        if (target == null) {
            return;
        }

        TagEnum tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                .toUpperCase());

        switch (tagEnum) {
        case A:
            A a = (A) target;
            if (a.getCssClass().isEmpty()) {
                a.unsetCssClass();
            }
            if (a.isSetContent()) {
                removeCssClassWithinObjectList(a.getContent());
            }
            break;
        case ABBR:
            Abbr abbr = (Abbr) target;
            if (abbr.getCssClass().isEmpty()) {
                abbr.unsetCssClass();
            }
            if (abbr.isSetContent()) {
                removeCssClassWithinObjectList(abbr.getContent());
            }
            break;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            if (acronym.getCssClass().isEmpty()) {
                acronym.unsetCssClass();
            }
            if (acronym.isSetContent()) {
                removeCssClassWithinObjectList(acronym.getContent());
            }
            break;
        case ADDRESS:
            Address address = (Address) target;
            if (address.getCssClass().isEmpty()) {
                address.unsetCssClass();
            }
            if (address.isSetContent()) {
                removeCssClassWithinObjectList(address.getContent());
            }
            break;
        case APPLET:
            Applet applet = (Applet) target;
            if (applet.getCssClass().isEmpty()) {
                applet.unsetCssClass();
            }
            if (applet.isSetContent()) {
                removeCssClassWithinObjectList(applet.getContent());
            }
            break;
        case AREA:
            Area area = (Area) target;
            if (area.getCssClass().isEmpty()) {
                area.unsetCssClass();
            }
            // empty element
            break;
        case B:
            B b = (B) target;
            if (b.getCssClass().isEmpty()) {
                b.unsetCssClass();
            }
            if (b.isSetContent()) {
                removeCssClassWithinObjectList(b.getContent());
            }
            break;
        case BASE:
            Base base = (Base) target;
            if (base.getCssClass().isEmpty()) {
                base.unsetCssClass();
            }
            // empty element
            break;
        case BASEFONT:
            // Basefont basefont = (Basefont) target;
            // empty element
            break;
        case BDO:
            Bdo bdo = (Bdo) target;
            if (bdo.getCssClass().isEmpty()) {
                bdo.unsetCssClass();
            }
            if (bdo.isSetContent()) {
                removeCssClassWithinObjectList(bdo.getContent());
            }
            break;
        case BIG:
            Big big = (Big) target;
            if (big.getCssClass().isEmpty()) {
                big.unsetCssClass();
            }
            if (big.isSetContent()) {
                removeCssClassWithinObjectList(big.getContent());
            }
            break;
        case BLOCKQUOTE:
            Blockquote blockquote = (Blockquote) target;
            if (blockquote.getCssClass().isEmpty()) {
                blockquote.unsetCssClass();
            }
            if (blockquote.isSetContent()) {
                removeCssClassWithinObjectList(blockquote.getContent());
            }
            break;
        case BODY:
            Body body = (Body) target;
            if (body.getCssClass().isEmpty()) {
                body.unsetCssClass();
            }
            if (body.isSetContent()) {
                removeCssClassWithinObjectList(body.getContent());
            }
            break;
        case BR:
            Br br = (Br) target;
            if (br.getCssClass().isEmpty()) {
                br.unsetCssClass();
            }
            // empty element.
            break;
        case BUTTON:
            Button button = (Button) target;
            if (button.getCssClass().isEmpty()) {
                button.unsetCssClass();
            }
            if (button.isSetContent()) {
                removeCssClassWithinObjectList(button.getContent());
            }
            break;
        case CAPTION:
            Caption caption = (Caption) target;
            if (caption.getCssClass().isEmpty()) {
                caption.unsetCssClass();
            }
            if (caption.isSetContent()) {
                removeCssClassWithinObjectList(caption.getContent());
            }
            break;
        case CENTER:
            Center center = (Center) target;
            if (center.getCssClass().isEmpty()) {
                center.unsetCssClass();
            }
            if (center.isSetContent()) {
                removeCssClassWithinObjectList(center.getContent());
            }
            break;
        case CITE:
            Cite cite = (Cite) target;
            if (cite.getCssClass().isEmpty()) {
                cite.unsetCssClass();
            }
            if (cite.isSetContent()) {
                removeCssClassWithinObjectList(cite.getContent());
            }
            break;
        case CODE:
            Code code = (Code) target;
            if (code.getCssClass().isEmpty()) {
                code.unsetCssClass();
            }
            if (code.isSetContent()) {
                removeCssClassWithinObjectList(code.getContent());
            }
            break;
        case COL:
            Col col = (Col) target;
            if (col.getCssClass().isEmpty()) {
                col.unsetCssClass();
            }
            // empty element.
            break;
        case COLGROUP:
            Colgroup colgroup = (Colgroup) target;
            if (colgroup.getCssClass().isEmpty()) {
                colgroup.unsetCssClass();
            }
            if (colgroup.isSetCol()) {
                for (Col col1 : colgroup.getCol()) {
                    removeEmptyCssClass(col1);
                }
            }
            break;
        case DD:
            Dd dd = (Dd) target;
            if (dd.getCssClass().isEmpty()) {
                dd.unsetCssClass();
            }
            if (dd.isSetContent()) {
                removeCssClassWithinObjectList(dd.getContent());
            }
            break;
        case DEL:
            Del del = (Del) target;
            if (del.getCssClass().isEmpty()) {
                del.unsetCssClass();
            }
            if (del.isSetContent()) {
                removeCssClassWithinObjectList(del.getContent());
            }
            break;
        case DFN:
            Dfn dfn = (Dfn) target;
            if (dfn.getCssClass().isEmpty()) {
                dfn.unsetCssClass();
            }
            if (dfn.isSetContent()) {
                removeCssClassWithinObjectList(dfn.getContent());
            }
            break;
        case DIR:
            Dir dir = (Dir) target;
            if (dir.getCssClass().isEmpty()) {
                dir.unsetCssClass();
            }
            if (dir.isSetLi()) {
                for (Li li : dir.getLi()) {
                    removeEmptyCssClass(li);
                }
            }
            break;
        case DIV:
            Div div = (Div) target;
            if (div.getCssClass().isEmpty()) {
                div.unsetCssClass();
            }
            if (div.isSetContent()) {
                removeCssClassWithinObjectList(div.getContent());
            }
            break;
        case DL:
            Dl dl = (Dl) target;
            if (dl.getCssClass().isEmpty()) {
                dl.unsetCssClass();
            }
            if (dl.isSetDtOrDd()) {
                for (AbstractJaxb obj : dl.getDtOrDd()) {
                    removeEmptyCssClass(obj);
                }
            }
            break;
        case DT:
            Dt dt = (Dt) target;
            if (dt.getCssClass().isEmpty()) {
                dt.unsetCssClass();
            }
            if (dt.isSetContent()) {
                removeCssClassWithinObjectList(dt.getContent());
            }
            break;
        case EM:
            Em em = (Em) target;
            if (em.getCssClass().isEmpty()) {
                em.unsetCssClass();
            }
            if (em.isSetContent()) {
                removeCssClassWithinObjectList(em.getContent());
            }
            break;
        case FIELDSET:
            Fieldset fieldset = (Fieldset) target;
            if (fieldset.getCssClass().isEmpty()) {
                fieldset.unsetCssClass();
            }
            if (fieldset.isSetContent()) {
                removeCssClassWithinObjectList(fieldset.getContent());
            }
            break;
        case FONT:
            Font font = (Font) target;
            if (font.getCssClass().isEmpty()) {
                font.unsetCssClass();
            }
            if (font.isSetContent()) {
                removeCssClassWithinObjectList(font.getContent());
            }
            break;
        case FORM:
            Form form = (Form) target;
            if (form.getCssClass().isEmpty()) {
                form.unsetCssClass();
            }
            if (form.isSetContent()) {
                removeCssClassWithinObjectList(form.getContent());
            }
            break;
        case H1:
            H1 h1 = (H1) target;
            if (h1.getCssClass().isEmpty()) {
                h1.unsetCssClass();
            }
            if (h1.isSetContent()) {
                removeCssClassWithinObjectList(h1.getContent());
            }
            break;
        case H2:
            H2 h2 = (H2) target;
            if (h2.getCssClass().isEmpty()) {
                h2.unsetCssClass();
            }
            if (h2.isSetContent()) {
                removeCssClassWithinObjectList(h2.getContent());
            }
            break;
        case H3:
            H3 h3 = (H3) target;
            if (h3.getCssClass().isEmpty()) {
                h3.unsetCssClass();
            }
            if (h3.isSetContent()) {
                removeCssClassWithinObjectList(h3.getContent());
            }
            break;
        case H4:
            H4 h4 = (H4) target;
            if (h4.getCssClass().isEmpty()) {
                h4.unsetCssClass();
            }
            if (h4.isSetContent()) {
                removeCssClassWithinObjectList(h4.getContent());
            }
            break;
        case H5:
            H5 h5 = (H5) target;
            if (h5.getCssClass().isEmpty()) {
                h5.unsetCssClass();
            }
            if (h5.isSetContent()) {
                removeCssClassWithinObjectList(h5.getContent());
            }
            break;
        case H6:
            H6 h6 = (H6) target;
            if (h6.getCssClass().isEmpty()) {
                h6.unsetCssClass();
            }
            if (h6.isSetContent()) {
                removeCssClassWithinObjectList(h6.getContent());
            }
            break;
        case HGROUP:
            Hgroup hgroup = (Hgroup)target;
            if (hgroup.getCssClass().isEmpty()) {
                hgroup.unsetCssClass();
            }
            if (hgroup.isSetH1OrH2OrH3()) {
                for (AbstractJaxb obj : hgroup.getH1OrH2OrH3()) {
                    removeEmptyCssClass(obj);
                }
            }
            break;
        case HEAD:
            Head head = (Head) target;
            if (head.getCssClass().isEmpty()) {
                head.unsetCssClass();
            }
            for (AbstractJaxb obj : head.getContent()) {
                removeEmptyCssClass(obj);
            }
            break;
        case HR:
            Hr hr = (Hr) target;
            if (hr.getCssClass().isEmpty()) {
                hr.unsetCssClass();
            }
            // empty element.
            break;
        case HTML:
            Html html = (Html) target;
            if (html.isSetHead()) {
                removeEmptyCssClass(html.getHead());
            }
            if (html.isSetBody()) {
                removeEmptyCssClass(html.getBody());
            }
            break;
        case I:
            I i = (I) target;
            if (i.getCssClass().isEmpty()) {
                i.unsetCssClass();
            }
            if (i.isSetContent()) {
                removeCssClassWithinObjectList(i.getContent());
            }
            break;
        case IFRAME:
            Iframe iframe = (Iframe) target;
            if (iframe.getCssClass().isEmpty()) {
                iframe.unsetCssClass();
            }
            if (iframe.isSetContent()) {
                removeCssClassWithinObjectList(iframe.getContent());
            }
            break;
        case IMG:
            Img img = (Img) target;
            if (img.getCssClass().isEmpty()) {
                img.unsetCssClass();
            }
            // empty element
            break;
        case INPUT:
            Input input = (Input) target;
            if (input.getCssClass().isEmpty()) {
                input.unsetCssClass();
            }
            // empty element
            break;
        case INS:
            Ins ins = (Ins) target;
            if (ins.getCssClass().isEmpty()) {
                ins.unsetCssClass();
            }
            if (ins.isSetContent()) {
                removeCssClassWithinObjectList(ins.getContent());
            }
            break;
        case ISINDEX:
            Isindex isindex = (Isindex) target;
            if (isindex.getCssClass().isEmpty()) {
                isindex.unsetCssClass();
            }
            // empty element.
            break;
        case KBD:
            Kbd kbd = (Kbd) target;
            if (kbd.getCssClass().isEmpty()) {
                kbd.unsetCssClass();
            }
            if (kbd.isSetContent()) {
                removeCssClassWithinObjectList(kbd.getContent());
            }
            break;
        case LABEL:
            Label label = (Label) target;
            if (label.getCssClass().isEmpty()) {
                label.unsetCssClass();
            }
            if (label.isSetContent()) {
                removeCssClassWithinObjectList(label.getContent());
            }
            break;
        case LEGEND:
            Legend legend = (Legend) target;
            if (legend.getCssClass().isEmpty()) {
                legend.unsetCssClass();
            }
            if (legend.isSetContent()) {
                removeCssClassWithinObjectList(legend.getContent());
            }
            break;
        case LI:
            Li li = (Li) target;
            if (li.getCssClass().isEmpty()) {
                li.unsetCssClass();
            }
            if (li.isSetContent()) {
                removeCssClassWithinObjectList(li.getContent());
            }
            break;
        case LINK:
            Link link = (Link) target;
            if (link.getCssClass().isEmpty()) {
                link.unsetCssClass();
            }
            // empty element.
            break;
        case MAP:
            Map map = (Map) target;
            // map has no class property
            if (map.isSetArea()) {
                for (Area area2 : map.getArea()) {
                    removeEmptyCssClass(area2);
                }
            }
            break;
        case MENU:
            Menu menu = (Menu) target;
            if (menu.getCssClass().isEmpty()) {
                menu.unsetCssClass();
            }
            if (menu.isSetContent()) {
                removeCssClassWithinObjectList(menu.getContent());
            }
            break;
        case META:
            Meta meta = (Meta) target;
            if (meta.getCssClass().isEmpty()) {
                meta.unsetCssClass();
            }
            break;
        case NOFRAMES:
            Noframes noframes = (Noframes) target;
            if (noframes.getCssClass().isEmpty()) {
                noframes.unsetCssClass();
            }
            if (noframes.isSetContent()) {
                removeCssClassWithinObjectList(noframes.getContent());
            }
            break;
        case NOSCRIPT:
            Noscript noscript = (Noscript) target;
            if (noscript.getCssClass().isEmpty()) {
                noscript.unsetCssClass();
            }
            if (noscript.isSetContent()) {
                removeCssClassWithinObjectList(noscript.getContent());
            }
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
            if (object.getCssClass().isEmpty()) {
                object.unsetCssClass();
            }
            if (object.isSetContent()) {
                removeCssClassWithinObjectList(object.getContent());
            }
            break;
        case OL:
            Ol ol = (Ol) target;
            if (ol.getCssClass().isEmpty()) {
                ol.unsetCssClass();
            }
            if (ol.isSetLi()) {
                for (Li li2 : ol.getLi()) {
                    removeEmptyCssClass(li2);
                }
            }
            break;
        case OPTGROUP:
            Optgroup optgroup = (Optgroup) target;
            if (optgroup.getCssClass().isEmpty()) {
                optgroup.unsetCssClass();
            }
            if (optgroup.isSetOption()) {
                for (Option op : optgroup.getOption()) {
                    removeEmptyCssClass(op);
                }
            }
            break;
        case OPTION:
            Option option = (Option) target;
            if (option.getCssClass().isEmpty()) {
                option.unsetCssClass();
            }
            // has no child element.
            break;
        case P:
            P p = (P) target;
            if (p.getCssClass().isEmpty()) {
                p.unsetCssClass();
            }
            if (p.isSetContent()) {
                removeCssClassWithinObjectList(p.getContent());
            }
            break;
        case PARAM:
            Param param = (Param) target;
            if (param.getCssClass().isEmpty()) {
                param.unsetCssClass();
            }
            break;
        case PRE:
            Pre pre = (Pre) target;
            if (pre.getCssClass().isEmpty()) {
                pre.unsetCssClass();
            }
            if (pre.isSetContent()) {
                removeCssClassWithinObjectList(pre.getContent());
            }
            break;
        case Q:
            Q q = (Q) target;
            if (q.getCssClass().isEmpty()) {
                q.unsetCssClass();
            }
            if (q.isSetContent()) {
                removeCssClassWithinObjectList(q.getContent());
            }
            break;
        case S:
            S s = (S) target;
            if (s.getCssClass().isEmpty()) {
                s.unsetCssClass();
            }
            if (s.isSetContent()) {
                removeCssClassWithinObjectList(s.getContent());
            }
            break;
        case SAMP:
            Samp samp = (Samp) target;
            if (samp.getCssClass().isEmpty()) {
                samp.unsetCssClass();
            }
            if (samp.isSetContent()) {
                removeCssClassWithinObjectList(samp.getContent());
            }
            break;
        case SCRIPT:
            Script script = (Script) target;
            if (script.getCssClass().isEmpty()) {
                script.unsetCssClass();
            }
            break;
        case SELECT:
            Select select = (Select) target;
            if (select.getCssClass().isEmpty()) {
                select.unsetCssClass();
            }
            if (select.isSetOptgroupOrOption()) {
                for (AbstractJaxb obj : select.getOptgroupOrOption()) {
                    removeEmptyCssClass(obj);
                }
            }
            break;
        case SMALL:
            Small small = (Small) target;
            if (small.getCssClass().isEmpty()) {
                small.unsetCssClass();
            }
            if (small.isSetContent()) {
                removeCssClassWithinObjectList(small.getContent());
            }
            break;
        case SPAN:
            Span span = (Span) target;
            if (span.getCssClass().isEmpty()) {
                span.unsetCssClass();
            }
            if (span.isSetContent()) {
                removeCssClassWithinObjectList(span.getContent());
            }
            break;
        case STRIKE:
            Strike strike = (Strike) target;
            if (strike.getCssClass().isEmpty()) {
                strike.unsetCssClass();
            }
            if (strike.isSetContent()) {
                removeCssClassWithinObjectList(strike.getContent());
            }
            break;
        case STRONG:
            Strong strong = (Strong) target;
            if (strong.getCssClass().isEmpty()) {
                strong.unsetCssClass();
            }
            if (strong.isSetContent()) {
                removeCssClassWithinObjectList(strong.getContent());
            }
            break;
        case STYLE:
            Style style = (Style) target;
            if (style.getCssClass().isEmpty()) {
                style.unsetCssClass();
            }
            break;
        case SUB:
            Sub sub = (Sub) target;
            if (sub.getCssClass().isEmpty()) {
                sub.unsetCssClass();
            }
            if (sub.isSetContent()) {
                removeCssClassWithinObjectList(sub.getContent());
            }
            break;
        case SUP:
            Sup sup = (Sup) target;
            if (sup.getCssClass().isEmpty()) {
                sup.unsetCssClass();
            }
            if (sup.isSetContent()) {
                removeCssClassWithinObjectList(sup.getContent());
            }
            break;
        case TABLE:
            Table table = (Table) target;
            if (table.getCssClass().isEmpty()) {
                table.unsetCssClass();
            }
            if (table.isSetCaption()) {
                removeEmptyCssClass(table.getCaption());
            }
            if (table.isSetCol()) {
                for (Col col1 : table.getCol()) {
                    removeEmptyCssClass(col1);
                }
            }
            if (table.isSetColgroup()) {
                for (Colgroup cg : table.getColgroup()) {
                    removeEmptyCssClass(cg);
                }
            }
            if (table.isSetTbody()) {
                for (Tbody tb : table.getTbody()) {
                    removeEmptyCssClass(tb);
                }
            }
            if (table.isSetTfoot()) {
                removeEmptyCssClass(table.getTfoot());
            }
            if (table.isSetThead()) {
                removeEmptyCssClass(table.getThead());
            }
            if (table.isSetTr()) {
                for (Tr tr : table.getTr()) {
                    removeEmptyCssClass(tr);
                }
            }
            break;
        case TBODY:
            Tbody tbody = (Tbody) target;
            if (tbody.getCssClass().isEmpty()) {
                tbody.unsetCssClass();
            }
            if (tbody.isSetTr()) {
                for (Tr tr : tbody.getTr()) {
                    removeEmptyCssClass(tr);
                }
            }
            break;
        case TD:
            Td td = (Td) target;
            if (td.getCssClass().isEmpty()) {
                td.unsetCssClass();
            }
            if (td.isSetContent()) {
                removeCssClassWithinObjectList(td.getContent());
            }
            break;
        case TEXTAREA:
            Textarea textarea = (Textarea) target;
            if (textarea.getCssClass().isEmpty()) {
                textarea.unsetCssClass();
            }
            break;
        case TFOOT:
            Tfoot tfoot = (Tfoot) target;
            if (tfoot.getCssClass().isEmpty()) {
                tfoot.unsetCssClass();
            }
            if (tfoot.isSetTr()) {
                for (Tr tr : tfoot.getTr()) {
                    removeEmptyCssClass(tr);
                }
            }
            break;
        case TH:
            Th th = (Th) target;
            if (th.getCssClass().isEmpty()) {
                th.unsetCssClass();
            }
            if (th.isSetContent()) {
                removeCssClassWithinObjectList(th.getContent());
            }
            break;
        case THEAD:
            Thead thead = (Thead) target;
            if (thead.getCssClass().isEmpty()) {
                thead.unsetCssClass();
            }
            if (thead.isSetTr()) {
                for (Tr tr : thead.getTr()) {
                    removeEmptyCssClass(tr);
                }
            }
            break;
        case TITLE:
            Title title = (Title) target;
            if (title.getCssClass().isEmpty()) {
                title.unsetCssClass();
            }
            break;
        case TR:
            Tr tr = (Tr) target;
            if (tr.getCssClass().isEmpty()) {
                tr.unsetCssClass();
            }
            if (tr.isSetThOrTd()) {
                for (java.lang.Object obj : tr.getThOrTd()) {
                    removeEmptyCssClass((T) obj);
                }
            }
            break;
        case TT:
            Tt tt = (Tt) target;
            if (tt.getCssClass().isEmpty()) {
                tt.unsetCssClass();
            }
            if (tt.isSetContent()) {
                removeCssClassWithinObjectList(tt.getContent());
            }
            break;
        case U:
            U u = (U) target;
            if (u.getCssClass().isEmpty()) {
                u.unsetCssClass();
            }
            if (u.isSetContent()) {
                removeCssClassWithinObjectList(u.getContent());
            }
            break;
        case UL:
            Ul ul = (Ul) target;
            if (ul.getCssClass().isEmpty()) {
                ul.unsetCssClass();
            }
            if (ul.isSetLi()) {
                for (Li li1 : ul.getLi()) {
                    removeEmptyCssClass(li1);
                }
            }
            break;
        case VAR:
            Var var = (Var) target;
            if (var.getCssClass().isEmpty()) {
                var.unsetCssClass();
            }
            if (var.isSetContent()) {
                removeCssClassWithinObjectList(var.getContent());
            }
            break;
        // html5
        case ARTICLE:
            Article article = (Article) target;
            if (article.getCssClass().isEmpty()) {
                article.unsetCssClass();
            }
            if (article.isSetContent()) {
                removeCssClassWithinObjectList(article.getContent());
            }
            break;
        case ASIDE:
            Aside aside = (Aside) target;
            if (aside.getCssClass().isEmpty()) {
                aside.unsetCssClass();
            }
            if (aside.isSetContent()) {
                removeCssClassWithinObjectList(aside.getContent());
            }
            break;
        case AUDIO:
            Audio audio = (Audio) target;
            if (audio.getCssClass().isEmpty()) {
                audio.unsetCssClass();
            }
            if (audio.isSetContent()) {
                removeCssClassWithinObjectList(audio.getContent());
            }
            break;
        case BDI:
            Bdi bdi = (Bdi) target;
            if (bdi.getCssClass().isEmpty()) {
                bdi.unsetCssClass();
            }
            if (bdi.isSetContent()) {
                removeCssClassWithinObjectList(bdi.getContent());
            }
            break;
        case CANVAS:
            Canvas canvas = (Canvas) target;
            if (canvas.getCssClass().isEmpty()) {
                canvas.unsetCssClass();
            }
            if (canvas.isSetContent()) {
                removeCssClassWithinObjectList(canvas.getContent());
            }
            break;
        case COMMAND:
            Command command = (Command) target;
            if (command.getCssClass().isEmpty()) {
                command.unsetCssClass();
            }
            // empty element
            break;
        case DATALIST:
            Datalist datalist = (Datalist) target;
            if (datalist.getCssClass().isEmpty()) {
                datalist.unsetCssClass();
            }
            if (datalist.isSetContent()) {
                removeCssClassWithinObjectList(datalist.getContent());
            }
            break;
        case DETAILS:
            Details details = (Details) target;
            if (details.getCssClass().isEmpty()) {
                details.unsetCssClass();
            }
            if (details.isSetContent()) {
                removeCssClassWithinObjectList(details.getContent());
            }
            break;
        case EMBED:
            Embed embed = (Embed) target;
            if (embed.getCssClass().isEmpty()) {
                embed.unsetCssClass();
            }
            // empty element
            break;
        case FIGCAPTION:
            Figcaption figcaption = (Figcaption) target;
            if (figcaption.getCssClass().isEmpty()) {
                figcaption.unsetCssClass();
            }
            if (figcaption.isSetContent()) {
                removeCssClassWithinObjectList(figcaption.getContent());
            }
            break;
        case FIGURE:
            Figure figure = (Figure) target;
            if (figure.getCssClass().isEmpty()) {
                figure.unsetCssClass();
            }
            if (figure.isSetContent()) {
                removeCssClassWithinObjectList(figure.getContent());
            }
            break;
        case FOOTER:
            Footer footer = (Footer) target;
            if (footer.getCssClass().isEmpty()) {
                footer.unsetCssClass();
            }
            if (footer.isSetContent()) {
                removeCssClassWithinObjectList(footer.getContent());
            }
            break;
        case HEADER:
            Header header = (Header) target;
            if (header.getCssClass().isEmpty()) {
                header.unsetCssClass();
            }
            if (header.isSetContent()) {
                removeCssClassWithinObjectList(header.getContent());
            }
            break;
        case KEYGEN:
            Keygen keygen = (Keygen) target;
            if (keygen.getCssClass().isEmpty()) {
                keygen.unsetCssClass();
            }
            // empty element
            break;
        case MARK:
            Mark mark = (Mark) target;
            if (mark.getCssClass().isEmpty()) {
                mark.unsetCssClass();
            }
            if (mark.isSetContent()) {
                removeCssClassWithinObjectList(mark.getContent());
            }
            break;
        case METER:
            Meter meter = (Meter) target;
            if (meter.getCssClass().isEmpty()) {
                meter.unsetCssClass();
            }
            if (meter.isSetContent()) {
                removeCssClassWithinObjectList(meter.getContent());
            }
            break;
        case NAV:
            Nav nav = (Nav) target;
            if (nav.getCssClass().isEmpty()) {
                nav.unsetCssClass();
            }
            if (nav.isSetContent()) {
                removeCssClassWithinObjectList(nav.getContent());
            }
            break;
        case OUTPUT:
            Output output = (Output) target;
            if (output.getCssClass().isEmpty()) {
                output.unsetCssClass();
            }
            if (output.isSetContent()) {
                removeCssClassWithinObjectList(output.getContent());
            }
            break;
        case PROGRESS:
            Progress progress = (Progress) target;
            if (progress.getCssClass().isEmpty()) {
                progress.unsetCssClass();
            }
            if (progress.isSetContent()) {
                removeCssClassWithinObjectList(progress.getContent());
            }
            break;
        case RP:
            Rp rp = (Rp) target;
            if (rp.getCssClass().isEmpty()) {
                rp.unsetCssClass();
            }
            if (rp.isSetContent()) {
                removeCssClassWithinObjectList(rp.getContent());
            }
            break;
        case RT:
            Rt rt = (Rt) target;
            if (rt.getCssClass().isEmpty()) {
                rt.unsetCssClass();
            }
            if (rt.isSetContent()) {
                removeCssClassWithinObjectList(rt.getContent());
            }
            break;
        case RUBY:
            Ruby ruby = (Ruby) target;
            if (ruby.getCssClass().isEmpty()) {
                ruby.unsetCssClass();
            }
            if (ruby.isSetContent()) {
                removeCssClassWithinObjectList(ruby.getContent());
            }
            break;
        case SECTION:
            Section section = (Section) target;
            if (section.getCssClass().isEmpty()) {
                section.unsetCssClass();
            }
            if (section.isSetContent()) {
                removeCssClassWithinObjectList(section.getContent());
            }
            break;
        case SOURCE:
            Source source = (Source) target;
            if (source.getCssClass().isEmpty()) {
                source.unsetCssClass();
            }
            // empty element
            break;
        case SUMMARY:
            Summary summary = (Summary) target;
            if (summary.getCssClass().isEmpty()) {
                summary.unsetCssClass();
            }
            if (summary.isSetContent()) {
                removeCssClassWithinObjectList(summary.getContent());
            }
            break;
        case TIME:
            Time time = (Time) target;
            if (time.getCssClass().isEmpty()) {
                time.unsetCssClass();
            }
            if (time.isSetContent()) {
                removeCssClassWithinObjectList(time.getContent());
            }
            break;
        case TRACK:
            Track track = (Track) target;
            if (track.getCssClass().isEmpty()) {
                track.unsetCssClass();
            }
            // empty element.
            break;
        case VIDEO:
            Video video = (Video) target;
            if (video.getCssClass().isEmpty()) {
                video.unsetCssClass();
            }
            if (video.isSetContent()) {
                removeCssClassWithinObjectList(video.getContent());
            }
            break;
        case WBR:
            Wbr wbr = (Wbr) target;
            if (wbr.getCssClass().isEmpty()) {
                wbr.unsetCssClass();
            }
            break;
        }
    }

}

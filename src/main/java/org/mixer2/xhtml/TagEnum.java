package org.mixer2.xhtml;

/**
 * xhtmlのタグの種類と、mixer2におけるそれらのJava型を結び付けるための列挙型です。
 *
 * @author watanabe
 *
 */
public enum TagEnum {

    A(org.mixer2.jaxb.xhtml.A.class, false) //
    , ABBR(org.mixer2.jaxb.xhtml.Abbr.class, false) //
    , ACRONYM(org.mixer2.jaxb.xhtml.Acronym.class, false) //
    , ADDRESS(org.mixer2.jaxb.xhtml.Address.class, false) //
    , APPLET(org.mixer2.jaxb.xhtml.Applet.class, false) //
    , AREA(org.mixer2.jaxb.xhtml.Area.class, false) //
    , ARTICLE(org.mixer2.jaxb.xhtml.Article.class, false) //
    , ASIDE(org.mixer2.jaxb.xhtml.Aside.class, false) //
    , AUDIO(org.mixer2.jaxb.xhtml.Audio.class, false) //
    , B(org.mixer2.jaxb.xhtml.B.class, false) //
    , BASE(org.mixer2.jaxb.xhtml.Base.class, true) //
    , BASEFONT(org.mixer2.jaxb.xhtml.Basefont.class, true) //
    , BDI(org.mixer2.jaxb.xhtml.Bdi.class, false) //
    , BDO(org.mixer2.jaxb.xhtml.Bdo.class, false) //
    , BIG(org.mixer2.jaxb.xhtml.Big.class, false) //
    , BLOCKQUOTE(org.mixer2.jaxb.xhtml.Blockquote.class, false) //
    , BODY(org.mixer2.jaxb.xhtml.Body.class, true) //
    , BR(org.mixer2.jaxb.xhtml.Br.class, false) //
    , BUTTON(org.mixer2.jaxb.xhtml.Button.class, false) //
    , CANVAS(org.mixer2.jaxb.xhtml.Canvas.class, false) //
    , CAPTION(org.mixer2.jaxb.xhtml.Caption.class, true) //
    , CENTER(org.mixer2.jaxb.xhtml.Center.class, false) //
    , CITE(org.mixer2.jaxb.xhtml.Cite.class, false) //
    , CODE(org.mixer2.jaxb.xhtml.Code.class, false) //
    , COL(org.mixer2.jaxb.xhtml.Col.class, false) //
    , COLGROUP(org.mixer2.jaxb.xhtml.Colgroup.class, true) //
    , COMMAND(org.mixer2.jaxb.xhtml.Command.class, false) //
    , DATALIST(org.mixer2.jaxb.xhtml.Datalist.class, false) //
    , DD(org.mixer2.jaxb.xhtml.Dd.class, false) //
    , DEL(org.mixer2.jaxb.xhtml.Del.class, false) //
    , DETAILS(org.mixer2.jaxb.xhtml.Details.class, false) //
    , DFN(org.mixer2.jaxb.xhtml.Dfn.class, false) //
    , DIR(org.mixer2.jaxb.xhtml.Dir.class, true) //
    , DIV(org.mixer2.jaxb.xhtml.Div.class, true) //
    , DL(org.mixer2.jaxb.xhtml.Dl.class, true) //
    , DT(org.mixer2.jaxb.xhtml.Dt.class, true) //
    , EM(org.mixer2.jaxb.xhtml.Em.class, false) //
    , EMBED(org.mixer2.jaxb.xhtml.Embed.class, false) //
    , FIELDSET(org.mixer2.jaxb.xhtml.Fieldset.class, true) //
    , FIGCAPTION(org.mixer2.jaxb.xhtml.Figcaption.class, false) //
    , FIGURE(org.mixer2.jaxb.xhtml.Figure.class, false) //
    , FONT(org.mixer2.jaxb.xhtml.Font.class, false) //
    , FOOTER(org.mixer2.jaxb.xhtml.Footer.class, false) //
    , FORM(org.mixer2.jaxb.xhtml.Form.class, false) //
    , H1(org.mixer2.jaxb.xhtml.H1.class, false) //
    , H2(org.mixer2.jaxb.xhtml.H2.class, false) //
    , H3(org.mixer2.jaxb.xhtml.H3.class, false) //
    , H4(org.mixer2.jaxb.xhtml.H4.class, false) //
    , H5(org.mixer2.jaxb.xhtml.H5.class, false) //
    , H6(org.mixer2.jaxb.xhtml.H6.class, false) //
    , HEAD(org.mixer2.jaxb.xhtml.Head.class, true) //
    , HEADER(org.mixer2.jaxb.xhtml.Header.class, false) //
    , HGROUP(org.mixer2.jaxb.xhtml.Hgroup.class, true) //
    , HR(org.mixer2.jaxb.xhtml.Hr.class, false) //
    , HTML(org.mixer2.jaxb.xhtml.Html.class, true) //
    , I(org.mixer2.jaxb.xhtml.I.class, false) //
    , IFRAME(org.mixer2.jaxb.xhtml.Iframe.class, false) //
    , IMG(org.mixer2.jaxb.xhtml.Img.class, false) //
    , INPUT(org.mixer2.jaxb.xhtml.Input.class, false) //
    , INS(org.mixer2.jaxb.xhtml.Ins.class, false) //
    , ISINDEX(org.mixer2.jaxb.xhtml.Isindex.class, false) //
    , KBD(org.mixer2.jaxb.xhtml.Kbd.class, false) //
    , KEYGEN(org.mixer2.jaxb.xhtml.Keygen.class, false) //
    , LABEL(org.mixer2.jaxb.xhtml.Label.class, false) //
    , LEGEND(org.mixer2.jaxb.xhtml.Legend.class, false) //
    , LI(org.mixer2.jaxb.xhtml.Li.class, true) //
    , LINK(org.mixer2.jaxb.xhtml.Link.class, true) //
    , MAP(org.mixer2.jaxb.xhtml.Map.class, false) //
    , MARK(org.mixer2.jaxb.xhtml.Mark.class, false) //
    , MENU(org.mixer2.jaxb.xhtml.Menu.class, true) //
    , META(org.mixer2.jaxb.xhtml.Meta.class, true) //
    , METER(org.mixer2.jaxb.xhtml.Meter.class, false) //
    , NAV(org.mixer2.jaxb.xhtml.Nav.class, false) //
    , NOFRAMES(org.mixer2.jaxb.xhtml.Noframes.class, false) //
    , NOSCRIPT(org.mixer2.jaxb.xhtml.Noscript.class, false) //
    , OBJECT(org.mixer2.jaxb.xhtml.Object.class, false) //
    , OL(org.mixer2.jaxb.xhtml.Ol.class, true) //
    , OPTGROUP(org.mixer2.jaxb.xhtml.Optgroup.class, true) //
    , OPTION(org.mixer2.jaxb.xhtml.Option.class, false) //
    , OUTPUT(org.mixer2.jaxb.xhtml.Output.class, false) //
    , P(org.mixer2.jaxb.xhtml.P.class, false) //
    , PARAM(org.mixer2.jaxb.xhtml.Param.class, false) //
    , PRE(org.mixer2.jaxb.xhtml.Pre.class, false) //
    , PROGRESS(org.mixer2.jaxb.xhtml.Progress.class, false) //
    , Q(org.mixer2.jaxb.xhtml.Q.class, false) //
    , RP(org.mixer2.jaxb.xhtml.Rp.class, false) //
    , RT(org.mixer2.jaxb.xhtml.Rt.class, false) //
    , RUBY(org.mixer2.jaxb.xhtml.Ruby.class, false) //
    , S(org.mixer2.jaxb.xhtml.S.class, false) //
    , SAMP(org.mixer2.jaxb.xhtml.Samp.class, false) //
    , SCRIPT(org.mixer2.jaxb.xhtml.Script.class, true) //
    , SECTION(org.mixer2.jaxb.xhtml.Section.class, false) //
    , SELECT(org.mixer2.jaxb.xhtml.Select.class, false) //
    , SMALL(org.mixer2.jaxb.xhtml.Small.class, false) //
    , SOURCE(org.mixer2.jaxb.xhtml.Source.class, false) //
    , SPAN(org.mixer2.jaxb.xhtml.Span.class, false) //
    , STRIKE(org.mixer2.jaxb.xhtml.Strike.class, false) //
    , STRONG(org.mixer2.jaxb.xhtml.Strong.class, false) //
    , STYLE(org.mixer2.jaxb.xhtml.Style.class, true) //
    , SUB(org.mixer2.jaxb.xhtml.Sub.class, false) //
    , SUMMARY(org.mixer2.jaxb.xhtml.Summary.class, false) //
    , SUP(org.mixer2.jaxb.xhtml.Sup.class, false) //
    , TABLE(org.mixer2.jaxb.xhtml.Table.class, true) //
    , TBODY(org.mixer2.jaxb.xhtml.Tbody.class, true) //
    , TD(org.mixer2.jaxb.xhtml.Td.class, true) //
    , TEXTAREA(org.mixer2.jaxb.xhtml.Textarea.class, false) //
    , TFOOT(org.mixer2.jaxb.xhtml.Tfoot.class, true) //
    , TH(org.mixer2.jaxb.xhtml.Th.class, true) //
    , THEAD(org.mixer2.jaxb.xhtml.Thead.class, true) //
    , TIME(org.mixer2.jaxb.xhtml.Time.class, false) //
    , TITLE(org.mixer2.jaxb.xhtml.Title.class, true) //
    , TR(org.mixer2.jaxb.xhtml.Tr.class, true) //
    , TRACK(org.mixer2.jaxb.xhtml.Track.class, false) //
    , TT(org.mixer2.jaxb.xhtml.Tt.class, false) //
    , U(org.mixer2.jaxb.xhtml.U.class, false) //
    , UL(org.mixer2.jaxb.xhtml.Ul.class, true) //
    , VAR(org.mixer2.jaxb.xhtml.Var.class, false) //
    , VIDEO(org.mixer2.jaxb.xhtml.Video.class, false) //
    , WBR(org.mixer2.jaxb.xhtml.Wbr.class, false) //
    ;

    @SuppressWarnings("rawtypes")
    private Class tagType;

    /**  */
    private boolean addLineBreak;

    private <T extends AbstractJaxb> TagEnum(Class<T> tagType,
            boolean addLineBreak) {
        this.tagType = tagType;
        this.addLineBreak = addLineBreak;
    }

    /**
     * <p>
     * mixer2におけるタグのクラス名を返します。
     * <p>
     * <p>
     * ex. div = org.miser2.jaxb.xhtml.Div.class
     * </p>
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> Class<T> getTagClass() {
        return this.tagType;
    }

    /**
     * <p>
     * タグの前後に改行を入れるべきか否かを返します。 ブロック要素の場合はtrue、それ以外の場合にfalseがセットされていますが、
     * あまり厳密ではありません。
     * </p>
     *
     */
    public boolean getAddLineBreak() {
        return this.addLineBreak;
    }

}

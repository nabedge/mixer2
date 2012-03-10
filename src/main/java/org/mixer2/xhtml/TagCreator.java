package org.mixer2.xhtml;

import org.mixer2.jaxb.xhtml.*;

/**
 * usage:
 * 
 * <pre>
 * import static org.mixer2.xhtml.TagCreator.*;
 * // shortcut of Div div = new Div();
 * Div div = div();
 * // shortcut of Div div = new Div(); div.setId(&quot;foo&quot;);
 * Div div = divWithId(&quot;foo&quot;);
 * </pre>
 * 
 * @author watanabe
 * 
 */
public class TagCreator {

    public static A a() {
        return new A();
    }

    public static Abbr abbr() {
        return new Abbr();
    }

    public static Acronym acronym() {
        return new Acronym();
    }

    public static Address address() {
        return new Address();
    }

    public static Applet applet() {
        return new Applet();
    }

    public static Area area() {
        return new Area();
    }

    public static B b() {
        return new B();
    }

    public static Base base() {
        return new Base();
    }

    public static Basefont basefont() {
        return new Basefont();
    }

    public static Bdo bdo() {
        return new Bdo();
    }

    public static Big big() {
        return new Big();
    }

    public static Blockquote blockquote() {
        return new Blockquote();
    }

    public static Body body() {
        return new Body();
    }

    public static Br br() {
        return new Br();
    }

    public static Button button() {
        return new Button();
    }

    public static Caption caption() {
        return new Caption();
    }

    public static Center center() {
        return new Center();
    }

    public static Cite cite() {
        return new Cite();
    }

    public static Code code() {
        return new Code();
    }

    public static Col col() {
        return new Col();
    }

    public static Colgroup colgroup() {
        return new Colgroup();
    }

    public static Dd dd() {
        return new Dd();
    }

    public static Del del() {
        return new Del();
    }

    public static Dfn dfn() {
        return new Dfn();
    }

    public static Dir dir() {
        return new Dir();
    }

    public static Div div() {
        return new Div();
    }

    public static Dl dl() {
        return new Dl();
    }

    public static Dt dt() {
        return new Dt();
    }

    public static Em em() {
        return new Em();
    }

    public static Fieldset fieldset() {
        return new Fieldset();
    }

    public static Font font() {
        return new Font();
    }

    public static Form form() {
        return new Form();
    }

    public static H1 h1() {
        return new H1();
    }

    public static H2 h2() {
        return new H2();
    }

    public static H3 h3() {
        return new H3();
    }

    public static H4 h4() {
        return new H4();
    }

    public static H5 h5() {
        return new H5();
    }

    public static H6 h6() {
        return new H6();
    }

    public static Hgroup hgroup() {
        return new Hgroup();
    }

    public static Head head() {
        return new Head();
    }

    public static Hr hr() {
        return new Hr();
    }

    public static Html html() {
        return new Html();
    }

    public static I i() {
        return new I();
    }

    public static Iframe iframe() {
        return new Iframe();
    }

    public static Img img() {
        return new Img();
    }

    public static Input input() {
        return new Input();
    }

    public static Ins ins() {
        return new Ins();
    }

    public static Isindex isindex() {
        return new Isindex();
    }

    public static Kbd kbd() {
        return new Kbd();
    }

    public static Label label() {
        return new Label();
    }

    public static Legend legend() {
        return new Legend();
    }

    public static Li li() {
        return new Li();
    }

    public static Link link() {
        return new Link();
    }

    public static Map map() {
        return new Map();
    }

    public static Menu menu() {
        return new Menu();
    }

    public static Meta meta() {
        return new Meta();
    }

    public static Noframes noframes() {
        return new Noframes();
    }

    public static Noscript noscript() {
        return new Noscript();
    }

    public static org.mixer2.jaxb.xhtml.Object object() {
        return new org.mixer2.jaxb.xhtml.Object();
    }

    public static Ol ol() {
        return new Ol();
    }

    public static Optgroup optgroup() {
        return new Optgroup();
    }

    public static Option option() {
        return new Option();
    }

    public static P p() {
        return new P();
    }

    public static Param param() {
        return new Param();
    }

    public static Pre pre() {
        return new Pre();
    }

    public static Q q() {
        return new Q();
    }

    public static S s() {
        return new S();
    }

    public static Samp samp() {
        return new Samp();
    }

    public static Script script() {
        return new Script();
    }

    public static Select select() {
        return new Select();
    }

    public static Small small() {
        return new Small();
    }

    public static Span span() {
        return new Span();
    }

    public static Strike strike() {
        return new Strike();
    }

    public static Strong strong() {
        return new Strong();
    }

    public static Style style() {
        return new Style();
    }

    public static Sub sub() {
        return new Sub();
    }

    public static Sup sup() {
        return new Sup();
    }

    public static Table table() {
        return new Table();
    }

    public static Tbody tbody() {
        return new Tbody();
    }

    public static Td td() {
        return new Td();
    }

    public static Textarea textarea() {
        return new Textarea();
    }

    public static Tfoot tfoot() {
        return new Tfoot();
    }

    public static Th th() {
        return new Th();
    }

    public static Thead thead() {
        return new Thead();
    }

    public static Title title() {
        return new Title();
    }

    public static Tr tr() {
        return new Tr();
    }

    public static Tt tt() {
        return new Tt();
    }

    public static U u() {
        return new U();
    }

    public static Ul ul() {
        return new Ul();
    }

    public static Var var() {
        return new Var();
    }

    public static A aWithId(String id) {
        A tag = a();
        tag.setId(id);
        return tag;
    }

    public static Abbr abbrWithId(String id) {
        Abbr tag = abbr();
        tag.setId(id);
        return tag;
    }

    public static Acronym acronymWithId(String id) {
        Acronym tag = acronym();
        tag.setId(id);
        return tag;
    }

    public static Address addressWithId(String id) {
        Address tag = address();
        tag.setId(id);
        return tag;
    }

    public static Applet appletWithId(String id) {
        Applet tag = applet();
        tag.setId(id);
        return tag;
    }

    public static Area areaWithId(String id) {
        Area tag = area();
        tag.setId(id);
        return tag;
    }

    public static B bWithId(String id) {
        B tag = b();
        tag.setId(id);
        return tag;
    }

    public static Base baseWithId(String id) {
        Base tag = base();
        tag.setId(id);
        return tag;
    }

    public static Basefont basefontWithId(String id) {
        Basefont tag = basefont();
        tag.setId(id);
        return tag;
    }

    public static Bdo bdoWithId(String id) {
        Bdo tag = bdo();
        tag.setId(id);
        return tag;
    }

    public static Big bigWithId(String id) {
        Big tag = big();
        tag.setId(id);
        return tag;
    }

    public static Blockquote blockquoteWithId(String id) {
        Blockquote tag = blockquote();
        tag.setId(id);
        return tag;
    }

    public static Body bodyWithId(String id) {
        Body tag = body();
        tag.setId(id);
        return tag;
    }

    public static Br brWithId(String id) {
        Br tag = br();
        tag.setId(id);
        return tag;
    }

    public static Button buttonWithId(String id) {
        Button tag = button();
        tag.setId(id);
        return tag;
    }

    public static Caption captionWithId(String id) {
        Caption tag = caption();
        tag.setId(id);
        return tag;
    }

    public static Center centerWithId(String id) {
        Center tag = center();
        tag.setId(id);
        return tag;
    }

    public static Cite citeWithId(String id) {
        Cite tag = cite();
        tag.setId(id);
        return tag;
    }

    public static Code codeWithId(String id) {
        Code tag = code();
        tag.setId(id);
        return tag;
    }

    public static Col colWithId(String id) {
        Col tag = col();
        tag.setId(id);
        return tag;
    }

    public static Colgroup colgroupWithId(String id) {
        Colgroup tag = colgroup();
        tag.setId(id);
        return tag;
    }

    public static Dd ddWithId(String id) {
        Dd tag = dd();
        tag.setId(id);
        return tag;
    }

    public static Del delWithId(String id) {
        Del tag = del();
        tag.setId(id);
        return tag;
    }

    public static Dfn dfnWithId(String id) {
        Dfn tag = dfn();
        tag.setId(id);
        return tag;
    }

    public static Dir dirWithId(String id) {
        Dir tag = dir();
        tag.setId(id);
        return tag;
    }

    public static Div divWithId(String id) {
        Div tag = div();
        tag.setId(id);
        return tag;
    }

    public static Dl dlWithId(String id) {
        Dl tag = dl();
        tag.setId(id);
        return tag;
    }

    public static Dt dtWithId(String id) {
        Dt tag = dt();
        tag.setId(id);
        return tag;
    }

    public static Em emWithId(String id) {
        Em tag = em();
        tag.setId(id);
        return tag;
    }

    public static Fieldset fieldsetWithId(String id) {
        Fieldset tag = fieldset();
        tag.setId(id);
        return tag;
    }

    public static Font fontWithId(String id) {
        Font tag = font();
        tag.setId(id);
        return tag;
    }

    public static Form formWithId(String id) {
        Form tag = form();
        tag.setId(id);
        return tag;
    }

    public static H1 h1WithId(String id) {
        H1 tag = h1();
        tag.setId(id);
        return tag;
    }

    public static H2 h2WithId(String id) {
        H2 tag = h2();
        tag.setId(id);
        return tag;
    }

    public static H3 h3WithId(String id) {
        H3 tag = h3();
        tag.setId(id);
        return tag;
    }

    public static H4 h4WithId(String id) {
        H4 tag = h4();
        tag.setId(id);
        return tag;
    }

    public static H5 h5WithId(String id) {
        H5 tag = h5();
        tag.setId(id);
        return tag;
    }

    public static H6 h6WithId(String id) {
        H6 tag = h6();
        tag.setId(id);
        return tag;
    }

    public static Hgroup hgroupWithId(String id) {
        Hgroup tag = hgroup();
        tag.setId(id);
        return tag;
    }

    public static Head headWithId(String id) {
        Head tag = head();
        tag.setId(id);
        return tag;
    }

    public static Hr hrWithId(String id) {
        Hr tag = hr();
        tag.setId(id);
        return tag;
    }

    public static Html htmlWithId(String id) {
        Html tag = html();
        tag.setId(id);
        return tag;
    }

    public static I iWithId(String id) {
        I tag = i();
        tag.setId(id);
        return tag;
    }

    public static Iframe iframeWithId(String id) {
        Iframe tag = iframe();
        tag.setId(id);
        return tag;
    }

    public static Img imgWithId(String id) {
        Img tag = img();
        tag.setId(id);
        return tag;
    }

    public static Input inputWithId(String id) {
        Input tag = input();
        tag.setId(id);
        return tag;
    }

    public static Ins insWithId(String id) {
        Ins tag = ins();
        tag.setId(id);
        return tag;
    }

    public static Isindex isindexWithId(String id) {
        Isindex tag = isindex();
        tag.setId(id);
        return tag;
    }

    public static Kbd kbdWithId(String id) {
        Kbd tag = kbd();
        tag.setId(id);
        return tag;
    }

    public static Label labelWithId(String id) {
        Label tag = label();
        tag.setId(id);
        return tag;
    }

    public static Legend legendWithId(String id) {
        Legend tag = legend();
        tag.setId(id);
        return tag;
    }

    public static Li liWithId(String id) {
        Li tag = li();
        tag.setId(id);
        return tag;
    }

    public static Link linkWithId(String id) {
        Link tag = link();
        tag.setId(id);
        return tag;
    }

    public static Map mapWithId(String id) {
        Map tag = map();
        tag.setId(id);
        return tag;
    }

    public static Menu menuWithId(String id) {
        Menu tag = menu();
        tag.setId(id);
        return tag;
    }

    public static Meta metaWithId(String id) {
        Meta tag = meta();
        tag.setId(id);
        return tag;
    }

    public static Noframes noframesWithId(String id) {
        Noframes tag = noframes();
        tag.setId(id);
        return tag;
    }

    public static Noscript noscriptWithId(String id) {
        Noscript tag = noscript();
        tag.setId(id);
        return tag;
    }

    public static org.mixer2.jaxb.xhtml.Object objectWithId(String id) {
        org.mixer2.jaxb.xhtml.Object tag = object();
        tag.setId(id);
        return tag;
    }

    public static Ol olWithId(String id) {
        Ol tag = ol();
        tag.setId(id);
        return tag;
    }

    public static Optgroup optgroupWithId(String id) {
        Optgroup tag = optgroup();
        tag.setId(id);
        return tag;
    }

    public static Option optionWithId(String id) {
        Option tag = option();
        tag.setId(id);
        return tag;
    }

    public static P pWithId(String id) {
        P tag = p();
        tag.setId(id);
        return tag;
    }

    public static Param paramWithId(String id) {
        Param tag = param();
        tag.setId(id);
        return tag;
    }

    public static Pre preWithId(String id) {
        Pre tag = pre();
        tag.setId(id);
        return tag;
    }

    public static Q qWithId(String id) {
        Q tag = q();
        tag.setId(id);
        return tag;
    }

    public static S sWithId(String id) {
        S tag = s();
        tag.setId(id);
        return tag;
    }

    public static Samp sampWithId(String id) {
        Samp tag = samp();
        tag.setId(id);
        return tag;
    }

    public static Script scriptWithId(String id) {
        Script tag = script();
        tag.setId(id);
        return tag;
    }

    public static Select selectWithId(String id) {
        Select tag = select();
        tag.setId(id);
        return tag;
    }

    public static Small smallWithId(String id) {
        Small tag = small();
        tag.setId(id);
        return tag;
    }

    public static Span spanWithId(String id) {
        Span tag = span();
        tag.setId(id);
        return tag;
    }

    public static Strike strikeWithId(String id) {
        Strike tag = strike();
        tag.setId(id);
        return tag;
    }

    public static Strong strongWithId(String id) {
        Strong tag = strong();
        tag.setId(id);
        return tag;
    }

    public static Style styleWithId(String id) {
        Style tag = style();
        tag.setId(id);
        return tag;
    }

    public static Sub subWithId(String id) {
        Sub tag = sub();
        tag.setId(id);
        return tag;
    }

    public static Sup supWithId(String id) {
        Sup tag = sup();
        tag.setId(id);
        return tag;
    }

    public static Table tableWithId(String id) {
        Table tag = table();
        tag.setId(id);
        return tag;
    }

    public static Tbody tbodyWithId(String id) {
        Tbody tag = tbody();
        tag.setId(id);
        return tag;
    }

    public static Td tdWithId(String id) {
        Td tag = td();
        tag.setId(id);
        return tag;
    }

    public static Textarea textareaWithId(String id) {
        Textarea tag = textarea();
        tag.setId(id);
        return tag;
    }

    public static Tfoot tfootWithId(String id) {
        Tfoot tag = tfoot();
        tag.setId(id);
        return tag;
    }

    public static Th thWithId(String id) {
        Th tag = th();
        tag.setId(id);
        return tag;
    }

    public static Thead theadWithId(String id) {
        Thead tag = thead();
        tag.setId(id);
        return tag;
    }

    public static Title titleWithId(String id) {
        Title tag = title();
        tag.setId(id);
        return tag;
    }

    public static Tr trWithId(String id) {
        Tr tag = tr();
        tag.setId(id);
        return tag;
    }

    public static Tt ttWithId(String id) {
        Tt tag = tt();
        tag.setId(id);
        return tag;
    }

    public static U uWithId(String id) {
        U tag = u();
        tag.setId(id);
        return tag;
    }

    public static Ul ulWithId(String id) {
        Ul tag = ul();
        tag.setId(id);
        return tag;
    }

    public static Var varWithId(String id) {
        Var tag = var();
        tag.setId(id);
        return tag;
    }

    // HTML5
    public static Article article() {
        return new Article();
    }

    public static Aside aside() {
        return new Aside();
    }

    public static Audio audio() {
        return new Audio();
    }

    public static Bdi bdi() {
        return new Bdi();
    }

    public static Canvas canvas() {
        return new Canvas();
    }

    public static Command command() {
        return new Command();
    }

    public static Datalist datalist() {
        return new Datalist();
    }

    public static Details details() {
        return new Details();
    }

    public static Embed embed() {
        return new Embed();
    }

    public static Figcaption figcaption() {
        return new Figcaption();
    }

    public static Figure figure() {
        return new Figure();
    }

    public static Footer footer() {
        return new Footer();
    }

    public static Header header() {
        return new Header();
    }

    public static Keygen keygen() {
        return new Keygen();
    }

    public static Mark mark() {
        return new Mark();
    }

    public static Meter meter() {
        return new Meter();
    }

    public static Nav nav() {
        return new Nav();
    }

    public static Output output() {
        return new Output();
    }

    public static Progress progress() {
        return new Progress();
    }

    public static Rp rp() {
        return new Rp();
    }

    public static Rt rt() {
        return new Rt();
    }

    public static Ruby ruby() {
        return new Ruby();
    }

    public static Section section() {
        return new Section();
    }

    public static Source source() {
        return new Source();
    }

    public static Summary summary() {
        return new Summary();
    }

    public static Time time() {
        return new Time();
    }

    public static Track track() {
        return new Track();
    }

    public static Video video() {
        return new Video();
    }

    public static Wbr wbr() {
        return new Wbr();
    }

    // ////////

    public static Article articleWithId(String id) {
        Article article = article();
        article.setId(id);
        return article;
    }

    public static Aside asideWithId(String id) {
        Aside aside = aside();
        aside.setId(id);
        return aside;
    }

    public static Audio audioWithId(String id) {
        Audio audio = audio();
        audio.setId(id);
        return audio;
    }

    public static Bdi bdiWithId(String id) {
        Bdi bdi = bdi();
        bdi.setId(id);
        return bdi;
    }

    public static Canvas canvasWithId(String id) {
        Canvas canvas = canvas();
        canvas.setId(id);
        return canvas;
    }

    public static Command commandWithId(String id) {
        Command command = command();
        command.setId(id);
        return command;
    }

    public static Datalist datalistWithId(String id) {
        Datalist datalist = datalist();
        datalist.setId(id);
        return datalist;
    }

    public static Details detailsWithId(String id) {
        Details details = details();
        details.setId(id);
        return details;
    }

    public static Embed embedWithId(String id) {
        Embed embed = embed();
        embed.setId(id);
        return embed;
    }

    public static Figcaption figcaptionWithId(String id) {
        Figcaption figcaption = figcaption();
        figcaption.setId(id);
        return figcaption;
    }

    public static Figure figureWithId(String id) {
        Figure figure = figure();
        figure.setId(id);
        return figure;
    }

    public static Footer footerWithId(String id) {
        Footer footer = footer();
        footer.setId(id);
        return footer;
    }

    public static Header headerWithId(String id) {
        Header header = header();
        header.setId(id);
        return header;
    }

    public static Keygen keygenWithId(String id) {
        Keygen keygen = keygen();
        keygen.setId(id);
        return keygen;
    }

    public static Mark markWithId(String id) {
        Mark mark = mark();
        mark.setId(id);
        return mark;
    }

    public static Meter meterWithId(String id) {
        Meter meter = meter();
        meter.setId(id);
        return meter;
    }

    public static Nav navWithId(String id) {
        Nav nav = nav();
        nav.setId(id);
        return nav;
    }

    public static Output outputWithId(String id) {
        Output output = output();
        output.setId(id);
        return output;
    }

    public static Progress progressWithId(String id) {
        Progress progress = progress();
        progress.setId(id);
        return progress;
    }

    public static Rp rpWithId(String id) {
        Rp rp = rp();
        rp.setId(id);
        return rp;
    }

    public static Rt rtWithId(String id) {
        Rt rt = rt();
        rt.setId(id);
        return rt;
    }

    public static Ruby rubyWithId(String id) {
        Ruby ruby = ruby();
        ruby.setId(id);
        return ruby;
    }

    public static Section sectionWithId(String id) {
        Section section = section();
        section.setId(id);
        return section;
    }

    public static Source sourceWithId(String id) {
        Source source = source();
        source.setId(id);
        return source;
    }

    public static Summary summaryWithId(String id) {
        Summary summary = summary();
        summary.setId(id);
        return summary;
    }

    public static Time timeWithId(String id) {
        Time time = time();
        time.setId(id);
        return time;
    }

    public static Track trackWithId(String id) {
        Track track = track();
        track.setId(id);
        return track;
    }

    public static Video videoWithId(String id) {
        Video video = video();
        video.setId(id);
        return video;
    }

    public static Wbr wbrWithId(String id) {
        Wbr wbr = wbr();
        wbr.setId(id);
        return wbr;
    }

}

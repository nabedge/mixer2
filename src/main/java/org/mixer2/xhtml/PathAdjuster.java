package org.mixer2.xhtml;

import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.*;

/**
 * <p>
 * path ajustment utility for image, style sheet, etc.
 * </p>
 *
 * <h4>target tag and attribute.</h4>
 * <table border="1">
 * <thead>
 * <tr>
 * <th>tag</th>
 * <th>attribute</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr><td>a</td><td>href</td></tr>
 * <tr><td rowspan="2">applet</td><td>code</td></tr>
 * <tr><!-- applet --><td>codebase</td></tr>
 * <tr><td>area</td><td>href</td></tr>
 * <tr><td>audio</td><td>src</td></tr>
 * <tr><td>base</td><td>href</td></tr>
 * <tr><td>blockquote</td><td>cite</td></tr>
 * <tr><td>del</td><td>cite</td></tr>
 * <tr><td>embed</td><td>src</td></tr>
 * <tr><td>form</td><td>action</td></tr>
 * <tr><td>iframe</td><td>src</td></tr>
 * <tr><td rowspan="2">img</td><td>src</td></tr>
 * <tr><!-- img --><td>usemap</td></tr>
 * <tr><td rowspan="2">input</td><td>src</td></tr>
 * <tr><!-- input --><td>usemap</td></tr>
 * <tr><td>ins</td><td>cite</td></tr>
 * <tr><td>link</td><td>href</td></tr>
 * <tr><td rowspan="3">object</td><td>codebase</td></tr>
 * <tr><!-- object  --><td>data</td></tr>
 * <tr><!-- object  --><td>usemap</td></tr>
 * <tr><td>q</td><td>cite</td></tr>
 * <tr><td>script</td><td>src</td></tr>
 * <tr><td>track</td><td>src</td></tr>
 * <tr><td>video</td><td>src</td></tr>
 * </tbody>
 * </table>
 *
 */
public class PathAdjuster {

    @SuppressWarnings("unused")
    private static Log log = LogFactory.getLog(PathAdjuster.class);

    /**
     * <p>
     * replace all the path.
     * </p>
     *
     * <h4>template html</h4>
     * <pre>{@code
     * <html>
     * <head>
     *   <script src="foo/bar.js"> </script>
     * </head>
     * <body>
     *   <a href="foo/bar.html">bar.html</a>
     *   <img src="foo/bar.png" />
     * </body>
     * </html>
     * }</pre>
     *
     * <h4>code</h4>
     * <pre>{@code
     * Html html = mixer2Engine.loadHtmlTemplate(templateString);
     * PathAjuster.replacePath(html, Pattern.compile("^foo/"), "xyz/");
     * System.out.println(mixer2Engine.saveToString(html));
     * }</pre>
     *
     * <h4>result:</h4>
     * <pre>{@code
     * <html>
     * <head>
     *   <script src="xyz/bar.js"> </script>
     * </head>
     * <body>
     *   <a href="xyz/bar.html">bar.html</a>
     *   <img src="xyz/bar.png" />
     * </body>
     * </html>
     * }</pre>
     *
     * @param target tag
     * @param pattern regex pattern
     * @param replacement replacemnet string.
     */
    public static <T extends AbstractJaxb> void replacePath(T target,
            Pattern pattern, String replacement) {
        execute(target, pattern, replacement, WHICH.ALL, null, null);
    }

    public static <T extends AbstractJaxb> void replacePathIncludeClass(
            T target, Pattern pattern, String replacement,
            List<String> includeClazz) {
        execute(target, pattern, replacement, WHICH.INCLUDE, includeClazz, null);
    }

    public static <T extends AbstractJaxb> void replacePathIncludeTag(
            T target, Pattern pattern, String replacement,
            List<Class<?>> includeTagType) {
        execute(target, pattern, replacement, WHICH.INCLUDE, null,
                includeTagType);
    }

    public static <T extends AbstractJaxb> void replacePathInclude(T target,
            Pattern pattern, String replacement, List<String> includeClazz,
            List<Class<?>> includeTagType) {
        execute(target, pattern, replacement, WHICH.INCLUDE, includeClazz,
                includeTagType);
    }

    public static <T extends AbstractJaxb> void replacePathExcludeClass(
            T target, Pattern pattern, String replacement,
            List<String> excludeClazz) {
        execute(target, pattern, replacement, WHICH.EXCLUDE, excludeClazz, null);
    }

    public static <T extends AbstractJaxb> void replacePathExcludeTag(T target,
            Pattern pattern, String replacement, List<Class<?>> excludeTagType) {
        execute(target, pattern, replacement, WHICH.EXCLUDE, null,
                excludeTagType);
    }

    public static <T extends AbstractJaxb> void replacePathExclude(T target,
            Pattern pattern, String replacement, List<String> excludeClazz,
            List<Class<?>> excludeTagType) {
        execute(target, pattern, replacement, WHICH.EXCLUDE, excludeClazz,
                excludeTagType);
    }

    private enum WHICH {
        ALL, INCLUDE, EXCLUDE
    }

    private static <T extends AbstractJaxb> boolean match(
            List<String> targetClazz,
            Class<?> targetTagType,
            WHICH which,
            List<String> clazz,
            List<Class<?>> tagType
            ) {

        boolean result;

        switch (which) {
        case ALL:
            result = true;
            break;
        case INCLUDE:
            result = false;
            if (clazzMatch(targetClazz, clazz)
                    && tagTypeMatch(targetTagType, tagType)) {
                result = true;
            }
            break;
        case EXCLUDE:
            result = true;
            if (clazzMatch(targetClazz, clazz)
                    && tagTypeMatch(targetTagType, tagType)) {
                result = false;
            }
            break;
        default:
            result = true;
        }
        return result;
    }

    private static boolean tagTypeMatch(Class<?> targetTagType, List<Class<?>> tagType) {
        boolean tagTypeMatch = false;
        if (tagType == null) {
            tagTypeMatch = true;
        } else {
            TAGTYPEMATCH: for (Class<?> c : tagType) {
                if (c.getName().equals(targetTagType.getName())) {
                    tagTypeMatch = true;
                    break TAGTYPEMATCH;
                }
            }
        }
        return tagTypeMatch;
    }

    private static boolean clazzMatch(List<String> targetClazz,List<String> clazz) {
        boolean clazzMatch = false;
        if (clazz == null) {
            clazzMatch = true;
        } else {
            CLASSMATCH: for (String cssClazz : clazz) {
                if (targetClazz.contains(cssClazz)) {
                    clazzMatch = true;
                    break CLASSMATCH;
                }
            }
        }
        return clazzMatch;
    }

    private static <T extends AbstractJaxb> void execute(
            T target,
            Pattern pattern,
            String replacement,
            WHICH which,
            List<String> clazz,
            List<Class<?>> tagType) {

        TagEnum tagEnum;

        // target must be Tag
        if (target instanceof AbstractJaxb) {
            tagEnum = TagEnum.valueOf(target.getClass().getSimpleName()
                    .toUpperCase());
        } else {
            return;
        }

        switch (tagEnum) {
        case A:
            A a = (A) target;
            if (match(a.getCssClass(), a.getClass(), which, clazz, tagType)) {
                if (a.isSetHref()) {
                    Matcher matcher = pattern.matcher(a.getHref());
                    a.setHref(matcher.replaceFirst(replacement));
                }
            }
            if (a.isSetContent()) {
                replacePathWithinObjectList(a.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case ABBR:
            Abbr abbr = (Abbr) target;
            if (abbr.isSetContent()) {
                replacePathWithinObjectList(abbr.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case ACRONYM:
            Acronym acronym = (Acronym) target;
            if (acronym.isSetContent()) {
                replacePathWithinObjectList(acronym.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case ADDRESS:
            Address address = (Address) target;
            if (address.isSetContent()) {
                replacePathWithinObjectList(address.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case APPLET:
            Applet applet = (Applet) target;
            if (match(applet.getCssClass(), applet.getClass(), which, clazz,
                    tagType)) {
                if (applet.isSetCode()) {
                    Matcher matcher = pattern.matcher(applet.getCode());
                    applet.setCode(matcher.replaceFirst(replacement));
                }
                if (applet.isSetCodebase()) {
                    Matcher matcher = pattern.matcher(applet.getCodebase());
                    applet.setCodebase(matcher.replaceFirst(replacement));
                }
            }
            if (applet.isSetContent()) {
                replacePathWithinObjectList(applet.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case AREA:
            Area area = (Area) target;
            if (match(area.getCssClass(), area.getClass(), which, clazz,
                    tagType)) {
                if (area.isSetHref()) {
                    Matcher matcher = pattern.matcher(area.getHref());
                    area.setHref(matcher.replaceFirst(replacement));
                }
            }
            break;
        case B:
            B b = (B) target;
            if (b.isSetContent()) {
                replacePathWithinObjectList(b.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case BASE:
            Base base = (Base) target;
            if (match(base.getCssClass(), base.getClass(), which, clazz,
                    tagType)) {
                if (base.isSetHref()) {
                    Matcher matcher = pattern.matcher(base.getHref());
                    base.setHref(matcher.replaceFirst(replacement));
                }
            }
            break;
        case BASEFONT:
            break;
        case BDO:
            Bdo bdo = (Bdo) target;
            if (bdo.isSetContent()) {
                replacePathWithinObjectList(bdo.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case BIG:
            Big big = (Big) target;
            if (big.isSetContent()) {
                replacePathWithinObjectList(big.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case BLOCKQUOTE:
            Blockquote blockquote = (Blockquote) target;
            if (match(blockquote.getCssClass(), blockquote.getClass(), which,
                    clazz, tagType)) {
                if (blockquote.isSetCite()) {
                    Matcher matcher = pattern.matcher(blockquote.getCite());
                    blockquote.setCite(matcher.replaceFirst(replacement));
                }
            }
            if (blockquote.isSetContent()) {
                replacePathWithinObjectList(blockquote.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case BODY:
            Body body = (Body) target;
            if (body.isSetContent()) {
                replacePathWithinObjectList(body.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case BR:
            break;
        case BUTTON:
            Button button = (Button) target;
            if (button.isSetContent()) {
                replacePathWithinObjectList(button.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case CAPTION:
            Caption caption = (Caption) target;
            if (caption.isSetContent()) {
                replacePathWithinObjectList(caption.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case CENTER:
            Center center = (Center) target;
            if (center.isSetContent()) {
                replacePathWithinObjectList(center.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case CITE:
            Cite cite = (Cite) target;
            if (cite.isSetContent()) {
                replacePathWithinObjectList(cite.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case CODE:
            Code code = (Code) target;
            if (code.isSetContent()) {
                replacePathWithinObjectList(code.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case COL:
            break;
        case COLGROUP:
            break;
        case DD:
            Dd dd = (Dd) target;
            if (dd.isSetContent()) {
                replacePathWithinObjectList(dd.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case DEL:
            Del del = (Del) target;
            if (del.isSetCite()) {
                Matcher matcher = pattern.matcher(del.getCite());
                del.setCite(matcher.replaceFirst(replacement));

            }
            if (del.isSetContent()) {
                replacePathWithinObjectList(del.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case DFN:
            Dfn dfn = (Dfn) target;
            if (dfn.isSetContent()) {
                replacePathWithinObjectList(dfn.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case DIR:
            Dir dir = (Dir) target;
            if (dir.isSetLi()) {
                for (ListIterator<Li> i = dir.getLi().listIterator(); i
                        .hasNext();) {
                    Li li = i.next();
                    replacePathWithinObjectList(li.getContent(), pattern,
                            replacement, which, clazz, tagType);
                }
            }
            break;
        case DIV:
            Div div = (Div) target;
            if (div.isSetContent()) {
                replacePathWithinObjectList(div.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case DL:
            Dl dl = (Dl) target;
            if (dl.isSetDtOrDd()) {
                for (ListIterator<AbstractJaxb> i = dl.getDtOrDd()
                        .listIterator(); i.hasNext();) {
                    AbstractJaxb aj = i.next();
                    if (aj instanceof Dd) {
                        replacePath((Dd) aj, pattern, replacement);
                    }
                    if (aj instanceof Dt) {
                        replacePath((Dt) aj, pattern, replacement);
                    }
                }
            }
            break;
        case DT:
            Dt dt = (Dt) target;
            if (dt.isSetContent()) {
                replacePathWithinObjectList(dt.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case EM:
            Em em = (Em) target;
            if (em.isSetContent()) {
                replacePathWithinObjectList(em.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case FIELDSET:
            Fieldset fieldset = (Fieldset) target;
            if (fieldset.isSetContent()) {
                replacePathWithinObjectList(fieldset.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case FONT:
            Font font = (Font) target;
            if (font.isSetContent()) {
                replacePathWithinObjectList(font.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case FORM:
            Form form = (Form) target;
            if (match(form.getCssClass(), form.getClass(), which, clazz,
                    tagType)) {
                if (form.isSetAction()) {
                    Matcher matcher = pattern.matcher(form.getAction());
                    form.setAction(matcher.replaceFirst(replacement));
                }
            }
            if (form.isSetContent()) {
                replacePathWithinObjectList(form.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case H1:
            H1 h1 = (H1) target;
            if (h1.isSetContent()) {
                replacePathWithinObjectList(h1.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case H2:
            H2 h2 = (H2) target;
            if (h2.isSetContent()) {
                replacePathWithinObjectList(h2.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case H3:
            H3 h3 = (H3) target;
            if (h3.isSetContent()) {
                replacePathWithinObjectList(h3.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case H4:
            H4 h4 = (H4) target;
            if (h4.isSetContent()) {
                replacePathWithinObjectList(h4.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case H5:
            H5 h5 = (H5) target;
            if (h5.isSetContent()) {
                replacePathWithinObjectList(h5.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case H6:
            H6 h6 = (H6) target;
            if (h6.isSetContent()) {
                replacePathWithinObjectList(h6.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case HGROUP:
            Hgroup hgroup = (Hgroup) target;
            if (hgroup.isSetH1OrH2OrH3()) {
                for (AbstractJaxb aj: hgroup.getH1OrH2OrH3()) {
                    execute(aj, pattern, replacement, which, clazz, tagType);
                }
            }
            break;
        case HEAD:
            Head head = (Head) target;
            for (ListIterator<AbstractJaxb> i = head.getContent()
                    .listIterator(); i.hasNext();) {
                AbstractJaxb aj = i.next();
                execute(aj, pattern, replacement, which, clazz, tagType);
            }
            break;
        case HR:
            break;
        case HTML:
            Html html = (Html) target;
            if (html.isSetHead()) {
                execute(html.getHead(), pattern, replacement, which, clazz,
                        tagType);
            }
            if (html.isSetBody()) {
                execute(html.getBody(), pattern, replacement, which, clazz,
                        tagType);
            }
            break;
        case I:
            I i = (I) target;
            if (i.isSetContent()) {
                replacePathWithinObjectList(i.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case IFRAME:
            Iframe iframe = (Iframe) target;
            if (match(iframe.getCssClass(), iframe.getClass(), which, clazz,
                    tagType)) {
                if (iframe.isSetSrc()) {
                    Matcher matcher = pattern.matcher(iframe.getSrc());
                    iframe.setSrc(matcher.replaceFirst(replacement));
                }
            }
            if (iframe.isSetContent()) {
                replacePathWithinObjectList(iframe.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case IMG:
            Img img = (Img) target;
            if (match(img.getCssClass(), img.getClass(), which, clazz, tagType)) {
                if (img.isSetSrc()) {
                    Matcher matcher = pattern.matcher(img.getSrc());
                    img.setSrc(matcher.replaceFirst(replacement));
                }
                if (img.isSetUsemap()) {
                    Matcher matcher = pattern.matcher(img.getUsemap());
                    img.setUsemap(matcher.replaceFirst(replacement));
                }
            }
            break;
        case INPUT:
            Input input = (Input) target;
            if (match(input.getCssClass(), input.getClass(), which, clazz,
                    tagType)) {
                if (input.isSetSrc()) {
                    Matcher matcher = pattern.matcher(input.getSrc());
                    input.setSrc(matcher.replaceFirst(replacement));
                }
            }
            break;
        case INS:
            Ins ins = (Ins) target;
            if (match(ins.getCssClass(), ins.getClass(), which, clazz, tagType)) {
                if (ins.isSetCite()) {
                    Matcher matcher = pattern.matcher(ins.getCite());
                    ins.setCite(matcher.replaceFirst(replacement));
                }
            }
            if (ins.isSetContent()) {
                replacePathWithinObjectList(ins.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case ISINDEX:
            break;
        case KBD:
            Kbd kbd = (Kbd) target;
            if (kbd.isSetContent()) {
                replacePathWithinObjectList(kbd.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case LABEL:
            Label label = (Label) target;
            if (label.isSetContent()) {
                replacePathWithinObjectList(label.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case LEGEND:
            Legend legend = (Legend) target;
            if (legend.isSetContent()) {
                replacePathWithinObjectList(legend.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case LI:
            Li li = (Li) target;
            if (li.isSetContent()) {
                replacePathWithinObjectList(li.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case LINK:
            Link link = (Link) target;
            if (match(link.getCssClass(), link.getClass(), which, clazz,
                    tagType)) {
                if (link.isSetHref()) {
                    Matcher matcher = pattern.matcher(link.getHref());
                    link.setHref(matcher.replaceFirst(replacement));
                }
            }
            break;
        case MAP:
            Map map = (Map) target;
            if (map.isSetArea()) {
                for (ListIterator<Area> j = map.getArea().listIterator(); j
                        .hasNext();) {
                    Area tmpArea = j.next();
                    execute(tmpArea, pattern, replacement, which, clazz, tagType);
                }
            }
            if (map.isSetPOrH1OrH2()) {
                for (ListIterator<AbstractJaxb> j = map.getPOrH1OrH2()
                        .listIterator(); j.hasNext();) {
                    AbstractJaxb aj = j.next();
                    execute(aj, pattern, replacement, which, clazz, tagType);
                }
            }
            break;
        case MENU:
            Menu menu = (Menu) target;
            if (menu.isSetContent()) {
                replacePathWithinObjectList(menu.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case META:
            break;
        case NOFRAMES:
            Noframes noframes = (Noframes) target;
            if (noframes.isSetContent()) {
                replacePathWithinObjectList(noframes.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case NOSCRIPT:
            Noscript noscript = (Noscript) target;
            if (noscript.isSetContent()) {
                replacePathWithinObjectList(noscript.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case OBJECT:
            org.mixer2.jaxb.xhtml.Object object = (org.mixer2.jaxb.xhtml.Object) target;
            if (match(object.getCssClass(), object.getClass(), which, clazz,
                    tagType)) {
                if (object.isSetCodebase()) {
                    Matcher matcher = pattern.matcher(object.getCodebase());
                    object.setCodebase(matcher.replaceFirst(replacement));
                }
                if (object.isSetData()) {
                    Matcher matcher = pattern.matcher(object.getData());
                    object.setData(matcher.replaceFirst(replacement));
                }
                if (object.isSetUsemap()) {
                    Matcher matcher = pattern.matcher(object.getUsemap());
                    object.setUsemap(matcher.replaceFirst(replacement));
                }
            }
            if (object.isSetContent()) {
                replacePathWithinObjectList(object.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case OL:
            Ol ol = (Ol) target;
            if (ol.isSetLi()) {
                for (ListIterator<Li> j = ol.getLi().listIterator(); j
                        .hasNext();) {
                    Li li2 = j.next();
                    replacePathWithinObjectList(li2.getContent(), pattern,
                            replacement, which, clazz, tagType);
                }
            }
            break;
        case OPTGROUP:
            break;
        case OPTION:
            break;
        case P:
            P p = (P) target;
            if (p.isSetContent()) {
                replacePathWithinObjectList(p.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case PARAM:
            break;
        case PRE:
            Pre pre = (Pre) target;
            if (pre.isSetContent()) {
                replacePathWithinObjectList(pre.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case Q:
            Q q = (Q) target;
            if (match(q.getCssClass(), q.getClass(), which, clazz, tagType)) {
                if (q.isSetCite()) {
                    Matcher matcher = pattern.matcher(q.getCite());
                    q.setCite(matcher.replaceFirst(replacement));
                }
            }
            if (q.isSetContent()) {
                replacePathWithinObjectList(q.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case S:
            S s = (S) target;
            if (s.isSetContent()) {
                replacePathWithinObjectList(s.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case SAMP:
            Samp samp = (Samp) target;
            if (samp.isSetContent()) {
                replacePathWithinObjectList(samp.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case SCRIPT:
            Script script = (Script) target;
            if (match(script.getCssClass(), script.getClass(), which, clazz,
                    tagType)) {
                if (script.isSetSrc()) {
                    Matcher matcher = pattern.matcher(script.getSrc());
                    script.setSrc(matcher.replaceFirst(replacement));
                }
            }
            break;
        case SELECT:
            Select select = (Select) target;
            if (select.isSetOptgroupOrOption()) {
                for (ListIterator<AbstractJaxb> j = select
                        .getOptgroupOrOption().listIterator(); j.hasNext();) {
                    AbstractJaxb aj = j.next();
                    execute(aj, pattern, replacement, which, clazz, tagType);
                }
            }
            break;
        case SMALL:
            Small small = (Small) target;
            if (small.isSetContent()) {
                replacePathWithinObjectList(small.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case SPAN:
            Span span = (Span) target;
            if (span.isSetContent()) {
                replacePathWithinObjectList(span.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case STRIKE:
            Strike strike = (Strike) target;
            if (strike.isSetContent()) {
                replacePathWithinObjectList(strike.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case STRONG:
            Strong strong = (Strong) target;
            if (strong.isSetContent()) {
                replacePathWithinObjectList(strong.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case STYLE:
            break;
        case SUB:
            Sub sub = (Sub) target;
            if (sub.isSetContent()) {
                replacePathWithinObjectList(sub.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case SUP:
            Sup sup = (Sup) target;
            if (sup.isSetContent()) {
                replacePathWithinObjectList(sup.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case TABLE:
            Table table = (Table) target;
            if (table.isSetCol()) {
                for (ListIterator<Col> j = table.getCol().listIterator(); j
                        .hasNext();) {
                    Col col1 = j.next();
                    execute(col1, pattern, replacement, which, clazz, tagType);
                }
            }
            if (table.isSetColgroup()) {
                for (ListIterator<Colgroup> j = table.getColgroup()
                        .listIterator(); j.hasNext();) {
                    Colgroup cg = j.next();
                    execute(cg, pattern, replacement, which, clazz, tagType);
                }
            }
            if (table.isSetTbody()) {
                for (ListIterator<Tbody> j = table.getTbody().listIterator(); j
                        .hasNext();) {
                    Tbody tbody = j.next();
                    execute(tbody, pattern, replacement, which, clazz, tagType);
                }
            }
            if (table.isSetThead()) {
                execute(table.getThead(), pattern, replacement, which, clazz, tagType);
            }
            if (table.isSetTfoot()) {
                execute(table.getTfoot(), pattern, replacement, which, clazz, tagType);
            }
            if (table.isSetTr()) {
                for (ListIterator<Tr> j = table.getTr().listIterator(); j
                        .hasNext();) {
                    Tr tr = j.next();
                    execute(tr, pattern, replacement, which, clazz, tagType);
                }
            }
            break;
        case TBODY:
            Tbody tbody = (Tbody) target;
            if (tbody.isSetTr()) {
                for (ListIterator<Tr> j = tbody.getTr().listIterator(); j
                        .hasNext();) {
                    Tr tr = j.next();
                    execute(tr, pattern, replacement, which, clazz, tagType);
                }
            }
            break;
        case TD:
            Td td = (Td) target;
            if (td.isSetContent()) {
                replacePathWithinObjectList(td.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case TEXTAREA:
            break;
        case TFOOT:
            Tfoot tfoot = (Tfoot) target;
            if (tfoot.isSetTr()) {
                for (ListIterator<Tr> j = tfoot.getTr().listIterator(); j
                        .hasNext();) {
                    Tr tr = j.next();
                    execute(tr, pattern, replacement, which, clazz, tagType);
                }
            }
            break;
        case TH:
            Th th = (Th) target;
            if (th.isSetContent()) {
                replacePathWithinObjectList(th.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case THEAD:
            Thead thead = (Thead) target;
            if (thead.isSetTr()) {
                for (ListIterator<Tr> j = thead.getTr().listIterator(); j
                        .hasNext();) {
                    Tr tr = j.next();
                    execute(tr, pattern, replacement, which, clazz, tagType);
                }
            }
            break;
        case TITLE:
            break;
        case TR:
            Tr tr = (Tr) target;
            if (tr.isSetThOrTd()) {
                for (ListIterator<Flow> j = tr.getThOrTd().listIterator(); j
                        .hasNext();) {
                    Flow flow = j.next();
                    execute(flow, pattern, replacement, which, clazz, tagType);
                }
            }
            break;
        case TT:
            Tt tt = (Tt) target;
            if (tt.isSetContent()) {
                replacePathWithinObjectList(tt.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case U:
            U u = (U) target;
            if (u.isSetContent()) {
                replacePathWithinObjectList(u.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case UL:
            Ul ul = (Ul) target;
            if (ul.isSetLi()) {
                for (ListIterator<Li> j = ul.getLi().listIterator(); j
                        .hasNext();) {
                    Li li2 = j.next();
                    execute(li2, pattern, replacement, which, clazz, tagType);
                }
            }
            break;
        case VAR:
            Var var = (Var) target;
            if (var.isSetContent()) {
                replacePathWithinObjectList(var.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case ARTICLE:
            Article article = (Article) target;
            if (article.isSetContent()) {
                replacePathWithinObjectList(article.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case ASIDE:
            Aside aside = (Aside) target;
            if (aside.isSetContent()) {
                replacePathWithinObjectList(aside.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case AUDIO:
            Audio audio = (Audio) target;
            if (match(audio.getCssClass(), audio.getClass(), which, clazz,
                    tagType)) {
                if (audio.isSetContent()) {
                    replacePathWithinObjectList(audio.getContent(), pattern,
                            replacement, which, clazz, tagType);
                }
            }
            break;
        case BDI:
            Bdi bdi = (Bdi) target;
            if (bdi.isSetContent()) {
                replacePathWithinObjectList(bdi.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case CANVAS:
            Canvas canvas = (Canvas) target;
            if (canvas.isSetContent()) {
                replacePathWithinObjectList(canvas.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case COMMAND:
            break;
        case DATALIST:
            Datalist datalist = (Datalist) target;
            if (datalist.isSetContent()) {
                replacePathWithinObjectList(datalist.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case DETAILS:
            Details details = (Details) target;
            if (details.isSetContent()) {
                replacePathWithinObjectList(details.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case EMBED:
            Embed embed = (Embed) target;
            if (match(embed.getCssClass(), embed.getClass(), which, clazz,
                    tagType)) {
                if (embed.isSetSrc()) {
                    Matcher matcher = pattern.matcher(embed.getSrc());
                    embed.setSrc(matcher.replaceFirst(replacement));
                }
            }
            break;
        case FIGCAPTION:
            Figcaption figcaption = (Figcaption) target;
            if (figcaption.isSetContent()) {
                replacePathWithinObjectList(figcaption.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case FIGURE:
            Figure figure = (Figure) target;
            if (figure.isSetContent()) {
                replacePathWithinObjectList(figure.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case FOOTER:
            Footer footer = (Footer) target;
            if (footer.isSetContent()) {
                replacePathWithinObjectList(footer.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case HEADER:
            Header header = (Header) target;
            if (header.isSetContent()) {
                replacePathWithinObjectList(header.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case KEYGEN:
            break;
        case MARK:
            Mark mark = (Mark) target;
            if (mark.isSetContent()) {
                replacePathWithinObjectList(mark.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case METER:
            Meter meter = (Meter) target;
            if (meter.isSetContent()) {
                replacePathWithinObjectList(meter.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case NAV:
            Nav nav = (Nav) target;
            if (nav.isSetContent()) {
                replacePathWithinObjectList(nav.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case OUTPUT:
            Output output = (Output) target;
            if (output.isSetContent()) {
                replacePathWithinObjectList(output.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case PROGRESS:
            Progress progress = (Progress) target;
            if (progress.isSetContent()) {
                replacePathWithinObjectList(progress.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case RP:
            Rp rp = (Rp) target;
            if (rp.isSetContent()) {
                replacePathWithinObjectList(rp.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case RT:
            Rt rt = (Rt) target;
            if (rt.isSetContent()) {
                replacePathWithinObjectList(rt.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case RUBY:
            Ruby ruby = (Ruby) target;
            if (ruby.isSetContent()) {
                replacePathWithinObjectList(ruby.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case SECTION:
            Section section = (Section) target;
            if (section.isSetContent()) {
                replacePathWithinObjectList(section.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case SOURCE:
            Source source = (Source) target;
            if (match(source.getCssClass(), source.getClass(), which, clazz,
                    tagType)) {
                if (source.isSetSrc()) {
                    Matcher matcher = pattern.matcher(source.getSrc());
                    source.setSrc(matcher.replaceFirst(replacement));
                }
            }
            break;
        case SUMMARY:
            Summary summary = (Summary) target;
            if (summary.isSetContent()) {
                replacePathWithinObjectList(summary.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case TIME:
            Time time = (Time) target;
            if (time.isSetContent()) {
                replacePathWithinObjectList(time.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case TRACK:
            Track track = (Track) target;
            if (match(track.getCssClass(), track.getClass(), which, clazz,
                    tagType)) {
                if (track.isSetSrc()) {
                    Matcher matcher = pattern.matcher(track.getSrc());
                    track.setSrc(matcher.replaceFirst(replacement));
                }
            }
            break;
        case VIDEO:
            Video video = (Video) target;
            if (match(video.getCssClass(), video.getClass(), which, clazz,
                    tagType)) {
                if (video.isSetSrc()) {
                    Matcher matcher = pattern.matcher(video.getSrc());
                    video.setSrc(matcher.replaceFirst(replacement));
                }
            }
            if (video.isSetContent()) {
                replacePathWithinObjectList(video.getContent(), pattern,
                        replacement, which, clazz, tagType);
            }
            break;
        case WBR:
            break;
        }

    }

    private static void replacePathWithinObjectList(
            List<java.lang.Object> list, Pattern pattern, String replacement,
            WHICH which, List<String> clazz, List<Class<?>> tagType) {

        for (ListIterator<java.lang.Object> i = list.listIterator(); i
                .hasNext();) {
            java.lang.Object tmpobj = i.next();
            if (tmpobj instanceof AbstractJaxb) {
                execute((AbstractJaxb) tmpobj, pattern, replacement, which, clazz, tagType);
            }
        }
    }

}

package org.mixer2.xhtml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.util.CastUtil;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;
import org.mixer2.xhtml.util.GetByIdUtil;
import org.mixer2.xhtml.util.GetDescendantsUtil;
import org.mixer2.xhtml.util.InsertByIdUtil;
import org.mixer2.xhtml.util.RemoveByIdUtil;
import org.mixer2.xhtml.util.RemoveDescendantsUtil;
import org.mixer2.xhtml.util.RemoveEmptyCssClassUtil;
import org.mixer2.xhtml.util.ReplaceByIdUtil;
import org.mixer2.xhtml.util.ReplaceDescendantsUtil;
import org.mixer2.xhtml.util.UnsetIdUtil;

/**
 * すべてのタグ型の基底クラスです。
 *
 * @author watanabe
 *
 */
@javax.xml.bind.annotation.XmlTransient
public abstract class AbstractJaxb implements Serializable {

    private static Log log = LogFactory.getLog(AbstractJaxb.class);
    private static final long serialVersionUID = 1L;

    /**
     * 型キャストをするメソッドです。 括弧記号でキャストをする手間を省きます。
     *
     * <pre>
     * // usage:
     * // get a TD tag of first row, first column.
     * Td td = html.getById(&quot;foo&quot;, Table.class).getTr().get(0).getThOrTd().get(0)
     *         .cast(Td.class);
     * </pre>
     *
     * @param <T>
     * @param clazz
     * @return
     */
    public <T> T cast(Class<T> clazz) {
        return CastUtil.<T> cast(this);
    }

    /**
     * <p>
     * 指定したid属性を持つ子孫要素を取得します。 戻り値は指定したタグ型なのでキャストの必要はありません。
     * </p>
     *
     * <pre>
     * // sample: get a Div tag having id=&quot;foo&quot; property.
     * html.getById(&quot;foo&quot;, Div.class);
     * </pre>
     *
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> T getById(String id, Class<T> tagType)
            throws TagTypeUnmatchException {
        Object obj = GetByIdUtil.getById(id, this);
        if (obj != null && !obj.getClass().isAssignableFrom(tagType)) {
            throw new TagTypeUnmatchException(tagType.getClass(),
                    obj.getClass());
        }
        return (T) obj;
    }

    /**
     * 指定したid属性を持つ子孫要素を取得します。 戻り値を正式なタグとして使うには適合するタグ型にキャストする必要があります。
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> T getById(String id) {
        Object obj = GetByIdUtil.getById(id, this);
        return (T) obj;
    }

    /**
     * <p>
     * 自分自身の子孫要素のうち、指定したid属性を持つ要素を削除します。 自分自身を削除することはできません。
     * </p>
     *
     */
    public boolean removeById(String id) {
        return RemoveByIdUtil.removeById(id, this);
    }

    /**
     * <p>
     * 自分自身の子孫要素のうち、指定したid属性を持つ要素を置換します。 自分自身を置換することはできません。
     * なお、replaceのディープコピーで置換されます。
     * </p>
     *
     * @return 置換に成功すればtrue、置換対象が見つからなければfalseを返します。
     */
    public <T extends AbstractJaxb> boolean replaceById(String id, T obj)
            throws TagTypeUnmatchException {
        return ReplaceByIdUtil.replaceById(id, this, obj);
    }

    /**
     * <p>
     * 自分自身の子孫要素のうち、指定したid属性を持つ要素を、 指定された文字列で置換します。 自分自身を置換することはできません。
     * </p>
     *
     * @return 置換に成功すればtrue、置換対象が見つからなければfalseを返します。
     */
    public <T extends AbstractJaxb> boolean replaceById(String id, String string)
            throws TagTypeUnmatchException {
        return ReplaceByIdUtil.replaceById(id, this, string);
    }

    /**
     * <p>
     * 指定したタグ型で、かつ指定したclass属性を持つ子孫要素を探してListで返します
     * </p>
     *
     * <pre>
     * // usage:
     * // get all div objects having &quot;foo&quot; class
     * List&lt;Div&gt; divList = html.getDescendants(&quot;foo&quot;, Div.class);
     * // get all Table objects having &quot;bar&quot; class within &lt;div id=&quot;foo&quot;&gt;
     * List&lt;Table&gt; tbList = html.getById(&quot;foo&quot;, Div.class).getDescendants(&quot;bar&quot;,
     *         Table.class);
     * </pre>
     *
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> List<T> getDescendants(String clazz,
            Class<T> tagType) {
        return GetDescendantsUtil.getDescendants((T) this, new ArrayList<T>(),
                clazz, tagType);
    }

    /**
     * <p>
     * 指定したタグ型の子孫要素を探してListで返します
     * </p>
     *
     * <pre>
     * // usage:
     * // get all div objects.
     * html.getDescendants(Div.class);
     * // get all table objects within &lt;div id=&quot;foo&quot;&gt;
     * html.getById(&quot;foo&quot;, Div.class).getDescendants(Table.class);
     * </pre>
     *
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> List<T> getDescendants(Class<T> tagType) {
        return GetDescendantsUtil.getDescendants((T) this, new ArrayList<T>(),
                tagType);
    }

    /**
     * <p>
     * 指定したclass属性を持つ子孫要素を探してListで返します
     * </p>
     *
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> List<T> getDescendants(String clazz) {
        return GetDescendantsUtil.getDescendants((T) this, new ArrayList<T>(),
                clazz);
    }

    /**
     * 指定したタグ型で、かつ、指定したclass属性を持つ子孫要素をすべて削除します
     *
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void removeDescendants(String clazz,
            Class<T> tagType) {
        RemoveDescendantsUtil.removeDescendants((T) this, clazz, tagType);
    }

    /**
     * 指定したタグ型の子孫要素をすべて削除します
     *
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void removeDescendants(Class<T> tagType) {
        RemoveDescendantsUtil.removeDescendants((T) this, tagType);
    }

    /**
     * 指定したclass属性を持つ子孫要素をすべて削除します
     *
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void removeDescendants(String clazz) {
        RemoveDescendantsUtil.removeDescendants((T) this, clazz);
    }

    /**
     * 指定したタグ型で、かつ、指定したclass属性を持つすべての子孫要素を置換します。 なお、replaceのディープコピーで置換されます。
     *
     * @return 置換に成功すればtrue、置換対象が見つからなければfalseを返します。
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(String clazz,
            Class<T> tagType, T replace) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, tagType, clazz,
                replace);
    }

    /**
     * 指定したタグ型で、かつ、指定したclass属性を持つすべての子孫要素を 文字列で置換します。
     *
     * @return 置換に成功すればtrue、置換対象が見つからなければfalseを返します。
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(String clazz,
            Class<T> tagType, String replace) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, tagType, clazz,
                replace);
    }

    /**
     * 指定したタグ型の子孫要素を置換します。 なお、replaceのディープコピーで置換されます。
     *
     * @return 置換に成功すればtrue、置換対象が見つからなければfalseを返します。
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(Class<T> tagType,
            T replace) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, tagType, replace);
    }

    /**
     * 指定したタグ型の子孫要素を文字列で置換します。
     *
     * @return 置換に成功すればtrue、置換対象が見つからなければfalseを返します。
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(Class<T> tagType,
            String replace) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, tagType, replace);
    }

    /**
     * 指定したclass属性を持つ子孫要素を置換します。 なお、replaceのディープコピーで置換されます。
     *
     * @return 置換に成功すればtrue、置換対象が見つからなければfalseを返します。
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(String clazz,
            T replace) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, clazz, replace);
    }

    /**
     * 指定したclass属性を持つ子孫要素を文字列で置換します。
     *
     * @return 置換に成功すればtrue、置換対象が見つからなければfalseを返します。
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(String clazz,
            String replace) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, clazz, replace);
    }

    /**
     * 指定したid属性を持つタグの直後（内部ではない）に挿入します。 なお、挿入されるのはreplaceのディープコピーです。
     *
     * @return 挿入に成功すればtrue、挿入対象が見つからなければfalseを返します。
     */
    public <T extends AbstractJaxb> boolean insertAfterId(String id, T insObject)
            throws TagTypeUnmatchException {
        return InsertByIdUtil.insertAfterId(id, insObject, this);
    }

    /**
     * 指定したid属性を持つタグの直後（内部ではない）に文字列を挿入します。
     *
     * @return 挿入に成功すればtrue、挿入対象が見つからなければfalseを返します。
     */
    public boolean insertAfterId(String id, String insString)
            throws TagTypeUnmatchException {
        return InsertByIdUtil.insertAfterId(id, insString, this);
    }

    /**
     * 指定したid属性を持つタグの直前に挿入します。 なお、挿入されるのはreplaceのディープコピーです。
     *
     * @return 挿入に成功すればtrue、挿入対象が見つからなければfalseを返します。
     */
    public <T extends AbstractJaxb> boolean insertBeforeId(String id,
            T insObject) throws TagTypeUnmatchException {
        return InsertByIdUtil.insertBeforeId(id, insObject, this);
    }

    /**
     * 指定したid属性を持つタグの直前に文字列を挿入します。
     *
     * @return 挿入に成功すればtrue、挿入対象が見つからなければfalseを返します。
     */
    public boolean insertBeforeId(String id, String insString)
            throws TagTypeUnmatchException {
        return InsertByIdUtil.insertBeforeId(id, insString, this);
    }

    /**
     * <p>
     * TreeMap形式で定義したstyle属性を書きこみます。
     * </p>
     *
     * <pre>
     * // usage:
     * TreeMap&lt;String, String&gt; styleMap = new TreeMap&lt;String, String&gt;();
     * styleMap.put(&quot;border-color&quot;, &quot;red&quot;);
     * html.getById(Div.class, &quot;hellomsg&quot;).setStyleByTreeMap(styleMap);
     * // output:
     * // &lt;div id=&quot;hellomsg&quot; style=&quot;border-color:red;&quot;&gt;...&lt;/div&gt;
     * </pre>
     *
     */
    public <T extends AbstractJaxb> void setStyleByTreeMap(
            TreeMap<String, String> styleMap) {
        String str = "";
        for (String key : styleMap.keySet()) {
            str += key + ":" + styleMap.get(key) + "; ";
        }
        this.setStyle(str);
    }

    /**
     * タグのstyle属性をTreeMapで返します
     * @return
     */
    public TreeMap<String, String> getStyleAsTreeMap() {
        TreeMap<String, String> resultMap = new TreeMap<String, String>();
        if (StringUtils.isBlank(this.getStyle())) {
            return resultMap;
        }
        String st[] = this.getStyle().trim().split(";");
        String st2[];
        for (String s : st) {
            st2 = s.split(":");
            resultMap.put(st2[0].trim(), st2[1].trim());
        }
        return resultMap;
    }

    /**
     * <p>
     * 自分自身のディープコピーを返します。
     * </p>
     * <p>
     * FIXME this method using serialize/unserialize. it's slow. please remake.
     * </p>
     *
     * <pre>
     * // usage
     * Div div = html.getById(Div.class, &quot;foo&quot;);
     * Div div2 = div.copy(Div.class);
     * </pre>
     *
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> T copy(Class<T> tagType)
            throws TagTypeUnmatchException {

        if (!tagType.equals(this.getClass())) {
            log.warn("to use copy() method, tagType must be same type of the original object.");
            throw new TagTypeUnmatchException(getClass(), tagType);
        }

        ObjectInputStream in;
        Object result = null;
        try {
            ByteArrayInputStream byteIn = new ByteArrayInputStream(
                    this.toByteArray());
            in = new ObjectInputStream(byteIn);
            result = in.readObject();
        } catch (IOException e) {
            log.warn("IOException occurred while copy() on jaxb object.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            log.warn("ClassNotFoundException occurred while copy() on jaxb object.");
            e.printStackTrace();
        }

        return (T) result;
    }

    /**
     * data-* 属性を設定します
     * @param key data-"key"
     * @param value
     */
    public void setData(String key, String value) {
        QName qn = new QName("data-" + key);
        this.getOtherAttributes().put(qn, value);
    }

    /**
     * data-* 属性の値を返します。値が設定されていない場合はnullが返されます
     * @param key data-"key"
     * @return
     */
    public String getData(String key){
        QName qn = new QName("data-" + key);
        return this.getOtherAttributes().get(qn);
    }

    /**
     * aria-* 属性を設定します
     * @param key aria-"key"
     * @param value
     */
    public void setAria(String key, String value) {
        QName qn = new QName("aria-" + key);
        this.getOtherAttributes().put(qn, value);
    }

    /**
     * aria-* 属性の値を返します。値が設定されていない場合はnullが返されます
     * @param key aria-"key"
     * @return
     */
    public String getAria(String key) {
        QName qn = new QName("aria-" + key);
        return this.getOtherAttributes().get(qn);
    }

    /**
     * otherAttributeマップを取得します。
     * このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。
     */
    public Map<QName, String> getOtherAttributes() {
        return null;
    }

    /**
     * id属性を取得します。設定されていなければnullを返します。 このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。 （xhtmlでは全種類のタグがid属性を持ちます）
     */
    public String getId() {
        return null;
    }

    /**
     * id属性をセットします。属性を削除したい場合にはnullを与えてください。 このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。 （xhtmlでは全種類のタグがid属性を持ちます）
     */
    public void setId(String id) {
    }

    /**
     * id属性がセットされているか（nullではないか）を返します。 このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。 （xhtmlでは全種類のタグがid属性を持ちます）
     */
    public boolean isSetId() {
        return false;
    }

    /**
     * 自分の子孫要素すべてのid属性を削除します。 自分自身のid属性も削除します。
     */
    public void unsetAllId() {
        UnsetIdUtil.unsetAllId(this);
    }

    /**
     * 自分の子孫要素のうち、そのid属性が指定の正規表現とマッチする場合に、id属性を削除します。
     * 自分自身のid属性も、patternにマッチする場合は削除します。
     */
    public void unsetAllId(Pattern pattern) {
        UnsetIdUtil.unsetAllId(this, pattern);
    }

    /**
     * タグのstyle属性を返します。このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。
     * （html5では全てのタグがclass属性とstyle属性を持ちます。）
     *
     * @return
     */
    public String getStyle() {
        return null;
    }

    /**
     * タグのstyle属性をセットします。このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。
     * （html5では全てのタグがclass属性とstyle属性を持ちます。）
     *
     * @return
     */
    public void setStyle(String value) {
        return;
    }

    /**
     * タグのclass属性をリストで返します。このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。
     * （html5では全てのタグがclass属性とstyle属性を持ちます。）
     *
     * @return
     */
    public List<String> getCssClass() {
        return null;
    }

    /**
     * 指定した文字列がclass属性に含まれているかどうかを判定します
     */
    public <T extends AbstractJaxb> boolean hasCssClass(String clazz) {
        boolean result = false;
        List<String> classList = this.getCssClass();
        if (classList != null && classList.contains(clazz)) {
            result = true;
        }
        return result;
    }

    /**
     * 指定した文字列をclass属性に追加します。既にある場合には何もしません。
     */
    public <T extends AbstractJaxb> void addCssClass(String clazz) {
        List<String> classList = this.getCssClass();
        if (!this.hasCssClass(clazz)) {
            classList.add(clazz);
        }
    }

    /**
     * 指定した文字列がclass属性に含まれていればそれをすべて削除します
     */
    public <T extends AbstractJaxb> void removeCssClass(String clazz) {
        List<String> classList = this.getCssClass();
        if (classList != null) {
            for (ListIterator<String> i = classList.listIterator(); i.hasNext();) {
                if (i.next().equals(clazz)) {
                    i.remove();
                }
            }
        }
    }

    /**
     * <p>
     * class属性の内容が何も指定されていない場合にのみclass属性自体を削除します。 自分の配下の子孫要素すべてに作用します。
     * これは下のような無意味なclass指定が出力されてしまうことを防ぐためのメソッドです。
     * </p>
     *
     * <pre>
     * &lt;div class=&quot;&quot;&gt;....&lt;/div&gt;
     * </pre>
     *
     */
    public void removeEmptyCssClass() {
        RemoveEmptyCssClassUtil.removeEmptyCssClass(this);
    }

    /**
     * 自分自身のバイト列表現を返します。
     *
     */
    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(this);
        return byteOut.toByteArray();
    }

    /**
     * <p>
     * デバッグ用です。
     * {@link org.apache.commons.lang.builder.ToStringBuilder#toString()}
     * </p>
     */
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE).toString();
    }

}

package org.mixer2.xhtml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.util.CastUtil;
import org.mixer2.util.M2StringUtils;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;
import org.mixer2.xhtml.util.CopyUtil;
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
 * <p>
 * base class of all tag type
 * </p>
 * <p>
 * すべてのタグ型の基底クラスです。
 * </p>
 *
 * @author watanabe
 *
 */
@javax.xml.bind.annotation.XmlTransient
public abstract class AbstractJaxb implements Serializable {

    private static Log log = LogFactory.getLog(AbstractJaxb.class);
    private static final long serialVersionUID = 1L;

    /**
     * <p>
     * type cast.
     * </p>
     * <p>
     * 型キャストをするメソッドです。 括弧記号でキャストをする手間を省きます。
     * </p>
     *
     * <pre>
     * // usage:
     * // get a TD tag of first row, first column.
     * Td td = html.getById(&quot;foo&quot;, Table.class).getTr().get(0).getThOrTd().get(0)
     *         .cast(Td.class);
     * </pre>
     *
     * @param clazz
     *            tag type of org.mixer2.jaxb.xhtml.*
     * @return
     */
    public <T> T cast(Class<T> clazz) {
        return CastUtil.<T> cast(this);
    }

    /**
     * <p>
     * get tag that has specified id property. You don't need to cast() because
     * you can specify the tag type.
     * </p>
     * <p>
     * 指定したid属性を持つ子孫要素を取得します。 戻り値は指定したタグ型なのでキャストの必要はありません。
     * </p>
     *
     * <pre>
     * // sample: get a Div tag having id=&quot;foo&quot; property.
     * html.getById(&quot;foo&quot;, Div.class);
     * </pre>
     *
     * @param id
     * @param tagType
     * @return
     * @throws TagTypeUnmatchException
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
     * <p>
     * get tag that has specified id property. To use return value as ussual
     * tag, you must cast() it.
     * </p>
     * <p>
     * 指定したid属性を持つ子孫要素を取得します。 戻り値を正式なタグとして使うには適合するタグ型にキャストする必要があります。
     * </p>
     *
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> T getById(String id) {
        Object obj = GetByIdUtil.getById(id, this);
        return (T) obj;
    }

    /**
     * <p>
     * delete element that has specified id property within descendant element
     * of oneself. you can't delete oneself.
     * </p>
     * <p>
     * 自分自身の子孫要素のうち、指定したid属性を持つ要素を削除します。 自分自身を削除することはできません。
     * </p>
     *
     * @param id
     * @return
     */
    public boolean removeById(String id) {
        return RemoveByIdUtil.removeById(id, this);
    }

    /**
     * <p>
     * replace element that has specified property within descendant element of
     * oneself. you can't replace oneself. It will be replaced by deep copy of
     * "replacement"
     * </p>
     * <p>
     * 自分自身の子孫要素のうち、指定した要素を置換します。 自分自身を置換することはできません。
     * なお、replaceのディープコピーで置換されます。
     * </p>
     *
     * @param target
     * @param replacement
     * @return if success to replace, return true. if no hit, return false.
     * @throws TagTypeUnmatchException
     */
    public <T extends AbstractJaxb> boolean replace(T target, T replacement)
            throws TagTypeUnmatchException {
        String id = target.getId();
        if (id == null) {
            for (int i = 0; i < 256; i++) {
                id = UUID.randomUUID().toString();
                if (this.getById(id) == null && replacement.getById(id) == null) {
                    target.setId(id);
                    break;
                }
            }
        }
        return ReplaceByIdUtil.replaceById(id, this, replacement);
    }

    /**
     * <p>
     * replace element that has specified id property within descendant element
     * of oneself. you can't replace oneself. It will be replaced by deep copy
     * of "replacement"
     * </p>
     * <p>
     * 自分自身の子孫要素のうち、指定したid属性を持つ要素を置換します。 自分自身を置換することはできません。
     * なお、replaceのディープコピーで置換されます。
     * </p>
     *
     * @param id
     * @param replacement
     * @return if success to replace, return true. if no hit, return false.
     * @throws TagTypeUnmatchException
     */
    public <T extends AbstractJaxb> boolean replaceById(String id, T replacement)
            throws TagTypeUnmatchException {
        return ReplaceByIdUtil.replaceById(id, this, replacement);
    }

    /**
     * <p>
     * replace element by string. you can't replace oneself.
     * </p>
     * <p>
     * 自分自身の子孫要素のうち、指定したid属性を持つ要素を指定された文字列で置換します。 自分自身を置換することはできません。
     * </p>
     *
     * @param id
     * @param string
     * @return if success to replace, return true. if no hit, return false.
     * @throws TagTypeUnmatchException
     */
    public <T extends AbstractJaxb> boolean replaceById(String id,
            String replacement) throws TagTypeUnmatchException {
        return ReplaceByIdUtil.replaceById(id, this, replacement);
    }

    /**
     * <p>
     * scan descendant element that is specified tag type having specified class
     * property and return it as List.
     * </p>
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
     * @param clazz
     * @param tagType
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> List<T> getDescendants(String clazz,
            Class<T> tagType) {
        return GetDescendantsUtil.getDescendants((T) this, new ArrayList<T>(),
                clazz, tagType);
    }

    /**
     * <p>
     * scan descendant elements that has specified tag type and return it as
     * List.
     * </p>
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
     * @param tagType
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> List<T> getDescendants(Class<T> tagType) {
        return GetDescendantsUtil.getDescendants((T) this, new ArrayList<T>(),
                tagType);
    }

    /**
     * <p>
     * scan descendant elements that has specified class property and return it
     * as List
     * </p>
     * <p>
     * 指定したclass属性を持つ子孫要素を探してListで返します
     * </p>
     *
     * @param clazz
     *            class property
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> List<T> getDescendants(String clazz) {
        return GetDescendantsUtil.getDescendants((T) this, new ArrayList<T>(),
                clazz);
    }

    /**
     * <p>
     * delete all descendant elements that is specified tag type having
     * specified class property.
     * </p>
     * <p>
     * 指定したタグ型で、かつ、指定したclass属性を持つ子孫要素をすべて削除します
     * </p>
     *
     * @param clazz
     *            class property
     * @param tagType
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void removeDescendants(String clazz,
            Class<T> tagType) {
        RemoveDescendantsUtil.removeDescendants((T) this, clazz, tagType);
    }

    /**
     * <p>
     * delete all descendant elements that is specified tag type.
     * </p>
     * <p>
     * 指定したタグ型の子孫要素をすべて削除します
     * </p>
     *
     * @param tagType
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void removeDescendants(Class<T> tagType) {
        RemoveDescendantsUtil.removeDescendants((T) this, tagType);
    }

    /**
     * <p>
     * delete all descendant elements having specified classs property
     * </p>
     * <p>
     * 指定したclass属性を持つ子孫要素をすべて削除します
     * </p>
     *
     * @param clazz
     *            class property
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void removeDescendants(String clazz) {
        RemoveDescendantsUtil.removeDescendants((T) this, clazz);
    }

    /**
     * <p>
     * relpace all the descendant elements that is specified tag type having
     * specified class property. this method use deep copy of "replacement"
     * </p>
     * <p>
     * 指定したタグ型で、かつ、指定したclass属性を持つすべての子孫要素を置換します。 なお、replaceのディープコピーで置換されます。
     * </p>
     *
     * @param clazz
     *            class property
     * @param tagType
     * @param replacement
     * @throws TagTypeUnmatchException
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(String clazz,
            Class<T> tagType, T replacement) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, tagType, clazz,
                replacement);
    }

    /**
     * <p>
     * relpace all the descendant elements by String. The target is specified
     * tag type having specified class property.
     * </p>
     * <p>
     * 指定したタグ型で、かつ、指定したclass属性を持つすべての子孫要素を 文字列で置換します。
     * </p>
     *
     * @param clazz
     *            class property
     * @param tagType
     * @param replacement
     * @throws TagTypeUnmatchException
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(String clazz,
            Class<T> tagType, String replacement)
            throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, tagType, clazz,
                replacement);
    }

    /**
     * <p>
     * replace all descendant elements that is specified tag type. This method
     * use deep copy of "replacement"
     * </p>
     * <p>
     * 指定したタグ型の子孫要素を置換します。 なお、"replacement"のディープコピーで置換されます。
     * </p>
     *
     * @param tagType
     * @param replacement
     * @throws TagTypeUnmatchException
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(Class<T> tagType,
            T replacement) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, tagType,
                replacement);
    }

    /**
     * 指定したclass属性を持つ子孫要素を置換します。 なお、replaceのディープコピーで置換されます。
     *
     *
     * @param clazz
     *            class property
     * @param replacement
     * @throws TagTypeUnmatchException
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(String clazz,
            T replacement) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, clazz, replacement);
    }

    /**
     * <p>
     * replace all descendant element that is specified tag type by String
     * </p>
     * <p>
     * 指定したタグ型の子孫要素を文字列で置換します。
     * </p>
     *
     * @param tagType
     * @param replacement
     * @throws TagTypeUnmatchException
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(Class<T> tagType,
            String replacement) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, tagType,
                replacement);
    }

    /**
     * <p>
     * 指定したclass属性を持つ子孫要素を文字列で置換します。
     * </p>
     *
     * @param clazz
     *            class property
     * @param replacement
     * @throws TagTypeUnmatchException
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void replaceDescendants(String clazz,
            String replacement) throws TagTypeUnmatchException {
        ReplaceDescendantsUtil.replaceDescendants((T) this, clazz, replacement);
    }

    /**
     * <p>
     * insert element after the element having specified id property. This
     * method use deep copy of "insObject"
     * </p>
     * 
     * <p>
     * 指定したid属性を持つタグの直後（内部ではない）に挿入します。 なお、挿入されるのはreplaceのディープコピーです。
     * </p>
     *
     * @param id
     *            id property
     * @param insObject
     * @return true if success to insert. if no hit, return false.
     * @throws TagTypeUnmatchException
     */
    public <T extends AbstractJaxb> boolean insertAfterId(String id, T insObject)
            throws TagTypeUnmatchException {
        return InsertByIdUtil.insertAfterId(id, insObject, this);
    }

    /**
     * <p>
     * 指定したid属性を持つタグの直後（内部ではない）に文字列を挿入します。
     * </p>
     *
     * @param id
     * @param insString
     * @return true if success to insert. if no hit, return false.
     * @throws TagTypeUnmatchException
     */
    public boolean insertAfterId(String id, String insString)
            throws TagTypeUnmatchException {
        return InsertByIdUtil.insertAfterId(id, insString, this);
    }

    /**
     * <p>
     * 指定したid属性を持つタグの直前に挿入します。 なお、挿入されるのはreplaceのディープコピーです。
     * </p>
     *
     * @param id
     * @param insObject
     * @return true if success to insert. if no hit, return false.
     * @throws TagTypeUnmatchException
     */
    public <T extends AbstractJaxb> boolean insertBeforeId(String id,
            T insObject) throws TagTypeUnmatchException {
        return InsertByIdUtil.insertBeforeId(id, insObject, this);
    }

    /**
     * <p>
     * 指定したid属性を持つタグの直前に文字列を挿入します。
     * </p>
     *
     * @param id
     * @param insString
     * @return true if success to insert. if no hit, return false.
     * @throws TagTypeUnmatchException
     */
    public boolean insertBeforeId(String id, String insString)
            throws TagTypeUnmatchException {
        return InsertByIdUtil.insertBeforeId(id, insString, this);
    }

    /**
     * <p>
     * write style property by TreeMap
     * </p>
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
     * @param styleMap
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
     * <p>
     * return style property as TreeMap
     * </p>
     * <p>
     * タグのstyle属性をTreeMapで返します
     * </p>
     *
     * @return
     */
    public TreeMap<String, String> getStyleAsTreeMap() {
        TreeMap<String, String> resultMap = new TreeMap<String, String>();
        if (M2StringUtils.isBlank(this.getStyle())) {
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
     * return deep copy of myself
     * </p>
     * <p>
     * <strong>NOTICE: DO NOT USE clone() and copyTo() method !</strong>
     * They has bug. Use this copy() method instead of them.
     * </p>
     * <p>
     * 自分自身のディープコピーを返します。
     * </p>
     * <p>
     * <strong>注意: clone()とcopyTo()メソッドは使わないでください。</strong>
     * html5のaria-*属性やdata-*属性を持つタグをうまくコピーできないというバグがあります。
     * かわりにこのcopy()メソッドを使ってください。
     * </p>
     *
     * <pre>
     * // usage
     * Div div = html.getById(Div.class, &quot;foo&quot;);
     * Div div2 = div.copy(Div.class);
     * </pre>
     *
     * @param tagType
     * @return
     * @throws TagTypeUnmatchException
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> T copy(Class<T> tagType)
            throws TagTypeUnmatchException {
    	T copy = null;
        if (!tagType.equals(this.getClass())) {
            log.warn("to use copy() method, tagType must be same type of the original object.");
            throw new TagTypeUnmatchException(getClass(), tagType);
        }
        try {
			copy = (T) this.clone();
		} catch (CloneNotSupportedException e) {
			log.error("can not create clone(copy) of this object.", e);
		}
        CopyUtil.copyOtherAttr(this, copy);
        return copy;
    }
    
    /**
     * <p>
     * same as {@link #copy(Class)} but never throw exception.
     * return null if failed to copy.
     * </p>
     * <p>
     * {@link #copy(Class)}と同じですが、失敗しても例外を発生させずにnullを返します
     * </p>
     * 
     * @param tagType
     * @return
     */
    public <T extends AbstractJaxb> T copyNoException(Class<T> tagType) {
        T copy = null;
        try {
            copy = (T) this.copy(tagType);
        } catch (final TagTypeUnmatchException e) {
            return null;
        }
        return copy;
    }

    /**
     * <p>
     * set data-* property
     * </p>
     * <p>
     * data-* 属性を設定します
     * </p>
     *
     * <pre>
     * Div div = new Div();
     * div.setData(&quot;foo&quot;, &quot;bar&quot;);
     * // you get &lt;div data-foo=&quot;bar&quot;&gt;&lt;/div&gt;
     * </pre>
     *
     * @param key
     *            data-"key"
     */
    public void setData(String key, String value) {
        QName qn = new QName("data-" + key);
        this.getOtherAttributes().put(qn, value);
    }

    /**
     * <p>
     * return the value of data-* property. If not set, return null.
     * </p>
     * <p>
     * data-* 属性の値を返します。値が設定されていない場合はnullが返されます
     * </p>
     *
     * @param key
     *            data-"key"
     * @return null if not found property
     */
    public String getData(String key) {
        QName qn = new QName("data-" + key);
        return this.getOtherAttributes().get(qn);
    }

    /**
     * <p>
     * set area-* property
     * </p>
     * <p>
     * aria-* 属性を設定します
     * </p>
     *
     * @param key
     *            aria-"key"
     * @param value
     */
    public void setAria(String key, String value) {
        QName qn = new QName("aria-" + key);
        this.getOtherAttributes().put(qn, value);
    }

    /**
     * <p>
     * return the value of area-* property. If not set, return null.
     * </p>
     * <p>
     * aria-* 属性の値を返します。値が設定されていない場合はnullが返されます
     * </p>
     *
     * @param key
     *            aria-"key"
     * @return
     */
    public String getAria(String key) {
        QName qn = new QName("aria-" + key);
        return this.getOtherAttributes().get(qn);
    }

    /**
     * <p>
     * 指定されたdata-* 属性を消去します。
     * </p>
     * <p>
     * remove attribute of data-* property.
     * </p>
     * @param key data-"key"
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    public String removeData(String key) {
        QName qn = new QName("data-" + key);
        return this.getOtherAttributes().remove(qn);
    }

    /**
     * <p>
     * 指定されたaria-* 属性を消去します。
     * </p>
     * <p>
     * remove attribute of aria-* property.
     * </p>
     * @param key data-"key"
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    public String removeAria(String key) {
        QName qn = new QName("aria-" + key);
        return this.getOtherAttributes().remove(qn);
    }

    /**
     * <p>
     * get other attribute map. NOTICE: this method is dummy for make coding
     * easy. Acrually, this method is overridden by each tag class.
     * </p>
     * <p>
     * otherAttributeマップを取得します。 このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。
     * </p>
     *
     * @return
     */
    public Map<QName, String> getOtherAttributes() {
        return null;
    }

    /**
     * <p>
     * get id property. return null if not set. NOTICE: this method is dummy for
     * make coding easy. Acrually, this method is overridden by each tag class.
     * </p>
     * <p>
     * id属性を取得します。設定されていなければnullを返します。 このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。 （xhtmlでは全種類のタグがid属性を持ちます）
     * </p>
     *
     * @return
     */
    public String getId() {
        return null;
    }

    /**
     * <p>
     * set id property. NOTICE: this method is dummy for make coding easy.
     * Acrually, this method is overridden by each tag class.
     * </p>
     * <p>
     * id属性をセットします。属性を削除したい場合にはnullを与えてください。 このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。 （xhtmlでは全種類のタグがid属性を持ちます）
     * </p>
     */
    public void setId(String id) {
    }

    /**
     * <p>
     * NOTICE: this method is dummy for make coding easy. Acrually, this method
     * is overridden by each tag class.
     * </p>
     * <p>
     * id属性がセットされているか（nullではないか）を返します。 このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。 （xhtmlでは全種類のタグがid属性を持ちます）
     * </p>
     */
    public boolean isSetId() {
        return false;
    }

    /**
     * <p>
     * delete id property of all descendant elements. Also, remove id property
     * of myself.
     * </p>
     * <p>
     * 自分の子孫要素すべてのid属性を削除します。 自分自身のid属性も削除します。
     * </p>
     */
    public void unsetAllId() {
        UnsetIdUtil.unsetAllId(this);
    }

    /**
     * <p>
     * 自分の子孫要素のうち、そのid属性が指定の正規表現とマッチする場合に、id属性を削除します。
     * 自分自身のid属性も、patternにマッチする場合は削除します。
     * </p>
     */
    public void unsetAllId(Pattern pattern) {
        UnsetIdUtil.unsetAllId(this, pattern);
    }

    /**
     * <p>
     * NOTICE: this method is dummy for make coding easy. Acrually, this method
     * is overridden by each tag class.
     * </p>
     * <p>
     * タグのstyle属性を返します。このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。
     * （html5では全てのタグがclass属性とstyle属性を持ちます。）
     * </p>
     *
     * @return
     */
    public String getStyle() {
        return null;
    }

    /**
     * <p>
     * NOTICE: this method is dummy for make coding easy. Acrually, this method
     * is overridden by each tag class.
     * </p>
     * <p>
     * タグのstyle属性をセットします。このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。
     * （html5では全てのタグがclass属性とstyle属性を持ちます。）
     * </p>
     *
     * @return
     */
    public void setStyle(String value) {
        return;
    }

    /**
     * <p>
     * return class property as List. NOTICE: this method is dummy for make
     * coding easy. Acrually, this method is overridden by each tag class.
     * </p>
     * </p> タグのclass属性をリストで返します。このメソッドはコーディングしやすくするためのダミーです。
     * 実際は各タグ型の同名メソッドによってオーバーライドされ、そちらが実行されます。
     * （html5では全てのタグがclass属性とstyle属性を持ちます。） </p>
     *
     * @return
     */
    public List<String> getCssClass() {
        return null;
    }

    /**
     * <p>
     * return true if having specified class property.
     * </p>
     * <p>
     * 指定した文字列がclass属性に含まれているかどうかを判定します
     * </p>
     *
     * @param clazz
     *            class property
     * @return
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
     * <p>
     * add class property. If already set, do nothing.
     * </p>
     * <p>
     * 指定した文字列をclass属性に追加します。既にある場合には何もしません。
     * </p>
     */
    public <T extends AbstractJaxb> void addCssClass(String clazz) {
        List<String> classList = this.getCssClass();
        if (!this.hasCssClass(clazz)) {
            classList.add(clazz);
        }
    }

    /**
     * <p>
     * remove specified class property if having it.
     * </p>
     * <p>
     * 指定した文字列がclass属性に含まれていればそれをすべて削除します
     * </p>
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
     * remove class property if it has no value.
     * </p>
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
     * <p>
     * returns byte sequence of myself.
     * </p>
     * <p>
     * 自分自身のバイト列表現を返します。
     * </p>
     *
     * @return
     * @throws IOException
     */
    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(this);
        return byteOut.toByteArray();
    }

    /**
     * <p>
     * FOR DEBUG. This method does not include the field of a null object in the
     * returned string.
     * </p>
     * <p>
     * デバッグ用です。このメソッドは文字列表現に null オブジェクトを持つフィールドを加えません。
     * </p>
     */
    public String toString() {
        return M2StringUtils.stringifier(this);
    }

}

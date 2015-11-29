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
import org.mixer2.jaxb.xhtml.Footer;
import org.mixer2.jaxb.xhtml.Header;
import org.mixer2.jaxb.xhtml.Input;
import org.mixer2.util.CastUtil;
import org.mixer2.util.M2StringUtils;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;
import org.mixer2.xhtml.util.*;

/**
 * <p>
 * base class of all tag type
 * </p>
 *
 * @author nabedge
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
     * get tag that has specified id attribute. You don't need to cast() because
     * you can specify the tag type.
     * </p>
     *
     * <pre>
     * // sample: get a Div tag having id=&quot;foo&quot; attribute.
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
     * get tag that has specified id attribute. To use return value as ussual
     * tag, you must cast() it.
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
     * delete element that has specified attribute within descendant element
     * of oneself. you can't delete oneself.
     * </p>
     *
     * @param target
     * @return if success to delete, return true. if no hit, return false.
     */
    public <T extends AbstractJaxb> boolean remove(T target) {
        String id = target.getId();
        if (id == null) {
            for (int i = 0; i < 256; i++) {
                id = UUID.randomUUID().toString();
                if (this.getById(id) == null) {
                    target.setId(id);
                    break;
                }
            }
        }
        return RemoveByIdUtil.removeById(id, this);
    }

    /**
     * <p>remove inner content of this tag. </p>
     */
    public void removeInner() {
    	RemoveInnerUtil.removeInner(this);
    }

    /**
     * <p>
     * delete element that has specified id attribute within descendant element
     * of oneself. you can't delete oneself.
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
     * replace element that has specified attribute within descendant element of
     * oneself. you can't replace oneself. It will be replaced by deep copy of
     * "replacement"
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
     * replace element that has specified id attribute within descendant element
     * of oneself. you can't replace oneself. It will be replaced by deep copy
     * of "replacement"
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
     * 
     * @param id
     * @param replacement
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
     * attribute and return it as List.
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
     * scan descendant elements that has specified class attribute and return it
     * as List
     * </p>
     *
     * @param clazz
     *            class attribute
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
     * specified class attribute.
     * </p>
     *
     * @param clazz
     *            class attribute
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
     *
     * @param tagType
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void removeDescendants(Class<T> tagType) {
        RemoveDescendantsUtil.removeDescendants((T) this, tagType);
    }

    /**
     * <p>
     * delete all descendant elements having specified class attribute
     * </p>
     *
     * @param clazz
     *            class attribute
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> void removeDescendants(String clazz) {
        RemoveDescendantsUtil.removeDescendants((T) this, clazz);
    }

    /**
     * <p>
     * replace all the descendant elements that is specified tag type having
     * specified class attribute. this method use deep copy of "replacement"
     * </p>
     *
     * @param clazz
     *            class attribute
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
     * replace all the descendant elements by String. The target is specified
     * tag type having specified class attribute.
     * </p>
     *
     * @param clazz
     *            class attribute
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
     * replace all descendant elements that has specified class attribute.
     * This method user deep copy of "replacement"
     * 
     * @param clazz class attribute
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
     *     replace descendant tag with string. specifying class property.
     * </p>
     *
     * @param clazz
     *            class attribute
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
     * Replace whole of inside the tag by replacement.<br>
     * For various reasons, this method does NOT use deep copy of replacement.<br>
     * It is recommended to use copy(T) in method argument.
     * </p>
     *
     * <b>recommended pattern.</b>
     * <pre>
     * // div and p is instance of Div, p tag object.
     * Div div = TagCreator.div();
     * P p = TagCreator.p();
     * p.getContent().add("foo");
     * div.replaceInner(p.copy(P.class)); // *** using copy()
     * p.getContent().add("bar");
     * System.out.println(mixer2Engine.saveToString(div));
     * // you get &lt;div&gt;&lt;p&gt;foo&lt;/p&gt;&lt;/div&gt;
     * </pre>
     * 
     * <b>anti pattern. use with caution.</b>
     * <pre>
     * // divA and divB is instance of Div tag object.
     * Div div = TagCreator.div();
     * P p = TagCreator.p();
     * p.getContent().add("foo");
     * div.replaceInner(p); // *** without copy()
     * p.getContent().add("bar");
     * System.out.println(mixer2Engine.saveToString(div));
     * // you get &lt;div&gt;&lt;p&gt;foo bar&lt;/p&gt;&lt;/div&gt;
     * </pre>
     * 
     * @param replacement
     */
    public <T extends AbstractJaxb> void replaceInner(T replacement) {
    	ReplaceInnerUtil.replaceInner(this, replacement);
    }

    /**
     * <p>
     * Replace whole of inside the tag by replacement.<br>
     * If this tag can not have String directory (ex. &lt;table&gt; tag), do nothing.
     * </p>
     * 
     * @param replacement
     */
    public void replaceInner(String replacement) {
    	ReplaceInnerUtil.replaceInner(this, replacement);
    }
    
    /**
     * <p>
     * Replace whole of inside the tag by the whole elements of the list.<br>
     * If the element can not be use in this tag, There is a case that will be exclude.
     * </p>
     * 
     * @param replacement
     */
    public void replaceInner(List<? extends java.lang.Object> replacement) {
    	ReplaceInnerUtil.replaceInner(this, replacement);
    }

    /**
     * <p>
     * insert element after the element having specified id attribute. This
     * method use deep copy of "insObject"
     * </p>
     *
     * @param id
     *            id attribute
     * @param insObject
     * @return true if success to insert. if no hit, return false.
     * @throws TagTypeUnmatchException
     */
    public <T extends AbstractJaxb> boolean insertAfterId(String id, T insObject)
            throws TagTypeUnmatchException {
        return InsertByIdUtil.insertAfterId(id, insObject, this);
    }

    /**
     * <p>insert String after the element having specified id attribute</p>
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
     * <p>insert element before the element having specified id attribute.
     * This method use deep copy of insObject
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
     * <p>insert string before the element having specified id attribute.</p>
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
     * write style attribute by TreeMap
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
     * return style attributes as TreeMap
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
     * set data-* attribute
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
     * return the value of data-* attribute. If not set, return null.
     * </p>
     *
     * @param key
     *            data-"key"
     * @return null if not found attribute
     */
    public String getData(String key) {
        QName qn = new QName("data-" + key);
        return this.getOtherAttributes().get(qn);
    }

    /**
     * <p>
     * set area-* attribute
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
     * return the value of area-* attribute. If not set, return null.
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
     * <p>remove a specified data-* attribute.</p>
     * 
     * @param key data-"key"
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    public String removeData(String key) {
        QName qn = new QName("data-" + key);
        return this.getOtherAttributes().remove(qn);
    }

    /**
     * <p>remove a specified aria-* attribute.</p>
     * 
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
     *
     * @return
     */
    public Map<QName, String> getOtherAttributes() {
        return null;
    }

    /**
     * <p>
     * get id attribute. return null if not set. NOTICE: this method is dummy for
     * make coding easy. Acrually, this method is overridden by each tag class.
     * </p>
     *
     * @return
     */
    public String getId() {
        return null;
    }

    /**
     * <p>
     * set id attribute. NOTICE: this method is dummy for make coding easy.
     * Acrually, this method is overridden by each tag class.
     * </p>
     */
    public void setId(String id) {
    }

    /**
     * <p>
     * NOTICE: this method is dummy for make coding easy. Acrually, this method
     * is overridden by each tag class.
     * </p>
     */
    public boolean isSetId() {
        return false;
    }

    /**
     * <p>
     * remove id attribute of all descendant elements. Also, remove id attribute
     * of myself.
     * </p>
     */
    public void unsetAllId() {
        UnsetIdUtil.unsetAllId(this);
    }

    /**
     * <p>remove id attribute that matches specified regex. Also, matches and remove of myself.</p>
     */
    public void unsetAllId(Pattern pattern) {
        UnsetIdUtil.unsetAllId(this, pattern);
    }

    /**
     * <p>
     * NOTICE: this method is dummy for make coding easy. Acrually, this method
     * is overridden by each tag class.
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
     *
     * @param value
     */
    public void setStyle(String value) {
        return;
    }

    /**
     * <p>
     * return class attribute as List. NOTICE: this method is dummy for make
     * coding easy. Acrually, this method is overridden by each tag class.
     * </p>
     *
     * @return
     */
    public List<String> getCssClass() {
        return null;
    }

    /**
     * <p>
     * return true if have specified class attribute.
     * </p>
     *
     * @param clazz
     *            class attribute
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
     * add class attribute. If already set, do nothing.
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
     * remove specified class attribute if having it.
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
     * Remove class attribute if it has no value.
     * This method prevent no-meaning class attribute like below.
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
     * <p>find tag by "name" property returning as List.</p>
     * @param name
     * @param tagType
     * @param <T>
     * @return if not found, returns empty list.
     */
    public <T extends AbstractJaxb> List<T> getByNameAsList(String name, Class<T> tagType) {
        return GetByNameUtil.getByNameAsList((T) this, new ArrayList<T>(), name,tagType);
    }

    /**
     * <p>find tag by "name" property. (the first one in this tag)</p>
     *
     * @param name
     * @param tagType
     * @param <T>
     * @return null if not found.
     */
    public <T extends AbstractJaxb> T getByName(String name, Class<T> tagType) {
        return GetByNameUtil.getByName((T) this, name, tagType);
    }

    /**
     * <p>get header tag</p>
     * @return
     */
    public List<Header> getHeaderAsList() {
        return this.getDescendants(Header.class);
    }

    /**
     * <p>get header tag (the first one in this tag)</p>
     * @return null if not found.
     */
    public Header getHeader() {
        List<Header> list = this.getDescendants(Header.class);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * <p>get footer tag</p>
     * @return
     */
    public List<Footer> getFooterAsList() {
        return this.getDescendants(Footer.class);
    }

    /**
     * <p>get footer tag (the first one in this tag)</p>
     * @return null if not found.
     */
    public Footer getFooter() {
        List<Footer> list = this.getDescendants(Footer.class);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * <p>
     * returns byte sequence of myself.
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
     */
    public String toString() {
        return M2StringUtils.stringifier(this);
    }

}

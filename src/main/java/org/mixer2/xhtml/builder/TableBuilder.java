package org.mixer2.xhtml.builder;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.Table;
import org.mixer2.jaxb.xhtml.Tbody;
import org.mixer2.jaxb.xhtml.Td;
import org.mixer2.jaxb.xhtml.Tfoot;
import org.mixer2.jaxb.xhtml.Thead;
import org.mixer2.jaxb.xhtml.Tr;
import org.mixer2.xhtml.AbstractJaxb;
import org.mixer2.xhtml.exception.TagTypeUnmatchException;

/**
 * Builder for table,td,tr,tbody,thead,tfoot. This class is not thread safe.<br>
 *
 * @author nabedge
 *
 */
public class TableBuilder {

    private static Log log = LogFactory.getLog(TableBuilder.class);

    /**  */
    public class tbody {

        private List<tr> trList = new ArrayList<tr>();

        // attribute information for tbody
        private Map<String, Object> attrMap = new HashMap<String, Object>();

        /**
         * set property to tbody tag
         *
         * @param key
         *            attribute name. id,title,class,style...
         * @param value
         *            value. you can use List&lt;String&gt;
         */
        public void setAttr(String key, Object value) {
            this.attrMap.put(key, value);
        }

        /**
         * set property of tbody tag by map. <br>
         * The key of map is attribute name (id,title,class,etc...)<br>
         * In case of "class" attribute, you can use String or List&lt;STring&gt;<br>
         * 
         * @param attrMap
         */
        public void setAttr(Map<String, Object> attrMap) {
            this.attrMap = attrMap;
        }

        /**
         * tr tag of specified index on tbody.
         * if there no tr at the specified index, tr will be created automatically.
         *
         * @param index
         *            0 = first tr, 1 = second tr.
         * @return
         */
        public tr tr(int index) {
            while (trList.size() <= index) {
                trList.add(new tr());
            }
            return trList.get(index);
        }

        /**
         * add new tr on list of tr in tbody and return the new tr.
         */
        public tr addTr() {
            tr tr = new tr();
            trList.add(tr);
            return tr;
        }

        /**
         * Add new tr on list of tr in tbody and return the new tr. 
         * The new tr has specified attributes.
         *
         */
        public tr addTr(Map<String, Object> attrMap) {
            tr tr = new tr();
            tr.setAttr(attrMap);
            trList.add(tr);
            return tr;
        }

        /**
         * Add new tr tag to the last of tbody.
         * The tr tag has tds having the value of list.
         * 
         * @param tdList the value of list must be tag or String that can be included in td tag.
         * @return
         * @throws TagTypeUnmatchException
         */
        public tbody addTr(List<Object> tdList) throws TagTypeUnmatchException {
            addTr(tdList, null);
            return this;
        }

        /**
         * Add new tr tag to the last of tbody.
         * The tr tag has td tags having the each value of list.
         * The specified attribute will be set to tr tag.
         *
         * @param <T>
         * @param tdList the value of list must be tag or String that can be included in td tag.
         * @param attrMap
         * @return
         * @throws TagTypeUnmatchException
         * 
         */
        @SuppressWarnings("unchecked")
        public <T extends AbstractJaxb> tbody addTr(List<Object> tdList,
                Map<String, Object> attrMap) throws TagTypeUnmatchException {
            tr tr = new tr();
            tr.setAttr(attrMap);
            for (Object obj : tdList) {
                if (obj instanceof String) {
                    tr.addTd((String) obj);
                } else if (obj instanceof AbstractJaxb) {
                    tr.addTd((T) obj);
                } else {
                    throw new TagTypeUnmatchException(
                            "String or other tag object expected but tdList contains "
                                    + obj.getClass().getName());
                }
            }
            trList.add(tr);
            return this;
        }

        public Tbody buildTbody() {
            Tbody tbody = new Tbody();
            setAttribute(tbody, attrMap);
            if (trList.size() < 1) {
                return tbody;
            }
            for (tr _tr : trList) {
                tbody.getTr().add(_tr.buildTr());
            }

            return tbody;
        }

    }

    /**
     * Inner class of tr tag. This is different from org.mixer2.jaxb.xhtml.Tr .
     */
    public class tr {

        /**
         * Inner class of td tag. This is different from org.mixer2.jaxb.xhtml.Td .
         */
        public class td {

            // attribute for td tag
            private Map<String, Object> attrMap = new HashMap<String, Object>();

            // content of td
            private List<Object> content = new ArrayList<Object>();

            /**
             * get content in td tag.
             */
            public List<Object> getContent() {
                return content;
            }

            /**
             * add content into td tag
             * @param string
             */
            public void add(String string) {
                content.add(string);
            }

            /**
             * add content into tod tag
             */
            public <T extends AbstractJaxb> void add(T tag) {
                content.add(tag);
            }

            /**
             * create Td tag
             * @return
             */
            public Td buildTd() {
                Td td = new Td();
                setAttribute(td, attrMap);
                for (Object obj : getContent()) {
                    td.getContent().add(obj);
                }
                return td;
            }

            /**
             * set attribute of td tag. key is attribute name, value is attribute value.
             * @param attrMap
             */
            public void setAttr(Map<String, Object> attrMap) {
                this.attrMap = attrMap;
            }

            /**
             * set attribute of td tag
             * @param key
             * @param value
             */
            public void setAttr(String key, Object value) {
                attrMap.put(key, value);
            }

        }

        // attribute information for tr tag
        private Map<String, Object> attrMap = new HashMap<String, Object>();

        /**
         * set attributes for tr tag
         * @param attrMap
         */
        public void setAttr(Map<String, Object> attrMap) {
            this.attrMap = attrMap;
        }

        /**
         * set attribute for tr tag
         * @param key
         * @param value
         */
        public void setAttr(String key, Object value) {
            attrMap.put(key, value);
        }

        private List<td> tdList = new ArrayList<td>();

        /**
         * Get specified td. If there are no td at the specified index, td will be created on the index.
         * 
         * @param index 0=first td, 1=second td
         * @return
         */
        public td td(int index) {
            while (tdList.size() <= index) {
                tdList.add(new td());
            }
            return tdList.get(index);
        }

        /**
         * add new td having specified string into the last of td list of tr.
         * @param string
         * @return
         */
        public tr addTd(String string) {
            addTd(string, null);
            return this;
        }

        /**
         * add new td having specified tag into the last of td list of tr.
         *
         * @param tag
         * @return
         */
        public <T extends AbstractJaxb> tr addTd(T tag) {
            addTd(tag, null);
            return this;
        }

        /**
         * add new td having specified string and specified sttributes into the last of td list of tr.
         * 
         * @param string
         * @param attrMap
         * @return
         */
        public tr addTd(String string, Map<String, Object> attrMap) {
            td td = new td();
            td.getContent().add(string);
            if (attrMap != null) {
                td.setAttr(attrMap);
            }
            tdList.add(td);
            return this;
        }

        /**
         * add new td having specified tag and specified sttributes into the last of td list of tr.
         *
         * @param tag
         * @param attrMap
         * @return
         */
        public <T extends AbstractJaxb> tr addTd(T tag,
                Map<String, Object> attrMap) {
            td td = new td();
            td.getContent().add(tag);
            if (attrMap != null) {
                td.setAttr(attrMap);
            }
            tdList.add(td);
            return this;
        }

        public Tr buildTr() {
            Tr tr = new Tr();
            setAttribute(tr, attrMap);
            for (td _td : tdList) {
                tr.getThOrTd().add(_td.buildTd());
            }
            return tr;
        }

    }

    private List<tr> trList = new ArrayList<tr>();

    /**
     * Get tr of specified index. If there no tr at the specified index, new tr will be created.
     *
     * @param index 0=first tr, 1= second tr
     * @return
     */
    public tr tr(int index) {
        while (trList.size() <= index) {
            trList.add(new tr());
        }
        return trList.get(index);
    }

    /**
     * add new tr.
     * @return
     */
    public tr addTr() {
        tr tr = new tr();
        trList.add(tr);
        return tr;
    }

    /**
     * add new tr having specified attributes.
     */
    public tr addTr(Map<String, Object> attrMap) {
        tr tr = new tr();
        tr.setAttr(attrMap);
        trList.add(tr);
        return tr;
    }

    /**
     * add new tr having td tags that has content of each value of list.
     * 
     * @param tdList
     * @return
     * @throws TagTypeUnmatchException
     */
    public <T extends AbstractJaxb> TableBuilder addTr(List<Object> tdList)
            throws TagTypeUnmatchException {
        return addTr(tdList, null);
    }

    /**
     * add new tr having td tags that has content of each value of list. 
     * The new tr tag have specifed attributes.
     *
     * @param tdList
     * @param attrMap attributes for new tr tag
     * @return
     * @throws TagTypeUnmatchException
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractJaxb> TableBuilder addTr(List<Object> tdList,
            Map<String, Object> attrMap) throws TagTypeUnmatchException {
        tr tr = new tr();
        tr.setAttr(attrMap);
        for (Object obj : tdList) {
            if (obj instanceof String) {
                tr.addTd((String) obj);
            } else if (obj instanceof AbstractJaxb) {
                tr.addTd((T) obj);
            } else {
                throw new TagTypeUnmatchException(
                        "String or other tag object expected but tdList contains "
                                + obj.getClass().getName());
            }
        }
        trList.add(tr);
        return this;
    }

    private List<tbody> tbodyList = new ArrayList<tbody>();

    /**
     * Get tbody at specified index
     * @param index 0=first tbody, 1=second tbody.
     *            添え字です。0なら一つ目のtbody、1なら二つ目のtbody
     * @return
     */
    public tbody tbody(int index) {
        while (tbodyList.size() <= index) {
            tbodyList.add(new tbody());
        }
        return tbodyList.get(index);
    }

    /**
     * add new tbody and get it.
     * @return
     */
    public tbody addTbody() {
        tbody tbody = new tbody();
        tbodyList.add(tbody);
        return tbody;
    }

    /**
     * add new tbody into table having tr,td tags 
     * 
     * @param trList List of List for tr,td tags
     * @return
     * @throws TagTypeUnmatchException
     */
    public TableBuilder addTbody(List<List<Object>> trList)
            throws TagTypeUnmatchException {
        addTbody(trList, null);
        return this;
    }

    public TableBuilder addTbody(List<List<Object>> trList,
            Map<String, Object> attrMap) throws TagTypeUnmatchException {
        tbody tbody = new tbody();
        tbody.setAttr(attrMap);
        for (List<Object> list : trList) {
            tbody.addTr(list, attrMap);
        }
        tbodyList.add(tbody);
        return this;
    }

    public thead thead = new thead();

    /**
     * inner class for thead. It is different from org.mixer2.jaxb.xhtml.Thead
     */
    public class thead {

        // attributes
        private Map<String, Object> attrMap = new HashMap<String, Object>();

        public void setAttr(Map<String, Object> attrMap) {
            this.attrMap = attrMap;
        }

        public void setAttr(String key, Object value) {
            attrMap.put(key, value);
        }

        private List<tr> trList = new ArrayList<tr>();

        public tr tr(int index) {
            while (trList.size() <= index) {
                trList.add(new tr());
            }
            return trList.get(index);
        }

        public <T extends AbstractJaxb> thead addTr(List<Object> tdList)
                throws TagTypeUnmatchException {
            addTr(tdList, null);
            return this;
        }

        @SuppressWarnings("unchecked")
        public <T extends AbstractJaxb> thead addTr(List<Object> tdList,
                Map<String, Object> attrMap) throws TagTypeUnmatchException {
            tr tr = new tr();
            tr.setAttr(attrMap);
            for (Object obj : tdList) {
                if (obj instanceof String) {
                    tr.addTd((String) obj);
                } else if (obj instanceof AbstractJaxb) {
                    tr.addTd((T) obj);
                } else {
                    throw new TagTypeUnmatchException(
                            "String or other tag object expected but tdList contains "
                                    + obj.getClass().getName());
                }
            }
            trList.add(tr);
            return this;
        }

        /**
         * add new tr into thead and get it
         */
        public tr addTr() {
            tr tr = new tr();
            trList.add(tr);
            return tr;
        }

        /**
         * add new tr having attributes into thead and get it
         */
        public tr addTr(Map<String, Object> attrMap) {
            tr tr = new tr();
            tr.setAttr(attrMap);
            return tr;
        }

        public Thead buildThead() {
            Thead thead = new Thead();
            if (trList.size() < 1) {
                return null;
            }
            setAttribute(thead, attrMap);
            for (tr _tr : trList) {
                thead.getTr().add(_tr.buildTr());
            }
            return thead;
        }

    }

    public tfoot tfoot = new tfoot();

    public class tfoot {

        private Map<String, Object> attrMap = new HashMap<String, Object>();

        public void setAttr(Map<String, Object> attrMap) {
            this.attrMap = attrMap;
        }

        public void setAttr(String key, Object value) {
            attrMap.put(key, value);
        }

        private List<tr> trList = new ArrayList<tr>();

        public tr tr(int index) {
            while (trList.size() <= index) {
                trList.add(new tr());
            }
            return trList.get(index);
        }

        public <T extends AbstractJaxb> tfoot addTr(List<Object> tdList)
                throws TagTypeUnmatchException {
            return addTr(tdList, null);
        }

        @SuppressWarnings("unchecked")
        public <T extends AbstractJaxb> tfoot addTr(List<Object> tdList,
                Map<String, Object> attrMap) throws TagTypeUnmatchException {
            tr tr = new tr();
            tr.setAttr(attrMap);
            for (Object obj : tdList) {
                if (obj instanceof String) {
                    tr.addTd((String) obj);
                } else if (obj instanceof AbstractJaxb) {
                    tr.addTd((T) obj);
                } else {
                    throw new TagTypeUnmatchException(
                            "String or other tag object expected but tdList contains "
                                    + obj.getClass().getName());
                }
            }
            trList.add(tr);
            return this;
        }

        public tr addTr() {
            tr tr = new tr();
            trList.add(tr);
            return tr;
        }

        public tr addTr(Map<String, Object> attrMap) {
            tr tr = new tr();
            tr.setAttr(attrMap);
            return tr;
        }

        public Tfoot buildTfoot() {
            Tfoot tfoot = new Tfoot();
            if (trList.size() < 1) {
                return null;
            }
            setAttribute(tfoot, attrMap);
            for (tr _tr : trList) {
                tfoot.getTr().add(_tr.buildTr());
            }
            return tfoot;
        }

    }

    /**
     * build table tag object finally.
     * 
     * @return
     */
    public Table build() {
        Table table = new Table();
        Thead _thead = thead.buildThead();
        if (_thead != null) {
            table.setThead(_thead);
        }
        Tfoot _tfoot = tfoot.buildTfoot();
        if (_tfoot != null) {
            table.setTfoot(_tfoot);
        }
        for (tbody _tbody : tbodyList) {
            table.getTbody().add(_tbody.buildTbody());
        }
        for (tr _tr : trList) {
            table.getTr().add(_tr.buildTr());
        }
        return table;
    }

    private void setAttribute(Tr tr, Map<String, Object> map) {
        _setAtribute(tr, map);
    }

    private void setAttribute(Td td, Map<String, Object> map) {
        _setAtribute(td, map);
    }

    private void setAttribute(Tbody tbody, Map<String, Object> map) {
        _setAtribute(tbody, map);
    }

    private void setAttribute(Thead thead, Map<String, Object> map) {
        _setAtribute(thead, map);
    }

    private void setAttribute(Tfoot tfoot, Map<String, Object> map) {
        _setAtribute(tfoot, map);
    }

    @SuppressWarnings("unchecked")
    private <T extends AbstractJaxb> void _setAtribute(T obj,
            Map<String, Object> map) {

        if (map == null) {
            return;
        }

        for (String key : map.keySet()) {
            if ("class".equalsIgnoreCase(key)
                    || "cssClass".equalsIgnoreCase(key)) {
                Object val = map.get(key);
                if (val instanceof List) {
                    obj.getCssClass().addAll((List<String>) val);
                } else if (val instanceof String) {
                    String[] tmp = ((String) val).split("\\s+", 0);
                    obj.getCssClass().addAll(java.util.Arrays.asList(tmp));
                } else {
                    log.warn("illegal class property specified on TableBuilder#_setAttribute");
                }
                continue;
            }
            if (obj instanceof Td && "rowspan".equals(key)) {
                obj.cast(Td.class).setRowspan((Integer)map.get(key));
                continue;
            }
            if (obj instanceof Td && "colspan".equals(key)) {
                obj.cast(Td.class).setColspan((Integer) map.get(key));
                continue;
            }
            try {
                BeanUtils.setProperty(obj, key, map.get(key));
            } catch (IllegalAccessException e) {
                log.error("IllegalAccessException occured", e);
            } catch (InvocationTargetException e) {
                log.error("InvocationTargetException occured", e);
            }
        }
    }

}

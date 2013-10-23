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
 * table,tr,td,tbody,thead,tfoot等のタグを作ります。
 * org.mixer2.jaxb.xhtml.*の配下のタグ型を直接使うよりも、より直感的にテーブルを組み立てることができます。
 *
 * なお、このクラスはスレッドセーフではありません。 This class is not thread safe.
 *
 * @author watanabe
 *
 */
public class TableBuilder {

    private static Log log = LogFactory.getLog(TableBuilder.class);

    /**
     * テーブルのtbodyを表す内部クラスです。 mixer2のTbody型(org.mixer2.jaxb.xhtml.Tbody)とは異なります。
     *
     */
    public class tbody {

        private List<tr> trList = new ArrayList<tr>();

        // tbodyタグに与える属性情報
        private Map<String, Object> attrMap = new HashMap<String, Object>();

        /**
         * tbodyタグに与える属性をセットします
         *
         * @param key
         *            属性名です。例: id,title,class,style...
         * @param value
         *            値です。class属性の場合はList&lt;String&gt;で渡すことも可能です。
         */
        public void setAttr(String key, Object value) {
            this.attrMap.put(key, value);
        }

        /**
         * tbodyタグに与える属性をMapでまとめてセットします。 Mapのキーが属性名（id,title,class,etc...）です。
         * class属性の場合は値の型はStringまたはList&lt;STring&gt;のどちらでも可能です。
         *
         * @param attrMap
         */
        public void setAttr(Map<String, Object> attrMap) {
            this.attrMap = attrMap;
        }

        /**
         * tbodyタグに含まれる、指定された位置のtrの情報を返します。 その位置にまだtrが無い場合には自動的に生成されます。
         *
         * @param index
         *            添え字です。0なら最初のtr、1なら2つめのtr
         * @return
         */
        public tr tr(int index) {
            while (trList.size() <= index) {
                trList.add(new tr());
            }
            return trList.get(index);
        }

        /**
         * tbody内のtrのリストの最後尾に新たなtrを追加し、それを返します。
         */
        public tr addTr() {
            tr tr = new tr();
            trList.add(tr);
            return tr;
        }

        /**
         * trのリストの最後尾に新たなtrを追加し、それを返します。また、指定された属性をtrタグにセットします。
         *
         */
        public tr addTr(Map<String, Object> attrMap) {
            tr tr = new tr();
            tr.setAttr(attrMap);
            return tr;
        }

        /**
         * 指定されたListの内容のそれぞれをtdとして持つtrを tbody内の最後尾に追加します。
         *
         * @param tdList
         * @return
         * @throws TagTypeUnmatchException
         *             tdList内にStringでもmixer2のタグ型でもないものが含まれている場合にスローされます。
         */
        public tbody addTr(List<Object> tdList) throws TagTypeUnmatchException {
            addTr(tdList, null);
            return this;
        }

        /**
         * 指定されたListの内容のそれぞれをtdとして持つtrを tbody内の最後尾に追加します。
         * また、指定された属性をtrタグにセットします。
         *
         * @param <T>
         * @param tdList
         * @param attrMap
         * @return
         * @throws TagTypeUnmatchException
         *             tdList内にStringでもmixer2のタグ型でもないものが含まれている場合にスローされます。
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

        /**
         * 内部に蓄積されているtr,tdの情報をもとに、 org.mixer2.jaxb.xhtml.Table,Tr,Td型を使って
         * 最終的なtbodyタグオブジェクトを生成します。
         *
         * @return
         */
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
     * テーブルの行(tr)を表す内部クラスです。 mixer2のTr型(org.mixer2.jaxb.xhtml.Tr)とは異なります。
     *
     */
    public class tr {

        /**
         * テーブルの列(td)を表す内部クラスです。 mixer2のTd型(org.mixer2.jaxb.xhtml.Td)とは異なります。
         *
         */
        public class td {

            // tdタグに与える属性情報
            private Map<String, Object> attrMap = new HashMap<String, Object>();

            // td内のコンテンツ情報
            private List<Object> content = new ArrayList<Object>();

            /**
             * tdタグ内部のコンテンツをListで返します。
             *
             */
            public List<Object> getContent() {
                return content;
            }

            /**
             * tdタグ内部に文字列でコンテンツを追加します。
             *
             */
            public void add(String string) {
                content.add(string);
            }

            /**
             * tdタグ内部にhtmlタグ（div,span,...etc）でコンテンツを追加します。
             *
             */
            public <T extends AbstractJaxb> void add(T tag) {
                content.add(tag);
            }

            /**
             * td内に蓄積された情報をもとにTdタグを生成します。
             *
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
             * Mapにまとめた属性情報をtd情報にセットする
             *
             * @param attrMap
             */
            public void setAttr(Map<String, Object> attrMap) {
                this.attrMap = attrMap;
            }

            /**
             * 指定の属性情報をtd情報にセットする
             *
             * @param key
             * @param value
             */
            public void setAttr(String key, Object value) {
                attrMap.put(key, value);
            }

        }

        // trタグに与える属性情報
        private Map<String, Object> attrMap = new HashMap<String, Object>();

        /**
         * trタグに与える属性をセットします
         *
         * @param attrMap
         */
        public void setAttr(Map<String, Object> attrMap) {
            this.attrMap = attrMap;
        }

        /**
         * trタグに与える属性をセットします
         *
         * @param key
         * @param value
         */
        public void setAttr(String key, Object value) {
            attrMap.put(key, value);
        }

        private List<td> tdList = new ArrayList<td>();

        /**
         * 指定された位置のtdを返します。 その位置にまだtdが無い場合には自動的に生成されます。
         *
         * @param index
         *            添え字です。0なら1列目のtd、1なら2列目のtd
         * @return
         */
        public td td(int index) {
            while (tdList.size() <= index) {
                tdList.add(new td());
            }
            return tdList.get(index);
        }

        /**
         * tr内部のtdのリストの最後尾に、指定された文字列をコンテンツとして含む新たなtdを追加します。
         *
         * @param string
         * @return
         */
        public tr addTd(String string) {
            addTd(string, null);
            return this;
        }

        /**
         * tr内部のtdのリストの最後尾に、 指定されたタグオブジェクトをコンテンツとして含む新たなtdを追加します。
         *
         * @param string
         * @return
         */
        public <T extends AbstractJaxb> tr addTd(T tag) {
            addTd(tag, null);
            return this;
        }

        /**
         * 指定された文字列をコンテンツとして含み、 かつ、指定された属性を持つ新たなtdを、 tr内部のtdのリストの最後尾に追加します。
         *
         * @param string
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
         * 指定されたタグオブジェクトをコンテンツとして含み、 かつ、指定された属性を持つ新たなtdを、 tr内部のtdのリストの最後尾に追加します。
         *
         * @param string
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

        /**
         * 蓄積されたtdの情報をもとに、 org.mixer2.jaxb.xhtml.Trタグ型オブジェクトを生成します。
         *
         * @return
         */
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
     * 指定された位置のtrを返します。 その位置にまだtrが無い場合には自動的に生成されます。
     *
     * @param index
     *            添え字です。0なら1行目のtr、1なら2行目のtr
     * @return
     */
    public tr tr(int index) {
        while (trList.size() <= index) {
            trList.add(new tr());
        }
        return trList.get(index);
    }

    /**
     * trのリストの最後尾に新たなtrを追加し、それを返します。
     *
     */
    public tr addTr() {
        tr tr = new tr();
        trList.add(tr);
        return tr;
    }

    /**
     * trのリストの最後尾に新たなtrを追加し、それを返します。また、指定された属性をtrタグにセットします。
     *
     */
    public tr addTr(Map<String, Object> attrMap) {
        tr tr = new tr();
        tr.setAttr(attrMap);
        return tr;
    }

    /**
     * 指定されたListの内容のそれぞれをtdとして持つtrをtrのリストの最後尾に追加します。
     *
     * @param <T>
     * @param tdList
     *            それぞれのtdに入れたいコンテンツのListです
     * @return
     * @throws TagTypeUnmatchException
     * @throws TagTypeUnmatchException
     *             String型またはAbstractJaxbを継承している型以外の<br />
     *             オブジェクトtdListに含まれている場合にスローします。
     */
    public <T extends AbstractJaxb> TableBuilder addTr(List<Object> tdList)
            throws TagTypeUnmatchException {
        return addTr(tdList, null);
    }

    /**
     * 指定されたListの内容のそれぞれをtdとして持つtrを tableの最後尾に追加します。 また、指定された属性をtrタグにセットします。
     *
     * @param <T>
     * @param tdList
     * @param coreAttr
     *            属性map
     * @return
     * @throws TagTypeUnmatchException
     *             Stringまたはtdに入れることができるタグ型以外のオブジェクトがtdListに含まれている場合にスローします
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
     * 指定された位置のtbodyを返します。
     *
     * @param index
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
     * tbodyのリストの最後尾に新たなtbodyを作成し、それを返します
     *
     * @return
     */
    public tbody addTbody() {
        tbody tbody = new tbody();
        tbodyList.add(tbody);
        return tbody;
    }

    /**
     * 2次元のListの情報をもとに、tr,tdを含む新たなtbodyをテーブルに追加します。
     *
     * @param trList
     *            ListのList。最終的にはこれをもとにtr,tdタグが形成されます。
     * @return
     * @throws TagTypeUnmatchException
     *             trList内にStringでもタグ型でもない値が含まれている場合にスローされます。
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

    /**
     * TableBuilderのインスタンス内でtheadの情報を保持するプロパティです。
     *
     */
    public thead thead = new thead();

    /**
     * テーブルのtheadを表す内部クラスです。 mixer2のThead型(org.mixer2.jaxb.xhtml.Thead)とは異なります。
     *
     */
    public class thead {

        // 属性情報
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
         * thead内のtrのリストの最後尾に新たなtrを追加し、それを返します。
         *
         */
        public tr addTr() {
            tr tr = new tr();
            trList.add(tr);
            return tr;
        }

        /**
         * thead内のtrのリストの最後尾に新たなtrを追加し、それを返します。また、指定された属性をtrタグにセットします。
         *
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

    /**
     * TableBuilderのインスタンス内でtheadの情報を保持するプロパティです。
     *
     */
    public tfoot tfoot = new tfoot();

    /**
     * テーブルのtfootを表す内部クラスです。mixer2のTfoot型(org.mixer2.jaxb.xhtml.Tfoot)とは異なります。
     *
     */
    public class tfoot {

        // 属性情報
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
     * 内部に蓄積されているtr,tbody,thead,tfootの情報をもとに、
     * org.mixer2.jaxb.xhtml.Table,Tr,Td,Tbody,Thead,Tfoot型を使って
     * 最終的なtableタグオブジェクトを生成します。
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

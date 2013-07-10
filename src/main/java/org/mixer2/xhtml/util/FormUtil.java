package org.mixer2.xhtml.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mixer2.jaxb.xhtml.Form;
import org.mixer2.jaxb.xhtml.Input;
import org.mixer2.jaxb.xhtml.Option;
import org.mixer2.jaxb.xhtml.Select;
import org.mixer2.jaxb.xhtml.Textarea;
import org.mixer2.util.M2StringUtils;

/**
 * <p>
 * set javabean value into input,radio,textarea etc.
 * </p>
 * <p>
 * formタグ内部の入力フォーム（input,radio,textarea等）にJavaBeanの値をセットするユーティリティ
 * </p>
 *
 * @author watanabe
 *
 */
public class FormUtil {

    private static Log log = LogFactory.getLog(FormUtil.class);

    /**
     * <p>
     * LabelValueBeanのリストをもとに、optionタグのlistを返します。
     * </p>
     *
     * @param list
     * @param resultList
     *            empty List. Usually, put new ArrayList<Option> as is.
     *            空のlist。通常は new ArrayList してそのまま渡してください
     * @return
     */
    public static List<Option> makeOptionList(Collection<LabelValueBean> list,
            List<Option> resultList) {
        for (LabelValueBean bean : list) {
            resultList.add(makeOption(bean));
        }
        return resultList;
    }

    /**
     * <p>
     * LabelValueBeanをもとに、ひとつのoptionタグを返します。
     * </p>
     *
     * @param bean
     * @return
     */
    public static Option makeOption(LabelValueBean bean) {
        Option option = new Option();
        option.setValue(bean.getValue());
        option.setContent(bean.getLabel());
        return option;
    }

    /**
     * ラベルとvalueをもとに、ひとつのoptionタグを返します。
     *
     * @param value
     * @param label
     * @return
     */
    public static Option makeOption(String value, String label) {
        return makeOption(new LabelValueBean(label, value));
    }

    /**
     * <p>
     * formタグオブジェクトにJavaBeanの値をセットします。
     * 複数の値を取りうるpropertyは配列としてBeanにセットしておいてください。
     * </p>
     *
     * @param form
     *            Form tag type object
     * @param bean
     *            JavaBean
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static void populateForm(Form form, Object bean)
            throws IllegalAccessException, InvocationTargetException {

        // input tag
        try {
            for (Input input : form.getDescendants(Input.class)) {
                // name属性が指定されていない場合はスルーする。
                if (M2StringUtils.isBlank(input.getName())) {
                    continue;
                }

                switch (input.getType()) {
                case RADIO:
                    // radioは同じnameで複数個ありうるが、ひとつしか選択できない
                    String beanValue = BeanUtils.getProperty(bean,
                            input.getName());
                    if (input.getValue() != null
                            && input.getValue().equals(beanValue)) {
                        input.setChecked("checked");
                    } else {
                        input.setChecked(null);
                    }
                    break;
                case CHECKBOX:
                    // checkboxは同じnameで複数個ありうるし、複数選択できる
                    String[] beanValues = BeanUtils.getArrayProperty(bean,
                            input.getName());
                    boolean matchBean = false;
                    for (String value : beanValues) {
                        if (value.equals(input.getValue())) {
                            input.setChecked("checked");
                            matchBean = true;
                            continue;
                        }
                    }
                    // inputタグのvalueが、beanの配列の値のどれにもマッチしてない場合には
                    // チェックをはずす
                    if (!matchBean) {
                        input.setChecked(null);
                    }
                    break;
                default:
                    // radio,checkbox以外
                    input.setValue(BeanUtils.getProperty(bean, input.getName()));
                }
            }
        } catch (NoSuchMethodException e) {
            log.debug("bean property not found that match the input tag in form.");
        }

        // textarea
        try {
            for (Textarea textarea : form.getDescendants(Textarea.class)) {
                // name属性が指定されていない場合はスルーする。
                if (M2StringUtils.isBlank(textarea.getName())) {
                    continue;
                } else {
                    textarea.setContent(BeanUtils.getProperty(bean,
                            textarea.getName()));
                }
            }
        } catch (NoSuchMethodException e) {
            log.debug("bean property not found that match the textarea tag in form.");
        }

        // select
        try {
            for (Select select : form.getDescendants(Select.class)) {
                // name属性が指定されていない場合はスルーする。
                if (M2StringUtils.isBlank(select.getName())) {
                    continue;
                } else {
                    for (Option option : select.getDescendants(Option.class)) {
                        boolean matchBean = false;
                        for (String value : BeanUtils.getArrayProperty(bean,
                                select.getName())) {
                            if (value.equals(option.getValue())) {
                                option.setSelected("selected");
                                matchBean = true;
                            }
                        }
                        // optionタグのvalueが、beanの配列の値のどれにも
                        // マッチしてない場合にはチェックをはずす
                        if (!matchBean) {
                            option.setSelected(null);
                        }
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            log.debug("bean property not found that match the option tag in select tag.");
        }
    }
}

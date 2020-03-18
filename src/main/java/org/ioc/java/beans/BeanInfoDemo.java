package org.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo} 示例
 * Created by lasia on 2020/2/22.
 */
public class BeanInfoDemo {
    public static void main(String args[]) throws IntrospectionException {
        //加Object.class 只找当前层次
        BeanInfo beanInfo = Introspector.getBeanInfo(Persons.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    //PropertyDescriptors 允许添加属性编辑器 - PropertyEditor
                    //GUI -> text(String) -> PropertyType
                    // name -> String
                    //age -> Integer
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyName = propertyDescriptor.getName();
                    if ("age".equals(propertyName)) { //为 age 字段/属性增加 PropertyEditor
                        propertyDescriptor.setPropertyEditorClass(stringToIntegerPropertyEditor.class);
//                        propertyDescriptor.createPropertyEditor();
                    }
                    System.out.println(propertyDescriptor);
                }
        );
    }

    static class stringToIntegerPropertyEditor extends PropertyEditorSupport {
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
           Integer value = Integer.valueOf(text);
           setValue(value);
        }
    }
}

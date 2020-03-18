package org.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.thinking.in.spring.ioc.overview.domain.User;

/**
 * 34
 * Created by lasia on 2020/3/8.
 */
public class BeanAliasDemo {
    public static void main(String args[]) {
        //配置 XML 配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definition-context.xml");
        //通过别名 lasia获取曾用名 user的bean
        User user = beanFactory.getBean("user",User.class);
        User lasia = beanFactory.getBean("lasia",User.class);
        System.out.println("user 是否与 lasia Bean相同：" + (user == lasia));
    }
}

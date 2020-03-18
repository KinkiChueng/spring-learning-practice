package org.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.thinking.in.spring.ioc.overview.domain.User;

/**
 * Created by lasia on 2020/3/14.
 */
public class BeanInstantiationDemo {
    public static void main(String args[]) {

        //配置 XML 配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        //通过别名 lasia获取曾用名 user的bean
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
        User userByFactoryMethod = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(userByInstanceMethod);
        System.out.println(user);
        System.out.println(userByFactoryMethod);
    }
}

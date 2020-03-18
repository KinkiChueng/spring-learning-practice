package org.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.thinking.in.spring.bean.factory.UserFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by lasia on 2020/3/14.
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String args[]) {

        //配置 XML 配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
//        demoServiceLoader();

        displayServiceLoader(beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class));
    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().createUser());
        }
    }

    public static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
       // ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().createUser());
        }
    }
}

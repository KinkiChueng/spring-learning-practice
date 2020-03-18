package org.thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.thinking.in.spring.bean.factory.UserFactory;

/**
 * Created by lasia on 2020/3/14.
 */
@Configuration
public class BeanInitializationDemo {


    public static void main(String args[]) {
        //创建BeanFactory
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(BeanInitializationDemo.class);
        //启动Spring应用上下文
        annotationConfigApplicationContext.refresh();

        UserFactory userFactory = annotationConfigApplicationContext.getBean(UserFactory.class);
        System.out.println("应用上下文准备关闭");
        annotationConfigApplicationContext.close();
        System.out.println("应用上下文已关闭");
    }

    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestory")
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}

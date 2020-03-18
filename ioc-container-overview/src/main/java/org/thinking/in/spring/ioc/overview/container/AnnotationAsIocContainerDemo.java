package org.thinking.in.spring.ioc.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thinking.in.spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * Created by lasia on 2020/3/6.
 */
public class AnnotationAsIocContainerDemo {
    public static void main(String args[]) {
        //创建 beanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类AnnotationAsIocContainerDemo作为配置类 Configuration class
        applicationContext.register(AnnotationAsIocContainerDemo.class);
        //启动应用上下文
        applicationContext.refresh();
        //加载配置
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        String location = "classpath:/META-INF/dependency-lookup-context.xml";
//        int beanDefinitionCount = reader.loadBeanDefinitions(location);
//        System.out.println("bean定义加载数量:"+beanDefinitionCount);
        //依赖查找集合对象
        lookupCollectionByType(applicationContext);
        applicationContext.close();
    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(1l);
        user.setName("a");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的user集合对象" + users);
        }
    }

}

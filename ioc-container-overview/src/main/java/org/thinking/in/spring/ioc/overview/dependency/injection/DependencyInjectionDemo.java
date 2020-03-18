package org.thinking.in.spring.ioc.overview.dependency.injection;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.thinking.in.spring.ioc.overview.domain.User;
import org.thinking.in.spring.ioc.overview.repository.UserRepository;

/**
 * 依赖注入示例
 * Created by lasia on 2020/2/24.
 */
public class DependencyInjectionDemo {
    public static void main(String args[]) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        //自定义bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository.getUsers());

        //依赖注入 (内建依赖)
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory);

//        //依赖查找 (错误)
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        //容器内建bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取Environment类型的bean" + environment);

        ObjectFactory userFactory = userRepository.getObjectFactory();
        System.out.println(userFactory.getObject());


        whoIsIocContainer(userRepository,beanFactory);
    }

    private static void whoIsIocContainer(UserRepository userRepository, BeanFactory beanFactory) {
        //ConfigurableApplicationContext <-- ApplicationContext <-- BeanFactory 代理模式
        //这个表达式为什么不成立
        System.out.println(userRepository.getBeanFactory() == beanFactory);
    }
}

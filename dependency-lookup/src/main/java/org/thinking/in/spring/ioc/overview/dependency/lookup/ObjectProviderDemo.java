package org.thinking.in.spring.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.thinking.in.spring.ioc.overview.domain.User;

/**
 * 通过{@link ObjectProvider} 进行依赖查找
 * Created by lasia on 2020/3/17.
 */
public class ObjectProviderDemo {   //@Configuration非必须注解
    public static void main(String args[]) {
        //创建 beanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册Configuration class（配置类）
        applicationContext.register(ObjectProviderDemo.class);

        applicationContext.refresh();

        lookupByObjectProvider(applicationContext);
        lookupIfAvailable(applicationContext);
        lookupByStreamOps(applicationContext);

        //显示的关闭Spring应用上下文
        applicationContext.close();
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
//        Iterable<String> stringIterable = userObjectProvider;
//        for (String s : stringIterable) {
//            System.out.println(s);
//        }
        objectProvider.stream().forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        User user = userObjectProvider.getIfAvailable(() -> User.createUser());

        System.out.println("当前User对象：" + user);
    }

    @Bean
    @Primary
    public String helloWorld() {
        return "hello lasia";
    }

    @Bean
    public String message() {
        return "message";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }

}

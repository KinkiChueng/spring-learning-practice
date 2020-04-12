package ioc.dependency.injection;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thinking.in.spring.ioc.overview.domain.User;

/**
 * 55 | Setter方法依赖注入：Setter注入的原理是什么？
 * Created by lasia on 2020/4/12.
 */
public class AnnotionDependencySetterInjectionDemo {
    private User user;
    public static void main(String args[]) {
        //创建 beanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册Configuration class（配置类）
        applicationContext.register(AnnotionDependencySetterInjectionDemo.class);


        //依赖查找并且创建bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        //加载XML资源 解析并且生成BeanDefintion
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        //启动
        applicationContext.refresh();
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);

        //显示的关闭Spring应用上下文
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}

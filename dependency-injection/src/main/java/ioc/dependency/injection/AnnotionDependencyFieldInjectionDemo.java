package ioc.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thinking.in.spring.ioc.overview.domain.User;

import javax.annotation.Resource;

/**
 * 57 | 为什么Spring官方文档没有单独列举这种注入方式？
 * Created by lasia on 2020/4/12.
 */
public class AnnotionDependencyFieldInjectionDemo {
    @Autowired //Autowired会忽略静态字段
    private
//    static
    UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;
    public static void main(String args[]) {
        //创建 beanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册Configuration class（配置类）--》Spring bean
        applicationContext.register(AnnotionDependencyFieldInjectionDemo.class);


        //依赖查找并且创建bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        //加载XML资源 解析并且生成BeanDefintion
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        //启动
        applicationContext.refresh();
        //依赖查找AnnotionDependencyFieldInjectionDemo bean
        AnnotionDependencyFieldInjectionDemo demo = applicationContext.getBean(AnnotionDependencyFieldInjectionDemo.class);

        UserHolder userHolder = demo.userHolder;
        System.out.println(userHolder);
        UserHolder userHolder2 = demo.userHolder2;
        System.out.println(userHolder2);
        System.out.println(userHolder == userHolder2);

        //显示的关闭Spring应用上下文
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}

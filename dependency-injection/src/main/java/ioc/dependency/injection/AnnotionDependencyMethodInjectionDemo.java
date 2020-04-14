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
public class AnnotionDependencyMethodInjectionDemo {

    private UserHolder userHolder;

    private UserHolder userHolder2;

    @Autowired
    public void initUserHolder(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    @Resource
    public void initUserHolder2(UserHolder userHolder) {
        this.userHolder2 = userHolder;
    }
    public static void main(String args[]) {
        //创建 beanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册Configuration class（配置类）--》Spring bean
        applicationContext.register(AnnotionDependencyMethodInjectionDemo.class);


        //依赖查找并且创建bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        //加载XML资源 解析并且生成BeanDefintion
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        //启动
        applicationContext.refresh();
        //依赖查找AnnotionDependencyFieldInjectionDemo bean
        AnnotionDependencyMethodInjectionDemo demo = applicationContext.getBean(AnnotionDependencyMethodInjectionDemo.class);

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

package ioc.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于Java注解
 * 55 | Setter方法依赖注入：Setter注入的原理是什么？
 * Created by lasia on 2020/4/12.
 */
public class APIDependencyConstructorInjectionDemo {
    public static void main(String args[]) {
        //创建 beanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //生成
        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        //注册Configuration class（配置类）
        applicationContext.registerBeanDefinition("userHolder",userHolderBeanDefinition);

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

    /**
     * {@link UserHolder} 生成 {@link BeanDefinition}
     * @return
     */
    private static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        definitionBuilder.addConstructorArgReference("superUser");
        return definitionBuilder.getBeanDefinition();
    }

}

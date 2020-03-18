package org.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.thinking.in.spring.ioc.overview.domain.User;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * Created by lasia on 2020/3/9.
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String args[]) {
        //创建 beanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册Configuration class（配置类）
        applicationContext.register(Config.class);
        //1 通过@bean方式定义
        //2 通过@Component 方式
        //3 通过@Import 导入

        //通过BeanDefinition注册API
        //1 命名Bean注册方式
        registerBeanDefinition(applicationContext,"asdf");
        //2非命名
        registerBeanDefinition(applicationContext);

        applicationContext.refresh();
        System.out.println("config类型所有beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("user类型所有beans" + applicationContext.getBeansOfType(User.class));
        //显示的关闭Spring应用上下文
        applicationContext.close();
    }

    /**
     *  命名bean的注册方式
     * @param registry
     * @param beanName
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry,String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id",1).addPropertyValue("name","lasia");

        //如果beanName存在
        if (StringUtils.hasText(beanName)) {
            //注册BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());

        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry) {
        registerBeanDefinition(registry,null);
    }

    @Component //定义当前类作为 SpringBean组件
    public static class Config {
        /**
         * 注解方式创建bean
         * @return
         */
        @Bean(name = {"user","lasia"})
        public User user() {
            User user = new User();
            user.setId(1l);
            user.setName("a");
            return user;
        }
    }
}

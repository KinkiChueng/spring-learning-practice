package ioc.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 {@link Aware} 接口回调的依赖注入实例
 * Created by lasia on 2020/4/12.
 */
public class AwareDependencyInjectionDemo implements BeanFactoryAware,ApplicationContextAware {
    private static BeanFactory beanFactory;
    private static ApplicationContext applicationContext;

    public static void main(String args[]) {
        //创建 beanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册Configuration class（配置类）
        context.register(AwareDependencyInjectionDemo.class);

        context.refresh();

        System.out.println(beanFactory == context.getBeanFactory());
        System.out.println(applicationContext == context);
        context.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AwareDependencyInjectionDemo.beanFactory = beanFactory;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AwareDependencyInjectionDemo.applicationContext = applicationContext;
    }
}

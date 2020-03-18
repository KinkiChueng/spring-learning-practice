package org.thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thinking.in.spring.bean.factory.UserFactory;

/**
 * GC示例
 * Created by lasia on 2020/3/15.
 */
public class BeanGarbageCollectionDemo {
    public static void main(String args[]) throws InterruptedException {
        //创建BeanFactory
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(BeanInitializationDemo.class);
        //启动Spring应用上下文
        annotationConfigApplicationContext.refresh();

        UserFactory userFactory = annotationConfigApplicationContext.getBean(UserFactory.class);
        System.out.println("应用上下文准备关闭");
        annotationConfigApplicationContext.close();
        System.out.println("应用上下文已关闭");
        Thread.sleep(10000L);
        //强制GC 方法不是稳定被调用到的
        System.gc();
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("当前对象DefaultUserFactory正在被回收");
    }
}

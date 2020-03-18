package org.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * java8之后没绝对抽象类 有默认实现
 * Created by lasia on 2020/3/14.
 */
public class DefaultUserFactory implements UserFactory,InitializingBean,DisposableBean {
    //1,@PostConstruct
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct:userFactory初始化··· ");
    }

    public void initUserFactory() {
        System.out.println("自定义初始化方法initUserFactory:userFactory初始化··· ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet:userFactory初始化··· ");
    }

    @PreDestroy
    public void preDestory() {
        System.out.println("@PreDestroy : userFactory销毁中···");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy() : userFactory销毁中···");
    }

    public void doDestory() {
        System.out.println("自定义销毁方法doDestory() : userFactory销毁中···");
    }
}

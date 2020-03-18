package org.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;
import org.thinking.in.spring.ioc.overview.domain.User;

/**
 * {@link User} bean的 {@link FactoryBean}实现
 * 单例
 * Created by lasia on 2020/3/14.
 */
public class UserFactoryBean implements FactoryBean {

    @Nullable
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}

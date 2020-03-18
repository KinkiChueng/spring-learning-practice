package org.thinking.in.spring.bean.factory;

import org.thinking.in.spring.ioc.overview.domain.User;

/**
 * Created by lasia on 2020/3/14.
 */
public interface UserFactory {
    default User createUser() {
        return User.createUser();
    }
}

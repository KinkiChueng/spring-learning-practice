package ioc.dependency.injection;

import org.thinking.in.spring.ioc.overview.domain.User;

/**
 * {@link User} 的holder方式
 * Created by lasia on 2020/4/12.
 */
public class UserHolder {
    private User user;

    public UserHolder(User user) {
        this.user = user;
    }

    public UserHolder() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}

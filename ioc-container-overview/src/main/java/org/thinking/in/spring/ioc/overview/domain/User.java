package org.thinking.in.spring.ioc.overview.domain;


import org.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * Created by lasia on 2020/2/24.
 */
@Super
public class User {
    private Long id;

    private String name;

    public static User createUser() {
        return new User();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

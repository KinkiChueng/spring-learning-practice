package org.thinking.in.spring.ioc.overview.domain;

import org.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * Created by lasia on 2020/2/24.
 */
@Super
public class SuperUser extends User {
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}

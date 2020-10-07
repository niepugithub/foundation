package com.jdk.jmx.sc;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @date:2020/10/7 18:20
 **/
@Setter
@Getter
public class User implements UserMBean {

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

}

package com.jdk.jmx.sc;

/**
 * @description:
 * @date:2020/10/7 18:21
 **/
public interface UserMBean {

    /**
     * 获取用户名
     *
     * @return
     */
    String getName();

    /**
     * 设置用户名
     *
     * @param name
     */
    void setName(String name);

    /**
     * 获取密码
     *
     * @return
     */
    String getPassword();

    /**
     * 设置密码
     *
     * @param password
     */
    void setPassword(String password);

    /**
     * @param x
     * @param y
     * @return
     */
    int add(int x, int y);

}

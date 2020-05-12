package com.beans;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/11 22:39
 */
public class UserBean {
    private String userName;
    private String password;
    private String email;

    public UserBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

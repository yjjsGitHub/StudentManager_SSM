package com.yjj.model;


import java.sql.Date;

/**
 * Created by Administrator on 2018/7/13.
 */
public class Admin {

    private String email;
    private String password;
    private Date lastTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lastTime=" + lastTime.getTime() +
                '}';
    }
}

package com.yjj.model;

public class Student {

    private String sid;
    private String cid;
    private String name;
    private Integer sex;
    private String address;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}

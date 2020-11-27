package com.ice.entity;

import java.util.Date;

public class UserEntity {

    private String username;

    private String password;

    private String loginname;

    private Date updateDate;

    private Integer age;

    private String permissions;

    public UserEntity(){

    }
    public UserEntity(String username, String password, String loginname, Date updateDate, Integer age) {
        this.username = username;
        this.password = password;
        this.loginname = loginname;
        this.updateDate = updateDate;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}

package com.ice.entity;

public class CommonOptionEntity {

    /**
     * 热点下拉框key
     */
    private String number;

    /**
     * 热点下拉框value
     */
    private String tital;

    /**
     * 微博内容
     */
    private String content;

    /**
     * 微博创建时间
     */
    private String createDate;

    /**
     * 发布者姓名
     */
    private String username;

    /**
     * 评论内容
     */
    private String comments;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTital() {
        return tital;
    }

    public void setTital(String tital) {
        this.tital = tital;
    }
}

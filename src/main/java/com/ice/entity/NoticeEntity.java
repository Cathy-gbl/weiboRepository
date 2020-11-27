package com.ice.entity;

import java.util.Date;

public class NoticeEntity {
    private String id;

    private String noticeContent;

    private Date noticeDate;

    private String username;

    private String isFlag;

    public NoticeEntity(){}

    public NoticeEntity(String id, String noticeContent, Date noticeDate, String username, String isFlag) {
        this.id = id;
        this.noticeContent = noticeContent;
        this.noticeDate = noticeDate;
        this.username = username;
        this.isFlag = isFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag;
    }
}

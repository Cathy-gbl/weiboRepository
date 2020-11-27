package com.ice.service;

import com.ice.entity.NoticeEntity;

import java.util.List;

public interface NoticeService {

    public boolean insert(String noticeContent,String username);

    public List<NoticeEntity> getAllNotice();
}

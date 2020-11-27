package com.ice.service.impl;

import com.ice.entity.NoticeEntity;
import com.ice.mapper.NoticeMapper;
import com.ice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public boolean insert(String noticeContent, String username) {
        int insert = noticeMapper.insert(new NoticeEntity(UUID.randomUUID().toString(), noticeContent, new Date(), username, "1"));
        if(insert > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<NoticeEntity> getAllNotice() {
        return noticeMapper.getAllNotice();
    }
}

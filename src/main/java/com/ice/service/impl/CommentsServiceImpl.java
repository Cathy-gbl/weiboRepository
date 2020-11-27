package com.ice.service.impl;

import com.ice.entity.CommentsEntity;
import com.ice.entity.WeiBoEntity;
import com.ice.mapper.CommentsMapper;
import com.ice.service.CommentsSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsSerive {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public List<CommentsEntity> getCommentsInfoByLoginName(String loginname) {
        return commentsMapper.getCommentsInfoByLoginName(loginname);
    }

    @Override
    public boolean delete(String number) {
        int delete = commentsMapper.delete(number);
        if(delete > 0){
            return true;
        }
        return false;
    }
}

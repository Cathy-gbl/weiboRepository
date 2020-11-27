package com.ice.service;

import com.ice.entity.CommentsEntity;
import com.ice.entity.WeiBoEntity;

import java.util.List;

public interface CommentsSerive {

    public List<CommentsEntity> getCommentsInfoByLoginName(String loginname);

    public boolean delete(String number);
}

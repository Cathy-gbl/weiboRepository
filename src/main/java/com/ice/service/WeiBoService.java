package com.ice.service;

import com.ice.entity.WeiBoEntity;

import java.util.List;

public interface WeiBoService {

    public List<WeiBoEntity> getWeiBoInfoByLoginname(String loginname);

    public boolean delete(String number);

    public boolean insert(String content,String tital,String labelname,String laginname);
}

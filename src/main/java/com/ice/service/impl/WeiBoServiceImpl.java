package com.ice.service.impl;

import com.ice.entity.WeiBoEntity;
import com.ice.mapper.WeiBoMapper;
import com.ice.service.WeiBoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class WeiBoServiceImpl implements WeiBoService {

    @Autowired
    private WeiBoMapper weiBoMapper;

    @Override
    public List<WeiBoEntity> getWeiBoInfoByLoginname(String loginname) {
        return weiBoMapper.getWeiBoInfoByLoginname(loginname);
    }

    @Override
    public boolean delete(String number) {
        int i = weiBoMapper.deleteWeibo(number);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(String content, String tital, String labelname, String laginname) {
        WeiBoEntity weiBoEntity = new WeiBoEntity();
        weiBoEntity.setId(UUID.randomUUID().toString());
        weiBoEntity.setNumber(UUID.randomUUID().toString());
        weiBoEntity.setContent(content);
        weiBoEntity.setTital(tital);
        weiBoEntity.setIsFlag("1");
        weiBoEntity.setCreateDate(new Date());
        weiBoEntity.setLoginname(laginname);
        weiBoEntity.setLabelname(labelname);
        int insert = weiBoMapper.insert(weiBoEntity);
        if(insert > 0){
            return true;
        }
        return false;
    }
}

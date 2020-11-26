package com.ice.service.impl;

import com.ice.entity.CommonOptionEntity;
import com.ice.mapper.CommonOptionMapper;
import com.ice.service.CommonOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonOptionServiceImpl implements CommonOptionService {

    @Autowired
    private CommonOptionMapper commonOptionMapper;

    @Override
    public List<CommonOptionEntity> getHotContentOption() {
        return commonOptionMapper.getHotContentOption();
    }

    @Override
    public List<CommonOptionEntity> getHotContentOptionByLike(String content) {
        String hotContent = "%"+content+"%";
        return commonOptionMapper.getHotContentOptionByLike(hotContent);
    }

    @Override
    public List<CommonOptionEntity> getHotContentXqByNumber(String content) {
        return commonOptionMapper.getHotContentXq(content);
    }

    @Override
    public List<CommonOptionEntity> getHotCommentsXqByNumber(String content) {
        return commonOptionMapper.getHotCommentsXq(content);
    }


}

package com.ice.service;

import com.ice.entity.CommonOptionEntity;
import com.ice.mapper.CommonOptionMapper;

import java.util.List;

public interface CommonOptionService {

    public List<CommonOptionEntity> getHotContentOption();

    public List<CommonOptionEntity> getHotContentOptionByLike(String content);

    public List<CommonOptionEntity> getHotContentXqByNumber(String content);

    public List<CommonOptionEntity> getHotCommentsXqByNumber(String content);

}

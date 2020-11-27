package com.ice.service;

import com.ice.entity.LabelEntity;

import java.util.List;

public interface LabelService {

    public boolean insert(String labelname,String loginname);

    public List<LabelEntity> getAllLabel();
}

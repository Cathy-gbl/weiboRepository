package com.ice.service.impl;

import com.ice.entity.LabelEntity;
import com.ice.mapper.LabelMapper;
import com.ice.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public boolean insert(String labelname, String loginname) {

        int i = labelMapper.insertLabel(UUID.randomUUID().toString(), labelname, new Date(), loginname);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<LabelEntity> getAllLabel() {
        return labelMapper.getAllLabel();
    }
}

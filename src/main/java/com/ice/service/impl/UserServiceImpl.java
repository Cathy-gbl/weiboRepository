package com.ice.service.impl;

import com.ice.entity.UserEntity;
import com.ice.mapper.UserMapper;
import com.ice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean login(String username,String password) {
        UserEntity login = userMapper.login(username, password);
        if(login == null){
            return false;
        }
        return true;
    }

    @Override
    public int updateUserInfo(String username, String password, Integer age, String loginname) {
        UserEntity userEntity = new UserEntity(username, password, loginname, new Date(), age);
        return userMapper.updateUserInfo(userEntity);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public boolean setPermissions(String loginname, String flag) {
        String permissions = "";
        if(flag.equals("Y")){
            permissions = "1";
        }else {
            permissions = "0";
        }
        int i = userMapper.setPermissions(loginname, permissions);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPermissions(String loginname) {
        UserEntity userEntity = userMapper.checkPermissions(loginname);
        if(userEntity != null){
            return true;
        }
        return false;
    }
}

package com.ice.service;

import com.ice.entity.UserEntity;

import java.util.List;

public interface UserService {

    public boolean login(String username,String password);

    public int updateUserInfo(String username,String password,Integer age,String loginname);

    public List<UserEntity> getAllUser();

    public boolean setPermissions(String loginname,String flag);

    public boolean checkPermissions(String loginname);
}

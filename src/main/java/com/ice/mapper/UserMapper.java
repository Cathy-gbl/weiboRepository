package com.ice.mapper;

import com.ice.entity.UserEntity;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("SELECT username,password,loginname,permissions FROM USER WHERE LOGINNAME = #{0} AND PASSWORD = #{1}")
    public UserEntity login(String username, String password);

    @Update("UPDATE user SET username = #{username}, password=#{password},age=#{age},updatedate=#{updateDate} WHERE loginname = #{loginname}")
    public int updateUserInfo(UserEntity userEntity);

    @Select("SELECT loginname,username,permissions FROM USER where is_flag = '1'")
    public List<UserEntity> getAllUser();

    @Update("update user set permissions = #{1} where loginname = #{0}")
    public int setPermissions(String loginname,String permissions);

    @Select("SELECT username,password,loginname,permissions FROM USER WHERE LOGINNAME = #{0} AND is_flag = '1' AND permissions = '1'")
    public UserEntity checkPermissions(String username);
}

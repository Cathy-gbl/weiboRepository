package com.ice.mapper;

import com.ice.entity.NoticeEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NoticeMapper {


    @Insert("INSERT INTO notice(id, noticeContent, noticeDate, username, is_flag) VALUES (#{id}, #{noticeContent}, #{noticeDate},#{username} , #{isFlag})")
    public int insert(NoticeEntity noticeEntity);

    @Select("SELECT a.id, a.noticeContent, a.noticeDate, b.username FROM notice a " +
            "inner join user b on a.username = b.loginname " +
            "WHERE a.IS_FLAG = '1'")
    public List<NoticeEntity> getAllNotice();
}

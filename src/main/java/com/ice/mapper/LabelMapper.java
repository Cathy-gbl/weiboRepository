package com.ice.mapper;


import com.ice.entity.LabelEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface LabelMapper {

    @Insert("INSERT INTO label(id, labelname, create_date, create_user) VALUES (#{0}, #{1}, #{2}, #{3});\n")
    public int insertLabel(String id, String labelname, Date createDate,String loginname);

    @Select("SELECT ID,LABELNAME FROM LABEL")
    public List<LabelEntity> getAllLabel();
}

package com.ice.mapper;

import com.ice.entity.WeiBoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WeiBoMapper {

    @Select("SELECT " +
            "a.hot_number as number,a.hot_tital as tital," +
            "a.hot_content as content,a.create_date as createDate," +
            "b.loginname as loginname,b.username as username,c.LABELNAME as LABELNAME " +
            "FROM hot_content A INNER JOIN USER B ON A.user_id = B.loginname " +
            "left JOIN LABEL C ON A.LABEL_ID = C.ID "+
            " WHERE a.is_flag = '1' and  B.loginname = #{0}")
    public List<WeiBoEntity> getWeiBoInfoByLoginname(String loginname);

    @Update("UPDATE hot_content SET is_flag = '0' where hot_number = #{0}")
    public int deleteWeibo(String number);

    @Insert("INSERT INTO hot_content( id,hot_number, hot_content, hot_tital, is_flag, create_date, user_id, label_id) " +
            "VALUES (#{id},#{number},#{content},#{tital},#{isFlag},#{createDate},#{loginname},#{labelname} )")
    public int insert(WeiBoEntity weiBoEntity);
}

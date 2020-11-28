package com.ice.mapper;

import com.ice.entity.CommonOptionEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface CommonOptionMapper {

    @Select("SELECT hot_number AS number,hot_tital as tital FROM hot_content WHERE is_flag = '1'")
    List<CommonOptionEntity> getHotContentOption();

    @Select("SELECT hot_number AS number,hot_tital as tital FROM hot_content WHERE is_flag = '1' and hot_tital like #{content} ")
    List<CommonOptionEntity> getHotContentOptionByLike(String content);

//    @Select("SELECT a.hot_number as number,a.hot_content as content,a.hot_tital as tital, " +
//            "a.create_date as createDate,c.username as username,b.content as comments " +
//            "FROM hot_content a inner join hot_comments b on a.comments_id = b.id and a.hot_number = b.hot_number "+
//            "inner join user c on a.user_id = c.id "+
//            "WHERE a.is_flag = '1' and b.is_flag = '1' and c.is_flag = '1' "+
//            "and a.hot_number = #{number} "+
//            "GROUP BY a.hot_number,b.content,a.create_date,c.username,b.comment_time "+
//            "order by a.create_date"
//    )
//    List<CommonOptionEntity> getHotContentXq(String number);

    @Select(
            "SELECT " +
            "a.hot_number as number,a.hot_content as content,a.hot_tital as tital, "+
            "a.create_date as createDate,b.username "+
            "FROM hot_content a "+
            "LEFT JOIN USER B ON A.user_id = B.loginname "+
            "WHERE a.is_flag = '1' and a.hot_number = #{number} "
    )
    List<CommonOptionEntity> getHotContentXq(String number);

    @Select(
            "SELECT a.content,b.username,a.comment_time as createDate FROM hot_comments a "+
            "LEFT JOIN USER B ON A.commentator = b.loginname "+
            "WHERE a.hot_number = #{number} AND a.iS_FLAG = '1' " +
             "order by a.comment_time asc"
    )
    List<CommonOptionEntity> getHotCommentsXq(String number);
}

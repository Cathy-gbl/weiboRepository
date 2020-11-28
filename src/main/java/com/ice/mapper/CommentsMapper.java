package com.ice.mapper;

import com.ice.entity.CommentsEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentsMapper {

    @Select("SELECT A.CONTENT,A.comment_time AS commentTime,C.USERNAME,B.hot_tital AS TITAL,A.hot_number as number,A.comments_id as id \n" +
            "FROM hot_comments A \n" +
            "INNER JOIN hot_content B ON A.hot_number = B.hot_number\n" +
            "INNER JOIN USER C ON A.commentator = C.loginname \n" +
            "WHERE B.IS_FLAG = '1' AND A.is_flag = '1'\n" +
            "AND C.loginname = #{0}")
    public List<CommentsEntity> getCommentsInfoByLoginName(String loginname);

    @Update("update hot_comments set is_flag = '0' where comments_id = #{0}")
    public int delete(String number);

    @Insert("INSERT INTO hot_comments(content, commentator, comment_time, is_flag, hot_number, comments_id)" +
            " VALUES (#{content},#{username},#{commentTime},#{isFlag},#{number},#{id})")
    public int insert(CommentsEntity commentsEntity);
}

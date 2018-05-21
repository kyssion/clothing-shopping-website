package org.kys.clothing.dateQuery;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.kys.clothing.comment.CommentBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDataQuery {

    @Insert("insert into comment (user_code, comment_info, sku, add_time, status) " +
            "values (#{userCode},#{commentInfo},#{sku},#{addTime},#{status})")
    int addComment(CommentBean commentBean);

    @Select("select * from commment where sku =#{sku}")
    List<CommentBean> findCommentBysku(@Param("sku") String sku);
}

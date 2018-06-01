package org.kys.clothing.dataQuery;

import org.apache.ibatis.annotations.*;
import org.kys.clothing.user.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDataQuery {
    @Select("select * from user where user_code = #{userCode}")
    UserBean getUserInfo(@Param("userCode") String userCode);

    @Insert("insert into user (user_code, user_password, user_tel, user_email, user_addr, status)" +
            " values (#{userCode},#{userPassword},#{userTel},#{userEmail},#{userAddr},#{status})")
    int insertUserBean(UserBean userBean);

    @Select("select count(*) from user where user_code = #{userCode}")
    Integer isRegister(@Param("userCode") String userCode);

    @Select("select * from user")
    List<UserBean> getAllUser();

    @Delete("delete from user where user_code = #{userCode}")
    boolean deleteUser(@Param("userCode") String userCode);
}

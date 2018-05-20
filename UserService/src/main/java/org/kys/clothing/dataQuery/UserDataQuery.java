package org.kys.clothing.dataQuery;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.kys.clothing.user.UserBean;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDataQuery {
    @Select("select * from user where user_code = #{userCode}")
    public UserBean getUserInfo(@Param("userCode") String userCode);

    @Insert("insert into user (user_code, user_password, user_tel, user_email, user_addr, status)" +
            " values (#{userCode},#{userPassword},#{userTel},#{userEmail},#{userAddr},#{status})")
    int insertUserBean(UserBean userBean);

    @Select("select count(*) from user where user_code = #{userCode}")
    Integer isRegister(@Param("userCode") String userCode);
}

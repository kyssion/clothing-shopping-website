package org.kys.clothing.fegin;

import org.kys.clothing.user.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "user-service")
public interface UserFegin {

    @RequestMapping(value = "get_all_user",method = RequestMethod.GET)
    List<UserBean> getAllUserBean();

    @RequestMapping("delete_user")
    boolean deleteUserBean(@RequestParam("user_code")String userCode);
}

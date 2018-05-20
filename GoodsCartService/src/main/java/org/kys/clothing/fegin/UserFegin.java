package org.kys.clothing.fegin;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
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
    @RequestMapping(value = "get_user_info",method = RequestMethod.GET)
    UserBean getDiscountsGoods(@RequestParam("user_code")String userCode);
}


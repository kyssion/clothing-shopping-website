package org.kys.clothing.fegin;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.user.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "user-service")
public interface DiscountFegin {
    @RequestMapping(value = "get_goods_with_discounts",method = RequestMethod.GET)
    GoodsBean getDiscountsGoods(@RequestParam("sku")String sku);
}

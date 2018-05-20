package org.kys.clothing.fegin;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.goodsCart.GoodsCardsBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "goodscarts-service")
public interface GoodsCardsFegin {
    @RequestMapping(value = "get_all_user_goods",method = RequestMethod.GET)
    List<GoodsCardsBean> getAllUserGoods(@RequestParam("userCode")String userCode);
}


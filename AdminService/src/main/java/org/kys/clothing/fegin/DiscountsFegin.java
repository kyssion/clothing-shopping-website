package org.kys.clothing.fegin;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.returnI.DiscountBeanList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "discounts-service")
public interface DiscountsFegin {
    @RequestMapping(value = "get_discounts_goods",method = RequestMethod.GET)
    List<GoodsBean> getDiscountsGoods(@RequestParam("page") int page, @RequestParam("page_size") int pageSize);

    @RequestMapping(value = "get_discounts_information",method = RequestMethod.GET)
    DiscountsBean getDiscountsInformationBySku(@RequestParam("sku") String sku);

    @RequestMapping("get_discount")
    DiscountBeanList getDiscount(@RequestParam("sku")String sku, @RequestParam("page")int page);

    @RequestMapping("update_discout")
    boolean updateDiscount(@RequestParam("sku")String sku,@RequestParam("info")String info,@RequestParam("money")int money);
}


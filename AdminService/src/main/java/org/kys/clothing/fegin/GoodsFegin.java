package org.kys.clothing.fegin;


import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.returnI.GoodsBeanList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "goods-service")
public interface GoodsFegin{
    @RequestMapping("get_all_goods_by_page")
    List<GoodsBean> getAllGoodsBean(@RequestParam("number") int number);

    @RequestMapping("delete_goods")
    boolean deleteGoodsBean(@RequestParam("sku")String sku);

    @RequestMapping("insert_goods")
    boolean insertGoodsBean(@RequestBody GoodsBean goodsBean);

    @RequestMapping("get_all_a_goods")
    GoodsBeanList getAdminGoodsList(@RequestParam("page")int number, @RequestParam("sku")@Nullable String sku,
                                           @RequestParam("c")@Nullable String categration,
                                           @RequestParam("fc")@Nullable String fcategration);
}

package org.kys.clothing.fegin;


import org.kys.clothing.Good.GoodsBean;
import org.springframework.cloud.openfeign.FeignClient;
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
}

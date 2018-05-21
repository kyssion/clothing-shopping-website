package org.kys.clothing.dataQuery;

import org.apache.ibatis.annotations.*;
import org.kys.clothing.goodsCart.GoodsCardsBean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@Mapper
public interface GoodsCartQuery {
    @Select("select * from goods g,goods_cards c  " +
            "where g.sku=c.sku and c.user_code= #{usercode}")
    public List<GoodsCardsBean> getUserGoodsCart(@Param("userCode") String userCode);

    @Delete("delete from goods_cards where userCode=#{userCode}")
    Integer removeGoodsItem(@Param("userCode") String userCode);

    @Insert("insert into goods_cards (cards_id, sku, sku_number, add_time, user_code)" +
            "values(#{cardsId},#{sku},#{skuNumber},#{addTime},#{userCode})")
    Integer addGoodsItem(GoodsCardsBean bean);

    @Delete("delete from goods_cards where userCode=#{userCode} and sku=#{sku}")
    Integer removeGoodsItem(@Param("userCode") String userCode,@Param("sku") String sku);
}

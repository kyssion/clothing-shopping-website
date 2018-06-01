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
            "where g.sku=c.sku and c.user_code= #{userCode}")
    List<GoodsCardsBean> getUserGoodsCart(@Param("userCode") String userCode);

    @Delete("delete from goods_cards where userCode=#{userCode}")
    Integer removeGoodsItembyUserCode(@Param("userCode") String userCode);

    @Insert("insert into goods_cards (cards_id, sku, sku_number, add_time, user_code,color,size)" +
            "values(#{cardsId},#{sku},#{skuNumber},#{addTime},#{userCode},#{color},#{size})")
    Integer addGoodsItem(GoodsCardsBean bean);

    @Delete("delete from goods_cards where userCode=#{user_code} and sku=#{sku}")
    Integer removeGoodsItemByCodeAndSku(@Param("userCode") String userCode,@Param("sku") String sku);

    @Update("update goods_cards set sku_number=#{number} where sku=#{sku} and user_code = #{userCode}")
    Integer updateGoodsCartds(@Param("userCode") String userCode,
                              @Param("sku") String sku,
                              @Param("number") int number);

    @Select("select * from goods_cards where user_code = #{userCode} and sku = #{sku}")
    GoodsCardsBean getUserGoodsCartItem(@Param("userCode") String userCode, @Param("sku") String sku);
}

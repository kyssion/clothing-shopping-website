package org.kys.clothing.feginHystrix;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.fegin.GoodsCardsFegin;
import org.kys.clothing.goodsCart.GoodsCardsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoodsCardsHystrix implements GoodsCardsFegin {
    private static final Logger logger = LoggerFactory.getLogger(GoodsCardsHystrix.class);

    @Override
    public List<GoodsCardsBean> getAllUserGoods(String userCode) {
        logger.error("当前商品查询发生异常请重试");
        return null;
    }
}

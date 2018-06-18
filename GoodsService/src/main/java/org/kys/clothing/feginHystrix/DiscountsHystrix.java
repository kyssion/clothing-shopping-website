package org.kys.clothing.feginHystrix;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.fegin.DiscountsFegin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DiscountsHystrix implements DiscountsFegin {
    private static final Logger logger = LoggerFactory.getLogger(DiscountsHystrix.class);

    @Override
    public List<GoodsBean> getDiscountsGoods(int page, int pageSize) {
        logger.error("商品优惠查询异常:时间+{}",new Date().getTime());
        return new ArrayList<>();
    }

    @Override
    public DiscountsBean getDiscountsInformationBySku(String sku) {
        logger.error("商品优惠信息查询异常：+{}",new Date().getTime());
        return null;
    }
}

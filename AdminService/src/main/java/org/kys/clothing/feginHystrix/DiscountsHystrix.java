package org.kys.clothing.feginHystrix;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.fegin.DiscountsFegin;
import org.kys.clothing.returnI.DiscountBeanList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiscountsHystrix implements DiscountsFegin {
    private static final Logger logger = LoggerFactory.getLogger(DiscountsHystrix.class);

    @Override
    public List<GoodsBean> getDiscountsGoods(int page, int pageSize) {
        return new ArrayList<>();
    }

    @Override
    public DiscountsBean getDiscountsInformationBySku(String sku) {
        logger.error("cuowu");
        return null;
    }

    @Override
    public DiscountBeanList getDiscount(String sku, int page) {
        return null;
    }

    @Override
    public boolean updateDiscount(String sku, String info, int money) {
        return false;
    }
}

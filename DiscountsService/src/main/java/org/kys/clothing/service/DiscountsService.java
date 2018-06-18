package org.kys.clothing.service;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.dataQuery.DiscountsClothingQuery;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.inventroy.InventoryBean;
import org.kys.clothing.returnI.DiscountBeanList;
import org.kys.clothing.returnI.InventoryBeanList;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiscountsService {

    @Autowired
    DiscountsClothingQuery discountsClothingQuery;

    public List<GoodsBean> getAllCountsService(int page, int pageSize) {
        List<GoodsBean> list = discountsClothingQuery.selectAllDiscountsClothing(page - 1, pageSize);
        return list;
    }

    public DiscountsBean getDiscountsInformationBySku(String sku) {
        return discountsClothingQuery.getDiscountsInformationByGoodsId(sku);
    }

    public GoodsBean getGoodsInfoWithDiscounts(String sku) {
        return discountsClothingQuery.getGoodsInfoWithDiscounts(sku);
    }

    public DiscountBeanList getDiscount(String sku, int page) {
        int allpage = 0;
        List<DiscountsBean> list;
        if (sku == null) {
            allpage = discountsClothingQuery.getdisBeanAll().size();
            list = discountsClothingQuery.getdisBeanList(page * 20, 20);
        } else {
            allpage = discountsClothingQuery.getdisByskuall(sku).size();
            list = discountsClothingQuery.getdisBysku(page * 20, 20, sku);
        }

        return new DiscountBeanList(page + 1, allpage % 20 == 0 ? allpage / 20 : allpage / 20 + 1, list);
    }

    public boolean updateDiscount(String sku, String info, int money) {
        int a = discountsClothingQuery.update(sku, info, money);
        return a > 0 ? true : false;
    }

    public boolean addNewDiscount(String sku, String info, int money) {
        long i = new Date().getTime();
        int a = discountsClothingQuery.insert(sku, "1", i, money, info);
        return a > 0 ? true : false;
    }
}

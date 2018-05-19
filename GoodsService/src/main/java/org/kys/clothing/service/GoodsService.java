package org.kys.clothing.service;

import org.kys.clothing.GoodsBean;
import org.kys.clothing.dataQuery.GoodsDataQuery;
import org.kys.clothing.discounts.DiscountsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDataQuery goodsDataQuery;

    public List<GoodsBean> getAllGoodsInfo(int page, int pageSize) {
        List<GoodsBean> goodsList= goodsDataQuery.SelectAllGoods(page,pageSize);
        return goodsList;
    }

    public GoodsBean getGoodsInformation(DiscountsBean discountsBean, String sku) {
        GoodsBean goodsBean = goodsDataQuery.getGoodsBySku(sku);
        if (goodsBean!=null&&discountsBean!=null){
            goodsBean.setDiscounts(true);
            goodsBean.setDiscountsMoney(discountsBean.getDiscountsMoney());
        }
        return goodsBean;
    }
}

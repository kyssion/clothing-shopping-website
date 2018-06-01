package org.kys.clothing.service;

import org.kys.clothing.Good.GoodsBean;
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
        List<GoodsBean> goodsList= goodsDataQuery.SelectAllGoods(page*pageSize,pageSize);
        return goodsList;
    }

    public GoodsBean getGoodsInformation(DiscountsBean discountsBean, String sku) {
        GoodsBean goodsBean = goodsDataQuery.getGoodsBySku(sku);
        if (goodsBean!=null&&discountsBean!=null){
            goodsBean.setDiscount(true);
            goodsBean.setDiscountMoney(discountsBean.getDiscountsMoney());
        }
        return goodsBean;
    }

    public List<GoodsBean> getAllGoodsInfobycategration(int i, int pageSize, int categration,int c) {
        return goodsDataQuery.SelectAllGoodsbyCategration(i*pageSize,pageSize,categration,c);
    }
    public List<GoodsBean> getAllFGoodsInfobycategration(int i, int pageSize, int categration) {
        return goodsDataQuery.SelectFAllGoodsbyCategration(i*pageSize,pageSize,categration);
    }

    public Integer getAllGoodsInfoNumber(int categration, int c) {
        return goodsDataQuery.getAllGoodsInfoNumber(categration,c);
    }

    public List<GoodsBean> getAllgoods(int number) {
        return goodsDataQuery.getAllgoods(number*20);
    }

    public boolean deleteGoods(String sku) {
        return goodsDataQuery.deleteSku(sku);
    }

    public boolean insert(GoodsBean goodsBean) {
        goodsDataQuery.deleteSku(goodsBean.getSku());
        return goodsDataQuery.insert(goodsBean);
    }
}

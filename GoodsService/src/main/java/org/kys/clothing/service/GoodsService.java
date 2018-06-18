package org.kys.clothing.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.dataQuery.GoodsDataQuery;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.inventroy.InventoryBean;
import org.kys.clothing.returnI.GoodsBeanList;
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

    public GoodsBean getGoodsInformation(DiscountsBean discountsBean, InventoryBean inventoryBean, String sku) {
        GoodsBean goodsBean = goodsDataQuery.getGoodsBySku(sku);
        if (goodsBean!=null&&discountsBean!=null){
            goodsBean.setDiscount(true);
            goodsBean.setDiscountMoney(discountsBean.getDiscountsMoney());
            goodsBean.setStyle(discountsBean.getStyle());
        }
        if (goodsBean!=null&&inventoryBean!=null){
            goodsBean.setInventory((int) inventoryBean.getInventoryNumber());
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

    public GoodsBeanList getAdminGoodsList(int number, String sku, String categration, String fcategration) {
        String sql = "select * from goods";
        boolean first=true;
        if (sku!=null&&!sku.equals("")||
                categration!=null&&!categration.equals("")||
                fcategration!=null&&!fcategration.equals("")){
            sql+=" where";
        }
        if (sku!=null&&!sku.equals("")){
            if (!first){
                sql+=" and";
            }
            sql+=" sku='"+sku+"'"+" or "+"goods_name like '%"+sku+"%'";
            first=false;
        }
        if (categration!=null&&!categration.equals("")){
            if (!first){
                sql+=" and";
            }
            sql+=" categroy_id="+categration+"";
            first=false;
        }
        if (fcategration!=null&&!fcategration.equals("")){
            if (!first){
                sql+=" and";
            }
            sql+=" f_categration_id="+fcategration+"";
            first=false;
        }
        int all=goodsDataQuery.adminSelect(sql).size();
        sql+=" limit "+number*20+",20";
        return new GoodsBeanList(number+1,all%20==0?all/20:all/20+1,goodsDataQuery.adminSelect(sql));
    }
}

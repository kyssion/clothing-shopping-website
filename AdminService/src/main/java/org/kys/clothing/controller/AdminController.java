package org.kys.clothing.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.bouncycastle.cert.ocsp.Req;
import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.fegin.*;
import org.kys.clothing.inventroy.InventoryBean;
import org.kys.clothing.returnI.DiscountBeanList;
import org.kys.clothing.returnI.GoodsBeanList;
import org.kys.clothing.returnI.InventoryBeanList;
import org.kys.clothing.returnI.OrderBeanList;
import org.kys.clothing.user.UserBean;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    InventoryFegin inventoryFegin;

    @Autowired
    UserFegin userFegin;

    @Autowired
    GoodsFegin goodsFegin;

    @Autowired
    DiscountsFegin discountsFegin;

    @Autowired
    OrderFegin orderFegin;

    @RequestMapping("get_all_goods")
    public GoodsBeanList getAllgoods(@RequestParam("page") int number,
                                     @RequestParam("sku") @Nullable String sku,
                                     @RequestParam("c") @Nullable String categration,
                                     @RequestParam("fc") @Nullable String fcategration) {
        number = number >= 1 ? number - 1 : 0;
        return goodsFegin.getAdminGoodsList(number, sku, categration, fcategration);
    }

    @RequestMapping("delete_goods")
    public boolean deleteGoods(@RequestParam("sku") String sku) {
        return goodsFegin.deleteGoodsBean(sku);
    }

    @Transactional
    @RequestMapping(value = "insert_goods", method = RequestMethod.POST)
    public boolean insert(@RequestParam("goods_name") String goodsName, @RequestParam("cat") String cateId,
                          @RequestParam("fcat") String fcateId, @RequestParam("img") String img, @RequestParam("money") int money,
                          @RequestParam("info") String info) {
        String cates = "";
        String fcates = "";
        switch (cateId) {
            case "0":
                cates = "衬衫";
                break;
            case "1":
                cates = "大衣";
                break;
            case "2":
                cates = "T恤衫";
                break;
            case "3":
                cates = "短裤";
                break;
            case "4":
                cates = "卫衣";
                break;
            case "5":
                cates = "平底鞋";
                break;
            case "6":
                cates = "长裤";
                break;
        }
        switch (fcateId) {
            case "0":
                fcates = "男装";
                break;
            case "1":
                fcates = "女装";
                break;
            case "2":
                fcates = "休闲装";
                break;
            case "3":
                fcates = "运动装";
                break;
        }
        GoodsBean goodsBean = new GoodsBean();
        goodsBean.setGoodsName(goodsName);
        goodsBean.setSku("" + new Date().getTime() + "" + (int) Math.random() * 100);
        goodsBean.setCategroyId(cateId);
        goodsBean.setCategroyName(cates);
        goodsBean.setfCategrationId(fcateId);
        goodsBean.setfCategrationName(fcates);
        goodsBean.setInformation(info);
        goodsBean.setMoney(money);
        goodsBean.setImg(img);
        System.out.println(JSONObject.toJSON(goodsBean));
        goodsFegin.insertGoodsBean(goodsBean);
        return true;
    }


    @RequestMapping("get_inventory")
    public InventoryBeanList getInventoryBeanList(@RequestParam("page") int page, @RequestParam("sku") @Nullable String sku) {
        page = page >= 1 ? page - 1 : page;
        return inventoryFegin.getInventoryBeanList(page, sku);
    }


    @RequestMapping("updateInventory")
    public int updateInventory(@RequestParam("sku") String sku, @RequestParam("number") int number) {
        return inventoryFegin.updateInventory(sku, number);
    }


    @RequestMapping("get_discount")
    public DiscountBeanList getDiscountBean(@RequestParam("page") int page, @RequestParam("sku") @Nullable String sku) {
        page = page >= 1 ? page - 1 : page;
        return discountsFegin.getDiscount(sku, page);
    }

    @RequestMapping("update_discount")
    public boolean updateDicount(@RequestParam("sku") String sku, @RequestParam("info") String info, @RequestParam("money") int money) {
        return discountsFegin.updateDiscount(sku, info, money);
    }


    @RequestMapping("select_order")
    public OrderBeanList getAllOrder(@RequestParam("page") int page, @RequestParam("order_id") String orderId, @RequestParam("userCode") String userCode) {
        return orderFegin.getAdminGetOrder(page, orderId, userCode);
    }

    @RequestMapping("change_order_status")
    public boolean changeOrderStatus(@RequestParam("orderId") String orderId,
                                     @RequestParam("status") int status) {
        return orderFegin.changeOrderStatus(orderId, status);
    }
}


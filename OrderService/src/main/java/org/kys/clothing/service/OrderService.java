package org.kys.clothing.service;

import com.alibaba.fastjson.JSONObject;
import org.kys.clothing.dataQuery.OrderDataQuery;
import org.kys.clothing.fegin.GoodsCardsFegin;
import org.kys.clothing.goodsCart.GoodsCardsBean;
import org.kys.clothing.order.OrderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDataQuery orderDataQuery;

    @Autowired
    GoodsCardsFegin goodsCardsFegin;

    public boolean createOrderByUserCode(String userCode) {
        List<GoodsCardsBean> goodsCardsBeans = goodsCardsFegin.getAllUserGoods(userCode);
        String goodsCardsBeansText = JSONObject.toJSONString(goodsCardsBeans);
        OrderBean orderBean = new OrderBean();
        orderBean.setAddTime(new Date().getTime());
        orderBean.setChangeTime(new Date().getTime());
        orderBean.setGoodsInfo(goodsCardsBeansText);
        orderBean.setOrderId(new Date().getTime() + "-" + userCode + "" + (int) (Math.random() * 100));
        orderBean.setStatus(1);
        orderBean.setUserCode(userCode);
        int a = orderDataQuery.insertOrderInfo(orderBean);
        return a > 0 ? true : false;
    }
}

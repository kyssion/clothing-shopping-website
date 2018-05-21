package org.kys.clothing.service;

import com.alibaba.fastjson.JSONObject;
import org.kys.clothing.dataQuery.OrderDataQuery;
import org.kys.clothing.fegin.GoodsCardsFegin;
import org.kys.clothing.fegin.InventoryFegin;
import org.kys.clothing.goodsCart.GoodsCardsBean;
import org.kys.clothing.inventroy.InventoryBean;
import org.kys.clothing.order.OrderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDataQuery orderDataQuery;

    @Autowired
    GoodsCardsFegin goodsCardsFegin;

    @Autowired
    InventoryFegin inventoryFegin;

    @Transactional
    public boolean createOrderByUserCode(String userCode) {
        List<GoodsCardsBean> goodsCardsBeans = goodsCardsFegin.getAllUserGoods(userCode);

        List<String> skus= this.getSkuList(goodsCardsBeans);
        List<InventoryBean> inventoryBeans =
                inventoryFegin.getInventoryBeans(skus);
        GoodsCardsBean goodsCardsBean = new GoodsCardsBean();
        for (InventoryBean bean:inventoryBeans){
            int inventory = 0;
            for (GoodsCardsBean bean1:goodsCardsBeans){
                if (bean1.getSku().equals(bean.getSku())){
                    goodsCardsBean=bean1;
                    break;
                }
            }
            inventory=(int)bean.getInventoryNumber()-(int)goodsCardsBean.getSkuNumber();
            if (inventory<0){
                return false;
            }
            bean.setInventoryNumber(inventory);
        }

        String goodsCardsBeansText = JSONObject.toJSONString(goodsCardsBeans);
        OrderBean orderBean = new OrderBean();
        orderBean.setAddTime(new Date().getTime());
        orderBean.setChangeTime(new Date().getTime());
        orderBean.setGoodsInfo(goodsCardsBeansText);
        orderBean.setOrderId(new Date().getTime() + "-" + userCode + "" + (int) (Math.random() * 100));
        orderBean.setStatus(1);
        orderBean.setUserCode(userCode);

        int a = orderDataQuery.insertOrderInfo(orderBean);
        int b = inventoryFegin.updateInventory(inventoryBeans);

        return a > 0&&b>0 ? true : false;
    }
    public List<String> getSkuList(List<GoodsCardsBean> goodsCardsBeans){
        List<String> skus = new ArrayList<>();
        for (GoodsCardsBean bean:goodsCardsBeans){
            skus.add(bean.getSku());
        }
        return skus;
    }

    public List<OrderBean> getOrderInformation(String userCode,String orderId) {
        List<OrderBean> orderBeans = null;
        if (orderId==null){
            orderBeans= orderDataQuery.getOrderListByUserAndId(userCode,orderId);
        }else{
            orderBeans= orderDataQuery.getOrderListByUser(userCode);
        }
        for(OrderBean bean:orderBeans){
            List<GoodsCardsBean> cardsBeans = JSONObject.parseArray(bean.getGoodsInfo(),GoodsCardsBean.class);
            bean.setGoodsCardsBeans(cardsBeans);
        }
        return orderBeans;
    }

    public boolean changeOrderStatus(String orderId, int status) {
        return orderDataQuery.changeOrderStatus(orderId,status);
    }
}

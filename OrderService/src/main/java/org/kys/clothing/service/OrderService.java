package org.kys.clothing.service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Ordering;
import org.kys.clothing.dataQuery.OrderDataQuery;
import org.kys.clothing.fegin.GoodsCardsFegin;
import org.kys.clothing.fegin.InventoryFegin;
import org.kys.clothing.goodsCart.GoodsCardsBean;
import org.kys.clothing.inventroy.InventoryBean;
import org.kys.clothing.order.OrderBean;
import org.kys.clothing.returnI.OrderBeanList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
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
    public String createOrderByUserCode(String userCode) {
        List<GoodsCardsBean> goodsCardsBeans = goodsCardsFegin.getAllUserGoods(userCode);

        List<String> skus= this.getSkuList(goodsCardsBeans);
        List<InventoryBean> inventoryBeans =
                inventoryFegin.getInventoryBeans(skus);
        for (GoodsCardsBean cardsBean:goodsCardsBeans){
            boolean b=true;
            for (InventoryBean bean:inventoryBeans){
                if(bean.getSku().equals(cardsBean.getSku())){
                    b=false;
                    int a= (int) (bean.getInventoryNumber()-cardsBean.getSkuNumber());
                    if (a<0){
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("code",false);
                        jsonObject.put("name",cardsBean.getGoodsName());
                        jsonObject.put("sku",cardsBean.getSku());
                        return jsonObject.toJSONString();
                    }
                    bean.setInventoryNumber(a);
                }
            }
            if (b){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",false);
                jsonObject.put("name",cardsBean.getGoodsName());
                return jsonObject.toJSONString();
            }
        }

        //总金额教研
        int allMoney = 0;
        for (GoodsCardsBean bean:goodsCardsBeans){
            bean.setAllMoney((int) (bean.getMoney()*bean.getSkuNumber()-bean.getDiscount()*bean.getSkuNumber()));
            allMoney+=bean.getAllMoney();
        }
        String goodsCardsBeansText = JSONObject.toJSONString(goodsCardsBeans);
        OrderBean orderBean = new OrderBean();
        orderBean.setAddTime(new Date().getTime());
        orderBean.setChangeTime(new Date().getTime());
        orderBean.setGoodsInfo(goodsCardsBeansText);
        orderBean.setOrderId(new Date().getTime() + "-" + userCode + "" + (int) (Math.random() * 100));
        orderBean.setStatus(1);
        orderBean.setUserCode(userCode);
        orderBean.setAllMoney(allMoney);

        int a = orderDataQuery.insertOrderInfo(orderBean);
        int b = inventoryFegin.updateInventory(inventoryBeans);
        int c = orderDataQuery.deleteGoodsCardsInfo(userCode);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",true);
        return jsonObject.toJSONString();
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
        if (orderId!=null){
            orderBeans= orderDataQuery.getOrderListByUserAndId(userCode,orderId);
        }else{
            orderBeans= orderDataQuery.getOrderListByUser(userCode);
        }
        for(OrderBean bean:orderBeans){
            List<GoodsCardsBean> cardsBeans = JSONObject.parseArray(bean.getGoodsInfo(),GoodsCardsBean.class);
            bean.setGoodsCardsBeans(cardsBeans);
            bean.setGoodsInfo(null);
        }
        return orderBeans;
    }

    public boolean changeOrderStatus(String orderId, int status) {
        String statusName="";
        switch (status){
            case 1:statusName="下单成功";break;
            case 2:statusName="待发货";break;
            case 3:statusName="已发貨";break;
            case 4:statusName="已完成";break;
            case 0:statusName="取消";break;

        }
        return orderDataQuery.changeOrderStatus(orderId,status,statusName);
    }

    public boolean deleteOrder(String orderId) {
        return orderDataQuery.deleteOrder(orderId);
    }

    public OrderBeanList getAdminGetOrder(int page, String orderId, String userCode) {
        List<OrderBean> list = null;
        if (orderId!=null&&userCode!=null){
            list = orderDataQuery.getOrderListByUserAndId(userCode, orderId);
        }else if (orderId!=null){
            list = orderDataQuery.getOrderListByid(orderId);
        }else if(userCode!=null){
            list=orderDataQuery.getOrderListByUser(userCode);
        }else{
            list= orderDataQuery.getAllOrder();
        }
        if (page*20>=list.size()){
            list=new ArrayList<>();
        }else if ((page+1)*20>=list.size()){
            list=list.subList(page*20,list.size());
        }else{
            list=list.subList(page*20,(page+1)*20);
        }
        return new OrderBeanList(page+1,list.size(),list);
    }
}

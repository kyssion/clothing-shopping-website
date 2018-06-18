package org.kys.clothing.service;

import org.kys.clothing.dataQuery.GoodsCartQuery;
import org.kys.clothing.goodsCart.GoodsCardsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class GoodsCartService {
    @Autowired
    GoodsCartQuery goodsCartQuery;

    public List<GoodsCardsBean> getUserGoodsCart(String userCode) {
        List<GoodsCardsBean> list = goodsCartQuery.getUserGoodsCart(userCode);
        for (GoodsCardsBean bean:list){
            bean.setAllMoney((int) (bean.getMoney()*bean.getSkuNumber()-bean.getDiscount()*bean.getSkuNumber()));
        }
        return list;
    }

    public boolean removeGoodsItem(String userCode) {
        Integer i = goodsCartQuery.removeGoodsItembyUserCode(userCode);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

//    public boolean removeGoodsItem(String userCode, String sku) {
//        Integer i = goodsCartQuery.removeGoodsItemByCodeAndSku(userCode, sku);
//        if (i > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    @Transactional
    public boolean updateUserGoodsCards(String userCode, String sku, int number) {
        Integer iii = goodsCartQuery.updateGoodsCartds(userCode, sku, number);
        int a = iii == null ? 0 : 1;
        return a > 0 ? true : false;
    }

    public boolean addGoodsInCards(String sku, String userCode, int number,String color,String size,int discount,String style) {
        GoodsCardsBean goodsCardsBean = goodsCartQuery.getUserGoodsCartItem(userCode, sku,size,color);
        if (goodsCardsBean == null||!(goodsCardsBean.getSize().equals(size))||
                !goodsCardsBean.getColor().equals(color)) {
            goodsCardsBean= new GoodsCardsBean();
            goodsCardsBean.setSku(sku);
            goodsCardsBean.setSkuNumber(number);
            goodsCardsBean.setCardsId(userCode + new Date().getTime());
            goodsCardsBean.setUserCode(userCode);
            goodsCardsBean.setColor(color);
            goodsCardsBean.setSize(size);
            goodsCardsBean.setDiscount(discount);
            goodsCardsBean.setDiscountStyle(style==null?"暂无优惠":style);
            Integer i = goodsCartQuery.addGoodsItem(goodsCardsBean);
            return i==null||i==0?false:true;
        }else{
            return updateUserGoodsCards(userCode,sku,(int)goodsCardsBean.getSkuNumber()+number);
        }
    }

    public boolean deleteGoodsCards(String userCode, String sku,String size,String color) {
        Integer iii = goodsCartQuery.removeGoodsItemByCodeAndSku(userCode, sku,size,color);
        return iii == null || iii == 0 ? false : true;
    }
}

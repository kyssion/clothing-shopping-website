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
        return goodsCartQuery.getUserGoodsCart(userCode);
    }

    public boolean removeGoodsItem(String userCode) {
        Integer i = goodsCartQuery.removeGoodsItembyUserCode(userCode);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean removeGoodsItem(String userCode, String sku) {
        Integer i = goodsCartQuery.removeGoodsItemByCodeAndSku(userCode, sku);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean updateUserGoodsCards(String userCode, String sku, int number) {
        Integer iii = goodsCartQuery.updateGoodsCartds(userCode, sku, number);
        int a = iii == null ? 0 : 1;
        return a > 0 ? true : false;
    }

    public boolean addGoodsInCards(String sku, String userCode, int number,String color,String size) {
        GoodsCardsBean goodsCardsBean = goodsCartQuery.getUserGoodsCartItem(userCode, sku);

        if (goodsCardsBean == null||!(goodsCardsBean.getSize().equals(size))||
                !goodsCardsBean.getColor().equals(color)) {
            goodsCardsBean= new GoodsCardsBean();
            goodsCardsBean.setSku(sku);
            goodsCardsBean.setSkuNumber(number);
            goodsCardsBean.setCardsId(userCode + new Date().getTime());
            goodsCardsBean.setUserCode(userCode);
            goodsCardsBean.setColor(color);
            goodsCardsBean.setSize(size);
            Integer i = goodsCartQuery.addGoodsItem(goodsCardsBean);
            return i==null||i==0?false:true;
        }else{
            return updateUserGoodsCards(userCode,sku,(int)goodsCardsBean.getSkuNumber()+number);
        }
    }

    public boolean deleteGoodsCards(String userCode, String sku) {
        Integer iii = goodsCartQuery.removeGoodsItemByCodeAndSku(userCode, sku);
        return iii == null || iii == 0 ? false : true;
    }
}

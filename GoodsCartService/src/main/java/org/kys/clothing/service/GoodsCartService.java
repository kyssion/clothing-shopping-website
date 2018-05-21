package org.kys.clothing.service;

import org.kys.clothing.Good.GoodsBean;
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
    public boolean removeGoodsItem(String userCode){
        Integer i = goodsCartQuery.removeGoodsItem(userCode);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean removeGoodsItem(String userCode,String sku){
        Integer i = goodsCartQuery.removeGoodsItem(userCode,sku);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }
    @Transactional
    public boolean updateUserGoodsCards(String sku,String userCode, List<GoodsCardsBean> goodsList) {
        int a=0;
        for (GoodsCardsBean bean:goodsList){
            this.removeGoodsItem(userCode,sku);
            a+=goodsCartQuery.addGoodsItem(bean);
        }
        return a>0?true:false;
    }

    public int addGoodsInCards(String sku,String userCode) {
        GoodsCardsBean goodsCardsBean =
                new GoodsCardsBean();
        goodsCardsBean.setSku(sku);
        goodsCardsBean.setSkuNumber(1);
        goodsCardsBean.setCardsId(userCode+new Date().getTime());
        goodsCardsBean.setUserCode(userCode);
        return goodsCartQuery.addGoodsItem(goodsCardsBean);
    }

}

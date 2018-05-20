package org.kys.clothing.service;

import org.kys.clothing.dataQuery.GoodsCartQuery;
import org.kys.clothing.goodsCart.GoodsCardsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public boolean updateUserGoodsCards(String userCode, List<GoodsCardsBean> goodsList) {
        this.removeGoodsItem(userCode);
        int a=0;
        for (GoodsCardsBean bean:goodsList){
            a+=goodsCartQuery.addGoodsItem(bean);
        }
        return a>0?true:false;
    }
}

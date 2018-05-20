package org.kys.clothing.controller;

import org.kys.clothing.fegin.UserFegin;
import org.kys.clothing.goodsCart.GoodsCardsBean;
import org.kys.clothing.service.GoodsCartService;
import org.kys.clothing.user.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsCartController {
    @Autowired
    GoodsCartService goodsCartService;

    @Autowired
    UserFegin userFegin;

    @RequestMapping("get_all_user_goods")
    public List<GoodsCardsBean> getGoodsCartInfo(@RequestParam("userCode")String userCode,
                                                 @RequestParam("userPassword")@Nullable String userPassword){
        return goodsCartService.getUserGoodsCart(userCode);
    }

    @RequestMapping("update_user_goods_card")
    public boolean changeGoddsCardsItem(@RequestBody Param param){
        return goodsCartService.updateUserGoodsCards(param.getUserCode(),param.getGoodsList());
    }
}
class Param{
    String userCode;
    List<GoodsCardsBean> goodsList;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<GoodsCardsBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsCardsBean> goodsList) {
        this.goodsList = goodsList;
    }
}

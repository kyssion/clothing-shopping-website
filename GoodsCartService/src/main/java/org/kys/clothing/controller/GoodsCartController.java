package org.kys.clothing.controller;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.fegin.DiscountFegin;
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

    @Autowired
    DiscountFegin discountFegin;
    /**
     * 获得用户所有的购物信息
     * @param userCode
     * @param userPassword
     * @return
     */
    @RequestMapping("get_all_user_goods")
    public List<GoodsCardsBean> getGoodsCartInfo(@RequestParam("userCode")String userCode,
                                                 @RequestParam("userPassword")@Nullable String userPassword){
        return goodsCartService.getUserGoodsCart(userCode);
    }

    /**
     * 修改购物车的信息
     * @param param
     * @return
     */
    @RequestMapping("update_user_goods_card")
    public boolean changeGoddsCardsItem(@RequestBody Param param){
        return goodsCartService.updateUserGoodsCards(param.getSku(),param.getUserCode(),param.getGoodsList());
    }


    /**
     * 添加进购物车注意购物车中并不需要添加商品信息
     * @param sku
     * @param userCode
     * @return
     */
    public boolean addGoodsInGoodsCards(@RequestParam("sku")String sku,@RequestParam("userCode")String userCode){
        int a=goodsCartService.addGoodsInCards(sku,userCode);
        return a>0?true:false;
    }
}
class Param{
    String userCode;
    String sku;
    List<GoodsCardsBean> goodsList;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

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

package org.kys.clothing.controller;

import org.kys.clothing.fegin.DiscountFegin;
import org.kys.clothing.fegin.UserFegin;
import org.kys.clothing.goodsCart.GoodsCardsBean;
import org.kys.clothing.service.GoodsCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
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
     * @param
     * @return
     */
    @RequestMapping(value = "update_user_goods_card",method = RequestMethod.GET)
    public boolean changeGoddsCardsItem(@RequestParam("userCode")String userCode,@RequestParam("sku")String sku,
                                        @RequestParam("number")int number){
        return goodsCartService.updateUserGoodsCards(userCode,sku,number);
    }


    @RequestMapping(value = "delete_goods_carts",method = RequestMethod.GET)
    public boolean delteteGoodsCartsItem(@RequestParam("userCode")String userCode,
                                         @RequestParam("sku")String sku,@RequestParam("size")String size,
                                         @RequestParam("color")String color){
        return goodsCartService.deleteGoodsCards(userCode,sku,size,color);
    }

    /**
     * 添加进购物车注意购物车中并不需要添加商品信息
     * @param sku
     * @param userCode
     * @return
     */
    @RequestMapping("add_goods_in_cards")
    public boolean addGoodsInGoodsCards(@RequestParam("sku")String sku,@RequestParam("userCode")String userCode,
                                        @RequestParam("number")int number,@RequestParam("color")String color,
                                        @RequestParam("size")String size,@RequestParam("discount")@Nullable int discount
            ,@RequestParam("discount_style")@Nullable String style){
        return goodsCartService.addGoodsInCards(sku,userCode,number,color,size,discount,style);
    }
}
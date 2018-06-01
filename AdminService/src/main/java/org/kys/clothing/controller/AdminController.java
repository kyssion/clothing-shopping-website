package org.kys.clothing.controller;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.fegin.GoodsFegin;
import org.kys.clothing.fegin.InventoryFegin;
import org.kys.clothing.fegin.UserFegin;
import org.kys.clothing.inventroy.InventoryBean;
import org.kys.clothing.user.UserBean;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    InventoryFegin inventoryFegin;

    @Autowired
    UserFegin userFegin;

    @Autowired
    GoodsFegin goodsFegin;



    @RequestMapping("all_user")
    public List<UserBean> selectAllUser(){
        return userFegin.getAllUserBean();
    }

    @RequestMapping("delete_user")
    public boolean deleteUser(@RequestParam("user_code")String userCode){
        return userFegin.deleteUserBean(userCode);
    }

    @RequestMapping("get_all_goods")
    public List<GoodsBean> getAllgoods(@RequestParam("page")int number){
        number = number>=1?number-1:0;
        return goodsFegin.getAllGoodsBean(number);
    }

    @RequestMapping("updateInventory")
    public int updateInventory(@RequestParam("sku")String sku,@RequestParam("number")int number){
        return inventoryFegin.updateInventory(sku,number);
    }


    @RequestMapping("delete_goods")
    public boolean deleteGoods(@RequestParam("sku")String sku){
        return goodsFegin.deleteGoodsBean(sku);
    }

    @Transactional
    @RequestMapping(value = "insert_goods",method = RequestMethod.POST)
    public boolean insert(@RequestBody GoodsBean bean){
        inventoryFegin.insertInventory(bean.getSku(),bean.getInventory());
        goodsFegin.insertGoodsBean(bean);
        return true;
    }

}


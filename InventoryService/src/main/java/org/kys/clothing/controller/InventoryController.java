package org.kys.clothing.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.xs.LSInputList;
import org.kys.clothing.inventroy.InventoryBean;
import org.kys.clothing.returnI.InventoryBeanList;
import org.kys.clothing.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    /**
     * 通过sku获得商品的库存
     * @param sku
     * @return
     */
    @RequestMapping("get_inventory_by_sku")
    public InventoryBean getInventoryBean(@RequestParam("sku") String sku){
        return inventoryService.getInventoryBean(sku);
    }

    /**
     * sku 数组批量获取
     * @param skus
     * @return
     */
    @RequestMapping(value = "get_inventory_list_by_sku_list",method = RequestMethod.POST)
    public List<InventoryBean> getInventoryBeansByskuList(@RequestBody List<String> skus){
        return inventoryService.getInventoryBeans(skus);
    }

    @RequestMapping("admin_select_inventory")
    public InventoryBeanList getInventoryBeanList(@RequestParam("page")int page,@RequestParam("sku")@Nullable String sku){
        if (sku.equals("")){
            sku=null;
        }
        return inventoryService.getInventyBeanList(page,sku);
    }


    /**
     * 批量添加库存
     * @param beans
     * @return
     */
    @RequestMapping(value = "insert_inventory_list",method = RequestMethod.POST)
    public int insertInventoryList(@RequestBody List<InventoryBean> beans){
        return inventoryService.insertInventory(beans);
    }

    @RequestMapping(value = "insert_inventroy",method = RequestMethod.GET)
    public int insertInventory(@RequestParam("sku")String sku,@RequestParam("number")int number){
        int a=inventoryService.insertInventoryByone(sku,number);
        return a;
    }


    /**
     * 升级inventory
     * @param sku
     * @param number
     * @return
     */
    @RequestMapping(value = "update_inventory",method = RequestMethod.GET)
    public int updateInventory(@RequestParam("sku")String sku,@RequestParam("number")int number){
        List<InventoryBean> list = new ArrayList<>();
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setInventoryNumber(number);
        inventoryBean.setSku(sku);
        inventoryBean.setStatus(1);
        list.add(inventoryBean);
        int a=inventoryService.updateInventory(list);
        return a;
    }

    @RequestMapping("delete_inventory")
    public int deleteInventory(@RequestParam("sku")String sku){
        return inventoryService.deleteInventory(sku);
    }

    /**
     * 批量修改库存
     * @param beans
     * @return
     */
    @RequestMapping(value = "update_inventory_list",method = RequestMethod.POST)
    public int updateInventoryList(@RequestBody List<InventoryBean> beans){
        return inventoryService.updateInventory(beans);
    }
}

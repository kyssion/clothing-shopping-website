package org.kys.clothing.controller;

import org.kys.clothing.inventroy.InventoryBean;
import org.kys.clothing.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping("get_inventory_by_sku")
    public InventoryBean getInventoryBean(@RequestParam("sku") String sku){
        return inventoryService.getInventoryBean(sku);
    }
    @RequestMapping(value = "get_inventory_list_by_sku_list",method = RequestMethod.POST)
    public List<InventoryBean> getInventoryBeansByskuList(@RequestBody List<String> skus){
        return inventoryService.getInventoryBeans(skus);
    }

    @RequestMapping(value = "insert_inventory_list",method = RequestMethod.POST)
    public int insertInventoryList(@RequestBody List<InventoryBean> beans){
        return inventoryService.insertInventory(beans);
    }

    @RequestMapping(value = "update_inventory_list",method = RequestMethod.POST)
    public int updateInventoryList(@RequestBody List<InventoryBean> beans){
        return inventoryService.insertInventory(beans);
    }
}

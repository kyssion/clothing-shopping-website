package org.kys.clothing.fegin;

import com.sun.org.apache.regexp.internal.RE;
import org.kys.clothing.inventroy.InventoryBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Component
@FeignClient(value = "inventory-service")
public interface InventoryFegin {
    @RequestMapping(value = "insert_inventory_list",method = RequestMethod.POST)
    int insertInventoryList(List<InventoryBean> beans);

    @RequestMapping(value = "get_inventory_list_by_sku_list",method=RequestMethod.POST)
    List<InventoryBean> selectInventor(List<String> sku);

    @RequestMapping(value = "delete_inventory")
    boolean deleteInventory(@RequestParam("sku") String sku);

    @RequestMapping(value = "insert_inventroy",method = RequestMethod.GET)
    int insertInventory(@RequestParam("sku")String sku,@RequestParam("number")int number);

    @RequestMapping(value = "update_inventory",method = RequestMethod.GET)
    int updateInventory(@RequestParam("sku")String sku,@RequestParam("number")int number);
}

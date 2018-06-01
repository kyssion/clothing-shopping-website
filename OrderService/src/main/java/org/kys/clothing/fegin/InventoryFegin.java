package org.kys.clothing.fegin;

import org.kys.clothing.inventroy.InventoryBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "inventory-service")
public interface InventoryFegin {
    @RequestMapping(value = "get_inventory_list_by_sku_list",method = RequestMethod.POST)
    List<InventoryBean> getInventoryBeans(@RequestBody List<String> skus);

    @RequestMapping(value = "update_inventory_list",method = RequestMethod.POST)
    int updateInventory(@RequestBody List<InventoryBean> inventoryBeans);
}

package org.kys.clothing.feginHystrix;

import org.kys.clothing.fegin.InventoryFegin;
import org.kys.clothing.inventroy.InventoryBean;

import java.util.ArrayList;
import java.util.List;

public class InventoryHystrix implements InventoryFegin {
    @Override
    public List<InventoryBean> getInventoryBeans(List<String> skus) {
        return new ArrayList<>();
    }

    @Override
    public int updateInventory(List<InventoryBean> inventoryBeans) {
        return 0;
    }
}

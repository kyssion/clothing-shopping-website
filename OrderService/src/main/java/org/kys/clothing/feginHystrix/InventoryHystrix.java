package org.kys.clothing.feginHystrix;

import org.kys.clothing.fegin.InventoryFegin;
import org.kys.clothing.inventroy.InventoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class InventoryHystrix implements InventoryFegin {
    Logger logger=LoggerFactory.getLogger(InventoryHystrix.class);
    @Override
    public List<InventoryBean> getInventoryBeans(List<String> skus) {
        logger.error("优惠信息批量查询异常");
        return new ArrayList<>();
    }

    @Override
    public int updateInventory(List<InventoryBean> inventoryBeans) {
        logger.error("优惠信息修改异常");
        return 0;
    }

    @Override
    public InventoryBean getInventoryBean(String sku) {
        logger.error("优惠信息查询异常");
        return null;
    }
}

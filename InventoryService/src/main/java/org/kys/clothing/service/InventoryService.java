package org.kys.clothing.service;

import org.kys.clothing.dataQuary.InventoryQuary;
import org.kys.clothing.inventroy.InventoryBean;
import org.kys.clothing.returnI.InventoryBeanList;
import org.omg.CORBA.DynAnyPackage.InvalidValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryQuary inventoryQuary;

    public InventoryBean getInventoryBean(String sku) {
        return inventoryQuary.getInventoryBean(sku);
    }

    public List<InventoryBean> getInventoryBeans(List<String> skus) {
        String sql = "select * from inventory where sku in(";
        String item = "";
        for (int a = 0; a < skus.size(); a++) {
            item += a == 0 ? "'" + skus.get(a) + "'" : ",'" + skus.get(a) + "'";
        }
        if(item.equals("")){
            item="-100";
        }
        sql += item + ")" + " and status=1";
        return inventoryQuary.getINventoryBeans(sql);
    }

    public int insertInventory(List<InventoryBean> beans) {
        String sql = "insert into inventory (sku, inventory_number, status) values ";
        for (InventoryBean bean : beans) {
            String string = "(";
            string += "'" + bean.getSku() + "'";
            string += ",'" + bean.getInventoryNumber() + "'";
            string += ",'" + bean.getStatus() + "'";
            string += "),";
            sql += string;
        }
        sql = sql.substring(0, sql.length() - 1);
        System.out.println(sql);
        return inventoryQuary.insertInventory(sql);
    }

    public int updateInventory(List<InventoryBean> beans) {
        int a = 0;
        for (InventoryBean bean : beans) {
            a += inventoryQuary.updateInventory(bean);
        }
        if (a == 0) {
            a = insertInventory(beans);
        }
        return a;
    }

    public int insertInventoryByone(String sku, int number) {
        int a = 0;
        InventoryBean inventoryBean = new InventoryBean();
        inventoryBean.setStatus(1);
        inventoryBean.setSku(sku);
        inventoryBean.setInventoryNumber(number);
        List<InventoryBean> list = new ArrayList<>();
        list.add(inventoryBean);
        return insertInventory(list);
    }

    public int deleteInventory(String sku) {
        return inventoryQuary.delete(sku);
    }

    public InventoryBeanList getInventyBeanList(int page, String sku) {
        int allpage = 0;
        List<InventoryBean> list;
        if (sku == null) {
            allpage = inventoryQuary.getInventoryBeanAll().size();
            list = inventoryQuary.getInventyBeanList(page * 20, 20);
        } else {
            allpage = inventoryQuary.getInventoryBeanByskuall(sku).size();
            list = inventoryQuary.getInventoryBeanBysku(page * 20, 20, sku);
        }

        return new InventoryBeanList(page + 1, allpage % 20 == 0 ? allpage / 20 : allpage / 20 + 1,list);
    }
}

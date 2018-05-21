package org.kys.clothing.service;

import org.kys.clothing.dataQuary.InventoryQuary;
import org.kys.clothing.inventroy.InventoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryQuary inventoryQuary;
    public InventoryBean getInventoryBean(String sku) {
        return inventoryQuary.getInventoryBean(sku);
    }

    public List<InventoryBean> getInventoryBeans(List<String> skus) {
        String sql = "select * from inventoryQuary where sku in(";
        String item = "";
        for (int a=0;a<skus.size();a++){
            item+=a==0?"'"+skus.get(a)+"'":",'"+skus.get(a)+"'";
        }
        sql+=item+")"+" and status=1";
        return inventoryQuary.getINventoryBeans(sql);
    }

    public int insertInventory(List<InventoryBean> beans) {
        String sql = "insert into (sku, inventory_number, status) values ";
        for (InventoryBean bean:beans){
            String string = "(";
            string += "'"+bean.getSku()+"'";
            string += ",'"+bean.getInventoryNumber()+"'";
            string += ",'"+bean.getStatus()+"'";
            string +="),";
        }
        sql=sql.substring(0,sql.length()-1);
        return  inventoryQuary.insertInventory(sql);
    }

    public int updateInventory(List<InventoryBean> beans){
        int a=0;
        for (InventoryBean bean:beans){
            a+=inventoryQuary.updateInventory(bean);
        }
        return a;
    }
}

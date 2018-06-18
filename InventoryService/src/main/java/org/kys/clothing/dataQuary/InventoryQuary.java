package org.kys.clothing.dataQuary;

import org.apache.ibatis.annotations.*;
import org.kys.clothing.inventroy.InventoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InventoryQuary {
    @Select("select * from inventory where sku = #{sku}")
    InventoryBean getInventoryBean(String sku);

    @Select("${sql}")
    List<InventoryBean> getINventoryBeans(@Param("sql") String sql);

    @Insert("${sql}")
    int insertInventory(@Param("sql") String sql);

    @Update("update inventory set inventory_number=#{inventoryNumber} where sku = #{sku}")
    int updateInventory(InventoryBean bean);

    @Delete("delete from inventory where sku=#{sku}")
    int delete(@Param("sku") String sku);

    @Select("select goods_name,goods.sku,img,inventory_number from goods left join inventory on goods.sku=inventory.sku;")
    List<InventoryBean> getInventoryBeanAll();

    @Select("select goods_name,goods.sku,img,inventory_number from goods left join inventory on goods.sku=inventory.sku limit #{page},#{pageSize}")
    List<InventoryBean> getInventyBeanList(@Param("page") int page,@Param("pageSize")int pageSize);

    @Select("select goods_name,goods.sku,img,inventory_number from goods left join inventory on goods.sku=inventory.sku where goods.sku=#{sku}")
    List<InventoryBean> getInventoryBeanByskuall(@Param("sku") String sku);

    @Select("select goods_name,goods.sku,img,inventory_number from goods left join inventory on goods.sku=inventory.sku where goods.sku=#{sku} limit #{page},#{pageSize}")
    List<InventoryBean> getInventoryBeanBysku(@Param("page") int page, @Param("pageSize")int pageSize,@Param("sku") String sku);
}

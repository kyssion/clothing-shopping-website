package org.kys.clothing.dataQuery;

import org.apache.ibatis.annotations.*;
import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.inventroy.InventoryBean;
import org.springframework.stereotype.Repository;
import sun.awt.EventListenerAggregate;

import java.util.List;

@Repository
@Mapper
public interface DiscountsClothingQuery {
    @Select("select * from goods g,goods_discounts d where g.sku=d.sku and status !=0 limit #{page},#{pageSize}")
    List<GoodsBean> selectAllDiscountsClothing(@Param("page") int page, @Param("pageSize") int pageSize);

    @Select("select * from goods_discounts where sku=#{sku} and status !=-1")
    DiscountsBean getDiscountsInformationByGoodsId(@Param("sku") String sku);

    @Select("select * from goods g,goods_discounts d where g.sku=d.sku and status !=0 and sku=#{sku} limit")
    GoodsBean getGoodsInfoWithDiscounts(@Param("sku") String sku);

    @Select("select goods.img,goods.goods_name,goods.sku,img,goods_discounts.style,goods_discounts.discounts_money from goods left join goods_discounts on goods.sku=goods_discounts.sku;")
    List<DiscountsBean> getdisBeanAll();

    @Select("select goods.img,goods.goods_name,goods.sku,img,goods_discounts.style,goods_discounts.discounts_money from goods left join goods_discounts on goods.sku=goods_discounts.sku limit #{page},#{pageSize}")
    List<DiscountsBean> getdisBeanList(@Param("page") int i, @Param("pageSize") int i1);

    @Select("select goods.img,goods.goods_name,goods.sku,img,goods_discounts.style,goods_discounts.discounts_money from goods left join goods_discounts on goods.sku=goods_discounts.sku where goods.sku = #{sku}")
    List<DiscountsBean> getdisByskuall(@Param("sku") String sku);

    @Select("select goods.img,goods.goods_name,goods.sku,img,goods_discounts.style,goods_discounts.discounts_money from goods left join goods_discounts on goods.sku=goods_discounts.sku where goods.sku=#{sku} limit #{page},#{pageSize}")
    List<DiscountsBean> getdisBysku(@Param("page") int i, @Param("pageSize") int i1, @Param("sku") String sku);

    @Update("update goods_discounts set style =#{info},discounts_money = #{money} where sku = #{sku}")
    int update(@Param("sku") String sku, @Param("info") String info, @Param("money") int money);

    @Insert("insert into goods_discounts ( sku, status, add_time, discounts_money, style) values " +
            "(#{sku},#{status},#{addTime},#{discountsMoney},#{style})")
    int insert(@Param("sku") String sku,
               @Param("status") String status,
               @Param("addTime") long addTime,
               @Param("discountsMoney") int money,
               @Param("style") String style);
}

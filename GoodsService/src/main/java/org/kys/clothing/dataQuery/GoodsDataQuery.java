package org.kys.clothing.dataQuery;

import org.apache.ibatis.annotations.*;
import org.kys.clothing.Good.GoodsBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface GoodsDataQuery {
    @Select("select * from goods limit #{page2},#{pageSize2};")
    public List<GoodsBean> SelectAllGoods(@Param("page2") int page, @Param("pageSize2") int pageSize);

    @Select("select * from goods where sku= #{sku}")
    GoodsBean getGoodsBySku(@Param("sku") String sku);
    @Select("select * from goods where categroy_id = #{categration} and f_categration_id=#{fcategration} limit #{page2},#{pageSize2};")
    List<GoodsBean> SelectAllGoodsbyCategration(@Param("page2") int i, @Param("pageSize2") int pageSize,@Param("categration") int categration,
                                                @Param("fcategration")int categration2);
    @Select("select * from goods where f_categration_id = #{categration} limit #{page2},#{pageSize2};")
    List<GoodsBean> SelectFAllGoodsbyCategration(@Param("page2") int i, @Param("pageSize2") int pageSize,@Param("categration") int categration);

    @Select("select count(*) from goods where categroy_id = #{categration} and f_categration_id=#{fcategration}")
    Integer getAllGoodsInfoNumber(@Param("categration") int categration,
                                  @Param("fcategration")int categration2);

    @Select("select goods.*,inventory_number from goods left join inventory on goods.sku=inventory.sku limit #{number},20;")
    List<GoodsBean> getAllgoods(@Param("number") int number);

    @Delete("delete from goods where sku=#{sku}")
    boolean deleteSku(@Param("sku") String sku);

    @Insert("insert into goods (goods_name, sku, categroy_id, categroy_name, money, img, style, information, f_categration_name, f_categration_id) values" +
                                "(#{goodsName},#{sku},#{categroyId},${categroyName},#{money},#{img},#{style},#{information},#{f_categration_name},#{f_categration_id})")
    boolean insert(GoodsBean goodsBean);
}

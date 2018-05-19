package org.kys.clothing.dataQuery;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.kys.clothing.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiscountsClothingQuery {
    @Select("select * from goods g,goods_discounts d where g.sku=d.sku and status !=0 limit #{page},#{pageSize}")
    List<GoodsBean> selectAllDiscountsClothing(@Param("page") int page, @Param("pageSize") int pageSize);

    @Select("select * from goods_discounts where sku=#{sku} and status !=-1")
    DiscountsBean getDiscountsInformationByGoodsId(@Param("sku") String sku);
}

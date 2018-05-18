package org.kys.clothing.dataQuery;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.kys.clothing.GoodsBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface GoodsDataQuery {
    @Select("select * from goods limit #{page2},#{pageSize2};")
    public List<GoodsBean> SelectAllGoods(@Param("page2") int page, @Param("pageSize2") int pageSize);
}

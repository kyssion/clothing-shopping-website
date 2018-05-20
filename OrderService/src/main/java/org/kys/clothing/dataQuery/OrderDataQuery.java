package org.kys.clothing.dataQuery;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.kys.clothing.order.OrderBean;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderDataQuery {
    @Insert("insert into order (order_id, goods_info, add_time, change_time, status, user_code)" +
            "values (orderId,goodsInfo,addTime,changeTime,status,userCode)")
    public int insertOrderInfo(OrderBean userCode);
}

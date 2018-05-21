package org.kys.clothing.dataQuery;

import org.apache.ibatis.annotations.*;
import org.kys.clothing.order.OrderBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDataQuery {
    @Insert("insert into order (order_id, goods_info, add_time, change_time, status, user_code)" +
            "values (orderId,goodsInfo,addTime,changeTime,status,userCode)")
    public int insertOrderInfo(OrderBean userCode);

    @Select("select * from order where user_code=${userCode} and order_id = #{orderId}")
    List<OrderBean> getOrderListByUserAndId(@Param("userCode") String userCode,
                                            @Param("orderId") String orderId);

    @Select("select * from order where user_code = #{userCode}")
    List<OrderBean> getOrderListByUser(@Param("userCode") String userCode);

    @Update("update order set status = #{status} where order_id = #{orderId}")
    boolean changeOrderStatus(@Param("orderId") String orderId, @Param("status") int status);
}

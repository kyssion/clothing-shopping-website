package org.kys.clothing.dataQuery;

import org.apache.ibatis.annotations.*;
import org.kys.clothing.order.OrderBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDataQuery {
    @Insert("insert into `order` (order_id, goods_info, add_time, change_time, status, user_code,all_money) " +
            "values (#{orderId},#{goodsInfo},#{addTime},#{changeTime},#{status},#{userCode},#{allMoney})")
    int insertOrderInfo(OrderBean userCode);

    @Select("select * from `order` where user_code=#{userCode} and order_id = #{orderId} order by add_time desc ")
    List<OrderBean> getOrderListByUserAndId(@Param("userCode") String userCode,
                                            @Param("orderId") String orderId);

    @Select("select * from `order` where user_code = #{userCode} order by add_time desc ")
    List<OrderBean> getOrderListByUser(@Param("userCode") String userCode);

    @Update("update `order` set status = #{status},status_name=#{statusName} where order_id = #{orderId}")
    boolean changeOrderStatus(@Param("orderId") String orderId, @Param("status") int status,@Param("statusName")String s);

    @Delete("delete from goods_cards where user_code = #{userCode}")
    int deleteGoodsCardsInfo(@Param("userCode") String userCode);

    @Delete("delete from order where order_id = #{orderId}")
    boolean deleteOrder(@Param("orderId") String orderId);

    @Select("select * from `order` where order_id=#{orderId} order by add_time desc")
    List<OrderBean> getOrderListByid(@Param("orderId") String orderId);

    @Select("select * from `order` order by add_time desc")
    List<OrderBean> getAllOrder();
}

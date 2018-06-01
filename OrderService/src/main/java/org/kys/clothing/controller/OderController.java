package org.kys.clothing.controller;

import org.kys.clothing.order.OrderBean;
import org.kys.clothing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OderController {
    @Autowired
    OrderService orderService;

    /**
     * 创建订单
     *
     * @param userCode
     * @return
     */
    @RequestMapping("create_order")
    public String createOrder(@RequestParam("userCode") String userCode) {
        return orderService.createOrderByUserCode(userCode);
    }
    /**
     * 查看所有的订单
     *
     * @param userCode
     * @param orderId
     * @return
     */
    @RequestMapping("show_order")
    public List<OrderBean> getOrderInformation(@RequestParam("userCode") String userCode, @RequestParam("orderId") @Nullable String orderId) {
        return orderService.getOrderInformation(userCode, orderId);
    }

    /**
     * 改变订单状态
     *
     * @param orderId
     * @param status
     * @return
     */
    @RequestMapping("change_order_status")
    public boolean changeOrderStatus(@RequestParam("orderId") String orderId,
                                     @RequestParam("status") int status) {
        return orderService.changeOrderStatus(orderId, status);
    }

    @RequestMapping("delete_order")
    public boolean deleteOrder(@RequestParam("orderId")String orderId){
        return orderService.deleteOrder(orderId);
    }
}

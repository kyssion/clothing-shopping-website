package org.kys.clothing.fegin;


import org.kys.clothing.returnI.OrderBeanList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "order-service")
public interface OrderFegin {
    @RequestMapping("admin_get_order")
    OrderBeanList getAdminGetOrder(@RequestParam("page")int page,
                                          @RequestParam("orderId")String orderId,
                                          @RequestParam("userCode")String userCode);
    @RequestMapping("change_order_status")
    public boolean changeOrderStatus(@RequestParam("orderId") String orderId,
                                     @RequestParam("status") int status);
}

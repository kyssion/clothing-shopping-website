package org.kys.clothing.controller;

import org.kys.clothing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OderController {
    @Autowired
    OrderService orderService;
    public boolean createOrder(@RequestParam("userCode")String userCode){
        return orderService.createOrderByUserCode(userCode);
    }

}

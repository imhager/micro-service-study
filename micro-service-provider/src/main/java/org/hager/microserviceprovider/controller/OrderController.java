package org.hager.microserviceprovider.controller;

import org.hager.microserviceinterfaceconventions.model.OrderModel;
import org.hager.microserviceinterfaceconventions.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wzh
 * Date: 2017/9/27 16:19
 * Description: 订单微服务
 */

@RestController
@RequestMapping(value = "order-service")
public class OrderController {

    /**
     * 为了测试load balance，打印出对应的application.name
     */
    @Value("${spring.application.name}")
    String applicationName;

    @Value("${environment.name}")
    String environName;

    @Autowired
    OrderService orderService;

    // http://localhost:8771/order-service/detail/9527
    @RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
    public OrderModel getOrderDetail(@PathVariable("orderId") Long orderId) {
        return orderService.getOrderDetail(orderId);
    }
}

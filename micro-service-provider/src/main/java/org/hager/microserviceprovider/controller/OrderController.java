package org.hager.microserviceprovider.controller;

import java.text.MessageFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: wzh
 * Date: 2017/9/27 16:19
 * Description: 订单微服务
 */

@RestController
@RequestMapping(value = "order-service")
public class OrderController {

    // 为了测试load balance
    @Value("${spring.application.name}")
    String applicationName;

    @Value("${environment.name}")
    String environName;

    // http://localhost:8771/order-service/detail/9527
    @RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
    public String getOrderDetail(@PathVariable("orderId") String orderId) {
        return MessageFormat.format("orderId={0},current time is {1}.[data from {2}-{3}]"
                , orderId
                , new Date()
                , applicationName
                , environName);
    }

}

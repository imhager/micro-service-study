package org.hager.microserviceconsumerfeign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wzh
 * @date: 2018/05/29
 * Description:
 */

@FeignClient(value = "micro-service-provider", fallback = OrderServiceClientFallback.class)
public interface OrderServiceClient {


    @RequestMapping(value = "/order-service/detail/{orderId}", method = RequestMethod.GET)
    String getOrderDetail(@PathVariable("orderId") String orderId);
}

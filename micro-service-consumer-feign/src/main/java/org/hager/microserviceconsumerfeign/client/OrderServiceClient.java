package org.hager.microserviceconsumerfeign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wzh
 * @date: 2018/05/29
 * Description:
 */

@FeignClient(value = "micro-service-provider", fallback = OrderServiceClientFallback.class)
public interface OrderServiceClient {


    @GetMapping(value = "/order-service/detail/{orderId}")
    String getOrderDetail(@PathVariable("orderId") String orderId);
}

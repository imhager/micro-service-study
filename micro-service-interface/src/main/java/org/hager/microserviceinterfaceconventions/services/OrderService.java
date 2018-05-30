package org.hager.microserviceinterfaceconventions.services;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wzh
 * @date: 2018/05/29 15:47
 * Description:
 */
public interface OrderService {

    String getOrderDetail(@PathVariable("orderId") String orderId);
}

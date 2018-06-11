package org.hager.microserviceinterfaceconventions.services;

import org.hager.microserviceinterfaceconventions.model.OrderModel;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wzh
 * @date: 2018/05/29 15:47
 * Description:
 */
public interface OrderService {

    OrderModel getOrderDetail(@PathVariable("orderId") Long orderId);
}

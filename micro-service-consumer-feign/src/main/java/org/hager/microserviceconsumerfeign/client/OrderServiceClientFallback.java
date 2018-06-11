package org.hager.microserviceconsumerfeign.client;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hager.microserviceinterfaceconventions.model.OrderModel;

/**
 * @author wzh
 * @date: 2018/05/29
 * Description:
 */
public class OrderServiceClientFallback implements OrderServiceClient {
    @Override
    public OrderModel getOrderDetail(Long orderId) {
        // return "来自熔断实现返回信息:orderId=" + orderId;
        return new OrderModel(-1L
                , -1L
                , "来自熔断实现返回信息:orderId=" + orderId
                , Timestamp.valueOf(LocalDateTime.now()));
    }
}

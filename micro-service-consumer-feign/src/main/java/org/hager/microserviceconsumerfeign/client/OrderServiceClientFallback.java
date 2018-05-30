package org.hager.microserviceconsumerfeign.client;

/**
 * @author wzh
 * @date: 2018/05/29
 * Description:
 */
public class OrderServiceClientFallback implements OrderServiceClient {
    @Override
    public String getOrderDetail(String orderId) {
        return "来自熔断实现返回信息:orderId=" + orderId;
    }
}

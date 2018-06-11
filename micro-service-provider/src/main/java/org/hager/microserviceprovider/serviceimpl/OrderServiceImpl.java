package org.hager.microserviceprovider.serviceimpl;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.hager.microserviceinterfaceconventions.model.OrderModel;
import org.hager.microserviceinterfaceconventions.services.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wzh
 * @date: 2018/05/29 16:51
 * Description:
 */

@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 为了测试load balance
     */
    @Value("${spring.application.name}")
    String applicationName;

    @Value("${environment.name}")
    String environName;

    @Override
    public OrderModel getOrderDetail(Long orderId) {

        String msg = MessageFormat.format("orderId={0},current time is {1}.[data from {2}-{3}]"
                , orderId
                , new Date()
                , applicationName
                , environName);

        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId(orderId);
        orderModel.setOrderName(msg);
        orderModel.setUserId(9527L);
        orderModel.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));

        return orderModel;
    }
}

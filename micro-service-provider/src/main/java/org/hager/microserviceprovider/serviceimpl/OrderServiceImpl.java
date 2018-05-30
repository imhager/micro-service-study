package org.hager.microserviceprovider.serviceimpl;

import java.text.MessageFormat;
import java.util.Date;

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
    public String getOrderDetail(String orderId) {
        return MessageFormat.format("orderId={0},current time is {1}.[data from {2}-{3}]"
                , orderId
                , new Date()
                , applicationName
                , environName);
    }
}

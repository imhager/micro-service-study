package org.hager.microserviceapigateway.services;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.hager.microserviceinterfaceconventions.model.OrderModel;
import org.hager.microserviceinterfaceconventions.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

/**
 * @author wzh
 * @date: 2018/06/09
 * Description: 聚合服务，根据用户id，请求用户信息和订单信息
 */
@Slf4j
@Service
public class AggregationService {

    @Autowired
    private RestTemplate restTemplate;

    private String microUserServiceUri = "http://micro-service-provider/user-service/detail/{id}";

    private String microOrderServiceUri = "http://micro-service-provider/order-service/detail/{id}";


    @HystrixCommand(fallbackMethod = "userFallback")
    public Observable<UserModel> getUserById(Long userId) {
        return Observable.create(observer -> {
            UserModel userModel = restTemplate.getForObject(microUserServiceUri, UserModel.class, userId);

            observer.onNext(userModel);
            observer.onCompleted();
        });
    }

    @HystrixCommand(fallbackMethod = "orderFallback")
    public Observable<OrderModel> getOrderByUserId(Long orderId) {
        return Observable.create(observer -> {
            OrderModel orderModel = restTemplate.getForObject(microOrderServiceUri, OrderModel.class, orderId);

            observer.onNext(orderModel);

            observer.onCompleted();
        });
    }


    public OrderModel orderFallback(Long orderId) {
        return null;
    }

    public UserModel userFallback(Long userId) {
        return null;
    }

}

package org.hager.microserviceapigateway.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hager.microserviceapigateway.model.UserInfo;
import org.hager.microserviceapigateway.services.AggregationService;
import org.hager.microserviceinterfaceconventions.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

/**
 * @author wzh
 * @date: 2018/06/09
 * Description: 测试调用 聚合服务
 */

@RestController
@Slf4j
public class AggregationController {

    @Autowired
    private AggregationService aggregationService;

    @RequestMapping(value = "/aggregate/{id}")
    public DeferredResult<UserInfo> getAggregationData(@PathVariable("id") Long id) {
        Observable<UserInfo> result = this.aggregationObservable(id);

        return this.toDeferredResult(result);
    }


    private Observable<UserInfo> aggregationObservable(Long id) {
        return Observable.zip(

                this.aggregationService.getUserById(id),

                this.aggregationService.getOrderByUserId(id),

                (userModel, orderModel) -> {

                    UserInfo userInfo1 = new UserInfo();
                    userInfo1.setUserId(userModel.getUserId());
                    userInfo1.setUserName(userModel.getUserName());
                    userInfo1.setAge(userModel.getAge());
                    List<OrderModel> orderModelList = new ArrayList<>();
                    orderModelList.add(orderModel);

                    userInfo1.setOrderList(orderModelList);

                    return userInfo1;
                }
        );
    }


    private DeferredResult<UserInfo> toDeferredResult(Observable<UserInfo> details) {
        DeferredResult<UserInfo> result = new DeferredResult<>();

        //订阅

        details.subscribe(new Observer<UserInfo>() {
            @Override
            public void onCompleted() {
                log.info("完成。。。");
            }

            @Override
            public void onError(Throwable throwable) {
                log.error("发生错误。。。", throwable);
            }

            @Override
            public void onNext(UserInfo stringStringHashMap) {
                result.setResult(stringStringHashMap);
            }
        });

        return result;
    }
}
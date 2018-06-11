package org.hager.microserviceconsumerfeign.controller;

import org.hager.microserviceconsumerfeign.client.UserServiceClient;
import org.hager.microserviceinterfaceconventions.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: wzh
 * Date: 2017/9/27 17:29
 * Description:
 */

//完整请求地址 http://localhost:8782/consumer-user-feign/info?userId=xxx
@RestController

@RequestMapping(value = "consumer-user-feign")
public class UserController {

    // 注入使用了Feign Client的client对象


    @Autowired
    UserServiceClient userServiceClient;

    // 模拟GET请求
    @RequestMapping(value = "/info")
    public UserModel info(Long userId) {
        return userServiceClient.getUser(userId);
    }


    // 模拟POST请求
    // @RequestMapping(value = "/list", method = RequestMethod.POST)
    // public String list() {
    //     Map<String, Object> params = new HashMap<>();
    //     params.put("key_1", "value_1");
    //     params.put("key_2", "value_2");
    //     params.put("key_3", "value_4");
    //
    //     return userServiceClient.getUsers(params);
    // }
}

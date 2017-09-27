package org.hager.microserviceconsumerfeign.controller;

import org.hager.microserviceconsumerfeign.client.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: wzh
 * Date: 2017/9/27 17:29
 * Description:
 */

//完整请求地址 http://localhost:8782/user/info?name=hager
@RestController
public class UserController {

    @Autowired
    UserServiceClient userServiceClient; // 注入使用了Feign Client的client对象

    @RequestMapping(value = "/info")
    public String info(String name) {
        return userServiceClient.getUser(name);
    }
}

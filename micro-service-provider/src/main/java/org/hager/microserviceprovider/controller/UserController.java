package org.hager.microserviceprovider.controller;

import org.hager.microserviceinterfaceconventions.model.UserModel;
import org.hager.microserviceinterfaceconventions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2017/9/27 16:17
 * Description:
 *
 * @author Admin
 */

@RestController
@RequestMapping(value = "user-service")
public class UserController {

    // 为了测试load balance，便于区分显示内容
    @Value("${spring.application.name}")
    String applicationName;

    @Value("${environment.name}")
    String environName;

    @Autowired
    UserService userService;

    // http://localhost:8771/user-service/detail/9527
    @RequestMapping(value = "/detail/{userId}", method = RequestMethod.GET)
    public UserModel getUser(@PathVariable("userId") Long userId) {
        // return MessageFormat.format("hi,user_{0},current time is {1}.[data from {2}-{3}]"
        //         , userService.getUser(userId)
        //         , new Date()
        //         , applicationName
        //         , environName);

        return userService.getUser(userId);

    }
}

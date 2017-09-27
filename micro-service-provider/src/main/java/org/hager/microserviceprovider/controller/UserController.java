package org.hager.microserviceprovider.controller;

import java.text.MessageFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: wzh
 * Date: 2017/9/27 16:17
 * Description:
 */

@RestController
@RequestMapping(value = "user-service")
public class UserController {

    // 为了测试load balance
    @Value("${spring.application.name}")
    String applicationName;

    @Value("${environment.name}")
    String environName;

    @RequestMapping(value = "/detail/{name}", method = RequestMethod.GET)
    public String getUser(@PathVariable("name") String name) {
        return MessageFormat.format("hi,user_{0},current time is {1}.[data from {2}-{3}]"
                , name
                , new Date()
                , applicationName
                , environName);
    }
}

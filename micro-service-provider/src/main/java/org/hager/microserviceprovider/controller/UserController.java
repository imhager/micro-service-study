package org.hager.microserviceprovider.controller;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    // http://localhost:8771/user-service/detail/jack
    @RequestMapping(value = "/detail/{name}", method = RequestMethod.GET)
    public String getUser(@PathVariable("name") String name) {
        return MessageFormat.format("hi,user_{0},current time is {1}.[data from {2}-{3}]"
                , name
                , new Date()
                , applicationName
                , environName);
    }


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String getUsers(@RequestBody Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            sb.append("key=" + key + ",value=" + params.get(key));
        }

        return String.format("params:%s", sb.toString());
    }
}

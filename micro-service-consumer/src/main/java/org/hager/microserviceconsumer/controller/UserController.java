package org.hager.microserviceconsumer.controller;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * User: wzh
 * Date: 2017/9/27 16:27
 * Description: 调用provider提供的服务
 */

@RestController
@RequestMapping(value = "consumer-user")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${service.provider.application.name}")
    String providerUrl;

    //GET http://localhost:port/consumer-user/detail?name=xxx
    @ResponseBody
    @RequestMapping(value = "/detail")
    public ResponseEntity<String> userInfo(String name) {

        String uriUser = MessageFormat.format("{0}/user-service/detail/{1}", providerUrl, name);

        return restTemplate.getForEntity(uriUser, String.class);
    }
}

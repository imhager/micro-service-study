package org.hager.microserviceconsumerfeign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: wzh
 * Date: 2017/9/27 17:19
 * Description: 为user-service创建一个feign-client
 * 利用feignclient对rest Template进行了封装；
 * 然后，在本类中定义你想调用的方法接口即可
 */
@FeignClient("user-service") // 用FeignClient注解来绑定该接口对应user-service服务
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/userInfo")
    String getUser(@PathVariable("name") String name);
}

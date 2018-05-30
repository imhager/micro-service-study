package org.hager.microserviceconsumerfeign.client;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Date: 2017/9/27 17:19
 * Description: 为user-service创建一个feign-client
 * 利用feignClient对rest Template进行了封装；
 * 然后，在本类中定义你想调用的方法接口即可。
 * <p>
 * 用FeignClient注解来绑定该接口对应user-service服务
 * 利用fallback，实现熔断时的拦截返回
 *
 * @author Admin
 */


@FeignClient(value = "micro-service-provider"
        , fallback = UserServiceClientFallback.class
        , configuration = UserServiceFeignConfiguration.class)
public interface UserServiceClient {

    @GetMapping(value = "/user-service/detail/{name}")
    String getUser(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.POST, value = "/user-service/list")
    String getUsers(@RequestBody Map<String, Object> params);
}

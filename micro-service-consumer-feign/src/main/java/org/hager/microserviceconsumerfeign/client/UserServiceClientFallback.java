package org.hager.microserviceconsumerfeign.client;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Date: 2017/10/23 15:28
 * Description: 实现熔断时返回,当请求失败或熔断时，就会调用对应方法
 * 不需要对方法设置requestMapping规则
 *
 * 特别说明：该实现并不需要指定RequestMapping路由规则；
 *
 * @author wzh
 */

@Component
public class UserServiceClientFallback implements UserServiceClient {

    @Override
    // @RequestMapping(value = "/user-service/detail/{name}", method = RequestMethod.GET)
    public String getUser(@PathVariable("name") String name) {
        return "来自熔断实现返回信息:name=" + name;
    }

    @Override
    // @RequestMapping(value = "/user-service/list", method = RequestMethod.POST)
    public String getUsers(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            sb.append("key=" + key + ",value=" + params.get(key));
        }

        String s = String.format("params:%s", sb.toString());

        return "来自熔断实现返回信息:params:" + s;
    }
}

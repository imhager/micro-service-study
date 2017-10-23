package org.hager.microserviceconsumerfeign.client;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Date: 2017/10/23 15:28
 * Description: 实现熔断时返回
 *
 * @author wzh
 */

@Component
public class UserServiceClientHystrix implements UserServiceClient {

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/user-service/detail/{name}")
    public String getUser(@PathVariable("name") String name) {
        return "来自熔断实现返回信息:name=" + name;
    }

    @Override
    public String getUsers(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            sb.append("key=" + key + ",value=" + params.get(key));
        }

        String s = String.format("params:%s", sb.toString());

        return "来自熔断实现返回信息:params:" + s;
    }
}

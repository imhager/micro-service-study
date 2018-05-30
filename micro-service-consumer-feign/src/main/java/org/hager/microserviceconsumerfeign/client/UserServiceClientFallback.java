package org.hager.microserviceconsumerfeign.client;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Date: 2017/10/23 15:28
 * Description: 实现熔断时返回,当请求失败或熔断时，就会调用对应方法
 * 不需要对方法设置requestMapping规则
 *
 * @author wzh
 */

@Component
public class UserServiceClientFallback implements UserServiceClient {

    @Override
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

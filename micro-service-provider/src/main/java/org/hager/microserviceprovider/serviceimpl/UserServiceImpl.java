package org.hager.microserviceprovider.serviceimpl;

import java.util.Map;

import org.hager.microserviceinterfaceconventions.services.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wzh
 * @date: 2018/05/29 17:13
 * Description:
 */

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(String name) {
        return "user_" + name;
    }

    @Override
    public String getUsers(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            sb.append("key=" + key + ",value=" + params.get(key));
        }

        return sb.toString();
    }
}

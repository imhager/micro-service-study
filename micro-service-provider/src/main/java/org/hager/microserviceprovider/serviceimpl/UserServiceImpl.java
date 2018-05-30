package org.hager.microserviceprovider.serviceimpl;

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
}

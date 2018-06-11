package org.hager.microserviceinterfaceconventions.services;

import org.hager.microserviceinterfaceconventions.model.UserModel;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wzh
 * @date: 2018/05/29 17:13
 * Description:
 */
public interface UserService {

    UserModel getUser(@PathVariable("userId") Long userId);
}

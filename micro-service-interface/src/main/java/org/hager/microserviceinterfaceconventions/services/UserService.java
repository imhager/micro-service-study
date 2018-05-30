package org.hager.microserviceinterfaceconventions.services;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wzh
 * @date: 2018/05/29 17:13
 * Description:
 */
public interface UserService {

    String getUser(@PathVariable("name") String name);

    // String getUsers(@RequestBody Map<String, Object> params);
}

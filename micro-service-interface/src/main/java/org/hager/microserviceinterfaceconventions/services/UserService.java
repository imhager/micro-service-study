package org.hager.microserviceinterfaceconventions.services;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wzh
 * @date: 2018/05/29 17:13
 * Description:
 */
public interface UserService {

    String getUser(@PathVariable("name") String name);

    String getUsers(@RequestBody Map<String, Object> params);
}

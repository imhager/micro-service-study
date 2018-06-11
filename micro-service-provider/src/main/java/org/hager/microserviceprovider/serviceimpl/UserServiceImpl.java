package org.hager.microserviceprovider.serviceimpl;

import java.text.MessageFormat;
import java.util.Date;

import org.hager.microserviceinterfaceconventions.model.UserModel;
import org.hager.microserviceinterfaceconventions.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wzh
 * @date: 2018/05/29 17:13
 * Description:
 */

@Service
public class UserServiceImpl implements UserService {

    /**
     * 为了测试load balance
     */
    @Value("${spring.application.name}")
    String applicationName;

    @Value("${environment.name}")
    String environName;

    @Override
    public UserModel getUser(Long userId) {

        String msg = MessageFormat.format("userId={0},current time is {1}.[data from {2}-{3}]"
                , userId
                , new Date()
                , applicationName
                , environName);

        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setUserName("唐嫣");
        userModel.setAge(18);
        userModel.setNickName("唐伯虎");

        return userModel;
    }
}

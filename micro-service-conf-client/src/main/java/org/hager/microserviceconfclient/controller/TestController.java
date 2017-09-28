package org.hager.microserviceconfclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: wzh
 * Date: 2017/9/28 13:53
 * Description: 测试从conf-server获取配置文件
 */
@RefreshScope // 当远程配置更新后，可以自动更新
@RestController
@RequestMapping(value = "test")
public class TestController {

    /**
     * 从远程conf-server获取配置内容
     */
    @Value("${from}")
    String confEnvironment;

    @Value("${spring.cloud.config.uri}")
    String confServer;

    @ResponseBody
    @RequestMapping("/env")
    public String env() {
        return String.format("i came from conf-server=%s,the environment is [%s]"
                , confServer
                , this.confEnvironment);

        //输出结果 i came from conf-server=http://localhost:8791/,the environment is [git-dev-1.0]
    }
}

package org.hager.microserviceregistry2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Admin
 */
@EnableEurekaServer // 注解为注册中心
@SpringBootApplication
public class MicroServiceRegistry2Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceRegistry2Application.class, args);
    }
}

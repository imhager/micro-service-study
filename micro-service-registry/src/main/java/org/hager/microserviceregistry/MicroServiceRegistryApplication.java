package org.hager.microserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 注解为注册中心
@SpringBootApplication
public class MicroServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceRegistryApplication.class, args);
    }
}

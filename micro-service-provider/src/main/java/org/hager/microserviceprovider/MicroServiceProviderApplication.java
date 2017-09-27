package org.hager.microserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroServiceProviderApplication {

    public static void main(String[] args) {

        // 可以自由指定配置，适用于多配置，多项目情况
        // System.setProperty("spring.config.name", "application.properties");

        SpringApplication.run(MicroServiceProviderApplication.class, args);
    }
}

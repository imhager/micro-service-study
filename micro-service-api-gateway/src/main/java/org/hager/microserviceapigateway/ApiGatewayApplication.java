package org.hager.microserviceapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Admin
 * 启用服务注册发现，zuulProxy
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

    /**
     * 声明一个客户端loadBalance的restClient
     *
     * @return restTemplate RestTemplate instance
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}

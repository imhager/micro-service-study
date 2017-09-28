package org.hager.microserviceconfclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroServiceConfClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConfClientApplication.class, args);

        // 在没有引入Web 依赖时，依然可以按照Web启动
        // new SpringApplicationBuilder(MicroServiceConfClientApplication.class).web(true).run(args);

    }
}

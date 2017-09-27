package org.hager.microserviceconfserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MicroServiceConfServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConfServerApplication.class, args);
    }
}

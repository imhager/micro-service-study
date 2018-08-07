package org.hager.microservicezipkintraceprovider;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author wzh
 * @date: 2018/08/07
 * Description: 测试分布式跟踪的服务提供者
 */

@RestController
public class TraceProvideController {

    @GetMapping("/trace-service-provider")
    public Mono<String> trace() {
        System.out.println("===call trace-service-provider===");

        return Mono.just("trace-service-provider" + LocalDateTime.now());
    }
}

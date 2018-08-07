package org.hager.microservicezipkintrace.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author wzh
 * @date: 2018/08/07
 * Description:测试分布式跟踪的服务消费者
 */

@RestController
public class TraceConsumeController {

    @Autowired
    private LoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                // 这里需要注意，对于webclient来说，在这个filterChain中使用了LoadBalancerExchangeFilterFunction，
                // 可以看到使用了LoadBalancerExchangeFilterFunction的filter方法里头，对原来的request进行了包装，
                // 使用loadBalancerClient根据服务ID进行服务发现选取可用的服务地址，
                // 然后替换原来的uri，构造成新的request传递到下一个filter
                .baseUrl("http://micro-service-zipkin-trace-provider")
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    /**
     * 服务消费方法
     *
     * @return 远程返回内容
     */
    @GetMapping("/trace-consumer")
    public Mono<String> traceA() {
        System.out.println("==call trace-consumer ==");

        return webClient()
                .get()
                .uri("/trace-service-provider")
                .retrieve()
                .bodyToMono(String.class);
    }
}

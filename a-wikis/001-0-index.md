# 索引

## Features

Spring Cloud Netflix features:

* Service Discovery: Eureka instances can be registered and clients can discover the instances using Spring-managed beans
* Service Discovery: an embedded Eureka server can be created with declarative Java configuration
* Circuit Breaker: Hystrix clients can be built with a simple annotation-driven method decorator
* Circuit Breaker: embedded Hystrix dashboard with declarative Java configuration
* Declarative REST Client: Feign creates a dynamic implementation of an interface decorated with JAX-RS or Spring MVC annotations
* Client Side Load Balancer: Ribbon
* External Configuration: a bridge from the Spring Environment to Archaius (enables native configuration of Netflix components using Spring Boot conventions)
* Router and Filter: automatic regsitration of Zuul filters, and a simple convention over configuration approach to reverse proxy creation

---

* 服务注册与发现 `Eureka Server`
* 服务提供者 `Eureka Client`
* 服务消费者 `Eureka Client`
  * `feign`
  * `rest + ribbon`
* 负载 `ribbon`
* 断路器 `Hystrix`
* 网关：鉴权、拦截、降级、服务聚合等 `zuul`
* (动态)路由&过滤器 `zuul`
* 灰度发布 `Spring Cloud Ribbon Discovery Server filter`
  * [灰度发布](https://github.com/jmnarloch/ribbon-discovery-filter-spring-cloud-starter)
* 监控
  * 断路器聚合监控 (`Hystrix Turbine`)
  * 断路器监控 (`Hystrix Dashboard`)
* 服务链路追踪 (`Spring Cloud Sleuth`) [zipkin](https://yq.aliyun.com/articles/60165)
* 配置中心 `Conf Server` `Conf Client`
* 消息总线 (`Spring Cloud Bus`)


## 参考资料
* https://blog.de-swaef.eu/the-netflix-stack-using-spring-boot-part-3-feign/
* http://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.0.0.RC2/single/spring-cloud-netflix.html

* https://blog.csdn.net/forezp/article/details/70037513
* https://yq.aliyun.com/articles/60165 zipkin分析
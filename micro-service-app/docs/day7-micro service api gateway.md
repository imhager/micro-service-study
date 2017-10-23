# api gateway
* 基于zuul 构建;集成eureka与注册中心连接，启动服务发现；这样在配置zuul.routes时，就可以利用service id进行路由处理了。

## 依赖包
```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zuul</artifactId>
</dependency>
```

## 路由示例
```bash
# zuul.routes.xxxx.path:xxxx 部分为路由的名字，可以任意定义，但是一组映射关系的path和url要相同，下面讲serviceId时候也是如此。
zuul.routes.user-service.path=/user-service/**
zuul.routes.user-service.serviceId=micro-service-provider
```
### 如果配置多个服务分发怎么办？上述路由方式略显不足了
* 其实，`spring cloud zuul` 已经帮我们做了默认配置。默认情况下，Zuul会代理所有注册到Eureka Server的微服务，并且Zuul的路由规则如下：http://ZUUL_HOST:ZUUL_PORT/微服务在Eureka上的serviceId/**会被转发到serviceId对应的微服务。
* 验证地址 `http://10.167.3.99:9761/micro-service-provider/user-service/detail/jack` 就可以正常分发了。

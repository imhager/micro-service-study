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
```xml
# zuul.routes.xxxx.path:xxxx 部分为路由的名字，可以任意定义，但是一组映射关系的path和url要相同，下面讲serviceId时候也是如此。
zuul.routes.user-service.path=/user-service/**
zuul.routes.user-service.serviceId=micro-service-provider
```
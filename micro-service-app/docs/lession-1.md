# 创建项目

## micro-eureka-server
> service registry

* 依赖 `eureka-server`

## micro-eureka-provider
> 服务提供者

* 依赖 `eureka discovery client`

## micro-eureka-consumer
> 服务消费者，同时也可以作为服务提供者使用；因为都是注册到了注册中心；

* 依赖 `eureka discovery client`

## micro-eureka-conf-server
> 分布式配置中心

* 依赖 `config server`

## 测试项目功能(依次启动)
* `micro-eureka-server`
* `micro-eureka-provider` 为了测试Ribbon功能，启动两个
    * `java -jar micro-eureka-provider-0.0.1-SNAPSHOT.jar --server.port=8762`
    * `java -jar micro-eureka-provider-0.0.1-SNAPSHOT.jar --server.port=8764`
* `micro-eureka-consumer`
    * 
    
## micro-app
> 基于spring boot、thymeleaf、jpa 的Web站点
> 勾选了 Web、aspects、thyme leaf、JPA、mysql、lombok、cache
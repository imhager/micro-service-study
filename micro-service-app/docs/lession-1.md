# 创建项目

## micro-service-registry
> service registry

* 依赖 `eureka-server`

## micro-service-provider
> 服务提供者

* 依赖 `eureka discovery client`

## micro-service-consumer
> 服务消费者，同时也可以作为服务提供者使用；因为都是注册到了注册中心；

* 依赖 `eureka discovery client`、`Ribbon`

## micro-service-consumer-feign
> 服务消费者，同时也可以作为服务提供者使用；因为都是注册到了注册中心；

* 依赖 `eureka discovery client`、`Feign`

## micro-service-conf-server
> 分布式配置中心

* 依赖 `config server`

## micro-service-app
> 基于springBoot + JPA + thymeleaf 的Web项目；后续用于整合一些功能的使用

## 测试项目功能(依次启动)
* `micro-service-registry`
    * `java -jar micro-service-provider-0.0.1-SNAPSHOT.jar --server.port=8761`
    
* `micro-service-provider` 为了测试Ribbon功能，启动两个
    * `java -jar micro-service-provider-0.0.1-SNAPSHOT.jar --server.port=8771`
    * `java -jar micro-service-provider-0.0.1-SNAPSHOT.jar --server.port=8772`
    
* `micro-service-consumer`
    * `java -jar micro-service-consumer-0.0.1-SNAPSHOT.jar --server.port=8781`
    
* `micro-service-consumer-feign`
    * `java -jar micro-service-consumer-feign-0.0.1-SNAPSHOT.jar --server.port=8782`
    
## micro-app
> 基于spring boot、thymeleaf、jpa 的Web站点
> 勾选了 Web、aspects、thyme leaf、JPA、mysql、lombok、cache
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
* `micro-service-registry` 注册中心，为了测试集群功能，启动两个
  * 构建高可用注册中心
  * 启动方式（打开两个cmd窗口，然后各自执行一条，等两个节点都正常启动后，会提示阶段UP状态）
  * `java -jar micro-service-registry-0.0.1-SNAPSHOT.jar --spring.profiles.active=registry-center-cluster-001`
  * `java -jar micro-service-registry-0.0.1-SNAPSHOT.jar --spring.profiles.active=registry-center-cluster-002`
    
* `micro-service-provider` 服务提供方 为了测试Ribbon功能，启动两个
    * `java -jar micro-service-provider-0.0.1-SNAPSHOT.jar --server.port=8771`
    * `java -jar micro-service-provider-0.0.1-SNAPSHOT.jar --server.port=8772`
    
* `micro-service-consumer` 服务消费方
    * `java -jar micro-service-consumer-0.0.1-SNAPSHOT.jar --server.port=8781`
    
* `micro-service-consumer-feign` 服务消费方，集成了feign请求
    * `java -jar micro-service-consumer-feign-0.0.1-SNAPSHOT.jar --server.port=8782`

* `micro-service-conf-server` 配置中心服务端

* `micro-service-conf-client` 配置中心客户端


## micro-app
> 基于spring boot、thymeleaf、jpa 的Web站点
> 勾选了 Web、aspects、thyme leaf、JPA、mysql、lombok、cache
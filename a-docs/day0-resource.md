# feature
* http://cloud.spring.io/spring-cloud-netflix/
* https://projects.spring.io/spring-cloud/
* http://cloud.spring.io/spring-cloud-static/Dalston.SR4/multi/multi_spring-cloud.html
* http://blog.csdn.net/lc0817/article/details/54375802 问题集锦
* http://blog.csdn.net/qq_22841811/article/category/6808338 系列文章 ★★★
* http://ifeve.com/%E3%80%8Aspring-cloud-netflix%E5%AE%98%E6%96%B9%E6%96%87%E6%A1%A3%E3%80%8B7-%E5%A3%B0%E6%98%8E%E5%BC%8F-rest-%E5%AE%A2%E6%88%B7%E7%AB%AF%EF%BC%9A-feign/
* http://blog.didispace.com/Spring-Cloud%E5%9F%BA%E7%A1%80%E6%95%99%E7%A8%8B/

## Distributed/versioned configuration
* spring-cloud-config-server
* config-client

## Service registration and discovery

* eureka discovery client
    * 服务消费方consumer：利用restTemplate 发起Rest请求
    * 服务提供方provider：以rest方式对外提供服务
* eureka server
    * 注册中心角色

## Routing

* Router and Filter: automatic regsitration of Zuul filters, 
and a simple convention over configuration approach to reverse proxy creation
* http://blog.csdn.net/qq_18675693/article/details/53282031

## Service-to-service calls

* RestTemplate、feign

## Load balancing

* Client Side Load Balancer: Ribbon

#### ribbon

> Ribbon是一个基于HTTP和TCP客户端的负载均衡器。Feign中也使用Ribbon。
  Ribbon可以在通过客户端中配置的ribbonServerList服务端列表去轮询访问以达到均衡负载的作用。
  当Ribbon与Eureka联合使用时，ribbonServerList会被DiscoveryEnabledNIWSServerList重写，
  扩展成从Eureka注册中心中获取服务端列表。同时它也会用NIWSDiscoveryPing来取代IPing，它将职责委托给Eureka来确定服务端是否已经启动。

## api-gateway
* zuul
* http://blog.didispace.com/springcloud5/

## Circuit Breakers

* Hystrix
* http://blog.csdn.net/qq_18675693/article/details/53282031

## Global locks

* 

## Leadership election and cluster state

* 

## Distributed messaging

* http://cloud.spring.io/spring-cloud-bus


## micro-feign-client

> Feign是一个声明式的Web Service客户端，它使得编写Web Serivce客户端变得更加简单。
我们只需要使用Feign来创建一个接口并用注解来配置它既可完成。
它具备可插拔的注解支持，包括Feign注解和JAX-RS注解。
Feign也支持可插拔的编码器和解码器。
Spring Cloud为Feign增加了对Spring MVC注解的支持，还整合了Ribbon和Eureka来提供均衡负载的HTTP客户端实现。




## oauth security

> 接口调用安全验证

## reference

* http://blog.csdn.net/forezp/article/details/69696915
* http://www.360doc.cn/mip/617789585.html
* http://blog.didispace.com/springcloud2/
* http://www.cnblogs.com/lazio10000/p/5510852.html
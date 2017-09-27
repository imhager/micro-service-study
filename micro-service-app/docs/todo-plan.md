# feature
> http://cloud.spring.io/spring-cloud-netflix/
> 

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
* Router and Filter: automatic regsitration of Zuul filters, and a simple convention over configuration approach to reverse proxy creation

## Service-to-service calls
* RestTemplate、feign

## Load balancing
* Client Side Load Balancer: Ribbon

## Circuit Breakers
* Hystrix

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

## micro-ribbon
> Ribbon是一个基于HTTP和TCP客户端的负载均衡器。Feign中也使用Ribbon。
  Ribbon可以在通过客户端中配置的ribbonServerList服务端列表去轮询访问以达到均衡负载的作用。
  当Ribbon与Eureka联合使用时，ribbonServerList会被DiscoveryEnabledNIWSServerList重写，
  扩展成从Eureka注册中心中获取服务端列表。同时它也会用NIWSDiscoveryPing来取代IPing，它将职责委托给Eureka来确定服务端是否已经启动。

## Hystrix
> 熔断限流

## api-gateway
> api网关

## oauth security
> 接口调用安全验证

## reference
* http://blog.csdn.net/forezp/article/details/69696915
* http://www.360doc.cn/mip/617789585.html
* http://blog.didispace.com/springcloud2/
* http://www.cnblogs.com/lazio10000/p/5510852.html
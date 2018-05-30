# 常见问题集锦

## Q1 Eureka的自我保护模式
>如果在Eureka Server的首页看到以下这段提示，则说明Eureka已经进入了保护模式：
 EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
 
* 一般出现此模式时，服务返回错误。即如果真实的服务已经Down掉，但在注册中心界面服务却一直存在，且显示为UP状态。

### 产生原因
>    Eureka Server在运行期间，会统计心跳失败的比例在15分钟之内是否
 低于85%，如果出现低于的情况（在单机调试的时候很容易满足，实际在
 生产环境上通常是由于网
 络不稳定导致），Eureka Server会将当前的实例注册信息保护起来，同时提
 示这个警告。保护模式主要用于一组客户端和Eureka Server之间存在网络分
 区场景下的保护。一旦进入保护模式，Eureka Server将会尝试保护其服务注
 册表中的信息，不再删除服务注册表中的数据（也就是不会注销任何微服务）。
 
 ### 解决办法
> `eureka.server.enable-self-preservation=false` 关闭自我保护。
 
 ```text
 1.Hystrix,在fallback方法中shutdown指定的服务
 2.让zuul只路由到活着的那个服务：
 添加依赖：
   <dependency>
       <groupId>com.squareup.okhttp3</groupId>
       <artifactId>okhttp</artifactId>
       <version>3.6.0</version>
   </dependency>
 配置文件：
 ribbon.connectTimeout: 2000
 ribbon.readTimeout: 10000
 ribbon.maxAutoRetries: 1
 ribbon.maxAutoRetriesNextServer: 2
 ribbon.okToRetryOnAllOperations: true
 ribbon.okhttp.enabled: true
 3.重试机制（和上述一个道理）
 spring.cloud.loadbalancer.retry.enabled=true
 hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=10000
 hello-service.ribbon.ConnectTimeout=250
 hello-service.ribbon.ReadTimeout=1000
 hello-service.ribbon.OkToRetryOnAllOperations=true
 hello-service.ribbon.MaxAutoRetriesNextServer=2
 hello-service.ribbon.MaxAutoRetries=1
 
 
 spring.cloud.loadbalancer.retry.enabled：该参数用来开启重试机制，它默认是关闭的。这里需要注意，官方文档中的配置参数少了enabled
 hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds：断路器的超时时间需要大于ribbon的超时时间，不然不会触发重试。
 
 hello-service.ribbon.ConnectTimeout：请求连接的超时时间
 
 hello-service.ribbon.ReadTimeout：请求处理的超时时间
 
 hello-service.ribbon.OkToRetryOnAllOperations：对所有操作请求都进行重试
 
 hello-service.ribbon.MaxAutoRetriesNextServer：切换实例的重试次数
 
 hello-service.ribbon.MaxAutoRetries：对当前实例的重试次数
```


## Q2 如果有多个实现，zuul如何处理的。
> can't autoware .there is more than one bean of xxx type.

### 产生原因
> 因为为了实现熔断，对同一个接口实现了2个实现。其中一个是fallback时调用的实现。

### 解决办法
> 通过 `@Primary=true`注解解决。
```text
When using Feign with Hystrix fallbacks, there are multiple beans in the ApplicationContext of the same type. 
This will cause @Autowired to not work because there isn’t exactly one bean, or one marked as primary. 
To work around this, Spring Cloud Netflix marks all Feign instances as @Primary, 
so Spring Framework will know which bean to inject. In some cases, this may not be desirable. 
To turn off this behavior set the primary attribute of @FeignClient to false.当使用Feign和Hystrix后退时，
ApplicationContext中有多个相同类型的bean。 这将导致@Autowired无法工作，因为不是只有一个bean，或者标记为主要的bean。 
为了解决这个问题，Spring Cloud Netflix将所有Feign实例标记为@Primary，以便Spring Framework知道要注入哪个bean。 
在某些情况下，这可能不合意。 要关闭此行为，请将@FeignClient的主属性设置为false。

```
 
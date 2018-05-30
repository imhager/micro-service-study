# 服务消费者
> 一般是调用 `micro service provider` 的服务消费方。通过注册中心进行服务消费；

> 如果要做到高并发、高可用，设置重试机制的话，可以通过`feign`进行请求。`feign`默认有重试机制，当然也可以通过配置进行屏蔽。

>一般情况下，会在网关层，通过引入`zuul`进行提前拦截处理。比如常见的日志、鉴权、熔断降级等

## 一般方式调用
> 详见项目 `micro-service-consumer`

## 利用feign进行调用
> 详见项目 `micro-service-consumer-feign`

## 引入依赖
* `spring-cloud-starter-feign`
* `spring-cloud-starter-hystrix` -- 按理说feign应该是带了，不过还是引入一下比较好

## 修改配置 `application.properties`

```bash
# 启动熔断
feign.hystrix.enabled=true
```

## 实现对`provider`的调用
* 实现一个client `UserServiceClient`,包装了对`micro-service-proder`服务提供方的调用接口；同时制定`@FeignClient`的参数；
* `@FeignClient`注解中的`name`属性值是服务名称，即`feign`会通过`eureka`从注册中心查找名称为`name`的服务；
  * 比如：@FeignClient(name = "ea")意为通知Feign在调用该接口方法时要向Eureka中查询名为ea的服务，从而得到服务URL。

```java
// value 表示服务提供方注册到注册中心的服务名称（application.name）
// fallback 表示如果服务异常时，处理熔断返回类
// configuration 表示针对feignClient自定义的配置
@FeignClient(value = "micro-service-provider"
          , fallback = UserServiceClientFallback.class
          , configuration = UserServiceFeignConfiguration.class)
  public interface UserServiceClient{
    // 代码略
  }
  ```

* 实现一个熔断触发时的实现类；`UserServiceClientFallback`;

## 验证结果
> 请求地址 `http://localhost:8782/consumer-user-feign/info?name=xxx`
* 当`provider`服务正常时，返回正常数据；`hi,user_xxx,current time is 17-10-23 下午4:18.[data from micro-service-provider-dev]`
* 当`provider` 异常时，返回`来自熔断实现返回信息:name=xxx`;

### 验证POST请求(可以利用工具模拟，比如postman)
> 请求地址：`http://localhost:8782/consumer-user-feign/list`
* 正常访问时：返回 `params:key=key_3,value=value_4key=key_2,value=value_2key=key_1,value=value_1`
* 异常访问时，返回 `来自熔断实现返回信息:params:key=key_3,value=value_4key=key_2,value=value_2key=key_1,value=value_1`
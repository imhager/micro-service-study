# 一般方式调用
> 详见项目 `micro-service-consumer`

# 利用feign进行调用
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
* 实现一个熔断触发时的实现类；`UserServiceClientHystrix`;

## 验证结果
> 请求地址 `http://localhost:8782/consumer-user-feign/info?name=xxx`
* 当`provider`服务正常时，返回正常数据；`hi,user_xxx,current time is 17-10-23 下午4:18.[data from micro-service-provider-dev]`
* 当`provider` 异常时，返回`来自熔断实现返回信息:name=xxx`;

### 验证POST请求(可以利用工具模拟，比如postman)
> 请求地址：`http://localhost:8782/consumer-user-feign/list`
* 正常访问时：返回 `params:key=key_3,value=value_4key=key_2,value=value_2key=key_1,value=value_1`
* 异常访问时，返回 `来自熔断实现返回信息:params:key=key_3,value=value_4key=key_2,value=value_2key=key_1,value=value_1`
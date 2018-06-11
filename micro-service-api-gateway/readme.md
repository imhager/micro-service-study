# 服务网关 2018-06-11

> 网关，是一个比较重要的一个环节。可以承担着很多重要的角色。微服务的整体架构中，网关是最重要的一个环节。

* 限流
* 降级
* 认证
* 拦截（日志等切面）
* 聚合服务


## 示例


* 请求`http://localhost:9761/aggregate/10086`

```json
{
"userId": 10086,
"userName": "唐嫣",
"age": 18,
"orderList": [
{
"orderId": 10086,
"userId": 9527,
"orderName": "orderId=10,086,current time is 18-6-11 上午10:42.[data from micro-service-provider-dev]",
"createTime": 1528684958859
}
]
}

```
 
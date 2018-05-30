# 灰度发布

* [通过修改ribbon rule实现](https://blog.csdn.net/tianyaleixiaowu/article/details/79130646)
* [引入别的包实现](https://blog.csdn.net/tianyaleixiaowu/article/details/78083269)

```text
// https://github.com/jmnarloch/ribbon-discovery-filter-spring-cloud-starter
<dependency>  
            <groupId>io.jmnarloch</groupId>  
            <artifactId>ribbon-discovery-filter-spring-cloud-starter</artifactId>  
            <version>2.1.0</version>  
        </dependency> 
```

* 但是需要注意的是，如果注册中心使用的是非netflix eureka的话，该依赖是不起作用的。
> Due to lack of proper abstraction in Spring Cloud, this extension is targeting only Netflix Eureka, it's not going to work if you will use Consul or Zookeeper as your Spring Cloud enabled discovery services.

* 可以通过设置禁用该功能 `ribbon.filter.metadata.enabled=false`，默认是`true`

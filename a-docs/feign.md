# feign 
> Feign中对 Hystrix 有依赖关系。Feign只是一个便利的rest框架，简化调用，最后还是通过ribbon在注册服务器中找到服务实例，然后对请求进行分配。
* feign 很多特性讲解 https://segmentfault.com/a/1190000011675354
* 实现功能 https://blog.csdn.net/forezp/article/details/73480304?winzoom=1
* 牛逼分析 https://blog.de-swaef.eu/the-netflix-stack-using-spring-boot-part-3-feign/


## feign httpclient 

> Feign的HTTP Client
  Feign在默认情况下使用的是JDK原生的URLConnection发送HTTP请求，没有连接池，但是对每个地址会保持一个长连接，
  即利用HTTP的persistence connection 。
  我们可以用Apache的HTTP Client替换Feign原始的http client, 从而获取连接池、超时时间等与性能息息相关的控制能力。
  Spring Cloud从Brixtion.SR5版本开始支持这种替换，首先在项目中声明Apache HTTP Client和feign-httpclient依赖：
```text
在pom文件加上：

<dependency>
    <groupId>com.netflix.feign</groupId>
    <artifactId>feign-httpclient</artifactId>
    <version>RELEASE</version>
</dependency>
同理，如果想要feign使用Okhttp，则只需要在pom文件上加上feign-okhttp的依赖：
<dependency>
    <groupId>com.netflix.feign</groupId>
    <artifactId>feign-okhttp</artifactId>
    <version>RELEASE</version>
</dependency>
```   
然后在application.properties中添加：`feign.httpclient.enabled=true`，其实这个配置也可以不用写。默认就是`true`.

## Feign request/response compression
> You may consider enabling the request or response GZIP compression for your Feign requests. 
You can do this by enabling one of the properties:
```text
  feign.compression.request.enabled=true
  feign.compression.response.enabled=true
  Feign request compression gives you settings similar to what you may set for your web server:
  feign.compression.request.enabled=true
  feign.compression.request.mime-types=text/xml,application/xml,application/json
  feign.compression.request.min-request-size=2048
```
These properties allow you to be selective about the compressed media types and minimum request threshold length.
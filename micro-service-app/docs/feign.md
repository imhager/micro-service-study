# feign 
> Feign中对 Hystrix 有依赖关系。Feign只是一个便利的rest框架，简化调用，最后还是通过ribbon在注册服务器中找到服务实例，然后对请求进行分配。
* https://segmentfault.com/a/1190000011675354
* 实现功能 https://blog.csdn.net/forezp/article/details/73480304?winzoom=1

## feign httpclient 

> Feign的HTTP Client
  Feign在默认情况下使用的是JDK原生的URLConnection发送HTTP请求，没有连接池，但是对每个地址会保持一个长连接，即利用HTTP的persistence connection 。我们可以用Apache的HTTP Client替换Feign原始的http client, 从而获取连接池、超时时间等与性能息息相关的控制能力。Spring Cloud从Brixtion.SR5版本开始支持这种替换，首先在项目中声明Apache HTTP Client和feign-httpclient依赖：
```text
  <!-- 使用Apache HttpClient替换Feign原生httpclient -->
          <dependency>
              <groupId>org.apache.httpcomponents</groupId>
              <artifactId>httpclient</artifactId>
          </dependency>
          <dependency>
              <groupId>com.netflix.feign</groupId>
              <artifactId>feign-httpclient</artifactId>
              <version>${feign-httpclient}</version>
          </dependency>
```   
然后在application.properties中添加：  
  `feign.httpclient.enabled=true`
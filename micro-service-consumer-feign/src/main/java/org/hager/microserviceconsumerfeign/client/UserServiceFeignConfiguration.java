package org.hager.microserviceconsumerfeign.client;

import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wzh
 * @date: 2018/05/29 18:00
 * Description: 自定义配置，一般用于扩展属性、覆盖默认设置等
 * 如果你需要一个额外的属性，或者想覆盖一个属性，你可以为每一个FeignClient创建自定义的属性Bean
 */

@Configuration
public class UserServiceFeignConfiguration {
    public static final int FIVE_SECONDS = 5000;

    // @Bean
    // Retryer feignRetryer() {
    //     return Retryer.NEVER_RETRY;
    // }

    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(FIVE_SECONDS, FIVE_SECONDS);
    }

    // 这容易出问题是： Method getUsers not annotated with HTTP method type (ex. GET, POST)
    // https://www.cnblogs.com/myibm/p/8032684.html
    // @Bean
    // public Contract feignContract() {
    //     return new feign.Contract.Default();
    // }

    /**
     * 鉴权时，设置
     */
    // @Bean
    // public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    //     return new BasicAuthRequestInterceptor("user", "password");
    // }
}

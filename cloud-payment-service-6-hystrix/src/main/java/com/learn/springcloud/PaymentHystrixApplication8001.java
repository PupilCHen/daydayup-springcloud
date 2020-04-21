package com.learn.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * 支付模块的启动类
 *  服务降级：超时配置或者程序异常（讲解了客户端和服务端，一般是调用方考虑服务降级）
 *    1、主启动类： @EnableCircuitBreaker
 *    2、在service方法上：@HystrixCommand 和  @HystrixProperty 相关的配置 ==》什么情况下采用服务降级的措施
 *  服务熔断
 *  服务限流
 *  *
 * @author ct
 * @date 2020/3/13 2:44 下午
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class PaymentHystrixApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixApplication8001.class, args);
    }

    /**
     * management.endpoints.exposure.include.hystrix.stream
     *
     * 此配置是为了服务监控而配置，与服务器容错本身无关，springcloud升级后的坑
     * ServletRegistrationBean 因为springboot的默认路径不是"/hystrix.stream"
     * 只要在自己的项目配置上面的servlet就可以了
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);

        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}

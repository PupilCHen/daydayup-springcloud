package com.learn.springcloud.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 订单服务的启动类
 *
 * Caused by: org.xml.sax.SAXParseException: 文档根元素 "beans" 必须匹配 DOCTYPE 根 "null"。
 * 导致这个异常的原因是，application.xml，SpringBoot不允许使用这个名称，修改名称为：application-spring.xml 正常启动
 *
 * @author ct
 * @EnableDiscoveryClient
 * @EnableEurekaClient
 * @date 2020/3/13 8:00 下午
 */
@EnableEurekaClient
//@EnableDiscoveryClient
@SpringBootApplication
//@RibbonClient(name = "cloud-payment-service", configuration = MyConfigRules.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}

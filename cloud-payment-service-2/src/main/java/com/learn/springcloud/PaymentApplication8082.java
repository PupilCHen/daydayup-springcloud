package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 支付模块的启动类
 *
 * @author ct
 * @date 2020/3/13 2:44 下午
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentApplication8082 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8082.class, args);
    }
}

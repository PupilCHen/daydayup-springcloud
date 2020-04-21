package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Zookeeper注册中心启动类
 *
 * @author ct
 * @date 2020/3/14 1:31 下午
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentApplication8084 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8084.class, args);
    }
}

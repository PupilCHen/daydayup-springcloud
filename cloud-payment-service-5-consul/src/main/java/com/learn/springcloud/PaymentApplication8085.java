package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Consul整合启动类
 *
 * @author ct
 * @date 2020/3/14 3:18 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication8085 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8085.class, args);
    }
}

package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ct
 * @date 2020/4/2 4:39 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosApplication9002.class, args);
    }
}

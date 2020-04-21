package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ct
 * @date 2020/4/2 4:31 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosApplication9001.class, args);
    }
}

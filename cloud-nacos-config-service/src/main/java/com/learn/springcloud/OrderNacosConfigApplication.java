package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ct
 * @date 2020/4/2 5:47 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosConfigApplication.class, args);
    }
}

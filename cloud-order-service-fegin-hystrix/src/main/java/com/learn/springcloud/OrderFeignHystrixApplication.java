package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 客户端
 *  服务降级
 *      1、主启动类添加注解开启断路器：@EnableHystrix
 *      2、修改yml配置文件，开启断路器
 *      3、指定服务降级配置（在Controller层）
 *
 *      降级级别：
 *          方法级别
 *          类级别
 *          服务接口级别
 *
 *  服务熔断
 *
 *  服务限流
 * @author ct
 * @date 2020/3/27 11:58 下午
 */
@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class OrderFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixApplication.class, args);
    }
}

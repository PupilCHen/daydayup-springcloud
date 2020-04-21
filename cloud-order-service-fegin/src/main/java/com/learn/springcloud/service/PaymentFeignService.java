package com.learn.springcloud.service;

import com.learn.springcloud.entities.CommonsResult;
import com.learn.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign负载均衡service
 *
 * @author ct
 * @date 2020/3/27 10:26 上午
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 使用Feign负载均衡
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    CommonsResult<Payment> queryPaymentById(@PathVariable("id") Long id);

    /**
     * 测试openFeign超时时间配置
     *
     * @return
     */
    @GetMapping("/payment/forOpenFeignTimeout")
    CommonsResult<Payment> forOpenFeignTimeout();
}

package com.learn.springcloud.controller;

import com.learn.springcloud.entities.CommonsResult;
import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Feign客户端Controller
 * 与Ribbon不同点：
 * @author ct
 * @date 2020/3/27 10:29 上午
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get/{id}")
    public CommonsResult<Payment> queryPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.queryPaymentById(id);
    }

    @GetMapping("/forOpenFeignTimeout")
    public CommonsResult<Payment> forOpenFeignTimeout(){
        return paymentFeignService.forOpenFeignTimeout();
    }
}

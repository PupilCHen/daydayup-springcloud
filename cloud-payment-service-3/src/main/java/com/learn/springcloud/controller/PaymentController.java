package com.learn.springcloud.controller;

import com.learn.springcloud.entities.CommonsResult;
import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.servcie.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 支付API
 *
 * @author ct
 * @date 2020/3/13 3:14 下午
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Resource
    private EurekaDiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonsResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("支付成功.结果:{}", result);
        if (result <= 0) {
            return new CommonsResult<>(500, "支付失败！请稍后重试", null);
        }
        return new CommonsResult<>(200, "支付成功！处理服务器ip:" + serverPort, result);
    }

    @GetMapping("/get/{id}")
    public CommonsResult<Payment> queryPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryPaymentById(id);
        log.info("查询支付详情:{}", payment);
        if (payment == null) {
            return new CommonsResult<>(500, "查询失败！没找到支付记录。", null);
        }
        return new CommonsResult<>(200, "查询成功！处理服务器ip:" + serverPort, payment);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> log.info("Eureka Service:{}", service));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> log.info("{} - {} - {} - {}.",
                instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri()));
        return discoveryClient;
    }

    @GetMapping("/lb")
    public Object getPaymentLb() {
        return serverPort;
    }
}
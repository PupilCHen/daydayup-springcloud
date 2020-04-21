package com.learn.springcloud.conroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 支付模块 整合Consul API
 *
 * @author ct
 * @date 2020/3/14 1:33 下午
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String paymentConsul(){
        return "SpringCloud with Consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}

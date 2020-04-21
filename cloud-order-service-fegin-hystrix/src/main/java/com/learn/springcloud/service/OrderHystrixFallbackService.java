package com.learn.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author ct
 * @date 2020/3/28 11:57 下午
 */
@Component
public class OrderHystrixFallbackService implements OrderHystrixService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "服务降级处理：paymentInfoOk==》(灬ꈍ ꈍ灬)";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "服务降级处理：paymentInfoTimeOut==》(灬ꈍ ꈍ灬)";
    }
}

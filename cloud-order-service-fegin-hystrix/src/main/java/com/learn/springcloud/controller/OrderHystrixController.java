package com.learn.springcloud.controller;

import com.learn.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ct
 * @date 2020/3/28 12:01 上午
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "globalTimeOutFallbackMethod")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = orderHystrixService.paymentInfoOk(id);
        log.info("OrderHystrixController paymentInfoOk:{}", result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    //@HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallbackMethod", commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    //})
    //@HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        //int age = 10 / 0;
        String result = orderHystrixService.paymentInfoTimeOut(id);
        log.info("OrderHystrixController paymentInfoTimeOut:{}", result);
        return result;
    }

    public String paymentInfoTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        log.info("paymentInfoTimeOutFallbackMethod ==》(灬ꈍ ꈍ灬)");
        return "消费者80，对方支付系统繁忙，请稍后10秒后重试.";
    }

    public String globalTimeOutFallbackMethod() {
        log.info("消费者统一处理服务降级，请稍后10秒后重试.==》(灬ꈍ ꈍ灬)");
        return "消费者统一处理服务降级，请稍后10秒后重试.";
    }

}

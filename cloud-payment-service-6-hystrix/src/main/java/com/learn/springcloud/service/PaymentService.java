package com.learn.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ct
 * @date 2020/3/27 11:20 下午
 */
@Slf4j
@Service
public class PaymentService {

    public String paymentInfoOk(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "  paymentInfoOk,id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeOut(Integer id) {
        int timeOut = 3;
        // 超时
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (Exception e) {
            log.info("失败", e.getCause());
        }

        // 程序错误
        //int age = 10 / 0;
        return "线程池:" + Thread.currentThread().getName()
                + "  paymentInfoTimeOut,id:" + id + "O(∩_∩)O哈哈~" + "耗时" + timeOut + "秒.";
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "系统繁忙，请稍后重试." + "(灬ꈍ ꈍ灬)";
    }

    /**
     * 开启熔断，在10秒内如果请求10次，失败率达到60%，就熔断；睡眠时间窗口期，尝试是否恢复。
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")

    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能小于等于0");
        }
        return Thread.currentThread().getName() + "调用成功，流水号：" + IdUtil.simpleUUID();
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return "参数ID 不能死负数或者0，请重新输入参数重试.(灬ꈍ ꈍ灬)";
    }
}

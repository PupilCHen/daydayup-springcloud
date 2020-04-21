package com.learn.springcloud.boot.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载均衡算法
 * 1、注释掉启动类的：@RibbonClient(name = "cloud-payment-service", configuration = MyConfigRules.class)
 * 2、注释掉：RestTemplate的@LoadBalanced
 *
 * @author ct
 * @date 2020/3/27 9:38 上午
 */
public interface LoadBalancer {
    /**
     * 获取服务器实例
     *
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}

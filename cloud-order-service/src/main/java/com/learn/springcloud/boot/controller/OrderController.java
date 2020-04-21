package com.learn.springcloud.boot.controller;

import com.learn.springcloud.boot.lb.MyLoadBalancer;
import com.learn.springcloud.entities.CommonsResult;
import com.learn.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单消费api
 *
 * @author ct
 * @date 2020/3/13 8:02 下午
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {
    /**
     * 单机配置：public static final String PAYMENT_URL = "http://localhost:8081";
     */
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private MyLoadBalancer myLoadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 需要配置这个注解，才能将参数传递 @RequestBody
     *
     * @param payment
     * @return com.learn.springcloud.entities.CommonsResult<com.learn.springcloud.entities.Payment>
     * @date 2020/3/13 8:27 下午
     */
    @PostMapping("/create")
    public CommonsResult<Payment> create(Payment payment) {
        CommonsResult commonsResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonsResult.class);
        log.info("Order 请求支付返回:{}", commonsResult);
        return commonsResult;
    }


    @GetMapping("/get/{id}")
    public CommonsResult<Payment> getPayment(@PathVariable("id") Long id) {
        CommonsResult result = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonsResult.class);
        log.info("Order获取支付详情:{}", result);
        return result;
    }

    /**
     * 整合ZK注册中心
     *
     * @return java.lang.String
     * @date 2020/3/14 3:34 下午
     */
    @GetMapping("/zk")
    public String zk() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }

    /**
     * 整合consul注册中心
     *
     * @return java.lang.String
     * @date 2020/3/14 3:34 下午
     */
    @GetMapping("/consul")
    public String consul() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }

    @GetMapping("/getForEntity/{id}")
    public CommonsResult<Payment> getPaymentForEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonsResult> result = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonsResult.class);

        log.info("Order获取支付详情:{}", result);
        if (result.getStatusCode().is2xxSuccessful()) {
            return result.getBody();
        }
        return new CommonsResult<>(500, "查询失败!", null);
    }

    /**
     * 测试自定义负载均衡算法
     *
     * @return
     */
    @GetMapping("/lb")
    public Object getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (CollectionUtils.isEmpty(instances)) {
            return null;
        }
        ServiceInstance instance = myLoadBalancer.instances(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/lb", String.class);
    }
}

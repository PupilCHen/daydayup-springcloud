package com.learn.springcloud.boot.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义实现负债均衡
 *
 * @author ct
 * @date 2020/3/27 9:40 上午
 */
@Slf4j
@Component
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger serverCyclicCounter = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.serverCyclicCounter.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.serverCyclicCounter.compareAndSet(current, next));
        log.info("访问次数是next数值:{}", next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}

package com.learn.springcloud.rules;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 实现Ribbon负载均衡的其他算法
 * 它是集成在消费方的负载均衡
 *
 * @author ct
 * @date 2020/3/14 6:07 下午
 */
@Configuration
public class MyConfigRules {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}

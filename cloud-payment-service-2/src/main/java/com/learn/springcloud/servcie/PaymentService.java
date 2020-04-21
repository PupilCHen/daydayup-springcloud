package com.learn.springcloud.servcie;

import com.learn.springcloud.entities.Payment;

/**
 * 支付业务逻辑处理
 *
 * @author ct
 * @date 2020/3/13 3:10 下午
 */
public interface PaymentService {
    /**
     * 插入支付记录
     *
     * @param payment
     * @return int
     * @date 2020/3/13 2:55 下午
     */
    int insert(Payment payment);

    /**
     * 根据id查询支付记录
     *
     * @param id
     * @return com.learn.springcloud.entities.Payment
     * @date 2020/3/13 2:57 下午
     */
    Payment queryPaymentById(Long id);
}

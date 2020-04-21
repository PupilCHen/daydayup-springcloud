package com.learn.springcloud.dao;

import com.learn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 支付模块的Dao层
 *
 * @author ct
 * @date 2020/3/13 2:54 下午
 */
@Mapper
public interface PaymentDao {
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
    Payment queryPaymentById(@Param("id") Long id);
}

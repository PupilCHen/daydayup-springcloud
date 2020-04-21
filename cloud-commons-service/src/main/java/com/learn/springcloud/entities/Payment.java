package com.learn.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 支付模块 支付实体类
 *
 * @author ct
 * @date 2020/3/13 2:46 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private static final long serialVersionUID = 588422947710852783L;

    private Long id;
    private String serial;
}

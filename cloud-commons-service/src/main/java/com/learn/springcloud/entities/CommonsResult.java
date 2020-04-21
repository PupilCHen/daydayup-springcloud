package com.learn.springcloud.entities;

import lombok.*;

/**
 * 公共返回参数实体
 *
 * @author ct
 * @date 2020/3/13 2:51 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CommonsResult<T> {

    @NonNull
    private Integer code;
    private String message;
    private T data;
}

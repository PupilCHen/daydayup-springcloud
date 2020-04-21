package com.learn.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 钓鱼的人
 *
 * @author ct
 * @date 2020/3/17 11:19 下午
 */
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private FishingRod fr;

    /**
     * 钓鱼
     */
    public void fish() {
        fr.used();
    }

    public void setFr(FishingRod fr) {
        this.fr = fr;
    }
}

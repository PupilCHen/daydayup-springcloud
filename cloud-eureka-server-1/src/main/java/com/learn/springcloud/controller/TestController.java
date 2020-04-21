package com.learn.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试URL是否正常访问
 *
 * @author ct
 * @date 2020/3/13 9:56 下午
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test(){
        return "Test Success";
    }
}
package com.learn.springcloud.controller;

import com.learn.springcloud.domain.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ct
 * @date 2020/4/10 12:50 下午
 */
@RestController
public class UserController {
    @GetMapping("/insert")
    @ResponseBody
    public User insertUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.err.println(error.getDefaultMessage());
            }
        }
        return user;
    }
}
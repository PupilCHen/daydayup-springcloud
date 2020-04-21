package com.learn.springcloud.boot.test;

import com.learn.springcloud.entities.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Spring自动注入的bean注入方式
 *
 * @author ct
 * @date 2020/3/17 11:22 下午
 */
public class AssembleTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-spring.xml");
        Person person = (Person)context.getBean("person");
        person.fish();
    }
}

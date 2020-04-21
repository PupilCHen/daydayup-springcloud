package com.learn.springcloud.entities;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 测试Spring创建属性
 *
 * @author ct
 * @date 2020/3/17 11:07 下午
 */
@Data
public class Department {
    private String name;
    private String[] empName;
    /**
     * List集合
     */
    private List<Employee> empList;
    /**
     * Set集合
     */
    private Set<Employee> empSets;
    /**
     * map集合
     */
    private Map<String, Employee> empMap;
    /**
     * Properties的使用
     */
    private Properties pp;
}
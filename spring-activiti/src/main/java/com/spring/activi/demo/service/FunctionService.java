package com.spring.activi.demo.service;

import java.util.Map;

/**
 * @author: wufeng
 * @date: 2018/7/3 17:52
 * @desrcption: 抽象类，子类实现父类
 */
public interface FunctionService {

    /**
     *
     * @author wufeng
     * @date 2018/7/4 15:47
     * @param value 待计算的公式
     * @param map 公式当中的参数和值
     * @descption
     * @return java.lang.Object
     */
    Object expressRun(String value, Map<String, Object> map);
}

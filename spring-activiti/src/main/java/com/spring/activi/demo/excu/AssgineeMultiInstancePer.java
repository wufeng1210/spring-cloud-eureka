package com.spring.activi.demo.excu;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: wufeng
 * @date: 2018/6/19 16:12
 * @desrcption: 设置会签人员
 */
public class AssgineeMultiInstancePer implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("设置会签人员");
        execution.setVariable("pers", Arrays.asList("张三", "李四", "王五", "赵六"));
    }
}

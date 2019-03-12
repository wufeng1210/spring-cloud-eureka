package com.spring.activi.demo.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * @author: wufeng
 * @date: 2018/6/19 16:17
 * @desrcption: 测试会签过程中监听器的执行过程
 */
public class TestListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.print(delegateTask.getId() + " - " + delegateTask.getProcessInstanceId()
                + " - " + delegateTask.getEventName() + " - " + delegateTask.getTaskDefinitionKey());
    }
}

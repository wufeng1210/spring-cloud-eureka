package com.spring.activi.demo.task;

import org.activiti.engine.delegate.DelegateExecution;

import java.io.Serializable;

/**
 * @author: wufeng
 * @date: 2018/6/19 16:15
 * @desrcption: 多实例完成的条件判断
 */
public class MulitiInstanceCompleteTask implements Serializable {

    public boolean completeTask(DelegateExecution execution) {
        System.out.println("总的会签任务数量：" + execution.getVariable("nrOfInstances")
                + "当前获取的会签任务数量：" + execution.getVariable("nrOfActiveInstances") + " - "
                + "已经完成的会签任务数量：" + execution.getVariable("nrOfCompletedInstances"));
        System.out.println("I am invoked.");
        return false;
    }
}

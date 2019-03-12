package com.spring.activi.demo.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.Arrays;

/**
 * @author: wufeng
 * @date: 2018/6/19 18:24
 * @desrcption: 单人会签 添加审批人 一人同意即可下一步
 */
public class ManagerTaskHandlerCandidateUser implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("设置单人会签人员");
        String[] empLoyees = {"wangba","wangjiu"};
        delegateTask.addCandidateUsers(Arrays.asList(empLoyees));
    }
}

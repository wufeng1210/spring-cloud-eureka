package com.spring.activi.demo.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wufeng
 * @date: 2018/6/19 15:41
 * @desrcption:
 */
@Service
public class MyTaskListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("delegateTask.getEventName"+ delegateTask.getEventName());
        //添加会签的人员，以下所有的都审批通过才可进入下一环节
        List<String> assigneeList = new ArrayList<String>();
        assigneeList.add("wangba");
        assigneeList.add("wangjiu");
        delegateTask.setVariable("assigneeList",assigneeList);
    }
}

package com.spring.activi.demo.service;

import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: wufeng
 * @date: 2018/6/19 11:02
 * @desrcption:
 */
@RestController
@RequestMapping("/activityService")
public interface ActivityConsumerService {

    /**
     *
     * @author wufeng
     * @date 2018/6/19 11:03
     * @param
     * @descption 流程demo
     * @return
     */
    @RequestMapping(value = "/startActivityDemo")
    boolean startActivityDemo();

    /**
     * 会签：多人同意才能下一步
     * @author wufeng
     * @date 2018/6/19 17:17
     * @param
     * @descption
     * @return void
     */
    @RequestMapping(value = "/multiln")
    void multiDemo();
    /**
     *
     * @author wufeng
     * @date 2018/6/20 11:23
     * @param
     * @descption 查询个人待办业务
     * @return java.util.List<org.activiti.engine.task.Task>
     */
    @RequestMapping(value = "/findMyPersonlTask")
    void findMyPersonlTask();

    @RequestMapping(value = "/findActivitiImpl")
    ActivityImpl findActivitiImpl(String taskId, String activityId);

    @RequestMapping(value = "/findProcess")
    void findProcess();

    @RequestMapping(value = "/singlesign")
    void singleSign();

    @RequestMapping(value = "/endProcess")
    void endProcess(String taskId);

    @RequestMapping(value = "/taskRollBack")
    void taskRollBack(String taskId);

    @RequestMapping(value = "/processInstance")
    void processInstance();

}

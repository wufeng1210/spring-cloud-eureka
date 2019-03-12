package com.spring.activi.demo.service.impl;

import com.spring.activi.demo.pojo.JumpTaskCmd;
import com.spring.activi.demo.service.ActivityConsumerService;
import com.spring.activi.demo.task.MulitiInstanceCompleteTask;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.TaskServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.groovy.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wufeng
 * @date: 2018/6/19 11:04
 * @desrcption:
 */
@Service("activityService")
public class ActivityConsumerServiceImpl implements ActivityConsumerService {

    private static Logger logger = LoggerFactory.getLogger(ActivityConsumerServiceImpl.class);

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private HistoryService historyService;


    @Override
    public boolean startActivityDemo() {
        System.out.println("method startActivityDemo begin....");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("apply","zhangsan");
        map.put("approve","lisi");

        //流程启动
        ExecutionEntity pi1 = (ExecutionEntity) runtimeService.startProcessInstanceByKey("leave",map);
        System.out.println(pi1.getId() + " " + pi1.getName());

        String processId = pi1.getId();
        String taskId = pi1.getTasks().get(0).getId();
        taskService.complete(taskId, map);//完成第一步申请

        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        String taskId2 = task.getId();
        map.put("pass", false);
        taskService.complete(taskId2, map);//驳回申请
        System.out.println("method startActivityDemo end....");
        return false;
    }

    /**
     * 会签：多人同意才能下一步
     * @author wufeng
     * @date 2018/6/19 17:17
     * @param
     * @descption
     * @return void
     */

    @Override
    public void multiDemo() {
        // 流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();

//        Deployment deployment = repositoryService.createDeployment().name("会签流程测试").addInputStream("multiInstances.bpmn", this.getClass().getResourceAsStream("multiInstances.bpmn"))//
//                .deploy();
        // 开始流程
    //    ExecutionEntity deployment = (ExecutionEntity) runtimeService.startProcessInstanceByKey("multiInstances");
       // deployment.setName("会签流程测试");
      //  System.out.println(deployment.getId() + " " + deployment.getName());
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("mulitiInstance", new MulitiInstanceCompleteTask());
        // 启动流程实例
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("multiInstances",variables);
        System.out.println(pi.getId() + "  " + pi.getActivityId());
        Task task1 = taskService.createTaskQuery().processInstanceId(pi.getId()).taskAssignee("张三").singleResult();
        System.out.println(task1.getId() + " - " + task1.getAssignee() + " - " + task1.getProcessInstanceId() + " - " + task1.getProcessDefinitionId());
        Task task2 = taskService.createTaskQuery().processInstanceId(pi.getId()).taskAssignee("李四").singleResult();
        System.out.println(task2.getId() + " - " + task2.getAssignee() + " - " + task2.getProcessInstanceId() + " - " + task2.getProcessDefinitionId());
        Task task3 = taskService.createTaskQuery().processInstanceId(pi.getId()).taskAssignee("王五").singleResult();
        System.out.println(task3.getId() + " - " + task3.getAssignee() + " - " + task3.getProcessInstanceId() + " - " + task3.getProcessDefinitionId());
        Task task4 = taskService.createTaskQuery().processInstanceId(pi.getId()).taskAssignee("赵六").singleResult();
        if (task4 != null) {
            System.out.println(task4.getId() + " - " + task4.getAssignee() + " - " + task4.getProcessInstanceId() + " - " + task4.getProcessDefinitionId());
        }
        taskService.complete(task1.getId());
        taskService.complete(task2.getId());
    //    taskService.complete(task3.getId());
        taskService.complete(task4.getId());
        Task task7 = taskService.createTaskQuery().processInstanceId(pi.getId()).taskAssignee("钱七").singleResult();
        System.out.println(task7);
     //   taskService.complete(task7.getId());
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult();
        if (null == processInstance) {
            System.out.println("流程完成.");
        } else {
            // 流程未完成的
            System.out.println(processInstance.getId() + "---" + processInstance.getName());
        }
    }


    /**
     *
     * @author wufeng
     * @date 2018/6/20 14:58
     * @param
     * @descption
     * @return
     */
    @Override
    public void singleSign() {
        Map<String,Object> map = new HashMap<String,Object>();
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        map.put("apply","zhangsan");

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("signCount", 0);
        //流程启动
        ExecutionEntity pi1 = (ExecutionEntity) runtimeService.startProcessInstanceByKey("singlesigning", variables);

        taskService.complete(pi1.getId());


    }

    /**
     *
     * @author wufeng
     * @date 2018/6/20 11:23
     * @param
     * @descption 查询个人待办业务
     * @return java.util.List<org.activiti.engine.task.Task>
     */
    @Override
    public void findMyPersonlTask() {

        List<Task> list = processEngine.getTaskService().createTaskQuery().taskAssignee("张三")
 //               .taskCandidateUser(candidateUser)//组任务的办理人查询
//						.processDefinitionId(processDefinitionId)//使用流程定义ID查询
//						.processInstanceId(processInstanceId)//使用流程实例ID查询
//						.executionId(executionId)//使用执行对象ID查询
                .orderByTaskCreateTime().asc()
                /**返回结果集*/
//						.singleResult()//返回惟一结果集
//						.count()//返回结果集的数量
//						.listPage(firstResult, maxResults);//分页查询
                .list();
        System.out.println(list);

    }

    @Override
    public void findProcess(){
        try {
            ProcessInstance processInstance =  findProcessInstanceByTaskId("7514");
            System.out.println(processInstance.getId());
            historyActInstanceList();
            // 查询当前实例的任务
            List<Task> tasks = taskService.createTaskQuery().processInstanceId("7501").list();
            System.out.println(tasks);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //流程实例的id
    public void historyActInstanceList(){
        // 表act_hi_actinst
        List<HistoricActivityInstance>  list=processEngine.getHistoryService() // 历史相关Service
                .createHistoricActivityInstanceQuery() // 创建历史活动实例查询
                .processInstanceId("50001") // 执行流程实例id
                .finished()
                .list();
        for(HistoricActivityInstance hai:list){
            System.out.println("活动ID:"+hai.getId());
            System.out.println("流程实例ID:"+hai.getProcessInstanceId());
            System.out.println("活动名称："+hai.getActivityName());
            System.out.println("办理人："+hai.getAssignee());
            System.out.println("开始时间："+hai.getStartTime());
            System.out.println("结束时间："+hai.getEndTime());
            System.out.println("=================================");
        }
    }

    /**
     * 根据任务ID获取流程定义
     *
     * @param taskId
     *            任务ID
     * @return
     * @throws Exception
     */
    private ProcessDefinitionEntity findProcessDefinitionEntityByTaskId(
            String taskId) throws Exception {
        // 取得流程定义
        ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
                .getDeployedProcessDefinition(findTaskById(taskId)
                        .getProcessDefinitionId());

        if (processDefinition == null) {
            throw new Exception("流程定义未找到!");
        }

        return processDefinition;
    }

    /**
     * 根据任务ID获得任务实例
     *
     * @param taskId
     *            任务ID
     * @return
     * @throws Exception
     */
    private TaskEntity findTaskById(String taskId) throws Exception {
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId(
                taskId).singleResult();
        if (task == null) {
            throw new Exception("任务实例未找到!");
        }
        return task;
    }

    /**
     * 中止流程(特权人直接审批通过等)
     *
     * @param taskId
     */
    @Override
    public void endProcess(String taskId) {
        ActivityImpl endActivity = findActivitiImpl(taskId, "end");
        try{
            commitProcess(taskId, null, endActivity.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 取回流程
     *
     * @param taskId
     *            当前任务ID
     * @param activityId
     *            取回节点ID
     * @throws Exception
     */
    public void callBackProcess(String taskId, String activityId)
            throws Exception {
        if (StringUtils.isBlank(activityId)) {
            throw new Exception("目标节点ID为空！");
        }

        // 查找所有并行任务节点，同时取回
        List<Task> taskList = findTaskListByKey(findProcessInstanceByTaskId(
                taskId).getId(), findTaskById(taskId).getTaskDefinitionKey());
        for (Task task : taskList) {
            commitProcess(task.getId(), null, activityId);
        }
    }

    @Override
    public void processInstance(){
        // 挂起
     //   testSuspendProcessInstance();

        // 激活
        testActivateProcessInstance();
    }
    /**
     *
     * @author wufeng
     * @date 2018/6/21 9:41
     * @param
     * @descption  挂起流程
     * @return void
     */
    public void testSuspendProcessInstance(){
        RuntimeService runtimeService = processEngine.getRuntimeService();

        String processInstanceId="7501";
        //根据一个流程实例的id挂起该流程实例
        runtimeService.suspendProcessInstanceById(processInstanceId);

    }

    /**
     *
     * @author wufeng
     * @date 2018/6/21 9:41
     * @param
     * @descption 激活流程
     * @return void
     */
    public void testActivateProcessInstance(){
        RuntimeService runtimeService = processEngine.getRuntimeService();

        String processInstanceId="7501";

        runtimeService.activateProcessInstanceById(processInstanceId);
    }



    @Override
    public void taskRollBack(String taskId){
       // updateTaskJumpByAssignee("17501", "application", "lisi");
        try{
          //  updateTaskTurnBackByAssignee("72566","72551","","","");

            returnAssignmengByTaskId("75009", "75001");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void updateTaskJumpByAssignee(String procInsId, String activityId, String userId) {
        List<Execution> executions = runtimeService.createExecutionQuery().processInstanceId(procInsId).list();
        if (executions.size() > 0)
        {
            String executionId = executions.get(0).getId();
            List<String> executionIds = new ArrayList<>();
            for (Execution execution : executions)
            {
                executionIds.add(execution.getId());
            }
            TaskServiceImpl taskServiceImpl = (TaskServiceImpl) taskService;
            taskServiceImpl.getCommandExecutor().execute(new JumpTaskCmd(executionIds, activityId));
            for (Task task : taskService.createTaskQuery().executionId(executionId).list())
            {
                taskService.setAssignee(task.getId(), userId);
            }
        }
        else
        {
            System.out.println("流程实例id{" + procInsId + "}没有执行中任务实例！");
        }
    }

    private final String IS_RETURN_BACK_TASK = "is_return_back_tack";

    /**
     *
     * @author wufeng
     * @date 2018/6/20 17:48
     * @param taskId, procInstId, approvers, type, message
     * @descption  回退上一节点
     * @return boolean
     */
    public boolean updateTaskTurnBackByAssignee(String taskId, String procInstId, String approvers, String type,
                                                String message) {

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (null == task)
        {
            throw new RuntimeException("任务ID：" + taskId + "没有查询到任务信息！");
        }
        // 查询最近的非退回的任务，退回的任务在catagory字段标示为IS_RETURN_BACK_TASK
        List<HistoricTaskInstance> historicTaskInstances = historyService.createHistoricTaskInstanceQuery()
                .processInstanceId(procInstId).orderByHistoricTaskInstanceEndTime().desc().list();
        HistoricTaskInstance turnBackTask = null;
        for (HistoricTaskInstance historicTaskInstance : historicTaskInstances)
        {
            String catagory = historicTaskInstance.getCategory();
            if (IS_RETURN_BACK_TASK.equals(catagory) || historicTaskInstance.getId().equals(taskId)
                    || historicTaskInstance.getTaskDefinitionKey().equals(task.getTaskDefinitionKey()))
            {
                continue;
            }
            else
            {
                turnBackTask = historicTaskInstance;
                break;
            }
        }
        if (null == turnBackTask)
        {
            throw new RuntimeException("没有可退回的任务！");
        }
        else
        {
            task.setCategory(IS_RETURN_BACK_TASK);
            taskService.saveTask(task);
            // 获取上一步审批人
            if (StringUtils.isBlank(approvers))
            {
                approvers = "";
                List<HistoricIdentityLink> historicIdentityLinks = historyService
                        .getHistoricIdentityLinksForTask(turnBackTask.getId());
                for (HistoricIdentityLink historicIdentityLink : historicIdentityLinks)
                {
                    approvers += historicIdentityLink.getUserId() + ",";
                }
                if (approvers.length() > 0)
                {
                    approvers = approvers.substring(0, approvers.length() - 1);
                }
            }
            if (StringUtils.isEmpty(approvers))
            {
                System.out.println("获取不到退回的审批人！");
            }
            try
            {
                this.updateTaskJumpByAssignee(procInstId, turnBackTask.getTaskDefinitionKey(), approvers);
            }
            catch (Exception e)
            {
                logger.error("WorkflowTaskService.updateTaskTurnBackByAssignee: " + e.getMessage(), e);
            }
        }
        return true;
    }

    /**
     *
     * @author wufeng
     * @date 2018/6/20 18:29
     * @param taskId, procInstId
     * @descption  返回指定节点
     * @return void
     */
    public void returnAssignmengByTaskId(String taskId, String procInstId){

        //根据实例id获取任务列表
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(procInstId).list();
        for(Task task: tasks){
            task.setCategory(IS_RETURN_BACK_TASK);
            taskService.saveTask(task);
        }
        String approvers = "";

        // 查询当前任务id的历史任务实例
        HistoricTaskInstance taskDefinitionKey = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
        //根据任务id获取人员
        List<HistoricIdentityLink> historicIdentityLinks = historyService.getHistoricIdentityLinksForTask(taskId);
        for (HistoricIdentityLink historicIdentityLink : historicIdentityLinks) {
            approvers += historicIdentityLink.getUserId() + ",";
        }
        if (approvers.length() > 0) {
            approvers = approvers.substring(0, approvers.length() - 1);
        }
        if (StringUtils.isEmpty(approvers)) {
            System.out.println("获取不到退回的审批人！");
        }
        try {
            logger.info(taskDefinitionKey.getTaskDefinitionKey());
            this.updateTaskJumpByAssignee(procInstId, taskDefinitionKey.getTaskDefinitionKey(), approvers);
        } catch (Exception e) {
            logger.error("WorkflowTaskService.updateTaskTurnBackByAssignee: " + e.getMessage(), e);
        }
    }
    /**
     * 根据流程实例ID和任务key值查询所有同级任务集合
     *
     * @param processInstanceId
     * @param key
     * @return
     */
    private List<Task> findTaskListByKey(String processInstanceId, String key) {
        return taskService.createTaskQuery().processInstanceId(
                processInstanceId).taskDefinitionKey(key).list();
    }

    /**
     * 根据任务ID获取对应的流程实例
     *
     * @param taskId
     *            任务ID
     * @return
     * @throws Exception
     */
    private ProcessInstance findProcessInstanceByTaskId(String taskId)
            throws Exception {
        // 找到流程实例
        ProcessInstance processInstance = runtimeService
                .createProcessInstanceQuery().processInstanceId(
                        findTaskById(taskId).getProcessInstanceId())
                .singleResult();
        if (processInstance == null) {
            throw new Exception("流程实例未找到!");
        }
        return processInstance;
    }


    /**
     * @param taskId
     *            当前任务ID
     * @param variables
     *            流程变量
     * @param activityId
     *            流程转向执行任务节点ID<br>
     *            此参数为空，默认为提交操作
     * @throws Exception
     */
    private void commitProcess(String taskId, Map<String, Object> variables,
                               String activityId) throws Exception {
        if (variables == null) {
            variables = new HashMap<String, Object>();
        }
        // 跳转节点为空，默认提交操作
        if (StringUtils.isBlank(activityId)) {
            taskService.complete(taskId, variables);
        } else {// 流程转向操作
            turnTransition(taskId, activityId, variables);
        }
    }

    /**
     * 流程转向操作
     *
     * @param taskId
     *            当前任务ID
     * @param activityId
     *            目标节点任务ID
     * @param variables
     *            流程变量
     * @throws Exception
     */
    private void turnTransition(String taskId, String activityId,
                                Map<String, Object> variables) throws Exception {
        // 当前节点
        ActivityImpl currActivity = findActivitiImpl(taskId, null);
        // 清空当前流向
        List<PvmTransition> oriPvmTransitionList = clearTransition(currActivity);

        // 创建新流向
        TransitionImpl newTransition = currActivity.createOutgoingTransition();
        // 目标节点
        ActivityImpl pointActivity = findActivitiImpl(taskId, activityId);
        // 设置新流向的目标节点
        newTransition.setDestination(pointActivity);

        // 执行转向任务
        taskService.complete(taskId, variables);
        // 删除目标节点新流入
        pointActivity.getIncomingTransitions().remove(newTransition);

        // 还原以前流向
        restoreTransition(currActivity, oriPvmTransitionList);
    }

    /**
     * 清空指定活动节点流向
     *
     * @param activityImpl
     *            活动节点
     * @return 节点流向集合
     */
    private List<PvmTransition> clearTransition(ActivityImpl activityImpl) {
        // 存储当前节点所有流向临时变量
        List<PvmTransition> oriPvmTransitionList = new ArrayList<PvmTransition>();
        // 获取当前节点所有流向，存储到临时变量，然后清空
        List<PvmTransition> pvmTransitionList = activityImpl
                .getOutgoingTransitions();
        for (PvmTransition pvmTransition : pvmTransitionList) {
            oriPvmTransitionList.add(pvmTransition);
        }
        pvmTransitionList.clear();

        return oriPvmTransitionList;
    }

    /**
     * 还原指定活动节点流向
     *
     * @param activityImpl
     *            活动节点
     * @param oriPvmTransitionList
     *            原有节点流向集合
     */
    private void restoreTransition(ActivityImpl activityImpl,
                                   List<PvmTransition> oriPvmTransitionList) {
        // 清空现有流向
        List<PvmTransition> pvmTransitionList = activityImpl
                .getOutgoingTransitions();
        pvmTransitionList.clear();
        // 还原以前流向
        for (PvmTransition pvmTransition : oriPvmTransitionList) {
            pvmTransitionList.add(pvmTransition);
        }
    }

    /**
     * 转办流程
     *
     * @param taskId
     *            当前任务节点ID
     * @param userCode
     *            被转办人Code
     */
    public void transferAssignee(String taskId, String userCode) {
        taskService.setAssignee(taskId, userCode);
    }

    /**
     * 根据任务ID和节点ID获取活动节点 <br>
     *
     * @param taskId
     *            任务ID
     * @param activityId
     *            活动节点ID <br>
     *            如果为null或""，则默认查询当前活动节点 <br>
     *            如果为"end"，则查询结束节点 <br>
     *
     * @return
     * @throws Exception
     */
   @Override
    public ActivityImpl findActivitiImpl(String taskId, String activityId){
       if(StringUtils.isEmpty(taskId)){
           taskId = "57562";
       }
       if(StringUtils.isEmpty(activityId)){
           activityId = "";
       }
        // 取得流程定义
        try {
            ProcessDefinitionEntity processDefinition = findProcessDefinitionEntityByTaskId(taskId);

            // 获取当前活动节点ID
            if (StringUtils.isBlank(activityId)) {
                activityId = findTaskById(taskId).getTaskDefinitionKey();
            }
            // 根据流程定义，获取该流程实例的结束节点
            if (activityId.toUpperCase().equals("END")) {
                for (ActivityImpl activityImpl : processDefinition.getActivities()) {
                    List<PvmTransition> pvmTransitionList = activityImpl
                            .getOutgoingTransitions();
                    if (pvmTransitionList.isEmpty()) {
                        System.out.println("end : "+activityImpl);
                        return activityImpl;
                    }
                }
            }

            // 根据节点ID，获取对应的活动节点
            ActivityImpl activityImpl = ((ProcessDefinitionImpl) processDefinition)
                    .findActivity(activityId);
            System.out.println("activity:::"+activityImpl.getProperties());
            return activityImpl;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

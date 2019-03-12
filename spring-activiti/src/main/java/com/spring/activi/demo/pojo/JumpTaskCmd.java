package com.spring.activi.demo.pojo;

import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.task.Comment;

import java.util.List;

/**
 * @author: wufeng
 * @date: 2018/6/20 17:10
 * @desrcption:
 */
public class JumpTaskCmd implements Command<Comment> {

    protected List<String> executionIds;
    protected String  activityId;
    public JumpTaskCmd(List<String> executionIds, String activityId)
    {
        this.executionIds = executionIds;
        this.activityId = activityId;
    }
    public Comment execute(CommandContext commandContext) {
        for (String executionId : executionIds) {
            for (TaskEntity taskEntity : Context.getCommandContext().getTaskEntityManager()
                    .findTasksByExecutionId(executionId)) {
                Context.getCommandContext().getTaskEntityManager().deleteTask(taskEntity, "jump", false);
            }
        }
        ExecutionEntity executionEntity = Context.getCommandContext().getExecutionEntityManager()
                .findExecutionById(executionIds.get(0));
        ProcessDefinitionImpl processDefinition = executionEntity.getProcessDefinition();
        ActivityImpl activity = processDefinition.findActivity(activityId);
        executionEntity.executeActivity(activity);
        return null;
    }
}

package com.zkw;

import org.activiti.engine.*;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.task.Task;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ProcessEngineCreationIntegrationTest {

    @Test
    public void givenXMLConfig_whenGetDefault_thenGotProcessEngine() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = processEngine.getIdentityService();
//        Group group = identityService.newGroup("1");
//        group.setName("经理组");
//        group.setType("manager");
//        identityService.saveGroup(group);

//        Group data = identityService.createGroupQuery().groupId("1").singleResult();
//        data.setName("ManagerGroup");
//        identityService.saveGroup(data);

        User user=identityService.newUser("1");
        user.setFirstName("Angus");
        user.setLastName("Young");
        user.setEmail("yangenxiong@163.com");
        user.setPassword("abc");
        identityService.saveUser(user);

        Assert.assertNotNull(processEngine);
        //Assert.assertEquals("root", processEngine.getProcessEngineConfiguration().getJdbcUsername());
    }

    @Test
    public void givenBPMN_whenDeployProcess_thenDeployed() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment()
                .addClasspathResource("bpmn/First.bpmn")
                .deploy();
        Long count = repositoryService.createProcessDefinitionQuery().count();
        Assert.assertTrue(count >= 1);
    }

    @Test
    public void testSimpleWorkflow(){
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 得到流程存储服务组件
        RepositoryService repositoryService = engine.getRepositoryService();
        // 得到运行时服务组件
        RuntimeService runtimeService = engine.getRuntimeService();
        // 获取流程任务组件
        TaskService taskService = engine.getTaskService();
        // 部署流程文件
        repositoryService.createDeployment()
                .addClasspathResource("bpmn/First.bpmn").deploy();
        // 启动流程
        runtimeService.startProcessInstanceByKey("process1");
        // 查询第一个任务
        Task task = taskService.createTaskQuery().singleResult();
        System.out.println("第一个任务完成前，当前任务名称：" + task.getName());
        // 完成第一个任务
        taskService.complete(task.getId());
        // 查询第二个任务
        task = taskService.createTaskQuery().singleResult();
        System.out.println("第二个任务完成前，当前任务名称：" + task.getName());
        // 完成第二个任务（流程结束）
        taskService.complete(task.getId());
        task = taskService.createTaskQuery().singleResult();
        System.out.println("流程结束后，查找任务：" + task);
    }

    @Test
    public void testStartById(){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = engine.getRepositoryService();
        RuntimeService runtimeService = engine.getRuntimeService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("bpmn/startById.bpmn20.xml").deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId()).singleResult();
        Map<String,Object> vars= new HashMap<String,Object>();
        vars.put("days",5);

        runtimeService.startProcessInstanceById(processDefinition.getId());
        runtimeService.startProcessInstanceById(processDefinition.getId(),vars);
        runtimeService.startProcessInstanceById(processDefinition.getId(),"vacationRequest1");
        runtimeService.startProcessInstanceById(processDefinition.getId(),"vacationRequest2",vars);

        long count=runtimeService.createProcessInstanceQuery().count();
        System.out.println("process instance number-->"+count);
    }

}

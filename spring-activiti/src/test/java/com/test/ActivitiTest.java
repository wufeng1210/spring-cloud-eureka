package com.test;

import org.activiti.engine.RuntimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wufeng
 * @date: 2018/6/19 10:24
 * @desrcption:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ActivitiTest {

//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Test
//    public void TestStartProcess() {
//        Map<String, Object> variables = new HashMap<>();
//        variables.put("applicantName", "John Doe");
//        variables.put("email", "john.doe@activiti.com");
//        variables.put("phoneNumber", "123456789");
//        runtimeService.startProcessInstanceByKey("myProcess", variables);
//    }
}

package com.spring.activi.demo.controller;

import com.spring.activi.demo.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wufeng
 * @date: 2018/7/11 15:50
 * @desrcption: 函数解析
 */
@RestController
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private final FunctionService functionService;

    public FunctionController(FunctionService functionService){
        this.functionService = functionService;
    }

}

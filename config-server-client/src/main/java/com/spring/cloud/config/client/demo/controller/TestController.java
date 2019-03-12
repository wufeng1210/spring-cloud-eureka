package com.spring.cloud.config.client.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wufeng
 * @date: 2018/6/14 14:12
 * @desrcption:
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @RequestMapping("/from")
    public String from(){
        return this.from;
    }


}

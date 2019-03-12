package com.spring.cloud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: wufeng
 * @date: 2018/6/11 18:02
 * @desrcption:
 */
@RestController
public class DcController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/dc")
    public String dc(){
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }
}

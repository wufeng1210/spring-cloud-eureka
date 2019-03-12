package com.demo.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wufeng
 * @date: 2018/6/11 13:46
 * @desrcption: eureka-client服务的客户端
 */

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException{
        Thread.sleep(5000L);
        String services = "Services："+ discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}

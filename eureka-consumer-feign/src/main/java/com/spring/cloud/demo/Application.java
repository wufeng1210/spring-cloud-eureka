package com.spring.cloud.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author: wufeng
 * @date: 2018/6/12 17:20
 * @desrcption: 启动
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}

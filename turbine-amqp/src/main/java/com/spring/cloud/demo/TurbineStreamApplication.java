package com.spring.cloud.demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author: wufeng
 * @date: 2018/6/15 10:28
 * @desrcption:
 */
@Configurable
@EnableAutoConfiguration
@EnableTurbineStream
@EnableDiscoveryClient
public class TurbineStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineStreamApplication.class, args);
    }
}

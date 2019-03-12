package com.spring.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: wufeng
 * @date: 2018/6/15 10:06
 * @desrcption:
 */
@EnableHystrixDashboard
@SpringCloudApplication
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
//        new SpringApplicationBuilder(HystrixDashboardApplication.class).web(true).run(args);
    }
}

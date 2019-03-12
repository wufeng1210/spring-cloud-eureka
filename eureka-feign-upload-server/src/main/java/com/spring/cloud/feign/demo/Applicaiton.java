package com.spring.cloud.feign.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: wufeng
 * @date: 2018/6/13 13:55
 * @desrcption: feign上传服务提供方
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Applicaiton {

    @RestController
    public class UploadController{

        @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public String handleFileUpload(@RequestPart(value = "file")MultipartFile file){
            return file.getName();
        }
    }

    public static void main(String[] args) {
        new  SpringApplicationBuilder(Applicaiton.class)
                .web(true).run(args);
    }
}

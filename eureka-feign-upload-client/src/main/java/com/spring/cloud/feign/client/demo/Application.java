package com.spring.cloud.feign.client.demo;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: wufeng
 * @date: 2018/6/13 14:19
 * @desrcption: feign上传消费方
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .web(true).run(args);
    }

    @FeignClient(value = "upload-server", configuration = UploadService.MutipartSupportConfig.class)
    public interface UploadService {

        @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        String handleFileUpload(@RequestPart(value = "file")MultipartFile file);


        @Configurable
        class MutipartSupportConfig{
            @Bean
            public Encoder feignFormEncoder(){
                return new SpringFormEncoder();
            }
        }
    }
}

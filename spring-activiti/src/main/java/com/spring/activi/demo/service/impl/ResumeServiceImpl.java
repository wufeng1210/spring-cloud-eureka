package com.spring.activi.demo.service.impl;

import com.spring.activi.demo.service.ResumeService;
import org.springframework.stereotype.Service;

/**
 * @author: wufeng
 * @date: 2018/6/19 10:23
 * @desrcption:
 */
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
    @Override
    public void storeResume() {
        System.out.println("---task start");
    }
}

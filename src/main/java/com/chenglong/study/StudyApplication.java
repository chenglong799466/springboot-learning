package com.chenglong.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
public class StudyApplication {

    // SpringBoot项目通过扫描整个项目查找main方法来启动整个web。
    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }
}

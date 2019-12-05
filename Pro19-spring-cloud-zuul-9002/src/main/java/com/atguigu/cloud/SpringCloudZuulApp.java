package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
public class SpringCloudZuulApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulApp.class, args);
        //testgit2.0
    }
}


package com.atguigu.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringCloudHystrixDashBoard {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixDashBoard.class,args);

    }
}

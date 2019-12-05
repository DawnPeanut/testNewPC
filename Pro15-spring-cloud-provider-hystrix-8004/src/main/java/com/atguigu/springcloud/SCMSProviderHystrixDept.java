package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//启用对Hystrix熔断机制的支持
public class SCMSProviderHystrixDept {

    public static void main(String[] args) {
        SpringApplication.run(SCMSProviderHystrixDept.class,args);
    }

}

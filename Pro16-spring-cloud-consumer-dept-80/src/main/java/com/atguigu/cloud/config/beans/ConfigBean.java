package com.atguigu.cloud.config.beans;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced//Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    //相当于<bean id="restTemplate" class="org.springframework.web.client.RestTemplate">
}

package com.atguigu.cloud.controller;


import com.atguigu.cloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {
//    private static  final  String REST_URL_PREFIX="http://localhost:8001";
    private static  final  String REST_URL_PREFIX="http://ATFUIGU_SCMS_DEPT";

    @Autowired
    private  RestTemplate restTemplate;

    @RequestMapping("/consummer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consummer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Integer deptNo) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+deptNo, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/consummer/dept/get/all")
    public List<Dept> getAll() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/all", List.class);
    }

}

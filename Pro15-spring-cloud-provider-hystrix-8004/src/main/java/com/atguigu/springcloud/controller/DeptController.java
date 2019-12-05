package com.atguigu.springcloud.controller;

import com.atguigu.cloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@RestController// Controller+ResponseBody
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping(value ="/dept/get/{deptNo}",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod="getHystrix")
    public Dept get(@PathVariable("deptNo") Integer deptNo){
        Dept dept=deptService.findById(deptNo);
        if(dept==null){
            throw new RuntimeException("未找到和"+deptNo+"对应的信息！");
        }
        return dept;
    }

    public Dept getHystrix(@PathVariable("deptNo") Integer deptNo){
        return new Dept(deptNo, "与"+deptNo+"对应的Dept信息未找到！", "对应数据库信息未找到！");
    }

    @RequestMapping(value ="/dept/get/all",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getAllHystrix")
    public List<Dept> getAll(){

        int i = Calendar.getInstance().get(Calendar.SECOND);
        if(i%5==0){
            throw new RuntimeException();
        }
        return deptService.findAll();
    }
    public List<Dept> getAllHystrix(){
        return Arrays.asList(new Dept(null,"no inf","no inf"));
    }



}

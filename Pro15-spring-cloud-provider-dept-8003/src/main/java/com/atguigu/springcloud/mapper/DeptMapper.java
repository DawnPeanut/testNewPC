package com.atguigu.springcloud.mapper;


import com.atguigu.cloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//作用类似service,controller
public interface DeptMapper {

    Dept findById(Integer deptNo);
    List<Dept> findAll();
    boolean addDept(Dept dept);
}

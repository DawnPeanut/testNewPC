package com.atguigu.cloud.service.factory;


import com.atguigu.cloud.entities.Dept;
import com.atguigu.cloud.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public List<Dept> getAll() {
                return null;
            }

            @Override
            public Dept get(Integer deptNo) {
                return new Dept(deptNo,"provider remote failed ,use dept boject prepared by myself","");
            }
        };
    }
}

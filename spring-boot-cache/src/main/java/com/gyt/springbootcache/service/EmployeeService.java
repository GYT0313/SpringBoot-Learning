package com.gyt.springbootcache.service;

import com.gyt.springbootcache.bean.Employee;
import com.gyt.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "emp", cacheManager = "employeeCacheManager")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法结果缓存，以后从缓存获取相同的结果
     *
     * , condition = "#id>0"
     * , unless = "#result == null "
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp"/*, keyGenerator = "myKeyGenerator", condition = "#id > 1"*/)
    public Employee getEmpById(Integer id) {
        System.out.println("查询: " + id + " 号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }


    /**
     * 缓存更新
     * 先调用目标方法，将结果缓存起来
     *
     * 步骤：
     *  1、先查询1号
     *  2、再次查询同样的结果
     *  3、更新1号
     *  4、再次查询1号
     * @param employee
     * @return
     */
    @CachePut(value = "emp", key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp: " + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }


    @CacheEvict(value = "emp", key = "#id")
    public void deleteEmp(Integer id) {
//        employeeMapper.deleteEmpById(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#lastName")
            },
            put = {
//                    @CachePut(value = "emp", key = "#result.id"),
//                    @CachePut(value = "emp", key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }

}

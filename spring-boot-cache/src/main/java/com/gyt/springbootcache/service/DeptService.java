package com.gyt.springbootcache.service;

import com.gyt.springbootcache.bean.Department;
import com.gyt.springbootcache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;


@CacheConfig(cacheNames = "dept", cacheManager = "deptCacheManager")
@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;

    /**
     * 缓存的数据能存入redis，
     * 第二次从缓存查询就不能反序列化回来
     * 因为存的时dept的json数据，而使用RedisTemplate<Object, Employee> 来操作redis
     *
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "dept")
//    public Department getDeptById(Integer id) {
//        System.out.println("查询部门: " + id);
//        Department department = departmentMapper.getDeptById(id);
//        return department;
//    }

    /**
     * 编码使用缓存，使用API
     * @param id
     * @return
     */
    public Department getDeptById(Integer id) {
        System.out.println("查询部门: " + id);
        Department department = departmentMapper.getDeptById(id);

        // 获取某个缓存
        Cache dept = deptCacheManager.getCache("dept");
        dept.put("dept:1", department);

        return department;
    }

}

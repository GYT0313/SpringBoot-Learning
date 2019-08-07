package com.gyt.springbootcache;

import com.gyt.springbootcache.bean.Employee;
import com.gyt.springbootcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    // 操作字符串
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * String  List  Set  Hash  ZSet
     */
    @Test
    public void test01() {
//        stringRedisTemplate.opsForValue().append("msg", "hello");
        System.out.println(stringRedisTemplate.opsForValue().get("msg"));
    }

    // k,v 都是对象
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    @Test
    public void test02() {
        Employee employee = employeeMapper.getEmpById(1);
        // 默认jdk序列化保存到redis
//        redisTemplate.opsForValue().set("emp01", employee);
        // 以json保存
        empRedisTemplate.opsForValue().set("emp02", employee);


/*        Employee employee = new Employee();
        employee.setdId(1);
        employee.setLastName("jdk");
        employee.setEmail("jdk");
        employee.setGender(0);
        empRedisTemplate.opsForValue().set("emp02", employee);*/
    }



    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

}

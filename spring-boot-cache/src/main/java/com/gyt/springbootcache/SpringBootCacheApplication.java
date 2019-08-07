package com.gyt.springbootcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @className: SpringBootCacheApplication
 * @author guyt
 * @description:
 * 一、搭建基本环境
 * 1、导入数据库文件    创建department 和 employee
 * 2、创建javaBean
 * 3、整合mybatis，操作数据库
 *      1、配置数据源
 *      2、使用注解版mybatis
 *          1）、@MapperScan指定扫描的包
 * 二、快速体验缓存
 *      步骤：
 *          1、开启基于注解的缓存@EnableCaching
 *          2、标注缓存
 *              @Cacheable
 *              @CacheEvict
 *              @CachePut
 * 三、整合redis作为缓存
 *  1、使用docker安装redis
 *  2、引入redis的starter
 *  3、配置redis
 *  4、测试缓存
 *      原理：CacheManager === Cache缓存组件来实际缓存数据
 *      1、引入redis的starter后，RedisCacheManager相当于替换了CacheManager
 *      2、RedisManager引入RedisCache来作为缓存的组件
 *      3、默认保存数据 k、v都是Object时，序列化保存，如何改写为Json？
 *      4、自定义CacheManager
 *
 * @date 2019/8/7
 * @version 1.0.0
 */

@EnableCaching
@MapperScan("com.gyt.springbootcache.mapper")
@SpringBootApplication
public class SpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }

}

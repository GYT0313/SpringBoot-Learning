package com.gyt.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @className: SpringBootSecurityApplication
 * @author guyt
 * @description:
 *  1、引入SpringSecurity
 *  2、编写配置类：
 *  MySecurityConfig extends WebSecurityConfigurerAdapter
 *  3、控制请求的访问权限
 *
 * @date 2019/8/8
 * @version 1.0.0
 */
@SpringBootApplication
public class SpringBootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityApplication.class, args);
    }

}

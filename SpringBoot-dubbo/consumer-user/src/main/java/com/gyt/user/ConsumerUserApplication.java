package com.gyt.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @className: ConsumerUserApplication
 * @author guyt
 * @description:
 *  1、引入依赖
 *  2、配置dubbo注册中心地址
 *  3、引用服务
 * @date 2019/8/9
 * @version 1.0.0
 */
@SpringBootApplication
public class ConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserApplication.class, args);
    }

}

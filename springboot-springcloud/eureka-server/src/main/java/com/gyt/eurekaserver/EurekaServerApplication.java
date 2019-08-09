package com.gyt.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @className: EurekaServerApplication
 * @author guyt
 * @description:
 *  注册中心
 *      1、配置
 *      2、@EnableEurekaServer
 * @date 2019/8/9
 * @version 1.0.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}

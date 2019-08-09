package com.gyt.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @className: ProviderTicketApplication
 * @author guyt
 * @description:
 *  1、将服务提供者注册到注册中心
 *      1）引入dubbo和zkclient的相关依赖
 *      2）配置dubbo的扫描包和注册中心地址
 *      3）使用@service
 * @date 2019/8/9
 * @version 1.0.0
 */
@SpringBootApplication
public class ProviderTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTicketApplication.class, args);
    }

}

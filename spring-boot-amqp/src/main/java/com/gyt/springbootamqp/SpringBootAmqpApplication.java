package com.gyt.springbootamqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @className: SpringBootAmqpApplication
 * @author guyt
 * @description:
 *  自动配置:
 *      1、RabbitAutoConfiguration
 *      2、连接工厂ConnectionFactory
 *      3、RabbitProperties配置
 *      4、RabbitTemplate，发送和接受消息
 *      5、AmqpAdmin，系统管理功能组件
 * @date 2019/8/7
 * @version 1.0.0
 */

@SpringBootApplication
public class SpringBootAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpApplication.class, args);
    }

}

package com.gyt.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @className: SpringBootElasticsearchApplication
 * @author guyt
 * @description:
 *  SpringBoot默认支持两种技术和ES交互
 *      1、Jest（默认不生效，需要导入相应包）
 *      2、SpringData ElasticSearch
 *          如果版本不适配，要么降低es  2.4.6
 *          要么升级spring data
 *
 *          1）Client 客户端
 *          2）ElasticSearchTemplate
 *          3）编写一个ElasticSearchRepository的子接口来操作es
 *  1）编写ElastciSearchRepository
 * @date 2019/8/8
 * @version 1.0.0
 */
@SpringBootApplication
public class SpringBootElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElasticsearchApplication.class, args);
    }

}

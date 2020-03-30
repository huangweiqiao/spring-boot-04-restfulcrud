package com.hwq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @SpringBootApplication 表示这是一个springBoot的启动类
 * @ImportResource(locations = {"classpath:beans.xml"}) 表示导入xml配置文件
 * @MapperScan(value = "com.hwq.mapper")  这里配置就不需要在 mapper包下的每个人Mapper类上加 @Mapper注解了
 */
@MapperScan(value = "com.hwq.mapper") //这里配置就不需要在 mapper包下的每个人Mapper类上加 @Mapper注解了
@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
public class SpringBoot04RestfulCurdApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04RestfulCurdApplication.class,args);
    }
}


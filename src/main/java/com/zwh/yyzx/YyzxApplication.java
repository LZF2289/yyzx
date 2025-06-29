package com.zwh.yyzx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//配置mapper路径
@MapperScan(basePackages = "com.zwh.yyzx.mapper")
public class YyzxApplication {

    public static void main(String[] args) {
        SpringApplication.run(YyzxApplication.class, args);
    }

}
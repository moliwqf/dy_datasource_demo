package com.moli.dynamic.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author moli
 * @time 2024-07-19 21:25:34
 */
@MapperScan("com.moli.dynamic.datasource.mapper")
@SpringBootApplication
public class DyDsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DyDsDemoApplication.class, args);
    }
}

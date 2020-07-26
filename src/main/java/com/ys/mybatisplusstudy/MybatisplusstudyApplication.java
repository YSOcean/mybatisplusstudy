package com.ys.mybatisplusstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ys.mybatisplusstudy.mapper")
public class MybatisplusstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusstudyApplication.class, args);
    }

}

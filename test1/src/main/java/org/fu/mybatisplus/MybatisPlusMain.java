package org.fu.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.fu.mybatisplus.mapper")
@SpringBootApplication
public class MybatisPlusMain {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusMain.class);
    }
}

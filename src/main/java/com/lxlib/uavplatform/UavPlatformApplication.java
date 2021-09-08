package com.lxlib.uavplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author chengmanyuan
 * @date 2021/09/07
 */
@SpringBootApplication
@MapperScan("com.lxlib.uavplatform.repository.dao")
public class UavPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(UavPlatformApplication.class, args);
    }

}

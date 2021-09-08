package com.lxlib.uavplatform;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.UUID;

/**
 * @author chengmanyuan
 * @date 2021/09/07
 */
@SpringBootApplication
@MapperScan("com.lxlib.uavplatform.repository.dao")
@Slf4j
public class UavPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(UavPlatformApplication.class, args);
        log.info("项目启动成功！");
    }

}

package com.catcher92.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "com.catcher92.blog.mapper")
@Configuration
public class MyBatisConfig {
}

package com.hly.sirius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration//开启自动配置，逐层往下搜索加注解的类
@MapperScan("com.hly.sirius.dao")
@ServletComponentScan(basePackages = {"com.hly.sirius.filter"})
@EnableTransactionManagement//开启事务
@SpringBootApplication
public class AppletApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppletApplication.class, args);

	}
}

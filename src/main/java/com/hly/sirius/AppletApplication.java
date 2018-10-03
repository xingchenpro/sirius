package com.hly.sirius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration//开启自动配置，逐层往下搜索加注解的类
@MapperScan("com.hly.sirius.dao")
@ServletComponentScan(basePackages = {"com.hly.sirius.filter"})//开启扫描Servlet
@EnableTransactionManagement//开启事务
@EnableScheduling//开启定时任务的支持
@EnableCaching//开启缓存功能
@SpringBootApplication
public class AppletApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppletApplication.class, args);

	}
}

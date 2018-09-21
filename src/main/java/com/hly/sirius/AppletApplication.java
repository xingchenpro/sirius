package com.hly.sirius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@MapperScan("com.hly.sirius.dao")
@SpringBootApplication
public class AppletApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppletApplication.class, args);

	}
}

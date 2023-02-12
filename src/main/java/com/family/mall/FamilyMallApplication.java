package com.family.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.family.mall.mapper")
@SpringBootApplication
public class FamilyMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyMallApplication.class, args);
	}

}

package com.geordi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 引导类， Spring Boot应用的入口类
 *
 **/
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//调用SpringApplication类的静态方法run()启动Spring Boot应用
		SpringApplication.run(DemoApplication.class, args);
	}

}

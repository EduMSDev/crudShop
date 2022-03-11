package com.sprinter.demo;

import com.sprinter.demo.controller.GenericController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CrudShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudShopApplication.class, args);
	}

}

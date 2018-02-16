package com.praktos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class PraktosApplication {


	public static void main(String[] args) {
		SpringApplication.run(PraktosApplication.class, args);
	}
}

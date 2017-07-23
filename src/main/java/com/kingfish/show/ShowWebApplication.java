package com.kingfish.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShowWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowWebApplication.class, args);
	}
}

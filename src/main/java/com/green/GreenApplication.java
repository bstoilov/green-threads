package com.green;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class GreenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenApplication.class, args);
	}

}

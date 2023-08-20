package com.richard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CQRSApplication {

	public static void main(String[] args) {
		SpringApplication.run(CQRSApplication.class, args);
	}

}

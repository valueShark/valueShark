package com.valueshark.valueshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ValuesharkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValuesharkApplication.class, args);
	}

}

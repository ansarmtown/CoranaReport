package com.corana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class CoranaReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoranaReportApplication.class, args);
	}

}

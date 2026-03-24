package com.sp26.team8.CleanSweepProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (scanBasePackages = "com.sp26.team8")
@EnableJpaRepositories("com.sp26.team8.repository")
@EntityScan("com.sp26.team8.entity")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}


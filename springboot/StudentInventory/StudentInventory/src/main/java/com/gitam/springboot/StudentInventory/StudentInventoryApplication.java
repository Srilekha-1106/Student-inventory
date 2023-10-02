package com.gitam.springboot.StudentInventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudentInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentInventoryApplication.class, args);
	}

}

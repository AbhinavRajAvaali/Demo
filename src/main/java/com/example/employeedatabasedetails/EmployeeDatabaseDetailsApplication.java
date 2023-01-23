package com.example.employeedatabasedetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class EmployeeDatabaseDetailsApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeDatabaseDetailsApplication.class, args);
	}
}

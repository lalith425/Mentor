package com.example.progressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class ProgressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgressServiceApplication.class, args);
	}

}

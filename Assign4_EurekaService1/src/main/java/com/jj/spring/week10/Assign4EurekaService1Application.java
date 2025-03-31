package com.jj.spring.week10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@EnableDiscoveryClient
@SpringBootApplication
public class Assign4EurekaService1Application {

	public static void main(String[] args) {
		SpringApplication.run(Assign4EurekaService1Application.class, args);
	}
	
	

}

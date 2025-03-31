package com.jj.spring.assign4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class Assign4EurekaService2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assign4EurekaService2Application.class, args);
	}

}

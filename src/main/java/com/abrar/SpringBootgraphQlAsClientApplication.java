package com.abrar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
public class SpringBootgraphQlAsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootgraphQlAsClientApplication.class, args);
		System.out.println("running up As a client...");
		//log.info("SpringBoot GraphQl As A Client is running up...");
	}

}

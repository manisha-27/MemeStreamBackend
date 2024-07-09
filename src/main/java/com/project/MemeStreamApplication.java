package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemeStreamApplication {

	public static void main(String[] args) {
		System.out.println("HELLO");
		SpringApplication.run(MemeStreamApplication.class, args);
		System.out.println("HELLO AND HI");
	}

}

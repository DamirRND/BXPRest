package com.bx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class BxpRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BxpRestApplication.class, args);
	}
}

package com.aph.spring.proj2.springproj2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.aph.spring.proj2.*")
public class Springproj2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springproj2Application.class, args);
	}

}

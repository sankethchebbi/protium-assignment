package com.example.sanketh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SankethApplication {

	public static void main(String[] args) {
		SpringApplication.run(SankethApplication.class, args);
	}

}

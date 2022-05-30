package com.dev.api.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class InitiApplication {

	public static void main(String[] args) {
   SpringApplication.run(InitiApplication.class, args);
 }

}


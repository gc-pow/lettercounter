package com.infinityeyes.lettercounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LettercounterApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(LettercounterApplication.class, args);
	}
}

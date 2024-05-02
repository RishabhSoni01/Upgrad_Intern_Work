package com.example.Sprinboot_Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Bean
	public TyreService tyreService() {
		return new TyreService();
	}

	@Bean
	public SpeakerService speakerService() {
		return new SpeakerService();
	}
}
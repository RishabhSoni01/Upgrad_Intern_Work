package com.example.springTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTwoApplication.class, args);
		@Bean
		public TyreService tyreService() {
			return new TyreService();
		}

		@Bean
		public SpeakerService speakerService() {
			return new SpeakerService();
		}
	}

}

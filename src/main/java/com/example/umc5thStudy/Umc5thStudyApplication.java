package com.example.umc5thStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Umc5thStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc5thStudyApplication.class, args);
	}

}

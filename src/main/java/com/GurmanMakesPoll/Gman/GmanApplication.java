package com.GurmanMakesPoll.Gman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmanApplication.class, args);
	}

}

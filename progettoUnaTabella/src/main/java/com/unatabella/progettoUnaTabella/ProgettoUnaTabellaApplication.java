package com.unatabella.progettoUnaTabella;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"com/unatabella/progettoUnaTabella/repository"})
public class ProgettoUnaTabellaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoUnaTabellaApplication.class, args);
	}

}

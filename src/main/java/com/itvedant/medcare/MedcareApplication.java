package com.itvedant.medcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(FileStorageProperties.class)
public class MedcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedcareApplication.class, args);
	}

}

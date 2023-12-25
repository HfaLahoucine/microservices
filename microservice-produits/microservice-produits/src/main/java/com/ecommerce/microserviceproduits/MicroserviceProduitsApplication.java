package com.ecommerce.microserviceproduits;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJpaAuditing
public class MicroserviceProduitsApplication {

	public static void main(String[] args) {

		SpringApplication.run(MicroserviceProduitsApplication.class, args);
	}

}

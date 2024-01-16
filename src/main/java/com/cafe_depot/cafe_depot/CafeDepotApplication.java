package com.cafe_depot.cafe_depot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cafe_depot.cafe_depot")
@EntityScan(basePackages = "com.cafe_depot.cafe_depot.entities")

public class CafeDepotApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeDepotApplication.class, args);
	}

}

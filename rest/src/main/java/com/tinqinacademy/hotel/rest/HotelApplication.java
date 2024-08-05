package com.tinqinacademy.hotel.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.tinqinacademy.hotel.persistence.entities")
@EnableJpaRepositories(basePackages = "com.tinqinacademy.hotel.persistence.repository" )
@SpringBootApplication(scanBasePackages = {"com.tinqinacademy.hotel"})
public class HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}
}

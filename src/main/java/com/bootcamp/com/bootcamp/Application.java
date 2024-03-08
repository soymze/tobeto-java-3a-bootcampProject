package com.bootcamp.com.bootcamp;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}

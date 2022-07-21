package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class RestBankingProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(RestBankingProject01Application.class, args);
	}

}

package com.razz.ci_cd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CiCdApplication {

	@GetMapping("/message")
	public String message(){
		return "Congratulation!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(CiCdApplication.class, args);
	}

}

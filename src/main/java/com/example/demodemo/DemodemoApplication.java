package com.example.demodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemodemoApplication {

	@RequestMapping("/aaa")
	String home(){
		return "Hi!! welcome to Springboot!";
	}

	@RequestMapping("/hello")
	String home2(){
		return "こんにちは。";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemodemoApplication.class, args);
	}

}
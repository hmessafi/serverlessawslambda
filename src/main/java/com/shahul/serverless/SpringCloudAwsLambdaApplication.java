package com.shahul.serverless;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shahul.serverless.service.TwitterService;

@SpringBootApplication
public class SpringCloudAwsLambdaApplication {
	
	@Autowired
	TwitterService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAwsLambdaApplication.class, args);
	}

	@Bean
	public Supplier<String> username(){
		return ()-> service.updateUsername();
	}
	
}

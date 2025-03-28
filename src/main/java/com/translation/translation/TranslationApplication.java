package com.translation.translation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.translation")
public class TranslationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslationApplication.class, args);
	}

}

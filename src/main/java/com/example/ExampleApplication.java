package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.swing.*;
import java.io.File;



@SpringBootApplication
@ComponentScan("com.example")
public class ExampleApplication extends JPanel {

	public static String ROOT = "upload-dir";

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/get").allowedOrigins("http://localhost:9000");
			}
		};
	}
}

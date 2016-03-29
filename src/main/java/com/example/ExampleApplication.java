package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
@ComponentScan("com.example")
public class ExampleApplication {

	public static String ROOT = "upload-dir";

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}


	@Bean
	public CommandLineRunner runner(final DocumentRepository repository){
		return new CommandLineRunner() {
			@Override

			public void run(String... strings) throws Exception {
				repository.save(new Document("Cerere","11.11.2012","1","mihai","123"));
				repository.save(new Document("Cerere","11.11.2012","1","vlad","1234"));
				repository.save(new Document("Cerere","11.11.2012","1","vadim","12345"));

			}
		};
	}
	@Bean
	CommandLineRunner init() {
		return (String[] args) -> {
			new File(ROOT).mkdir();
		};
	}
}

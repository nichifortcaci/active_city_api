package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}


	@Bean
	public CommandLineRunner runner(final CatRepository repository){
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				repository.save(new Cat("Joric","11.11.2012"));
				repository.save(new Cat("Joric","11.21.2012"));
				repository.save(new Cat("Joric","11.31.2012"));
				repository.save(new Cat("Joric","11.41.2012"));
				repository.save(new Cat("Valera","12.11.2012"));
				repository.save(new Cat("Grisa","13.11.2012"));
				repository.save(new Cat("Ion","14.11.2012"));
			}
		};
	}
}

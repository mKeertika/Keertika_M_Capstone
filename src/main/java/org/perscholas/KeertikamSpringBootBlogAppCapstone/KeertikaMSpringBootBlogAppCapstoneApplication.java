package org.perscholas.KeertikamSpringBootBlogAppCapstone;

import org.perscholas.KeertikamSpringBootBlogAppCapstone.services.IPostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class KeertikaMSpringBootBlogAppCapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeertikaMSpringBootBlogAppCapstoneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(IPostService postService) {
		return args -> System.out.println("My blog is running now!");
	}
}


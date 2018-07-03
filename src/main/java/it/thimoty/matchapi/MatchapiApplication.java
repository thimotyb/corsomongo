package it.thimoty.matchapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MatchapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MatchapiApplication.class, args);
	}
}

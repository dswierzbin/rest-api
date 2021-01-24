package pl.swierzbin.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class RestApiApplication {

	public static void main(String... args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
}

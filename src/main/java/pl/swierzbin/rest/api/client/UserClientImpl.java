package pl.swierzbin.rest.api.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.swierzbin.rest.api.client.model.User;
import reactor.core.publisher.Mono;

@Component
public class UserClientImpl implements UserClient {

	private final WebClient webClient;

	public UserClientImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public Mono<User> getUserByLogin(String login) {
		return webClient
				.get()
				.uri("/users/{login}", login)
				.retrieve()
				.bodyToMono(User.class);
	}
}

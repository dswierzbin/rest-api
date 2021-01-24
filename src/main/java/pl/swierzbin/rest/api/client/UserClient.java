package pl.swierzbin.rest.api.client;

import pl.swierzbin.rest.api.client.model.User;
import reactor.core.publisher.Mono;

public interface UserClient {

	Mono<User> getUserByLogin(String login);
}

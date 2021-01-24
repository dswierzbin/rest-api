package pl.swierzbin.rest.api.service;

import pl.swierzbin.rest.api.model.User;
import reactor.core.publisher.Mono;

public interface UserService {

	Mono<User> findUserByLogin(String login);
}

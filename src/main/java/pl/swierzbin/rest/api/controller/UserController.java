package pl.swierzbin.rest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.swierzbin.rest.api.model.User;
import pl.swierzbin.rest.api.service.UserService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/users", produces = "application/json")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{login}")
	public Mono<User> getUserByLogin(@PathVariable("login") String login) {
		return userService.findUserByLogin(login);
	}
}

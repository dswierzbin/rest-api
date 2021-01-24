package pl.swierzbin.rest.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.swierzbin.rest.api.client.UserClient;
import pl.swierzbin.rest.api.entity.RequestStatistic;
import pl.swierzbin.rest.api.model.User;
import pl.swierzbin.rest.api.repository.RequestStatisticRepository;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final UserClient userClient;

	private final RequestStatisticRepository requestStatisticRepository;

	public UserServiceImpl(UserClient userClient, RequestStatisticRepository requestStatisticRepository) {
		this.userClient = userClient;
		this.requestStatisticRepository = requestStatisticRepository;
	}

	@Override
	public Mono<User> findUserByLogin(String login) {
		final RequestStatistic requestStatistic = requestStatisticRepository.findById(login).orElse(new RequestStatistic(login));
		requestStatistic.setRequestCount(requestStatistic.getRequestCount() + 1);
		requestStatisticRepository.save(requestStatistic);
		log.debug("Login {}, request count {}", login, requestStatistic.getRequestCount());

		return userClient.getUserByLogin(login).flatMap(user -> {
			final int followers = user.getFollowers();
			final Integer calculates = followers == 0 ? null : 6 / followers * (2 + user.getPublicRepos());
			final User result = User.builder()
					.id(user.getId())
					.login(user.getLogin())
					.name(user.getName())
					.type(user.getType())
					.avatarUrl(user.getAvatarUrl())
					.createdAt(user.getCreatedAt())
					.calculations(calculates).build();
			return Mono.just(result);
		});
	}
}

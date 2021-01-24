package pl.swierzbin.rest.api.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private int id;
	private String login;
	private String name;
	private String type;
	@JsonProperty("avatar_url")
	private String avatarUrl;
	@JsonProperty("created_at")
	private Date createdAt;
	private int followers;
	@JsonProperty("public_repos")
	private int publicRepos;
}

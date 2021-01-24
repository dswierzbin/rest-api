package pl.swierzbin.rest.api.model;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class User {
	private int id;
	private String login;
	private String name;
	private String type;
	private String avatarUrl;
	private Date createdAt;
	private Integer calculations;
}

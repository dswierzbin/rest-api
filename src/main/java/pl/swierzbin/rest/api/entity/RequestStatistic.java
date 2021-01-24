package pl.swierzbin.rest.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "request_statistic")
public class RequestStatistic {

	@Id
	private String login;
	@Column(name = "request_count")
	private int requestCount;

	public RequestStatistic(String login) {
		this.login = login;
	}
}

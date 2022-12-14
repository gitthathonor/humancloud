package site.metacoding.humancloud.domain.subscribe;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Subscribe implements Serializable {
	private Integer subscribeId;
	private Integer subscribeUserId;
	private Integer subscribeCompanyId;
	private Timestamp subscribeCreatedAt;

	public Subscribe(Integer userId, Integer companyId) {
		this.subscribeUserId = userId;
		this.subscribeCompanyId = companyId;
	}
}

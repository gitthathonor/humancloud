package site.metacoding.humancloud.domain.subscribe;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Subscribe {
	private Integer subscribeId;
	private Integer subscribeUserId;
	private Integer subscribeCompanyId;
	private Timestamp subscribeCreatedAt;

	public Subscribe(Integer userId, Integer companyId){
		this.subscribeUserId=userId;
		this.subscribeCompanyId=companyId;
	}
}

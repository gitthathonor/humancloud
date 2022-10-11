package site.metacoding.humancloud.domain.user;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class User {
	private Integer userId;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phoneNumber;
	private Timestamp createdAt;

	public User(String username, String password, String name, String email, String phoneNumber){
		this.username=username;
		this.password=password;
		this.name=name;
		this.email=email;
		this.phoneNumber=phoneNumber;
	}

	public void updateToEntity(String password, String name, String email, String phoneNumber){
		this.password=password;
		this.name=name;
		this.email=email;
		this.phoneNumber=phoneNumber;
	}

	public void setUserId(Integer id){
		this.userId=id;
	}

	public void toPhoneNumber(String num){
		this.phoneNumber=num;
	}
}

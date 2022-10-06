package site.metacoding.humancloud.web.dto.user;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class JoinDto {
	private Integer userId; // 카테고리 인서트를 위해서 받아옴 -> 유저제너래이티드키 사용하려고
	private String username;
	private String password;
	private String name;
	private String email;
	private String phoneNumber;
	private List<String> categoryList;

    public JoinDto(String username, String password, String name, String email, String phoneNumber, List<String> categorList){
        this.username=username;
        this.password=password;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.categoryList=categorList;
    }
}
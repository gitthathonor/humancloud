package site.metacoding.humancloud.domain.company;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.humancloud.web.dto.request.company.UpdateDto;

@NoArgsConstructor
@Getter
@Setter
@RedisHash("company")
public class Company implements Serializable {
	private Integer companyId;
	private String companyUsername;
	private String companyPassword;
	private String companyName;
	private String companyEmail;
	private String companyPhoneNumber;
	private String companyAddress;
	private String companyLogo;
	private Timestamp companyCreatedAt;

	public Company(String companyUsername, String companyPassword, String companyName, String companyEmail,
			String companyPhoneNumber, String companyAddress, String companyLogo) {
		this.companyUsername = companyUsername;
		this.companyPassword = companyPassword;
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.companyPhoneNumber = companyPhoneNumber;
		this.companyAddress = companyAddress;
		this.companyLogo = companyLogo;
	}

	public Company(String companyPassword, String companyName, String companyEmail,
			String companyPhoneNumber, String companyAddress, String companyLogo) {
		this.companyPassword = companyPassword;
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.companyPhoneNumber = companyPhoneNumber;
		this.companyAddress = companyAddress;
		this.companyLogo = companyLogo;
	}

	public void update(UpdateDto updateDto) {
		this.companyPassword = updateDto.getCompanyPassword();
		this.companyName = updateDto.getCompanyName();
		this.companyEmail = updateDto.getCompanyEmail();
		this.companyPhoneNumber = updateDto.getCompanyPhoneNumber();
		this.companyAddress = updateDto.getCompanyAddress();
		this.companyLogo = updateDto.getCompanyLogo();
	}

	public void toPhoneNumber(String num) {
		this.companyPhoneNumber = num;
	}
}

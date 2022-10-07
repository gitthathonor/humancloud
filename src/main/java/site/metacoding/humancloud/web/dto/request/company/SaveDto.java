package site.metacoding.humancloud.web.dto.request.company;

import lombok.Getter;
import site.metacoding.humancloud.domain.company.Company;

@Getter
public class SaveDto {
	private String companyUsername;
	private String companyPassword;
	private String companyName;
	private String companyEmail;
	private String companyPhoneNumber;
	private String companyAddress;
	
	public Company toEntity() {
		return new Company(this.companyUsername, this.companyPassword, this.companyName, this.companyEmail, this.companyPhoneNumber, this.companyAddress);
	}
}

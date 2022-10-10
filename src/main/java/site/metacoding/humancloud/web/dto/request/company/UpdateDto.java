package site.metacoding.humancloud.web.dto.request.company;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.humancloud.domain.company.Company;

@Getter
@Setter
public class UpdateDto {
	private Integer companyId;
	private String companyUsername;
	private String companyPassword;
	private String companyName;
	private String companyEmail;
	private String companyPhoneNumber;
	private String companyAddress;
	private String companyLogo;
	
	public Company toEntity() {
		return new Company(this.companyUsername, this.companyPassword, this.companyName, this.companyEmail, this.companyPhoneNumber, this.companyAddress, this.companyLogo);
	}
}

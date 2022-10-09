package site.metacoding.humancloud.domain.company;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Company {
	private Integer companyId;
	private String companyUsername;
	private String companyPassword;
	private String companyName;
	private String companyEmail;
	private String companyPhoneNumber;
	private String companyAddress;
	private String companyLogo;
	private Timestamp companyCreatedAt;
}

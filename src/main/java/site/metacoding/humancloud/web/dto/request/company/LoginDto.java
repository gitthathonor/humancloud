package site.metacoding.humancloud.web.dto.request.company;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    private String companyUsername;
    private String companyPassword;
}

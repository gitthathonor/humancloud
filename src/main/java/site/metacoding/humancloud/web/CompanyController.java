package site.metacoding.humancloud.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.service.CompanyService;
import site.metacoding.humancloud.web.dto.CMRespDto;
import site.metacoding.humancloud.web.dto.request.company.SaveDto;

@RestController
@RequiredArgsConstructor
public class CompanyController {
	
	private final CompanyService companyService;
	
	
	@GetMapping("/company/saveForm")
	public String saveForm() {
		return "company/saveForm";
	}
	
	@PostMapping("/api/company/save")
	public @ResponseBody CMRespDto<?> save(@RequestBody SaveDto saveDto) {
		companyService.saveCompany(saveDto);
		return new CMRespDto<>(1, "회원 가입 완료", null);
	}
}

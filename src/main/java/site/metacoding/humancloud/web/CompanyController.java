package site.metacoding.humancloud.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.service.CompanyService;
import site.metacoding.humancloud.web.dto.CMRespDto;
import site.metacoding.humancloud.web.dto.request.company.SaveDto;

@Controller
@RequiredArgsConstructor
public class CompanyController {

	private final CompanyService companyService;

	// 임시 main
	@GetMapping("/")
	public String main() {
		return "page/main";
	}

	// 기업 회원가입 페이지
	@GetMapping("/company/saveForm")
	public String saveForm() {
		return "page/company/companySaveForm";
	}
	
	
	// 기업회원 username 중복체크
	@GetMapping("/company/checkSameUsername")
	public @ResponseBody CMRespDto<?> checkSameUsername(String companyUsername) {
		boolean isSame = companyService.checkSameUsername(companyUsername);
		return new CMRespDto<>(1, "통신 성공", isSame);
	}
	

	// 기업 회원가입
	@PostMapping(value = "/company/save", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	  public @ResponseBody CMRespDto<?> save(@RequestPart("file") MultipartFile file, @RequestPart("saveDto") SaveDto saveDto) throws Exception {
	    int pos = file.getOriginalFilename().lastIndexOf(".");
	    String extension = file.getOriginalFilename().substring(pos + 1);
	    String filePath = "C:\\temp\\img\\";
	    String logoSaveName = UUID.randomUUID().toString();
	    String logo = logoSaveName + "." + extension;

	    File makeFileFolder = new File(filePath);
	    if (!makeFileFolder.exists()) {
	      if (!makeFileFolder.mkdir()) {
	        throw new Exception("File.mkdir():Fail.");
	      }
	    }

	    File dest = new File(filePath, logo);
	    try {
	      Files.copy(file.getInputStream(), dest.toPath());
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	    Company company = saveDto.toEntity(logo);
	    companyService.saveCompany(company);
	    return new CMRespDto<>(1, "기업 등록 성공", logo);
	  }
	
	@GetMapping("/company/info")
	public String showCompanyInfo() {
		return "page/company/companyDetail";
	}
	
	
	

//	// form양식 테스트
//	@PostMapping("/company/save")
//	public String save(SaveDto saveDto) {
//		System.out.println("controller 실행됨");
//		companyService.saveCompany(saveDto);
//		return "redirect:/";
//	}

}

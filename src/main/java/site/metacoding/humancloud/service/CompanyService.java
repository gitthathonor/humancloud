package site.metacoding.humancloud.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.domain.company.CompanyDao;
import site.metacoding.humancloud.web.dto.request.company.SaveDto;

@Service
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyDao companyDao;
	
	// 회원 username 중복체크
	public boolean checkSameUsername(String companyUsername) {
		Company companyPS = companyDao.findByUsername(companyUsername);
		if (companyPS == null) {
			return false;
		} else {
			return true;
		}
	}

	// 기업 회원 등록
	public void saveCompany(Company company) {
		companyDao.save(company);
	}
	
	// 기업 정보 상세보기
	public Company showCompanyDetail(Integer companyId) {
		return companyDao.findById(companyId);
	}

	
	
	
	
	
	
	
	
	
	

//	public boolean 로그인(Integer id, LoginDto loginDto) {
//		User userPS = userDao.findById(id);
//		if (loginDto.getUsername() != userPS.getUsername()) {
//			return false;
//		} else if (loginDto.getPassword() != userPS.getPassword()) {
//			return false;
//		}
//		return true;
//	}

//	// form 테스트
//	public void saveCompany(SaveDto saveDto) {
//		System.out.println("service 실행됨");
//		companyDao.save(saveDto.toEntity());
//	}

}

package site.metacoding.humancloud.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.company.CompanyDao;
import site.metacoding.humancloud.web.dto.request.company.SaveDto;

@Service
@RequiredArgsConstructor
public class CompanyService {
	
	private final CompanyDao companyDao;
	
	// 기업 회원 등록
	public void saveCompany(SaveDto saveDto) {
		companyDao.save(saveDto.toEntity());
	}
}

package site.metacoding.humancloud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.domain.company.CompanyDao;
import site.metacoding.humancloud.domain.subscribe.SubscribeDao;
import site.metacoding.humancloud.web.dto.request.company.LoginDto;
import site.metacoding.humancloud.web.dto.request.company.SaveDto;
import site.metacoding.humancloud.web.dto.request.company.UpdateDto;
import site.metacoding.humancloud.web.dto.response.user.ResCompanyDto;

@Service
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyDao companyDao;
	private final SubscribeDao subscribeDao;

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
	public Company getCompanyDetail(Integer companyId) {
		return companyDao.findById(companyId);
	}

	// 기업 리스트 보기
	public List<Company> getCompanyList() {
		return companyDao.findAll();
	}

	// 기업정보 수정
	public void updateCompany(Integer id, UpdateDto updateDto) {
		// 1. 영속화
		Company companyPS = companyDao.findById(id);

		// 2. updateDto를 companyPS에 업데이트
		companyPS.update(updateDto);

		// 3. update
		companyDao.update(companyPS);
	}

	// 기업정보 삭제
	public void deleteCompany(Integer id) {
		companyDao.deleteById(id);
	}

	public ResCompanyDto 로그인(LoginDto loginDto) {
		Company companyPS = companyDao.findByUsername(loginDto.getCompanyUsername());
		if (companyPS == null) {
			return null;
		} else if (loginDto.getCompanyPassword().equals(companyPS.getCompanyPassword())) {
			return new ResCompanyDto(companyPS, subscribeDao.findByCompanyId(companyPS.getCompanyId()));
		}
		return null;
	}

}

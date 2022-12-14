package site.metacoding.humancloud.domain.recruit;

import java.util.List;
import java.util.concurrent.RecursiveAction;

import site.metacoding.humancloud.web.dto.request.recruit.SaveDto;
import site.metacoding.humancloud.web.dto.response.page.PagingDto;
import site.metacoding.humancloud.web.dto.response.recruit.CompanyRecruitDto;
import site.metacoding.humancloud.web.dto.response.recruit.RecruitDetail;

public interface RecruitDao {
	public void save(SaveDto saveDto);

	public Recruit findById(Integer id);

	public List<Recruit> findAll();

	public void update(Recruit recruit);

	public void deleteById(Integer id);

	public List<Recruit> orderByCreatedAt();

	public List<Recruit> orderByCareer();

	public void findByCareer();

	public List<Recruit> findByCompanyId(Integer id);

	public List<CompanyRecruitDto> joinCompanyRecruit(int startNum);

	public List<Recruit> orderByrecommend(Integer userId);

	public List<RecruitDetail> findByTitle(String recruitTitle);

	public PagingDto paging(Integer page);
}

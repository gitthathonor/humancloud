package site.metacoding.humancloud.domain.recruit;

import java.util.List;

import site.metacoding.humancloud.web.dto.request.recruit.SaveDto;

public interface RecruitDao {
	public void save(SaveDto saveDto);

	public Recruit findById(Integer id);

	public List<Recruit> findAll();

	public void update(Recruit recruit);

	public void deleteById(Integer id);

	public List<Recruit> orederByCreatedAt();

	public List<Recruit> findByCompanyId(Integer id);
}

package site.metacoding.humancloud.domain.resume;

import java.util.List;

import site.metacoding.humancloud.web.dto.request.resume.SaveDto;
import site.metacoding.humancloud.web.dto.request.resume.UpdateDto;

public interface ResumeDao {
	public void save(SaveDto saveDto);

	public Resume findById(Integer id);

	public List<Resume> findAll();

	public void update(UpdateDto updateDto);

	public void deleteById(Integer id);

	public List<Resume> findByUserId(Integer userId);

	public void deleteByUserId(Integer userId);

	public Resume sumReadCount(Integer userId);

	public List<Resume> orderByCareer();

	public List<Resume> orderByEducation();

	public List<Resume> orderByCreatedAt();

	public List<Resume> orderByRecommended(Integer companyId);

}

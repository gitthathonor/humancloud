package site.metacoding.humancloud.domain.resume;

import java.util.List;

import site.metacoding.humancloud.web.dto.request.resume.SaveDto;
import site.metacoding.humancloud.web.dto.request.resume.UpdateDto;
import site.metacoding.humancloud.web.dto.response.page.PagingDto;

public interface ResumeDao {
	public void save(SaveDto saveDto);

	public Resume findById(Integer id);

	public List<Resume> findAll(int startNum);

	public void update(UpdateDto updateDto);

	public void deleteById(Integer id);

	public List<Resume> findByUserId(Integer userId);

	public void deleteByUserId(Integer userId);

	public Resume sumReadCount(Integer userId);

	public List<Resume> orderByCareer();

	public List<Resume> orderByEducation();

	public List<Resume> orderByCreatedAt();

	public List<Resume> orderByRecommend(Integer companyId);

	public PagingDto paging(Integer page);

	public void updateReadCount(Integer resumeId);

	public List<Resume> applyResumeList(Integer companyId);

}

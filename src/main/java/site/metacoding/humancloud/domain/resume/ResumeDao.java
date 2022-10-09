package site.metacoding.humancloud.domain.resume;

import java.util.List;

import site.metacoding.humancloud.web.dto.request.resume.SaveDto;

public interface ResumeDao {
	public void save(SaveDto saveDto);
	public Resume findById(Integer id);
	public List<Resume> findAll();
	public void update(Resume resume);
	public void deleteById(Integer id);

	public int sumReadCount(Integer userId);
	public List<Resume> orderByCareer();
}

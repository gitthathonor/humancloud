package site.metacoding.humancloud.domain.resume;

import java.util.List;
import java.util.Locale.Category;

public interface ResumeDao {
	public void save(Resume resume);
	public Resume findById(Integer id);
	public List<Resume> findAll();
	public void update(Resume resume);
	public void deleteById(Integer id);

	public int sumReadCount(Integer userId);
	public List<Resume> orderByCareer();
	public List<Resume> orderByEducation();
	public List<Resume> orderByCreatedAt();

}

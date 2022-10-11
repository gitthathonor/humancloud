package site.metacoding.humancloud.domain.category;

import java.util.List;

import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.domain.resume.Resume;

public interface CategoryDao {
	public void save(Category category);

	public Category findById(Integer id);

	public List<Category> findAll();

	public void update(Category category);

	public void deleteById(Integer id);

	public void deleteByResumeId(Integer resumeId);

	public List<Category> distinctName();

	public List<Category> findByName(String name);

	public List<Category> findByResumeId(Integer resumeId);

	public List<Category> findByRecruitId(Integer recruitId);

	public List<Resume> findByResumeCategory(String categories);

	public List<Category> joinRecruitCategory(Integer CompanyId);

	// public List<Map<String, Object>>
	// findCompanyByName(@Param("categories")List<Category> categories);
}

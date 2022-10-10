package site.metacoding.humancloud.domain.category;

import java.util.List;

import site.metacoding.humancloud.domain.company.Company;


public interface CategoryDao {
	public void save(Category category);
	public Category findById(Integer id);
	public List<Category> findAll();
	public void update(Category category);
	public void deleteById(Integer id);
	public void deleteByResumeId(Integer categoryResumeId);
	public List<Category> findByName(String name);
	public List<Category> findByResumeId(Integer ResumeId);
	public List<Category> findByCompanyId(Integer companyId);
	public Company findByCompanyCategory(String categories);

	// public List<Map<String, Object>> findCompanyByName(@Param("categories")List<Category> categories);
}

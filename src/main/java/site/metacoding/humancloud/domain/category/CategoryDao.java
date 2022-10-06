package site.metacoding.humancloud.domain.category;

import java.util.List;

import site.metacoding.humancloud.domain.company.Company;

public interface CategoryDao {
	public void save(Category category);
	public Category findById(Integer id);
	public List<Category> findAll();
	public void update(Category category);
	public void deleteById(Integer id);

	public List<Category> findByUserId(Integer userId);
	public Company findByCompanyCategory(String categoryName);
}

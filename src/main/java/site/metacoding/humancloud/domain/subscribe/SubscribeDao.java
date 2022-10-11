package site.metacoding.humancloud.domain.subscribe;

import site.metacoding.humancloud.domain.company.Company;

import java.util.List;

public interface SubscribeDao {
	public void save(Subscribe subscribe);
	public Subscribe findById(Integer id);
	public List<Subscribe> findAll();
	public void update(Subscribe subscribe);
	public void deleteById(Integer id);

	public List<Company> findCompanyByUserId(Integer userId);
	public void deleteByUserCompany(Integer userId, Integer companyId);
}

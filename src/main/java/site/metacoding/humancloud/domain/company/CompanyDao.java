package site.metacoding.humancloud.domain.company;

import java.util.List;


public interface CompanyDao {
	public void save(Company company);
	public Company findById(Integer id);
	public List<Company> findAll();
	public void update(Company company);
	public void deleteById(Integer id);
<<<<<<< HEAD

=======
	
	public Company findByUsername(String companyUsername);
>>>>>>> 7abdc34b24506874c1167a19a88300d18c451ce1
}

package site.metacoding.humancloud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import site.metacoding.humancloud.config.MyBatisConfig;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.category.CategoryDao;
import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.domain.company.CompanyDao;
import site.metacoding.humancloud.domain.recruit.Recruit;
import site.metacoding.humancloud.domain.recruit.RecruitDao;

@Import(MyBatisConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
class HumancloudApplicationTests {

	@Autowired
	private RecruitDao recruitDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private CompanyDao companyDao;

	@Test
	public void save_test() {
		// given
		String recruitTitle = "타이틀 테스트";
		Recruit recruitPS = new Recruit(recruitTitle);

		// when
		// int result = recruitDao.save(recruitPS);

		// then
		// assertEquals(1, result);
	}

	@Test
	public void findByRecruitId_test() {
		// given
		Integer 글아이디 = 7;

		Recruit recruitPS = recruitDao.findById(글아이디);
		Company companyPS = companyDao.findById(recruitPS.getRecruitCompanyId());
		List<Category> categoryList = categoryDao.findByRecruitId(글아이디);
		recruitPS.setCategory(categoryList);
		recruitPS.setCompany(companyPS);

		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		String t = form.format(recruitPS.getRecruitCreatedAt());

		System.out.println("===========================");
		System.out.println(t);
		System.out.println("===========================");

		assertEquals(3, recruitPS.getCategory().size());
	}

	@Test
	public void 뭘테스트하는지모르겠다ㅅㅂ_test() {
		Integer recruitId = 7;

		Recruit recruitPS = recruitDao.findById(recruitId);
		Company companyPS = companyDao.findById(recruitPS.getRecruitCompanyId());
		List<Category> categoryList = categoryDao.findByRecruitId(recruitId);
		List<Recruit> recruitListByCompanyId = recruitDao.findByCompanyId(recruitPS.getRecruitCompanyId());
		recruitPS.setCategory(categoryList);
		recruitPS.setCompany(companyPS);
		recruitPS.setRecruitListByCompanyId(recruitListByCompanyId);

		for (int i = 0; i < recruitListByCompanyId.size(); i++) {
			System.out.println(recruitListByCompanyId.get(i).getRecruitStartDay());
		}

		System.out.println("=======================");
		System.out.println(recruitPS.getRecruitStartDay());
		System.out.println("=======================");

	}

}

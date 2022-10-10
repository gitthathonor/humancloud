package site.metacoding.humancloud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import site.metacoding.humancloud.config.MyBatisConfig;
import site.metacoding.humancloud.domain.category.CategoryDao;
import site.metacoding.humancloud.domain.recruit.Recruit;
import site.metacoding.humancloud.domain.recruit.RecruitDao;

@Import(MyBatisConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
class HumancloudApplicationTests {

	@Autowired
	private RecruitDao recruitDao;

	@Test
	public void save_test() {
		//given
		String recruitTitle = "타이틀 테스트";
		Recruit recruitPS = new Recruit(recruitTitle);

		//when
		int result = recruitDao.save(recruitPS);
		
		//then
		assertEquals(1, result);
	}

}

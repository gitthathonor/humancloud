package site.metacoding.humancloud.dao.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import site.metacoding.humancloud.config.MyBatisConfig;
import site.metacoding.humancloud.domain.user.User;
import site.metacoding.humancloud.domain.user.UserDao;
import site.metacoding.humancloud.web.dto.request.user.JoinDto;


@Import(MyBatisConfig.class) // MyBatisTest가 MyBatisConfig를 못읽음
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실DB사용
@MybatisTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findById_test() {
        // given (받아야 될 것)
        Integer productId = 1;

        // when (테스트)
        User userPS = userDao.findById(productId);

        // then (검증)
        assertEquals("ssar", userPS.getUsername());
    }

    @Test
    public void findAll_test() {
        // given

        // when
        List<User> userListPS = userDao.findAll();

        // then
        assertEquals(3, userListPS.size());
    }

    @Test
    public void save_test() {
        // given
        String username = "yu";
        String password = "123";
        String name= "yujin";
        String email = "yujin09@gmail.com";
        String phoneNumber = "01099966462";
        List<String> categoryList = new ArrayList<>();
        categoryList.add("데이터");
        categoryList.add("입니다");
        
        JoinDto joinDto = new JoinDto(username, password, username, email, phoneNumber, categoryList);

        // when
        int result = userDao.save(joinDto);

        // then
        assertEquals(1, result);
    } 

    @Test
    public void update_test() {
        // given
        Integer userId = 1;
        String username = "ssar2";
        String password = "123";
        String name= "구직자";
        String email = "aa@gmail.com";
        String phoneNumber = "01011112222";


        User userPS = userDao.findById(userId);
        userPS.UserUpdate(password, name, email, phoneNumber);
        

        int result=userDao.update(userPS);

        // then
        assertEquals(1, result);
    }

    @Test
    public void deleteById_test() {
        // given
        Integer userId = 3;

        // verify
        User userPS = userDao.findById(userId);
        

        // when
        int result = userDao.deleteById(userId);

        // then
        assertEquals(1, result);
    }
}
package site.metacoding.humancloud.domain.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.humancloud.web.dto.request.resume.user.JoinDto;

public interface UserDao {
	public int save(JoinDto joinDto);
	public User findById(Integer id);
	public List<User> findAll();
	public int update(@Param("id") Integer id,@Param("user") User user);
	public int deleteById(Integer id);

	public User findByUsername(String username);

}

package site.metacoding.humancloud.domain.apply;

import java.util.List;

import site.metacoding.humancloud.web.dto.request.apply.SaveDto;

public interface ApplyDao {
	public void save(SaveDto saveDto);

	public Apply findById(Integer id);

	public List<Apply> findAll();

	public void update(Apply apply);

	public void deleteById(Integer recruitId, Integer resumeId);
}

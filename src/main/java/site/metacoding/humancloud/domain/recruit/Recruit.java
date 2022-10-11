package site.metacoding.humancloud.domain.recruit;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.company.Company;

@NoArgsConstructor
@Getter
@Setter
public class Recruit {
	private Integer recruitId;
	private String recruitTitle;
	private String recruitCareer;
	private Integer recruitSalary;
	private String recruitLocation;
	private String recruitContent;
	private Integer recruitReadCount;
	private Integer recruitCompanyId;
	private Timestamp recruitCreatedAt;

	private List<String> recruitCategoryList;

	private Company company;
	private List<Category> category;

	public Recruit(String recruitTitle) {
		this.recruitTitle = recruitTitle;
	}

}

package site.metacoding.humancloud.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Category {
	private Integer categoryId;
	private Integer categoryResumeId;
	private Integer categoryRecruitId;
	private String categoryName;

	public Category(Integer categoryResumeId, String categoryName) {
		this.categoryResumeId = categoryResumeId;
		this.categoryName = categoryName;
	}
}

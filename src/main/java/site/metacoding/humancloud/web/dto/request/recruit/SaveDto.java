package site.metacoding.humancloud.web.dto.request.recruit;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveDto {
    private Integer recruitId;
    private String recruitTitle;
    private String recruitCareer;
    private Integer recruitSalary;
    private String recruitLocation;
    private Integer recruitReadCount;
    private String recruitContent;
    private Integer recruitCompanyId;

    private List<String> recruitCategoryList;
}

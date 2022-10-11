package site.metacoding.humancloud.web.dto.request.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveDto {
	private String boardTitle;
	private String boardContent;
}

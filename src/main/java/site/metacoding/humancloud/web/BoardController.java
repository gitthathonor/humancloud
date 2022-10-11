package site.metacoding.humancloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.service.BoardService;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/board")
	public String getBoardList() {
		return "page/board/boardList";
	}
	
	
}

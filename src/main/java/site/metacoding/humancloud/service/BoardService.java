package site.metacoding.humancloud.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.board.BoardDao;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardDao boardDao;
}

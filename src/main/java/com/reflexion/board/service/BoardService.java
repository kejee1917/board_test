package com.reflexion.board.service;

import java.util.List;

import com.reflexion.board.dto.BoardDto;
import com.reflexion.board.util.BoardPaging;

public interface BoardService {
	
	int countBoard(BoardPaging paging);
	
	List<BoardDto> getBoardList(BoardPaging paging);

	BoardDto getBoardDetail(BoardDto dto);

	int viewCount(BoardDto dto);
	
}

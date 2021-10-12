package com.reflexion.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reflexion.board.dao.BoardDao;
import com.reflexion.board.dto.BoardDto;
import com.reflexion.board.util.BoardPaging;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao dao;

	@Override
	public List<BoardDto> getBoardList(BoardPaging paging) {
		return dao.getBoardList(paging);
	}

	@Override
	public int countBoard(BoardPaging paging) {
		return dao.countBoard(paging);
	}

	@Override
	public BoardDto getBoardDetail(BoardDto dto) {
		return dao.getBoardDetail(dto);
	}

	@Override
	public int viewCount(BoardDto dto) {
		return dao.viewCount(dto);
	}


	
	
}

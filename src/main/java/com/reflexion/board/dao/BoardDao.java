package com.reflexion.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reflexion.board.dto.BoardDto;
import com.reflexion.board.util.BoardPaging;

@Repository
public class BoardDao{

	@Autowired
	SqlSessionTemplate session;
	
	
	//게시글의 총 개수
	public int countBoard(BoardPaging paging) {
		return session.selectOne("Board.countBoard", paging);
	}
	
	//페이지 처리 게시글 조회
	public List<BoardDto> getBoardList(BoardPaging paging) {
		return session.selectList("Board.getBoardList", paging);
	}
	
	//게시글 세부 내용
	public BoardDto getBoardDetail(BoardDto dto) {
		return session.selectOne("Board.getBoardDetail", dto);
	}

	//조회수 증가
	public int viewCount(BoardDto dto) {
		return session.update("Board.viewCount", dto);
	}
	

}

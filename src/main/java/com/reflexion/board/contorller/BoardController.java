package com.reflexion.board.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reflexion.board.dto.BoardDto;
import com.reflexion.board.service.BoardService;
import com.reflexion.board.util.BoardPageMaker;
import com.reflexion.board.util.BoardPaging;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	@RequestMapping("/boardList")
	public String getIntro(Model model, BoardPaging paging) {
		
		BoardPageMaker pageMaker = new BoardPageMaker();
		
		//현재페이지 번호, 페이지당 보여 줄 게시글 수
		pageMaker.setPag(paging); 
		
		//총 게시글 개수
		pageMaker.setTotalCount(service.countBoard(paging)); 
		
		List<BoardDto> list = service.getBoardList(paging);
		
		model.addAttribute("boardList", list);
		model.addAttribute("boardPageMaker", pageMaker);
		model.addAttribute("boardPaging", paging);
		
		return "boardList";
	}	
	
	
	@RequestMapping("/boardDetail")
	public String boardDetail(Model model, BoardDto dto, BoardPaging paging) {
		
		BoardDto boardDto = service.getBoardDetail(dto);
		
		//조회수 증가	
		service.viewCount(dto);	
		
		model.addAttribute("boardDto", boardDto);
		model.addAttribute("boardPaging", paging);
		
		return "boardDetail";
	}
	

}

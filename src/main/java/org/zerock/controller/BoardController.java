package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.command.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/service/")
public class BoardController {
	
	// BoardService 객체 연결
	// 1. (new 사용)
//	BoardService boardService = new BoardServiceImpl();
	
	// 2. (xml에 bean등록 처리)
	@Autowired
	private BoardService boardService;

	// 게시판 등록화면 처리
	@RequestMapping("/boardRegister")
	public String boardRegister() {
		
		
		return "service/boardRegister";
	}
	
	// 게시글 등록 요청 처리
	@RequestMapping(value = "/boardForm", method = RequestMethod.POST)
	public String boardForm(
			@RequestParam("name") String name,
			@RequestParam("title") String title,
			@RequestParam("content") String content
			) {
		//boardService 
		boardService.register(name, title, content);
		
		return "service/boardResult";
	}
	// 게시글 리스트 보기 요청 처리
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		List<BoardVO> DB = boardService.getList();
		// 전달 받은 DB를 boardList로 저장
		model.addAttribute("boardList", DB);
	
		return "service/boardList";
	}
	// 게시글 삭제 요청 처리
	@RequestMapping("/boardDelete")
	public String boardDelete(Model model,
			@RequestParam("num") String num) {
		boardService.delete(num);
		
		return "redirect:/service/boardList";
	}
	
	
	
	
	
}

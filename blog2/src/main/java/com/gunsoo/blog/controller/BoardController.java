package com.gunsoo.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gunsoo.blog.service.BoardService;


@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//메인페이지 
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.boardList(pageable));
		
		return "index";
	}
	
	//해당 글 insert
	@GetMapping("board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
	//글 상세보기 페이지 
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.detailBoard(id));
		return "board/detail";
	}
	
	
	
}













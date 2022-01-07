package com.gunsoo.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {

	//메인페이지 
	@GetMapping({"","/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
	
}

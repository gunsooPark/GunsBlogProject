package com.gunsoo.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	//회원가입 화면 
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	//로그인화면 
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
}

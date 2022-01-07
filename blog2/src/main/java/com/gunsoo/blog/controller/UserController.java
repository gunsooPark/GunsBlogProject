package com.gunsoo.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용 
//그냥 주소가 / 이면 idext.jsp 허용 
//static이하에 있는 /js/*, /css/*, /image/* 허용 

@Controller
public class UserController {

	//회원가입 화면 
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	//로그인화면 
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
}

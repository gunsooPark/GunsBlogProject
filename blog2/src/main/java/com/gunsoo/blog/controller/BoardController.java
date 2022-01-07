package com.gunsoo.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gunsoo.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {

	//메인페이지 
	@GetMapping({"","/"})
	public String index(@AuthenticationPrincipal PrincipalDetail principal) {
		System.out.println("로그인 사용자 아이디 : " + principal.getUsername());
		return "index";
	}
	
	
}

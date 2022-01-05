package com.gunsoo.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunsoo.blog.dto.ResponseDto;
import com.gunsoo.blog.model.RoleType;
import com.gunsoo.blog.model.User;
import com.gunsoo.blog.service.UserService;

@RestController
@RequestMapping("/api/*")
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	//회원가입 
	@PostMapping("/user")
	public ResponseEntity<Integer>  save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출 ");
		user.setRole(RoleType.USER); //권한부여 
		userService.save(user);
		
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	
	//정통적인 로그인
	@PostMapping("/user/login")
	public ResponseEntity<Integer> login(@RequestBody User user){
		System.out.println("UserApiController : login 호출 ");
		User principal = userService.login(user);
		if(principal != null) {
			session.setAttribute("principal", principal);
		}
		
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
		
	}
	
	
}








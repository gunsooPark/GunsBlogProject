package com.gunsoo.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunsoo.blog.dto.ResponseDto;
import com.gunsoo.blog.model.RoleType;
import com.gunsoo.blog.model.User;
import com.gunsoo.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	
	//회원가입 
	@PostMapping("/auth/joinProc")
	public ResponseEntity<Integer>  save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출 ");
		
		userService.save(user);
		
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	
	
	
}








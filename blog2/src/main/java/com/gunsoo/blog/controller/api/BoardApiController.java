package com.gunsoo.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunsoo.blog.config.auth.PrincipalDetail;
import com.gunsoo.blog.dto.ResponseDto;
import com.gunsoo.blog.model.Board;
import com.gunsoo.blog.model.RoleType;
import com.gunsoo.blog.model.User;
import com.gunsoo.blog.service.BoardService;
import com.gunsoo.blog.service.UserService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	
	//글쓰기 
	@PostMapping("/api/board")
	public ResponseEntity<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){
		boardService.save(board, principal.getUser());
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	
	
	
	
	
}








package com.gunsoo.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gunsoo.blog.model.Board;
import com.gunsoo.blog.model.RoleType;
import com.gunsoo.blog.model.User;
import com.gunsoo.blog.repository.BoardRepository;
import com.gunsoo.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록해준다. 
@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	//글쓰기 
	@Transactional
	public void save(Board board, User user) { //title, content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}

	//글목록 
	public List<Board> boardList() {
		return boardRepository.findAll();
	}
	
}

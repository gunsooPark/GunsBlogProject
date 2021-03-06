package com.gunsoo.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	@Transactional(readOnly = true)
	public Page<Board> boardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	//글상세보기
	@Transactional(readOnly = true)
	public Board detailBoard(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다. ");
				});
	}

	//삭제하기 
	@Transactional
	public void deleteBoard(int id) {
		 boardRepository.deleteById(id);
	}
	
	
	
}
















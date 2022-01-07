package com.gunsoo.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gunsoo.blog.model.User;
import com.gunsoo.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록해준다. 
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// 회원가입
	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}// end save


}

package com.gunsoo.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gunsoo.blog.model.RoleType;
import com.gunsoo.blog.model.User;
import com.gunsoo.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록해준다. 
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	// 회원가입
	@Transactional
	public void save(User user) {
		//암호화 전 비밀번호 
		String rawPassword = user.getPassword(); 
		//비밀번호 암호화
		String encPasword = encoder.encode(rawPassword);
		//암호화 
		user.setPassword(encPasword);
		//권한부여 
		user.setRole(RoleType.USER); 

		userRepository.save(user);
	}// end save


}

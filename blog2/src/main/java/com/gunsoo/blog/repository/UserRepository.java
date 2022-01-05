package com.gunsoo.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gunsoo.blog.model.User;

// DAO로 생각하면 된다.
// 자동으로 bean 등록이 된다.
//@Repository //생략가능하다.
public interface UserRepository extends JpaRepository<User, Integer> {// 해당 user테이블을 관리하는 JpaRepository이다. 주키는 Integer형이다.
	// JpaRepository -> 기본적인 crud는 되어있다.

	// JAP Naming 쿼리전략
	// 로그인 쿼리 -> SELECT * FROM user WHERE username = ? AND password =? 쿼리가 자동적으로 생성
	User findByUsernameAndPassword(String username, String password);

	// 이와 같이 사용할 수도 있음
//	@Query(value = "SELECT * FROM user WHERE username = ? AND password =?", nativeQuery = true)
//	User login(String username, String password);

}

package com.gunsoo.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//빈등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것 

@Configuration //빈등록 (ioc 관리)
@EnableWebSecurity //시큐리티 필터가 등록이 된다.  
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인즈을 미리 체크하겠다는 뜻  
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//비밀번호 암호화 
	@Bean //Ioc가 된다. -> 리턴하는 함수를 Spring이 관리한다. 
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() //csrf 토큰 비활성화 (테스트시 걸어두는게 좋음) 
			.authorizeRequests()
			.antMatchers("/auth/**", "/js/**", "/css/**", "/image/**", "/") //url이 /auth/는
			.permitAll() //모두 허용해주고
			.anyRequest() //그 외 나머지 url은
			.authenticated() //인증되어야된다.
		.and()
			.formLogin()
			.loginPage("/auth/loginForm"); //로그인 페이지를 지정
	}
	
	
}

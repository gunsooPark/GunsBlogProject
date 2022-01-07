package com.gunsoo.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//빈등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것 

@Configuration //빈등록 (ioc 관리)
@EnableWebSecurity //시큐리티 필터가 등록이 된다.  
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인즈을 미리 체크하겠다는 뜻  
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/auth/**") //url이 /auth/는
			.permitAll() //모두 허용해주고
			.anyRequest() //그 외 나머지 url은
			.authenticated() //인증되어야된다.
		.and()
			.formLogin()
			.loginPage("/auth/loginForm");
	}
	
	
}

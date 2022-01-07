package com.gunsoo.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gunsoo.blog.config.auth.PrincipalDetailService;

//빈등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것 

@Configuration //빈등록 (ioc 관리)
@EnableWebSecurity //시큐리티 필터가 등록이 된다.  
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인즈을 미리 체크하겠다는 뜻  
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	//비밀번호 암호화 
	@Bean //Ioc가 된다. -> 리턴하는 함수를 Spring이 관리한다. 
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	//시큐리티가 대신 로그인해주는데 password를 가로채기를 하는데 
	//해당 password가 뭘로 해시가 되어 회원가입이 되었는지 알아야 
	//같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음 . 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
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
			.loginPage("/auth/loginForm") //로그인 페이지를 지정
			.loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인해줌
			.defaultSuccessUrl("/");
	}
	
	
}

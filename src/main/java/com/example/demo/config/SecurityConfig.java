package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.security.MyUserDetailService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
		http
		.authorizeHttpRequests(authz -> authz 
			.requestMatchers("/login", "/css/**", "/js/**").permitAll()// 인증 없이 접근 허용
			.anyRequest().authenticated()// 나머지 요청은 인증 필요
		)//authorizeHttpRequests() : 어떤 URL이 인증 없이 접근 가능한지 지정
		.formLogin(form -> form
			.loginPage("/login")// 커스텀 로그인 페이지 경로
			.defaultSuccessUrl("/home", true)// 로그인 성공 시 이동 경로
			.permitAll()
		)//formLogin() : 로그인 페이지와 성공/실패 후 이동 경로 설정
		.logout(logout -> logout
			.logoutSuccessUrl("/login?logout")// 로그아웃 후 이동
			.permitAll()
		)//logout() : 로그아웃 처리 경로 설정
		.csrf();//csrf() : CSRF 보호 및 예외 지정 csrf 공격에 대비하기 위해 csrf 토큰을 화면에 주어 해당 토큰이 맞는지 확인하도록 한다.

		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();// 비밀번호 암호화용
	} // passwordEncoder(): 비밀번호 암호화 알고리즘 설정 (BCrypt 사용)
}


/*

1. 사용자가 /login 화면에서 username/password 입력

2. Spring Security가 내부적으로 AuthenticationManager를 호출

3. AuthenticationManager → UserDetailsService 구현체를 호출 (MyUserDetailService)

4. MyUserDetailService가 UserDetails 객체 반환

5. Spring Security가 입력한 비밀번호(password)와 암호화된 비밀번호(encoder.encode(...))를 비교

6. 성공 시 SecurityContextHolder에 인증 정보 저장 → defaultSuccessUrl("/home")로 이동

*/
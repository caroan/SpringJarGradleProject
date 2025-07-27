package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.home.HomeRepository;
import com.example.demo.vo.home.MbrInfo;

import lombok.RequiredArgsConstructor;

//@Service
//@RequiredArgsConstructor
public class MyUserDetailService {//implements UserDetailsService {
	
//	final private PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	HomeRepository homeRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//		
//		MbrInfo mbrInfo = new MbrInfo();
//		
//		mbrInfo.setUserId(userId);
//		
//		MbrInfo result = homeRepository.getMemberAllInfo(mbrInfo);
//		
//		if(result != null ) {
//			return User.builder().username(result.getUserId()).password(passwordEncoder.encode(result.getUserPassword())).roles("USER").build();
//		}
//		throw new UsernameNotFoundException("유저의 이름을 찾을 수 없습니다.");
//	}
}

// UserDetailManager가 있기 때문에 동일한 역활을 하는 UserDetailsService는 필요 없음.
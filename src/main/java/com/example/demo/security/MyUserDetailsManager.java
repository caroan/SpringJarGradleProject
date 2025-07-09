package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.home.HomeRepository;
import com.example.demo.vo.home.MbrInfo;
import com.example.demo.vo.security.MyUserDetails;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserDetailsManager implements UserDetailsManager {
	//솔직히 유저의 회원가입, 탈퇴, 수정, 비밀번호 재생성 등은 그냥 일반적인 컨트롤러를 사용한다.
	
	private final HomeRepository homeRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		MbrInfo mbrInfo = new MbrInfo();
		
		mbrInfo.setUserId(userId);
		
		MbrInfo result = homeRepository.getMemberAllInfo(mbrInfo);
		
		if(result != null) {
//			return User.withUsername(result.getUserId())
//					.password(result.getUserPassword())
//					.roles("USER")
//					.build();
			return new MyUserDetails(result);
		}
		throw new UsernameNotFoundException("유저의 이름을 찾을 수 없습니다.");
	}

	@Override
	public void createUser(UserDetails user) {
		MbrInfo param = new MbrInfo();
		param.setUserId(user.getUsername());
		param.setUserPassword(passwordEncoder.encode(user.getPassword()));
		param.setUserEmail( ((MyUserDetails)user).getUserEmail() );
		int cnt = homeRepository.insertMemberInfo(param);
	}

	@Override
	public void updateUser(UserDetails user) {
		MbrInfo param = new MbrInfo();
		param.setUserId(user.getUsername());
		param.setUserPassword(passwordEncoder.encode(user.getPassword()));
		param.setUserEmail( ((MyUserDetails)user).getUserEmail() );
		
		int cnt = homeRepository.updateMemberInfo(param);
		
		if(cnt < 1) {
			throw new UsernameNotFoundException("해당 사용자가 없습니다.");
		}
	}

	@Override
	public void deleteUser(String userId) {
		MbrInfo param = new MbrInfo();
		param.setUserId(userId);
		int cnt = homeRepository.deleteMemberInfo(param);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		
		MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
		
		MbrInfo param = userDetails.getMbr();
		param.setUserId(userId);
		
		MbrInfo mbrInfo = homeRepository.getMemberAllInfo(param);
		
		if(mbrInfo == null) {
			throw new UsernameNotFoundException("해당 사용자가 없습니다.");
		}
		
		if(!passwordEncoder.matches(oldPassword, mbrInfo.getUserPassword())) {
			throw new IllegalArgumentException("기존 비밀번호가 일치하지 않습니다.");
		}
		
		mbrInfo.setUserPassword(newPassword);
		
		int cnt = homeRepository.updateMemberInfo(mbrInfo);
	}

	@Override
	public boolean userExists(String userId) {
		MbrInfo param = new MbrInfo();
		param.setUserId(userId);
		MbrInfo result = homeRepository.getMemberAllInfo(param);
		
		return result != null ? true : false;
	}

}

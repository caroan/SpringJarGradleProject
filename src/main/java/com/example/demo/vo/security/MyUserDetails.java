package com.example.demo.vo.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.vo.home.MbrInfo;

import lombok.Data;

@Data
public class MyUserDetails implements UserDetails {
	
	private final MbrInfo mbr;
	
	public MyUserDetails(MbrInfo mbr) {
		this.mbr = mbr;
	}
	
	public MbrInfo getMbr() {
		return mbr;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(() -> "USER");
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return mbr.getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return mbr.getUserId();
	}
	
	public String getUserEmail() {
		return mbr.getUserEmail();
	}
	
	public String getUserRealName() {
		return mbr.getUserName();
	}

}

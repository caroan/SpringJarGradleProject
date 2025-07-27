package com.example.demo.controller.home;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.vo.home.MbrInfo;

@Controller
public class MemberController {
	
	@GetMapping("/createMember")
	public String getCreateMemberPage() {
		String modifyMemberPage = "/view/member/modify";
		return modifyMemberPage;
	}
	
	@PostMapping
	public Map<String, Object> createUser(MbrInfo mbrInfo){
		return null;
	}
}

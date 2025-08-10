package com.example.demo.controller.home;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.home.MbrInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestMemberController {
	@PostMapping("/registMember")
	public Map<String, Object> createUser(@RequestBody MbrInfo mbrInfo){
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("result", "success");
		
		return result;
	}
}

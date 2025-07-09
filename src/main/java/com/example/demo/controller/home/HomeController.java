package com.example.demo.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String getHome() {
		String home = "/view/home/home";
		System.out.println("home에 입장완료 : " + home);
		return home;
	}
	
	@GetMapping("/login")
	public String getLogin() {
		String login = "/view/login/login";
		System.out.println("카카오톡에 'caroan github 비빌번호' 이름으로 비밀번호 있으니 찾아볼 것");
		return login;
	}
}

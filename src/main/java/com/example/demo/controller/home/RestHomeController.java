package com.example.demo.controller.home;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.home.HomeService;
import com.example.demo.vo.common.ApiResponse;
import com.example.demo.vo.home.ApartInfo;
import com.example.demo.vo.home.MbrInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestHomeController {
	@Autowired
	HomeService homeSerivce;
	
	@PostMapping("/apartmentRealPriceAjax")
	public ApiResponse getApartRealPriceAjax(ApartInfo param){
		Map result = new HashMap<String, String>();
		
		try {
			Map<String, Object> myApart = homeSerivce.getApartmentDeals("", "", "");
			System.out.print(myApart.toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result.put("apartRealPrice", "9억원");
		
		return new ApiResponse<Map>().success(result);
	}
	
	@PostMapping("memberInfoAjax")
	public Map<String, String> getMemberInfoAjax(Map<String, String> param){
		
		Map result = new HashMap<String, String>();
		
		MbrInfo mbrInfo = new MbrInfo();
		mbrInfo.setUserId("first_person");
		
		result.put("memberInfo", homeSerivce.getMemberNameInfo(mbrInfo));
		
		return result;
	}
}
